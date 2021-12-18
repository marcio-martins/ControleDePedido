package com.gmail.amarciosm.controledepedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.amarciosm.controledepedidos.domain.Cliente;
import com.gmail.amarciosm.controledepedidos.exception.MyObjectNotFoundException;
import com.gmail.amarciosm.controledepedidos.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository categoriaRepository;
	
	public List<Cliente> listar(){
		List<Cliente> lista = categoriaRepository.findAll(); 	
		return lista;
	}
	
	public Cliente buscar(Integer id){
		Optional<Cliente> lista = categoriaRepository.findById(id);
		return lista.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado. id = " + id));
	}
	
}
