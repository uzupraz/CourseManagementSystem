package UIdesign;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ItemEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import backend.connector;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Login {
	
	private String userName;
	private String password;
	
	private JFrame frmLogin;
	private static JPasswordField passwordField;
	private static JTextField UserTextField;
	static String comboBoxValue ="";
	private static JLabel lblNewLabel_4;
	private static JLabel lblNewLabel_4_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public static String toString(char[] a)
    {
        // Creating object of String class
        String string = new String(a);
 
        return string;
    }
	
	public static void validate( JLabel lblNewLabel_42, JLabel lblNewLabel_4_12) {
//		if(comboBoxValue.isEmpty()) {
//			lblNewLabel_2.setVisible(true);
//			return;
//		}else {
//			lblNewLabel_2.setVisible(false);
//		}
		if(UserTextField.getText().isEmpty()) {
			lblNewLabel_4.setVisible(true);
			return;	
		}else {
			lblNewLabel_4.setVisible(false);
		}
		if(passwordField.getPassword().length == 0){
			lblNewLabel_4_1.setVisible(true);
			return;
		}else {
			lblNewLabel_4_1.setVisible(false);
		}
	}


	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBounds(new Rectangle(500, 500, 500, 500));
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(new Color(121, 121, 121));
		frmLogin.getContentPane().setForeground(new Color(255, 255, 255));
		frmLogin.setBounds(100, 100, 877, 509);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(121, 121, 121));
		panel.setBounds(0, 0, 450, 481);
		frmLogin.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/image/Hidden person-pana.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_2)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel = new JLabel("Welcome to CMS");
		lblNewLabel.setFont(new Font("Perpetua", Font.PLAIN, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(481, 0, 319, 89);
		frmLogin.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(481, 309, 319, 44);
		frmLogin.getContentPane().add(passwordField);
		
		UserTextField = new JTextField();
		UserTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		UserTextField.setBounds(481, 215, 319, 44);
		frmLogin.getContentPane().add(UserTextField);
		UserTextField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Log in!");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Perpetua", Font.PLAIN, 28));
		lblLogin.setBounds(481, 51, 319, 51);
		frmLogin.getContentPane().add(lblLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Username or Email :");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(481, 190, 149, 22);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(481, 285, 149, 22);
		frmLogin.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.addActionListener(new ActionListener() {
			private String db_userName;
			private String db_password;
			private String uniID;
			private String LoginId;
			private int userTyprId;

			public void actionPerformed(ActionEvent e) {
				
				
				validate(lblNewLabel_4,lblNewLabel_4_1);
 
				userName = UserTextField.getText().trim();
				password = new String(passwordField.getPassword());
				Statement statement = connector.getStatement();					
				String getData = "SELECT * FROM `logindetails` WHERE Username = '"+userName+"' AND Password = '"+password+"';";
				
				
				try {
					int flag = 0;
					ResultSet resultSet = statement.executeQuery(getData);
					while (resultSet.next()) {
						String db_userName = resultSet.getString("Username").trim();
						String db_password = resultSet.getString("Password").trim();
						LoginId = resultSet.getBigDecimal("LoginId").toString();
						
						userTyprId = resultSet.getInt("UserTypeId");
						if (db_userName.equals(userName) && db_password.equals(password)) {
							if(userTyprId==1) 
							{
								AdminDashboard window = new AdminDashboard();
								frmLogin.dispose();
								flag = 1;
							}
							else if(userTyprId==2)
							{
								Teacher window = new Teacher();
								frmLogin.dispose();
								flag = 1;
							}
							else if(userTyprId==3)
							{
								uniID = resultSet.getBigDecimal("UniID").toString();
								Student window = new Student();
								window.setStudentID(LoginId);
								window.setUniID(uniID);
								frmLogin.dispose();
								flag = 1;
							}
							
						}
					}
					if (flag == 0) {
						System.out.println("User Not Found");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
		}
		});
		
		btnNewButton.setBounds(481, 382, 130, 44);
		frmLogin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.setVisible(true);
				frmLogin.dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setBounds(670, 382, 130, 44);
		frmLogin.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_4 = new JLabel("Invalid Username");
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setBounds(481, 262, 110, 13);
		frmLogin.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_4_1 = new JLabel("Invalid Password");
		lblNewLabel_4_1.setVisible(false);
		lblNewLabel_4_1.setForeground(Color.RED);
		lblNewLabel_4_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(481, 359, 110, 13);
		frmLogin.getContentPane().add(lblNewLabel_4_1);
		frmLogin.setVisible(true);
		
		
	
	}
}
