package com.example.ecommapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecommapp.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
