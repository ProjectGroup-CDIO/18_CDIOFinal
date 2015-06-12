package opr.client.service;

import java.util.List;

import opr.shared.UnitDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IDBServiceAsync {
	
	void getCoin(double value, AsyncCallback<UnitDTO> callback); 
	void getTables(AsyncCallback<List<String>> callback);
}
