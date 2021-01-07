package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cliente;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.services.exceptions.DateIntegrityException;
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
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj,obj);
		return repository.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DateIntegrityException("Não é possível excluir um Cliente que possui pedidos");
		}
	}
	public List<Cliente> findAll(){
		return repository.findAll();
	}

	public Page<Cliente> findPage(Integer page,Integer linesPerPage,String orderBy,String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		return repository.findAll(pageRequest);
	}
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(),objDto.getNome(),objDto.getEmail(),null,null);
	}
	private void updateData(Cliente newObj,Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	
}
