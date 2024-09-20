package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SubmissionQuery {
	
	static Statement statement = connector.getStatement(); 

	public static ResultSet getQuestion(String ID) {
		
			String getQuery = "SELECT Question FROM `assigment` WHERE AssignmentID = '"+ID+"'";
			
			ResultSet resultSet = null;
			try {
				resultSet = statement.executeQuery(getQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			return resultSet;
	}
		
public static void InsertQuery(HashMap<String , String> data) {
	
		
		String insertQuery = "INSERT INTO `stdsubmission`(`AssignmentID`, `Module`,`StudentID`,`UniID`, `StudentName`,`Question`,`Answer` ,`Marks`,`Published`,`Status`) VALUES ('"+data.get("AssignmentID")+"','"+data.get("Module")+"','"+data.get("StudentID")+"','"+data.get("UniID")+"','"+data.get("StudentName")+"','"+data.get("Question")+"','"+data.get("Answer")+"','"+data.get("Marks")+"','false','failed')";
		
		
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
	String getQuery = "SELECT * FROM `stdsubmission`"; 
	
	ResultSet resultSet = null;
	try {
		resultSet = statement.executeQuery(getQuery);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 
	return resultSet;
}
public static void UpdateMarksQuery(HashMap<String, String> updateData) {
	int Marks = Integer.parseInt(updateData.get("Marks"));
	String Status = "failed";
	if (Marks >= 40) {
		Status = "passed";
	}
	
	String insertQuery = "UPDATE `stdsubmission` SET `Marks`='"+Marks+"' , `Status`='"+Status+"' WHERE StudentID = '"+updateData.get("StudentID")+"' AND AssignmentID = '"+updateData.get("AssignmentID")+"'";
	
	
	try {
		int insertSuccess = statement.executeUpdate(insertQuery);
		if(insertSuccess == 1) {
			System.out.println("Updated");
		}else {
			System.out.println("No insert");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	
	public static void PublishQuery(String ID) {
		String insertQuery = "UPDATE `stdsubmission` SET `Published`='true' WHERE StudentID = '"+ID+"'";
		
		try {
			int insertSuccess = statement.executeUpdate(insertQuery);
			if(insertSuccess == 1) {
				System.out.println("Updated");
			}else {
				System.out.println("No insert");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ResultSet CheckQuery(HashMap<String, String> data) {
		String getQuery = "SELECT * FROM `stdsubmission` WHERE StudentID = '"+data.get("StudentID")+"' AND AssignmentID = '"+data.get("AssigmentID")+"'";
		
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(getQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		return resultSet;
	}
}
