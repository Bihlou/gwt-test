package com.ffbe.events.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;

public interface Presenter {

	public void bind();
	public abstract void go(final HasWidgets container);
	
}
