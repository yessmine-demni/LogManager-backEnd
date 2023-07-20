package com.vermeg.logmanager.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String lastName;
	private String password;
	
	@ManyToMany
	@JoinTable(name = "Log_User")
	private List<Machine> Machine;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Machine> getMachine() {
		return Machine;
	}
	public void setMachine(List<Machine> machine) {
		Machine = machine;
	}
	
}
