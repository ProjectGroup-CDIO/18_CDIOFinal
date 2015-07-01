package opr.server.interfaces;

import java.io.IOException;
import java.net.UnknownHostException;

import opr.shared.DALException;

public interface IASE {
	
	void connect() throws UnknownHostException, IOException;
	double getSWeight() throws IOException;
	double getSIWeight() throws IOException, DALException;
	void tara() throws Exception;
	
}
