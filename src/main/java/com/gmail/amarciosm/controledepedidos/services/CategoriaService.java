package com.gmail.amarciosm.controledepedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.amarciosm.controledepedidos.domain.Categoria;
import com.gmail.amarciosm.controledepedidos.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listar(){
		List<Categoria> lista = categoriaRepository.findAll();
		return lista;
	}
	
	public Categoria buscar(Integer id){
		Optional<Categoria> lista = categoriaRepository.findById(id);
		return lista.orElse(null);
	}
	
}
