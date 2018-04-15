package com.timetable.ui.data;

import java.net.URL;
import java.util.ResourceBundle;

import com.timetable.core.constraint.Constraint;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BasicInfoUIController implements Initializable {
	@FXML
    private VBox rootContainer;

    @FXML
    private Label collegeName;

    @FXML
    private Button collegeNameModifyButton;

    @FXML
    private ListView<String> daysList;


    @FXML
    private Button addDaysButton;

    @FXML
    private ListView<?> hoursList;


    @FXML
    private Button addHoursButton;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		collegeName.setText(Constraint.getInstance().getCollegeName());
		daysList.getItems().addAll(Constraint.getInstance().getDays());
		
		
		
	}

    @FXML
    void addDays(ActionEvent event) {
    	displayNewWindow("/com/timetable/ui/data/daysPickerUI.fxml", "Select Days");
    		
    }

    @FXML
    void addHours(ActionEvent event) {
    	displayNewWindow("/com/timetable/ui/data/daysPickerUI.fxml", "Add Hours");
    }

    @FXML
    void modifyName(ActionEvent event) {
    	
    	displayNewWindow("/com/timetable/ui/data/modifyUI.fxml", "Modify Name");
  
    }
    
    private void displayNewWindow(String loc,String title) {
    	try {
			Parent window = FXMLLoader.load(getClass().getResource(loc));
			Stage newStage = new Stage(StageStyle.DECORATED);
			newStage.setTitle(title);
			newStage.setScene(new Scene(window));
			newStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	

}
