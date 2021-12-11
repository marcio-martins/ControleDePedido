package com.gmail.amarciosm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.amarciosm.domain.Categoria;
import com.gmail.amarciosm.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id){
		Optional<Categoria> lista = categoriaRepository.findById(id);
		return lista.orElse(null);
	}
}
