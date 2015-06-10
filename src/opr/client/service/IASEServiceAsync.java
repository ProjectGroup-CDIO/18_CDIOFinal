package opr.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IASEServiceAsync {
	
	void setWeightDisplay(String msg, AsyncCallback<Void> callback);
	void setupConnect(AsyncCallback<Void> callback);
	void getSWeight(AsyncCallback<Integer> callback);
	void getSIWeight(AsyncCallback<Integer> callback);
	void tara(AsyncCallback<Void> callback);

}
