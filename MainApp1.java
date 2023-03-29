import java.sql.*;
import java.util.*;
public class MainApp1 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("                Database Operations Menu");
			System.out.println("1->To display all records\n2->To display record based on ID \n3->To insert record \n4->To update record\n5->To delete record");
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				DatabaseOperationsUsingPreparedStatement.displayAllRecords();
				break;
			case 2:
				DatabaseOperationsUsingPreparedStatement.displayRecordsBasedOnId();
				break;
			case 3:
				DatabaseOperationsUsingPreparedStatement.insertRecord();
				break;
			case 4:
				DatabaseOperationsUsingPreparedStatement.updateRecord();
				break;
			case 5:
				DatabaseOperationsUsingPreparedStatement.deleteRecordBasedOnId();
				break;	
			}
			System.out.println("Do you want you continue y/n:");
			char c=sc.next().charAt(0);
			if(c=='n' || c=='N') {
				System.out.println("Program terminated");
				break;
			}
		}
	}
}
