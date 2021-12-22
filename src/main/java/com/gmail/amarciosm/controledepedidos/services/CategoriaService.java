package com.gmail.amarciosm.controledepedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gmail.amarciosm.controledepedidos.domain.Categoria;
import com.gmail.amarciosm.controledepedidos.exception.MyObjectNotFoundException;
import com.gmail.amarciosm.controledepedidos.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> list(){
		List<Categoria> lista = categoriaRepository.findAll(); 	
		return lista;
	}
	
	public Categoria find(Integer id){
		Optional<Categoria> lista = categoriaRepository.findById(id);
		return lista.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado. id = " + id));
	}
	
	public Categoria insert(Categoria categoria){
		return categoriaRepository.save(categoria);
	}

	public Categoria update(Categoria categoria) {
		find(categoria.getId());
		return categoriaRepository.save(categoria);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new MyObjectNotFoundException("Não é possível excluir categorias que têm produtos relacionados!");
		}
	}
}
