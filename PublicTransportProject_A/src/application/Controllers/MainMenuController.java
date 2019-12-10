package application.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class MainMenuController implements Initializable{
	public Button signUpButton;
	public Button loginButton;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		signUpButton.setMinSize(150,20);
		loginButton.setMinSize(150,20);
	}
	
	public void goToLogin(){
        Parent root=null;
		try {
			root = FXMLLoader.load(getClass().getResource("../Views/Login.fxml"));
	 	    Main.primaryStage.getScene().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void goToRegister() {
        Parent root=null;
		try {
			root = FXMLLoader.load(getClass().getResource("../Views/Register.fxml"));
	 	    Main.primaryStage.getScene().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


}
