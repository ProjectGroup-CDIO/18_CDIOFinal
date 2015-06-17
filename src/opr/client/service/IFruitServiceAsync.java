package opr.client.service;

import java.util.List;

import opr.shared.FruitDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IFruitServiceAsync {
	
	void getFruitInfo(String name, AsyncCallback<FruitDTO> callback);
	void getFruitList(AsyncCallback<List<FruitDTO>> callback);

}
