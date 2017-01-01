package com.ffbe.events.client.item.presenter;

import java.util.ArrayList;
import java.util.List;

import com.ffbe.events.client.EventsServiceAsync;
import com.ffbe.events.client.common.ColumnDefinition;
import com.ffbe.events.client.common.Loader;
import com.ffbe.events.client.item.event.GetLimitedItemsEvent;
import com.ffbe.events.client.item.event.GetLimitedItemsEventHandler;
import com.ffbe.events.client.item.view.ItemsView;
import com.ffbe.events.client.presenter.Presenter;
import com.ffbe.events.shared.Item;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ItemPresenter implements Presenter, ItemsView.Presenter<Item> {

	private List<Item> listItem;
	private int eventId;

	public interface Display {
		void setData(List<Item> data);
		Widget asWidget();
	}

	private final EventsServiceAsync rpcService;
	private final EventBus eventBus;
	private final ItemsView<Item> view;

	public ItemPresenter(EventsServiceAsync rpcService, EventBus eventBus, ItemsView<Item> view,
			List<ColumnDefinition<Item>> columnDefinitions, int eventId) {
		this.rpcService = rpcService;
		this.view = view;
		this.view.setColumnDefinitions(columnDefinitions);
		this.eventId = eventId;
		this.eventBus = eventBus;
		bind();
		fetchItems();
	}

	@Override
	public void bind() {
		this.view.setPresenter(this);

		eventBus.addHandler(GetLimitedItemsEvent.TYPE, new GetLimitedItemsEventHandler() {

			@Override
			public void onLimitedItemClick(GetLimitedItemsEvent event) {
				int tableRow = event.getRow() - 1;
				Integer limit = listItem.get(tableRow).getLimit();
				if (limit != null) {
					listItem.get(tableRow).setQuantity(limit);
					view.setRowData(listItem);
				}
			}
		});
	}

	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(view.asWidget());
		fetchItems();
	}

	private void fetchItems() {

		rpcService.getItems(this.eventId, Loader.call( new AsyncCallback<ArrayList<Item>>() {
			public void onSuccess(ArrayList<Item> result) {
				view.setRowData(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}
		}));

	}

	@Override
	public void onGetLimitedItemsClicked(int rowSelected, String rowContent) {
		eventBus.fireEvent(new GetLimitedItemsEvent(rowSelected, rowContent));
	}

}
