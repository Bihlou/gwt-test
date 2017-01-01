package com.ffbe.events.server;

import java.util.ArrayList;
import java.util.Date;

import com.ffbe.events.client.EventsService;
import com.ffbe.events.shared.Event;
import com.ffbe.events.shared.Group;
import com.ffbe.events.shared.Item;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class EventsServiceImpl extends RemoteServiceServlet implements EventsService {

	private static final long serialVersionUID = -6035958669604804795L;

	
	
	@Override
	public ArrayList<Item> getItems(int EventId) {
		
		Group g1 = new Group(0, "Group 1");
		Group g2 = new Group(1, "Group 2");
		
		Item i1 = new Item(0, "Item 1", null, 100, g2);
		Item i2 = new Item(0, "Item 2", 10, 200, g1);
		Item i3 = new Item(0, "Item 3", null, 300, g2);
		Item i4 = new Item(0, "Item 4", null, 400, g1);
		
		ArrayList<Item> listItem = new ArrayList<Item>();
		listItem.add(i1);
		listItem.add(i2);
		listItem.add(i3);
		listItem.add(i4);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listItem;
	}



	@Override
	public ArrayList<Event> getEvents() {
		
		Event event1 = new Event(0, "First event", new Date(), new Date());
		Event event2 = new Event(1, "Second event", new Date(), new Date());
		
		ArrayList<Event> listEvent = new ArrayList<Event>();
		listEvent.add(event1);
		listEvent.add(event2);
		
		return listEvent;
	}

}
