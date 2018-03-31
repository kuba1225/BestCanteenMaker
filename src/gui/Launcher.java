package gui;

import java.awt.EventQueue;

public class Launcher {

	public static void main(String[] args) {
		Runnable newThread = new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		EventQueue.invokeLater(newThread);
	}

}
