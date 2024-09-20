package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class StudentQuery {
	static Statement statement = connector.getStatement(); 
	public static ResultSet getStudentName(String StudentID) {
		String query = "SELECT `Name` FROM `studentdetails` WHERE StudentID = '"+StudentID+"'";
		ResultSet result = null;
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}	
	public static ResultSet selectQuery() {
		String query = "SELECT * FROM `studentdetails`";
		ResultSet result = null;
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static void UpdateQuery(HashMap<String , String> updateData) {
		String updatequery = "UPDATE `studentdetails` SET `Level`='"+updateData.get("Level")+"',`Semester`='"+updateData.get("Semester")+"' WHERE StudentDetailsId = '"+updateData.get("StudentDetailsID")+"'";
		
		
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
}
