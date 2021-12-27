package com.gmail.amarciosm.controledepedidos.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.domain.Page;

import com.gmail.amarciosm.controledepedidos.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 8606279915076302498L;

	private Integer id;
    
	@NotEmpty(message = "Informe o nome da categoria")
    private String nome;
	
    public CategoriaDTO() {}

	public CategoriaDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
    
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static List<CategoriaDTO> gerarLista(List<Categoria> categorias) {
		return categorias.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
	}
    
	public static List<CategoriaDTO> gerarLista(Page<Categoria> categoriasPage) {
		return categoriasPage.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
	}
}
