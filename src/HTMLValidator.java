import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class HTMLValidator extends JFrame {
    private JTextArea inputTextField;
    private JTextArea resultTextArea;
    public HTMLValidator() {
        super("HTML Validator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(new BorderLayout());


        inputTextField = new JTextArea();
        inputTextField.setRows(5);
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        JButton validateButton = new JButton("Validate");

        add(inputTextField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(validateButton, BorderLayout.SOUTH);

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputTextField.getText();
                String parenthesisFile = onlyParentheses(inputText);
                boolean isValid = isValid(parenthesisFile);
                resultTextArea.setText("Is this a valid HTML file? " + isValid);
            }
        });
    }

    public static void main(String[] args) {
        HTMLValidator dsPractice = new HTMLValidator();
        dsPractice.setVisible(true);
    }

    public static String onlyParentheses(String textFile){
        String opening = "({[<";
        String closing = ")}]>";
        Stack<Character> parenthesisFile = new Stack<>();
        for(char c: textFile.toCharArray()){
            if(opening.indexOf(c) != -1 ||  closing.indexOf(c) != -1){
                parenthesisFile.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parenthesisFile.size(); i++) {
            sb.append(parenthesisFile.get(i));
        }

        return sb.toString();
    }

    public static boolean isValid(String s) {
        String opening = "({[<";
        String closing = ")}]>";
        Stack<Character> buffer = new Stack<>();
        for(char c: s.toCharArray()){
            if(opening.indexOf(c) != -1){
                buffer.push(c);
            }
            else if(closing.indexOf(c) != -1){
                if(buffer.isEmpty()){
                    return false;
                }
                if(closing.indexOf(c) != opening.indexOf(buffer.pop())){
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }
}
