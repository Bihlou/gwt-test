package com.ffbe.events.client;

import com.ffbe.events.client.item.common.ItemsColumnDefinitionFactory;
import com.ffbe.events.client.item.presenter.ItemPresenter;
import com.ffbe.events.client.item.view.ItemsViewImpl;
import com.ffbe.events.shared.Item;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Ffbe implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		EventsServiceAsync rpcService = GWT.create(EventsService.class);
		//EventBus eventBus = new SimpleEventBus();
		EventBus eventBus = GWT.create(SimpleEventBus.class);
		ItemPresenter itemPresenter = new ItemPresenter(rpcService, eventBus,new ItemsViewImpl<Item>(), ItemsColumnDefinitionFactory.getItemsColumnDefinition(), 0);
		itemPresenter.go(RootPanel.get());
	
	}
}
