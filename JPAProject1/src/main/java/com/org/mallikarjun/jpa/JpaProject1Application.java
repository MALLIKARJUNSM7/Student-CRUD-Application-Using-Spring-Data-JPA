package com.org.mallikarjun.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.org.mallikarjun.jpa.entity.Student;
import com.org.mallikarjun.jpa.repository.StudentRepository;

@SpringBootApplication
public class JpaProject1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(JpaProject1Application.class, args);
		StudentRepository studentRepository = applicationContext.getBean(StudentRepository.class);

		/*
		 * //1. Storing students multiple objects Student student1 = new Student();
		 * student1.setName("Rahul");
		 * student1.setCity("Kalaburagi");
		 * student1.setAge(12);
		 * student1.setFeesStatus("Paid");
		 * 
		 //studentRepository.save(student1);
		 * 
		 * Student student2 = new Student();
		 * student2.setName("Kiran");
		 * student2.setCity("Mandya");
		 * student2.setAge(15);
		 * student2.setFeesStatus("Not-Paid");
		 * 
		 * 
		 * Student student3 = new Student();
		 * student3.setName("Manjunath");
		 * student3.setCity("Bengaluru");
		 * student3.setAge(16);
		 * student3.setFeesStatus("Paid");
		 * 
		 * Student student4 = new Student();
		 * student4.setName("Harsha");
		 * student4.setCity("Tumakuru");
		 * student4.setAge(13);
		 * student4.setFeesStatus("Div");
		 * 
		 * Student student5 = new Student();
		 * student5.setName("Ravi");
		 * student5.setCity("Bidar");
		 * student5.setAge(10);
		 * student5.setFeesStatus("Paid");
		 * 
		 * Student student6 = new Student();
		 * student6.setName("Pavitra");
		 * student6.setCity("Kolara");
		 * student6.setAge(14);
		 * student6.setFeesStatus("Paid");
		 * 
		 * Student student7 = new Student();
		 * student7.setName("Naveen");
		 * student7.setCity("Ballari");
		 * student7.setAge(15);
		 * student7.setFeesStatus("Paid");
		 * 
		 * Student student8 = new Student();
		 * student8.setName("Divvya");
		 * student8.setCity("Udupi"); 
		 * student8.setAge(12);
		 * student8.setFeesStatus("Paid");
		 * 
		 * List<Student> allStudents = Arrays.asList(student1, student2, student3,
		 * student4, student5, student6, student7, student8);
		 * 
		 * Iterable<Student> saveAll = studentRepository.saveAll(allStudents);
		 * System.out.println(saveAll);
		 */

		// Performing CRUD Operation on Student

		//1. Fetching studentById
		System.out.println("Fetching Student By Id");
		Optional<Student> byId =studentRepository.findById(10);
		System.out.println(byId);

		//2.findAllStudents 
		System.out.println("Find All Students");
		Iterable<Student> findAllStudents =studentRepository.findAll();
		System.out.println(findAllStudents);

		//3.Update Student By Id
		System.out.println("Update Student By Id");
		Optional<Student> updateStudentById =studentRepository.findById(1);
		Student updateStudent = updateStudentById.get();
		updateStudent.setName("Arjun");
		Student updatedStudent = studentRepository.save(updateStudent);
		System.out.println(updateStudent);

		/*
		 * Deleting Student By Id studentRepository.deleteById(8);
		 * System.out.println("Student Deleted");
		 */

		//Performing operation using custom finder methods
		
		System.out.println("Operation Using Custom Finder Methods");
		
		// fetching student by Name
		List<Student> byName = studentRepository.findByName("Manjunath");
		System.out.println(byName);
     
		// fetching student by NameAndCity
		List<Student> findByNameAndCity = studentRepository.findByNameAndCity("Kiran", "Mandya");
		System.out.println(findByNameAndCity);

	}

}
