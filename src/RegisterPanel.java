import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
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
        inputLabel = new JLabel("Please enter the amount of money: ");
        input.addActionListener(new InputListener());

        inputPanel.add(inputLabel);
        inputPanel.add(input);
        this.add(inputPanel);
        this.add(changePanel);

        this.setLayout(new BorderLayout());
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(changePanel, BorderLayout.CENTER);


    }
        private class InputListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(input.getText());
                inputLabel.setText("$" + amount);

                if (amount <= 0)
                    inputLabel.setText("Empty Purse.");

                Purse purse = register.makeChange(amount);

                inputPanel.setPreferredSize(new Dimension(800, 800));
                inputPanel.setBackground(Color.BLUE);
                changePanel.setPreferredSize(new Dimension(900, 800));
                changePanel.setBackground(Color.BLACK);



                changePanel.setPurse(purse);
                inputPanel.add(changePanel);


                changePanel.revalidate();
                changePanel.repaint();
            }
        }

}