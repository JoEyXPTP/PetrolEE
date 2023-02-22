package com.hostmdy.model;

import java.time.LocalDate;

public class Invoice {
	
	private Integer id;	
	private String username;
	private String email;
	private String petrol_type;
	private Double amount;
	private Double total_price;
	private LocalDate date;
	

	public Invoice(String username, String email, String petrol_type, Double amount, Double total_price,
			LocalDate date) {
		super();
		this.username = username;
		this.email = email;
		this.petrol_type = petrol_type;
		this.amount = amount;
		this.total_price = total_price;
		this.date = date;
	}

	public Invoice(Integer id, String username, String email, String petrol_type, Double amount, Double total_price,
			LocalDate date) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.petrol_type = petrol_type;
		this.amount = amount;
		this.total_price = total_price;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPetrol_type() {
		return petrol_type;
	}

	public void setPetrol_type(String petrol_type) {
		this.petrol_type = petrol_type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", username=" + username + ", email=" + email + ", petrol_type=" + petrol_type
				+ ", amount=" + amount + ", total_price=" + total_price + ", date=" + date + "]";
	}

}
