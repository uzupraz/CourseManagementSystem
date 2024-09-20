package UIdesign;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.AssignmentQuery;
import backend.ModuleQuery;
import backend.SubmissionQuery;

import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

public class Teacher {

	private JFrame frame;
	private JTable SubmissionTable;
	private JTable AssignmentTable;
	private CardLayout cl_CardPanel= new CardLayout(0,0);
	private JPanel cardPanel;
	
	private static DefaultTableModel AssignmentModel= new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"AssignmentID", "Question", "Module"
			}
		);
	
	private static DefaultTableModel SubmissionModal= new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"SubmissionID", "AssignmentID", "Module", "StudentID" , "UniID" , "StudentName" ,"Question", "Answer" , "Marks"
			}
		);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher window = new Teacher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Teacher() {
		initialize();
	}
	
	public static void getAssignemntData() throws SQLException{
		ResultSet resultSet = AssignmentQuery.SelectQuery();
		
		
		while (resultSet.next()) {
			int AssignmentID = resultSet.getInt("AssignmentID");
			String Question = resultSet.getString("Question");
			String Module = resultSet.getString("Module");
			AssignmentModel.addRow(new Object[] {
					AssignmentID,
					Question,
					Module,
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
			});
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1344, 765);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1330, 728);
		frame.getContentPane().add(panel);
		
		JSplitPane splitPane = new JSplitPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 1330, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(134, 136, 137));
		splitPane.setLeftComponent(panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Teacher.class.getResource("/image/Teacher-icon.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Teacher");
		lblNewLabel_1.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JButton btnHome = new JButton("Home");
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setBorder(null);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_CardPanel.show(cardPanel,"name_774669064080200");
			}
		});
		btnHome.setFont(new Font("Perpetua", Font.PLAIN, 25));
		 
		JButton btnSetting_1_1 = new JButton("Assignment");
		btnSetting_1_1.setBorder(null);
		btnSetting_1_1.setBackground(new Color(255, 255, 255));
		btnSetting_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_CardPanel.show(cardPanel,"name_774932147097300");
			}
		});
		btnSetting_1_1.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login login = new Login();
			}
		});
		btnLogout.setForeground(new Color(0, 0, 0));
		btnLogout.setBackground(new Color(0, 0, 0));
		btnLogout.setFont(new Font("Perpetua", Font.PLAIN, 25));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(80)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSetting_1_1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSetting_1_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(134, 136, 137));
		splitPane.setRightComponent(panel_2);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane_1, GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane_1, GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
		);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(134, 136, 137));
		panel_3.setFont(new Font("Perpetua", Font.PLAIN, 30));
		splitPane_1.setLeftComponent(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("Student");
		lblNewLabel_3.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JLabel lblNewLabel_4 = new JLabel("1000");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 69));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Teacher.class.getResource("/image/Students-icon.png")));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(435, Short.MAX_VALUE)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(391))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(27)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(42)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(19)
							.addComponent(lblNewLabel_4)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		cardPanel = new JPanel();
		splitPane_1.setRightComponent(cardPanel);
		cardPanel.setLayout(cl_CardPanel);
		
		JPanel Home = new JPanel();
		Home.setBackground(new Color(134, 136, 137));
		cardPanel.add(Home, "name_774669064080200");
		
		JLabel lblNewLabel_2 = new JLabel("Student Submission Log");
		lblNewLabel_2.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		GroupLayout gl_Home = new GroupLayout(Home);
		gl_Home.setHorizontalGroup(
			gl_Home.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Home.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Home.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Home.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
							.addGap(425))
						.addGroup(Alignment.TRAILING, gl_Home.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_Home.setVerticalGroup(
			gl_Home.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Home.createSequentialGroup()
					.addGap(42)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
					.addGap(14))
		);
		
		SubmissionTable = new JTable();
		SubmissionTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options= {"Submit Marks","Cancel"};
				int selecterOption=JOptionPane.showOptionDialog(null, "Do you want to Submit Marks?", "Submit Marks.",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
				int selectedRow = SubmissionTable.getSelectedRow();
				String Question =  SubmissionTable.getValueAt(selectedRow,6).toString();
				String Answer = SubmissionTable.getValueAt(selectedRow,7).toString();
				SubmitMarks.setQuestion(Question);
				SubmitMarks.setAnswer(Answer);
				if (selecterOption == 0) {
					HashMap <String, String> updateData= new HashMap<>();
					SubmitMarks marks = new SubmitMarks();
					marks.setVisible(true);
					JButton submitbutton = marks.getBtnSubmit();
					submitbutton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String smarks = marks.getMarkstf().getText().trim();
							String AssignmentID = SubmissionTable.getValueAt(selectedRow, 1).toString();
							String StdId = SubmissionTable.getValueAt(selectedRow,3).toString();
							updateData.put("Marks",smarks);
							updateData.put("StudentID",StdId);
							updateData.put("AssignmentID",AssignmentID);
							SubmissionQuery.UpdateMarksQuery(updateData);
							SubmissionModal.setRowCount(0);
							marks.setVisible(false);
							try {
								getSubmssionData();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					JButton cancelbtn = marks.getBtnCancel();
					cancelbtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							marks.setVisible(false);
						}
					});
				}
			}
		});
		SubmissionTable.setModel(SubmissionModal);
		scrollPane.setViewportView(SubmissionTable);
		Home.setLayout(gl_Home);
		
		JPanel Assignment = new JPanel();
		Assignment.setBackground(new Color(128, 128, 128));
		cardPanel.add(Assignment, "name_774932147097300");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2_1 = new JLabel("Assignment");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		
		JButton btnNewButton = new JButton("Add Assignment");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssignmentForm form = new AssignmentForm();
				form.setVisible(true);
				JButton submit = form.getBtnNewButton();
				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String Question = form.getQuestiontf().getText();
						String Module = null;
						ButtonGroup buttonGroup = AssignmentForm.getButtonGroup();
						for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
							AbstractButton button = buttons.nextElement();

							if (button.isSelected()) {
								Module = button.getText().trim(); 
							}
						}
						
						System.out.println(Module);
						HashMap<String,String> addData = new HashMap<>();
						
						
						addData.put("Question",Question);
						addData.put("Module",Module);						
						AssignmentQuery.InsertQuery(addData);
						
						
						AssignmentModel.setRowCount(0);
						form.setVisible(false);
						try {
							getAssignemntData();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					
					}});
				}
			}
		);
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		GroupLayout gl_Assignment = new GroupLayout(Assignment);
		gl_Assignment.setHorizontalGroup(
			gl_Assignment.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Assignment.createSequentialGroup()
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(416)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(20)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 1025, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(436)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_Assignment.setVerticalGroup(
			gl_Assignment.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Assignment.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		
		AssignmentTable = new JTable();
		AssignmentTable.setModel(AssignmentModel);
		AssignmentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options= {"Delete"};
				int selecterOption=JOptionPane.showOptionDialog(null, "Do you want to update Marks?", "Update Marks",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
				int selectedRow = AssignmentTable.getSelectedRow();
				if (selecterOption == 0) {
					String ID = AssignmentTable.getValueAt(selectedRow, 0).toString();
					int result = AssignmentQuery.DeleteQuery(ID);
					if (result == 1) {
						AssignmentModel.removeRow(AssignmentTable.getSelectedRow());
					}
					
				}
			}
		});
		scrollPane_1.setViewportView(AssignmentTable);
		Assignment.setLayout(gl_Assignment);
		splitPane_1.setDividerLocation(125);
		panel_2.setLayout(gl_panel_2);
		splitPane.setDividerLocation(250);
		panel.setLayout(gl_panel);
		frame.setVisible(true);
		try {
			getAssignemntData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			getSubmssionData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

};


			
