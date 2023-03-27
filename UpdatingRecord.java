package com.mohana;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdatingRecord {
	public static void PrintRecord() throws Exception{
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mohana";
		String un="root";
		String pass="root";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		
		Class.forName(driver);
		conn= DriverManager.getConnection(url, un, pass);
		st=conn.createStatement();
		
		String s="select * from employee";
		rs=st.executeQuery(s);
		System.out.println("Updated record is:");
		System.out.println("EID\tEname\t\tEPhoneNumber\t\tE-emailId\t\t\tEAge\t\tEDOB");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t\t"+rs.getInt(5)+"\t\t"+rs.getString(6));
		}
	}
	public static void main(String args[]) throws Exception {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mohana";
		String un="root";
		String pass="root";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your choice:\n1->Update employee id\n2->Update employee name\n3->Update employee phone number\n4->Update employee email id\n5->Update employee age\n6->Update employee DOB");
		int choice=sc.nextInt();
		System.out.println("Enter the employee id to update:");
		int id=sc.nextInt();
		sc.nextLine();
		
		Class.forName(driver);
		conn= DriverManager.getConnection(url, un, pass);
		st=conn.createStatement();
		switch (choice){
		case 1:
			System.out.println("Enter the new id :");
			int reid=sc.nextInt();
			String s1="update employee set eidd="+"'"+reid+"'"+"where eidd="+id;
			int v1=st.executeUpdate(s1);
			if (v1>0) {
				System.out.println("Record was updated successfully!");
				PrintRecord();
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
				PrintRecord();
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
				PrintRecord();
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
				PrintRecord();
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
				PrintRecord();
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
				PrintRecord();
			}
			else
				System.out.println("Record was not updated");
			break;
		}
	}	
}
