package com.comtrade.domain;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GroupChatEntry {
	private String groupName;
	private int numberOfNewMessages;
	private boolean isReceivedMsgSeen;
	private StringBuffer stringBuff;
	private ImageIcon image;

	public GroupChatEntry(String groupName) {
		super();
		this.groupName = groupName;
		this.numberOfNewMessages = 0;
		this.isReceivedMsgSeen = true;
		this.stringBuff = new StringBuffer();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getNumberOfNewMessages() {
		return numberOfNewMessages;
	}

	public void setNumberOfNewMessages(int numberOfNewMessages) {
		this.numberOfNewMessages = numberOfNewMessages;
	}

	public void addNumberOfNewMessage() {
		numberOfNewMessages++;
	}

	public boolean isReceivedMsgSeen() {
		return isReceivedMsgSeen;
	}

	public void setReceivedMsgSeen(boolean isReceivedMsgSeen) {
		this.isReceivedMsgSeen = isReceivedMsgSeen;
	}

	public StringBuffer getStringBuff() {
		return stringBuff;
	}

	public void setStringBuff(StringBuffer sb) {
		this.stringBuff = sb;
	}

	public ImageIcon getImage() {
		if (isReceivedMsgSeen) {
			Image myImage = new ImageIcon("icons/seenmsg48.png").getImage();
			image = new ImageIcon(myImage);
			return image;
		}
		Image myImage = new ImageIcon("icons/newmsg48.png").getImage();
		image = new ImageIcon(myImage);
		return image;

	}

	@Override
	public String toString() {
		if (numberOfNewMessages==0) {
		return groupName;
		}else {
			return groupName+" ("+numberOfNewMessages+")";
		}
	}
}
