package opr.client.service;

import java.util.List;

import opr.shared.BatchDTO;
import opr.shared.LogDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("batchservice")
public interface IBatchService extends RemoteService {
	BatchDTO getBatch(int batchid) throws Exception;
	List<BatchDTO> getBatchList() throws Exception;
	void updateLog(LogDTO logdto) throws Exception;
}
