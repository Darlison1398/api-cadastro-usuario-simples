package com.example.cadastro_usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro_usuario.model.Usuario_model;
import com.example.cadastro_usuario.repository.Usuario_repository;

@RestController
@RequestMapping("/usuario")
public class Usuario_controller {

    @Autowired
    private Usuario_repository usuario_repository;

    @GetMapping("/teste")
    public String test() {
        return "SEU TESTE DEU CERTO, E SUA API JÁ ESTÁ FUNCIONANDO";
    }

    @PostMapping("/saveUser")
    public Usuario_model saveUser(@RequestBody Usuario_model usuario) {
        try {
            return usuario_repository.save(usuario);
        } catch (Exception e) {
            System.out.println("Erro ao salvar usuario: " + e.getMessage());
            return null;
        }
    }

    @GetMapping("/userById/{id}")
    public Usuario_model getUserById(@PathVariable Long id) {
        return usuario_repository.findById(id).orElse(null);
    }

    @GetMapping("/allUsers")
    public List<Usuario_model> getAllUsers() {
        return usuario_repository.findAll();
    }

    @PutMapping("/updateUsuario/{id}")
    public Usuario_model updateUsuario(@RequestBody Usuario_model user, @PathVariable Long id) {
        Usuario_model usuario = usuario_repository.findById(id).orElse(null);
        if (usuario!= null) {
            usuario.setNome(user.getNome());
            usuario.setIdade(user.getIdade());
            return usuario_repository.save(usuario);
        } else {
            System.out.println("Usuario não encontrado");
            return null;
        }
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        try {
            usuario_repository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar usuario: " + e.getMessage());
        }
    }
    
}
