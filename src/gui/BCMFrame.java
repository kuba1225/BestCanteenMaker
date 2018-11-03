package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.DataHolder;

public class BCMFrame extends JFrame {

	/**
	 * Create the frame.
	 */
	public BCMFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 650, 850);
		this.setLocation((int) ((dim.getWidth() / 2) - (this.getSize().width / 2)),
				(int) ((dim.getHeight() / 2) - (this.getSize().height / 2)));

		this.setTitle("BestCanteenMaker");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final BCMFrame frame = new BCMFrame();
					final CardLayout cardLayout = new CardLayout();
					final JPanel contentPanel = new JPanel(cardLayout);

					DataHolder dataHolder = new DataHolder();

					JPanel cardMenu = new Menu(cardLayout);
					JPanel cardInstructions = new Instructions(cardLayout);
					JPanel cardDimensionsInput = new DimensionsInputPanel(cardLayout, dataHolder);
					JPanel cardParametersInput = new ParametersInputPanel(cardLayout, dataHolder);
					JPanel cardVisualiser = new Visualizer(cardLayout, dataHolder);

					contentPanel.add(cardMenu, "Menu");
					contentPanel.add(cardInstructions, "Instructions");
					contentPanel.add(cardDimensionsInput, "DimensionsInputPanel");
					contentPanel.add(cardParametersInput, "ParametersInputPanel");
					contentPanel.add(cardVisualiser, "Visualizer");

					cardLayout.show(contentPanel, "Menu");

					frame.add(contentPanel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
