package com.gmail.amarciosm.controledepedidos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 8606279915076302498L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty
    @Column(length = 20)
    private String nome;
    
    private Double preco;
	
    @ManyToMany
    @JsonBackReference
    @JoinTable(
    		name = "produto_categoria",
    		joinColumns = @JoinColumn(columnDefinition = "produto_id"),
    		inverseJoinColumns = @JoinColumn(columnDefinition = "categoria_id"))
    private List<Categoria> categorias = new ArrayList<>();

	public Produto() {
		super();
	}

	public Produto(Integer id, @NotEmpty String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return nome;
	}
    
}
