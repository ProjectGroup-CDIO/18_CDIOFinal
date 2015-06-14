package opr.client.service;

import opr.shared.CoinDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ICoinServiceAsync {
	
	void getCoinInfo(double value, AsyncCallback<CoinDTO> callback);

}
