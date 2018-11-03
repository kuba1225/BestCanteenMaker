package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import logic.BCM;
import logic.DataHolder;
import logic.Individual;
import java.awt.GridLayout;
import java.awt.Insets;

public class Visualizer extends JPanel {

	private BCM bcm;

	private JPanel contentPane;
	private JLabel capacityLabel;
	private JLabel priceLabel;
	private JLabel overallLabel;
	private JProgressBar progressBarOfOverall;
	private JLabel capacityValueLabel;
	private JLabel priceValueLabel;
	private JButton nextButton;
	private JButton startStopButton;
	private JButton menuButton;
	private JLabel iterationLabel;
	private JPanel drawingPanel;
	private JPanel drawingContainerPanel;
	private JPanel menuContainerPanel;

	private boolean stopFlag;
	private boolean firstTime;
	private int actualIteration;

	private Timer timer;

	private CardLayout cardLayout;

	public Visualizer(CardLayout cardLayout, DataHolder dataHolder) {
		this.cardLayout = cardLayout;

		actualIteration = 0;
		firstTime = true;

		contentPane = new JPanel(new GridBagLayout());

		drawingContainerPanel = new JPanel();
		menuContainerPanel = new JPanel(new GridBagLayout());

		GridBagConstraints c2 = new GridBagConstraints();
		c2.insets = new Insets(3,3,3,3);
		
		c2.gridx = 0;
		c2.gridy = 0;
		capacityLabel = new JLabel("Capacity");
		menuContainerPanel.add(capacityLabel, c2);

		c2.gridx = 1;
		c2.gridy = 0;
		capacityValueLabel = new JLabel("123");
		menuContainerPanel.add(capacityValueLabel, c2);

		c2.gridx = 0;
		c2.gridy = 1;
		priceLabel = new JLabel("Price");
		menuContainerPanel.add(priceLabel, c2);

		c2.gridx = 1;
		c2.gridy = 1;
		priceValueLabel = new JLabel("22");
		menuContainerPanel.add(priceValueLabel, c2);

		c2.gridx = 0;
		c2.gridy = 2;
		overallLabel = new JLabel("Overall");
		menuContainerPanel.add(overallLabel, c2);

		c2.gridx = 1;
		c2.gridy = 2;
		progressBarOfOverall = new JProgressBar();
		progressBarOfOverall.setMaximum(10);
		progressBarOfOverall.setValue(0);
		menuContainerPanel.add(progressBarOfOverall, c2);

		c2.gridx = 0;
		c2.gridy = 3;
		nextButton = new JButton("Next");
		menuContainerPanel.add(nextButton, c2);

		c2.gridx = 2;
		c2.gridy = 3;
		startStopButton = new JButton("Start");
		menuContainerPanel.add(startStopButton, c2);


		c2.gridx = 1;
		c2.gridy = 4;
		iterationLabel = new JLabel("Iteration: -/-");
		menuContainerPanel.add(iterationLabel, c2);

		drawingContainerPanel.setMinimumSize(new Dimension(600, 400));

		GridBagConstraints c = new GridBagConstraints();

		nextButton.setEnabled(false);

		c.gridx = 0;
		c.gridy = 0;
		contentPane.add(menuContainerPanel);

		c.gridy = 1;
		contentPane.add(drawingContainerPanel, c);

		this.add(contentPane);

		ActionListener doNextIteration = new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (actualIteration < bcm.getIterations()) {
					iterationLabel.setText("Iteration: " + (actualIteration + 2) + "/" + bcm.getIterations());
					drawingContainerPanel.removeAll();
					drawingPanel = new DrawingPanel(bcm, actualIteration);
					drawingContainerPanel.add(drawingPanel);
					actualIteration += 1;

					String l1 = String.valueOf(bcm.getBestIndividualInEachIterationPopulation()
							.getIndividualsPopulation().get(actualIteration).getNumberOfSittingPlaces());
					String l2 = String.valueOf(bcm.getBestIndividualInEachIterationPopulation()
							.getIndividualsPopulation().get(actualIteration).getCostSum());
					capacityValueLabel.setText(l1);
					priceValueLabel.setText(l2);
					progressBarOfOverall.setMaximum(100);
					progressBarOfOverall.setValue(bcm.getBestIndividualInEachIterationPopulation()
							.getIndividualsPopulation().get(actualIteration).getComfortPoints());
					// progressBarOfComfort.setMaximum(100);
					progressBarOfOverall.setValue(bcm.getBestIndividualInEachIterationPopulation()
							.getIndividualsPopulation().get(actualIteration).getFitness());
					actualIteration += 1;
				} else {
					startStopButton.setEnabled(false);
					timer.stop();
				}
			}
		};

		startStopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (firstTime) {
					startStopButton.setEnabled(false);
					firstTime = false;
					bcm = new BCM(dataHolder);
					bcm.generateProjects();
					timer = new Timer(60000 / bcm.getIterationsSpeed(), doNextIteration);
				}

				if (bcm.getIterationsSpeed() != 0) {
					nextButton.setEnabled(false);
					startStopButton.setEnabled(true);

					if (stopFlag) {
						timer.stop();
						startStopButton.setText("Start");
						stopFlag = false;
					} else {
						timer.start();
						startStopButton.setText("Stop");
						stopFlag = true;
					}
				} else {
					nextButton.setEnabled(true);
				}
			}
		});

		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (actualIteration < bcm.getIterations()) {
					iterationLabel.setText("Iteration: " + (actualIteration + 1) + "/" + bcm.getIterations());

					drawingContainerPanel.removeAll();
					drawingPanel = new DrawingPanel(bcm, actualIteration);
					drawingContainerPanel.add(drawingPanel);

					String l1 = String.valueOf(bcm.getBestIndividualInEachIterationPopulation()
							.getIndividualsPopulation().get(actualIteration).getNumberOfSittingPlaces());
					String l2 = String.valueOf(bcm.getBestIndividualInEachIterationPopulation()
							.getIndividualsPopulation().get(actualIteration).getCostSum());
					capacityValueLabel.setText(l1);
					priceValueLabel.setText(l2);
					progressBarOfOverall.setMaximum(100);
					progressBarOfOverall.setValue(bcm.getBestIndividualInEachIterationPopulation()
							.getIndividualsPopulation().get(actualIteration).getComfortPoints());
					// progressBarOfComfort.setMaximum(100);
					progressBarOfOverall.setValue(bcm.getBestIndividualInEachIterationPopulation()
							.getIndividualsPopulation().get(actualIteration).getFitness());

					actualIteration += 1;
				} else
					nextButton.setEnabled(false);
			}
		});


	}
}

class DrawingPanel extends JPanel {

	private int i;
	private BCM bcm;

	public DrawingPanel(BCM bcm, int i) {
		setPreferredSize(new Dimension(650, 650));
		this.bcm = bcm;
		this.i = i;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		double scale = calculateScale(bcm);

		if (bcm != null) {
			Individual tmp = bcm.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(i);

			int shopX = 50 + (int) ((int) tmp.getShop().getX() * scale);
			int shopY = 50 + (int) ((int) tmp.getShop().getY() * scale);
			int shopLengthX = (int) (tmp.getShop().getLengthX() * scale);
			int shopLengthY = (int) (tmp.getShop().getLengthY() * scale);

			// draw shop at coordinates (x,y) with shopLengthX, shopLengthY
			g.setColor(new Color(180, 0, 0));
			g.fillRect(shopX, shopY, shopLengthX, shopLengthY);

			// draw seats
			for (int j = 0; j < tmp.getSeatsCoordinates().size(); j++) {
				int x = 50 + (int) ((tmp.getSeatsCoordinates().get(j).getX() + 0.2) * scale);
				int y = 50 + (int) ((tmp.getSeatsCoordinates().get(j).getY() + 0.2) * scale);
				int lengthX = (int) (scale * 0.6);
				int lengthY = (int) (scale * 0.6);
				g.setColor(new Color(80, 80, 80));
				g.fillRect(x, y, lengthX, lengthY);
				g.fillRect(x + 2, y + 2, 10 - 4, 10 - 4);
			}

			// draw tables
			for (int j = 0; j < tmp.getTablesCoordinates().size(); j++) {
				int x = 50 + (int) ((int) tmp.getTablesCoordinates().get(j).getX() * scale);
				int y = 50 + (int) ((int) tmp.getTablesCoordinates().get(j).getY() * scale);
				int lengthX = (int) (tmp.getTablesCoordinates().get(j).getLengthX() * scale);
				int lengthY = (int) (tmp.getTablesCoordinates().get(j).getLengthY() * scale);
				g.setColor(new Color(150, 150, 150));
				g.fillRect(x, y, lengthX, lengthY);
			}

			// draw lamps
			for (int j = 0; j < tmp.getLampsCoordinates().size(); j++) {
				int x = 50 + (int) ((int) tmp.getLampsCoordinates().get(j).getX() * scale);
				int y = 50 + (int) ((int) tmp.getLampsCoordinates().get(j).getY() * scale);
				g.setColor(Color.YELLOW);
				g.fillOval(x, 5 + y, (int) (0.3 * scale), (int) (0.3 * scale));
			}

			// draw walls
			g.setColor(Color.BLACK);
			g.drawLine(50, 50, 50 + (int) (bcm.getB() * scale), 50);
			g.drawLine(50 + (int) (bcm.getB() * scale), 50, 50 + (int) (bcm.getB() * scale),
					50 + (int) (bcm.getC() * scale));
			g.drawLine(50 + (int) (bcm.getB() * scale), 50 + (int) (bcm.getC() * scale),
					50 + (int) (bcm.getF() * scale), 50 + (int) (bcm.getC() * scale));
			g.drawLine(50 + (int) (bcm.getF() * scale), 50 + (int) (bcm.getC() * scale),
					50 + (int) (bcm.getF() * scale), 50 + (int) (bcm.getA() * scale));
			g.drawLine(50 + (int) (bcm.getF() * scale), 50 + (int) (bcm.getA() * scale), 50,
					50 + (int) (bcm.getA() * scale));
			g.drawLine(50, 50 + (int) (bcm.getA() * scale), 50, 50);

			// draw windows
			for (int j = 0; j < tmp.getWindowsCoordinates().size(); j++) {
				int x = 50 + (int) (tmp.getWindowsCoordinates().get(j).getX() * scale);
				int y = 50 + (int) (tmp.getWindowsCoordinates().get(j).getY() * scale);
				int length = (int) (tmp.getWindowsCoordinates().get(j).getLength() * scale);
				int position = tmp.getWindowsCoordinates().get(j).getPosition();
				// draw window at coordinates (x,y) with length and position(pozioma - 0,
				// pionowa - 1)
				if (position == 1) {
					g.setColor(new Color(220, 220, 220));
					g.drawLine(x, y, x, y + length);
				} else {
					g.setColor(new Color(220, 220, 220));
					g.drawLine(x, y, x + length, y);
				}
			}

			// draw door
			int doorX = 50 + (int) (tmp.getDoor().getX() * scale);
			int doorY = 50 + (int) (tmp.getDoor().getY() * scale);
			int doorLength = (int) (tmp.getDoor().getLength() * scale);
			int position = tmp.getDoor().getPosition();
			g.setColor(Color.RED);
			if (position == 1) {
				g.drawLine(doorX, doorY, doorX, (doorY + doorLength));
			} else if (position == 0) {
				g.drawLine(doorX, doorY, (doorX + doorLength), doorY);
			}
		}
	}

	public double calculateScale(BCM bcm) {
		double scale = 0;
		int tmp = 0;

		double windowWidth = this.getWidth() - 100;
		double windowHeight = this.getParent().getHeight() - 20;

		if (bcm.getA() >= bcm.getF()) {
			tmp = (int) bcm.getA();
			scale = windowHeight / tmp;
		} else {
			tmp = (int) bcm.getF();
			scale = windowWidth / tmp;
		}

		return scale;
	}
}
