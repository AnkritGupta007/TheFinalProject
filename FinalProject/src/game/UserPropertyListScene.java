package game;

import java.io.FileNotFoundException;
import java.util.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import logic.GameManager;
import logic.Player;
import logic.Property;
import javafx.scene.input.*;


public class UserPropertyListScene {
	@SuppressWarnings("restriction")
	public static Scene getScene() {
		TableView tableView = new TableView();
		
		TableColumn<String, Property> column1 = new TableColumn<>("Property Name");
		TableColumn<String, Property> column2 = new TableColumn<>("Fee");
		TableColumn<String, Property> column3 = new TableColumn<>("Sell Price");
		
		column1.setCellValueFactory(new PropertyValueFactory<>("propertyName"));
		column2.setCellValueFactory(new PropertyValueFactory<>("propertyFee"));
		column3.setCellValueFactory(new PropertyValueFactory<>("propertyPrice"));
		
		tableView.getColumns().add(column1);
		tableView.getColumns().add(column2);
		tableView.getColumns().add(column3);

		List<Property> properties = GameManager.currentPlayer.getOwnedProperties();
		for(Property p : properties) {
			tableView.getItems().add(p);
		}
		tableView.setPlaceholder(new Label("No rows to display."));
		
		//NOT FINISHED OR WORKING, DOUBLE CLICK EXAMPLE
		tableView.setOnMouseClicked((MouseEvent event) -> {
			if(event.getButton().equals(MouseButton.PRIMARY)&& event.getClickCount() == 2) {
				GameManager.changeScene(SellConfirmationScene.getScene());
			}
		});
		
		VBox vbox = new VBox(tableView);
		
		Scene scene = new Scene(vbox);
		
		return scene;
	}
}