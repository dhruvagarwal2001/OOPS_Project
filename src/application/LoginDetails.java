package application;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
public class LoginDetails {
	public static void acceptdetails(Audi a)
	{
		Stage window=new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Login");
		GridPane grid=new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		Label emailLabel=new Label("Email ID:");
		GridPane.setConstraints(emailLabel, 0, 0);
		TextField email=new TextField();
		email.setPromptText("1234@gmail.com");
		GridPane.setConstraints(email, 1, 0);
		Label passlabel=new Label("Password:");
		GridPane.setConstraints(passlabel, 0, 1);
		TextField password=new TextField();
		password.setPromptText("password");
		GridPane.setConstraints(password, 1, 1);
		Button loginButton=new Button("Login");
		loginButton.setOnAction(e-> {
			Student s=a.getStudent(email.getText(), password.getText());
			Admin admin=a.getAdmin(email.getText(),password.getText());
			if(s==null && admin==null)
			{
				AlertBox.display("Alert","Invalid Login Credentials","Close");
				
			}
			else if(s==null && admin!=null)
			{
				System.out.println("Signing up as Admin");
				
				Thread t=new Thread(admin);
				t.start();
				window.close();
				try {
					t.join();
				}
				catch(Exception ep)
				
				{
					System.out.println(ep.getMessage());
				}
				
				
			}
			else if(admin==null && s!=null)
			{
				System.out.println("Successfully Logged In !!\n");
				s.setStage(window);
				Thread t=new Thread(s);
				
				t.start();
				window.close();
				try {
					t.join();
				}
				catch(Exception ep)
				
				{
					System.out.println(ep.getMessage());
				}
				
			}
		});
		GridPane.setConstraints(loginButton, 1, 2);
		grid.getChildren().addAll(emailLabel,email,passlabel,password,loginButton);
		Scene scene=new Scene(grid,300,300);
		window.setScene(scene);
		window.show();
		
		
	}
	
}
