package gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import logic.BCM;
import logic.Individual;

public class Visualiser extends JFrame {

	private JPanel contentPane;

	public Visualiser(BCM dataHolder) {
		super("Best Canteen Maker");
		
		dataHolder.generateProjects();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 752);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

//		JLabel lblComfort = new JLabel("Comfort");
//		lblComfort.setBounds(10, 617, 82, 14);
//		contentPane.add(lblComfort);

		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(10, 642, 82, 14);
		contentPane.add(lblCapacity);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 667, 46, 14);
		contentPane.add(lblPrice);

		JLabel lblOverall = new JLabel("Overall");
		lblOverall.setBounds(411, 642, 46, 14);
		contentPane.add(lblOverall);

		JProgressBar progressBarOfOverall = new JProgressBar();
		progressBarOfOverall.setMaximum(10);
		progressBarOfOverall.setBounds(166, 622, 525, 14);
		contentPane.add(progressBarOfOverall);
		progressBarOfOverall.setValue(0);

//		JProgressBar progressBarOfComfort = new JProgressBar();
//		progressBarOfComfort.setMaximum(10);
//		progressBarOfComfort.setBounds(66, 617, 146, 14);
//		contentPane.add(progressBarOfComfort);
//		progressBarOfComfort.setValue(0);

		JLabel capacityLabel = new JLabel("");
		capacityLabel.setBounds(66, 642, 105, 14);
		contentPane.add(capacityLabel);

		JLabel priceLabel = new JLabel("");
		priceLabel.setBounds(66, 667, 105, 14);
		contentPane.add(priceLabel);

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(821, 688, 89, 23);
		contentPane.add(btnNext);

		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(821, 688, 89, 23);
		contentPane.add(btnStop);

		JLabel lblIteration = new JLabel("Iteration: -/" + dataHolder.getIterations());
		lblIteration.setBounds(803, 622, 105, 14);
		contentPane.add(lblIteration);
		

//		JPanel panel = new DrawingPanel(dataHolder, 0);
//		panel.setBackground(new Color(190, 190, 190));
//		panel.setBounds(10, 11, 900, 600);
//		contentPane.add(panel);

		if (dataHolder.getIterationsSpeed() != 0) {
			btnNext.setVisible(false);
			ActionListener doNextIteration = new ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(dataHolder.getActualIteration() != dataHolder.getIterations()-1){
						lblIteration.setText(
								"Iteration: " + (dataHolder.getActualIteration() + 2) + "/" + dataHolder.getIterations());
						JPanel newPanel = new DrawingPanel(dataHolder, dataHolder.getActualIteration());
						newPanel.setBackground(new Color(190, 190, 190));
						newPanel.setBounds(10, 11, 900, 600);
						contentPane.add(newPanel);
						newPanel.repaint();
						dataHolder.setActualIteration(dataHolder.getActualIteration() + 1);
						
						String l1 = String.valueOf(dataHolder.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(dataHolder.getActualIteration()).getNumberOfSittingPlaces());
						String l2 = String.valueOf(dataHolder.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(dataHolder.getActualIteration()).getCostSum());
						capacityLabel.setText(l1);
						priceLabel.setText(l2);
						progressBarOfOverall.setMaximum(100);
						progressBarOfOverall.setValue(dataHolder.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(dataHolder.getActualIteration()).getComfortPoints());
						//progressBarOfComfort.setMaximum(100);
						progressBarOfOverall.setValue(dataHolder.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(dataHolder.getActualIteration()).getFitness());
					}
					else btnStop.setEnabled(false);
				}
			};
			Timer timer = new Timer(60000 / dataHolder.getIterationsSpeed(), doNextIteration);
			timer.start();

			btnStop.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (dataHolder.isStopFlag()) {
						timer.stop();
						btnStop.setText("Resume");
						dataHolder.setStopFlag(false);
					} else {
						timer.start();
						btnStop.setText("Stop");
						dataHolder.setStopFlag(true);
					}
				}
			});
		}
		else {
			btnStop.setEnabled(false);
			btnNext.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (dataHolder.getActualIteration() < dataHolder.getIterations()) {
						lblIteration.setText("Iteration: " + (dataHolder.getActualIteration() + 1) + "/"
								+ dataHolder.getIterations());
						JPanel newPanel = new DrawingPanel(dataHolder, dataHolder.getActualIteration());
						newPanel.setBackground(new Color(190, 190, 190));
						newPanel.setBounds(10, 11, 900, 600);
						contentPane.add(newPanel);
						newPanel.repaint();
						dataHolder.setActualIteration(dataHolder.getActualIteration() + 1);
						
						String l1 = String.valueOf(dataHolder.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(dataHolder.getActualIteration()).getNumberOfSittingPlaces());
						String l2 = String.valueOf(dataHolder.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(dataHolder.getActualIteration()).getCostSum());
						capacityLabel.setText(l1);
						priceLabel.setText(l2);
						progressBarOfOverall.setMaximum(100);
						progressBarOfOverall.setValue(dataHolder.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(dataHolder.getActualIteration()).getComfortPoints());
						//progressBarOfComfort.setMaximum(100);
						progressBarOfOverall.setValue(dataHolder.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(dataHolder.getActualIteration()).getFitness());
					} else
						btnNext.setEnabled(false);
				}
			});
		}

	}
}
