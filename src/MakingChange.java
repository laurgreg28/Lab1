import java.awt.*;
import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RegisterPanel registerPanel = new RegisterPanel();
        frame.setPreferredSize(new Dimension(800, 600));
        frame.add(registerPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
