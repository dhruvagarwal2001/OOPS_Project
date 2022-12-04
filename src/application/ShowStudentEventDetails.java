package application;
import javafx.application.*;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.*;
public class ShowStudentEventDetails {
	public static void display(Audi a,Student s)
	{
		Stage window=new Stage();
		window.setTitle("Events");
		window.setMinHeight(400);
		window.setMinWidth(400);
		GridPane grid=new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		Label label=new Label();
		label.setText("Hello "+s.getFirstName()+"\nFollowing are the events for today");
		GridPane.setConstraints(label, 0, 0);
		
		int row=1;
		VBox layout=new VBox();
		layout.getChildren().addAll(label);
		layout.setAlignment(Pos.CENTER);
		for(Event e:a.getArr().values())
		{
			Label label1=new Label();
			label1.setText(e.getEventId()+". "+e.getEventName());
			GridPane.setConstraints(label1, 0, row);
			row++;
			layout.getChildren().addAll(label1);
		}
		
		Label EventId=new Label("Event ID to know more about that event");
		GridPane.setConstraints(EventId,0,row);
		row++;
		layout.getChildren().addAll(EventId);
		TextField eventid=new TextField();
		eventid.setMaxHeight(1);
		eventid.setMaxWidth(200);
		eventid.setPromptText("1");
		GridPane.setConstraints(eventid, 0, row);
		row++;
		layout.getChildren().add(eventid);
		Button show=new Button();
		GridPane.setConstraints(show,0,row);
		
		show.setText("Show");
		Button logout=new Button();
		GridPane.setConstraints(logout,1,row);
		
		logout.setText("logout");
		Button profile=new Button();
		GridPane.setConstraints(profile,2,row);
		logout.setOnAction(e->{
			window.close();
			System.out.println("Successfully Logged out!!");
			LoginDetails.acceptdetails(a);
			return;});
		profile.setText("Profile");
		show.setOnAction(e->{
			
			try {
				int id=Integer.parseInt(eventid.getText());
			if(id>a.getArr().values().size() || id<=0)
			{
				throw new NumberFormatException();
			}
			}
			catch(NumberFormatException exec)
			{
				AlertBox.display("Alert", "Enter correct Event ID", "Close");
				ShowStudentEventDetails.	display(a, s);
				window.close();
				return;
			}
//			Platform.runLater(()->);
			window.close();
			ShowEventDetails.display(a,s,a.getArr().get(Integer.parseInt(eventid.getText()))) ;
				
		});
		profile.setOnAction(exp->{
			window.close();
			ShowProfile.display(a, s);
			
		});
		layout.getChildren().addAll(show,logout,profile);
		Scene scene=new Scene(layout);
		window.setScene(scene);
		window.show();
		
	}
}
