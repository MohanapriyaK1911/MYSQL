package com.mohana;
import java.sql.*;
import java.util.*;
public class InsertingRecord {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mohana";
		String un="root";
		String pass="root";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=sc.nextInt();
		sc.nextLine();
		
		
		Class.forName(driver);
		con=DriverManager.getConnection(url, un, pass);
		st=con.createStatement();
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
				System.out.println("record is updated");
			}
			System.out.println("Updated table is:");
			String s2="select * from employee";
			rs1=st.executeQuery(s2);
			System.out.println("EID\tEname\t\tEPhoneNumber\t\tE-emailId\t\t\tEAge\t\tEDOB");
			while(rs1.next()) {
				System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t\t"+rs1.getString(3)+"\t"+rs1.getString(4)+"\t\t"+rs1.getInt(5)+"\t\t"+rs1.getString(6));
			}
		}
		else {
			System.out.println("ID already exits\nRecord is not updated");
		}
		
	}
}
