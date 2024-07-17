package task_23_guvi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Question_2 {

	public static void main(String[] args) throws Exception {

//		Creating a JDBC Connection for a database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/guvi", "root",
				"aravindh@123456");

//		Creating Statement to execute SQL Queries
		Statement statement = connection.createStatement();
		
//		Creating the CREATE Statement to create a table
		String createQuery = "CREATE TABLE employees (empcode int primary key, empname varchar(15), empage int, empsalary int);";
		
//		Creating the INSERT Statement to add records
		String insertQuery[] = { "INSERT INTO employees VALUES (101, 'Jenny', 25, 10000);",
				"INSERT INTO employees VALUES (102, 'Jackie', 30, 20000);",
				"INSERT INTO employees VALUES (103, 'Joe', 20, 40000);",
				"INSERT INTO employees VALUES (104, 'John', 40, 80000);",
				"INSERT INTO employees VALUES (105, 'Shameer', 25, 90000);" };
		
//		Creating the SELECT Statement to display the inserted records from the table
		String selectQuery = "SELECT * FROM employees;";
		
//		Creating the DROP Statement to drop the table - using this query if the entire code needs to be run from CREATE Statement again
		String dropQuery = "DROP TABLE employees;";

//		Executing the CREATE Statement
		boolean createSuccess = statement.execute(createQuery);
		if (createSuccess)
			System.out.println("Table Creation is NOT Successful");
		else
			System.out.println("Table Creation is Successful");

//		Executing the INSERT Statements
		boolean insertSuccess = true;
		for (String query : insertQuery) {
			insertSuccess = statement.execute(query);
		}
		if (insertSuccess)
			System.out.println("Record Insertion is NOT Successful");
		else
			System.out.println("Record Insertion is Successful");

//		Executing the SELECT Statement and storing the results in the ResultSet
		ResultSet resultSet = statement.executeQuery(selectQuery);

		System.out.println("\nDisplaying the records from 'employees' table");
		System.out.println("-----------------------------");
		while (resultSet.next()) {
			int empcode = resultSet.getInt("empcode");
			String empname = resultSet.getString("empname");
			int empage = resultSet.getInt("empage");
			int empsalary = resultSet.getInt("empsalary");
			System.out.println(empcode + " " + empname + " " + empage + " " + empsalary);
		}
		System.out.println("-----------------------------\n");

//		Executing the DROP Statement
		boolean dropSuccess = statement.execute(dropQuery);
		if (dropSuccess)
			System.out.println("Table Drop is NOT Successful");
		else
			System.out.println("Table Drop is Successful");

//		Close the Connection
		connection.close();

	}

}
