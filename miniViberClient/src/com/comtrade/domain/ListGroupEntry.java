package com.comtrade.domain;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.comtrade.domain.Groups;

public class ListGroupEntry {
	private Groups group;
	private ImageIcon image;
	private String path;
	private int numberOfNewRequests =0;

	
	public ListGroupEntry(Groups tempGroup, String path) {
		this.group = tempGroup;
		this.path = path;
	}

	
	
	public int getNumberOfNewRequests() {
		return numberOfNewRequests;
	}



	public void setNumberOfNewRequests(int numberOfNewRequests) {
		this.numberOfNewRequests = numberOfNewRequests;
	}

	public void addNewGroupRequest() {
		numberOfNewRequests++;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public ImageIcon getImage() {
		ImageIcon myImage = new ImageIcon(path);
		Image img  = myImage.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		image = new ImageIcon(img);
		return image;
	}
	
		
	public Groups getGroup() {
		return group;
	}

	@Override
	public String toString() {
		if (numberOfNewRequests!=0) {
			return group.getGroupName()+" (+"+numberOfNewRequests+")";
		}
		return group.getGroupName();
	}
	
}