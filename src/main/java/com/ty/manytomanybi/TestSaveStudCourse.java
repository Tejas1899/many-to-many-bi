package com.ty.manytomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudCourse {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Student student=new Student();
	student.setName("Ram");
	student.setAge(23);
	
	Student student1=new Student();
	student1.setName("Rao");
	student1.setAge(25);

	Student student2=new Student();
	student2.setName("Raj");
	student2.setAge(21);
	
	Course course1=new Course();
	course1.setName("Java");
	course1.setDuration("6 months");
	
	Course course2=new Course();
	course2.setName("Html");
	course2.setDuration("3 months");
	
	Course course3=new Course();
	course3.setName("CSS");
	course3.setDuration("9 months");
	
	List<Course> courses1=new ArrayList<Course>();
	courses1.add(course1);
	courses1.add(course2);
	courses1.add(course3);
	student.setCourses(courses1);
	
	List<Course> courses2=new ArrayList<Course>();
	courses2.add(course1);
	courses2.add(course3);
	student1.setCourses(courses2);
	
	List<Course> courses3=new ArrayList<Course>();
	courses3.add(course2);
	courses3.add(course3);
	student2.setCourses(courses3);
	
	List<Student> students=new ArrayList<Student>();
	students.add(student);
	students.add(student1);
	course1.setStudents(students);
	
	List<Student> students1=new ArrayList<Student>();
	students1.add(student);
	students1.add(student2);
	course2.setStudents(students1);
	
	List<Student> students2=new ArrayList<Student>();
	students2.add(student);
	students2.add(student1);
	students2.add(student2);
	course3.setStudents(students2);
	
	entityTransaction.begin();
	entityManager.persist(student);
	entityManager.persist(student1);
	entityManager.persist(student2);
	entityManager.persist(course1);
	entityManager.persist(course2);
	entityManager.persist(course3);
	entityTransaction.commit();
	
	
	
	
	
	
}

}
