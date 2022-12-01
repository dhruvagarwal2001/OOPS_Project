package application;
import javafx.application.*;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.*;
public class ShowProfile {
	public static void display(Audi a,Student s)
	{
		Stage window=new Stage();
		window.setTitle("Profile");
		window.setMinHeight(400);
		window.setMinWidth(400);
		GridPane grid=new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		Label label=new Label();
		label.setText("Here are the events that you have booked");
		
		GridPane.setConstraints(label, 0, 0);
		
		int row=1;
		VBox layout=new VBox();
		layout.getChildren().addAll(label);
		layout.setAlignment(Pos.CENTER);
		for(Event selectedevent:s.getBookedEvents().keySet())
			
		{
			String temp="";
			
			temp=temp+Long.toString(selectedevent.getEventId())+" "+selectedevent.getEventName()+": "+selectedevent.getDesc()+"\nTime:"+selectedevent.getStartTime()+" - "+selectedevent.getEndTime()+"\n";
			Label label1=new Label(temp);
			GridPane.setConstraints(label1,0,row);
			layout.getChildren().add(label1);
			row++;
		}
		
		Label EventId=new Label("Enter the Event ID for which you want to cancel the tickets:");
		GridPane.setConstraints(EventId,0,row);
		row++;
		ChoiceBox<Integer>ch=new ChoiceBox<Integer>();
		for(Event ev:s.getBookedEvents().keySet())
		ch.getItems().add(ev.getEventId());
		GridPane.setConstraints(ch,0,row);
		row++;
		layout.getChildren().add(ch);
		
		
		Button logout=new Button();
		GridPane.setConstraints(logout,1,row);
		
		logout.setText("logout");
		Button back=new Button();
		row++;
		GridPane.setConstraints(back,2,row);
		row++;
		logout.setOnAction(ep->{
			window.close();
			System.out.println("Successfully Logged out!!");
			LoginDetails.acceptdetails(a);
			return;});
		back.setText("<-Back");
		back.setOnAction(epe->{
			window.close();
			ShowStudentEventDetails.display(a, s);
			return;
		});
		Button cancel=new Button();
		GridPane.setConstraints(cancel,3,row);
		row++;
		
		cancel.setText("Cancel Tickets");
		cancel.setOnAction(ex->{
int n=ch.getValue();
if(n!=0)
{
window.close();
CancelEvent.display(a, s,a.getArr().get(n));}
		});	
		layout.getChildren().addAll(logout,back,cancel);
		Scene scene=new Scene(layout);
		window.setScene(scene);
		window.show();
		
		
	}
}



