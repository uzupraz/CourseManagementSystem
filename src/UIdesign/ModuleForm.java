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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class ModuleForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel Course;
	private JTextField CourseIDtextField;
	private JTextField Moduletf;
	private JLabel lblModuleleader;
	private JTextField ModuleLeadertf;
	private JLabel lblLevel;
	private JLabel lblSemester;
	private JLabel lblCredithour;
	private JTextField Leveltf;
	private JTextField Semestertf;
	private JTextField CreditHouttf;
	private JButton Submit;
	private JLabel lblAddCourse;

	public JTextField getCourseIDtextField() {
		return CourseIDtextField;
	}


	public JTextField getLeveltf() {
		return Leveltf;
	}


	public JTextField getSemestertf() {
		return Semestertf;
	}


	public JTextField getCreditHouttf() {
		return CreditHouttf;
	}


	public JButton getSubmit() {
		return Submit;
	}


	public JTextField getModuletf() {
		return Moduletf;
	}

	public JTextField getModuleLeadertf() {
		return ModuleLeadertf;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModuleForm dialog = new ModuleForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModuleForm() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 1245, 734);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(169, 170, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			Course = new JLabel("CourseID:");
			Course.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		
		CourseIDtextField = new JTextField();
		CourseIDtextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		CourseIDtextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CourseIDtextField.setColumns(10);
		
		JLabel lblModulename = new JLabel("ModuleName:");
		lblModulename.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		Moduletf = new JTextField();
		Moduletf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		Moduletf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Moduletf.setColumns(10);
		
		lblModuleleader = new JLabel("ModuleLeader:");
		lblModuleleader.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		ModuleLeadertf = new JTextField();
		ModuleLeadertf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ModuleLeadertf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ModuleLeadertf.setColumns(10);
		
		lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblSemester = new JLabel("Semester:");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblCredithour = new JLabel("CreditHour:");
		lblCredithour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		Leveltf = new JTextField();
		Leveltf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		Leveltf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Leveltf.setColumns(10);
		
		Semestertf = new JTextField();
		Semestertf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		Semestertf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Semestertf.setColumns(10);
		
		CreditHouttf = new JTextField();
		CreditHouttf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		CreditHouttf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CreditHouttf.setColumns(10);
		
		Submit = new JButton("Submit");
		Submit.setBackground(new Color(0, 0, 0));
		Submit.setForeground(new Color(0, 0, 0));
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblAddCourse = new JLabel("Add Course");
		lblAddCourse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddCourse, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1034, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(Course)
									.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
									.addComponent(CourseIDtextField, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblModulename, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
									.addGap(32)
									.addComponent(Moduletf, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
											.addComponent(Leveltf, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblSemester, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
											.addComponent(Semestertf, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblCredithour, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
											.addComponent(CreditHouttf, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))))
							.addGap(341))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblModuleleader, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ModuleLeadertf, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGap(347)))
					.addComponent(Submit, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addGap(284))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAddCourse, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(Course, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(CourseIDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(19)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblModulename, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(Moduletf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblModuleleader, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(ModuleLeadertf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(Leveltf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(30))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGap(16)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(Semestertf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(44))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblSemester, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCredithour, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(CreditHouttf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(283)
							.addComponent(Submit, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
