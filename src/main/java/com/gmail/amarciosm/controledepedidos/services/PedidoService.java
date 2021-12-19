package com.gmail.amarciosm.controledepedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.amarciosm.controledepedidos.domain.Pedido;
import com.gmail.amarciosm.controledepedidos.exception.MyObjectNotFoundException;
import com.gmail.amarciosm.controledepedidos.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> listar(){
		List<Pedido> lista = pedidoRepository.findAll(); 	
		return lista;
	}
	
	public Pedido buscar(Integer id){
		Optional<Pedido> lista = pedidoRepository.findById(id);
		return lista.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado. id = " + id));
	}
	
}
