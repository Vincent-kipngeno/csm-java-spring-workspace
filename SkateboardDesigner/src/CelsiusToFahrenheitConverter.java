import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusToFahrenheitConverter extends JFrame {

    private JTextField celsiusTextField;
    private JLabel resultLabel;

    public CelsiusToFahrenheitConverter() {
        setTitle("Celsius to Fahrenheit Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel celsiusLabel = new JLabel("Enter Celsius Temperature:");
        celsiusTextField = new JTextField();
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ConvertButtonListener());

        JLabel resultTextLabel = new JLabel("Result in Fahrenheit:");
        resultLabel = new JLabel();

        panel.add(celsiusLabel);
        panel.add(celsiusTextField);
        panel.add(convertButton);
        panel.add(new JLabel());
        panel.add(resultTextLabel);
        panel.add(resultLabel);

        add(panel);
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double celsius = Double.parseDouble(celsiusTextField.getText());
                double fahrenheit = (9.0 / 5.0) * celsius + 32;
                resultLabel.setText(String.format("%.2f °F", fahrenheit));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CelsiusToFahrenheitConverter().setVisible(true);
        });
    }
}
