package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

/**
 * Controller for FXML-doc FirstMenu.fxml.
 * 
 * @author Lykke Levin
 * @version 1.0
 *
 */

public class UIController  {

	private ChangeScene changeScene;
	@FXML
	private Slider volumeSlider;
	@FXML
	private TextField tfNameInput;
	@FXML
	private ImageView ivNewGame;
	@FXML
	private ImageView ivLoadGame;
	@FXML
	private ImageView ivSound;

	private boolean muteSound;
	private Sound sound;
	public static double volume = 1;

	//public UIController() {
	//	Image image = new Image(Paths.get("resources/images/soundButton.png").toUri().toString());
	//	ivSound.setImage(image);
	//}


	/**
	 * Generated method for the FXML.
	 *
	 * @throws Exception
	 */
	public void initialize() throws Exception {

		volumeSlider.setValue(UIController.volume);
		volumeSlider.valueProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				Sound.mp.setVolume(volumeSlider.getValue() / volumeSlider.getMax());
				UIController.setVolume(volumeSlider.getValue());
			}
		});
	}

	/**
	 * Sets the changeScene for this UIController
	 *
	 * @param sceneChanger an instance of the class ChangeScene
	 */
	public void setChangeScene(ChangeScene sceneChanger) {
		this.changeScene = sceneChanger;

	}

	/**
	 * Tells class changeScene to perform the swithScene-action.
	 *
	 * @throws Exception
	 */
	public void NewGameClicked() throws Exception {

		changeScene.switchScenetoSetting();

	}

	/**
	 * Should load a saved game file. This method is currently a non-functional
	 * method that is not implemented for the final version.
	 *
	 * @throws IOException
	 */
	public void LoadGameClicked() throws IOException {
		// fileHandler = new FileHandler();
		// String pot = fileHandler.loadPot();
		// System.out.println(fileHandler.loadPot());

//		System.out.println("LoadGame");
//		sound = new Sound();
//		sound.playSound("wrong");

	}

	public void soundSetting(MouseEvent mouseEvent) {
		if (!muteSound) {
			Image image = new Image(Paths.get("resources/images/soundButtonOff.png").toUri().toString());
			ivSound.setImage(image);
			sound.muteSound(true);
			muteSound = true;

		} else if (muteSound) {
			Image image = new Image(Paths.get("resources/images/soundButton.png").toUri().toString());
			ivSound.setImage(image);
			sound.muteSound(false);
			muteSound = false;
		}
	}

	public static void setVolume(double volume) {
		UIController.volume = volume;
	}

	public static double getVolume() {
		return UIController.volume;
	}

}



