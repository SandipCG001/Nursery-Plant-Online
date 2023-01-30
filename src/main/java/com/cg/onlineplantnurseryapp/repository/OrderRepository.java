package com.cg.onlineplantnurseryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnurseryapp.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, String>{

}
