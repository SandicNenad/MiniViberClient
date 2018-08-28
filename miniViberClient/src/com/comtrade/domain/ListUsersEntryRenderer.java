package com.comtrade.domain;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ListUsersEntryRenderer extends JLabel implements ListCellRenderer<Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	
	public ListUsersEntryRenderer() {
		setOpaque(true);
		setIconTextGap(12);
	}
	
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		ListUsersEntry entry = (ListUsersEntry) value;
		String title = entry.toString();
//		System.out.println("DA PROBAM");
		setText(title);
		setIcon(entry.getImage());
		if (isSelected) {
			setBackground(HIGHLIGHT_COLOR);
			setForeground(Color.white);
		} else {
			setBackground(Color.white);
			setForeground(Color.black);
		}
		return this;
	}


}
