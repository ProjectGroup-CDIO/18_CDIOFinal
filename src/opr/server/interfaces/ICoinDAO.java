package opr.server.interfaces;

import java.util.List;

import opr.shared.CoinDTO;
import opr.shared.DALException;

public interface ICoinDAO {
	CoinDTO getCoinInfo(double value) throws DALException;
	List<CoinDTO> getCoinList() throws DALException;
}
