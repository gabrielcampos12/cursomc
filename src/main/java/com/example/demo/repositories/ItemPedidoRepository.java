package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.ItemPedido;
import com.example.demo.domain.ItemPedidoPK;
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK>{

}
