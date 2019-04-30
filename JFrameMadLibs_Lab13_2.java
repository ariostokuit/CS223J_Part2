import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameMadLibs extends JFrame implements ActionListener{
    JTextArea story;
    JLabel Title;
    JLabel askName;
    JLabel askVerb;
    JLabel askPluralNoun;
    JLabel askAdjective;

    JTextField EnterName = new JTextField(10);
    JTextField EnterVerb = new JTextField(10);
    JTextField EnterPluralNoun = new JTextField(10);
    JTextField EnterAdjective = new JTextField(10);

    JButton Next = new JButton("Next");
    JButton Prev = new JButton("Prev");
    JButton Exit = new JButton("Exit");

    JPanel Panel1 =new JPanel();
    JPanel Panel2 = new JPanel();
    JPanel CPanel = new JPanel();

    CardLayout cardLayout1 = new CardLayout();

    public JFrameMadLibs(){
        super("CardLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Title = new JLabel("Welcome to Mad Libs");
        Title.setFont(new Font("Arial", Font.BOLD,20));
        askName = new JLabel("Please Enter Your Name");
        askName.setFont(new Font("Arial",Font.BOLD,10));
        askVerb = new JLabel("Please Enter A Verb ending in " + "ing");
        askVerb.setFont(new Font("Arial", Font.BOLD,10));
        askPluralNoun = new JLabel("Please Enter a Plural");
        askPluralNoun.setFont(new Font("Arial", Font.BOLD,10));

        Next.setFont(new Font("Arial", Font.BOLD,10));
        Prev.setFont(new Font("Arial", Font.BOLD,10));
        Exit.setFont(new Font("Arial", Font.BOLD,10));

        //set size of GUI
        setSize(400,150);
        setLayout(cardLayout1);

        Next.addActionListener(this);

        Panel1.setLayout(new BorderLayout());
        Panel1.add(Title,BorderLayout.NORTH);
        Panel1.add(CPanel,BorderLayout.CENTER);
        CPanel.add(askName); //nested panel
        CPanel.add(EnterName);
        CPanel.add(askVerb);
        CPanel.add(EnterVerb);
        CPanel.add(askPluralNoun);
        CPanel.add(EnterPluralNoun);
        CPanel.add(askAdjective);
        CPanel.add(EnterAdjective);
        Panel1.add(Next,BorderLayout.EAST);
        add(Panel1,"Panel1");

        Prev.addActionListener(this);
        Exit.addActionListener(this);
        Panel2.setLayout(new BorderLayout());
        Panel2.add(Prev,BorderLayout.WEST);
        Panel2.add(Exit,BorderLayout.EAST);
        add(Panel2, "Panel2"); //set up panel2 to create the result

        @Override
        public void actionPerformed(ActionEvent e){
            Object source = e.getSource();

            //if next buttobn is selected
            if(source == Next){
                int randomNumLib = (int)(Math.random()*2) + 1; //uses a random number generatro to determine Mad libs result
                
                if(randomNumLib == 1){
                    story = new JTextArea("Hi there, all you " + EnterAdjective.getText()+
                    "little boys and girls!" + "\nThis is your old TV buddy, " + EnterName.getText()+
                    "!\n With another " + EnterAdjective.getText() + " -hour program of\n "+
                    EnterVerb.getText() + " " + EnterPluralNoun.getText() + " for all of you");
                }
                else if(randomNumLib == 2){
                    story = new JTextArea("Driving a car can be fun...\n" + "If you follow " +
                    EnterName.getText() + "'s " + EnterAdjective.getText() + " advice: \n" +
                    "Before " + EnterVerb.getText() + ",always stick your " + EnterPluralNoun.getText() + "\nout of the window");
                }

                Panel2.add(story,BorderLayout.CENTER);
                cardLayout1.show(getContentPane(),"Panel2");
            }

            //if prev button was selected
            else if(source == Prev){cardLayout1.show(getContentPane(),"Panel1");}
            else if(source == Exit){super.dispose();} //If exit was selected
        }
    }
}