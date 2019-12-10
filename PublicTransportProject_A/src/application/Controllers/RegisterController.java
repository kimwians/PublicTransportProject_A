package application.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RegisterController implements Initializable{

	public Button registerButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		registerButton.setMinSize(200,40);
	}

}
