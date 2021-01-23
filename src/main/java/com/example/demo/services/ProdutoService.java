package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository repository;
	@Autowired
	CategoriaRepository categoriaRepository;
	public Produto buscar(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome,List<Integer> ids,Integer page,Integer linesPerPage,String orderBy,String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repository.search(nome,categorias,pageRequest);
	}
}
