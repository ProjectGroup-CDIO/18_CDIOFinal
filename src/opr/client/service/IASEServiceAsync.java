package opr.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IASEServiceAsync {
	
	void setWeightDisplay(String msg, AsyncCallback<Void> callback);
	void connect(AsyncCallback<Void> callback);
	void getSWeight(AsyncCallback<Double> callback);
	void getSIWeight(AsyncCallback<Double> callback);
	void tara(AsyncCallback<Void> callback);
	void start(AsyncCallback<Void> callback);

}
