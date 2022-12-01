package application;

import java.util.Scanner;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.*;


public class Main extends Application{ 
	Stage window;
	static Audi a=new Audi();
	public void start(Stage primaryStage) throws Exception
	{
		window=primaryStage;
		window.setTitle("Audi Booking System");
		Button login=new Button("Login");
		Label label1=new Label("Welcome to Audi Booking System");
		login.setOnAction(e->{LoginDetails.acceptdetails(a);
		window.close();});
		Button signup=new Button("Signup");
		signup.setOnAction(e->{
			SignupDetails.acceptdetails(a);
			window.close();
		});
		VBox layout=new VBox();
		layout.getChildren().addAll(label1,signup,login);
		layout.setAlignment(Pos.CENTER);
		Scene scene1=new Scene(layout,300,300);
		window.setScene(scene1);
		window.show();
	}
	public static void main(String args[])
	{
		launch(args);
//		while(true)
//		{
//		System.out.println("--------------------------------------------------------------------------------------------");
//		System.out.println("|                            Welcome to Audi Booking System                                |");
//		System.out.println("--------------------------------------------------------------------------------------------");
//		System.out.println("Enter 'Yes' to Login \nEnter 'No' to Signup");
//		
//		Scanner sc=new Scanner(System.in);
//		String signed_up=sc.nextLine();
//		if(signed_up.equalsIgnoreCase("Yes"))
//		{
//			
//			System.out.println("Enter email ID");
//			String email=sc.nextLine();
//			System.out.println("Enter password");
//			String pass=sc.nextLine();
//			Student s=a.getStudent(email,pass);
//			Admin admin=a.getAdmin(email,pass);
//			if(s==null && admin==null)
//			{
//				System.out.println("No correct email found");
//				continue;
//			}
//			else if(s==null && admin!=null)
//			{
//				System.out.println("Signing up as Admin");
//				Thread t=new Thread(admin);
//				t.start();
//				try {
//					t.join();
//				}
//				catch(Exception e)
//				{
//					System.out.println(e.getMessage());
//				}
//				continue;
//			}
//			else if(admin==null && s!=null)
//			{
//				System.out.println("Successfully Logged In !!\n");
//				Thread t=new Thread(s);
//				t.start();
//				try {
//					t.join();
//					
//				}
//				catch(Exception e)
//				{
//					System.out.println(e.getMessage());
//				}
//				continue;
//			}
//		}
//		else if(signed_up.equalsIgnoreCase("No"))
//		{
//			Student s=new Student();
//			s.signup(a);
//			continue;
//		}
//		else if(signed_up.equalsIgnoreCase("Exit"))
//		{
//			
//			break;
//		}
//		else
//		{
//			
//			System.out.println("Invalid Input Please enter valid input"+signed_up+"\n");
//			String []s=new String[1];
//			s[0]="";
//			continue;
//		}
//		}
		
	}
}

