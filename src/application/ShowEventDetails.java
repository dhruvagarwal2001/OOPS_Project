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
public class ShowEventDetails {
	public static void display(Audi a,Student s,Event e)
	{
		Stage window=new Stage();
		window.setTitle("Event Details");
		window.setMinHeight(400);
		window.setMinWidth(400);
		GridPane grid=new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		Label label=new Label();
		label.setText(e.getEventName()+":"+e.getDesc()+"\nTime :"+e.getStartTime()+" - "+e.getEndTime()+"\nCost :"+e.getCost()+"\n'*'-Booked Seats\n'_'-Empty Seats");
		
		GridPane.setConstraints(label, 0, 0);
		
		int row=1;
		VBox layout=new VBox();
		layout.getChildren().addAll(label);
		layout.setAlignment(Pos.CENTER);
		
		int k=1;
		for(int i=0;i<20;i++)
		{
			String temp="";
			for(int j=0;j<10;j++)
			{
				if(i%2==0)
				{
					
					
					temp+=Integer.toString(k)+" ";
					if(k<10)
						{
						temp=temp+" ";
						}	
					k++;
				}
				else
				{
					if(!e.getAvailability(i/2, j))
					{
						
						temp=temp+" * ";
					}
					else
					{
						
						temp=temp+" _  ";
					}
				}
				
			}
			System.out.println();
			temp=temp+"\n";
			Label label1=new Label(temp);
			
			GridPane.setConstraints(label1,0,row);
			layout.getChildren().addAll(label1);
			row++;
		}
		
		
		Label EventId=new Label("How Many Tickets do you want to book:");
		GridPane.setConstraints(EventId,0,row);
		row++;
		ChoiceBox<Integer>ch=new ChoiceBox<Integer>();
		for(int i=0;i<=10;i++)
		ch.getItems().add(i);
		ch.setValue(0);
		GridPane.setConstraints(ch,0,row);
		row++;
		layout.getChildren().add(ch);
		Label Seatnum=new Label("Enter the Seat Numbers seperated by ','");
		GridPane.setConstraints(EventId,0,row);
		row++;
		TextField numberoftickets=new TextField();
		numberoftickets.setPromptText("1");
		GridPane.setConstraints(numberoftickets, 1, row);
		row++;
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
		Button book=new Button();
		GridPane.setConstraints(book,3,row);
		row++;
		
		book.setText("Book");
		book.setOnAction(ex->{
int n=ch.getValue();
			
			String yo=numberoftickets.getText();
			String ar[]=yo.split(",");
			int arr[]=new int[n];
			if(ar.length>n || ar.length<n || ar.length==0)
			{
				System.out.println(n);
				AlertBox.display("Alert", "Enter correct number of seats", "Close");
			}
			try {
			for(int i=0;i<n;i++)
			{
				arr[i]=Integer.parseInt(ar[i].trim())-1;
			}
			int x[]=new int[n];
			int y[]=new int[n];
			for(int i=0;i<n;i++)
			{
				x[i]=arr[i]/10;
				y[i]=arr[i]%10;
			}
			
			
			if(e.bookticks(x,y,n,s)==0)
			{
				AlertBox.display("Alert", "Entered Seats are already filled", "Close");
			}
			else
				{
				System.out.println("Seats Successfully Booked!!\n");
				window.close();
				ShowStudentEventDetails.display(a, s);
				}}
			catch(Exception exep)
			{
				AlertBox.display("Alert", "Invalid Input", "Close");
			}
		});
		layout.getChildren().addAll(Seatnum,numberoftickets,logout,back,book);
		Scene scene=new Scene(layout);
		window.setScene(scene);
		window.show();
		
	}
}
