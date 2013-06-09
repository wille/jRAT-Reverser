package com.redpois0n;

import javax.swing.UIManager;

public class Main {
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		Frame frame = new Frame();
		frame.setVisible(true);
	}

}
