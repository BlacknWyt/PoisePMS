/**
 * @author Philasande Mkhize
 * @version 1.0
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner x = new Scanner(System.in);
		System.out.println("Please remember to only assign one person in each project, dont repeat persons otherwise you may break the program");
		System.out.println("What would you like to work with?\n1 - Projects\n2 - Architects\n3 - Contractors\n4 - Customers\n5 - View projects\n0 - Exit");
		String input = x.nextLine();
		
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/poisepms?useSSL=false",
					"testadmin",
					"test101"
			);
			
			statement = connection.createStatement();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		menu(x, input, connection, statement);
		x.close();

	}
	/**
	 * @param (x, input) x gets input from user. input allows 
	 * user to choose what they need to do on the database.
	 * Method allows for user to access any information of their
	 * choice and update or delete it
	 */
	private static void menu(Scanner x, String input, Connection connection, Statement statement) throws SQLException {
		//allows the use to choose what it is they are trying to work with and provides
		//necessary methods to accomplish that
		if(input.equals("Projects") || input.equals("1")){
			System.out.println("what would you like to do with the projects?\n1 - Enter new project\n2 - Update existing project\n3 - Delete project");
			String answer = x.nextLine();
			if(answer.equals("Enter new project") || answer.equals("1")) {
				enterProject(x,connection, statement);
			}
			else if(answer.equals("Update existing project") || answer.equals("2")) {
				updateExistingProj(x, connection, statement);
			}
			else if(answer.equals("Delete project") || answer.equals("3")) {
				deleteProject(x,  connection, statement);
			}
			
			System.out.println("What would you like to work with?\n1 - Projects\n2 - Architects\n3 - Contractors\n4 - Customers\n5 - View projects\n0 - Exit");
			String input2 = x.nextLine();
			menu(x, input2, connection, statement);
		}
		else if(input.equals("Architects") || input.equals("2")) {
			System.out.println("what would you like to do with the Architects?\n1 - Enter new architect\n2 - Update existing architect\n3 - Delete architect");
			String answer = x.nextLine();
			if(answer.equals("Enter new architect") || answer.equals("1")) {
				enterArchitect(x, connection, statement);
				
				System.out.println("What would you like to work with?\n1 - Projects\n2 - Architects\n3 - Contractors\n4 - Customers\n5 - View projects\n0 - Exit");
				String input2 = x.nextLine();
				menu(x, input2, connection, statement);
			}
			else if(answer.equals("Update existing architect") || answer.equals("2")) {
				updateExistingArchitect(x, connection, statement);
			}
			else if(answer.equals("Delete architect") || answer.equals("3")) {
				deleteArchitect(x, connection, statement);
				
				System.out.println("What would you like to work with?\n1 - Projects\n2 - Architects\n3 - Contractors\n4 - Customers\n5 - View projects\n0 - Exit");
				String input2 = x.nextLine();
				menu(x, input2, connection, statement);
			}
		}
		else if(input.equals("Contractors") || input.equals("3")) {
			System.out.println("what would you like to do with the Contractors?\n1 - Enter new contractor\n2 - Update existing contractor\n3 - Delete contractor");
			String answer = x.nextLine();
			if(answer.equals("Enter new contractor") || answer.equals("1")) {
				enterContractor(x, connection, statement);
				
				System.out.println("What would you like to work with?\n1 - Projects\n2 - Architects\n3 - Contractors\n4 - Customers\n5 - View projects\n0 - Exit");
				String input2 = x.nextLine();
				menu(x, input2, connection, statement);
			}
			else if(answer.equals("Update existing contractor") || answer.equals("2")) {
				updateExistingContractor(x, connection, statement);
				
				System.out.println("What would you like to work with?\n1 - Projects\n2 - Architects\n3 - Contractors\n4 - Customers\n5 - View projects\n0 - Exit");
				String input2 = x.nextLine();
				menu(x, input2, connection, statement);
			}
			else if(answer.equals("Delete contractor") || answer.equals("3")) {
				deleteContractor(x, connection, statement);
				
				System.out.println("What would you like to work with?\n1 - Projects\n2 - Architects\n3 - Contractors\n4 - Customers\n5 - View projects\n0 - Exit");
				String input2 = x.nextLine();
				menu(x, input2, connection, statement);
			}
		}
		else if(input.equals("Customers") || input.equals("4")) {
			System.out.println("what would you like to do with the customers?\n1 - Enter new customers\n2 - Update existing customers\n3 - Delete customers");
			String answer = x.nextLine();
			if(answer.equals("Enter new customer") || answer.equals("1")) {
				enterCustomer(x, connection, statement);
				
				System.out.println("What would you like to work with?\n1 - Projects\n2 - Architects\n3 - Contractors\n4 - Customers\n5 - View projects\n0 - Exit");
				String input2 = x.nextLine();
				menu(x, input2, connection, statement);
			}
			else if(answer.equals("Update existing customer") || answer.equals("2")) {
				updateExistingCustomer(x, connection, statement);
				
				System.out.println("What would you like to work with?\n1 - Projects\n2 - Architects\n3 - Contractors\n4 - Customers\n5 - View projects\n0 - Exit");
				String input2 = x.nextLine();
				menu(x, input2, connection, statement);
			}
			else if(answer.equals("Delete customer") || answer.equals("3")) {
				deleteCustomer(x, connection, statement);
				
				System.out.println("What would you like to work with?\n1 - Projects\n2 - Architects\n3 - Contractors\n4 - Customers\n5 - View projects\n0 - Exit");
				String input2 = x.nextLine();
				menu(x, input2, connection, statement);
			}
		}
		else if(input.equals("View projects") || input.equals("5")) {
			System.out.println("1 - View incomplete projects\n2 - View projects past due dates\n3 - View any project");
			String answer = x.nextLine();
			
			if(answer.equals("View incomplete projects") || answer.equals("1")) {
				viewIncompleteProjects(connection, statement);
			}
			else if(answer.equals("View projects past due dates") || answer.equals("2")) {
				projectsPastDueDate(connection, statement);
			}
			else if(answer.equals("View any project") || answer.equals("3")) {
				viewAnyProject(x, connection, statement);
			}
			
			
		}
		else if(input.equals("exit") || input.equals("0")) {
			System.out.println("Shutting down...");
		}
	}
	/**
	 * @Param x  Is a scanner that allows for input
	 */
	
	/**
	 * enterProject method allows for user to input new projects
	 * into the project table in the database
	 */
	public static void enterProject(Scanner x, Connection connection, Statement statement) throws SQLException{
		//holds values for new projects
		System.out.println("What is the Project name?");
		String projName = x.nextLine();
		
		System.out.println("What is the building type?");
		String buildingType = x.nextLine();
		
		System.out.println("What is the project address?");
		String projAddress = x.nextLine();
		
		System.out.println("What is the ERF number?");
		int erfNum = Integer.parseInt(x.nextLine());
		
		System.out.println("What is the total fee of the project?");
		float totalFee = Float.parseFloat(x.nextLine());
		
		System.out.println("What is the amount paid to date?");
		float amountPaidToDate = Float.parseFloat(x.nextLine());
		
		System.out.println("When is the project deadline? in the format : yyyy-mm-dd");
		String projDeadLine = x.nextLine();
		
		System.out.println("What is the project contractor's id number?");
		int projContractor = Integer.parseInt(x.nextLine());
		
		System.out.println("What is the project architect's id number?");
		int projArchitect = Integer.parseInt(x.nextLine());
		
		System.out.println("What is the customer's id number");
		int projCustomer = Integer.parseInt(x.nextLine());
		
		//if the project is not given a name it will take on the name of the
		//bulding type and customer id
		if(projName.equals("")) {
			projName = buildingType + " " + projCustomer;
		}

		int rowsAffected;
		
		//uses above values to create a new project 
		rowsAffected = statement.executeUpdate(
				"INSERT INTO (proj_name, building_type, proj_address, erf_num, total_fee, amount_paid_to_date, proj_deadline, proj_contractor,proj_architect,proj_customer)" +
				" projects (proj_name, building_type, proj_address, erf_num, total_fee, amount_paid_to_date, proj_deadline, proj_contractor,proj_architect,proj_customer) VALUES (" 
				 +"\'"+ projName +"\'"+","+ "\'" + buildingType+ "\'" + ", " + "\'" + projAddress + "\'" + ","+ erfNum +","+ totalFee + "," + amountPaidToDate + "," + "\'" +
				projDeadLine + "\'" +","+ projContractor +","+  projArchitect +","+ projCustomer + ");"
		);
		System.out.println("Project added, " + rowsAffected + "rows affected");
			
	}
	
	/**
	 * updateExistingProject allows the use to update their project in any way
	 * and mark their project as complete
	 */
	public static void updateExistingProj(Scanner x, Connection connection, Statement statement) throws SQLException{
		System.out.println("Please input the id number of the project you would like to update.");
		int id = Integer.parseInt(x.nextLine());
		
		System.out.println("What would you like to update?\n1 - Project ID number\n2 - Project name\n3 - Building Type\n4 - Project address\n5 - ERF number\n6 -Total project fee"
				+"\n7 - Amount paid to date\n8 - project deadline in the format: yyyy-mm-dd\n9 - Project Contractor\n10 - Project Architect\n11 - Project customer\n12 - Project finalisation");
		String change = x.nextLine();
		//changes the projec id number
		if(change.equals("Project ID number") || change.equals("1")) {
			System.out.println("What would you like to change it to?");
			int newId = Integer.parseInt(x.nextLine());

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE projects SET proj_num = " + newId + " WHERE proj_num = " + id + ";"
				);
				System.out.println("Project updated, " + rowsAffected + "rows affected");

		}
		//changes project name 
		else if(change.equals("Project name") || change.equals("2")) {
			System.out.println("What would you like to change it to?");
			String newName = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE projects SET proj_name = " +"\'"+ newName +"\'"+ " WHERE proj_num = " + id + ";"
				);
				System.out.println("Project updated, " + rowsAffected + "rows affected");
		}
		//changes the building type
		else if(change.equals("Building type") || change.equals("3")) {
			System.out.println("What would you like to change it to?");
			String buildingType = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE projects SET building_type = " +"\'"+ buildingType +"\'"+ " WHERE proj_num = " + id + ";"
				);
				System.out.println("Project updated, " + rowsAffected + "rows affected");
		}
		//changes projects address
		else if(change.equals("Project address") || change.equals("4")) {
			System.out.println("What would you like to change it to?");
			String projAddress = x.nextLine();
			
				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE projects SET proj_address = " +"\'"+ projAddress +"\'"+ " WHERE proj_num = " + id + ";"
				);
				System.out.println("Project updated, " + rowsAffected + "rows affected");

		}
		//changes projects ERF number
		else if(change.equals("ERF number") || change.equals("5")) {
			System.out.println("What would you like to change it to?");
			int erfNum = Integer.parseInt(x.nextLine());

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE projects SET erf_num = " + erfNum + " WHERE proj_num = " + id + ";"
				);
				System.out.println("Project updated, " + rowsAffected + "rows affected");
		}
		//changes total project fee
		else if(change.equals("Total project fee") || change.equals("6")) {
			System.out.println("What would you like to change it to?");
			int totalFee = Integer.parseInt(x.nextLine());
			
				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE projects SET total_fee = " + totalFee + " WHERE proj_num = " + id + ";"
				);
				System.out.println("Project updated, " + rowsAffected + "rows affected");
		}
		//changes amount paid to date
		else if(change.equals("Amount paid to date") || change.equals("7")) {
			System.out.println("What would you like to change it to?");
			int amountPaidToDate = Integer.parseInt(x.nextLine());
			
	
				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE projects SET amount_paid_to_date = " + amountPaidToDate + " WHERE proj_num = " + id + ";"
				);
				System.out.println("Project updated, " + rowsAffected + "rows affected");
				
	
		}
		//changes project deadline
		else if(change.equals("Project deadline") || change.equals("8")) {
			System.out.println("What would you like to change it to?");
			String projDeadLine = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE projects SET proj_deadline = " +"\'"+ projDeadLine +"\'"+ " WHERE proj_num = " + id + ";"
				);
				System.out.println("Project updated, " + rowsAffected + "rows affected");
				
	
		}
		//changes project contractor
		else if(change.equals("Project Contractor") || change.equals("9")) {
			System.out.println("What is the id number or the contractor you would like to change to?");
			int projContractor = Integer.parseInt(x.nextLine());

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE projects SET proj_manager = " +"\'"+ projContractor +"\'"+ " WHERE proj_num = " + id + ";"
				);
				System.out.println("Project updated, " + rowsAffected + "rows affected");

		}
		//changes the project architect
		else if(change.equals("Project Architect") || change.equals("10")) {
			System.out.println("What is the id number or the architect you would like to change to?");
			int projArchitect =  Integer.parseInt(x.nextLine());

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE projects SET proj_architect = " +"\'"+ projArchitect +"\'"+ " WHERE proj_num = " + id + ";"
				);
				System.out.println("Project updated, " + rowsAffected + "rows affected");

		}
		//changes the project customer
		else if(change.equals("Project customer") || change.equals("11")) {
			System.out.println("What is the id number or the customer you would like to change to?");
			int projCustomer =  Integer.parseInt(x.nextLine());

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE projects SET proj_customer = " +"\'"+ projCustomer +"\'"+ " WHERE proj_num = " + id + ";"
				);
				System.out.println("Project updated, " + rowsAffected + "rows affected");

		}
		//marks project complete and gets date of its completion
		else if(change.equals("Project finalisation") || change.equals("12")) {
			System.out.println("Is the project Complete or Incomplete?");
			String completeOrNot = x.nextLine();
			
			if(completeOrNot.equals("Complete")) {
				System.out.println("Please input the projects dates of completion in the format: yyyy-mm-dd");
				String date = x.nextLine();

					int rowsAffected;
					
					rowsAffected = statement.executeUpdate(
							"UPDATE projects SET proj_completion = 'Complete' WHERE proj_num = " + id + ";"
					);
					System.out.println("Project completion updated, " + rowsAffected + "rows affected");
					
					rowsAffected = statement.executeUpdate(
							"UPDATE projects SET proj_completion_date = " +"\'"+ date +"\'"+ " WHERE proj_num = " + id + ";"
					);
					System.out.println("Project completion updated, " + rowsAffected + "rows affected");
					System.out.println("Congratulations on completing your project!");
			}
			//marks project incomplete
			else if(completeOrNot.equals("Incomplete")) {

					int rowsAffected;
					
					rowsAffected = statement.executeUpdate(
							"UPDATE projects SET proj_completion = 'Incomplete' WHERE proj_num = " + id + ";"
					);
					System.out.println("Project completion updated, " + rowsAffected + "rows affected");
					
					rowsAffected = statement.executeUpdate(
							"UPDATE projects SET proj_completion_date = NULL WHERE proj_num = " + id + ";"
					);
					System.out.println("Project completion updated, " + rowsAffected + "rows affected");

			}
			
		}
		
		
	}
	
	/**
	 * deleteProjects removes the project from the database 
	 * and anyone that was involved in the project is removed aswell
	 */
	public static void deleteProject(Scanner x, Connection connection, Statement statement) throws SQLException{
		System.out.println("Please input the id of the project you want to delete");
		int projNum = Integer.parseInt(x.nextLine());
		
			int rowsAffected;
			ResultSet results;
			
			//retrieves project with that specific project number
			results = statement.executeQuery(
					"SELECT * FROM projects WHERE proj_num = " + projNum + ";"
			);
			
			//holds values of everyone involved in project 
			int contractor = 0;
			int architect = 0;
			int customer = 0;
			while(results.next()) {
				contractor = results.getInt("proj_contractor");
				architect = results.getInt("proj_architect");
				customer = results.getInt("proj_customer");
			}
			
			//removes everyone that was involved in the project from the
			//whole database and removes the project aswell
			
			rowsAffected = statement.executeUpdate(
					"DELETE FROM projects WHERE proj_num = " + projNum + ";"
			);
			System.out.println("Project deleted, " + rowsAffected + "rows affected");
			
			rowsAffected = statement.executeUpdate(
					"DELETE FROM customer WHERE id = " + "\'"+ customer + "\'"+ ";"
			);
			System.out.println("Project customer removed, " + rowsAffected + "rows affected");
			
			rowsAffected = statement.executeUpdate(
					"DELETE FROM architect WHERE id = " +"\'"+ architect +"\'"+ ";"
			);
			System.out.println("Project architect removed, " + rowsAffected + "rows affected");
			
			rowsAffected = statement.executeUpdate(
					"DELETE FROM contractor WHERE id = " +"\'"+ contractor +"\'"+ ";"
			);
			System.out.println("Project contractor removed, " + rowsAffected + "rows affected");

	}
	
	/**
	 * enterArchitect method allows for user to input new architects
	 * into the database
	 */
	public static void enterArchitect(Scanner x, Connection connection, Statement statement) throws SQLException{
		//holds values for new architect
		System.out.println("What is the architects name?");
		String name = x.nextLine();
		
		System.out.println("What is the architects telephone number?");
		int teleNum = Integer.parseInt(x.nextLine());
		
		System.out.println("What is the architects email address");
		String emailAddress = x.nextLine();
		
		System.out.println("What is the architects physical address?");
		String physicalAddress = x.nextLine();

			int rowsAffected;
			
			//create new architect with above values
			rowsAffected = statement.executeUpdate(
					"INSERT INTO (name, tele_num, email_address, physical_address) architect (name, tele_num, email_address, physical_address) VALUES ("+
					"\'"+ name +"\'"+","+ teleNum + "," + "\'" + emailAddress + "\'" + ","+ "\'"+ physicalAddress +"');"
			);
			System.out.println("Architect added, " + rowsAffected + "rows affected");
	}
	
	/**
	 * updateExistingArchitect allows the use to update any information 
	 * about their architect
	 */
	public static void updateExistingArchitect(Scanner x, Connection connection, Statement statement) throws SQLException{
		System.out.println("Please input the id of the architect you would like to update.");
		int id = Integer.parseInt(x.nextLine());
		
		System.out.println("What would you like to update?\n1 - Architects id\n2 - Architects name\n3 - Architects telephone number\n4 - Architects email address\n5 - Architects physical address");
		String change = x.nextLine();
		
		if(change.equals("Architects id") || change.equals("1")) {
			System.out.println("What would you like to change it to?");
			int newId = Integer.parseInt(x.nextLine());

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE architect SET id = " + newId + " WHERE id = " + id + ";"
				);
				System.out.println("Architects name updated, " + rowsAffected + " rows affected");
		}
		//changes architects names
		else if(change.equals("Architects name") || change.equals("2")) {
			System.out.println("What would you like to change it to?");
			String newName = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE architect SET name = " +"\'"+ newName +"\'"+ " WHERE id = " + id + ";" 
				);
				System.out.println("Architects name updated, " + rowsAffected + " rows affected");
		}
		//changes architects telephone number
		else if(change.equals("Architects telephone number") || change.equals("3")) {
			System.out.println("What would you like to change it to?");
			String teleNum = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE architect SET tele_num = " +"\'"+ teleNum +"\'"+ " WHERE id = " + id + ";"
				);
				System.out.println("Architects telephone number updated, " + rowsAffected + " rows affected");
				
		}
		//changes architects email address
		else if(change.equals("Architects email address") || change.equals("4")) {
			System.out.println("What would you like to change it to?");
			String emailAddress = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE architect SET email_address = " +"\'"+ emailAddress +"\'"+ " WHERE id = " + id + ";"
				);
				System.out.println("Architects email address updated, " + rowsAffected + " rows affected");

		}
		//changes architects address
		else if(change.equals("Architects physical address") || change.equals("5")) {
			System.out.println("What would you like to change it to?");
			String physicalAddress = x.nextLine();
		
				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE architect SET physical_address = " +"\'"+ physicalAddress +"\'"+ " WHERE id = " + id + ";"
				);
				System.out.println("Architects address updated, " + rowsAffected + " rows affected");

		}
	}
	
	/**
	 * deleteArchitect removes the architect from the 
	 * architect table
	 */
	public static void deleteArchitect(Scanner x, Connection connection, Statement statement) throws SQLException {
		System.out.println("Please input the id of the architect you want to remove");
		int id = Integer.parseInt(x.nextLine());
		
			int rowsAffected;
			
			//removes architect with that specific name from table
			rowsAffected = statement.executeUpdate(
					"DELETE FROM architect WHERE id = " + id + ";"
			);
			System.out.println("Architect removed, " + rowsAffected + "rows affected");
	}
	
	/**
	 * enterContractor method allows for user to input new contractors
	 * into the database
	 */
	public static void enterContractor(Scanner x, Connection connection, Statement statement) throws SQLException{
		//holds values of new contractor
		System.out.println("What is the contractor's name?");
		String name = x.nextLine();
		
		System.out.println("What is the contractor's telephone number?");
		String teleNum = x.nextLine();
		
		System.out.println("What is the contractor's email address?");
		String emailAddress = x.nextLine();
		
		System.out.println("What is the contractor's physical address?");
		String physicalAddress = x.nextLine();
		
		int rowsAffected;
		
		//uses above values to create a new contractor
		rowsAffected = statement.executeUpdate(
				"INSERT INTO (name, tele_num, email_address, physical_address) contractor VALUES ("
				+ "\'"+ name +"\'"+","+ teleNum + "," + "\'" + emailAddress + "\'" + ","+ "\'"+ physicalAddress +"');"
		);
		System.out.println("Contractor added, " + rowsAffected + "rows affected");
	}
	
	/**
	 * updateExistingContractor allows the use to update any information 
	 * about their contractor
	 */
	public static void updateExistingContractor(Scanner x, Connection connection, Statement statement) throws SQLException{
		System.out.println("Please input the id of the contractor you would like to update.");
		int id = Integer.parseInt(x.nextLine());
		
		System.out.println("What would you like to update?\n1 - Contractor id\n2 - Contractor name\n3 - Contractor telephone number\n4 - Contractor email address\n5 - Contractor physical address");
		String change = x.nextLine();
		
		if(change.equals("Contractor id") || change.equals("1")) {
			System.out.println("What would you like to change it to?");
			int newId = Integer.parseInt(x.nextLine());

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE contractor SET id = " + newId + " WHERE id = " + id + ";"
				);
				System.out.println("Contractors name updated, " + rowsAffected + " rows affected");
		}
		//changes architects names
		else if(change.equals("Contractor name") || change.equals("2")) {
			System.out.println("What would you like to change it to?");
			String newName = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE contractor SET name = " +"\'"+ newName +"\'"+ " WHERE id = " + id + ";" 
				);
				System.out.println("Contractor name updated, " + rowsAffected + " rows affected");
		}
		//changes architects telephone number
		else if(change.equals("Contractor telephone number") || change.equals("3")) {
			System.out.println("What would you like to change it to?");
			String teleNum = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE contractor SET tele_num = " +"\'"+ teleNum +"\'"+ " WHERE id = " + id + ";"
				);
				System.out.println("Contractor telephone number updated, " + rowsAffected + " rows affected");
				
		}
		//changes architects email address
		else if(change.equals("Contractor email address") || change.equals("4")) {
			System.out.println("What would you like to change it to?");
			String emailAddress = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE contractor SET email_address = " +"\'"+ emailAddress +"\'"+ " WHERE id = " + id + ";"
				);
				System.out.println("Contractor email address updated, " + rowsAffected + " rows affected");

		}
		//changes architects address
		else if(change.equals("Contractor physical address") || change.equals("5")) {
			System.out.println("What would you like to change it to?");
			String physicalAddress = x.nextLine();
		
				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE contractor SET physical_address = " +"\'"+ physicalAddress +"\'"+ " WHERE id = " + id + ";"
				);
				System.out.println("Contractor address updated, " + rowsAffected + " rows affected");

		}
	}
	
	/**
	 * deleteContractor removes the contractor from the 
	 * contractor table
	 */
	public static void deleteContractor(Scanner x, Connection connection, Statement statement) throws SQLException{
		System.out.println("Please input the id of the contractor you want to remove");
		int id = Integer.parseInt(x.nextLine());

			int rowsAffected;
			
			//removes contractor with that specific name
			rowsAffected = statement.executeUpdate(
					"DELETE FROM contractor WHERE id = " + "\'"+ id + "\'"+ ";"
			);
			System.out.println("Contractor removed, " + rowsAffected + "rows affected");
	}
	
	/**
	 * enterCustomer method allows for user to input new customer
	 * into the database
	 */
	public static void enterCustomer(Scanner x, Connection connection, Statement statement) throws SQLException{
		//holds values of new customer
		System.out.println("What is the customer's name?");
		String name = x.nextLine();
		
		System.out.println("What is the customer's telephone number?");
		String teleNum = x.nextLine();
		
		System.out.println("What is the customer's email address?");
		String emailAddress = x.nextLine();
		
		System.out.println("What is the customer's physical address?");
		String physicalAddress = x.nextLine();
		
		int rowsAffected;
		
		//uses above values to create a new contractor
		rowsAffected = statement.executeUpdate(
				"INSERT INTO (name, tele_num, email_address, physical_address) customer VALUES (" +
				"\'"+ name +"\'"+","+ teleNum + "," + "\'" + emailAddress + "\'" + ","+ "\'"+ physicalAddress +"');"
		);
		System.out.println("Customer added, " + rowsAffected + "rows affected");
	}
	
	/**
	 * updateExistingCustomer allows the use to update any information 
	 * about their customer
	 */
	public static void updateExistingCustomer(Scanner x, Connection connection, Statement statement) throws SQLException{
		System.out.println("Please input the id of the customer you would like to update.");
		int id = Integer.parseInt(x.nextLine());
		
		System.out.println("What would you like to update?\n1 - Customers id\n2 - Customers name\n3 - Customers telephone number\n4 - Customers email address\n5 - Customers physical address");
		String change = x.nextLine();
		
		if(change.equals("Customers id") || change.equals("1")) {
			System.out.println("What would you like to change it to?");
			int newId = Integer.parseInt(x.nextLine());

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE customer SET id = " + newId + " WHERE id = " + id + ";"
				);
				System.out.println("Customers name updated, " + rowsAffected + " rows affected");
		}
		//changes architects names
		else if(change.equals("Customers name") || change.equals("2")) {
			System.out.println("What would you like to change it to?");
			String newName = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE customer SET name = " +"\'"+ newName +"\'"+ " WHERE id = " + id + ";" 
				);
				System.out.println("Customers name updated, " + rowsAffected + " rows affected");
		}
		//changes architects telephone number
		else if(change.equals("Customers telephone number") || change.equals("3")) {
			System.out.println("What would you like to change it to?");
			String teleNum = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE customer SET tele_num = " +"\'"+ teleNum +"\'"+ " WHERE id = " + id + ";"
				);
				System.out.println("Customers telephone number updated, " + rowsAffected + " rows affected");
				
		}
		//changes architects email address
		else if(change.equals("Customers email address") || change.equals("4")) {
			System.out.println("What would you like to change it to?");
			String emailAddress = x.nextLine();

				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE customer SET email_address = " +"\'"+ emailAddress +"\'"+ " WHERE id = " + id + ";"
				);
				System.out.println("Customers email address updated, " + rowsAffected + " rows affected");

		}
		//changes architects address
		else if(change.equals("Contractor physical address") || change.equals("5")) {
			System.out.println("What would you like to change it to?");
			String physicalAddress = x.nextLine();
		
				int rowsAffected;
				
				rowsAffected = statement.executeUpdate(
						"UPDATE customer SET physical_address = " +"\'"+ physicalAddress +"\'"+ " WHERE id = " + id + ";"
				);
				System.out.println("Customers address updated, " + rowsAffected + " rows affected");

		}
	}
	
	/**
	 * deleteContractor removes the contractor from the 
	 * contractor table
	 */
	public static void deleteCustomer(Scanner x, Connection connection, Statement statement) throws SQLException{
		System.out.println("Please input the id of the customer you want to remove");
		int id = Integer.parseInt(x.nextLine());

			int rowsAffected;
			
			//removes contractor with that specific name
			rowsAffected = statement.executeUpdate(
					"DELETE FROM customer WHERE id = " + "\'"+ id + "\'"+ ";"
			);
			System.out.println("Customer removed, " + rowsAffected + "rows affected");
	}

	/**
	 * viewIncompleteProjects allows user to view all projects
	 * that have not been marked down as complete
	 */
	public static void viewIncompleteProjects(Connection connection, Statement statement) throws SQLException{

			ResultSet results;
			
			//retrieves and projects marked as incomplete
			results = statement.executeQuery(
					"SELECT * FROM projects WHERE proj_completion = 'Incomplete';"
			);
			
			//prints results
			while(results.next()) {
				System.out.println(results.getInt("proj_num") + ", " + results.getString("proj_name") + ", " + results.getString("building_type")
				+ ", " +results.getString("proj_address") + ", " + results.getInt("erf_num") + ", " + results.getFloat("total_fee") + ", " + results.getFloat("amount_paid_to_date")
				+ ", " + results.getString("proj_deadline") + ", " + results.getString("proj_contractor") + ", " + results.getString("proj_architect") + ", " + results.getString("proj_customer")
				+ ", " + results.getString("proj_completion") + ", " + results.getString("proj_completion_date")+ "\n\n"); 
			}
	}

	/**
	 * projectsPastDueDate allows user to view all projects
	 * that have not been completed on the allocated time
	 */
	public static void projectsPastDueDate(Connection connection, Statement statement) throws SQLException{

			ResultSet results;
			
			//compares projects with current date and returns projects past their due date
			results = statement.executeQuery(
					"SELECT * FROM projects WHERE proj_deadline < " +"\'"+ LocalDate.now() +"\'"
			);
			
			//prints out results
			while(results.next()) {
				System.out.println(results.getInt("proj_num") + ", " + results.getString("proj_name") + ", " + results.getString("building_type")
				+ ", " +results.getString("proj_address") + ", " + results.getInt("erf_num") + ", " + results.getFloat("total_fee") + ", " + results.getFloat("amount_paid_to_date")
				+ ", " + results.getString("proj_deadline") + ", " + results.getString("proj_contractor") + ", " + results.getString("proj_architect") + ", " + results.getString("proj_customer")
				+ ", " + results.getString("proj_completion") + ", " + results.getString("proj_completion_date")+ "\n\n"); 
			}
			
	}
	
	/**
	 * viewAnyProject allows user to view any project of their 
	 * choice through the project name or project number 
	 */
	public static void viewAnyProject(Scanner x, Connection connection, Statement statement) throws SQLException {
		System.out.println("Please input the project number or name");
		String answer = x.nextLine();

			ResultSet results;
			
			//retrieves any project that has that name or project number
			results = statement.executeQuery(
					"SELECT * FROM projects WHERE proj_num = " +"\'"+ answer +"\'"+ " OR proj_name = " + "\'"+ answer +"\';"
			);
			
			//prints out projects
			while(results.next()) {
				System.out.println(results.getInt("proj_num") + ", " + results.getString("proj_name") + ", " + results.getString("building_type")
				+ ", " +results.getString("proj_address") + ", " + results.getInt("erf_num") + ", " + results.getFloat("total_fee") + ", " + results.getFloat("amount_paid_to_date")
				+ ", " + results.getString("proj_deadline") + ", " + results.getString("proj_contractor") + ", " + results.getString("proj_architect") + ", " + results.getString("proj_customer")
				+ ", " + results.getString("proj_completion") + ", " + results.getString("proj_completion_date")+ "\n\n"); 
			}
			
			
			
		
	}
}
	
	