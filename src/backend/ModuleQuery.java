package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class ModuleQuery {
	
static Statement statement = connector.getStatement(); 

	public static void InsertQuery(HashMap<String , String> insertData) {
		
		String insertQuery = "INSERT INTO `module`(`CourseID`, `ModuleName`, `Module Leader`, `Level`, `Semester`, `Credithour`) "+
		"VALUES ('"+insertData.get("CourseID")+"','"+insertData.get("ModuleName")+"','"+insertData.get("ModuleLeader")+"','"+insertData.get("Level")+"','"+insertData.get("Semester")+"','"+insertData.get("CreditHour")+"')";
		
		
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
		String getQuery = "SELECT * FROM `module`"; 
		
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
	
	public static void DeleteQuery(HashMap<String , String> deleteData) {
		
		String Id = deleteData.get("ID");
		
		String deleteQuery = "DELETE FROM `module` WHERE ModuleID = '"+Id+"'";
		

		try {
			int deleteSuccess = statement.executeUpdate(deleteQuery);
			if (deleteSuccess == 1) {
				System.out.println("Deleted in module");
			}else {
				System.out.println("Not deleted in module");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}


}
