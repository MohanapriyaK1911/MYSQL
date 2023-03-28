import java.sql.*;
import java.util.Scanner;
public class DatabaseOperations {
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	public static void displayAllRecords() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=DatabaseConnection.getDatabaseConnection();
		st=con.createStatement();
		String s1="select * from Employee";
		rs=st.executeQuery(s1);
		System.out.println("Entire record is:");
		System.out.println("Eid\tEname\t\tEphone\t\tEemail\t\t\tEage\t\tEdob");
		System.out.println("-----------------------------------------------------------------------------------------------");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t\t"+rs.getInt(5)+"\t\t"+rs.getString(6));
		}	
	}
	public static void insertRecord() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=DatabaseConnection.getDatabaseConnection();
		st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id");
		int id=sc.nextInt();
		sc.nextLine();
		String s1="select * from employee where eidd="+id;
		rs=st.executeQuery(s1);
		if(!(rs.next())) {
			System.out.println("Enter the name");
			String name=sc.nextLine();
			System.out.println("Enter the phone number");
			String phone=sc.nextLine();
			System.out.println("Enter the email");
			String email=sc.nextLine();
			System.out.println("Enter the age");
			String age=sc.nextLine();
			System.out.println("Enter the date of birth");
			String dob=sc.nextLine();
			
			String s="insert into employee values("+id+",'"+name+"','"+phone+"','"+email+"',"+age+",'"+dob+"')";
			int v=st.executeUpdate(s);
			if(v>0) {
				System.out.println("Record is inserted");
			}	
		}
		else
			System.out.println("Record is not inserted\nEmployee Id already exits");
	}
	public static void updateRecord() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		con=DatabaseConnection.getDatabaseConnection();
		st=con.createStatement();
		
		System.out.println("To update record please enter your choice:\n1->Update employee id\n2->Update employee name\n3->Update employee phone number\n4->Update employee email id\n5->Update employee age\n6->Update employee DOB");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		System.out.println("Enter the employee id to update:");
		int id=sc.nextInt();
		sc.nextLine();
		String s="select * from employee where eidd="+id;
		rs=st.executeQuery(s);
		if (rs.next()) {		
			switch (choice){
			case 1:
				System.out.println("Enter the new id :");
				int reid=sc.nextInt();
				String s1="update employee set eidd="+"'"+reid+"'"+"where eidd="+id;
				int v1=st.executeUpdate(s1);
				if (v1>0) {
					System.out.println("Record was updated successfully!");
				}
				else
					System.out.println("Record was not updated");
				break;
			case 2:
				System.out.println("Enter name :");
				String rename=sc.nextLine();
				String s2="update employee set ename="+"'"+rename+"'"+"where eidd="+id;
				int v2=st.executeUpdate(s2);
				if (v2>0) {
					System.out.println("Record was updated successfully!");
				}
				else
					System.out.println("Record was not updated");
				break;
			case 3:
				System.out.println("Enter phone number :");
				String rephoneno=sc.nextLine();
				String s3="update employee set ephone="+"'"+rephoneno+"'"+"where eidd="+id;
				int v3=st.executeUpdate(s3);
				if (v3>0) {
					System.out.println("Record was updated successfully!");
				}
				else
					System.out.println("Record was not updated");
				break;
			case 4:
				System.out.println("Enter email id :");
				String reemailid=sc.nextLine();
				String s4="update employee set emailid="+"'"+reemailid+"'"+"where eidd="+id;
				int v4=st.executeUpdate(s4);
				if (v4>0) {
					System.out.println("Record was updated successfully!");
				}
				else
					System.out.println("Record was not updated");
				break;
			case 5:
				System.out.println("Enter the age :");
				String reage=sc.nextLine();
				String s5="update employee set eage="+"'"+reage+"'"+"where eidd="+id;
				int v5=st.executeUpdate(s5);
				if (v5>0) {
					System.out.println("Record was updated successfully!");
				}
				else
					System.out.println("Record was not updated");
				break;
			case 6:
				System.out.println("Enter the date of birth:");
				String redob=sc.nextLine();
				String s6="update employee set dob="+"'"+redob+"'"+"where eidd="+id;
				int v6=st.executeUpdate(s6);
				if (v6>0) {
					System.out.println("Record was updated successfully!");
				}
				else
					System.out.println("Record was not updated");
				break;
			}
		}
		else
			System.out.println("Record was not updated!\nEmployee id was not exits");
	}
	public static void deleteRecord() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=DatabaseConnection.getDatabaseConnection();
		st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id to delete");
		int id=sc.nextInt();
		sc.nextLine();
		String s1="select * from employee where eidd="+id;
		rs=st.executeQuery(s1);
		if(rs.next()) {
			String s2="delete from employee where eidd="+id;
			int v1=st.executeUpdate(s2);
			if(v1>0)
				System.out.println("The employee id was deleted successfully!");
			else
				System.out.println("Record was not deleted");		
		}
		else
			System.out.println("Record was not deleted\nThe employee id is not present in the table");
	}
	public static void displayRecordsBasedOnId() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		con=DatabaseConnection.getDatabaseConnection();
		st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id to show record");
		int id=sc.nextInt();
		String s="select * from employee where eidd="+id;
		rs=st.executeQuery(s);
		if(rs.next()) {
			System.out.println("Eid\tEname\t\tEphone\t\tEemail\t\t\tEage\t\tEdob");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t\t"+rs.getInt(5)+"\t\t"+rs.getString(6));
		}
		else {
			System.out.println("Employee not exits");
		}
		
	}		
		
 }

