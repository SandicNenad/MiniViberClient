package com.comtrade.domain;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PrivateChatEntry {
	private int chatUserId;
	private String chatUserName;
	private int numberOfNewMessages;
	private String receivedMessageStatus;
	private String sentMessageStatus;
	private boolean isReceivedMessageSeen;
	private StringBuffer stringBuff = new StringBuffer();
	private ImageIcon image;
	
	public PrivateChatEntry(int chatUserId, String chatUserName) {
		numberOfNewMessages = 0;
		receivedMessageStatus ="";
		sentMessageStatus = "";
		isReceivedMessageSeen = true;
		this.chatUserId = chatUserId;
		this.chatUserName = chatUserName;
	}

	public ImageIcon getImage() {
		if (isReceivedMessageSeen) {
			Image myImage = new ImageIcon("icons/seenmsg48.png").getImage();
			image = new ImageIcon(myImage);
			return image;
		}
		Image myImage = new ImageIcon("icons/newmsg48.png").getImage();
		image = new ImageIcon(myImage);
		return image;

	}
	
	public int getChatUserId() {
		return chatUserId;
	}

	public void setChatUserId(int chatUserId) {
		this.chatUserId = chatUserId;
	}

	public String getChatUserName() {
		return chatUserName;
	}

	public void setChatUserName(String chatUserName) {
		this.chatUserName = chatUserName;
	}

	public int getNumberOfNewMessages() {
		return numberOfNewMessages;
	}

	public void setNumberOfNewMessages(int numberOfNewMessages) {
		this.numberOfNewMessages = numberOfNewMessages;
	}
	
	public void setNewMessage() {
		numberOfNewMessages++;
	}

	public String getReceivedMessageStatus() {
		return receivedMessageStatus;
	}

	public void setReceivedMessageStatus(String receivedMessageStatus) {
		this.receivedMessageStatus = receivedMessageStatus;
	}

	public String getSentMessageStatus() {
		return sentMessageStatus;
	}

	public void setSentMessageStatus(String sentMessageStatus) {
		this.sentMessageStatus = sentMessageStatus;
	}

	public boolean isReceivedMessageSeen() {
		return isReceivedMessageSeen;
	}

	public void setReceivedMessageSeen(boolean isReceivedMessageSeen) {
		this.isReceivedMessageSeen = isReceivedMessageSeen;
	}

	public StringBuffer getStringBuff() {
		return stringBuff;
	}

	public void setStringBuff(StringBuffer stringBuff) {
		this.stringBuff = stringBuff;
	}
	
	@Override
	public String toString() {
		if (numberOfNewMessages==0) {
		return chatUserName;
		}else {
			return chatUserName+" ("+numberOfNewMessages+")";
		}
	}
}
