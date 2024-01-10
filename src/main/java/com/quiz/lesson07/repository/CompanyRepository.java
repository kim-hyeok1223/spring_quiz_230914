package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{

	// Spring data JPA
	
	// save(엔티티 객체);
	// Optional<앤티티객체> findById(id)
}
