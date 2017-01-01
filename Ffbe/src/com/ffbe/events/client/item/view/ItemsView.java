package com.ffbe.events.client.item.view;

import java.util.List;

import com.ffbe.events.client.common.ColumnDefinition;
import com.google.gwt.user.client.ui.Widget;

public interface ItemsView<T> {

	public interface Presenter<T> {
		void onGetLimitedItemsClicked(int rowSelected, String rowContent);
	}
	
	void setPresenter(Presenter<T> presenter);
	void setColumnDefinitions(List<ColumnDefinition<T>> columnDefinitions);
	void setRowData(List<T> rowData);
	Widget asWidget();
}
