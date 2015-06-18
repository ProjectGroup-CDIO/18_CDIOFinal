package opr.client.service;

import java.io.IOException;

import opr.shared.DALException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("aseservice")
public interface IASEService extends RemoteService{
	
	void setBrutto(double brutto);
	void connect() throws IOException;
	double getSWeight() throws IOException;
	double getSIWeight() throws IOException, DALException;
	void tara()throws Exception;
	void run() throws IOException, NumberFormatException;
	void changeSocket(String Ip, int port) throws IOException;
	

}
