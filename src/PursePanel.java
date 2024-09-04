import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel() {
       this.purse = new Purse();
    }
    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 0;
        int y = 20;
        if (purse == null) {
            return;
        }


        for (HashMap.Entry<Denomination, Integer> entry : purse.cash.entrySet()) {
            Denomination money = entry.getKey();
            int count = entry.getValue();
            ImageIcon icon= new ImageIcon(getClass().getResource(money.img()));
            Image image = icon.getImage();
            int width = icon.getIconWidth();
            for (int i = 0; i < count; i++) {
                g.drawImage(image, x, y, this);
                y += 30;
            }
            x += 100;
            y = 20;

        }
        repaint();


    }
}