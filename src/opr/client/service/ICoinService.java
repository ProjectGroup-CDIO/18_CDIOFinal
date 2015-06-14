package opr.client.service;

import opr.shared.CoinDTO;
import opr.shared.DALException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("coinservice")
public interface ICoinService extends RemoteService {
	CoinDTO getCoinInfo(double value) throws DALException;
}
