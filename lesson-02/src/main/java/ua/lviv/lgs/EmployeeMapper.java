package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper {

	
	
	public static Employee map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String firstName = result.getString("first_name");
		String lastName = result.getString("last_name");
		
		return new Employee(id, firstName, lastName);
	}
	
	
}
