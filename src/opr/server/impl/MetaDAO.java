package opr.server.impl;

import java.util.List;

import opr.client.service.IMetaService;
import opr.server.interfaces.IMetaDAO;
import opr.shared.DALException;

public class MetaDAO implements IMetaDAO, IMetaService {

	@Override
	public List<String> getTables() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
