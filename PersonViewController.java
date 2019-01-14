package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PersonViewController implements Initializable {

	private Person selectedPerson;
	    
	@FXML private Label firstNameLabel;
	@FXML private Label lastNameLabel;    
	@FXML private Label birthdayLabel;
	@FXML private Label ageLabel;
	@FXML private ImageView photo;
	
	private FileChooser fileChooser;
	private File filePath;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	 /**
     * Method will allow user to change the image from the hard disk.
     */
	public void chooseImageButtonPushed(ActionEvent event) {
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		fileChooser = new FileChooser();
		fileChooser.setTitle("Open Image");
		
		// set to the users favourite directory
		String userDirectoryString = System.getProperty("user.home") + "\\Pictures";
		File userDirectory = new File(userDirectoryString);
		
		if (!userDirectory.canRead())
			userDirectory = new File("c:/");
		
		fileChooser.setInitialDirectory(userDirectory);
		this.filePath = fileChooser.showOpenDialog(stage);
		
		// try to update the image from the filechoosers path
		try {
			BufferedImage bufferedImage = ImageIO.read(this.filePath);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);		
			selectedPerson.setImage(image);
			photo.setImage(selectedPerson.getImage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
    /**
     * When this method is called, it will change the Scene to 
     * a TableView example
     */
	public void changeScreenButtonPushed(ActionEvent event) throws IOException
{
    Parent tableViewParent = FXMLLoader.load(getClass().getResource("TableViewExample_View.fxml"));
    Scene tableViewScene = new Scene(tableViewParent);
    
    //This line gets the Stage information
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    
    window.setScene(tableViewScene);
    window.show();
}
	
	/**
    * This method accepts a person to initialize the view
    * @param person 
    */
	public void initData(Person person) {
		selectedPerson = person;
		firstNameLabel.setText(selectedPerson.getFirstName());
		lastNameLabel.setText(selectedPerson.getLastName());
		birthdayLabel.setText(selectedPerson.getBirthday().toString());
		ageLabel.setText(Integer.toString(selectedPerson.getAge()));
		photo.setImage(selectedPerson.getImage());
     }
}