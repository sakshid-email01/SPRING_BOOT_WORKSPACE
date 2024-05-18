package com.example.postgresql.crud.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity   // creates a table automatically in database
          // with same name as class name
@Table(name="CUSTOMER_DETAILS") // give user specific table name
public class Model {
	
	@Id  // required, marks column as primary key in table
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", unique = true, nullable = false)
	// provides custom column name and conditions optional
	private int id;
	
	@Column(name = "customer_name")
	private String name;
	
	@Column(name = "customer_emailId")
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
