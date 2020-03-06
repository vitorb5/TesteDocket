package br.com.docket.cartorio.repository;

import br.com.docket.cartorio.model.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartorioRepository extends JpaRepository<Cartorio, Long> {
}