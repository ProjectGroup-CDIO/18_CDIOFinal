package opr.client.service;

import java.util.List;

import opr.shared.DALException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("metaservice")
public interface IMetaService extends RemoteService {
	
	List<String> getTables() throws DALException;

}
