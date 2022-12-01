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
public class SignupDetails {
	
	public static void acceptdetails(Audi a)
	{
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Signup");
		GridPane grid=new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		Label fnamelabel=new Label("First Name");
		GridPane.setConstraints(fnamelabel, 0, 0);
		TextField fname=new TextField();
		fname.setPromptText("1234@gmail.com");
		GridPane.setConstraints(fname, 1, 0);
		Label lnamelabel=new Label("Last Name:");
		GridPane.setConstraints(lnamelabel, 0, 1);
		TextField lname=new TextField();
		GridPane.setConstraints(lname, 1, 1);
		
		Label emailLabel=new Label("Email ID:");
		GridPane.setConstraints(emailLabel, 0, 2);
		TextField email=new TextField();
		email.setPromptText("1234@gmail.com");
		GridPane.setConstraints(email, 1, 2);
		Label passlabel=new Label("Password:");
		GridPane.setConstraints(passlabel, 0, 3);
		TextField password=new TextField();
		password.setPromptText("password");
		GridPane.setConstraints(password, 1, 3);
		Button signupButton=new Button("Signup");
		signupButton.setOnAction(e-> {
			Student s=new Student(fname.getText(),lname.getText(),email.getText(),password.getText(),a);
			a.getAllcustomers().add(s);
			Thread thread=new Thread(s);
			thread.start();
			window.close();
			try {
				thread.join();
			}
			catch(Exception excep)
			{
				System.out.println(excep.getMessage());
			}
			LoginDetails.acceptdetails(a);
			});
		GridPane.setConstraints(signupButton, 1, 4);
		grid.getChildren().addAll(fnamelabel,fname,lnamelabel,lname,emailLabel,email,passlabel,password,signupButton);
		Scene scene=new Scene(grid,300,300);
		window.setScene(scene);
		window.show();
		
		
	}
	
}
