package tictactoe;

import java.util.Arrays;

public class Board {
    private Square[] board;
    private int emptySpaces;

    public Board() {
        board = new Square[9];
        Arrays.fill(board, Square.EMPTY);
        emptySpaces = board.length;
    }

    public void placePiece(Square piece, int placement) {
        board[placement] = piece;
        emptySpaces--;
    }

    public void removePiece(int placement) {
        board[placement] = Square.EMPTY;
        emptySpaces++;
    }

    public Square getBoardSquare(int square) {
        return board[square];
    }

    public int getEmptySpaces() {
        return emptySpaces;
    }
}
