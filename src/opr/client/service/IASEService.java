package opr.client.service;

import java.io.IOException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("aseservice")
public interface IASEService extends RemoteService{
	
	void setWeightDisplay(String msg);
	void connect() throws IOException;
	double getSWeight() throws IOException;
	double getSIWeight() throws IOException;
	void tara()throws Exception;
	void run() throws IOException, NumberFormatException;

}
