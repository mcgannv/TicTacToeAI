package tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class StartUpController {
    @FXML
    ToggleGroup turnGroup;
    @FXML
    ToggleGroup shapeGroup;
    @FXML
    RadioButton yesRadioBtn;
    @FXML
    RadioButton noRadioBtn;
    @FXML
    RadioButton xRadioBtn;
    @FXML
    RadioButton oRadioBtn;
    @FXML
    Button acceptBtn;
    @FXML
    Button cancelBtn;

    private TicTacToeController ticTacToeController;
    private Stage stage2;

    public void setMainController(TicTacToeController mainController, Stage stage2) {
        this.ticTacToeController = mainController;
        this.stage2 = stage2;
    }

    @FXML
    public void acceptHandler() {
        Player player;
        ComputerPlayer computerPlayer;
        Turn turn;
        if (turnGroup.getSelectedToggle() == yesRadioBtn) {
            turn = Turn.HUMAN;
        } else {
            turn = Turn.COMPUTER;
        }

        if (shapeGroup.getSelectedToggle() == xRadioBtn) {
            player = new Player('X');
            computerPlayer = new ComputerPlayer('O');
        } else {
            player = new Player('O');
            computerPlayer = new ComputerPlayer('X');
        }
        ticTacToeController.setPlayers(player, computerPlayer, turn);
        closeHandler();
    }

    @FXML
    public void checkToggles() {
        if ((turnGroup.getSelectedToggle() == null) || (shapeGroup.getSelectedToggle() == null)) {
            acceptBtn.setDisable(true);
        } else {
            acceptBtn.setDisable(false);
        }
    }

    @FXML
    public void closeHandler() {
        stage2.close();
    }
}
