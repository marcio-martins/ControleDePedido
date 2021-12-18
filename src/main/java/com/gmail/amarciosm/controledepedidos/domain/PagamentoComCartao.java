package com.gmail.amarciosm.controledepedidos.domain;

import javax.persistence.Entity;

import com.gmail.amarciosm.controledepedidos.enuns.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	private Integer numParcelas;

	public PagamentoComCartao() {
		super();
	}

	public PagamentoComCartao(Integer id, Integer estadoPagamento, Pedido pedido, Integer numParcelas) {
		super(id, estadoPagamento, pedido);
		this.numParcelas = numParcelas;
	}

	public Integer getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(Integer numParcelas) {
		this.numParcelas = numParcelas;
	}
	
	
	
}
