package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	public MainMenu() {
		super("Best Canteen Maker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		JButton newCanteenButton = new JButton("New Canteen");
		newCanteenButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetParametersFirstStep setParams = new SetParametersFirstStep();
				setParams.setVisible(true);
			}
		});
		newCanteenButton.setBounds(101, 114, 279, 35);
		contentPane.add(newCanteenButton);

		JButton instructionsButton = new JButton("Instructions");
		instructionsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Instructions instructions = new Instructions();
				instructions.setVisible(true);
			}
		});
		instructionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		instructionsButton.setBounds(101, 180, 279, 35);
		contentPane.add(instructionsButton);

		JButton authorsButton = new JButton("Authors & Informations");
		authorsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Authors authors = new Authors();
				authors.setVisible(true);
			}
		});
		authorsButton.setBounds(101, 249, 279, 35);
		contentPane.add(authorsButton);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/gui/images/MainMenu.jpg")));
		lblNewLabel.setBounds(0, 0, 495, 550);
		contentPane.add(lblNewLabel);
	}
}
