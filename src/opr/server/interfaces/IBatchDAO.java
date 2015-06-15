package opr.server.interfaces;

import java.util.List;

import opr.shared.BatchDTO;

public interface IBatchDAO {
	BatchDTO getBatch(int batchid) throws Exception;
	List<BatchDTO> getBatchList() throws Exception;
}
