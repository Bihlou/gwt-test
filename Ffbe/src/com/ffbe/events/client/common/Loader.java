package com.ffbe.events.client.common;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.PopupPanel;

public class Loader {

    private static final PopupPanel loadingIndicator = WidgetFactory.createLoadingPopup();
    private static final List<AsyncCallback<?>> callstack = new ArrayList<AsyncCallback<?>>();

    public static <T> AsyncCallback<T> call(final AsyncCallback<T> callback) {
        if(!loadingIndicator.isShowing()){
            loadingIndicator.center();
        }
        callstack.add(callback);
        return new AsyncCallback<T>() {
            @Override
            public void onFailure(Throwable caught) {
                handleReturn();
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(T result) {
                handleReturn();
                callback.onSuccess(result);
            }

            private void handleReturn(){
                callstack.remove(callback);
                if(callstack.size() < 1) {
                    loadingIndicator.hide();
                }
            }
        };
    }
}
