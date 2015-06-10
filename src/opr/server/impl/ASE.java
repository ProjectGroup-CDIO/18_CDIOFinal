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

public class ASE extends Thread implements IASE, IASEService {
	
	private Socket sock;
	private BufferedReader in;
	private DataOutputStream out;
	private int brutto;
	private int tara;
	private int netto = (brutto - tara);
	
	public ASE() {
		
	}
	
//	public ASE() {
//		try {
//			new Connector();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void connect() throws UnknownHostException, IOException {
		
		if(sock!=null) return;
		
		sock = new Socket("62.79.16.17", 8000);
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new DataOutputStream(sock.getOutputStream());
		
	}

	@Override
	public void setWeightDisplay(String msg) {
		//løl
		
	}

	@Override
	public double getSWeight() throws IOException {
		out.writeBytes("S");
		String response = in.readLine();
		double weight = Double.parseDouble(response.substring(3,response.length()-2).trim());
		return weight;
	}

	@Override
	public double getSIWeight() throws IOException {
		out.writeBytes("SI");
		String response = in.readLine();
		double weight = Double.parseDouble(response.substring(3,response.length()-2).trim());
		return weight;
		
	}

	@Override
	public void tara() {
		tara = brutto;	
	}
	
	public void run() {
		// TODO
	}

}
