
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register; // a register object to run the logic
    private JPanel inputPanel; //a panel to hold the JTextField for the user to enter an amount
    private JTextField input; // a place for the user to enter the amount
    private PursePanel changePanel; // a panel to display the change
public RegisterPanel() {
    //Sets up new register panel to display the input of the money
    //Initialization for all panels needed
    register = new Register();
    input = new JTextField(10);
    changePanel = new PursePanel();
    JPanel inputPanel = new JPanel();

    input.addActionListener(new InputListener());
    setLayout(new BorderLayout());

    inputPanel.add(new JLabel("Enter Amount: "));
    inputPanel.add(input);
    add(inputPanel, BorderLayout.NORTH);
    add(changePanel, BorderLayout.CENTER);
}

private class InputListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(input.getText());
            Purse change = register.makeChange(amount);
            changePanel.setPurse(change);
            changePanel.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid Amount!");
        }
    }
}

}
