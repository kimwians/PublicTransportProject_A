package application.Controllers;

import java.sql.SQLException;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private Label mainMenuText;

	@FXML
	private TextField usernameInput;

	@FXML
	private TextField passwordInput;

	@FXML
	private Button loginButton;

	@FXML
	private Button forgotPasswordButton;

	public void login(ActionEvent event) throws ClassNotFoundException, SQLException {

		String username = usernameInput.getText().toString();
		String password = passwordInput.getText().toString();

		Database.getConnection();
		Database.login(username, password);
		Database.closeConnection();

	}

}
