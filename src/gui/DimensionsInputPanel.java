package gui;

import java.awt.BasicStroke;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import logic.DataHolder;
import logic.Individual;

public class DimensionsInputPanel extends JPanel {

	private JPanel titlePanel;
	private JLabel title;

	private WallsPanel wallsPanel;

	private JLabel wallA;
	private JLabel wallB;
	private JLabel wallC;
	private JLabel wallD;
	private JLabel wallE;
	private JLabel wallF;

	private JPanel dataInputPanel;

	private JTextField inputWallA;
	private JTextField inputWallB;
	private JTextField inputWallC;
	private JTextField inputWallD;
	private JTextField inputWallE;
	private JTextField inputWallF;

	private JPanel errorPanel;
	private JLabel errorLabel;

	private JPanel buttonPanel;
	private JButton backButton;
	private JButton nextButton;

	private CardLayout cardLayout;
	private DataHolder dataHolder;

	/**
	 * Create the panel.
	 */
	public DimensionsInputPanel(CardLayout cardLayout, DataHolder dataHolder) {
		this.cardLayout = cardLayout;
		this.dataHolder = dataHolder;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		titlePanel = new JPanel();
		title = new JLabel("Insert walls size parameters");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		titlePanel.add(title);
		titlePanel.setMaximumSize(new Dimension(500, 100));
		titlePanel.setSize(new Dimension(500, 100));
		titlePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		titlePanel.setOpaque(false);
		this.add(titlePanel);

		wallsPanel = new WallsPanel();
		this.add(wallsPanel);

		dataInputPanel = new JPanel(new GridLayout(6, 2, 25, 25));
		wallA = new JLabel("Wall A:");
		wallA.setFont(new Font("Arial", Font.PLAIN, 20));
		wallB = new JLabel("Wall B:");
		wallB.setFont(new Font("Arial", Font.PLAIN, 20));
		wallC = new JLabel("Wall C:");
		wallC.setFont(new Font("Arial", Font.PLAIN, 20));
		wallD = new JLabel("Wall D:");
		wallD.setFont(new Font("Arial", Font.PLAIN, 20));
		wallE = new JLabel("Wall E:");
		wallE.setFont(new Font("Arial", Font.PLAIN, 20));
		wallF = new JLabel("Wall F:");
		wallF.setFont(new Font("Arial", Font.PLAIN, 20));
		inputWallA = new JTextField();
		inputWallB = new JTextField();
		inputWallC = new JTextField();
		inputWallD = new JTextField();
		inputWallE = new JTextField();
		inputWallF = new JTextField();
		dataInputPanel.setBorder(new EmptyBorder(20, 50, 20, 50));

		dataInputPanel.add(wallA);
		dataInputPanel.add(inputWallA);
		dataInputPanel.add(wallB);
		dataInputPanel.add(inputWallB);
		dataInputPanel.add(wallC);
		dataInputPanel.add(inputWallC);
		dataInputPanel.add(wallD);
		dataInputPanel.add(inputWallD);
		dataInputPanel.add(wallE);
		dataInputPanel.add(inputWallE);
		dataInputPanel.add(wallF);
		dataInputPanel.add(inputWallF);
		dataInputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		dataInputPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		dataInputPanel.setOpaque(false);
		this.add(dataInputPanel);

		errorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
		errorPanel.setOpaque(false);

		errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		errorPanel.add(errorLabel);

		this.add(errorPanel);

		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
		dataInputPanel.setOpaque(false);

		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(220, 50));
		backButton.setMaximumSize(new Dimension(220, 50));
		buttonPanel.add(backButton);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				clickedBackButton();
			}
		});

		nextButton = new JButton("Next");
		nextButton.setPreferredSize(new Dimension(220, 50));
		nextButton.setMaximumSize(new Dimension(220, 50));
		buttonPanel.add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				clickedNextButton();
			}
		});

		buttonPanel.setBorder(new EmptyBorder(10, 10, 20, 10));
		this.add(buttonPanel);

	}

	public void clickedNextButton() {
		if (validateData()) {
			setData();
			cardLayout.show(this.getParent(), "ParametersInputPanel");
		}
	}

	public void clickedBackButton() {
		cardLayout.show(this.getParent(), "Menu");
	}

	private class WallsPanel extends JPanel {
		public WallsPanel() {
			this.setBackground(Color.WHITE);
			this.setPreferredSize(new Dimension(600, 500));
			this.setMinimumSize(new Dimension(200, 280));
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int width = this.getWidth();
			int height = this.getHeight();

			Color color = Color.BLACK;
			int size = 5;
			setFont(new Font("Dialog", Font.BOLD, 20));

			g.setColor(color);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(size));

			drawLineA(g, Color.BLACK, 5);
			drawLineB(g, Color.BLACK, 5);
			drawLineC(g, Color.BLACK, 5);
			drawLineD(g, Color.BLACK, 5);
			drawLineE(g, Color.BLACK, 5);
			drawLineF(g, Color.BLACK, 5);

		}

		public void drawLineA(Graphics g, Color color, int size) {
			int width = this.getWidth();
			int height = this.getHeight();
			g.drawLine(20, 20, 20, height - 20);
			g.drawString("A", 25, (int) (20 + 0.5 * height));
		}

		public void drawLineB(Graphics g, Color color, int size) {
			int width = this.getWidth();
			int height = this.getHeight();
			g.drawLine(20, 20, (int) (0.3 * (width - 40)), 20);
			g.drawString("B", (int) (0.5 * (0.3 * (width - 40))), 40);
		}

		public void drawLineC(Graphics g, Color color, int size) {
			int width = this.getWidth();
			int height = this.getHeight();
			g.drawLine((int) (0.3 * (width - 40)), 20, (int) (0.3 * (width - 40)), (int) (0.3 * (height - 40)));
			g.drawString("C", (int) ((0.3 * (width - 40)) - 20), (int) (0.5 * (0.3 * (height - 40)) + 20));
		}

		public void drawLineD(Graphics g, Color color, int size) {
			int width = this.getWidth();
			int height = this.getHeight();
			g.drawLine((int) (0.3 * (width - 40)), (int) (0.3 * (height - 40)), width - 20,
					(int) (0.3 * (height - 40)));
			g.drawString("D", (int) (0.6 * width - 8), (int) (0.3 * (height - 40)) + 20);
		}

		public void drawLineE(Graphics g, Color color, int size) {
			int width = this.getWidth();
			int height = this.getHeight();
			g.drawLine(width - 20, height - 20, width - 20, (int) (0.3 * (height - 40)));
			g.drawString("E", (int) (width - 40), (int) (0.5 * height + 40));
		}

		public void drawLineF(Graphics g, Color color, int size) {
			int width = this.getWidth();
			int height = this.getHeight();
			g.drawLine(20, height - 20, width - 20, height - 20);
			g.drawString("F", (int) (0.5 * width - 40), (int) (height - 25));
		}
	}

	private void setData() {
		dataHolder.setWallA(Double.parseDouble(inputWallA.getText()));
		dataHolder.setWallB(Double.parseDouble(inputWallB.getText()));
		dataHolder.setWallC(Double.parseDouble(inputWallC.getText()));
		dataHolder.setWallD(Double.parseDouble(inputWallD.getText()));
		dataHolder.setWallE(Double.parseDouble(inputWallE.getText()));
		dataHolder.setWallF(Double.parseDouble(inputWallF.getText()));
	}

	private boolean validateData() {

		errorLabel.setText("");
		try {
			validateWallInput(inputWallA);
			validateWallInput(inputWallB);
			validateWallInput(inputWallC);
			validateWallInput(inputWallD);
			validateWallInput(inputWallE);
			validateWallInput(inputWallF);

			double a = Double.parseDouble(inputWallA.getText());
			double b = Double.parseDouble(inputWallB.getText());
			double c = Double.parseDouble(inputWallC.getText());
			double d = Double.parseDouble(inputWallD.getText());
			double e = Double.parseDouble(inputWallE.getText());
			double f = Double.parseDouble(inputWallF.getText());

			if ((a != (c + e))) {
				throw new IllegalArgumentException("Sum of wall \"c\" and \"e\" must be equal to wall \"a\"");
			}

			if ((f != (b + d))) {
				throw new IllegalArgumentException("Sum of wall \"b\" and \"d\" must be equal to wall \"f\"");
			}

			return true;
		} catch (Exception e) {
			errorLabel.setText(e.getMessage());
			return false;
		}
	}

	private void validateWallInput(JTextField wallInput) throws IllegalArgumentException, NumberFormatException {

		wallInput.setBackground(Color.WHITE);

		String wall = wallInput.getText();

		if (wall.trim().isEmpty()) {
			wallInput.setBackground(Color.RED);
			throw new IllegalArgumentException("Wall size field cannot be empty");
		}

		Double wallSize;

		try {
			wallSize = Double.parseDouble(wall);
		} catch (NumberFormatException e) {
			wallInput.setBackground(Color.RED);
			throw new NumberFormatException("Incorret wall size format");
		}

		if (wallSize < 0) {
			wallInput.setBackground(Color.RED);
			throw new IllegalArgumentException("Wall size field cannot be negative");
		}
	}
}
