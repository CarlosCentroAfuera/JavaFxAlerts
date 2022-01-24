package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Controller {


	private void showAlert(Alert alert) {
		Optional<ButtonType> resultado = alert.showAndWait();
		if(!resultado.isPresent()) {
			System.out.println("Dialogo cerrado con la X");
		} else if(resultado.get() == ButtonType.OK) {
			System.out.println("Resultado = OK");
		} else if (resultado.get() == ButtonType.CANCEL) {
			System.out.println("Resultado = CANCEL");
		} else {
			System.out.println("Resultado = OTROS: " + resultado.get().getText());
		}
	}

	@FXML
	private void onConfirmationClicked(ActionEvent event) {
		showAlert(new Alert(Alert.AlertType.CONFIRMATION));
	}

	@FXML
	private void onErrorClicked(ActionEvent event) {
		showAlert(new Alert(Alert.AlertType.ERROR));
	}

	@FXML
	private void onInformationClicked(ActionEvent event) {
		showAlert(new Alert(Alert.AlertType.INFORMATION));
	}

	@FXML
	private void onWarningClicked(ActionEvent event) {
		showAlert(new Alert(Alert.AlertType.WARNING));
	}

	@FXML
	private void onPersonalizadoClicked(ActionEvent event) {
		Alert customAlert = new Alert(Alert.AlertType.NONE);
		customAlert.setTitle("Mi título");
		customAlert.setContentText("Este es mi diálogo");
		customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.FINISH, ButtonType.NO);
		showAlert(customAlert);
	}

}