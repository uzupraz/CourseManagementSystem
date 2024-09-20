package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import UIdesign.CourseForm;

public class CourseQuery {
	static Statement statement = connector.getStatement(); 
	
	public static void InsertQuery(HashMap<String , String> insertData) {
		
		String insertQuery = "INSERT INTO `course`(`CourseName`, `CourseDescription`, `NoofModules`, `Status`, `Duration`)"+
		" VALUES ('"+insertData.get("Coursename")+"','"+insertData.get("CourseDes")+"','"+insertData.get("NoOfModules")+"','"+insertData.get("Status")+"','"+insertData.get("Duration")+"')";
		
		
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
		String getQuery = "SELECT * FROM `course`"; 
		
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
		
	
		String updatequery = "UPDATE `course` SET `CourseName`='"+updateData.get("CourseName")+"',`CourseDescription`='"+updateData.get("CourseDes")+"',`NoofModules`='"+updateData.get("No of modules")+"',`Status`='"+updateData.get("Status")+"',`Duration`='"+updateData.get("Duration")+"' WHERE Courseid = '"+updateData.get("CourseID")+"'";
		
		
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
		
		String deleteQuery = "DELETE FROM `module` WHERE CourseID = '"+Id+"'";
		

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
		String deleteQuery1 = "DELETE FROM `course` WHERE CourseID = '"+Id+"'";
		int deleteSuccess;
		try {
			deleteSuccess = statement.executeUpdate(deleteQuery1);
			if (deleteSuccess == 1) {
				System.out.println("Deleted in course");
			}else {
				System.out.println("Not deleted in course");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
