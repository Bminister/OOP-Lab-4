import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MakingChange {
//Main function that creates a Jframe and adds a RegisterPanel To it
    public static void main(String[] args) {
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        RegisterPanel panel = new RegisterPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}
