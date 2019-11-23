package tictactoe;

public class ComputerPlayer {
    private char piece;
    private int[] preferredMoves = {4, 0, 2, 6, 8, 1, 3, 5, 7};
    private Board board;

    public ComputerPlayer(char piece, Board board) {
        this.piece = piece;
        this.board = board;
    }

    public char getPiece() {
        return piece;
    }

    public int move(Game game) {
        if (canWin(game) != -1) {
            return canWin(game);
        }
        if (canLose(game) == -1) {
            return findBestSquare();
        } else {
            return canLose(game);
        }
    }

    private int canWin(Game game) {
        for (int i = 0; i < 9; i ++) {
            if (board.getBoardSquare(i) == Square.EMPTY) {
                board.placePiece(Square.COMPUTER, i);
                if (game.checkWinner(Square.COMPUTER)) {
                    board.removePiece(i);
                    return i;
                } else {
                    board.removePiece(i);
                }
            }
        }
        return -1;
    }

    private int canLose(Game game) {
        for (int i = 0; i < 9; i ++) {
            if (board.getBoardSquare(i) == Square.EMPTY) {
                board.placePiece(Square.HUMAN, i);
                if (game.checkWinner(Square.HUMAN)) {
                    board.removePiece(i);
                    return i;
                } else {
                    board.removePiece(i);
                }
            }
        }
        return -1;
    }

    private int findBestSquare() {
        for (int move : preferredMoves) {
            if (board.getBoardSquare(move) == Square.EMPTY) {
                return move;
            }
        }
        return -1;
    }
}
