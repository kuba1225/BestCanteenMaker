package gui;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Menu extends JPanel {

	private JButton buttonStart;
	private JButton buttonInstructions;
	private JButton buttonExit;
	private JLabel title;
	private JPanel titlePanel;
	private JPanel buttonPanel;
	private CardLayout cardLayout;

	/**
	 * Create the panel.
	 */
	public Menu(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
		showMenu();
	}

	private void showMenu() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		

		// TITLE PANEL
		title = new JLabel("Best Canteen Maker");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial Black", Font.PLAIN, 30));
		titlePanel = new JPanel();
		titlePanel.add(title);
		titlePanel.setMaximumSize(new Dimension(500, 100));
		titlePanel.setSize(new Dimension(500, 100));
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.setBorder(new EmptyBorder(40, 40, 40, 40));
		titlePanel.setOpaque(false);
		this.add(titlePanel);

		// BUTTON PANEL
		buttonPanel = new JPanel(new GridLayout(3, 1, 100, 80));
		buttonPanel.setSize(new Dimension(500, 550));
		buttonPanel.setMaximumSize(new Dimension(800, 550));

		buttonStart = new JButton("Nowa sto³ówka");
		buttonInstructions = new JButton("Instrukcja");
		buttonExit = new JButton("Wyjœcie");
		buttonPanel.setBorder(new EmptyBorder(100, 100, 100, 100));
		buttonPanel.add(buttonStart);
		buttonPanel.add(buttonInstructions);
		buttonPanel.add(buttonExit);
		buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		buttonPanel.setOpaque(false);
		this.add(buttonPanel);

		buttonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				clickedStartButton();
			}
		});
		buttonStart.setFont(new Font("Arial", Font.PLAIN, 20));

		buttonInstructions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				clickedInstructionsButton();
			}
		});
		buttonInstructions.setFont(new Font("Arial", Font.PLAIN, 20));

		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				clickedExitButton();
			}
		});
		buttonExit.setFont(new Font("Arial", Font.PLAIN, 20));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		GradientPaint gp = new GradientPaint(0, 0, Color.BLUE, 0, getHeight(), Color.BLACK);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

	private void clickedStartButton() {
		cardLayout.show(this.getParent(), "DimensionsInputPanel");
	}

	public void clickedInstructionsButton() {
		cardLayout.show(this.getParent(), "Instructions");
	}

	public void clickedExitButton() {
		System.exit(0);
	}

}