package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class AssignmentQuery {
	static Statement statement = connector.getStatement(); 

	public static void InsertQuery(HashMap<String , String> insertData) {
		
		String insertQuery = "INSERT INTO `assigment`(`Question`, `Module`) VALUES ('"+insertData.get("Question")+"','"+insertData.get("Module")+"')";
		
		
		try {
			int insertSuccess = statement.executeUpdate(insertQuery);
			if(insertSuccess == 1) {
				System.out.println("Inserted");
			}else {
				System.out.println("No insert");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static ResultSet SelectQuery() {
		String getQuery = "SELECT * FROM `assigment`"; 
		
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(getQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		return resultSet;
	}
	
	public static void UpdateQuery(HashMap<String , String> updateData) {
		String updatequery = "UPDATE `module` SET `CourseID`='"+updateData.get("CourseID")+"',`ModuleName`='"+updateData.get("ModuleName")+"',`Module Leader`='"+updateData.get("ModuleLeader")+"',`Level`='"+updateData.get("Level")+"',`Semester`='"+updateData.get("Semester")+"',`Credithour`='"+updateData.get("CreditHour")+"' WHERE ModuleID = '"+updateData.get("ModuleID")+"'";
		
		
		try {
			int querySuccess = statement.executeUpdate(updatequery);
			if(querySuccess == 1) {
				System.out.println("Updated");
			}else {
				System.out.println("No update");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int DeleteQuery(String deleteID) {
		
		
		String deleteQuery = "DELETE FROM `assigment` WHERE AssignmentID = '"+deleteID+"'";
		

		try {
			int deleteSuccess = statement.executeUpdate(deleteQuery);
			if (deleteSuccess == 1) {
				System.out.println("Deleted in module");
				return deleteSuccess;
			}else {
				System.out.println("Not deleted in module");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			Object[] options= {"Cancel"};
			int selecterOption=JOptionPane.showOptionDialog(null, "Cant delete Student have submitted", null,
					JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
		}
		return 0;
		
	}

}
