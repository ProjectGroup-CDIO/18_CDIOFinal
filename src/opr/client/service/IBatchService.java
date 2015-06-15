package opr.client.service;

import java.util.List;

import opr.shared.BatchDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("batchservice")
public interface IBatchService extends RemoteService {
	BatchDTO getBatch(int batchid) throws Exception;
	List<BatchDTO> getBatchList() throws Exception;
}
