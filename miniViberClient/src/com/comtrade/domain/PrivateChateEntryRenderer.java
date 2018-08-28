package com.comtrade.domain;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

@SuppressWarnings("rawtypes")
public class PrivateChateEntryRenderer extends JLabel implements ListCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	
	public PrivateChateEntryRenderer() {
		setOpaque(true);
		setIconTextGap(12);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		PrivateChatEntry entry = (PrivateChatEntry) value;
		setText(entry.toString());
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
