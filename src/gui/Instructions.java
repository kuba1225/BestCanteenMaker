package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class Instructions extends JFrame {

	public Instructions() {
		super("Best Canteen Maker");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 524);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 475, 473);
		getContentPane().add(scrollPane);
		
		JTextPane txtpnWelcomeInThe = new JTextPane();
		txtpnWelcomeInThe.setText("------------------------------------------------------------------------------------------------------------    \r\n                               Welcome in The Best Canteen Maker Instruction!\r\n------------------------------------------------------------------------------------------------------------\r\nYou will find here tips and advices about how to use the program.\r\n\r\n1. First step data insertion.\r\nWhen You are inserting walls parameters do not forget that they have to be all bigger than 0. Furthermore, length of the opposite walls has to be equal. It is important to choose canteen parameters wisely. Simulations will give the best effects if lenghts of the walls will be close to the possible, natural size of canteen. Setting canteen are both to one square kilometer and two square meters will result in not natural, possibly inapproperiate simulations.\r\nSuggested room area: 30 - 500 square meters.\r\n------------------------------------------------------------------------------------------------------------\r\n\r\n2. Second step of inserting data.\r\nIn second step You have to specify internal parameters of simulation. Specifing them not correctly may result in inapproperiate working of program and abnormal canteens projects.\r\n\r\nParameters to set:\r\n*Budget - budget has to be adjusted to the capacity and size of canteen. The currency is Polish Zloty. The bigger budget is, the more possible is that the overall rating of Your canteen will be high.\r\n*Capacity - capacity has to be adjusted mainly to the area of room. Setting to big capacity to small canteen will result in program errors.\r\n*Iterations - as long as program is based on genetic algorithm, You have to specify number of iterations. Each iteration will show You different project of canteen. The bigger is the number of iterations, the more adjusted canteen will be. Warning: setting this parameter to  the too big decimal will result in longer program work and similiar projects in late iterations.\r\nSuggested number: 3 - 30.\r\n*Iterations speed - The speed of iterations (iterations/minute). Max speed is 60 i/min. Setting this parameter to 0 will result in changing rewind mode to manual.\r\n*Number of individuals in generation - how many individuals will be competing in one iteration to be represented as the ultimate individual. The bigger is the number, the better results are, but program is slower. \r\nSuggested number: 5 - 50.\r\n*Mutation factor - specifies how often mutations will be occuring. It adds diversity and randomness to the project.\r\n*Hybrydization factor - specifies chance of creating new hybrids.\r\n ------------------------------------------------------------------------------------------------------------\r\n\r\n3. Visualiser\r\nThis module is created to visualise results of program calculations. It can work in two different modes:\r\n* auto-rewind mode\r\n* manual-rewind mode\r\nIn auto-rewind mode, projects will be changing in a estabilished periods of time.\r\nIn manual-rewind mode You will have to press \"Next\" button to change current canteen model.\r\n\r\n-----------------------------------------------------o------------------------------------------------------");
		txtpnWelcomeInThe.setBounds(10, 11, 475, 700);
		scrollPane.setViewportView(txtpnWelcomeInThe);
	}
}
