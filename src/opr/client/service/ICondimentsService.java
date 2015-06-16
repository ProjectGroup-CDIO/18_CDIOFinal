package opr.client.service;

import java.util.List;

import opr.shared.CondimentsDTO;
import opr.shared.DALException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("condimentsservice")
public interface ICondimentsService extends RemoteService {
	CondimentsDTO getCondimentsInfo(String name) throws DALException;
	List<CondimentsDTO> getCondimentsList() throws DALException;
}
