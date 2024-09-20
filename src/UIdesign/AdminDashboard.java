package UIdesign;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.CourseQuery;
import backend.ModuleQuery;
import backend.StudentQuery;
import backend.SubmissionQuery;
import backend.TeacherQuery;

import backend.connector;

import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

public class AdminDashboard{
	private static ResultSet resultSet;
	private JFrame frmAdminPanel;
	private CardLayout cl_cardPanel= new CardLayout(0,0);
	private JPanel cardPanel;
	private JTable Logtable;
	private JTable table_1;
	private JTable TeacherTable;
	private JTable CourseTable;
	private int selectedRow;
	private static DefaultTableModel TeacherModal= new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"TeacherID", "Name", "DOB", "PhoneNumber", "Address", "Email Address", "Module", "Qualification", "Position", "Gender"
			}
		);

	private static DefaultTableModel SubmissionModal= new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"SubmissionID", "AssignmentID", "Module", "StudentID" , "UniID" , "StudentName" ,"Question", "Answer" , "Marks","Status","Published"
			}
		);
	
	private static DefaultTableModel StudentModal= new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"StudentDetailsID", "StudentID", "Name", "Phonenumber" , "Emailaddress" , "DOB" ,"Address", "Gender" , "Level","Semester",
			}
		);
	
	
	private static DefaultTableModel CourseModal= new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"CourseID", "CourseName", "CourseDescription", "NoOfModules", "Status", "Duration"
			}
		);
	
	private static DefaultTableModel ModuleModal= new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"ModuleID", "CourseID", "ModuleName", "ModuleLeader", "Level", "Semester","CreditHour"
			}
		);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
					window.frmAdminPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminDashboard() {
		initialize();
	}
	
	public static void getCourseData() throws SQLException {
		
		
		
		 resultSet = CourseQuery.SelectQuery();
		
		
		while (resultSet.next()) {
			int CourseID = resultSet.getInt("CourseID");
			String CourseName = resultSet.getString("Coursename");
			String CourseDesc = resultSet.getString("CourseDescription");
			String NoofModules = resultSet.getString("NoofModules");
			String Status = resultSet.getString("Status");
			String Duration = resultSet.getString("Duration");
			CourseModal.addRow(new Object[] {
					CourseID,
					CourseName,
					CourseDesc,
					NoofModules,
					Status,
					Duration,
			});
		}
	}
	
	public static void getStudentData() throws SQLException {
		
		
		
		 resultSet = StudentQuery.selectQuery();
		
		
		while (resultSet.next()) {
			String StudentDetails = resultSet.getString("StudentDetailsId");
			String StudentID = resultSet.getString("StudentID");
			String Name = resultSet.getString("Name");
			String Phonenumber = resultSet.getString("Phonenumber");
			String Emailaddress = resultSet.getString("Emailaddress");
			String DOB = resultSet.getString("DOB");
			String Address = resultSet.getString("Address");
			String Gender = resultSet.getString("Gender");
			String Level = resultSet.getString("Level");
			String Semester = resultSet.getString("Semester");
			StudentModal.addRow(new Object[] {
					StudentDetails,
					StudentID,
					Name,
					Phonenumber,
					Emailaddress,
					DOB,
					Address,
					Gender,
					Level,
					Semester,
			});
		}
	}

	
	public static void getModuleData() throws SQLException{
		resultSet = ModuleQuery.SelectQuery();
		
		while (resultSet.next()) {
			int ModuleID = resultSet.getInt("ModuleID");
			int CourseID = resultSet.getInt("CourseID");
			String ModuleName = resultSet.getString("ModuleName");
			String ModuleLeader = resultSet.getString("Module Leader");
			String Level = resultSet.getString("Level");
			String Semester = resultSet.getString("Semester");
			String Credithour = resultSet.getString("Credithour");
			ModuleModal.addRow(new Object[] {
					ModuleID,
					CourseID,
					ModuleName,
					ModuleLeader,
					Level,
					Semester,
					Credithour,
			});
		}
		
		
	}
	
	public static void getSubmssionData() throws SQLException{
		ResultSet resultSet = SubmissionQuery.SelectQuery();
		
		
		while (resultSet.next()) {
			int SubmissionID = resultSet.getInt("SubmissionID");
			int AssignmentID = resultSet.getInt("AssignmentID");
			String Module = resultSet.getString("Module");
			int StudentID = resultSet.getInt("StudentID");
			int UniID = resultSet.getInt("UniID");
			String StudentName = resultSet.getString("StudentName");
			String Question = resultSet.getString("Question");
			String Answer = resultSet.getString("Answer");
			String Marks = resultSet.getString("Marks");
			String Status = resultSet.getString("Status");
			String Published = resultSet.getString("Published");
			SubmissionModal.addRow(new Object[] {
					SubmissionID,
					AssignmentID,
					Module,
					StudentID,
					UniID,
					StudentName,
					Question,
					Answer,
					Marks,
					Status,
					Published,
			});
		}
		
		
	}
	public static void getTeacherData() throws SQLException {
		resultSet = TeacherQuery.SelectQuery();
			
			while (resultSet.next()) {
				String TeacherID = resultSet.getString("TeacherID");
				String Name = resultSet.getString("Name");
				String DOB = resultSet.getString("DOB");
				String PhoneNumber = resultSet.getString("PhoneNumber");
				String Address = resultSet.getString("Address");
				String EmailAddress = resultSet.getString("EmailAddress");
				String Module = resultSet.getString("Module");
				String Qualification = resultSet.getString("Qualification");
				String Position = resultSet.getString("Position");
				String Gender = resultSet.getString("Gender");
				TeacherModal.addRow(new Object[] {
						TeacherID,
						Name,
						DOB,
						PhoneNumber,
						Address,
						EmailAddress,
						Module,
						Qualification,
						Position,
						Gender,
				});
			}
		}
		
				
;
		

	private JTable ModuleTable;
	private JTable Studenttable;
	private JTable StudentTable;
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminPanel = new JFrame();
		frmAdminPanel.setTitle("Admin Panel");
		frmAdminPanel.setBounds(100, 100, 1228, 592);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(new Color(121, 121, 121));
		splitPane.setDividerSize(0);
		frmAdminPanel.setContentPane(splitPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(107, 106, 107));
		splitPane.setLeftComponent(panel);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBorder(null);
		btnNewButton.setIconTextGap(35);
		btnNewButton.setIcon(new ImageIcon(AdminDashboard.class.getResource("/image/home.png")));
		btnNewButton.setFont(new Font("Perpetua", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel,"name_219236766039800");
			}
		});
		btnNewButton.setFocusCycleRoot(true);
		btnNewButton.setSelectedIcon(new ImageIcon("\\Downloads\\home.png"));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		
		JButton btnNewButton_1 = new JButton("Course");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIconTextGap(35);
		btnNewButton_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/image/online-learning.png")));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Perpetua", Font.PLAIN, 25));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel,"name_654837823487100");
			}
		});
		
		JButton btnNewButton_2 = new JButton("Student");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setIconTextGap(35);
		btnNewButton_2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/image/gear.png")));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Perpetua", Font.PLAIN, 25));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel,"name_80093103572000");
			}
		});
		
		JButton btnNewButton_3 = new JButton("Log out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminPanel.dispose();
				Login login = new Login();
			}
		});
		btnNewButton_3.setFont(new Font("Perpetua", Font.PLAIN, 25));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(37, 38, 39));
		
		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("\\eclipse-workspace\\cms\\src\\image\\user2.png"));
		
		JButton btnNewButton_1_1 = new JButton("Teacher");
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel,"name_219288303900400");
				
			}
		});
		btnNewButton_1_1.setIconTextGap(35);
		btnNewButton_1_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/image/training.png")));
		btnNewButton_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1.setFont(new Font("Perpetua", Font.PLAIN, 25));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		
		JButton btnNewButton_1_1_1 = new JButton("Report");
		btnNewButton_1_1_1.setBorder(null);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel,"name_1777422482600");
				SubmissionModal.setRowCount(0);
				try {
					getSubmssionData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/image/notepad.png")));
		btnNewButton_1_1_1.setIconTextGap(35);
		btnNewButton_1_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1_1.setFont(new Font("Perpetua", Font.PLAIN, 25));
		btnNewButton_1_1_1.setBackground(new Color(255, 255, 255));
		
		JButton btnNewButton_1_1_2 = new JButton("Module");
		btnNewButton_1_1_2.setBorder(null);
		btnNewButton_1_1_2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/image/plus.png")));
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel,"name_745223977780800");
			}
		});
		btnNewButton_1_1_2.setIconTextGap(35);
		btnNewButton_1_1_2.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1_2.setFont(new Font("Perpetua", Font.PLAIN, 25));
		btnNewButton_1_1_2.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addComponent(lblDashboard)
					.addGap(36))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(55)
					.addComponent(lblNewLabel)
					.addContainerGap(59, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_3)
					.addGap(2)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDashboard, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setBorder(null);
		splitPane_1.setLeftComponent(splitPane_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(134, 136, 137));
		splitPane_2.setLeftComponent(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Students");
		lblNewLabel_1.setFont(new Font("Perpetua", Font.PLAIN, 26));
		
		JLabel lblNewLabel_5 = new JLabel("102");
		lblNewLabel_5.setFont(new Font("Perpetua", Font.BOLD, 50));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(78)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(103)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addComponent(lblNewLabel_5)
					.addGap(18))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		splitPane_2.setRightComponent(panel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Teachers");
		lblNewLabel_1_1.setFont(new Font("Perpetua", Font.PLAIN, 28));
		
		JLabel lblNewLabel_5_1 = new JLabel("30");
		lblNewLabel_5_1.setFont(new Font("Perpetua", Font.BOLD, 50));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("\\eclipse-workspace\\cms\\src\\image\\Teacher-icon.png"));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(144)
					.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1_1)
					.addGap(60))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(19)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel_1_1))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		splitPane_2.setDividerLocation(450);
		
		cardPanel = new JPanel();
		cardPanel.setBackground(new Color(57, 57, 57));
		splitPane_1.setRightComponent(cardPanel);
		cardPanel.setLayout(cl_cardPanel);
		
		JPanel dashboard = new JPanel();
		dashboard.setBackground(new Color(120, 120, 120));
		cardPanel.add(dashboard, "name_219236766039800");
		
		JLabel lblNewLabel_6 = new JLabel("Dashboard");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setBorder(null);
		GroupLayout gl_dashboard = new GroupLayout(dashboard);
		gl_dashboard.setHorizontalGroup(
			gl_dashboard.createParallelGroup(Alignment.TRAILING)
				.addComponent(splitPane_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_dashboard.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_6)
					.addContainerGap(884, Short.MAX_VALUE))
		);
		gl_dashboard.setVerticalGroup(
			gl_dashboard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dashboard.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_6)
					.addGap(10)
					.addComponent(splitPane_3, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(null);
		splitPane_3.setLeftComponent(panel_3);
		
		JLabel lblNewLabel_7 = new JLabel("Log History");
		lblNewLabel_7.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addComponent(lblNewLabel_7))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		Logtable = new JTable();
		Logtable.setShowHorizontalLines(false);
		Logtable.setShowVerticalLines(false);
		Logtable.setBackground(new Color(255, 255, 255));
		Logtable.setModel(new DefaultTableModel(
			new Object[][] {
				{"12:45 AM", "Juja Logged in"},
				{"1:45 AM", "Assignement portal open"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Time", "Activity"
			}
		));
		scrollPane.setViewportView(Logtable);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		splitPane_3.setRightComponent(panel_4);
		
		JLabel lblNewLabel_7_1 = new JLabel("Feedbacks");
		lblNewLabel_7_1.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
						.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_7_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table_1 = new JTable();
		table_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table_1.setShowGrid(false);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Free Food chayo", "npcs54H432432", "Sakar Shrestha"},
				{"I dont know", "npcdgo225ndfi3", "Muskan Shrestha"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Feedback", "StudentID", "StudentName"
			}
		));
		scrollPane_1.setViewportView(table_1);
		panel_4.setLayout(gl_panel_4);
		splitPane_3.setDividerLocation(450);
		dashboard.setLayout(gl_dashboard);
		
		JPanel teacher = new JPanel();
		teacher.setBackground(new Color(255, 255, 255));
		cardPanel.add(teacher, "name_219288303900400");
		
		JLabel Teacher = new JLabel("Teacher Management");
		Teacher.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBackground(new Color(255, 255, 255));
		
		JButton btnAddTeachers = new JButton("Add teacher");
		btnAddTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminPanel.dispose();
				TeacherModal.setRowCount(0);
				Addteacher window = new Addteacher();
				window.setVisible(true);
				
			}
		});
		btnAddTeachers.setIcon(new ImageIcon("\\Downloads\\add-user.png"));
		btnAddTeachers.setIconTextGap(15);
		btnAddTeachers.setForeground(new Color(0, 0, 0));
		btnAddTeachers.setFont(new Font("Perpetua", Font.PLAIN, 25));
		btnAddTeachers.setFocusCycleRoot(true);
		btnAddTeachers.setBackground(new Color(208, 252, 179));
		GroupLayout gl_teacher = new GroupLayout(teacher);
		gl_teacher.setHorizontalGroup(
			gl_teacher.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_teacher.createSequentialGroup()
					.addGroup(gl_teacher.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_teacher.createSequentialGroup()
							.addGap(378)
							.addComponent(Teacher))
						.addGroup(gl_teacher.createSequentialGroup()
							.addGap(395)
							.addComponent(btnAddTeachers, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_teacher.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_teacher.setVerticalGroup(
			gl_teacher.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_teacher.createSequentialGroup()
					.addGap(21)
					.addComponent(Teacher)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAddTeachers, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		
		TeacherTable = new JTable();
		TeacherTable.setBackground(new Color(255, 255, 255));
		TeacherTable.addMouseListener(new MouseAdapter() {
			private ResultSet tId;

			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options= {"Update","Delete"};
				int selecterOption=JOptionPane.showOptionDialog(null, "Do you want to update or delete?", "Update or delete teacher",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
				selectedRow = TeacherTable.getSelectedRow();
				if(selecterOption==0) {
					HashMap<String , String> updateData = new HashMap<>();
					TeacherForm form = new TeacherForm();
					form.setVisible(true);		
					for(int i=1;i<TeacherTable.getColumnCount();i++) {
						String data =  TeacherTable.getValueAt(selectedRow, i).toString();
						if(form.getNametf().getText().isEmpty()) {
							form.getNametf().setText(data);
							
						}else if(form.getDOBtextField().getText().isEmpty()) {
							
							form.getDOBtextField().setText(data);
							
						}else if(form.getPhonetf().getText().isEmpty()) {
							
							form.getPhonetf().setText(data);
							
						}else if(form.getAddresstf().getText().isEmpty()) {
							form.getAddresstf().setText(data);
						}
						else if(form.getEmailtf().getText().isEmpty()) {
							form.getEmailtf().setText(data);
						}	
						else if(form.getCoursetf().getText().isEmpty()) {
							form.getCoursetf().setText(data);
						}
						else if(form.getQualificationtf().getText().isEmpty()) {
							form.getQualificationtf().setText(data);
						}
						else if(form.getPositiontf().getText().isEmpty()) {
							form.getPositiontf().setText(data);
					
					}
						else if(form.getGendertf().getText().isEmpty()) {
							form.getGendertf().setText(data);
					
					}
						JButton updatebtn = form.getUpdate();
						updatebtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String TeacherId = TeacherTable.getValueAt(selectedRow,0).toString();
								updateData.put("TeacherId",TeacherId);
								updateData.put("Name", form.getNametf().getText());
								updateData.put("DOB", form.getDOBtextField().getText());
								updateData.put("PhoneNumber", form.getPhonetf().getText());
								updateData.put("Address", form.getAddresstf().getText());
								updateData.put("EmailAddress", form.getEmailtf().getText());
								updateData.put("Module", form.getCoursetf().getText());
								updateData.put("Qualification", form.getQualificationtf().getText());
								updateData.put("Position", form.getPositiontf().getText());
								updateData.put("Gender", form.getGendertf().getText());
								TeacherModal.setRowCount(0);
								TeacherQuery.UpdateQuery(updateData);
								form.setVisible(false);
								try {
									getTeacherData();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						
					}
				}else if (selecterOption==1) {
					Object[] comfirm= {"Yes","No"};
					int confirm=JOptionPane.showOptionDialog(null, "Are you sure you want to delete?", "Confirm",
							JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,comfirm,comfirm[0]);
					if(confirm ==0) {
					
					Statement statement = connector.getStatement();
			
					String Id = null;
					String TeacherId = TeacherTable.getValueAt(selectedRow,0).toString();
					
					
					String selectQuery1 = "SELECT `TeacherDetailsID` FROM `teacherDetails` WHERE TeacherID = '"+TeacherId+"'";
					
					try {
						tId = statement.executeQuery(selectQuery1);
						while (tId.next()) {
							Id = tId.getString("TeacherDetailsID");
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					String deleteQuery = "DELETE FROM `teacherdetails` WHERE TeacherDetailsID = '"+Id+"';";
					try {
						int deleteSuccess = statement.executeUpdate(deleteQuery);
						if (deleteSuccess == 1) {
							System.out.println("Deleted");
						}else {
							System.out.println("Not deleted");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
					String deleteQuery1 = "DELETE FROM `teacher` WHERE TeacherID = '"+TeacherId+"'";
					int deleteSuccess;
					try {
						deleteSuccess = statement.executeUpdate(deleteQuery1);
						if (deleteSuccess == 1) {
							System.out.println("Deleted");
						}else {
							System.out.println("Not deleted");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					TeacherModal.removeRow(TeacherTable.getSelectedRow());
				
					}
				}
			}
		});
		TeacherTable.setDefaultEditor(Object.class, null);
		TeacherTable.setModel(TeacherModal);
		TeacherTable.getColumnModel().getColumn(2).setPreferredWidth(95);
		TeacherTable.getColumnModel().getColumn(3).setPreferredWidth(124);
		scrollPane_2.setViewportView(TeacherTable);
		panel.setLayout(gl_panel);
		teacher.setLayout(gl_teacher);
		
		JPanel courses = new JPanel();
		courses.setBackground(new Color(255, 255, 255));
		cardPanel.add(courses, "name_654837823487100");
		
		JLabel lblNewLabel_8 = new JLabel("Course Management");
		lblNewLabel_8.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(null);
		scrollPane_3.setBackground(new Color(255, 255, 255));
		
		JButton btnNewButton_2_1 = new JButton("Add Course");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseForm addCourse = new CourseForm();
				addCourse.setVisible(true);
				
				JButton submit = addCourse.getBtnSubmit();
				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HashMap<String,String> addData = new HashMap<>();
						String Coursename = addCourse.getCoursetf().getText();
						String CourseDes = addCourse.getCourseDestf().getText();
						String NoOfModules = addCourse.getNomoduletf().getText();
						String Duration = addCourse.getDurationtf().getText();
	
						String Status = CourseForm.getStatus();
						
						addData.put("Coursename", Coursename);
						addData.put("CourseDes", CourseDes);
						addData.put("NoOfModules", NoOfModules);
						addData.put("Status", Status);
						addData.put("Duration", Duration);
						CourseModal.setRowCount(0);
						CourseQuery.InsertQuery(addData);
						try {
							getCourseData();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						addCourse.setVisible(false);
					}
				});
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon("\\Downloads\\plus.png"));
		btnNewButton_2_1.setIconTextGap(15);
		btnNewButton_2_1.setForeground(new Color(0, 0, 0));
		btnNewButton_2_1.setFont(new Font("Perpetua", Font.PLAIN, 25));
		btnNewButton_2_1.setBackground(new Color(0, 0, 0));
		GroupLayout gl_courses = new GroupLayout(courses);
		gl_courses.setHorizontalGroup(
			gl_courses.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_courses.createSequentialGroup()
					.addGroup(gl_courses.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_courses.createSequentialGroup()
							.addGap(342)
							.addComponent(lblNewLabel_8))
						.addGroup(gl_courses.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE))
						.addGroup(gl_courses.createSequentialGroup()
							.addGap(409)
							.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_courses.setVerticalGroup(
			gl_courses.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_courses.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel_8)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		
		CourseTable = new JTable();
		CourseTable.setShowGrid(false);
		CourseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options= {"Update","Delete"};
				int selecterOption=JOptionPane.showOptionDialog(null, "Do you want to update or delete?", "Update or delete teacher",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
				int selectedRow1 = CourseTable.getSelectedRow();
				if (selecterOption == 0) {
					HashMap <String, String> updateData = new HashMap<>();
					CourseForm updateForm = new CourseForm();
					updateForm.setVisible(true);
					updateForm.setTitle("Update Course Form");
					
					for(int i=1;i<CourseTable.getColumnCount();i++) {
						if (i != 4) {
						String data =  CourseTable.getValueAt(selectedRow1, i).toString();
						if(updateForm.getCoursetf().getText().isEmpty()) {
							
							updateForm.getCoursetf().setText(data);
											
						}else if(updateForm.getCourseDestf().getText().isEmpty()) {
							
							updateForm.getCourseDestf().setText(data);
							
							
						}else if(updateForm.getNomoduletf().getText().isEmpty()) {
							
							updateForm.getNomoduletf().setText(data);
						}
						else if(updateForm.getDurationtf().getText().isEmpty()) {
							updateForm.getDurationtf().setText(data);
							
						}	
						}
			
					}
					JButton submit = updateForm.getBtnSubmit();
					submit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String CourseID = CourseTable.getValueAt(selectedRow1, 0).toString();
							updateData.put("CourseID", CourseID);
							updateData.put("CourseName", updateForm.getCoursetf().getText());
							updateData.put("CourseDes", updateForm.getCourseDestf().getText());
							updateData.put("No of modules", updateForm.getNomoduletf().getText());
							updateData.put("Status", CourseForm.getStatus());
							updateData.put("Duration", updateForm.getDurationtf().getText());
							CourseQuery.UpdateQuery(updateData);
							CourseModal.setRowCount(0);
							updateForm.setVisible(false);
							try {
								getCourseData();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					});
					
				}
				else if (selecterOption==1) {
					Object[] comfirm= {"Yes","No"};
					int confirm=JOptionPane.showOptionDialog(null, "Are you sure you want to delete?", "Confirm",
							JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,comfirm,comfirm[0]);
					if(confirm ==0) {
					HashMap <String,String> deleteData = new HashMap<>();
					String Id = CourseTable.getValueAt(selectedRow1,0).toString();
					CourseModal.removeRow(CourseTable.getSelectedRow());
					deleteData.put("ID",Id);
					CourseQuery.DeleteQuery(deleteData);
				
					}
				}
			}
			
		});
		CourseTable.setEnabled(true);
		TeacherTable.setDefaultEditor(Object.class, null);
		CourseTable.setModel(CourseModal);
		CourseTable.getColumnModel().getColumn(2).setPreferredWidth(107);
		CourseTable.getColumnModel().getColumn(4).setPreferredWidth(99);
		scrollPane_3.setViewportView(CourseTable);
		courses.setLayout(gl_courses);
		
		JPanel Module = new JPanel();
		Module.setBackground(new Color(255, 255, 255));
		cardPanel.add(Module, "name_745223977780800");
		
		JLabel lblNewLabel_11 = new JLabel("Module");
		lblNewLabel_11.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBackground(new Color(255, 255, 255));
		
		JButton btnNewButton_2_1_1 = new JButton("Add Module");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String,String> addData = new HashMap<>();
				ModuleForm insertForm = new ModuleForm();
				insertForm.setVisible(true);
				
				JButton submit = insertForm.getSubmit();
				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String CourseID = insertForm.getCourseIDtextField().getText();
						String ModuleName = insertForm.getModuletf().getText();
						String ModuleLeader = insertForm.getModuleLeadertf().getText();
						String Level = insertForm.getLeveltf().getText();
						String Semester =insertForm.getSemestertf().getText();
						String CreditHour = insertForm.getCreditHouttf().getText();
						
						
						addData.put("CourseID", CourseID);
						addData.put("ModuleName", ModuleName);
						addData.put("ModuleLeader", ModuleLeader);
						addData.put("Level", Level);
						addData.put("Semester", Semester);
						addData.put("CreditHour", CreditHour);
						
						
						
						
						ModuleModal.setRowCount(0);
						ModuleQuery.InsertQuery(addData);
						try {
							getModuleData();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
			}
		});
		btnNewButton_2_1_1.setIconTextGap(15);
		btnNewButton_2_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_2_1_1.setFont(new Font("Perpetua", Font.PLAIN, 25));
		btnNewButton_2_1_1.setBackground(new Color(0, 0, 0));
		GroupLayout gl_Module = new GroupLayout(Module);
		gl_Module.setHorizontalGroup(
			gl_Module.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Module.createSequentialGroup()
					.addGroup(gl_Module.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Module.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE))
						.addGroup(gl_Module.createSequentialGroup()
							.addGap(415)
							.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(gl_Module.createSequentialGroup()
					.addContainerGap(401, Short.MAX_VALUE)
					.addComponent(btnNewButton_2_1_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(390))
		);
		gl_Module.setVerticalGroup(
			gl_Module.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Module.createSequentialGroup()
					.addGap(17)
					.addComponent(lblNewLabel_11)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_2_1_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		ModuleTable = new JTable();
		ModuleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options= {"Update","Delete"};
				int selecterOption=JOptionPane.showOptionDialog(null, "Do you want to update or delete?", "Update or delete teacher",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
				int selectedRow1 = ModuleTable.getSelectedRow();
				if (selecterOption == 0) {
					HashMap<String , String> updateData = new HashMap<>();
					ModuleForm updateForm = new ModuleForm();
					updateForm.setVisible(true);
					updateForm.setTitle("Update Module Form");
					
					for(int i=1;i<ModuleTable.getColumnCount();i++) {
						String data =  ModuleTable.getValueAt(selectedRow1, i).toString();
						if(updateForm.getCourseIDtextField().getText().isEmpty()) {
							
							updateForm.getCourseIDtextField().setText(data);
							
							
						}else if(updateForm.getModuletf().getText().isEmpty()) {
							
							updateForm.getModuletf().setText(data);
							
							
						}else if(updateForm.getModuleLeadertf().getText().isEmpty()) {
							
							updateForm.getModuleLeadertf().setText(data);
							
							
						}else if(updateForm.getLeveltf().getText().isEmpty()) {
							updateForm.getLeveltf().setText(data);
							
						}
						else if(updateForm.getSemestertf().getText().isEmpty()) {
							updateForm.getSemestertf().setText(data);
							
						}
						else if(updateForm.getCreditHouttf().getText().isEmpty()) {
							updateForm.getCreditHouttf().setText(data);
							
						}	
					}
					
					JButton submit = updateForm.getSubmit();
					submit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String ModuleID = ModuleTable.getValueAt(selectedRow1, 0).toString();
							updateData.put("ModuleID", ModuleID);
							updateData.put("CourseID", updateForm.getCourseIDtextField().getText());
							updateData.put("ModuleName", updateForm.getModuletf().getText());
							updateData.put("ModuleLeader", updateForm.getModuleLeadertf().getText());
							updateData.put("Level", updateForm.getLeveltf().getText());
							updateData.put("Semester", updateForm.getSemestertf().getText());
							updateData.put("CreditHour", updateForm.getCreditHouttf().getText());
							ModuleModal.setRowCount(0);
							ModuleQuery.UpdateQuery(updateData);
							try {
								getModuleData();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							updateForm.setVisible(false);
							
						}


					});
					
					
					
					

					
				}
				else if (selecterOption==1) {
					Object[] comfirm= {"Yes","No"};
					int confirm=JOptionPane.showOptionDialog(null, "Are you sure you want to delete?", "Confirm",
							JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,comfirm,comfirm[0]);
					if(confirm ==0) {
					HashMap <String,String> deleteData = new HashMap<>();
					
					String Id = ModuleTable.getValueAt(selectedRow1,0).toString();
					ModuleModal.removeRow(ModuleTable.getSelectedRow());
					deleteData.put("ID",Id);
					ModuleQuery.DeleteQuery(deleteData);
				
					}
				}
			}
		});
		scrollPane_4.setViewportView(ModuleTable);
		ModuleTable.setModel(ModuleModal);
		Module.setLayout(gl_Module);
		
		JPanel Result = new JPanel();
		Result.setBackground(new Color(255, 255, 255));
		cardPanel.add(Result, "name_1777422482600");
		
		JLabel lblNewLabel_12 = new JLabel("Student Data");
		lblNewLabel_12.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBackground(new Color(255, 255, 255));
		GroupLayout gl_Result = new GroupLayout(Result);
		gl_Result.setHorizontalGroup(
			gl_Result.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Result.createSequentialGroup()
					.addGroup(gl_Result.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Result.createSequentialGroup()
							.addGap(400)
							.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Result.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_Result.setVerticalGroup(
			gl_Result.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Result.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		Studenttable = new JTable();
		Studenttable.setBackground(new Color(255, 255, 255));
		Studenttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] Action= {"Publish Marks","Cancel"};
				int selectedAction=JOptionPane.showOptionDialog(null, "Are you sure you want to delete?", "Confirm",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,Action,Action[0]);
				int selectedRow = Studenttable.getSelectedRow();
				String StudentID = null;
				if (selectedAction == 0) {
					StudentID = Studenttable.getValueAt(selectedRow, 3).toString().trim();
					SubmissionQuery.PublishQuery(StudentID);
					SubmissionModal.setRowCount(0);
					try {
						getSubmssionData();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		Studenttable.setModel(SubmissionModal);
		scrollPane_5.setViewportView(Studenttable);
		Result.setLayout(gl_Result);
		
		JPanel Student = new JPanel();
		Student.setBackground(new Color(255, 255, 255));
		cardPanel.add(Student, "name_80093103572000");
		
		JLabel lblNewLabel_9 = new JLabel("Student");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBackground(new Color(255, 255, 255));
		GroupLayout gl_Student = new GroupLayout(Student);
		gl_Student.setHorizontalGroup(
			gl_Student.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Student.createSequentialGroup()
					.addGroup(gl_Student.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Student.createSequentialGroup()
							.addGap(396)
							.addComponent(lblNewLabel_9))
						.addGroup(gl_Student.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_Student.setVerticalGroup(
			gl_Student.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Student.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNewLabel_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		
		StudentTable = new JTable();
		StudentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options= {"Update","Delete"};
				int selecterOption=JOptionPane.showOptionDialog(null, "Do you want to update or delete?", "Update or delete teacher",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
				int selectedRow = StudentTable.getSelectedRow();
				if (selecterOption == 0) {
					HashMap<String , String> updateData = new HashMap<>();
					StudentForm form = new StudentForm();
					form.setVisible(true);
					form.setTitle("Update Studnet Form");
					
					for(int i=8;i<StudentTable.getColumnCount();i++) {
						String data =  StudentTable.getValueAt(selectedRow, i).toString();
						if(form.getLeveltf().getText().isEmpty()) {
							
							form.getLeveltf().setText(data);
							
							
						}else if(form.getSemesterTf().getText().isEmpty()) {
							
							form.getSemesterTf().setText(data);
							
						}
						
					}
					JButton submit = form.getBtnNewButton();
					submit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String StudentDetailsID = StudentTable.getValueAt(selectedRow,0).toString();
							updateData.put("StudentDetailsID", StudentDetailsID);
							updateData.put("Level", form.getLeveltf().getText());
							updateData.put("Semester", form.getSemesterTf().getText());
							StudentModal.setRowCount(0);
							StudentQuery.UpdateQuery(updateData);
							try {
								getStudentData();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							form.setVisible(false);
							
						}


					});
					

					
					
					
				} else if (selecterOption == 1 ) {
					Object[] comfirm= {"Yes","No"};
					int confirm=JOptionPane.showOptionDialog(null, "Are you sure you want to delete?", "Confirm",
							JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,comfirm,comfirm[0]);
					if(confirm ==0) {
					
					Statement statement = connector.getStatement();
			

					String StudentId = StudentTable.getValueAt(selectedRow,1).toString();
					String StudentDetailsID = StudentTable.getValueAt(selectedRow,0).toString();
					
					String deleteQuery = "DELETE FROM `studentdetails` WHERE StudentDetailsID = '"+StudentDetailsID+"';";
					try {
						int deleteSuccess = statement.executeUpdate(deleteQuery);
						if (deleteSuccess == 1) {
							System.out.println("Deleted");
						}else {
							System.out.println("Not deleted");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
					String deleteQuery1 = "DELETE FROM `student` WHERE StudentID = '"+StudentId+"'";
					int deleteSuccess;
					try {
						deleteSuccess = statement.executeUpdate(deleteQuery1);
						if (deleteSuccess == 1) {
							System.out.println("Deleted");
						}else {
							System.out.println("Not deleted");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					StudentModal.removeRow(selectedRow);
					}
				}
			}
		});
		StudentTable.setModel(StudentModal);
		scrollPane_6.setViewportView(StudentTable);
		Student.setLayout(gl_Student);
		splitPane_1.setDividerLocation(100);
		splitPane.setDividerLocation(200);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPanel.setVisible(true);
		
		try {
			getTeacherData();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			getCourseData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			getModuleData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			getStudentData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
