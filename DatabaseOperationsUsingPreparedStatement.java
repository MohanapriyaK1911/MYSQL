import java.sql.*;
import java.util.*;
public class DatabaseOperationsUsingPreparedStatement {
	public static Connection con;
	public static PreparedStatement ps;
	public static ResultSet rs;

	public static void displayAllRecords() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=DatabaseConnections.getDatabaseConnection();
		String s="select * from employee";
		ps=con.prepareStatement(s);
		rs=ps.executeQuery();
		System.out.println("E-Id\tE-Name\t\tE-Phone\t\t\temailId\t\t\tE-Age\tE-BOB");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getInt(5)+"\t"+rs.getString(6));
		}
	}

	public static void displayRecordsBasedOnId() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter the employee Id to display record");
		int id=sc.nextInt();
		con=DatabaseConnections.getDatabaseConnection();
		String s="select * from employee where eidd=?";
		ps=con.prepareStatement(s);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println("E-Id\tE-Name\t\tE-Phone\t\temailId\t\tE-Age\tE-BOB");
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getInt(5)+"\t"+rs.getString(6));
		}
		else
			System.out.println("Can't display record\nEntered employee Id doesn't exits");
	}

	public static void insertRecord() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=DatabaseConnections.getDatabaseConnection();
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter the employee Id to insert record");
		int id=sc.nextInt();
		sc.nextLine();
		String s="select * from employee where eidd=?";
		ps=con.prepareStatement(s);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		if(!(rs.next())){
			System.out.println("Enter the employee name");
			String name=sc.nextLine();
			System.out.println("Enter the employee phone number");
			String phone=sc.nextLine();
			System.out.println("Enter the employee email Id");
			String email=sc.nextLine();
			System.out.println("Enter the employee age");
			int age=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the employee date of birth");
			String dob=sc.nextLine();
			String s1="insert into employee values(?,?,?,?,?,?)";
			ps=con.prepareStatement(s1);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3,phone);
			ps.setString(4,email);
			ps.setInt(5,age);
			ps.setString(6,dob);
			int v=ps.executeUpdate();
			if(v>0) {
				System.out.println("Record successfully inserted");
				System.out.println("After insertion record becomes");
				displayAllRecords();
			}
			else
				System.out.println("Record was not inserted");
		}
		else
			System.out.println("Entered employee Id already exits\nRecord was not inserted");
	}

	public static void updateRecord() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=DatabaseConnections.getDatabaseConnection();
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter the employee Id to update record");
		int id=sc.nextInt();
		sc.nextLine();
		String s="select * from employee where eidd=?";
		ps=con.prepareStatement(s);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		if(rs.next()){
			System.out.println("                    Which field you want to update");
			System.out.println("1->To update employee Id\n2->To update employee name\n3->To update employee phone number\n4->To update employee email id\n5->To update employee age\n6->To update employee date of birth");
			System.out.println("Enter your choice");
			int n=sc.nextInt();
			sc.nextLine();
			switch(n) {
			case 1:
				System.out.println("Enter the new Id");
				int new_id=sc.nextInt();
				sc.nextLine();
				String s1="update employee set eidd=? where eidd=?";
				ps=con.prepareStatement(s1);
				ps.setInt(1, new_id);
				ps.setInt(2, id);
				int v1=ps.executeUpdate();
				if(v1>0) {
					System.out.println("Record was updated");
					System.out.println("Updated record is");
					displayAllRecords();
				}
				else
					System.out.println("Record was not updated");
				break;
			case 2:
				System.out.println("Enter the name");
				String rename=sc.nextLine();
				String s2="update employee set ename=? where eidd=?";
				ps=con.prepareStatement(s2);
				ps.setString(1, rename);
				ps.setInt(2, id);
				int v2=ps.executeUpdate();
				if(v2>0) {
					System.out.println("Record was updated");
					System.out.println("Updated record is");
					displayAllRecords();
				}
				else
					System.out.println("Record was not updated");
				break;
			case 3:
				System.out.println("Enter the phone number");
				String rephone=sc.nextLine();
				String s3="update employee set ephone=? where eidd=?";
				ps=con.prepareStatement(s3);
				ps.setString(1, rephone);
				ps.setInt(2, id);
				int v3=ps.executeUpdate();
				if(v3>0) {
					System.out.println("Record was updated");
					System.out.println("Updated record is");
					displayAllRecords();
				}
				else
					System.out.println("Record was not updated");
				break;
			case 4:
				System.out.println("Enter the email id");
				String reemail=sc.nextLine();
				String s4="update employee set emailid=? where eidd=?";
				ps=con.prepareStatement(s4);
				ps.setString(1, reemail);
				ps.setInt(2, id);
				int v4=ps.executeUpdate();
				if(v4>0) {
					System.out.println("Record was updated");
					System.out.println("Updated record is");
					displayAllRecords();
				}
				else
					System.out.println("Record was not updated");
				break;
			case 5:
				System.out.println("Enter the age");
				int reage=sc.nextInt();
				sc.nextLine();
				String s5="update employee set eage=? where eidd=?";
				ps=con.prepareStatement(s5);
				ps.setInt(1, reage);
				ps.setInt(2, id);
				int v5=ps.executeUpdate();
				if(v5>0) {
					System.out.println("Record was updated");
					System.out.println("Updated record is");
					displayAllRecords();
				}
				else
					System.out.println("Record was not updated");
				break;
			case 6:
				System.out.println("Enter the date of birth");
				String redob=sc.nextLine();
				String s6="update employee set dob=? where eidd=?";
				ps=con.prepareStatement(s6);
				ps.setString(1, redob);
				ps.setInt(2, id);
				int v6=ps.executeUpdate();
				if(v6>0) {
					System.out.println("Record was updated");
					System.out.println("Updated record is");
					displayAllRecords();
				}
				else
					System.out.println("Record was not updated");
				break;
			}
		}
		else
			System.out.println("Entered employee Id doesn't exits\nRecord was not updated");
	}

	public static void deleteRecordBasedOnId() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=DatabaseConnections.getDatabaseConnection();
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter the employee Id to delete record");
		int id=sc.nextInt();
		sc.nextLine();
		String s="select * from employee where eidd=?";
		ps=con.prepareStatement(s);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		if(rs.next()) {
			String s1="delete from employee where eidd=?";
			ps=con.prepareStatement(s1);
			ps.setInt(1, id);
			int v=ps.executeUpdate();
			if(v>0){
				System.out.println("Record was successfully deleted");
				System.out.println("After deletion record becomes");
				displayAllRecords();
			}
			else
				System.out.println("Record was not deleted");
		}
		else
			System.out.println("Entered id is not exits\nRecord was not deleted");
	}
}
