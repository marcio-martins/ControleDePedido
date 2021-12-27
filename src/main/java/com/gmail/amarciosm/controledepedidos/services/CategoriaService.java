package com.gmail.amarciosm.controledepedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gmail.amarciosm.controledepedidos.domain.Categoria;
import com.gmail.amarciosm.controledepedidos.dto.CategoriaDTO;
import com.gmail.amarciosm.controledepedidos.exception.MyObjectNotFoundException;
import com.gmail.amarciosm.controledepedidos.repositories.CategoriaRepository;

import net.bytebuddy.description.annotation.AnnotationValue.Sort;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Page<Categoria> findPage(Integer page, Integer linesForPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesForPage, Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}
	
	public List<Categoria> findAll() {
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

	public Categoria fromDTO(CategoriaDTO categoriaDTO) {
		return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
	}
}
