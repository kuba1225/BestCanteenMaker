package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import logic.BCM;

public class SetParametersFirstStep extends JFrame {

	private JPanel contentPane;
	private JTextField aTextField;
	private JTextField bTextField;
	private JTextField cTextField;
	private JTextField dTextField;
	private JTextField eTextField;
	private JTextField fTextField;

	public SetParametersFirstStep() {
		super("Best Canteen Maker");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 728, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		BCM dataHolder = new BCM();

		JLabel lblNewLabel = new JLabel("Insert walls size parameters");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 204, 21);
		contentPane.add(lblNewLabel);

		JLabel WallSchemeLabel = new JLabel("New label");
		WallSchemeLabel.setIcon(new ImageIcon(SetParametersFirstStep.class.getResource("/gui/images/WallNull.jpg")));
		WallSchemeLabel.setBounds(20, 43, 676, 421);
		contentPane.add(WallSchemeLabel);

		JLabel lblWallALength = new JLabel("wall a length");
		lblWallALength.setBounds(20, 493, 78, 14);
		contentPane.add(lblWallALength);

		JLabel lblNewLabel_1 = new JLabel("wall b length");
		lblNewLabel_1.setBounds(20, 518, 78, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("wall c length");
		lblNewLabel_2.setBounds(20, 543, 78, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("wall d length");
		lblNewLabel_3.setBounds(20, 568, 78, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblWallELength = new JLabel("wall e length");
		lblWallELength.setBounds(20, 593, 78, 14);
		contentPane.add(lblWallELength);

		JLabel lblWallFLength = new JLabel("wall f length");
		lblWallFLength.setBounds(20, 618, 78, 14);
		contentPane.add(lblWallFLength);
		
		JTextPane errorTextPane = new JTextPane();
		errorTextPane.setForeground(Color.RED);
		errorTextPane.setBackground(SystemColor.menu);
		errorTextPane.setBounds(229, 493, 467, 96);
		errorTextPane.setEditable(false);
		contentPane.add(errorTextPane);

		aTextField = new JTextField();
		aTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WallSchemeLabel
						.setIcon(new ImageIcon(SetParametersFirstStep.class.getResource("/gui/images/WallA.jpg")));
			}
		});
		aTextField.setBounds(102, 490, 86, 20);
		contentPane.add(aTextField);
		aTextField.setColumns(10);

		bTextField = new JTextField();
		bTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WallSchemeLabel
						.setIcon(new ImageIcon(SetParametersFirstStep.class.getResource("/gui/images/WallB.jpg")));
			}
		});
		bTextField.setBounds(102, 515, 86, 20);
		contentPane.add(bTextField);
		bTextField.setColumns(10);

		cTextField = new JTextField();
		cTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WallSchemeLabel
						.setIcon(new ImageIcon(SetParametersFirstStep.class.getResource("/gui/images/WallC.jpg")));
			}
		});
		cTextField.setBounds(102, 540, 86, 20);
		contentPane.add(cTextField);
		cTextField.setColumns(10);

		dTextField = new JTextField();
		dTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WallSchemeLabel
						.setIcon(new ImageIcon(SetParametersFirstStep.class.getResource("/gui/images/WallD.jpg")));
			}
		});
		dTextField.setBounds(102, 565, 86, 20);
		contentPane.add(dTextField);
		dTextField.setColumns(10);

		eTextField = new JTextField();
		eTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WallSchemeLabel
						.setIcon(new ImageIcon(SetParametersFirstStep.class.getResource("/gui/images/WallE.jpg")));
			}
		});
		eTextField.setBounds(102, 590, 86, 20);
		contentPane.add(eTextField);
		eTextField.setColumns(10);

		fTextField = new JTextField();
		fTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WallSchemeLabel
						.setIcon(new ImageIcon(SetParametersFirstStep.class.getResource("/gui/images/WallF.jpg")));
			}
		});
		fTextField.setBounds(102, 615, 86, 20);
		contentPane.add(fTextField);
		fTextField.setColumns(10);
		

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dataHolder.setA(Double.parseDouble(aTextField.getText()));
				dataHolder.setB(Double.parseDouble(bTextField.getText()));
				dataHolder.setC(Double.parseDouble(cTextField.getText()));
				dataHolder.setD(Double.parseDouble(dTextField.getText()));
				dataHolder.setE(Double.parseDouble(eTextField.getText()));
				dataHolder.setF(Double.parseDouble(fTextField.getText()));
				
				if(checkIfErrorsExist(errorTextPane, dataHolder) == 0){
					setVisible(false);
					SetParametersSecondStep set = new SetParametersSecondStep(dataHolder);
					set.setVisible(true);
				}
				
			}
		});
		btnSubmit.setBounds(607, 614, 89, 23);
		contentPane.add(btnSubmit);

	}
	
	
	private int returnErrorNumber(BCM d){
		if(d.getA() <= 0 ||
			d.getB() <= 0 ||
			d.getC() <= 0 ||
			d.getD() <= 0 ||
			d.getE() <= 0 ||
			d.getF() <= 0) return 1;
		if(d.getB() + d.getD() != d.getF()) return 2;
		if(d.getC() + d.getE() != d.getA()) return 3;
		return 0;		
	}
	
	private int checkIfErrorsExist(JTextPane errorTextPane, BCM dataHolder){
		if(returnErrorNumber(dataHolder) == 1){
			errorTextPane.setText("All the lengths of walls have to be bigger than 0");
			errorTextPane.setVisible(true);
			return 1;
		}
		if(returnErrorNumber(dataHolder) == 2){
			errorTextPane.setText("Length of F wall has to be equal to the sum of lengths of walls B and D.");
			errorTextPane.setVisible(true);
			return 1;
		}
		if(returnErrorNumber(dataHolder) == 3){
			errorTextPane.setText("Length of A wall has to be equal to the sum of lengths of walls C and E.");
			errorTextPane.setVisible(true);
			return 1;
		}
		return 0;
	}

}
