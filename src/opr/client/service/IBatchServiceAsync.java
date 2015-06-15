package opr.client.service;

import java.util.List;

import opr.shared.BatchDTO;
import opr.shared.LogDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IBatchServiceAsync {
	void getBatch(int batchid, AsyncCallback<BatchDTO> callback);
	void getBatchList(AsyncCallback<List<BatchDTO>> callback);
	void updateLog(LogDTO logdto, AsyncCallback<Void> callback);
}
