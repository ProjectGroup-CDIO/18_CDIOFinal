package opr.server.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

import opr.client.service.IASEService;
import opr.server.Connector;
import opr.server.interfaces.IASE;

public class ASE implements IASE, IASEService {
	
	private Socket sock;
	private BufferedReader in;
	private DataOutputStream out;
	
	public ASE() {
		try {
			new Connector();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void connect() throws UnknownHostException, IOException {
		sock = new Socket("62.79.16.17", 8000);
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new DataOutputStream(sock.getOutputStream());
		
	}

	@Override
	public void setWeightDisplay(String msg) {
		
		
	}

	@Override
	public int getSWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSIWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void tara() {
		// TODO Auto-generated method stub
		
	}

}
