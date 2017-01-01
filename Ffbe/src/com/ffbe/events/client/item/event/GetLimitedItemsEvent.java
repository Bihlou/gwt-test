package com.ffbe.events.client.item.event;

import com.google.gwt.event.shared.GwtEvent;

public class GetLimitedItemsEvent extends GwtEvent<GetLimitedItemsEventHandler> {

	public static Type<GetLimitedItemsEventHandler> TYPE = new Type<GetLimitedItemsEventHandler>();

	private final String rowContent;
	private final int row;

	public GetLimitedItemsEvent(int row, String rowContent) {
		super();
		this.row = row;
		this.rowContent = rowContent;
	}

	public int getRow() {
		return row;
	}
	
	public String getRowContent() {
		return rowContent;
	}

	@Override
	public Type<GetLimitedItemsEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GetLimitedItemsEventHandler handler) {
		handler.onLimitedItemClick(this);
	}

}
