package UIdesign;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class AssignmentForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField Questiontf;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	public static final ButtonGroup buttonGroup = new ButtonGroup();
	String Module;
	
	
	public String getModule() {
		return Module;
	}

	public static ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JTextField getQuestiontf() {
		return Questiontf;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AssignmentForm dialog = new AssignmentForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AssignmentForm() {
		setBounds(100, 100, 1323, 745);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(169, 170, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel("Add Assignment");
			lblNewLabel.setFont(new Font("Perpetua", Font.PLAIN, 25));
		}
		JLabel lblNewLabel_1 = new JLabel("Question");
		lblNewLabel_1.setFont(new Font("Perpetua", Font.PLAIN, 25));
		Questiontf = new JTextField();
		Questiontf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		Questiontf.setColumns(10);
		btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();

					if (button.isSelected()) {
						Module = button.getText().trim(); 
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		lblNewLabel_2 = new JLabel("Module");
		lblNewLabel_2.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		JRadioButton Ooprb = new JRadioButton("OOP");
		buttonGroup.add(Ooprb);
		Ooprb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Ooprb.setBackground(new Color(255, 255, 255));
		
		JRadioButton AIrb = new JRadioButton("AI");
		buttonGroup.add(AIrb);
		AIrb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AIrb.setBackground(new Color(255, 255, 255));
		
		JRadioButton Nmcrb = new JRadioButton("NMC");
		buttonGroup.add(Nmcrb);
		Nmcrb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nmcrb.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(333, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(552))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(528))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(561))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(Nmcrb, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(Questiontf, GroupLayout.PREFERRED_SIZE, 704, GroupLayout.PREFERRED_SIZE))
							.addGap(262))))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(324)
					.addComponent(Ooprb, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(191)
					.addComponent(AIrb, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(578, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel)
					.addGap(185)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Questiontf, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Ooprb)
						.addComponent(AIrb)
						.addComponent(Nmcrb))
					.addGap(47)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
		);
		contentPanel.setLayout(gl_contentPanel);
	}

	
}
