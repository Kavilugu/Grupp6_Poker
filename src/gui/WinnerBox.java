package gui;


import java.nio.file.Paths;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Box that shows the winner of round. 
 * @author Lykke Levin 
 * version 1.0
 *
 */
public class WinnerBox{

	public boolean answer = false;
	public Stage window = new Stage();
	public Font font = new Font("Tw Cen MT", 18);
	private ImageView back = new ImageView(Paths.get("resources/images/background.png").toUri().toString());
	private ImageView btnOk = new ImageView(Paths.get("resources/images/okButton.png").toUri().toString());
	private boolean wantToRun = false;

	/**
	 * Creates a window containting messages of who won or lost. 
	 * @param title String title of the window from the method that uses WinnerBox. 
	 * @param message String message to display in the window from the method that uses ConfirmBox. 
	 * @param nr Int to check which message should be displayed. 
	 * @param handStrength String to print the handstrength the player or AI won with. 
	 * @return answer Boolean that returns an answer.
	 */
	public boolean displayWinner(String title, String message, int nr, String handStrength) {
		
		String aiWin = new String("Rundan vanns av " + message + " som hade " + handStrength);
		String playerWin = new String("Grattis " + message + ", du vann den här rundan! Du vann med " + handStrength);
		String playerWinAIFold = new String("Grattis " + message + ". " + handStrength);
		String aiWinOthersFold = new String("Rundan vanns av " + message + " " + handStrength);
		String playerLose = new String (message);
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setWidth(400);
		window.setHeight(200);
		window.setOnCloseRequest(e -> {
			answer = true;
			closeProgram();
		});

		Pane pane = new Pane();

		Label messageText = new Label();
		messageText.setFont(font);
		messageText.setTextFill(Color.WHITE);
		messageText.setWrapText(true);
		
		if(nr == 1){
			messageText.setText(playerWin);
		} else if(nr == 2){
			messageText.setText(aiWin);
		} else if(nr == 3){
			messageText.setText(playerWinAIFold);
		} else if(nr == 4){
		messageText.setText(aiWinOthersFold);
		}
		else if (nr == 5){
			messageText.setText(playerLose);
		}
		
		btnOk.setOnMouseReleased(e -> {
			answer = true;
			closeProgram();
		});

		back.setFitHeight(window.getHeight());
		back.setFitWidth(window.getWidth());
		messageText.setPrefSize(200, 100);
		messageText.setLayoutX(100);
		messageText.setLayoutY(10);
		btnOk.setFitHeight(35);
		btnOk.setFitWidth(35);
		btnOk.setLayoutX(175);
		btnOk.setLayoutY(110);


		pane.getChildren().addAll(back, messageText, btnOk);

		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.showAndWait();
		return answer;
		
	}

	/**
	 * Closes the window. 
	 */
	public void closeProgram() {
		stopHold();
		window.close();
	}

	/**
	 * Method which sets the boolean running to true.
	 * This Method is called upon user click on the Winner Box's OK-button.
	 */
	public void stopHold(){
		wantToRun = true;
	}

	/**
	 * Getter for the running variable.
	 * Called in GameController to check status and then called by GameLogicController to keep holing the game or to start it again.
	 */
	public boolean wantingToRun(){
		return wantToRun;
	}
}
