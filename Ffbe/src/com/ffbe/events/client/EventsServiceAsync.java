package com.ffbe.events.client;

import java.util.ArrayList;

import com.ffbe.events.shared.Event;
import com.ffbe.events.shared.Item;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EventsServiceAsync {

	void getItems(int EventId, AsyncCallback<ArrayList<Item>> listItem);

	void getEvents(AsyncCallback<ArrayList<Event>> callback);

}
