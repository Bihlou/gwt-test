package com.ffbe.events.client;

import java.util.ArrayList;

import com.ffbe.events.shared.Event;
import com.ffbe.events.shared.Item;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("eventsService")
public interface EventsService extends RemoteService{

	public ArrayList<Event> getEvents();
	
	public ArrayList<Item> getItems(int EventId);
	
}
