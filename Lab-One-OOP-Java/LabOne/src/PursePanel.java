import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Map;
import javax.swing.*;

public class PursePanel extends JPanel {
    private Purse purse; //represents the amount to display
    //constructor
    public PursePanel(){
        purse = new Purse();
    }
    public void setPurse(Purse p){
        this.purse = p;
    }
    public void updatePurse(Purse newPurse) {
       this.purse = newPurse;
        this.removeAll();
        revalidate();
        repaint();
    }
    @Override //needed when using super
    public void paintComponent(Graphics g) //holds logic for displaying purse contents
    {
        super.paintComponent(g);
        //string purseContents = purse.toString();
        //string [] lines = purseContents.split("\n");
        //int y = 20;
        //for (String line : lines)
        //imageIcon
        //img.setImage(img.getImage().getScaledInstance(90,55,
        //JLabel imgLabel = new JLabel(img);
        //imgLabel.setBounds(xOffset, y,90,55);
        ImageObserver observer;
        int y = 10;


        for (Denomination d : purse.cash.keySet()) {
            if (purse.cash.get(d) > 0) {
                g.drawString(d.img(), 20, y);
                y += 20;
            }
        }
    }
}
