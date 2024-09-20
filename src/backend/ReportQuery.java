package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class ReportQuery {
	
static Statement statement = connector.getStatement(); 

	

	public static ResultSet SelectQuery(HashMap <String, String> viewData) {
		System.out.println(viewData);
		String getQuery = "SELECT * FROM `stdsubmission` WHERE StudentID ='"+viewData.get("StudentID")+"' AND Module='"+viewData.get("Module")+"'";
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
