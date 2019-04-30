import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DiceGame extends JFrame implements ActionListener,ItemListener{
    int money = 1000; //start off with 1000 dollars at the beginning of the game
    JLabel heading;
    JLabel Available;
    JLabel Result;
    JLabel Plb;//place your bet
    JLabel Messages;

    JTextField Bet = new JTextField(15);
    JTextField CashLeft = new JTextField("$" + money); //display the initial game with 1000

    JButton D1 = new JButton("D1");
    JButton D2 = new JButton("D2");
    JButton D3 = new JButton("D3");
    JButton CashOut = new JButton("Cash Out"); //Exit Program
    JButton RollDice = new JButton("Roll Dice"); //Button to Roll Dice
    String[] QuickBetBox = {"Quick Bet", "$100", "$350", "$500"};
    JComboBox QuickBet = new JComboBox(QuickBetBox); //Combo box for quick bet

    JPanel PanelCenter = new JPanel();
    JPanel PanelWest = new JPanel();
    JPanel PanelEast = new JPanel();
    JPanel PanelSouth = new JPanel();

    public DiceGame(){
        //Title of the screen is casino simuylator
        super("Casino Simulator");
        heading = new JLabel("Welcome To The High Rollers Game");
        heading.setFont(new Font("Arial",Font.BOLD,30));
        Available = new JLabel("Cash Available");
        Available.setFont(new Font("Arial", Font.BOLD,20));
        Plb = new JLabel("Place your Bet\n");
        Plb.setFont(new Font("Arial",Font.BOLD,20));
        Messages = new JLabel();
        Result.setFont(new Font("Arial", Font.BOLD,20));

        //Set the GUI
        setSize(400,150);
        setLayout(new BorderLayout());

        //Set the Layout with a PANEL
        PanelCenter.setLayout(new FlowLayout());// buttonsPanel.setLayout(new FlowLayout());
        add(heading,BorderLayout.NORTH);
        add(PanelCenter,BorderLayout.CENTER);
        PanelWest.setLayout(new GridLayout(2,2,2,2,));
        add(PanelWest,BorderLayout.WEST);
        PanelEast.setLayout(new GridLayout(2,2,2,2));
        add(PanelEast,BorderLayout.EAST);
        PanelSouth.setLayout(new FlowLayout());
        add(PanelSouth,BorderLayout.SOUTH);

        PanelCenter.add(D1);
        PanelCenter.add(D2);
        PanelCenter.add(D3);
        PanelCenter.add(Plb);
        PanelCenter.add(Bet);

        PanelWest.add(Available);
        PanelWest.add(CashLeft);

        PanelEast.add(CashOut);
        PanelEast.add(QuickBet);
        QuickBet.setSelectedIndex(0);

        PanelSouth.add(Result);
        PanelSouth.add(RollDice);
        PanelSouth.add(Messages);

        D1.addActionListener(this);
        D2.addActionListener(this);
        D3.addActionListener(this);
        CashOut.addActionListener(this);
        RollDice.addActionListener(this);
        QuickBet.addActionListener(this);
    }

    //THIS IS FOR THE COMBO BOX OR FOR QUICK BET
    @Override
    public void itemStateChanged(ItemEvent e){
        Object source = e.getSource();
        int select = e.getStateChange();

        if(source  == QuickBet){
            if(select == ItemEvent.SELECTED){
                int posOfSelect = QuickBet.getSelectedIndex();
                if(posOfSelect == 1){
                    Bet.setText("" + 100); //if user select 100 set it 100 so we can parse the String
                }
                else if(posOfSelect == 2) {Bet.setText("" + 350); } // if user select 350
                else if(posOfSelect == 3) {Bet.setText("" + 500);} //if user select 500
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        int num1,num2,num3;
        num1 = (int)(Math.random()*6) + 1;
        num2 = (int)(Math.random()*6) + 1;
        num3 = (int)(Math.random()*6) + 1; //3 dices from 1-6 random generated
        String results = "Winner",message;
        Boolean isWinner; //determine if there was a match or not

        int moneyBet;
        String moneyString;
        
        try{
            moneyString = Bet.getText();
            moneyBet = Integer.parseInt(moneyString); //try to get the moneyString
        }
        catch(Exception ex){
            moneyBet =0;
        }
        moneyString = Bet.getText();
        moneyBet = Integer.parseInt(moneyString); //Convert String to int for money betted

        if(moneyBet > money){
            results = "Insufficient Funds"; //if player has insufficient finds
            Result.setText(results);
        }
        if(money == 0){CashOut.setText("EXIT");} // if player runs out of cash

        if(source == RollDice){ //If ROllDice was sleected then
            D1.setText("" + num1);
            D2.setText(""+num2); //display the numbers
            D3.setText("" + num3);

            //This is to determine if the dices outcome matches
            if((num1 == 2) && (num1 == num3)){
                //THree of a kind
                message = "Three of a Kind!";
                Messages.setText(message);
                Result.setText(results);
                isWinner = true;
            }
            else if(num1 == num2 || num1 == num3 || num2 == num3){
                message = "Two Pair";
                Messages.setText(message);
                Result.setText(results);
                isWinner = true; 
            }
            else{
                message = "Better luck next time"; //if there was no match then you lose
                results = "LOSER";
                Result.setText(results);
                Messages.setText(message);
                isWinner = false;
            }

            if(isWinner == true){
                //If there was a pair or three of a kind it will update
                money += moneyBet;
                CashLeft.setText("$" + money);
            }
            else{
                money -= moneyBet;
                CashLeft.setText("$" + money);
            }//IF isWinner is false then player loses money 
        }
        if(source == CashOut){
            super.dispose();    //If Cash Out buttone is selected then exit the program
        }

    }

}