package com.ffbe.events.shared;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 487899335098751716L;

	private int id;
	private String name;
	private Integer limit;
	private int price;
	private Integer quantity;
	private Group group;
	
	public Item(){}
	
	public Item(int id, String name, Integer limit, int price, Group group) {
		super();
		this.id = id;
		this.name = name;
		this.limit = limit;
		this.price = price;
		this.group = group;
		this.quantity = null;
	}

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
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group){
		this.group = group;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
