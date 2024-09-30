
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	Button helloButton;
	Button howdyButton;
	Button chineseButton;
	Button clearButton;
	Button exitButton;
	Label label;
	HBox box1;
	HBox box2;
	TextField textField = new TextField();

	//student Task #4:
	//  declare an instance of DataManager
	DataManager manager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		helloButton = new Button("Hello");
		howdyButton = new Button("Howdy");
		chineseButton = new Button("Chinese");
		clearButton = new Button("Clear");
		exitButton = new Button("Exit");
		label = new Label("Feedback: ");
		textField = new TextField();
		box1 = new HBox();
		box2 = new HBox();
		box1.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);
		box2.getChildren().addAll(label, textField);
		this.getChildren().addAll(box1, box2);
		box1.setMargin(helloButton, new Insets(5));
		box1.setMargin(howdyButton, new Insets(5));
		box1.setMargin(chineseButton, new Insets(5));
		box1.setMargin(clearButton, new Insets(5));
		box1.setMargin(exitButton, new Insets(5));
		box2.setMargin(label, new Insets(10));
		box2.setMargin(textField, new Insets(10));
		box1.setAlignment(Pos.CENTER);
		box2.setAlignment(Pos.CENTER);
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		manager = new DataManager();
		helloButton.setOnAction(new ButtonHandler());
		howdyButton.setOnAction(new ButtonHandler());
		chineseButton.setOnAction(new ButtonHandler());
		clearButton.setOnAction(new ButtonHandler());
		exitButton.setOnAction(new ButtonHandler());
		textField.setOnAction(new ButtonHandler());
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
	
		
	}
	
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			if (event.getTarget() == helloButton) {
				textField.setText(manager.getHello());
			} else if (event.getTarget() == howdyButton) {
				textField.setText(manager.getHowdy());
			} else if (event.getTarget() == chineseButton) {
				textField.setText(manager.getChinese());
			} else if (event.getTarget() == clearButton) {
				textField.setText("");
			} else {
				Platform.exit();
				System.exit(0);
			}
			
		}
		
	}
	
}