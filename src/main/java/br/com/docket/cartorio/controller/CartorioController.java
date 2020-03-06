package br.com.docket.cartorio.controller;

import br.com.docket.cartorio.dto.CartorioDTO;
import br.com.docket.cartorio.exception.CartorioNaoExisteException;
import br.com.docket.cartorio.model.Cartorio;
import br.com.docket.cartorio.service.CartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartorios")
public class CartorioController {

    @Autowired
    private CartorioService cartorioService;

    @GetMapping
        public  ResponseEntity<List<Cartorio>> Listar() throws Exception{
        List<Cartorio> cartorios = this.cartorioService.listar();
        if (cartorios != null && !cartorios.isEmpty()){
            return new ResponseEntity<>(cartorios, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Cartorio> buscar(@PathVariable("id") Long id) throws Exception{
        try {
            Cartorio cartorio = this.cartorioService.buscar(id);
            return new ResponseEntity<>(cartorio, HttpStatus.OK);
        } catch (CartorioNaoExisteException ce) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> alterar (@PathVariable("id") Long id, @RequestBody CartorioDTO cartorioDTO){
        try {
            this.cartorioService.alterar(id, cartorioDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (CartorioNaoExisteException ce){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Cartorio> criar (@RequestBody CartorioDTO cartorioDTO){
        try {
            Cartorio cartorio = this.cartorioService.criar(cartorioDTO);
            return new ResponseEntity<>(cartorio, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> listarCartorios (@PathVariable("id") Long id){
        try {
            this.cartorioService.deletar(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
