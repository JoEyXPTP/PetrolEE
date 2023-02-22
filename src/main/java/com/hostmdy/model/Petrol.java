package com.hostmdy.model;

public class Petrol {
	
	private Integer id;
	private String petrol_type;
	private Double quantity;
	private Double unit_price;
	private Boolean instock;
	
	public Petrol(String petrol_type, Double quantity, Double unit_price, Boolean instock) {
		super();
		this.petrol_type = petrol_type;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.instock = instock;
	}

	public Petrol(Integer id, String petrol_type, Double quantity, Double unit_price, Boolean instock) {
		super();
		this.id = id;
		this.petrol_type = petrol_type;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.instock = instock;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}

	public Boolean getInstock() {
		return instock;
	}

	public void setInstock(Boolean instock) {
		this.instock = instock;
	}

	@Override
	public String toString() {
		return "Petrol [id=" + id + ", petrol_type=" + petrol_type + ", quantity=" + quantity + ", unit_price="
				+ unit_price + ", instock=" + instock + "]";
	}
	
}
