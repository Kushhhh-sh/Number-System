import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import constants.HelperConstants;
import converter.DecimalToBinary;
import converter.DecimalToHexadecimal;
import converter.DecimalToOctal;
import converter.FromDecimal;

class DoubleJTextField extends JTextField {
    public DoubleJTextField() {
        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();

                if (!isNumber(ch) && !isValidSignal(ch) && !validatePoint(ch) && ch != '\b') {
                    e.consume();
                }
            }
        });

    }

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isValidSignal(char ch) {
        if ((getText() == null || "".equals(getText().trim())) && ch == '-') {
            return true;
        }

        return false;
    }

    private boolean validatePoint(char ch) {
        if (ch != '.') {
            return false;
        }

        if (getText() == null || "".equals(getText().trim())) {
            setText("0.");
            return false;
        } else if ("-".equals(getText())) {
            setText("-0.");
        }

        return true;
    }
}

public class Client implements ActionListener {

    private static JFrame mainFrame;
    private static JLabel titleLabel;
    private static JButton binaryButton;
    private static JButton octalButton;
    private static JButton hexadecimalButton;
    private static JFrame resultFrame;
    private static JLabel resultLabel;
    private static JLabel decimalLabel;
    private static JTextField decimalField;
    private static JLabel precisionLabel;
    private static JTextField precisionField;

    public static void main(String[] args) throws IOException {
        mainFrame = new JFrame("Number System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setSize(500, 285);
        mainFrame.setResizable(false);


        titleLabel = new JLabel("Number System");
        titleLabel.setFont(new Font("Ubuntu", Font.PLAIN, 25));
        titleLabel.setBounds(125, 30, 250, 50);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);


        decimalLabel = new JLabel("Enter a Decimal Number: ");
        decimalLabel.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        decimalLabel.setBounds(25, 100, 200, 25);
        

        // decimalField = new JFormattedTextField(NumberFormat.getNumberInstance());
        decimalField = new DoubleJTextField();
        decimalField.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        decimalField.setBounds(225, 100, 200, 25);
        decimalField.setVisible(true);
        

        precisionLabel = new JLabel("Enter a Precision: ");
        precisionLabel.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        precisionLabel.setBounds(25, 150, 200, 25);
        
        
        // precisionField = new JFormattedTextField(NumberFormat.getNumberInstance());
        precisionField = new DoubleJTextField();
        precisionField.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        precisionField.setText("2");
        precisionField.setBounds(225, 150, 200, 25);

        binaryButton = new JButton("Binary");
        binaryButton.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        binaryButton.setBounds(25, 200, 143, 25);
        binaryButton.addActionListener(new Client());

        octalButton = new JButton("Octal");
        octalButton.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        octalButton.setBounds(178, 200, 143, 25);
        octalButton.addActionListener(new Client());

        hexadecimalButton = new JButton("Hexadecimal");
        hexadecimalButton.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        hexadecimalButton.setBounds(331, 200, 144, 25);
        hexadecimalButton.addActionListener(new Client());

        mainFrame.add(titleLabel);
        mainFrame.add(decimalLabel);
        mainFrame.add(decimalField);
        mainFrame.add(precisionLabel);
        mainFrame.add(precisionField);
        mainFrame.add(binaryButton);
        mainFrame.add(octalButton);
        mainFrame.add(hexadecimalButton);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num = Double.parseDouble(decimalField.getText());
        HelperConstants.PRECISION = Integer.parseInt(precisionField.getText());

        decimalField.setText("");
        precisionField.setText("2");

        switch (e.getActionCommand()) {
            case "Binary":
                showResultDialog(num, "Binary", new DecimalToBinary(num));
                break;

            case "Octal":
                showResultDialog(num, "Octal", new DecimalToOctal(num));
                break;

            case "Hexadecimal":
                showResultDialog(num, "Hexadecimal", new DecimalToHexadecimal(num));
                break;

            default:
                break;
        }
    }
    
    private void showResultDialog(double num, String base, FromDecimal obj) {
        resultFrame = new JFrame("Result");
        resultFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        resultFrame.setSize(540, 100);
        resultFrame.setResizable(false);
        resultFrame.setLayout(null);
        
        resultLabel = new JLabel("The " + base + " of " + num + " is: " + obj);
        resultLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setBounds(20, 20, 500, 30);

        resultFrame.add(resultLabel);
        resultFrame.setVisible(true);
    }
}
