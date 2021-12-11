package com.gmail.amarciosm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gmail.amarciosm.domain.Categoria;
import com.gmail.amarciosm.domain.Produto;
import com.gmail.amarciosm.repositories.CategoriaRepository;
import com.gmail.amarciosm.repositories.ProdutoRepository;

@SpringBootApplication
public class ControleDePedidosApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
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
		*/
	}

}
