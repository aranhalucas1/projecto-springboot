package com.estudando.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudando.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
