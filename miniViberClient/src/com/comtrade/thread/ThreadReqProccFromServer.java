package com.comtrade.thread;

import com.comtrade.communication.Communication;
import com.comtrade.controllerclient.ControllerClient;
import com.comtrade.transfer.TransferClass;

public class ThreadReqProccFromServer extends Thread{
	
	public void run() {
		while (true) {
			TransferClass tc = new TransferClass();
			try {
				tc = Communication.getInstance().readData();
				tc.getClientObject();
				ControllerClient.getInstance().processServerRequirements(tc);
				
			} catch (Exception e) {
				System.out.println("Nema konekcije sa serverom");
//				e.printStackTrace();
				break;
			}
		}
	}
}
