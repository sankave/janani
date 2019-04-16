package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.main.model.Country;
import com.main.repository.CountryRepository;

@RestController
public class ReferenceDataController {
@Autowired
CountryRepository repo;
@RequestMapping("/save")
public String saveCountry(Country country)
{country.setId(34);
country.setCode("xyz");
country.setName("xxx");
repo.save(country);
return "successfully saved";
}
	
@RequestMapping("/list")
public List<Country> List(Country country)
{
	List<Country> ls=(List<Country>) repo.findAll();
	return ls;
}


@RequestMapping("/findbyid/{id}")
public List<Country> findbyid(Country country, @PathVariable int id)
{
	List<Country> ls=(List<Country>) repo.findById(id);
	return ls;
}

@RequestMapping("/find/{id}")
public List<Country> find(Country country, @PathVariable int id)
{
	List<Country> ls=(List<Country>) repo.findByIdGreaterThan(id);
	return ls;
}

/*@RequestMapping("/findbycodeandname/{code}/{name}")
public List<Country> findcodeandname(@PathVariable("code")String code,@PathVariable("name")String name)
{
	List<Country> ls=(List<Country>) repo.findByCodeAndName(code,name);
	return ls;
}*/

@RequestMapping("/findbycodeandname")
public List<Country> findcodeandname(@RequestParam String code,@RequestParam String name)
{
	List<Country> ls=(List<Country>) repo.findByCodeAndName(code,name);
	return ls;
}


}
