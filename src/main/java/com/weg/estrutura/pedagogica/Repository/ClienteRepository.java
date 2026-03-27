package com.weg.estrutura.pedagogica.Repository;

import com.weg.estrutura.pedagogica.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);

    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
