package com.comtrade.domain;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.comtrade.constant.Constant;
import com.comtrade.domain.User;

public class ListUsersEntry {
	private User user;
	private String status;
	private ImageIcon image;
	public ListUsersEntry(User user, String status) {
		super();
		this.user = user;
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public ImageIcon getImage() {
		if(status.equals("online")) {
			ImageIcon myImage = new ImageIcon(Constant.ICON_USER_ONLINE);
			Image img = myImage.getImage();
			image = new ImageIcon(img);
		}else if (status.equals("offline")){
			ImageIcon myImage = new ImageIcon(Constant.ICON_USER_OFFLINE);
			Image img = myImage.getImage();
			image = new ImageIcon(img);
		}else if (status.equals("recieved")) {
			ImageIcon myImage = new ImageIcon(Constant.ICON_USER_RECIEVED_REQUEST);
			Image img = myImage.getImage();
			image = new ImageIcon(img);
		}else if (status.equals("sent")) {
			ImageIcon myImage = new ImageIcon(Constant.ICON_USER_SENT_REQUEST);
			Image img = myImage.getImage();
			image = new ImageIcon(img);
		}else if (status.equals("blocked")) {
			ImageIcon myImage = new ImageIcon(Constant.ICON_USER_BLOCKED);
			Image img = myImage.getImage();
			image = new ImageIcon(img);
		}else if (status.equals("notfriend")) {
			ImageIcon myImage = new ImageIcon(Constant.ICON_USER_NOT_FRIENDS);
			Image img = myImage.getImage();
			image = new ImageIcon(img);
		}else if (status.equals("groupadmin") || status.equals(Constant.ICON_USER_GROUP_ADMIN)) {
			ImageIcon myImage = new ImageIcon(Constant.ICON_USER_GROUP_ADMIN);
			Image img = myImage.getImage();
			image = new ImageIcon(img);
		}else if (status.equals("groupmember") || status.equals(Constant.ICON_USER_GROUP_MEMBER)) {
			ImageIcon myImage = new ImageIcon(Constant.ICON_USER_GROUP_MEMBER);
			Image img = myImage.getImage();
			image = new ImageIcon(img);
		}else if (status.equals("groupasktojoin")|| status.equals(Constant.ICON_USER_GROUP_SENT_REQUEST)) {
			ImageIcon myImage = new ImageIcon(Constant.ICON_USER_GROUP_SENT_REQUEST);
			Image img = myImage.getImage();
			image = new ImageIcon(img);
		}
		return image;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	
	public String toString() {
		return getUser().toString();
	}
}
