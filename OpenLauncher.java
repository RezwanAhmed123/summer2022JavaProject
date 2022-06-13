import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OpenLauncher implements ActionListener{
    double currentDouble = 0;
    String current1 = "";
    String current2 = "";
    String current = current1;
    int w = 70;
    int h = 50;
    boolean isEquated = false;

    JFrame frame = new JFrame("Simple Calculator");
    JPanel displayBox = new JPanel();
    JLabel display = new JLabel();
    
    JButton zero = new JButton("0");
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    
    JButton clearButton = new JButton("C");
    JButton decimalButton = new JButton(".");

    JButton plusButton = new JButton("+");
    JButton minusButton = new JButton("-");
    JButton divideButton = new JButton("/");
    JButton multiplyButton = new JButton("x");
    JButton equalButton = new JButton("=");

    CalcBot calcBot = new CalcBot();

    OpenLauncher(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        displayBox.setBounds(20,20,340,100);
        displayBox.setFocusable(false);
        displayBox.setBackground(Color.white);

        display.setBackground(Color.white);
        display.setFont(new Font("Serif", Font.BOLD, 20));
        display.setHorizontalAlignment(SwingConstants.LEFT);

        buttonPlacement(one,1);
        buttonPlacement(two,2);
        buttonPlacement(three,3);
        buttonPlacement(four,4);
        buttonPlacement(five,5);
        buttonPlacement(six,6);
        buttonPlacement(seven,7);
        buttonPlacement(eight,8);
        buttonPlacement(nine,9);

        specialButtons();
        signButtons();

        frame.add(displayBox);
        displayBox.add(display);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isEquated){
            current1 = "";
            current2 = "";
            current = current1;
            calcBot.clearAll();
            isEquated = false;
        }
        if (e.getSource() == zero){
            current += "0";}
        else if (e.getSource() == one){
            current += "1";}
        else if (e.getSource() == two){
            current += "2";}
        else if (e.getSource() == three){
            current += "3";}
        else if (e.getSource() == four){
            current += "4";}
        else if (e.getSource() == five){
            current += "5";}
        else if (e.getSource() == six){
            current += "6";}
        else if (e.getSource() == seven){
            current += "7";}
        else if (e.getSource() == eight){
            current += "8";}
        else if (e.getSource() == nine){
            current += "9";}
        
        else if (e.getSource() == decimalButton){
            current += ".";}
        else if (e.getSource() == clearButton){
            current1 = "";
            current2 = "";
            current = current1;
            calcBot.clearAll();}

        else if (e.getSource() == plusButton){
            calcBot.initiateNumber(current, "+");
            current1 = current;
            current = current2;}
        else if (e.getSource() == minusButton){
            calcBot.initiateNumber(current, "-");
            current1 = current;
            current = current2;}
        else if (e.getSource() == multiplyButton){
            calcBot.initiateNumber(current, "x");
            current1 = current;
            current = current2;}
        else if (e.getSource() == divideButton){
            calcBot.initiateNumber(current, "/");
            current1 = current;
            current = current2;}

        display.setText(current);

        if (e.getSource() == equalButton) {
            calcBot.initiateNumber(current, "");
            current2 = current;
            calcBot.smallCalculate();
            String resultString = calcBot.NumberFormatter();
            String textDisplay = current1 + calcBot.firstSign + current2 + " = " + resultString;
            display.setText(textDisplay);
            isEquated = true;
            }
        
    }

    public void buttonPlacement(JButton button, int number){
        int x = 20 + ((number-1) %3)* 90;
        int y = 120 + ((number-1)/3) * 60;
        button.setBounds(x,y,w,h);
        button.setFocusable(false);
        button.addActionListener((ActionListener) this);
        frame.add(button);
    }

    public void specialButtons (){
        int x = 20;
        int y = 300;
        clearButton.setBounds(x,y,w,h);
        clearButton.addActionListener((ActionListener) this);
        clearButton.setBackground(Color.red);

        zero.setBounds(x+(w+20),y,w,h);
        zero.addActionListener((ActionListener) this);
        
        decimalButton.setBounds(x+(w +20)*2,y,w,h);
        decimalButton.addActionListener((ActionListener) this);

        frame.add(clearButton);
        frame.add(zero);
        frame.add(decimalButton);
    }

    public void signButtons(){
        int x = 290;
        int y = 120;

        h = h - 9;
        int gap = 6;

        plusButton.setBounds(x,y,w,h);
        plusButton.addActionListener((ActionListener) this);

        minusButton.setBounds(x,y+(h+gap),w,h);
        minusButton.addActionListener((ActionListener) this);

        multiplyButton.setBounds(x,y+(h+gap)*2,w,h);
        multiplyButton.addActionListener((ActionListener) this);

        divideButton.setBounds(x,y+(h+gap)*3,w,h);
        divideButton.addActionListener((ActionListener) this);

        equalButton.setBounds(x,y+(h+gap)*4,w,h);
        equalButton.addActionListener((ActionListener) this);

        frame.add(plusButton);
        frame.add(minusButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(equalButton);
    }
}
