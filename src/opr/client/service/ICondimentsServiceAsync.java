package opr.client.service;

import java.util.List;

import opr.shared.CondimentsDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ICondimentsServiceAsync {
	
	void getCondimentsInfo(String name, AsyncCallback<CondimentsDTO> callback);
	void getCondimentsList(AsyncCallback<List<CondimentsDTO>> callback);

}
