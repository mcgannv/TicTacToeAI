package tictactoe;

public class Game {
    private TicTacToeController controller;
    private Square square;
    private Board board;
    private Turn turn;
    private ComputerPlayer computerPlayer;

    public Game(TicTacToeController controller, Turn turn, Board board, ComputerPlayer computerPlayer) {
        this.controller = controller;
        this.turn = turn;
        this.board = board;
        this.computerPlayer = computerPlayer;
    }

    public boolean checkWinner(Square piece) {
        return (board.getBoardSquare(0) == piece && board.getBoardSquare(1) == piece && board.getBoardSquare(2) == piece) ||
                (board.getBoardSquare(3) == piece && board.getBoardSquare(4) == piece && board.getBoardSquare(5) == piece) ||
                (board.getBoardSquare(6) == piece && board.getBoardSquare(7) == piece && board.getBoardSquare(8) == piece) ||
                (board.getBoardSquare(0) == piece && board.getBoardSquare(3) == piece && board.getBoardSquare(6) == piece) ||
                (board.getBoardSquare(1) == piece && board.getBoardSquare(4) == piece && board.getBoardSquare(7) == piece) ||
                (board.getBoardSquare(2) == piece && board.getBoardSquare(5) == piece && board.getBoardSquare(8) == piece) ||
                (board.getBoardSquare(0) == piece && board.getBoardSquare(4) == piece && board.getBoardSquare(8) == piece) ||
                (board.getBoardSquare(2) == piece && board.getBoardSquare(4) == piece && board.getBoardSquare(6) == piece);
    }

    public void play() {
        if (turn == Turn.COMPUTER) {
            square = Square.COMPUTER;
            computerPlays();
        }
    }

    public void playerPlays(Square piece, int move) {
        if (turn == Turn.PLAYER) {
            board.placePiece(piece, move);
            if (checkWinner(piece)) {
                controller.winner(square);
            } else if (checkDraw()) {
                controller.winner(Square.EMPTY);
            } else {
                switchPlayers();
                computerPlays();
            }
        }
    }

    private void computerPlays() {
        if (turn == Turn.COMPUTER) {
            int computerMove = computerPlayer.move(this);
            board.placePiece(square, computerMove);
            controller.setComputerPlays(computerMove, computerPlayer.getPiece());
            if (checkWinner(square)) {
                controller.winner(square);
            } else if (checkDraw()) {
                controller.winner(Square.EMPTY);
            } else {
                switchPlayers();
            }
        }
    }

    private void switchPlayers() {
        if (turn == Turn.PLAYER) {
            turn = Turn.COMPUTER;
            square = Square.COMPUTER;
        } else {
            turn = Turn.PLAYER;
            square = Square.HUMAN;
        }
        controller.setSquare(square);
    }

    private boolean checkDraw() {
        return board.getEmptySpaces() == 0;
    }
}
