package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EmpModel") // give user specific table name
public class EmpModel {
	
	@Id  // required, marks column as primary key in table
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id", unique = true, nullable = false)
	// provides custom column name and conditions optional
	private int id;
	
	@Column(name = "emp_name")
	private String name;
	
	@Column(name = "emp_emailId")
	private String emailId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "CustomerDetails [id=" + id + ", name=" + name + ", emailId=" + emailId + "]";
	}
	

}

