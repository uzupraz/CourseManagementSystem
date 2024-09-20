package UIdesign;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import backend.connector;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField NametextField;
	private JTextField PhoneNotextField_2;
	private JTextField EmailtextField;
	private JTextField AddresstextField;
	private JTextField uniIDtextField;
	private JTextField userNametextField;
	private JTextField passwordTextField;
	private JTextField CpasswordTextField;
	private JPanel panel_2;
	private CardLayout cl_cardPanel= new CardLayout(0,0);
	private String UniID;
	private String UserName;
	private String Password;
	private String Name;
	private String PhoneNumber;
	private String EmailAddress;
	private String Gender;
	private String DOB;
	private String Address;
	private String Level;
	private String Semester;
	private int Id;
	private int LastInsertedId;
	private JDateChooser dateChooser;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	public String getUniID() {
		return UniID;
	}

	public String getUserName() {
		return UserName;
	}

	public String getPassword() {
		return Password;
	}

	public String getName() {
		return Name;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public String getGender() {
		return Gender;
	}

	public String getDOB() {
		return DOB;
	}

	public String getAddress() {
		return Address;
	}

	public String getLevel() {
		return Level;
	}

	public String getSemester() {
		return Semester;
	}

	public int getId() {
		return Id;
	}
	static Register frame = new Register();

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1347, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE))
		);
		
		JSplitPane splitPane = new JSplitPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
		);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(new Color(0, 0, 0));
		splitPane.setLeftComponent(imagePanel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setIcon(new ImageIcon(Register.class.getResource("/image/Hidden person-pana.png")));
		GroupLayout gl_imagePanel = new GroupLayout(imagePanel);
		gl_imagePanel.setHorizontalGroup(
			gl_imagePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_imagePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 449, Short.MAX_VALUE)
					.addGap(18))
		);
		gl_imagePanel.setVerticalGroup(
			gl_imagePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_imagePanel.createSequentialGroup()
					.addGap(174)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(205, Short.MAX_VALUE))
		);
		imagePanel.setLayout(gl_imagePanel);
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(cl_cardPanel);
		
		JPanel first = new JPanel();
		first.setBackground(new Color(131, 131, 131));
		panel_2.add(first, "name_181732992991200");
		
		JLabel lblNewLabel = new JLabel("Registration for Student");
		lblNewLabel.setFont(new Font("Perpetua", Font.BOLD, 36));
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JLabel lblDob = new JLabel("Date of Birth:");
		lblDob.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JLabel lblName_1_1 = new JLabel("Phone Number:");
		lblName_1_1.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JLabel lblName_1_2 = new JLabel("Email Address:");
		lblName_1_2.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JLabel lblName_1_2_1 = new JLabel("Address:");
		lblName_1_2_1.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		NametextField = new JTextField();
		NametextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		NametextField.setColumns(10);
		
		PhoneNotextField_2 = new JTextField();
		PhoneNotextField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		PhoneNotextField_2.setColumns(10);
		
		EmailtextField = new JTextField();
		EmailtextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		EmailtextField.setColumns(10);
		
		AddresstextField = new JTextField();
		AddresstextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		AddresstextField.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBorder(null);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Name = NametextField.getText().trim();
				DOB = (dateChooser.getDate()).toString().trim();
				PhoneNumber = PhoneNotextField_2.getText().trim();
				Address = AddresstextField.getText().trim();
				EmailAddress = EmailtextField.getText().trim();
				cl_cardPanel.show(panel_2,"name_247153338358800");
			}
		});
		btnNewButton.setFont(new Font("Perpetua", Font.PLAIN, 25));
		GroupLayout gl_first = new GroupLayout(first);
		gl_first.setHorizontalGroup(
			gl_first.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_first.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_first.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_first.createSequentialGroup()
							.addComponent(AddresstextField, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_first.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, gl_first.createSequentialGroup()
								.addComponent(lblName_1_2_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 405, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addGap(94))
							.addGroup(gl_first.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_first.createSequentialGroup()
								.addComponent(lblDob, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
								.addGap(472))
							.addGroup(gl_first.createSequentialGroup()
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
								.addGap(472))
							.addGroup(gl_first.createSequentialGroup()
								.addComponent(lblName_1_1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(648, Short.MAX_VALUE))
							.addGroup(gl_first.createSequentialGroup()
								.addComponent(PhoneNotextField_2, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
								.addGap(472))
							.addGroup(gl_first.createSequentialGroup()
								.addComponent(lblName_1_2, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(663, Short.MAX_VALUE))
							.addGroup(gl_first.createSequentialGroup()
								.addComponent(EmailtextField, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(472, Short.MAX_VALUE))
							.addGroup(gl_first.createSequentialGroup()
								.addComponent(lblName)
								.addContainerGap(766, Short.MAX_VALUE))
							.addGroup(gl_first.createSequentialGroup()
								.addComponent(NametextField, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(468, Short.MAX_VALUE)))))
		);
		gl_first.setVerticalGroup(
			gl_first.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_first.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(NametextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblName_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(PhoneNotextField_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(lblName_1_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(EmailtextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addGroup(gl_first.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_first.createSequentialGroup()
							.addComponent(lblName_1_2_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(AddresstextField, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
							.addGap(41))
						.addGroup(gl_first.createSequentialGroup()
							.addComponent(btnNewButton)
							.addContainerGap())))
		);
		first.setLayout(gl_first);
		
		JPanel third = new JPanel();
		third.setBackground(new Color(131, 131, 131));
		panel_2.add(third, "name_183512565776100");
		
		JLabel lblNewLabel_1 = new JLabel("Registration for Student");
		lblNewLabel_1.setFont(new Font("Perpetua", Font.BOLD, 36));
		
		JLabel lblName_1_1_1 = new JLabel("UNI ID:");
		lblName_1_1_1.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		uniIDtextField = new JTextField();
		uniIDtextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		uniIDtextField.setColumns(10);
		
		JLabel lblName_1_1_1_1 = new JLabel("Username:");
		lblName_1_1_1_1.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		userNametextField = new JTextField();
		userNametextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		userNametextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordTextField.setColumns(10);
		
		JLabel lblName_1_1_1_1_1 = new JLabel("Password:");
		lblName_1_1_1_1_1.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JLabel lblName_1_1_1_1_1_1 = new JLabel("Confirm Password:");
		lblName_1_1_1_1_1_1.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		CpasswordTextField = new JTextField();
		CpasswordTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		CpasswordTextField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				UniID = uniIDtextField.getText().trim();
				UserName = userNametextField.getText().trim();
				Password = passwordTextField.getText().trim();

				Statement statement = connector.getStatement();
				
String insertQuery = "INSERT INTO `logindetails`(`UserTypeId`,`UniID`, `UserName`, `Password`) VALUES ('"+3+"','"+UniID+"','"+UserName+"','"+Password+"')";
				
				try {
					int insertSuccess = statement.executeUpdate(insertQuery);
					if (insertSuccess == 1) {
						System.out.println("Success");
					}else {
						System.out.println("Failure");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


				
	
				String getStudentID = "SELECT `LoginId` FROM `logindetails` ORDER BY LoginId DESC LIMIT 1;";
				
				try {
					ResultSet resultSet = statement.executeQuery(getStudentID);
					while (resultSet.next()) {
						Id = resultSet.getInt("LoginId");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				String insertQuery2 = "INSERT INTO `studentdetails`(`StudentID`, `Name`, `Phonenumber`, `Emailaddress`, `DOB`, `Address`, `Gender`, `Level`, `Semester`) "
						+ "VALUES ('"+ Id +"','"+Name+"','"+PhoneNumber+"','"+EmailAddress+"','"+DOB+"','"+Address+"','"+Gender+"','"+Level+"','"+Semester+"')";
				
				
				try {
					int insertSuccess = statement.executeUpdate(insertQuery2);
					if(insertSuccess == 1) {
						System.out.println("Success");
					}else {
						System.out.println("Failure");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
				
				frame.setVisible(false);
				Login login = new Login();
				
			}
		});
		btnNewButton_1.setFont(new Font("Perpetua", Font.PLAIN, 25));
		GroupLayout gl_third = new GroupLayout(third);
		gl_third.setHorizontalGroup(
			gl_third.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_third.createSequentialGroup()
					.addContainerGap(244, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
					.addGap(228))
				.addGroup(gl_third.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_third.createParallelGroup(Alignment.LEADING)
						.addComponent(CpasswordTextField, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_third.createSequentialGroup()
							.addComponent(lblName_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(137))
						.addGroup(gl_third.createSequentialGroup()
							.addGroup(gl_third.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName_1_1_1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addComponent(uniIDtextField, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName_1_1_1_1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addComponent(userNametextField, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(462, Short.MAX_VALUE))))
		);
		gl_third.setVerticalGroup(
			gl_third.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_third.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
					.addGroup(gl_third.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_third.createSequentialGroup()
							.addComponent(lblName_1_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(uniIDtextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblName_1_1_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(userNametextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(lblName_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblName_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CpasswordTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(46))
						.addGroup(Alignment.TRAILING, gl_third.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(241))))
		);
		third.setLayout(gl_third);
		
		JPanel second = new JPanel();
		second.setBackground(new Color(131, 131, 131));
		panel_2.add(second, "name_247153338358800");
		
		JLabel lblName_1_1_1_2 = new JLabel("Gender :");
		lblName_1_1_1_2.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1_1 = new JLabel("Registration for Student");
		lblNewLabel_1_1.setFont(new Font("Perpetua", Font.BOLD, 36));
		
		JLabel lblName_1_1_1_2_1 = new JLabel("Level :");
		lblName_1_1_1_2_1.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JLabel lblName_1_1_1_2_2 = new JLabel("Semester");
		lblName_1_1_1_2_2.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBackground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnOther);
		rdbtnOther.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		JRadioButton level4rdbtnNewRadioButton_1 = new JRadioButton("4");
		level4rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		buttonGroup_1.add(level4rdbtnNewRadioButton_1);
		level4rdbtnNewRadioButton_1.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		JRadioButton Level5rdbtn = new JRadioButton("5");
		Level5rdbtn.setBackground(new Color(255, 255, 255));
		buttonGroup_1.add(Level5rdbtn);
		Level5rdbtn.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		JRadioButton Level6rdbtn = new JRadioButton("6");
		Level6rdbtn.setBackground(new Color(255, 255, 255));
		buttonGroup_1.add(Level6rdbtn);
		Level6rdbtn.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					Semester=((String) e.getItem()).trim();
				}
			}
		});
		comboBox.setFont(new Font("Perpetua", Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select the Semester", "1", "2", "3", "4", "5", "6"}));
		
		JButton btnNewButton_2 = new JButton("Procced");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();

					if (button.isSelected()) {
						Gender = button.getText().trim(); 
					}
				}
				
				for (Enumeration<AbstractButton> buttons = buttonGroup_1.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();

					if (button.isSelected()) {
						Level = button.getText().trim(); 
					}
				}
				
				cl_cardPanel.show(panel_2,"name_183512565776100");
			}
		});
		btnNewButton_2.setFont(new Font("Perpetua", Font.PLAIN, 30));
		GroupLayout gl_second = new GroupLayout(second);
		gl_second.setHorizontalGroup(
			gl_second.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_second.createSequentialGroup()
					.addGroup(gl_second.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_second.createSequentialGroup()
							.addGap(224)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_second.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_second.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName_1_1_1_2, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName_1_1_1_2_2, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_second.createSequentialGroup()
									.addGroup(gl_second.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_second.createSequentialGroup()
											.addComponent(level4rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(Level5rdbtn, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING, gl_second.createSequentialGroup()
											.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
											.addGap(44)
											.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
									.addGap(59)
									.addGroup(gl_second.createParallelGroup(Alignment.LEADING)
										.addComponent(Level6rdbtn, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnOther, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(248, Short.MAX_VALUE))
				.addGroup(gl_second.createSequentialGroup()
					.addContainerGap(595, Short.MAX_VALUE)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		gl_second.setVerticalGroup(
			gl_second.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_second.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addComponent(lblName_1_1_1_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_second.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnFemale)
						.addComponent(rdbtnOther))
					.addGap(81)
					.addComponent(lblName_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(gl_second.createParallelGroup(Alignment.BASELINE)
						.addComponent(level4rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(Level5rdbtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(Level6rdbtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(66)
					.addComponent(lblName_1_1_1_2_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		second.setLayout(gl_second);
		splitPane.setDividerLocation(450);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
