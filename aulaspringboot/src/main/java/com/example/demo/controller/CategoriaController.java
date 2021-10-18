package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Categoria;
import com.example.demo.repository.ICategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	ICategoriaRepository categoriaRepo;

	@GetMapping()
	public List<Categoria> getAll() {
		return this.categoriaRepo.findAll();
	}
	
//	@GetMapping("/categoria/{id}")
//	public Categoria get(Integer id) {
//		return (Categoria)this.categoriaRepo.findById(id);
//	}

//	@PutMapping()
//	public String put(@RequestBody Categoria categoria) {
//		return "O teste de Categoria funcionou!!!";
//	}
//
//	@PostMapping()
//	public Categoria post(@RequestBody Categoria categoria) {
//		return this.categoriaRepo.save(categoria);
//	}
//
//	@DeleteMapping("/categoria/{id}")
//	public String delete(Integer id) {
//		return "O teste de Categoria funcionou!!!";
//	}
}
