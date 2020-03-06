package br.com.docket.cartorio.service;

import br.com.docket.cartorio.dto.CartorioDTO;
import br.com.docket.cartorio.exception.CartorioNaoExisteException;
import br.com.docket.cartorio.model.Cartorio;
import br.com.docket.cartorio.repository.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartorioService {

    @Autowired
    private CartorioRepository cartorioRepository;

    public List<Cartorio> listar() throws Exception{
        try {
            return this.cartorioRepository.findAll();
        }catch (Exception e){
            throw  e;
        }
    }

    public Cartorio buscar(Long id) throws Exception{
        try {
            final Optional<Cartorio> optionalCartorio = this.cartorioRepository.findById(id);

            if (optionalCartorio.isPresent()) {
                return optionalCartorio.get();
            } else {
                throw new CartorioNaoExisteException("Cartorio não encontrado na base");
            }
        }catch (Exception e){
            throw e;
        }
    }

    public void alterar(Long id, CartorioDTO cartorioDTO) throws Exception {
        try {
            final Optional<Cartorio> cartorioOptional = this.cartorioRepository.findById(id);

            if ((cartorioOptional.isPresent())) {
                final Cartorio cartorio = cartorioOptional.get();
                cartorio.setNome(cartorioDTO.getNome());
                this.cartorioRepository.save(cartorio);
            } else {
                throw new CartorioNaoExisteException("Cartorio não existente");
            }

        }catch (Exception e){
            throw e;
        }
    }

    public  Cartorio criar(CartorioDTO cartorioDTO){
        try {
            return this.cartorioRepository.save(new Cartorio(cartorioDTO.getNome()));
        }catch (Exception e) {
            throw e;
        }
    }

    public  void  deletar(Long id) {
        try {
            this.cartorioRepository.deleteById(id);
        }catch (Exception e){
            throw e;
        }
    }
}
