import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PixelPainter extends JFrame implements KeyListener{
    private final int ROWS =16;
    private final int COLS =16;
    private final int GAPS = 2;

    private JPanel pane = new JPanel(new GridLayout(ROWS,COLS,GAPS,GAPS));
    private JPanel[][] panel = new JPanel[ROWS][COLS];
    private Color[][] color = new Color[ROWS][COLS];

    private Color BlackBoard = Color.BLACK;
    private Color whiteBoard = Color.WHITE;
    private Color highlightSpace = Color.YELLOW;

    private int rPos = (int)(Math.random()*7) + 1; //random positions
    private int cPos = (int)(Math.random()*7) + 1; 

    public PixelPainter(){
        super("Pixel Painter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int r = 0; r < ROWS; r++){//set all of the panel as white boards
            for(int c =0; c < COLS; c++){
                panel[r][c] = new JPanel();
                pane.add(panel[r][c]);
                color[r][c] = whiteBoard;
                panel[r][c].setBackground(color[r][c]); //set the background color to be white
            }
        }
        panel[rPos][cPos].setBackground(highlightSpace); //select one random space to be highlighted

        addKeyListener(this);
        add(pane);
    }
    private Boolean isWithinBounds(int r,int c){//test to see if the highlight space is within the board
        if((r >= 0 && r < ROWS) &&(c >= 0 && c < COLS)){
            return true;
        } 
            return false;
    }

    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_UP){//move up
            if(isWithinBounds(rPos - 1, cPos)){
                panel[rPos][cPos].setBackground(color[rPos][cPos]);
                rPos -= 1;
                panel[rPos][cPos].setBackground(highlightSpace);
            }
            else 
                rPos += 1;
        }
        if(keyCode == KeyEvent.VK_DOWN){//move down
            if(isWithinBounds(rPos + 1, cPos)){
                panel[rPos][cPos].setBackground(color[rPos][cPos]);
                rPos += 1;
            }
            else 
                rPos -= 1;
        }
        if(keyCode == KeyEvent.VK_RIGHT){ //move right
            if(isWithinBounds(rPos,cPos + 1)){
                panel[rPos][cPos].setBackground(color[rPos][cPos]);
                cPos += 1;
                panel[rPos][cPos].setBackground(highlightSpace);
            }
            else 
                cPos -= 1;
        }
        if(keyCode == KeyEvent.VK_LEFT){ //move left
            if(isWithinBounbds(rPos,cPos - 1)){
                panel[rPos][cPos].setBackground(color[rPos][cPos]);
                cPos -= 1;
                panel[rPos][cPos].setBackground(highlightSpace);
            }
            else
                cPos += 1;
        }
        if(keyCode == KeyEvent.VK_SPACE){
            if(color[rPos][cPos] == Color.BLACK){
                color[rPos][cPos] = whiteBoard;
                panel[rPos][cPos].setBackground(color[rPos][cPos]);
            }
            else 
                color[rPos][cPos] = BlackBoard;
        }
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
    @Override
    public void keyReleased(KeyEvent e){}
}