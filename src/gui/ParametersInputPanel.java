package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import logic.BCM;

public class ParametersInputPanel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public ParametersInputPanel(BCM dataHolder) {
		super("Best Canteen Maker");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSetCanteenMaking = new JLabel("Insert canteen parameters");
		lblSetCanteenMaking.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSetCanteenMaking.setBounds(10, 11, 240, 21);
		contentPane.add(lblSetCanteenMaking);

		JLabel lblBudget = new JLabel("Budget");
		lblBudget.setBounds(10, 43, 46, 14);
		contentPane.add(lblBudget);

		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(10, 68, 63, 14);
		contentPane.add(lblCapacity);

		JLabel lblIterations = new JLabel("Iterations");
		lblIterations.setBounds(10, 93, 63, 14);
		contentPane.add(lblIterations);

		JLabel lblIterationsSpeed = new JLabel("Iterations speed");
		lblIterationsSpeed.setBounds(10, 118, 110, 14);
		contentPane.add(lblIterationsSpeed);

		JLabel lblIndividuals = new JLabel("Number of individuals in generation");
		lblIndividuals.setBounds(10, 143, 182, 14);
		contentPane.add(lblIndividuals);

		JLabel lblHybrydizationFactor = new JLabel("Hybrydization factor");
		lblHybrydizationFactor.setBounds(10, 168, 141, 14);
		contentPane.add(lblHybrydizationFactor);

		JLabel lblMutationFactor = new JLabel("Mutation factor");
		lblMutationFactor.setBounds(10, 193, 110, 14);
		contentPane.add(lblMutationFactor);

		textField = new JTextField();
		textField.setBounds(265, 40, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(265, 65, 126, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(265, 90, 126, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(265, 115, 126, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(265, 140, 126, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(265, 165, 126, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(265, 190, 126, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblPln = new JLabel("PLN");
		lblPln.setBounds(401, 43, 46, 14);
		contentPane.add(lblPln);

		JLabel lblPrs = new JLabel("prs");
		lblPrs.setBounds(401, 68, 46, 14);
		contentPane.add(lblPrs);

		JLabel lblImin = new JLabel("i/min");
		lblImin.setBounds(401, 118, 46, 14);
		contentPane.add(lblImin);
		
		JTextPane errorTextPane = new JTextPane();
		errorTextPane.setEditable(false);
		errorTextPane.setForeground(Color.RED);
		errorTextPane.setBackground(SystemColor.menu);
		errorTextPane.setBounds(10, 218, 420, 77);
		contentPane.add(errorTextPane);
		errorTextPane.setVisible(false);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					dataHolder.setBudget(Double.parseDouble(textField.getText()));
					dataHolder.setCapacity(Integer.parseInt(textField_1.getText()));
					dataHolder.setIterations(Integer.parseInt(textField_2.getText()));
					dataHolder.setIterationsSpeed(Integer.parseInt(textField_3.getText()));
					dataHolder.setNumberOfIndividualsInIteration(Integer.parseInt(textField_4.getText()));
					dataHolder.setHybrydizationFactor(Double.parseDouble(textField_5.getText()));
					dataHolder.setMutationFactor(Double.parseDouble(textField_6.getText()));
					if(checkIfErrorsExist(errorTextPane, dataHolder) == 0){
						setVisible(false);
						Visualiser visualiser = new Visualiser(dataHolder);
						visualiser.setVisible(true);
					}
					
			}

		});
		btnSubmit.setBounds(341, 306, 89, 23);
		contentPane.add(btnSubmit);
		
	}
	
	private int returnErrorNumber(BCM dataHolder){
		if(dataHolder.getBudget() <= 0) return 1;
		if(dataHolder.getCapacity() <= 0) return 2;
		if(dataHolder.getIterations() <= 0) return 3;
		if(dataHolder.getIterationsSpeed() < 0) return 4;
		if(dataHolder.getNumberOfIndividualsInIteration() <= 0) return 5;
		if(dataHolder.getHybrydizationFactor() < 0) return 6;
		if(dataHolder.getMutationFactor() < 0) return 7;
		else return 0;
	}
	
	private int checkIfErrorsExist(JTextPane errorTextPane, BCM dataHolder){
		if(returnErrorNumber(dataHolder) == 1){
			errorTextPane.setText("Budget has to be bigger or equal to 0.");
			errorTextPane.setVisible(true);
			return 1;
		}
		if(returnErrorNumber(dataHolder) == 2){
			errorTextPane.setText("Capacity has to be bigger or equal to 0.");
			errorTextPane.setVisible(true);
			return 1;
		}
		if(returnErrorNumber(dataHolder) == 3){
			errorTextPane.setText("There has to be at least 1 iteration to make a simulation.");
			errorTextPane.setVisible(true);
			return 1;
		}
		if(returnErrorNumber(dataHolder) == 4){
			errorTextPane.setText("Iterations speed has to be bigger than 0.");
			errorTextPane.setVisible(true);
			return 1;
		}
		if(returnErrorNumber(dataHolder) == 5){
			errorTextPane.setText("Number Of Individuals in Iteration has to be bigger than 0.");
			errorTextPane.setVisible(true);
			return 1;
		}
		if(returnErrorNumber(dataHolder) == 6){
			errorTextPane.setText("Hybridization Factor has to be equal to 0 or bigger.");
			errorTextPane.setVisible(true);
			return 1;
		}
		if(returnErrorNumber(dataHolder) == 7){
			errorTextPane.setText("Mutation Factor has to be equal to 0 or bigger.");
			errorTextPane.setVisible(true);
			return 1;
		}
		
		return 0;
	}
}
