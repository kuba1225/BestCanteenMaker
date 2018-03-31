package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Authors extends JFrame {

	private JPanel contentPane;
	private JTextPane txtBestCanteenMaker;

	public Authors() {
		super("Best Canteen Maker");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 644, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtBestCanteenMaker = new JTextPane();
		txtBestCanteenMaker.setEditable(false);
		txtBestCanteenMaker.setText(
				"Best Canteen Maker application was made within \"Algorytmy i Struktury Danych\" laboratories.\r\n\r\nAuthors of the project: \r\nKrzysztof Berski,\r\nJakub Barański.\r\n\r\nSupervisor of the project: mgr inż. Paweł Zawadzki\r\n\r\nMade in the semester: Winter 2017\r\n\r\nPolitechnika Warszawska, Wydział Elektryczny (Warsaw University of Technology, EE faculty)");
		txtBestCanteenMaker.setBackground(SystemColor.menu);
		txtBestCanteenMaker.setBounds(10, 11, 608, 187);
		contentPane.add(txtBestCanteenMaker);
	}

}
