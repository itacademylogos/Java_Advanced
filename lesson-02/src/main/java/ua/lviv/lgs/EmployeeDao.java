package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	private static String READ_ALL = "select * from employee";
	private static String CREATE = "insert into employee(`first_name`, `last_name`) values (?,?)";
	private static String READ_BY_ID = "select * from employee where id =?";
	private static String UPDATE_BY_ID = "update employee set first_name=?, last_name = ? where id = ?";
	private static String DELETE_BY_ID = "delete from employee where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public EmployeeDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(Employee employee) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, employee.getFirstName());
		preparedStatement.setString(2, employee.getLastName());
		preparedStatement.executeUpdate();
	}

	public Employee read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return EmployeeMapper.map(result);
	}

	public void update(Employee employee) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, employee.getFirstName());
		preparedStatement.setString(2, employee.getLastName());
		preparedStatement.setInt(3, employee.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Employee> readAll() throws SQLException {
		List<Employee> listOfEmployee = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfEmployee.add(EmployeeMapper.map(result));
		}
		return listOfEmployee;
	}

}
