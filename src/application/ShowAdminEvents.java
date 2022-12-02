package application;
import javafx.application.*;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.*;
public class ShowAdminEvents {
	public static void display(Audi a,Admin s)
	{
		Stage window=new Stage();
		window.setTitle("Events");
		window.setMinHeight(800);
		window.setMinWidth(800);
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
			label1.setText(e.getEventId()+". "+e.getEventName()+": "+e.getDesc()+"\n"+e.getStartTime()+"-"+e.getEndTime()+"\nCost:"+e.getCost()+"\n"+"Total Sales :"+e.getTotalSales()+"\n");
			GridPane.setConstraints(label1, 0, row);
			row++;
			layout.getChildren().addAll(label1);
		}
		
		Label EventId=new Label("Event ID to Edit the event");
		GridPane.setConstraints(EventId,0,row);
		row++;
		layout.getChildren().add(EventId);
		ChoiceBox<Integer> ch=new ChoiceBox<Integer>();
		GridPane.setConstraints(ch, 0, row);
		row++;
		for(Event event:a.getArr().values())
		{
			ch.getItems().add(event.getEventId());
		}
		layout.getChildren().add(ch);
		Button edit=new Button();
		GridPane.setConstraints(edit,0,row);
		row++;
		edit.setText("Edit Event");
		Button logout=new Button();
		GridPane.setConstraints(logout,1,row);
		row++;
		logout.setText("logout");
		Button addevent=new Button();
		GridPane.setConstraints(addevent,1,row);
		row++;
		addevent.setText("Add Event");
		addevent.setOnAction(ep->{
			window.close();
			AddEvent.display(a,s);
		});
		logout.setOnAction(e->{
			window.close();
			System.out.println("Successfully Logged out!!");
			LoginDetails.acceptdetails(a);
			return;});
		
		edit.setOnAction(e->{
			
			int id=ch.getValue();
			window.close();
			ChangeEventDetails.display(a,s,a.getArr().get(id));
				
		});
		
		layout.getChildren().addAll(edit,logout,addevent);
		Scene scene=new Scene(layout);
		window.setScene(scene);
		window.show();
		
	}
}
