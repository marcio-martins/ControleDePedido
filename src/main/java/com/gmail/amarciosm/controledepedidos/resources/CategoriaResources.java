package com.gmail.amarciosm.controledepedidos.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gmail.amarciosm.controledepedidos.domain.Categoria;
import com.gmail.amarciosm.controledepedidos.dto.CategoriaDTO;
import com.gmail.amarciosm.controledepedidos.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	@Autowired
	private CategoriaService categoriaService;
	
	// /page&page=0&linesForPagelinesForPage=24 ...
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findPage(
			@RequestParam(name = "pageNumber", defaultValue = "0") Integer page, 
			@RequestParam(name = "linesForPage", defaultValue = "2") Integer linesForPage, // 24 é um bom número para projetos responsivos, pois é divisivel por 1,2,3,4,6... 
			@RequestParam(name = "direction", defaultValue = "ASC") String direction, // ASC OU DESC
			@RequestParam(name = "orderBy", defaultValue = "nome") String orderBy) {
		Page<Categoria> categoriasPage = categoriaService.findPage(page, linesForPage, direction, orderBy);
		List<CategoriaDTO> lista = CategoriaDTO.gerarLista(categoriasPage);
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> lista = CategoriaDTO.gerarLista(categoriaService.findAll());
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> listar(@PathVariable Integer id) {
		Categoria categoria = categoriaService.find(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO categoriaDTO) {
		Categoria categoria = categoriaService.fromDTO(categoriaDTO);
		categoriaService.insert(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Integer id) {
		categoriaService.update(categoria);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> update(@PathVariable Integer id) {
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
