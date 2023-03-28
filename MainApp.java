import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("Database Operations Menu");
			System.out.println("1->To display all records press 1\n2->To display records based on id press 2\n3->To insert the record press 3\n4->To update the record prees 4\n5->To delete the record press 5");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println("Enter your choice");
			int n=sc.nextInt();
			switch(n) {
			case 1:
				DatabaseOperations.displayAllRecords();
				break;
			case 2:
				DatabaseOperations.displayRecordsBasedOnId();
				break;
			case 3:
				DatabaseOperations.insertRecord();
				break;
			case 4:
				DatabaseOperations.updateRecord();
				break;
			case 5:
				DatabaseOperations.deleteRecord();
				break;
			}
			System.out.println("Do you want to continue y/n");
			char c=sc.next().charAt(0);
			if(c=='n'||c=='N') {
				System.out.println("-------------Program terminated----------------");
				break;
			}	
		}
		
	}
}
