package UIdesign;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import backend.AssignmentQuery;
import backend.ReportQuery;
import backend.StudentQuery;
import backend.SubmissionQuery;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Student {
	private String StudentID;
	
	private CardLayout cl_cardPanel= new CardLayout(0,0);
	private JPanel cardPanel;
	private String UniID;
	public void setStudentID(String studentID) {
		StudentID = studentID;
	}

	public String getStudentID() {
		return StudentID;
	}

	public String getUniID() {
		return UniID;
	}

	public void setUniID(String uniID) {
		UniID = uniID;
	}

	public int getStudentName() {
		return StudentName;
	}

	public void setStudentName(int studentName) {
		StudentName = studentName;
	}

	private int StudentName;
	private JFrame frame;
	private static DefaultTableModel SubmissionModel= new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"AssignmentID", "Question", "Module"
			}
		);
	
	private static DefaultTableModel ResultModel= new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"AssignmentID", "Question", "Module"
			}
		);
	private JTable SubTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void getAssignemntData() throws SQLException{
		ResultSet resultSet = AssignmentQuery.SelectQuery();
		
		
		while (resultSet.next()) {
			int AssignmentID = resultSet.getInt("AssignmentID");
			String Question = resultSet.getString("Question");
			String Module = resultSet.getString("Module");
			SubmissionModel.addRow(new Object[] {
					AssignmentID,
					Question,
					Module,
			});
		}
		
		
	}

	/**
	 * Create the application.
	 */
	public Student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1071, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
		);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(new Color(126, 126, 127));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(107, 107, 108));
		splitPane.setLeftComponent(panel_1);
		
		JButton Homebtn = new JButton("Home");
		Homebtn.setIcon(new ImageIcon(Student.class.getResource("/image/home.png")));
		Homebtn.setBorder(null);
		Homebtn.setBackground(new Color(255, 255, 255));
		Homebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel,"name_4213068297000");
			}
		});
		
		JButton btnNewButton_1 = new JButton("LogOut");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login login = new Login();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		JLabel lblNewLabel = new JLabel("Student");
		lblNewLabel.setFont(new Font("Perpetua", Font.PLAIN, 25));
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(123, 124, 125));
		splitPane.setRightComponent(panel_2);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(splitPane_1, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
		);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(134, 136, 137));
		splitPane_1.setLeftComponent(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("Ai assignment updated");
		lblNewLabel_3.setFont(new Font("Perpetua", Font.PLAIN, 30));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(219)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(212, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(38)
					.addComponent(lblNewLabel_3)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		cardPanel = new JPanel();
		cardPanel.setBackground(new Color(134, 136, 137));
		splitPane_1.setRightComponent(cardPanel);
		cardPanel.setLayout(cl_cardPanel);
		
		JPanel AssignmentSubmission = new JPanel();
		AssignmentSubmission.setBackground(new Color(131, 131, 131));
		cardPanel.add(AssignmentSubmission, "name_4213068297000");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		GroupLayout gl_AssignmentSubmission = new GroupLayout(AssignmentSubmission);
		gl_AssignmentSubmission.setHorizontalGroup(
			gl_AssignmentSubmission.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AssignmentSubmission.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(174, Short.MAX_VALUE))
		);
		gl_AssignmentSubmission.setVerticalGroup(
			gl_AssignmentSubmission.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_AssignmentSubmission.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(763))
		);
		
		SubTable = new JTable();
		SubTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options= {"Submit","Cancel"};
				int selecterOption=JOptionPane.showOptionDialog(null, "Do you want to update or delete?", "Update or delete teacher",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
				int selectedRow = SubTable.getSelectedRow();
				if (selecterOption == 0) {
						String ID = SubTable.getValueAt(selectedRow, 0).toString();
						ResultSet resultSet = SubmissionQuery.getQuestion(ID);
						String question = "";
						String marks = "";
						
						try {
							while (resultSet.next()) {
								question = resultSet.getString("Question");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						SubmissionForm.setQuestion(question);
						SubmissionForm form = new SubmissionForm();
						form.setVisible(true);
						JButton submitbtn = form.getSubmitbtn();
						submitbtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								HashMap<String, String> submitData = new HashMap<>();
								String StudentName = "";
								ResultSet result = StudentQuery.getStudentName(StudentID);
								try {
									while (result.next()) {
										StudentName = result.getString("Name");
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								String Answer = form.getAnswertf().getText();
								submitData.put("Question",SubTable.getValueAt(selectedRow,1).toString());
								submitData.put("AssignmentID", SubTable.getValueAt(selectedRow,0).toString() );
								submitData.put("Module", SubTable.getValueAt(selectedRow,2).toString() );
								submitData.put("StudentID", StudentID);
								submitData.put("UniID", UniID);
								submitData.put("StudentName", StudentName);
								submitData.put("Answer", Answer);
								submitData.put("Marks", marks);
								
								SubmissionQuery.InsertQuery(submitData);
								form.setVisible(false);
								
							}
						});
						
						
						
//						}
				}
			}
		});
		SubTable.setModel(SubmissionModel);
		scrollPane.setViewportView(SubTable);
		
		JPanel Result = new JPanel();
		Result.setBackground(new Color(131, 131, 131));
		cardPanel.add(Result, "name_4274684947099");
		
		JLabel lblNewLabel_2 = new JLabel("Result ");
		lblNewLabel_2.setFont(new Font("Perpetua", Font.PLAIN, 30));
		
		JButton btnNewButton = new JButton("OOP");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options= {"View Report"};
				int selecterOption=JOptionPane.showOptionDialog(null, "Do you want to View Marks?", "View marks",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
				if (selecterOption == 0) {
					String Module = "OOP";
					HashMap <String , String > viewData = new HashMap <>();
					viewData.put("StudentID",StudentID);
					viewData.put("Module",Module);
					ResultSet reportData = ReportQuery.SelectQuery(viewData);
					int assignmentCounter = 0;
					int overallMarks = 0;
					String overallStatus = "passed";
					String Name = null;
					String Published ="false";
					try {
						while (reportData.next()) {
							Name = reportData.getString("StudentName").trim();
							int Marks = reportData.getInt("Marks");
							String Status = reportData.getString("Status").trim();
							Published = reportData.getString("Published").trim();
							assignmentCounter += 1;
							if (Published.equals("true")) {
								overallMarks += Marks;	
								if (Status == "failed") {
									overallStatus = "failed";
								}
							} else {
								Published = "false";
							}
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (StudentID != null) {
						overallMarks = overallMarks / assignmentCounter;
					}
					
					ReportForm.setMarks(overallMarks);
					ReportForm.setStudentIDlb(StudentID);
					ReportForm.setModulelb(Module);
					ReportForm.setStatus(overallStatus);
					ReportForm.setS_Name(Name);
					if (Published.equals("true")) {
						ReportForm report = new ReportForm();
						report.setVisible(true);
						JButton cancel = report.getBtnNewButton();
						cancel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								report.setVisible(false);
							}
						});
					}else {
						NotPublished window = new NotPublished();
						window.setVisible(true);
						JButton btnNewButton = window.getBtnNewButton();
						btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							window.setVisible(false);
						}
					});
						
					}
					
					
				}
			}
		});
		
		JButton btnConceptAnTechnology = new JButton("Concept an Technology of AI");
		btnConceptAnTechnology.setForeground(new Color(0, 0, 0));
		btnConceptAnTechnology.setBackground(new Color(0, 0, 0));
		btnConceptAnTechnology.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options= {"View Report"};
				int selecterOption=JOptionPane.showOptionDialog(null, "Do you want to View Marks?", "View marks",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
				if (selecterOption == 0) {
					String Module = "AI";
					HashMap <String , String > viewData = new HashMap <>();
					viewData.put("StudentID",StudentID);
					viewData.put("Module",Module);
					ResultSet reportData = ReportQuery.SelectQuery(viewData);
					int assignmentCounter = 0;
					int overallMarks = 0;
					String overallStatus = "passed";
					String Name = null;
					String Published ="false";
					try {
						while (reportData.next()) {
							Name = reportData.getString("StudentName").trim();
							int Marks = reportData.getInt("Marks");
							String Status = reportData.getString("Status").trim();
							Published = reportData.getString("Published").trim();
							assignmentCounter += 1;
							if (Published.equals("true")) {
								overallMarks += Marks;	
								if (Status == "failed") {
									overallStatus = "failed";
								}
							} else {
								Published = "false";
							}
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (StudentID != null) {
						overallMarks = overallMarks / assignmentCounter;
					}
					
					ReportForm.setMarks(overallMarks);
					ReportForm.setStudentIDlb(StudentID);
					ReportForm.setModulelb(Module);
					ReportForm.setStatus(overallStatus);
					ReportForm.setS_Name(Name);
					if (Published.equals("true")) {
						ReportForm report = new ReportForm();
						report.setVisible(true);
						JButton cancel = report.getBtnNewButton();
						cancel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								report.setVisible(false);
							}
						});
					}else {
						NotPublished window = new NotPublished();
						window.setVisible(true);
						JButton btnNewButton = window.getBtnNewButton();
						btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							window.setVisible(false);
						}
					});
						
					}			
				}
			}
		});
		
		
		JButton btnNmc = new JButton("NMC");
		btnNmc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options= {"View Report"};
				int selecterOption=JOptionPane.showOptionDialog(null, "Do you want to View Marks?", "View marks",
						JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
				if (selecterOption == 0) {
					String Module = "NMC";
					HashMap <String , String > viewData = new HashMap <>();
					viewData.put("StudentID",StudentID);
					viewData.put("Module",Module);
					ResultSet reportData = ReportQuery.SelectQuery(viewData);
					int assignmentCounter = 0;
					int overallMarks = 0;
					String overallStatus = "passed";
					String Name = null;
					String Published ="false";
					try {
						while (reportData.next()) {
							Name = reportData.getString("StudentName").trim();
							int Marks = reportData.getInt("Marks");
							String Status = reportData.getString("Status").trim();
							Published = reportData.getString("Published").trim();
							assignmentCounter += 1;
							if (Published.equals("true")) {
								overallMarks += Marks;	
								if (Status.equals("failed")) {
									overallStatus = "failed";
								}
							} else {
								Published = "false";
							}
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (StudentID != null) {
						overallMarks = overallMarks / assignmentCounter;
					}
					
					ReportForm.setMarks(overallMarks);
					ReportForm.setStudentIDlb(StudentID);
					ReportForm.setModulelb(Module);
					ReportForm.setStatus(overallStatus);
					ReportForm.setS_Name(Name);
					if (Published.equals("true")) {
						ReportForm report = new ReportForm();
						report.setVisible(true);
						JButton cancel = report.getBtnNewButton();
						cancel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								report.setVisible(false);
							}
						});
					}else {
						NotPublished window = new NotPublished();
						window.setVisible(true);
						JButton btnNewButton = window.getBtnNewButton();
						btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							window.setVisible(false);
						}
					});
						
					}			
				}
			}
		});
		btnNmc.setForeground(new Color(0, 0, 0));
		btnNmc.setBackground(new Color(0, 0, 0));
		GroupLayout gl_Result = new GroupLayout(Result);
		gl_Result.setHorizontalGroup(
			gl_Result.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Result.createSequentialGroup()
					.addGap(22)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(btnConceptAnTechnology, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(btnNmc, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
				.addGroup(gl_Result.createSequentialGroup()
					.addGap(349)
					.addComponent(lblNewLabel_2)
					.addContainerGap(373, Short.MAX_VALUE))
		);
		gl_Result.setVerticalGroup(
			gl_Result.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Result.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel_2)
					.addGap(92)
					.addGroup(gl_Result.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConceptAnTechnology, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNmc, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		JButton btnResult = new JButton("Result");
		btnResult.setIcon(new ImageIcon(Student.class.getResource("/image/notepad.png")));
		btnResult.setBorder(null);
		btnResult.setBackground(new Color(255, 255, 255));
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel,"name_4274684947099");
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(75)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addGap(78))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnResult, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(Homebtn, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNewLabel)
					.addGap(46)
					.addComponent(Homebtn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnResult, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		Result.setLayout(gl_Result);
		splitPane_1.setDividerLocation(100);
		panel_2.setLayout(gl_panel_2);
		splitPane.setDividerLocation(250);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
		try {
			getAssignemntData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
