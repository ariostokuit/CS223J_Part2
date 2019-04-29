import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class QuizApp extends JFrame implements ActionListener, ItemListener{
    final int FRAME_WIDTH = 400;
    final int FRAME_HEIGHT = 350;
    JLabel heading;
    JLabel Result;

    JLabel Question1;
    JCheckBox Answer1_1;
    JCheckBox Answer1_2;
    JCheckBox Answer1_3;
    JCheckBox Answer1_4;
    ButtonGroup Ans1 = new ButtonGroup(); //mutually exclusive for question 1

    JLabel Question2;
    JCheckBox Answer2_1;
    JCheckBox Answer2_2;
    JCheckBox Answer2_3;
    JCheckBox Answer2_4;
    ButtonGroup Ans = new ButtonGroup(); //mutually exclusive for question2

    JLabel Question3;
    String[] AnswerBox = {"Pick an Option", "False" , "True"}; //For the Question 3
    JComboBox answerFor3 = new JComboBox(AnswerBox); //TRUE /FALSE

    JLabel Question4;
    JCheckBox Answer4_1;
    JCheckBox Answer4_2;
    JCheckBox Answer4_3;
    JCheckBox Answer4_4;
    ButtonGroup Ans4 = new ButtonGroup(); //mutually exclusive for question 4

    JButton submitButton;
    int score = 0;

    public QuizApp(){
        //Create the heading and labels
        super("JAVA QUIZ");
        heading = new JLabel("223J Quiz Application\n");
        heading.setFont(new Font("Arial", Font.BOLD, 25));

        //Set the font for questions and answers for each question
        Question1 = new JLabel("1) A variable can be referenced from its");
        Question1.setFont(new Font("Arial", Font.ITALIC,20));
        Answer1_1 = new JCheckBox("Range", false);
        Answer1_1.setFont(new Font("Arial", Font.BOLD,15));
        Answer1_2 = new JCheckBox("Space",false);
        Answer1_2.setFont(new Font("Arial",Font.BOLD,15));
        Answer1_3 = new JCheckBox("Domain", Font.BOLD,15));
        Answer1_3.setFont(new Font("Arial",Font.BOLD,15));
        Answer1_4 = new JCheckBox("Scope",false);
        Answer1_4.setFont(new Font("Arial",Font.BOLD,15));

        Question2 = new JLabel("2) Methods referenced with individual objects are");
        Question2.setFont(new Font("Arial", Font.ITALIC,20));
        Answer2_1 = new JCheckBox("Private", false);
        Answer2_1.setFont(new Font("Arial", Font.BOLD,15));
        Answer2_2 = new JCheckBox("Public",false);
        Answer2_2.setFont(new Font("Arial",Font.BOLD,15));
        Answer2_3 = new JCheckBox("Static", Font.BOLD,15));
        Answer2_3.setFont(new Font("Arial",Font.BOLD,15));
        Answer2_4 = new JCheckBox("NonStatic",false);
        Answer2_4.setFont(new Font("Arial",Font.BOLD,15));

        Question3 = new JLabel("3) Most Class Data Fields are Private");
        Question3.setFont(new Font("Arial", Font.ITALIC,17));
        answerFor3.setSelectedIndex(0);

        Question4 = new JLabel("4) Java classes are stored in a folder or\n");
        Question4.setFont(new Font("Arial", Font.ITALIC,20));
        Answer4_1 = new JCheckBox("Packet", false);
        Answer4_1.setFont(new Font("Arial", Font.BOLD,15));
        Answer4_2 = new JCheckBox("Package",false);
        Answer4_2.setFont(new Font("Arial",Font.BOLD,15));
        Answer4_3 = new JCheckBox("Bundle", Font.BOLD,15));
        Answer4_3.setFont(new Font("Arial",Font.BOLD,15));
        Answer4_4 = new JCheckBox("Gaggle",false);
        Answer4_4.setFont(new Font("Arial",Font.BOLD,15));

        submitButton = new JButton("Submit");
        Result = new JLabel("Score: " + "/20");
        Result.setFont(new Font("Arial", Font.BOLD,25));

        //Create the GUI
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Answer1_4.addItemListener(this);
        Answer2_4.addItemListener(this);
        answerFor3.addItemListener(this);
        Answer4_2.addItemListener(this);
        submitButton.addActionListener(this);

        Ans1.add(Answer1_1);
        Ans1.add(Answer1_2);
        Ans1.add(Answer1_3);
        Ans1.add(Answer1_4);
        Ans1.add(Answer2_1);
        Ans1.add(Answer2_2);
        Ans1.add(Answer2_3);
        Ans1.add(Answer2_4);
        Ans1.add(Answer4_1);
        Ans1.add(Answer4_2);
        Ans1.add(Answer4_3);
        Ans1.add(Answer4_4);

        //Set the Layout
        setLayout(new FlowLayout());
        add(heading);
        add(Question1);
        add(Answer1_1);
        add(Answer1_2);
        add(Answer1_3);
        add(Answer1_4);
        add(Question2);
        add(Answer2_1);
        add(Answer2_2);
        add(Answer2_3);
        add(Answer2_4);
        add(Question3);
        add(answerFor3);
        add(Question4);
        add(Answer4_1);
        add(Answer4_2);
        add(Answer4_3);
        add(Answer4_4);
        add(submitButton);
        add(Result);
    }

    @Override
    public void itemStateChanged(ItemEvent e){
        //get Answer for 1,2,4
        Object source = e.getItem();
        int select = e.getStateChange();

        //Calculate scores if answer selected were right or wrong
        if(source == Answer1_4 || source == Answer2_4 || source == Answer4_2){
            if(select == ItemEvent.SELECTED){
                //statements if box is checked
                score += 5;
            }
            else {
                //statements if box is unchecked
                score -= 5;
            }
        }

    //get the Answer for Question 3
    Object source1 = e.getSource();
    if(source1 == answerFor3){
        if(select == ItemEvent.SELECTED)
        {
            int positionOfSelection = answerFor3.getSelectedIndex();
                if(positionOfSelection == 2)
                {
                    score += 5;
                }
                else if(positionOfSelection == 1){
                    score -= 5;
                }
        }
    }
}
    @Override
    public void actionPerformed(ActionEvent e){
        Result.setText("Score :" + score + "/20");
    }

}