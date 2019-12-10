package application;
	
import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		try {
	        Parent root = FXMLLoader.load(getClass().getResource("Views/SplashScreen.fxml"));
	        primaryStage.setTitle("Bus Booking System");
	        primaryStage.setScene(new Scene(root, 800, 500));
	        primaryStage.show();
	        PauseTransition delay = new PauseTransition(Duration.seconds(2));
			delay.setOnFinished( event -> {
				try {
					changeScene("Views/MainMenu.fxml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			delay.play();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void changeScene(String fxml) throws IOException{
	   Parent pane = FXMLLoader.load(getClass().getResource(fxml));
	   primaryStage.getScene().setRoot(pane);
	}
	
	
	
}
