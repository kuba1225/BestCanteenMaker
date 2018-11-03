package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Instructions extends JPanel {

	private CardLayout cardLayout;

	/**
	 * Create the panel.
	 */
	public Instructions(CardLayout cardLayout) {
		this.cardLayout = cardLayout;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JTextArea instructionsTextArea = new JTextArea("");

		instructionsTextArea.setEditable(false);

		instructionsTextArea.append(instruction);
		instructionsTextArea.setLineWrap(true);
		instructionsTextArea.setWrapStyleWord(true);
		instructionsTextArea.setOpaque(false);
		instructionsTextArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(instructionsTextArea);
		this.setBorder(new EmptyBorder(20, 20, 20, 20));

		JPanel tittlePanel = new JPanel();
		JLabel tittleLabel = new JLabel("Instructions");
		tittleLabel.setFont(new Font("Arial", Font.BOLD, 25));
		tittlePanel.setBorder(new EmptyBorder(20, 0, 20, 0));
		tittlePanel.add(tittleLabel);

		JPanel buttonPanel = new JPanel();
		JButton backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(220, 50));
		backButton.setMaximumSize(new Dimension(220, 50));
		buttonPanel.setBorder(new EmptyBorder(30, 0, 10, 0));
		buttonPanel.add(backButton);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				clickedBackButton();
			}
		});

		this.add(tittlePanel);
		this.add(scrollPane);
		this.add(buttonPanel);
	}

	private void clickedBackButton() {
		cardLayout.show(this.getParent(), "Menu");
	}

	private String instruction = "------------------------------------------------------------------------------------------------------------    \r\n"
			+ "                               Welcome in The Best Canteen Maker Instruction!\r\n"
			+ "------------------------------------------------------------------------------------------------------------\r\n"
			+ "You will find here tips and advices about how to use the program.\r\n" + "\r\n"
			+ "1. First step data insertion.\r\n"
			+ "When You are inserting walls parameters do not forget that they have to be all bigger than 0. Furthermore, length of the opposite walls has to be equal. It is important to choose canteen parameters wisely. Simulations will give the best effects if lenghts of the walls will be close to the possible, natural size of canteen. Setting canteen are both to one square kilometer and two square meters will result in not natural, possibly inapproperiate simulations.\r\n"
			+ "Suggested room area: 30 - 500 square meters.\r\n"
			+ "------------------------------------------------------------------------------------------------------------\r\n"
			+ "\r\n" + "2. Second step of inserting data.\r\n"
			+ "In second step You have to specify internal parameters of simulation. Specifing them not correctly may result in inapproperiate working of program and abnormal canteens projects.\r\n"
			+ "\r\n" + "Parameters to set:\r\n"
			+ "*Budget - budget has to be adjusted to the capacity and size of canteen. The currency is Polish Zloty. The bigger budget is, the more possible is that the overall rating of Your canteen will be high.\r\n"
			+ "*Capacity - capacity has to be adjusted mainly to the area of room. Setting to big capacity to small canteen will result in program errors.\r\n"
			+ "*Iterations - as long as program is based on genetic algorithm, You have to specify number of iterations. Each iteration will show You different project of canteen. The bigger is the number of iterations, the more adjusted canteen will be. Warning: setting this parameter to  the too big decimal will result in longer program work and similiar projects in late iterations.\r\n"
			+ "Suggested number: 3 - 30.\r\n"
			+ "*Iterations speed - The speed of iterations (iterations/minute). Max speed is 60 i/min. Setting this parameter to 0 will result in changing rewind mode to manual.\r\n"
			+ "*Number of individuals in generation - how many individuals will be competing in one iteration to be represented as the ultimate individual. The bigger is the number, the better results are, but program is slower. \r\n"
			+ "Suggested number: 5 - 50.\r\n"
			+ "*Mutation factor - specifies how often mutations will be occuring. It adds diversity and randomness to the project.\r\n"
			+ "*Hybrydization factor - specifies chance of creating new hybrids.\r\n"
			+ " ------------------------------------------------------------------------------------------------------------\r\n"
			+ "\r\n" + "3. Visualiser\r\n"
			+ "This module is created to visualise results of program calculations. It can work in two different modes:\r\n"
			+ "* auto-rewind mode\r\n" + "* manual-rewind mode\r\n"
			+ "In auto-rewind mode, projects will be changing in a estabilished periods of time.\r\n"
			+ "In manual-rewind mode You will have to press \"Next\" button to change current canteen model.";

}
