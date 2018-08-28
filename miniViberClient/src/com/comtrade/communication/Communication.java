package com.comtrade.communication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.comtrade.constant.Constant;
import com.comtrade.transfer.TransferClass;

public class Communication {
	private static Communication instance;
	private Socket socket;
	private String ip;
	private int port;
	

	private Communication() {
		readAdressIpPort();
		try {
//			socket = new Socket("127.0.0.1", 9000);
			socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Communication getInstance() {
		if (instance == null) {
			instance = new Communication();
		}
		return instance;
	}

	private void readAdressIpPort() {
		File f = new File(Constant.ADRESS_IP_PORT);
		Scanner sc = null;
		try {
			sc = new Scanner(f);
			String line = sc.nextLine();
			String array[] =  line.split(":");
			ip = array[0];
			port = Integer.valueOf(array[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
	
	public void sendData(TransferClass tc) {
		try {
			ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
			outStream.writeObject(tc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public TransferClass readData() {
		ObjectInputStream inStream = null;
		try {
			 inStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("Pukla je konekcija");
//			e.printStackTrace();
		}
		try {
			return (TransferClass) inStream.readObject();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return null;
	}
}
