package com.org.mallikarjun.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.org.mallikarjun.jpa.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	// custom finder methods and implementation automatically provided by SprigBoot data JPA

	public List<Student> findByName(String name);

	public List<Student> findByNameAndCity(String name, String city);

}
