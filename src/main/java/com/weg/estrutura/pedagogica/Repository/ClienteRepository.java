package com.weg.estrutura.pedagogica.Repository;

import com.weg.estrutura.pedagogica.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}