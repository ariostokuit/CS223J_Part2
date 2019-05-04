//create a card Design App
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class CardDesignApp extends JFrame implements ActionListener{
    private JMenuBar mainBar = new JMenuBar();
    private JMenu File = new JMenu("File"); //FILE MENU
    private JMenuItem exit = new JMenuItem("Exit"); //EXIT

    private JMenu Select = new JMenu("Select");
    private JMenuItem home = new JMenuItem("Home");
    private JMenuItem CongratsCard = new JMenuItem("Congratulations Card");
    private JMenuItem BirthCard = new JMenuItem("Birthday Card");

    private JMenu Colors = new JMenu("Colors");
    private JMenu Bright = new JMenu("Bright");
    private JMenu Dark = new JMenu("Dark");
    private JMenuItem white = new JMenuItem("White");
    private JMenuItem yellow = new JMenuItem("Yellow");
    private JMenuItem pink = new JMenuItem("Pink");
    private JMenuItem black = new JMenuItem("Black");
    private JMenuItem gray = new JMenuItem("Gray");

    private JMenu Fonts = new JMenu("Fonts");
    private JMenuItem Arial = new JMenuItem("Arial");
    private JMenuItem Lucida = new JMenuItem("Lucida Handwriting");
    private JMenuItem InkFree = new JMenuItem("Ink Free");

    private JLabel Title = new JLabel("Card Designer Application");
    private JLabel Instruct = new JLabel("Then Get Started By Making Selections From the Menu");
    private JTextField Recipient = new JTextField('"' + "Please Enter The Recipient's Name" + '"');
    private JTextArea Message = new JTextArea("Enter your message here");
    
    private JLabel resultMessage = new JLabel();
    private JLabel resultMessage3 = new JLabel();
    private JTextField resultMessage2 = new JTextField();
    private JTextField resultMessage4 = new JTextField();

    JPanel HomeMenu = new JPanel();
    JPanel CongratsMenu = new JPanel();
    JPanel BirthdayMenu = new JPanel();

    CardLayout CardLayout1 = new CardLayout();

    public CardDesignApp(){
        super("Pimp My JFrame"); // LMAO
        setLayout(CardLayout1);
        setSize(400,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Title.setFont(new Font("Arial",Font.BOLD,20));
        Instruct.setFont(new Font("Arial",Font.BOLD,10));//Decorate the font of the title and instruct

        //Create JMenu Object
        setJMenuBar(mainBar);
        mainBar.add(File);
        mainBar.add(Select);
        mainBar.add(Colors);
        mainBar.add(Fonts);

        File.add(exit);
        Select.add(home);
        Select.add(CongratsCard);
        Select.add(BirthCard);
        Colors.add(Bright);
        Colors.add(Dark);
        Colors.add(white);
        Bright.add(yellow);
        Bright.add(pink);
        Dark.add(black);
        Dark.add(gray);
        Fonts.add(Arial);
        Fonts.add(Lucida);
        Fonts.add(InkFree);

        exit.addActionListener(this);
        home.addActionListener(this);
        CongratsCard.addActionListener(this);
        BirthCard.addActionListener(this);
        white.addActionListener(this);
        yellow.addActionListener(this);
        pink.addActionListener(this);
        black.addActionListener(this);
        gray.addActionListener(this);
        Arial.addActionListener(this);
        Lucida.addActionListener(this);
        InkFree.addActionListener(this);

        add(HomeMenu."HomeMenu");
        HomeMenu.setLayout(new GridLayout(3,1));
        HomeMenu.add(Title);
        HomeMenu.add(Recipient);
        HomeMenu.add(Instruct);

        add(CongratsMenu, "CongratsMenu");
        add(BirthdayMenu, "BirthdayMenu");
        BirthdayMenu.setLayout(new GridLayout(2,1));
        BirthdayMenu.add(resultMessage3);
        BirthdayMenu.add(resultMessage4);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        Container con = getContentPane();
        String name;
        String message;

        if(source == exit){System.exit(0);}
        else if(source == CongratsCard){//will display the congrats card
            CardLayout1.show(getContentPane(),"CongratsMenu");
            name = Recipient.getText();
            message = Message.getText();
            resultMessage.setText("Congratulations " + name);
            resultMessage2.setText(message);
        }
        else if(source == BirthCard){ //will display happy birthday
            CardLayout1.show(getContentPane(),"BirthdayMenu");
            name = Recipient.getText();
            message = Message.getText();
            resultMessage3.setText("Happy Birthday " + name);
            resultMessage4.setText(message);
        }
        else if(source == pink){
           HomeMenu.setBackground(Color.PINK);
           CongratsMenu.setBackground(Color.PINK);
           BirthdayMenu.setBackground(Color.PINK);
        }
        else if(source == yellow){
            HomeMenu.setBackground(Color.YELLOW);
            CongratsMenu.setBackground(Color.YELLOW);
           BirthdayMenu.setBackground(Color.YELLOW);
        }
        else if(source == black){
            HomeMenu.setBackground(Color.BLACK);
            CongratsMenu.setBackground(Color.BLACK);
           BirthdayMenu.setBackground(Color.BLACK);
        }
        else if(source == gray){//gray background
            HomeMenu.setBackground(Color.GRAY);
            CongratsMenu.setBackground(Color.GRAY);
           BirthdayMenu.setBackground(Color.GRAY);
        }
        else if(source == white){
            HomeMenu.setBackground(Color.WHITE);
            CongratsMenu.setBackground(Color.WHITE);
           BirthdayMenu.setBackground(Color.WHITE);
        }
    } 
    public static void main(String [] args){
        CardDesignApp frame = new CardDesignApp();
        frame.setVisible(true);
    }
}