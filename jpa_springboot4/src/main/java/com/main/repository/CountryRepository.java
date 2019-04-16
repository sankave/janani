package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.main.model.Country;

public interface CountryRepository extends CrudRepository<Country, Integer>{

	Country findById(int id);

	List<Country> findByIdGreaterThan(int id);
	
	
	/* @Query(value="Select t From Country t Where t.code=?1 And t.name=?2")
		List<Country> findByCodeAndName()String code, String name);*/
	 
	 
   @Query(value="Select t From Country t Where t.code = :code And t.name = :name")
	List<Country> findByCodeAndName(@Param("code")String code, @Param("name") String name);



}
