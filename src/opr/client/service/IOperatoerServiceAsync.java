package opr.client.service;

import java.util.List;

import opr.shared.OperatoerDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IOperatoerServiceAsync {
	
	void loginVerify(int oprId, String pass, AsyncCallback<OperatoerDTO> callback);
	void updateOperatoer(OperatoerDTO p, AsyncCallback<Void> callback)throws Exception;
	void deleteOperatoer(OperatoerDTO p, AsyncCallback<Void> callback)throws Exception;
	void createOperatoer(OperatoerDTO p, AsyncCallback<Void> callback)throws Exception;
	void getOperatoerList(AsyncCallback<List<OperatoerDTO>> callback) throws Exception;
	void getOperatoer(int oprID, AsyncCallback<OperatoerDTO> callback) throws Exception;

}
