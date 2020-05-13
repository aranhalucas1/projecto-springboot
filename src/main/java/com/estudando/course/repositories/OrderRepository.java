package com.estudando.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudando.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
