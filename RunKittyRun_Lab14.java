import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;

public class RunKittyRun extends JFrame implements ActionListener{
    
    private final int ROWS = 8;
    private final int COLS = 8;
    private final int GAP = 2;

    private int rPos = (int)(Math.random() * 7) + 1;
    private int cPos = (int)(Math.random() * 7) + 1;

    private JPanel pane = new JPanel(new GridLayout(ROWS,COLS,GAP,GAP));
    JPanel panelLayout = new JPanel();

    private JPanel[][] panel = new JPanel[ROWS][COLS]; // array of panels
    private JLabel[][] label = new JLabel[ROWS][COLS]; // array of labels

    private Color color1 = Color.GRAY; //set each board as gray
    private Color color2 = Color.WHITE; //set each board as white
    private Color tempColor;

    JButton LeftButton = new JButton("LEFT");
    JButton RightButton = new JButton("RIGHT");
    JButton UpButton = new JButton("UP");
    JButton DownButton = new JButton("DOWN");

    String kitty = "=^.^=";
    JLabel empty = new JLabel("");

    public RunKittyRun(){
        super("Run Kitty Run");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set teh color of the board
        for(int r = 0; r< ROWS; ++r){
            if(r % ROWS == 0){
                tempColor = color1;
                color1 = color2;
                color2 = tempColor;
            }
            for(int c = 0; c <COLS; ++c){
                panel[r][c] = new JPanel();
                pane.add(panel[r][c]);

                if(c % COLS == 0){
                    tempColor = color1;
                    color1 = color2;
                    color2 = tempColor;
                }
                if(c % 2 == 0){
                    panel[r][c].setBackground(color1);
                }
                else panel[r][c].setBackground(color2);

                label[r][c] = new JLabel("");
                panel[r][c].add(label[r][c]); //add the Jlabel to the panel
            }
        }

        label[rPose][cPos].setText(kitty); //set Kitty at a random position

        UpButton.addActionListener(this);
        DownButton.addActionListener(this);
        RightButton.addActionListener(this);
        LeftButton.addActionListener(this);

        //create the layout
        panelLayout.setLayout(new BorderLayout());
        panelLayout.add(UpButton,BorderLayout.NORTH);
        panelLayout.add(LeftButton,BorderLayout.WEST);
        panelLayout.add(RightButton, BorderLayout.EAST);
        panelLayout.add(DownButton,BorderLayout.SOUTH);
        panelLayout.add(pane,BorderLayout.CENTER);
        add(panelLayout);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == UpButton){ //move kitty up
            label[rPos][cPos].setText("");
            rPos -=1;
            if(isWithinBounds(rPos,cPos)){label[rPos][cPos].setText(kitty);}
            else
                rPos+=1;
            label[rPos][cPos].setText(kitty);
        }
        if(source == DownButton){//move kitty down
            label[rPos][cPos].setText("");
            rPos +=1;
            if(isWithinBounds(rPos,cPos)){label[rPos][cPos].setText(kitty);}
            else
                rPos-=1;
            label[rPos][cPos].setText(kitty);
        }
        if(source == RightButton){
         //move kitty right
         label[rPos][cPos].setText("");
          cPos+=1;
         if(isWithinBounds(rPos,cPos)){label[rPos][cPos].setText(kitty);}
         else
             rPos-=1;
         label[rPos][cPos].setText(kitty);   
        }
        if(source == LeftButton){
            //move kitty left
            label[rPos][cPos].setText("");
            cPos -=1;
            if(isWithinBounds(rPos,cPos)){label[rPos][cPos].setText(kitty);}
            else
                cPos+=1;
            label[rPos][cPos].setText(kitty);
        }
    }
    private Boolean isWithinBounds(int r,int c){//test to see if the kitty is within board
    if((r>= 0 && r<8) && (c >= 0 && c <8)){
        return true;
    }
    else
        return false;
    }
    public static void main(String[] args){
        RunKittyRun frame = new RunKittyRun();
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}