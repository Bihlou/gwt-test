package com.ffbe.events.client.common;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.PopupPanel;

public class WidgetFactory {

	//private final static Image defaultImage = new Image("path_to_ajax_wait_image");
	private final static String defaultText = "Loading...";
	
	
	public static PopupPanel createLoadingPopup(){
		PopupPanel loadingPanel = new PopupPanel();
		final Grid grid = new Grid(1, 2);
		//grid.setWidget(0, 0, defaultImage);
		grid.setText(0, 1, defaultText);
		loadingPanel.add(grid);
		
		return loadingPanel;
	}
}
