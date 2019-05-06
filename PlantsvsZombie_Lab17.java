/*
*
* Ariosto kuit Lab 17
* Plants vs Zombie lab
* Create a Plants vs Zombie game with Images and Image Icon
*/

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.color.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;

public class PlantsvsZombie extends JFrame implements KeyListener{
    final private Color color1 = Color.GREEM.darker();
    final private Color color2 = Color.GREEN;

    static int count =0;
    final int ROWS = 7;
    final int COLS = 7;
    private final int GAP = 3; //set the size of each gap

    private int rPos = (int)(Math.random()* 4) + 0;
    private int cPos = (int)(Math.random()*4) + 0; //random positions
    private int ZcPos = (int)(Math,random()*7) + 4; //random position for zombie

    private JPanel imgPane = new JPanel(new GridLayout(ROWS,COLS,GAP,GAP));
    JPanel panelLayout = new JPanel();

    ImageIcon zombie = new ImageIcon("/Users/AriostoKuit/Downloads/zombie.png");
    ImageIcon sunflower = new ImageIcon("/Users/AriostoKuit/Downloads/sunflower.png");
    ImageIcon rock = new ImageIcon("/Users/AriostoKuit/Downloads/rock.png");
    ImageIcon peaShooter = new ImageIcon("/Users/AriostoKuit/Downloads/peaShooter.png");

    private JPanel[][] imgPanel = new JPanel[ROWS][COLS]; //array of panels
    private JLabel[][] imgLabel = new JLabel[ROWS][COLS]; //array of JLabels
    private ImageIcon[][] images = new ImageIcon[ROWS][COLS]; //array of imageIcon

    Image Ztransformed = zombie.getImage().getScaledInstance(10,30,java.awt.Image.SCALE_SMOOTH);
    Image Stransformed = sunflower.getImage().getScaledInstance(30,90,java.awt.Image.SCALE_SMOOTH);
    Image Rtransformed = rock.getImage().getScaledInstance(30,90,java.awt.Image.SCALE_SMOOTH);
    Image Ptransformed = peaShooter.getImage().getScaledInstance(30,90,java.awt.Image.SCALE_SMOOTH);

    ImageIcon plant = null;

    public PlantsvsZombie(){
        super("Plants VS Zombies");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int r = 0; r < ROWS;r++){
            for(int c = 0; c < COLS; c++){
                imgPanel[r][c] = new JPanel();
                imgPane.add(imgPanel[r][c]);
                imgLabel[r][c] = new JLabel();
                images[r][c] = new ImageIcon();
                imgLabel[r][c].setIcon(images[r][c]);
                imgPanel[r][c].add(imgLabel[r][c]);

                if(r%2 == 0){
                    imgPanel[r][c].setBackground(color2); //set one row to be dark green
                }
                else 
                    imgPanel[r][c]/setBackground(color1); // set teh other row to be green
            }
        }
        
        plant = new ImageIcon(Stransformed);
        imgLabel[rPos][cPos].setIcon(this.plant); //In the begininng of the game we start with a sunflower
        
        setFocusable(true);
        addKeyListener(this);

        panelLayout.setLayout(new BorderLayout());
        panelLayout.add(imgPane);
        add(panelLayout);
    }
    private ImageIcon getRandomPlant() {//get a random plant to be placed next
        int characterSelect = (int)(Math.random() * 4) + 1;

        if(characterSelect == 1){plant = new ImageIcon(Stransformed);}
        else if(characterSelect == 2){plant = new ImageIcon(Rtransformed);}
        else if(characterSelect == 3){plant = new ImageIcon(Ptransformed);}

        return plant;
    }

    private Boolean isWithinBounds(int r, int c){
        if((r > = 0 && r < ROWS) && (c >= 0 && c < COLS)){//is within board
            return true;
        }
        else 
            return false;
    }
    private Boolean PositionHavePlant(int rPos,int cPos){//check if the plant is in position
        if(images[rPos][cPos].getImage() == Stransformed){
            return true;
        }
        else if(images[rPos][cPos].getImage() == Rtransformed){
            return true;
        }
        else if(images[rPos][cPos].getImage() == Ptransformed){
            return true;
        }
        else 
        return false;
    }

    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        count++;

        if(count == 4){
            imgLabel[rPos][ZcPos].setIcon(zombie);
            count = 0;
        }
    
        //set the plant and zombies and have teh plants able to move
        if(keyCode == KeyEvent.VK_UP){
            if(isWithinBounds(rPos - 1,cPos)){
                imgLabel[rPos][cPos].setIcon(images[rPos][cPos]);
                rPos -= 1;
                imgLabel[rPos][cPos].setIcon(this.plant);
            }
            else 
                rPos += 1;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            if(isWithinBounds(rPos + 1,cPos)){
                imgLabel[rPos][cPos].setIcon(images[rPos][cPos]);
                rPos += 1;
                imgLabel[rPos][cPos].setIcon(this.plant);
            }
            else 
                rPos -= 1;
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            if(isWithinBounds(rPos,cPos + 1)){
                imgLabel[rPos][cPos].setIcon(images[rPos][cPos]);
                cPos += 1;
                imgLabel[rPos][cPos].setIcon(this.plant);
            }
            else 
                cPos -= 1;
        }
        if(keyCode == KeyEvent.VK_LEFT){
            if(isWithinBounds(rPos,cPos - 1)){
                imgLabel[rPos][cPos].setIcon(images[rPos][cPos]);
                cPos -= 1;
                imgLabel[rPos][cPos].setIcon(this.plant);
            }
            else 
                cPos += 1;
        }
        if(keyCode == KeyEvent.VK_SPACE){
            plant = getRandomPlant(); // get a random plant to set next
            while(PositionHavePlant(rPos,cPos) == true){ //find new position for new plant
                rPos = (int)Math.random() * 4 + 1;
                cPos = (int)Math.random() * 4 + 1;
            }
            images[rPos][cPos] = this.plant; //set the new placed plant
        }
    }

    @Override
    public void keyTyped(KeyEvent e){

    }
    @Override
    public void keyReleased(KeyEvent e){

    }
    public static void main(String[] args){
        PlantsvsZombie frame = new PlantsvsZombie();
        frame.setSize(700,700);
        frame.setVisible(true);
    }
}

