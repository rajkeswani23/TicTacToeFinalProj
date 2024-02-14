import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    TicTacToeViewer view;

    private int x;

    private int y;

    private Image xImage;
    private Image oImage;
    TicTacToe game;
    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col,TicTacToeViewer view, TicTacToe game) {
        this.row = row;
        this.col = col;
        this.view = view;
        this.game = game;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

        x = col * 150 + 300;
        y = row * 150 + 300;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g, Image oImage, Image xImage)
    {
        g.drawRect(x, y, 150, 150);

        if (this.isWinningSquare)
        {
            g.setColor(Color.green);
            g.fillRect(x, y, 150, 150);
        }

        if (marker.equals("O"))
        {
            g.drawImage(oImage, x, y, 150, 150, view);
        }

        else if (marker.equals("X"))
        {
            g.drawImage(xImage, x, y, 150, 150, view);
        }

        if (game.getGameOver() && game.getWinner().equals("O"))
        {
            g.setColor(Color.black);
            g.drawString("O Wins", 500, 780);
        }

        else if (game.getGameOver() && game.getWinner().equals("X"))
        {
            g.setColor(Color.black);
            g.drawString("X Wins", 500, 780);
        }

        else if (game.getGameOver() && game.checkTie())
        {
            g.setColor(Color.black);
            g.drawString("It's a tie", 500, 780);
        }
    }
}
