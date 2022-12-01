package application;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class helloworld extends Application{
	
	Stage window;
	Button button;
	public static void main(String args[])
{
		
		launch(args);
}
	@Override
	public void start(Stage primarystage) throws Exception
	{
		window=primarystage;
		window.setTitle("Title of the window");
		button=new Button("click me");
		button.setOnAction(e->{
			boolean result=ConfirmBox.display("Title of window", "Are you sure you want ot get out");
			System.out.println(result);
				});
		StackPane layout1=new StackPane();
		layout1.getChildren().add(button);
		Scene scene1=new Scene(layout1,300,250);
		window.setScene(scene1);
		window.show();
	}
	
}
