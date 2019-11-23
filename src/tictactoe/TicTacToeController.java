package tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TicTacToeController {
    @FXML
    Button one;
    @FXML
    Button two;
    @FXML
    Button three;
    @FXML
    Button four;
    @FXML
    Button five;
    @FXML
    Button six;
    @FXML
    Button seven;
    @FXML
    Button eight;
    @FXML
    Button nine;

    private Player player;
    private Stage stage2;
    private Game game;
    private char piece;
    private Square square;

    @FXML
    private void initialize() {
       turnOffButtons();
    }


    public void setSecondStage(Stage stage2) {
        this.stage2 = stage2;
    }

    public void setNewGame(Player player, Game game, Square square) {
        this.player = player;
        this.game = game;
        this.square = square;
    }

    @FXML
    public void oneSelectHandler() {
        piece = player.getPiece();
        game.playerPlays(square, 0);
        one.setText(String.valueOf(piece));
        one.setDisable(true);
    }

    @FXML
    public void twoSelectHandler() {
        piece = player.getPiece();
        game.playerPlays(square, 1);
        two.setText(String.valueOf(piece));
        two.setDisable(true);
    }

    @FXML
    public void threeSelectHandler() {
        piece = player.getPiece();
        game.playerPlays(square, 2);
        three.setText(String.valueOf(piece));
        three.setDisable(true);
    }

    @FXML
    public void fourSelectHandler() {
        piece = player.getPiece();
        game.playerPlays(square, 3);
        four.setText(String.valueOf(piece));
        four.setDisable(true);
    }

    @FXML
    public void fiveSelectHandler() {
        piece = player.getPiece();
        game.playerPlays(square, 4);
        five.setText(String.valueOf(piece));
        five.setDisable(true);
    }

    @FXML
    public void sixSelectHandler() {
        piece = player.getPiece();
        game.playerPlays(square, 5);
        six.setText(String.valueOf(piece));
        six.setDisable(true);
    }

    @FXML
    public void sevenSelectHandler() {
        piece = player.getPiece();
        game.playerPlays(square, 6);
        seven.setText(String.valueOf(piece));
        seven.setDisable(true);
    }

    @FXML
    public void eightSelectHandler() {
        piece = player.getPiece();
        game.playerPlays(square, 7);
        eight.setText(String.valueOf(piece));
        eight.setDisable(true);
    }

    @FXML
    public void nineSelectHandler() {
        piece = player.getPiece();
        game.playerPlays(square, 8);
        nine.setText(String.valueOf(piece));
        nine.setDisable(true);
    }

    @FXML
    public void showStartUp() {
        stage2.show();
    }

    private void turnOffButtons() {
        one.setDisable(true);
        two.setDisable(true);
        three.setDisable(true);
        four.setDisable(true);
        five.setDisable(true);
        six.setDisable(true);
        seven.setDisable(true);
        eight.setDisable(true);
        nine.setDisable(true);
    }

    public void resetButtons() {
        one.setDisable(false);
        two.setDisable(false);
        three.setDisable(false);
        four.setDisable(false);
        five.setDisable(false);
        six.setDisable(false);
        seven.setDisable(false);
        eight.setDisable(false);
        nine.setDisable(false);
        one.setText("");
        two.setText("");
        three.setText("");
        four.setText("");
        five.setText("");
        six.setText("");
        seven.setText("");
        eight.setText("");
        nine.setText("");
    }

    public void setComputerPlays(int move, char piece) {
        if (move == 0) {
            one.setText(String.valueOf(piece));
            one.setDisable(true);
        } else if (move == 1) {
            two.setText(String.valueOf(piece));
            two.setDisable(true);
        } else if (move == 2) {
            three.setText(String.valueOf(piece));
            three.setDisable(true);
        } else if (move == 3) {
            four.setText(String.valueOf(piece));
            four.setDisable(true);
        } else if (move == 4) {
            five.setText(String.valueOf(piece));
            five.setDisable(true);
        } else if (move == 5) {
            six.setText(String.valueOf(piece));
            six.setDisable(true);
        } else if (move == 6) {
            seven.setText(String.valueOf(piece));
            seven.setDisable(true);
        } else if (move == 7) {
            eight.setText(String.valueOf(piece));
            eight.setDisable(true);
        } else if (move == 8) {
            nine.setText(String.valueOf(piece));
            nine.setDisable(true);
        }
    }

    public void winner(Square square) {
        turnOffButtons();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (square == Square.EMPTY) {
            alert.setHeaderText("Its a draw!");
        } else if (square == Square.HUMAN) {
            alert.setHeaderText("You Won!");
        } else if (square == Square.COMPUTER){
            alert.setHeaderText("You Lost!");
        }
        alert.setContentText("Select new game to play again.");
        alert.show();
    }

    public void setSquare(Square square) {
        this.square = square;
    }
}
