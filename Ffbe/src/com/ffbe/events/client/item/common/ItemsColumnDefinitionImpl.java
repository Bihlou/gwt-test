package com.ffbe.events.client.item.common;

import java.util.ArrayList;

import com.ffbe.events.client.common.ColumnDefinition;
import com.ffbe.events.shared.Item;

public class ItemsColumnDefinitionImpl extends ArrayList<ColumnDefinition<Item>> {

	private static final long serialVersionUID = -4682963894683258075L;
	
	private static final String DEFAULT_LIMIT = "-";

	private static ItemsColumnDefinitionImpl instance = null;

	public static ItemsColumnDefinitionImpl getInstance() {
		if (instance == null) {
			instance = new ItemsColumnDefinitionImpl();
		}
		return instance;
	}

	protected ItemsColumnDefinitionImpl() {

		this.add(new ColumnDefinition<Item>() {

			@Override
			public void render(Item i, StringBuilder sb) {
				sb.append("<div class='name'>" + i.getName() + "</div>");
			}

		});

		this.add(new ColumnDefinition<Item>() {

			@Override
			public void render(Item i, StringBuilder sb) {
				String limit = DEFAULT_LIMIT;
				if ( i.getLimit() != null ){
					limit = String.valueOf(i.getLimit());
				}
				sb.append("<div class='limit'>" + limit + "</div>");
			}

			public boolean isClickable() {
				return true;
			}

		});

		this.add(new ColumnDefinition<Item>() {

			@Override
			public void render(Item i, StringBuilder sb) {
				sb.append("<div class='price'>" + i.getPrice() + "</div>");
			}
			
		});

		this.add(new ColumnDefinition<Item>() {

			@Override
			public void render(Item i, StringBuilder sb) {
				sb.append("<input type ='text' class='quantity' />");
			}

		});

		this.add(new ColumnDefinition<Item>() {

			@Override
			public void render(Item i, StringBuilder sb) {
				String quantity = "";
				if ( i.getQuantity() != null ){
					quantity = String.valueOf(i.getQuantity());
				}
				sb.append("<input type ='text' class='amount' value='"+quantity+"' readonly='readonly'/>");
			}

		});
	}
}
