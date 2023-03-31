package Main;
import java.util.*;
public class Main {
public static void main(String[] args) {
	Student stu = new Student();
	stu.createTable();
	System.out.println("SELECT YOUR CHOICE");
	System.out.println("1. ADD STUDENT \n2. SHOW STUDENT DETAILS \n3. UPDATE STUDENT DETAILS \n4. DELETE STUDENT DETAILS \n5. DISPLAY ALL STUDENT DETAILS");
	
	Scanner sc = new Scanner(System.in);
	int choice = sc.nextInt();
	switch(choice) {
	case 1: stu.addStudentDetails();
	break;
	case 2: stu.showStudentDetails();
	break;
	case 3: stu.updateStudentDetails();
	break;
	case 4: stu.deleteStudentDetails();
	break;
	case 5: stu.displayAllStudentDetails();
	break;
	}
	sc.close();
}
}
