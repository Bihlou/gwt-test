package com.ffbe.events.client.item.view;

import java.util.List;

import com.ffbe.events.client.common.ColumnDefinition;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.Widget;

public class ItemsViewImpl<T> extends Composite implements ItemsView<T> {

	@UiTemplate("ItemsView.ui.xml")
	interface ItemsViewUiBinder extends UiBinder<Widget, ItemsViewImpl> {
	}

	private static ItemsViewUiBinder uiBinder = GWT.create(ItemsViewUiBinder.class);

	@UiField
	FlexTable itemsTable;

	private Presenter<T> presenter;
	private List<ColumnDefinition<T>> columnDefinitions;
	// private List<T> rowData;

	public ItemsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		itemsTable.setStylePrimaryName("itemsTable");
		// setHeaderItemsTable();
	}

	/*
	 * public void setHeaderItemsTable() { itemsTable.setText(0, 0, "Name");
	 * itemsTable.setText(0, 1, "Limit"); itemsTable.setText(0, 2, "Price");
	 * itemsTable.setText(0, 3, "Quantity"); itemsTable.setText(0, 4, "Amount");
	 * }
	 */

	@UiHandler("itemsTable")
	void onTableClicked(ClickEvent event) {
		if (presenter != null) {
			EventTarget target = event.getNativeEvent().getEventTarget();

			Node node = Node.as(target);
			TableCellElement cella = findNearestParentCell(node);

			if (shouldFireClickEvent(cella)) {
				Cell cell = itemsTable.getCellForEvent(event);
				presenter.onGetLimitedItemsClicked(cell.getRowIndex(), cella.getInnerHTML());
			}
		}
	}

	@Override
	public void setPresenter(Presenter<T> presenter) {
		this.presenter = presenter;
	}

	public void setColumnDefinition(List<ColumnDefinition<T>> columnDefintion) {
		this.columnDefinitions = columnDefintion;
	}

	@Override
	public void setRowData(List<T> rowData) {
		// this.rowData = rowData;

		for (int i = 0; i < rowData.size(); ++i) {
			T t = rowData.get(i);

			for (int j = 0; j < columnDefinitions.size(); ++j) {
				StringBuilder sb = new StringBuilder();
				columnDefinitions.get(j).render(t, sb);
				itemsTable.setHTML(i + 1, j, sb.toString());

			}
		}
	}

	private TableCellElement findNearestParentCell(Node node) {
		while ((node != null)) {
			if (Element.is(node)) {
				Element elem = Element.as(node);

				String tagName = elem.getTagName();
				if ("td".equalsIgnoreCase(tagName) || "th".equalsIgnoreCase(tagName)) {
					return elem.cast();
				}
			}
			node = node.getParentNode();
		}
		return null;
	}

	private boolean shouldFireClickEvent(TableCellElement cell) {
		boolean shouldFireClickEvent = false;

		if (cell != null) {
			ColumnDefinition<T> columnDefinition = columnDefinitions.get(cell.getCellIndex());
			if (columnDefinition != null) {
				shouldFireClickEvent = columnDefinition.isClickable();
			}
		}

		return shouldFireClickEvent;
	}

	public void setColumnDefinitions(List<ColumnDefinition<T>> columnDefinitions) {
		this.columnDefinitions = columnDefinitions;
	}

	public Widget asWidget() {
		return this;
	}

}