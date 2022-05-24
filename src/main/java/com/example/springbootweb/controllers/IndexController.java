package com.example.springbootweb.controllers;

import com.example.springbootweb.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "/home" , ""})
    public String index(Model model) {
        model.addAttribute("titulo","Titulo desde el controlador");
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Taveira");
        usuario.setEmail("juantaveira10@gmail.com");
        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo","Perfil de " + usuario.getNombre() + " " + usuario.getApellido());

        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        
        model.addAttribute("titulo","Lista de usuarios");

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Juan","Taveira","juan@juan.com") ,
                new Usuario("Leo","Messi","messi@messi.com") ,
                new Usuario("Felipe","Taveira","felipe@felipe.com") ,
                new Usuario("Sergio","Aguero","kun@kun.com")
        );

        return usuarios;
    }
}
