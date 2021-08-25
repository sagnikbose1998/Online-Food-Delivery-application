package com.cg.fds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer>{

}
