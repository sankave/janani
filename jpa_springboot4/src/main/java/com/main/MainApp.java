package com.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.model.Country;
import com.main.repository.CountryRepository;

@SpringBootApplication
@ComponentScan(basePackages="com")
public class MainApp {
	@Autowired
	CountryRepository repo;
	public static void main(String[] args) 
    {
		
	 SpringApplication.run(MainApp.class, args); 
}
	
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
