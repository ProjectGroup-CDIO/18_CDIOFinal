package opr.server.impl;

import java.util.List;

import opr.client.service.IMetaService;
import opr.server.interfaces.IMetaDAO;
import opr.shared.DALException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MetaDAO extends RemoteServiceServlet implements IMetaDAO, IMetaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5711854845648826350L;

	@Override
	public List<String> getTables() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
