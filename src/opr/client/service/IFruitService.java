package opr.client.service;

import java.util.List;

import opr.shared.FruitDTO;
import opr.shared.DALException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("fruitservice")
public interface IFruitService extends RemoteService {
	FruitDTO getFruitInfo(String name) throws DALException;
	List<FruitDTO> getFruitList() throws DALException;
}
