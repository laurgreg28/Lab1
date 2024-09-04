// Listens for changes in inputPanel and holds PursePanel
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    //Create register and GUI contents
    private Register register;
    private JPanel inputPanel;
    private JTextField input;
    private JLabel inputLabel;
    private PursePanel changePanel;
    private JLabel changeLabel;

    public RegisterPanel() {
        register = new Register();
        inputPanel = new JPanel();
        input = new JTextField(10);
        changePanel = new PursePanel();
        changeLabel = new JLabel("Purse Contents");
        inputLabel = new JLabel("Please enter the amount of money: "); //label to enter amount
        input.addActionListener(new InputListener()); //connecting input to listener

        //Adds input and label to panel
        input.setFont(new Font("Arial", Font.PLAIN, 20));
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        inputPanel.add(inputLabel);
        inputPanel.add(input);
        //Adds panels to frame
        this.add(inputPanel);
        this.add(changePanel);
        this.setLayout(new BorderLayout());
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(changePanel, BorderLayout.CENTER);

    }
    //Listener for changes to input
    private class InputListener implements ActionListener {
        //Performs actions when input changes
        public void actionPerformed(ActionEvent e) {
            //Gets input amount
            double amount = Double.parseDouble(input.getText());
            //Returns contents of purse
            Purse purse = register.makeChange(amount);

            //Diplays amount
            inputLabel.setText("$" + purse.getValue());
            //Prints empty purse
            if (amount <= 0.001)
                inputLabel.setText("Empty Purse.");


            //Customizes the panels
            inputPanel.setBackground(Color.gray);
            changePanel.setPreferredSize(new Dimension(900, 800));
            changePanel.setBackground(Color.BLUE);

            //Sets the change panel and add to inputPanel
            changePanel.setPurse(purse);
            changeLabel.setForeground(Color.white);
            changeLabel.setFont(new Font("Arial", Font.BOLD, 40));
            changePanel.add(changeLabel);
            inputPanel.add(changePanel);


            changePanel.revalidate();
            changePanel.repaint();
        }
    }

}