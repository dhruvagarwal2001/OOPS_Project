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
public class ConfirmBox {
	static boolean answer;
	public static boolean display(String title,String message)
	{
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinHeight(250);
		window.setMinWidth(250);
		Label label=new Label();
		label.setText(message);
		Button yesbutton=new Button("yes");
		Button nobutton=new Button("no");
		yesbutton.setOnAction(e->{
			answer=true;
			window.close();
		});
		nobutton.setOnAction(e->{
			answer=false;
			window.close();
		});
		VBox layout=new VBox();
		layout.getChildren().addAll(label,yesbutton,nobutton);
		layout.setAlignment(Pos.CENTER);
		Scene scene=new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		return answer;
	}
}
