package com.example.cadastro_usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cadastro_usuario.model.Usuario_model;

@Repository
public interface Usuario_repository extends JpaRepository<Usuario_model, Long> {
    
}
