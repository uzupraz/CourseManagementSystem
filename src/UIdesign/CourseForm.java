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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.BevelBorder;

public class CourseForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JPanel getContentPanel() {
		return contentPanel;
	}
	

	public JTextField getCoursetf() {
		return Coursetf;
	}

	public JTextField getCourseDestf() {
		return courseDestf;
	}

	public JTextField getNomoduletf() {
		return nomoduletf;
	}


	public JTextField getDurationtf() {
		return durationtf;
	}

	private JTextField Coursetf;
	private JTextField courseDestf;
	private JTextField nomoduletf;
	private JTextField durationtf;
	private JButton btnSubmit;
	private JComboBox StatuscomboBox;
	private static String Status = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CourseForm dialog = new CourseForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CourseForm() {
		setBounds(100, 100, 1090, 651);
		contentPanel.setBackground(new Color(169, 170, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabel = new JLabel("CourseName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		Coursetf = new JTextField();
		Coursetf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		Coursetf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Coursetf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CourseDescription");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("No of Module");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2_1 = new JLabel("Status");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		courseDestf = new JTextField();
		courseDestf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		courseDestf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		courseDestf.setColumns(10);
		
		nomoduletf = new JTextField();
		nomoduletf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		nomoduletf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomoduletf.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(0, 0, 0));
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Duration");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		durationtf = new JTextField();
		durationtf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		durationtf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		durationtf.setColumns(10);
		
		JLabel lblAddCourse = new JLabel("Add Course");
		lblAddCourse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		StatuscomboBox = new JComboBox();
		StatuscomboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					setStatus((String) e.getItem());
				}
			}
		});
		StatuscomboBox.setBackground(new Color(255, 255, 255));
		StatuscomboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Status:", "Enabled", "Disabled"}));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
							.addGap(155)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(nomoduletf, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
									.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
									.addGap(118))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(StatuscomboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(Alignment.LEADING, gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
											.addComponent(durationtf, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
											.addComponent(courseDestf, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
											.addComponent(Coursetf, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
									.addContainerGap(505, Short.MAX_VALUE))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblAddCourse, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
							.addGap(863))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(18)
					.addComponent(lblAddCourse, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Coursetf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(courseDestf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(nomoduletf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(StatuscomboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(durationtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(157, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
		);
		getContentPane().setLayout(groupLayout);
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}


	public static String getStatus() {
		return Status;
	}


	public static void setStatus(String status) {
		Status = status;
	}
}
