package com.udemy.backendninja.model;

public class CourseModel {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private int price;
	
	private int hours;
	
	
	public CourseModel() {
		super();
	}

	public CourseModel(Integer id, String name, String description, int price, int hours) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "CourseModel [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", hours="
				+ hours + "]";
	}
	
	

}
