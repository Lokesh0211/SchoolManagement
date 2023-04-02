package Main;
import java.util.*;
public class Main {
public static void main(String[] args) {
	Student stu = new Student();
	stu.createTable();
	Scanner sc = new Scanner(System.in);
	  int choice = 0;
      while (choice != 6) {
          System.out.println("SELECT YOUR CHOICE");
          System.out.println("1. ADD STUDENT \n2. SHOW STUDENT DETAILS \n3. UPDATE STUDENT DETAILS \n4. DELETE STUDENT DETAILS \n5. DISPLAY ALL STUDENT DETAILS \n6. Exit");

          choice = sc.nextInt();

          switch(choice) {
              case 1: 
                  stu.addStudentDetails();
                  System.out.println("\n");
                  break;
              case 2: 
                  stu.showStudentDetails();
                  System.out.println("\n");
                  break;
              case 3: 
                  stu.updateStudentDetails();
                  System.out.println("\n");
                  break;
              case 4: 
                  stu.deleteStudentDetails();
                  System.out.println("\n");
                  break;
              case 5: 
                  stu.displayAllStudentDetails();
                  System.out.println("\n");
                  break;
              case 6: 
                  break;
              default: 
                  System.out.println("Enter correct choice");
                  break;
          }
      }
      sc.close();
}
}
