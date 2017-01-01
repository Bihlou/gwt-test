package com.ffbe.events.client.item.common;

import java.util.List;

import com.ffbe.events.client.common.ColumnDefinition;
import com.ffbe.events.shared.Item;

public class ItemsColumnDefinitionFactory<T> {
	
	public static List<ColumnDefinition<Item>> getItemsColumnDefinition(){
		return ItemsColumnDefinitionImpl.getInstance();
	}
	
}
