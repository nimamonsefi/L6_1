/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author nimamonsefi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try{
            Scanner scanner=new Scanner(System.in);
            
            int i;
            
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@Nima:1521:xe"
                                ,"nimamonsefi","password");
            for(i=1;i<6;i++){
                PreparedStatement preparedStatement=connection
                        .prepareStatement("insert into tb1 (id,name,year,average)"
                                + " values(?,?,?,?)");
                
                System.out.print("\nEnter Your Id : ");
                preparedStatement.setString(1,scanner.next());
                
                System.out.print("Enter Your Name : ");
                preparedStatement.setString(2,scanner.next());
                
                System.out.print("Enter Your Year : ");
                preparedStatement.setString(3,scanner.next());
                
                System.out.print("Enter Your Average : ");
                preparedStatement.setDouble(4,scanner.nextDouble());
                
                preparedStatement.executeUpdate();
            }
            
                PreparedStatement preparedStatement=connection
                        .prepareStatement("update tb1 set id=?,name=?,year=?,average=? where id=?");
                
                System.out.print("\nEnter The Id You want Update :");
                preparedStatement.setString(5,scanner.next());
                
                System.out.print("\nEnter New Id : ");
                preparedStatement.setString(1,scanner.next());
                
                System.out.print("Enter New Name : ");
                preparedStatement.setString(2,scanner.next());
                
                System.out.print("Enter New Year : ");
                preparedStatement.setString(3,scanner.next());
                
                System.out.print("Enter New Average : ");
                preparedStatement.setDouble(4,scanner.nextDouble());
                
                preparedStatement.executeUpdate();
                
                preparedStatement=connection.prepareStatement("delete from tb1 where id=?");
                
                System.out.print("\nEnter The Id You want Delete :");
                preparedStatement.setString(1,scanner.next());
                preparedStatement.executeUpdate();
        
        }catch(ClassNotFoundException|SQLException e){
            System.out.println("asdasdasd");
        }
    }
    
}
