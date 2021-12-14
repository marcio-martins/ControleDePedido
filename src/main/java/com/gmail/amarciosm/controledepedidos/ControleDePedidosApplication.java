package com.gmail.amarciosm.controledepedidos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gmail.amarciosm.controledepedidos.domain.Categoria;
import com.gmail.amarciosm.controledepedidos.domain.Cidade;
import com.gmail.amarciosm.controledepedidos.domain.Estado;
import com.gmail.amarciosm.controledepedidos.domain.Produto;
import com.gmail.amarciosm.controledepedidos.repositories.CategoriaRepository;
import com.gmail.amarciosm.controledepedidos.repositories.CidadeRepository;
import com.gmail.amarciosm.controledepedidos.repositories.EstadoRepository;
import com.gmail.amarciosm.controledepedidos.repositories.ProdutoRepository;

@SpringBootApplication
public class ControleDePedidosApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ControleDePedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",5000d);
		Produto p2 = new Produto(null,"Mesa",1000d);
		Produto p3 = new Produto(null,"Mouse",90d);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");
		
		Cidade cid1 = new Cidade(null, "Guarulhos");
		Cidade cid2 = new Cidade(null, "Uberlândia");
		Cidade cid3 = new Cidade(null, "Campinas");
		
		est1.getCidades().addAll(Arrays.asList(cid1,cid3));
		est2.getCidades().add(cid2);
		
		cid1.setEstado(est1);
		cid2.setEstado(est2);
		cid3.setEstado(est1);
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		*/
	}

}
