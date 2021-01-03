package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cliente;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository repository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(()-> new  ObjectNotFoundException(
				"Objeto não encontrado!  Id: "+id+ ", Tipo: "+Cliente.class.getName()));
	}
	
	
}
