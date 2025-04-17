import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private PurseFacade purseFacade;  // Use facade
    private JPanel inputPanel;
    private JTextField input;
    private PursePanel changePanel;

    public RegisterPanel() {
        // Sets up the register panel to use the facade
        purseFacade = new PurseFacade(new DefaultMakeChangeStrategy());  // Default strategy
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
                Purse change = purseFacade.getChange(amount);
                changePanel.setPurse(change);
                changePanel.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid Amount!");
            }
        }
    }
}