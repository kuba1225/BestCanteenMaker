package gui;

import java.awt.EventQueue;

public class BCMFrame {

	public static void main(String[] args) {
		Runnable newThread = new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		EventQueue.invokeLater(newThread);
	}

}
