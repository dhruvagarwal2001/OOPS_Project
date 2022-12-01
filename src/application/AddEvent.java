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
public class AddEvent {
	
	public static void display(Audi a,Admin s)
	{
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinHeight(400);
		window.setMinWidth(400);
		window.setTitle("Add Event");
		GridPane grid=new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		Label fnamelabel=new Label("Event Name");
		GridPane.setConstraints(fnamelabel, 0, 0);
		TextField fname=new TextField();
		fname.setPromptText("Event Name");
		GridPane.setConstraints(fname, 1, 0);
		grid.getChildren().addAll(fnamelabel,fname);
		Label lnamelabel=new Label("Event Description");
		GridPane.setConstraints(lnamelabel, 0, 1);
		TextField lname=new TextField();
		GridPane.setConstraints(lname, 1, 1);
		lname.setPromptText("Event Description");
		grid.getChildren().addAll(lnamelabel,lname);
		Label emailLabel=new Label("Enter Start Time in format HH:MMam/pm");
		GridPane.setConstraints(emailLabel, 0, 2);
		TextField email=new TextField();
		email.setPromptText("Start Time");
		GridPane.setConstraints(email, 1, 2);
		grid.getChildren().addAll(emailLabel,email);
		Label passlabel=new Label("Enter End Time in format HH:MMam/pm");
		GridPane.setConstraints(passlabel, 0, 3);
		TextField password=new TextField();
		password.setPromptText("End Time");
		GridPane.setConstraints(password, 1, 3);
		grid.getChildren().addAll(passlabel,password);
		Label cost=new Label("Event Cost:");
		GridPane.setConstraints(cost, 0, 4);
		TextField costfield=new TextField();
		costfield.setPromptText("Event Cost");
		grid.getChildren().addAll(cost,costfield);
		Button change=new Button("Add");
		Button back=new Button("back");
		change.setOnAction(ex-> {
			
			try {
				int newcost=Integer.parseInt(costfield.getText());
				Event newevent=new Event(fname.getText(),email.getText(),password.getText(),lname.getText(),a.getArr().values().size()+1,newcost);
				a.getArr().put(newevent.getEventId(), newevent);
				window.close();
				System.out.println("Successfully Event Added!!");
				ShowAdminEvents.display(a, s);
			}
			catch(Exception exception)
			{
				window.close();
				AlertBox.display("Alert", "Wrong Cost Entered", "Close");
				AddEvent.display(a,s);
				
			}
			
			});
		GridPane.setConstraints(change, 1, 5);
		GridPane.setConstraints(back, 1, 6);
		back.setOnAction(exp->{
			
			window.close();
			ShowAdminEvents.display(a, s);
			
		});
		grid.getChildren().addAll(change,back);
		Scene scene=new Scene(grid,300,300);
		window.setScene(scene);
		window.show();
		
		
	}
	
}
