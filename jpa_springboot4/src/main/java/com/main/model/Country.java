package com.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {
	@Id
private int id;
private String code;
private String name;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Country() {
	super();
	
}
public Country(String code, String name) {
	super();
	this.code = code;
	this.name = name;
}

}
