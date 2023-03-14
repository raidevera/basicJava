import javax.management.OperationsException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// comment

public class calculator extends Frame implements ActionListener{

    JFrame frame;
    JTextField tf;
    JButton[] numBtn = new JButton[10];
    JButton[] funcBtn = new JButton[10];
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton decBtn, equBtn, modBtn, delBtn, acBtn, ngtBtn;
    JPanel panel;

    Font font = new Font("sans-serif", Font.BOLD, 20);

    double num1 = 0, num2 = 0, aresult, bresult, result;
    char operator;

    calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430,600);
        frame.setLayout(null);

        tf = new JTextField();
        tf.setBounds(60, 25, 300, 68);
        tf.setFont(font);
        tf.setEditable(false);

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        decBtn = new JButton(".");
        equBtn = new JButton("=");
        modBtn = new JButton("%");
        delBtn = new JButton("<--");
        acBtn = new JButton("C");
        ngtBtn = new JButton("(-)");

        funcBtn[0] = addBtn;
        funcBtn[1] = subBtn;
        funcBtn[2] = mulBtn;
        funcBtn[3] = divBtn;
        funcBtn[4] = decBtn;
        funcBtn[5] = equBtn;
        funcBtn[6] = modBtn;
        funcBtn[7] = delBtn;
        funcBtn[8] = acBtn;
        funcBtn[9] = ngtBtn;

        for(int i = 0; i < 10; i++) {
            funcBtn[i].addActionListener(this);
            funcBtn[i].setFont(font);
            funcBtn[i].setFocusable(false);
        }
        
        for(int i = 0; i < 10; i++) {
            numBtn[i] = new JButton(String.valueOf(i));
            numBtn[i].addActionListener(this);
            numBtn[i].setFont(font);
            numBtn[i].setFocusable(false);
            numBtn[i].setSize(100,100);
        }

        acBtn.setBounds(60, 120, 55, 45);
        delBtn.setBounds(140, 120, 60, 45);
        modBtn.setBounds(220, 120, 55, 45);
        divBtn.setBounds(300, 120, 55, 45);

        panel = new JPanel();
        panel.setBounds(60,200,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        //panel.setBackground(Color.cyan);

        panel.add(numBtn[7]);
        panel.add(numBtn[8]);
        panel.add(numBtn[9]);
        panel.add(mulBtn);
        panel.add(numBtn[4]);
        panel.add(numBtn[5]);
        panel.add(numBtn[6]);
        panel.add(subBtn);
        panel.add(numBtn[1]);
        panel.add(numBtn[2]);
        panel.add(numBtn[3]);
        panel.add(addBtn);
        panel.add(numBtn[0]);
        panel.add(decBtn);
        panel.add(ngtBtn);
        panel.add(equBtn);

        frame.add(panel);
        frame.add(delBtn);
        frame.add(acBtn);
        frame.add(modBtn);
        frame.add(divBtn);
        frame.add(tf);
        frame.setVisible(true);

    }
    public static void main(String[] args) {

        new calculator();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numBtn[i]) {
                tf.setText(tf.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decBtn) {
            tf.setText(tf.getText().concat("."));
        }

        if(e.getSource() == addBtn) {
            num1 = Double.parseDouble(tf.getText());
            operator = '+';
            tf.setText("");
        }

        if(e.getSource() == subBtn) {
            num1 = Double.parseDouble(tf.getText());
            operator = '-';
            tf.setText("");
        }
        
        if(e.getSource() == mulBtn) {
            num1 = Double.parseDouble(tf.getText());
            operator = '*';
            tf.setText("");
        }

        if(e.getSource() == divBtn) {
            num1 = Double.parseDouble(tf.getText());
            operator = '/';
            tf.setText("");
        }
        if(e.getSource() == modBtn) {
            num1 = Double.parseDouble(tf.getText());
            operator = '%';
            tf.setText("");
        }

        if(e.getSource() == equBtn) {
            num2 = Double.parseDouble(tf.getText());

            switch(operator) {
            case'+':
                result = num1 + num2;
                break;
            case'-':
                result = num1 - num2;
                break;
            case'*':
                result = num1 * num2;
                break;
            case'/':
                result = num1 / num2;
                break;
            case'%':
                aresult = num1 / 100;
                bresult = aresult * num2;
                result = bresult;
                break;

            }

            tf.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == acBtn) {
            tf.setText("");
        }

        if(e.getSource() == delBtn) {
            String string = tf.getText();
            tf.setText("");
            for(int i = 0; i < string.length() - 1; i++) {
                tf.setText(tf.getText() + string.charAt(i));
            }
        }

        if(e.getSource() == ngtBtn) {
            double temp = Double.parseDouble(tf.getText());
            temp *= -1;
            tf.setText(String.valueOf(temp));
            }
        }
    }

    