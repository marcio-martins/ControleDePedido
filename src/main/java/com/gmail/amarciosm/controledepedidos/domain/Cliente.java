package com.gmail.amarciosm.controledepedidos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gmail.amarciosm.controledepedidos.enuns.TipoCliente;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 8606279915076302498L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty
    @Column(length = 20)
    private String nome;
    
    @NotEmpty
    @Column(length = 20)
    private String email;
    
    @NotEmpty
    @Column(length = 20)
    private String cpfCnpj;
    
    private Integer tipoCliente;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();
    
    @ElementCollection
    @CollectionTable(name="telefones")
    private Set<String> telefones = new HashSet<>();
    
	public Cliente() {
		super();
	}
	
	public Cliente(Integer id, @NotEmpty String nome, @NotEmpty String email, @NotEmpty String cpfCnpj,
			Integer tipoCliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.tipoCliente = tipoCliente;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipoCliente);
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente.getCod();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return nome;
	}
    
}
