//Nikhil Sethi
//1213414
//Assignment three
//Reference: http://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author NikhilSethi
 */
public class callbacks extends Application {
    //Declaring variables, setting text fields 
    //Text area is set and check box. All these variables can be used as  there globaly declared
	private TextField fnameF, lnameF, addF, cityF, countryF, pcF;
	private TextArea txtArea;
	private CheckBox cb;
	private Text actiontarget;
	//This method gets the text which is entered in each text field and 
	//puts the enetered text into the text area
	//Aligning it properly by breaking it 
	public void input()
	{
		//each text field is set as a string to grab the text from that
		String fname = fnameF.getText();
		String lname = lnameF.getText();
		String city = cityF.getText();
		String add = addF.getText();
		String pc = pcF.getText();
		txtArea.setText(fname +" " + lname + "\n" +"\n"+ add + "\n" + city + " " + pc);
	}

   @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome to JAVAFX App");
        
        primaryStage.show();
        //Using the grid pane for the setting the layout of the form
        //setting hoeizontal and vertical gap between each widgets like textbox and labels
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Scene scene = new Scene(grid, 900, 300);
        primaryStage.setScene(scene);

		//Adding the labels and textfield in the scene 
		//There is a certain position for each label and textbox
        Text scenetitle = new Text("Please enter the your information");
        scenetitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        //Setting labels for each widget and setting the right position for it
        Label name = new Label("First Name:");
        grid.add(name, 0, 1);

        Label lname = new Label("Last Name:");
        grid.add(lname, 2, 1);

        Label address = new Label("Address:");
        grid.add(address, 0, 2);

        Label city = new Label("City:");
        grid.add(city, 2, 2);

        Label pC = new Label("Post Code:");
        grid.add(pC,0,3);

 		Label dob = new Label("DOB");
		grid.add(dob, 2, 3);

        DatePicker dobDP = new DatePicker();
		grid.add(dobDP, 3, 3);
     
        Label country = new Label("Country:");
        grid.add(country,0,4);

//-----------------------------------------------------------------------
        //Setting each textfields position
        fnameF = new TextField();
        grid.add(fnameF, 1, 1);

        lnameF = new TextField();
        grid.add(lnameF, 3, 1);

        addF = new TextField();
        grid.add(addF, 1, 2);

        cityF = new TextField();
        grid.add(cityF, 3, 2);

        pcF = new TextField();
        grid.add(pcF, 1, 3);

        countryF = new TextField();
        grid.add(countryF, 1, 4);

        txtArea = new TextArea();
        grid.add(txtArea, 5,0,1,6);
        txtArea.setPrefWidth(300);

        cb = new CheckBox("Include Country");
        grid.add(cb,3,4);

        
       
//-----------------------------------------------------------------------
    //This is an event handler for the checkbox, so if check is ticked the the 
    //following instruction will be executed. 
    cb.setOnAction(new EventHandler<ActionEvent>() 
    { 
    @Override
    public void handle(ActionEvent event) 
    	{
    		//Making an array list of countries that should be entered in the 
    		//textbox, and if it is not entered in textfield then it error checks.
    		String[] countries = {"New Zealand", "USA", "Australia", "India", "Dubai"};
       		String getCountry;
       
    		//this for loop, loops through the countried in the list and makes sure this is entered 
    		for(int i=0; i<=countries.length; i++)  
    		{
    			if(countries[i].equals(countryF.getText()))
    			{
    				//Calling the input method
    				input();
    				//Getting the text from the country field
    				getCountry = countryF.getText();
    				//This checks if checkbox is ticked
    				if(cb.isSelected())
    				//Writes the text in the text area 
    				txtArea.appendText("\n"+getCountry);
    				//Setting color green of the text message
    				actiontarget.setFill(Color.GREEN);
        			actiontarget.setText("Great, the country matches");
    				countryF.setStyle("");
    				return;
    			}
    			else
    			{
    				//Setting the text area to be blank if the country does not match
    				txtArea.setText("");
    				//Setting color for the text field for the country
    				countryF.setStyle("-fx-background-color: #CC3333;");
    				actiontarget.setFill(Color.RED);
        			actiontarget.setText("Country Does not match");
					//Calling the method
    				input();
    			}
    			
    		}
    	}
	});
//---------------------------------------------------------------------
//This action event for "setOnKeyReleased" is used each text field to 
//to get the live typing in the text area so as the user types a letter it gets printed
//out on the text area and then input method is called
	fnameF.setOnKeyReleased(new EventHandler<KeyEvent>()
	{
		@Override
		public void handle(KeyEvent ke)
		{
			input();
		}
	});

	lnameF.setOnKeyReleased(new EventHandler<KeyEvent>()
	{
		@Override
		public void handle(KeyEvent ke)
		{
			input();
		}
	});

	cityF.setOnKeyReleased(new EventHandler<KeyEvent>()
	{
		@Override
		public void handle(KeyEvent ke)
		{
			input();
		}
	});

	addF.setOnKeyReleased(new EventHandler<KeyEvent>()
	{
		@Override
		public void handle(KeyEvent ke)
		{
			input();
		}
	});

	pcF.setOnKeyReleased(new EventHandler<KeyEvent>()
	{
		@Override
		public void handle(KeyEvent ke)
		{
			input();
		}
	});
       
//-----------------------------------------------------------------------
//This creates a button on the scene and allow user to inteact with it
//This sets the position, alignment of the text on the scene
        Button btn = new Button("Submit");
        HBox hbBtn = new HBox(30);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 3, 5);

        actiontarget = new Text();
        grid.add(actiontarget, 1, 5);
        
        btn.setOnAction(new EventHandler<ActionEvent>() 
        { 
    @Override
    public void handle(ActionEvent e) 
    {
        actiontarget.setFill(Color.GREEN);
        actiontarget.setText("Form has been submitted");
    }
});
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                launch(args);
        }
}
