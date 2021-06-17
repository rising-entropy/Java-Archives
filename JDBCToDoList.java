//C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc14.jar
import java.sql.*;
import java.util.*;
public class JDBCToDoList {

    public static void createTask()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Task: ");
        String task = sc.nextLine();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mydb","mydb");
            Statement stmt = con.createStatement();

            int result = stmt.executeUpdate("insert into todolist(task) values(\'"+task+"\')");  
            
            if (result > 0)
                System.out.println("Insertion Successful");
            else
                System.out.println("Insertion Unsuccessful");
            
            con.close();  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println();
    }

    public static void viewTasks()
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mydb","mydb");
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("select * from todolist");  
            System.out.println("Your Tasks:\n");
            int c=1;
            while(rs.next())
            {
                System.out.println(String.valueOf(c) + " " + rs.getString(1));
            } 
            System.out.println(); 
            con.close();  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }

    public static void updateTask()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Task to Update: ");
        String task = sc.nextLine();
        System.out.print("Enter Updated Task: ");
        String taskupdate = sc.nextLine();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mydb","mydb");
            Statement stmt = con.createStatement();

            int result = stmt.executeUpdate("update todolist set task=\'"+taskupdate+"\' where task=\'"+task+"\'");  
        
            if (result > 0)
                System.out.println("Update Successful");
            else
                System.out.println("Update Unsuccessful");
            
            con.close();  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println();
    }

    public static void deleteTask()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Task to Delete: ");
        String task = sc.nextLine();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mydb","mydb");
            Statement stmt = con.createStatement();

            int result = stmt.executeUpdate("delete from todolist where task=\'"+task+"\'");  
        
            if (result > 0)
                System.out.println("Delete Successful");
            else
                System.out.println("Delete Unsuccessful");
            
            con.close();  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println();
    }

    public static void makeChoice()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your Action:");
        System.out.println("1. Create a Task");
        System.out.println("2. View all Tasks");
        System.out.println("3. Update a Task");
        System.out.println("4. Delete a Task");
        System.out.println("5. Exit");

        System.out.print("Your Choice: ");
        int choice = sc.nextInt();
        if(choice==1)
        {
            createTask();
            makeChoice();
        }
        if(choice==2)
        {
            viewTasks();
            makeChoice();
        }
        if(choice==3)
        {
            updateTask();
            makeChoice();
        }
        if(choice==4)
        {
            deleteTask();
            makeChoice();
        }
        if(choice==5)
        {
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        makeChoice();      
    }
}
