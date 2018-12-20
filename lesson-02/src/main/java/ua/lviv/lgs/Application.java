package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		EmployeeDao employeeDao = new EmployeeDao(ConnectionUtils.openConnection());

		// READ-ALL
		employeeDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		List<Employee> listOfEmployee = new ArrayList<>();
		listOfEmployee.add(new Employee("Andrew", "Teron"));
		listOfEmployee.add(new Employee("Bruce", "Willis"));
		listOfEmployee.add(new Employee("Canibal", "King"));
		listOfEmployee.add(new Employee("Daniel", "Rossi"));
		listOfEmployee.add(new Employee("Enga", "Still"));

		// INSERT
		listOfEmployee.forEach(employee -> {
			try {
				employeeDao.insert(employee);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

		// READ-ALL
		employeeDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		// READ-ById
		Employee employeeFromBD = employeeDao.read(2);
		System.out.println(employeeFromBD);

		// UPDATE - ById
		employeeFromBD.setLastName(employeeFromBD.getLastName() + "-DeLordRossi");
		employeeDao.update(employeeFromBD);

		// READ-ALL
		employeeDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		employeeDao.delete(6);

		// READ-ALL
		employeeDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

	}
}
