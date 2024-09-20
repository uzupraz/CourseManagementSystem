package UIdesign;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class SubmissionForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel Question;
	private JTextField Answertf;
	private static String Assigment_question;
	private JButton Submitbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		try {
			SubmissionForm dialog = new SubmissionForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JTextField getAnswertf() {
		return Answertf;
	}

	public static void setQuestion(String question) {
		Assigment_question = question;
	}

	/**
	 * Create the dialog.
	 */
	public SubmissionForm() {
		setBounds(100, 100, 980, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(134, 136, 137));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Assignment");
		lblNewLabel.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		Question = new JLabel(Assigment_question);
		Question.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		Answertf = new JTextField();
		Answertf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		Answertf.setColumns(10);
		
		Submitbtn = new JButton("Submit");
		Submitbtn.setForeground(new Color(0, 0, 0));
		Submitbtn.setBackground(new Color(0, 0, 0));
		Submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(Submitbtn, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addGap(415)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addGap(82)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(Question, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE)
								.addComponent(Answertf, GroupLayout.PREFERRED_SIZE, 794, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNewLabel)
					.addGap(58)
					.addComponent(Question, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Answertf, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
					.addComponent(Submitbtn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		contentPanel.setLayout(gl_contentPanel);
	}

	public JButton getSubmitbtn() {
		return Submitbtn;
	}
}
