import org.w3c.dom.ls.LSOutput;

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
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 100;
        int y = 100;
        if (purse == null) {
            return;
        }


        for (HashMap.Entry<Denomination, Integer> entry : purse.cash.entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();
            ImageIcon icon= new ImageIcon(getClass().getResource(denom.img()));
            Image image = icon.getImage();
            for (int i = 0; i < count; i++) {
                g.drawImage(image, x, y, this);
                x += 200;
            }


        }


        repaint();


    }
}

//String purseContents = purse.toString();
// String[] purseContents = purse.toString().split("\n");
//System.out.println("paintComponent called");
//for (String line: purseContents) {
//  g.drawString(line, x, y);
