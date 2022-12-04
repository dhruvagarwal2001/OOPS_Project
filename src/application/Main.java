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
	}
}

