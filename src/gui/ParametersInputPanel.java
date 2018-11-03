package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.DataHolder;

public class ParametersInputPanel extends JPanel {

	private JPanel titlePanel;
	private JLabel title;

	private JLabel budgetLabel;
	private JLabel capacityLabel;
	private JLabel iterationsLabel;
	private JLabel iterationsSpeedLabel;
	private JLabel numberOfIndividualsInGenerationLabel;
	private JLabel hybrydizationFactorLabel;
	private JLabel mutationFactorLabel;

	private JPanel dataInputPanel;

	private JTextField insertBudget;
	private JTextField insertCapacity;
	private JTextField insertIterations;
	private JTextField insertIterationsSpeed;
	private JTextField insertNumberOfIndividualsInGeneration;
	private JTextField insertHybrydizationFactor;
	private JTextField insertMutationFactor;

	private JPanel buttonPanel;

	private JPanel errorPanel;

	private JLabel errorLabel;

	private JButton backButton;
	private JButton nextButton;

	private CardLayout cardLayout;
	private DataHolder dataHolder;

	/**
	 * Create the panel.
	 */
	public ParametersInputPanel(CardLayout cardLayout, DataHolder dataHolder) {
		this.cardLayout = cardLayout;
		this.dataHolder = dataHolder;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel titlePanel = new JPanel();
		title = new JLabel("Insert canteen parameters");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		titlePanel.add(title);
		titlePanel.setMaximumSize(new Dimension(500, 100));
		titlePanel.setSize(new Dimension(500, 100));
		titlePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		titlePanel.setOpaque(false);
		this.add(titlePanel);

		dataInputPanel = new JPanel(new GridLayout(7, 2, 25, 25));

		budgetLabel = new JLabel("Budget (PLN):");
		budgetLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		capacityLabel = new JLabel("Capacity (persons):");
		capacityLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		iterationsLabel = new JLabel("Iterations:");
		iterationsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		iterationsSpeedLabel = new JLabel("Iterations speed (it/min):");
		iterationsSpeedLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		numberOfIndividualsInGenerationLabel = new JLabel("Number of individuals:");
		numberOfIndividualsInGenerationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		hybrydizationFactorLabel = new JLabel("Hybrydization factor:");
		hybrydizationFactorLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		mutationFactorLabel = new JLabel("Mutation factor:");
		mutationFactorLabel.setFont(new Font("Arial", Font.PLAIN, 20));

		insertBudget = new JTextField();
		insertCapacity = new JTextField();
		insertIterations = new JTextField();
		insertIterationsSpeed = new JTextField();
		insertNumberOfIndividualsInGeneration = new JTextField();
		insertHybrydizationFactor = new JTextField();
		insertMutationFactor = new JTextField();

		dataInputPanel.setBorder(new EmptyBorder(50, 50, 50, 50));

		dataInputPanel.add(budgetLabel);
		dataInputPanel.add(insertBudget);
		dataInputPanel.add(capacityLabel);
		dataInputPanel.add(insertCapacity);
		dataInputPanel.add(iterationsLabel);
		dataInputPanel.add(insertIterations);
		dataInputPanel.add(iterationsSpeedLabel);
		dataInputPanel.add(insertIterationsSpeed);
		dataInputPanel.add(numberOfIndividualsInGenerationLabel);
		dataInputPanel.add(insertNumberOfIndividualsInGeneration);
		dataInputPanel.add(hybrydizationFactorLabel);
		dataInputPanel.add(insertHybrydizationFactor);
		dataInputPanel.add(mutationFactorLabel);
		dataInputPanel.add(insertMutationFactor);

		dataInputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		dataInputPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		dataInputPanel.setOpaque(false);
		this.add(dataInputPanel);

		errorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
		errorPanel.setOpaque(false);
		errorPanel.setBorder(new EmptyBorder(20, 50, 20, 50));

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

		nextButton = new JButton("Generate");
		nextButton.setPreferredSize(new Dimension(220, 50));
		nextButton.setMaximumSize(new Dimension(220, 50));
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				clickedGenerateButton();
			}
		});
		buttonPanel.add(nextButton);

		buttonPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
		this.add(buttonPanel);

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				clickedBackButton();
			}
		});

	}

	private void clickedBackButton() {
		cardLayout.show(this.getParent(), "DimensionsInputPanel");
	}

	private void clickedGenerateButton() {
		if (validateData()) {
			setData();
			cardLayout.show(this.getParent(), "Visualizer");
		}
	}

	private void setData() {
		dataHolder.setBudget(Double.parseDouble(insertBudget.getText()));
		dataHolder.setCapacity(Integer.parseInt(insertCapacity.getText()));
		dataHolder.setIterations(Integer.parseInt(insertIterations.getText()));
		dataHolder.setIterationsSpeed(Integer.parseInt(insertIterationsSpeed.getText()));
		dataHolder
				.setNumberOfIndividualsInGeneration(Integer.parseInt(insertNumberOfIndividualsInGeneration.getText()));
		dataHolder.setHybrydizationFactor(Double.parseDouble(insertHybrydizationFactor.getText()));
		dataHolder.setMutationFactor(Double.parseDouble(insertMutationFactor.getText()));
	}

	private boolean validateData() {

		errorLabel.setText("");
		try {
			validateInputDouble(insertBudget);
			validateInputInteger(insertCapacity);
			validateInputInteger(insertIterations);
			validateInputInteger(insertIterationsSpeed);
			validateInputInteger(insertNumberOfIndividualsInGeneration);
			validateInputDouble(insertHybrydizationFactor);
			validateInputDouble(insertMutationFactor);
			return true;
		} catch (Exception e) {
			errorLabel.setText(e.getMessage());
			return false;
		}
	}

	private void validateInputDouble(JTextField inputDouble) throws IllegalArgumentException, NumberFormatException {

		inputDouble.setBackground(Color.WHITE);

		String strVal = inputDouble.getText();

		if (strVal.trim().isEmpty()) {
			inputDouble.setBackground(Color.RED);
			throw new IllegalArgumentException("Value cannot be empty");
		}

		Double doubleVal;

		try {
			doubleVal = Double.parseDouble(strVal);
		} catch (NumberFormatException e) {
			inputDouble.setBackground(Color.RED);
			throw new NumberFormatException("Incorret value format");
		}

		if (doubleVal < 0) {
			inputDouble.setBackground(Color.RED);
			throw new IllegalArgumentException("Value cannot be negative");
		}
	}

	private void validateInputInteger(JTextField inputInteger) throws IllegalArgumentException, NumberFormatException {

		inputInteger.setBackground(Color.WHITE);

		String strVal = inputInteger.getText();

		if (strVal.trim().isEmpty()) {
			inputInteger.setBackground(Color.RED);
			throw new IllegalArgumentException("Value cannot be empty");
		}

		Integer integerVal;

		try {
			integerVal = Integer.parseInt(strVal);
		} catch (NumberFormatException e) {
			inputInteger.setBackground(Color.RED);
			throw new NumberFormatException("Incorret value format");
		}

		if (integerVal < 0) {
			inputInteger.setBackground(Color.RED);
			throw new IllegalArgumentException("Value cannot be negative");
		}
	}

}
