import javax.swing.*;
import java.awt.*;
public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class

        private Image oImage;
        private Image xImage;

        private Square[][] squares;
        private final int WINDOW_WIDTH = 1000;
        private final int WINDOW_HEIGHT = 800;
        private final int TITLE_BAR_HEIGHT = 23;
        private TicTacToe board;

        public TicTacToeViewer(TicTacToe board) {

            // Initialize instance variables.
            // TODO: initialize the View's instance variables.

            this.board = board;
            this.squares = board.getBoard();

            // Setup the window and the buffer strategy.
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("Tic Tac Toe");
            this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            this.setVisible(true);
            oImage = new ImageIcon("Resources/O.png").getImage();
            xImage = new ImageIcon("Resources/X.png").getImage();
        }

    public Image getxImage() {
        return xImage;
    }

    public Image getoImage() {
        return oImage;
    }

    public void paint(Graphics g)
    {
        // TODO: Write the paint method.
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        g.drawString("0", 350, 200);
        g.drawString("1", 500, 200);
        g.drawString("2", 650, 200);
        g.drawString("0", 200, 400);
        g.drawString("1", 200, 550);
        g.drawString("2", 200, 700);

        squares = board.getBoard();
        for(int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < squares[0].length; j++)
            {
                this.squares[i][j].draw(g, oImage, xImage);
            }
        }

    }

}

