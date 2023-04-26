package com.devsuperior.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.userdept.entitiesDTO.Cliente;

public interface UserRepository extends JpaRepository<Cliente, Long> {

	
}



