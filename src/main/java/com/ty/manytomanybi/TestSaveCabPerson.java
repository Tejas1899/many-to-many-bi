package com.ty.manytomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveCabPerson {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Person person1=new Person();
	person1.setName("tej");
	person1.setAge(23);
	
	Person person2=new Person();
	person2.setName("Chim");
	person2.setAge(25);
	
	Person person3=new Person();
	person3.setName("ram");
	person3.setAge(30);
	
	Cab cab1=new Cab();
	cab1.setDriver_name("Kumara");
	cab1.setCost(50);
	
	Cab cab2=new Cab();
	cab2.setDriver_name("Ramesha");
	cab2.setCost(500);
	
	Cab cab3=new Cab();
	cab3.setDriver_name("Shashank");
	cab3.setCost(100);
	
	List<Cab> cabs1=new ArrayList<Cab>();
	cabs1.add(cab1);
	cabs1.add(cab2);
	person1.setCabs(cabs1);
	
	List<Cab> cabs2=new ArrayList<Cab>();
	cabs2.add(cab1);
	cabs2.add(cab3);
	person2.setCabs(cabs2);
	
	List<Cab> cabs3=new ArrayList<Cab>();
	cabs3.add(cab2);
	cabs3.add(cab3);
	person3.setCabs(cabs1);
	
	List<Person> persons1=new ArrayList<Person>();
	persons1.add(person1);
	persons1.add(person2);
	cab1.setPersons(persons1);
	
	List<Person> persons2=new ArrayList<Person>();
	persons2.add(person1);
	persons2.add(person3);
	cab1.setPersons(persons2);

	List<Person> persons3=new ArrayList<Person>();
	persons3.add(person2);
	persons3.add(person3);
	cab1.setPersons(persons3);
	
	entityTransaction.begin();
	entityManager.persist(person1);
	entityManager.persist(person2);
	entityManager.persist(person3);
	entityManager.persist(cab1);
	entityManager.persist(cab2);
	entityManager.persist(cab3);
	entityTransaction.commit();
	
	


}
}
