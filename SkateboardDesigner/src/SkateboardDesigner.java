import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkateboardDesigner extends JFrame {
    private JComboBox<String> deckComboBox, truckComboBox, wheelComboBox;
    private JList<String> miscellaneousList;
    private JButton calculateButton;

    public SkateboardDesigner() {
        setTitle("Skateboard Designer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        addComponents();

        setVisible(true);
    }

    private void initComponents() {
        String[] deckOptions = {"The Master Thrasher ($60)", "The Dictator ($45)", "The Street King ($50)"};
        String[] truckOptions = {"7.75 inch axle ($35)", "8 inch axle ($40)", "8.5 inch axle ($45)"};
        String[] wheelOptions = {"51 mm ($20)", "55 mm ($22)", "58 mm ($24)", "61 mm ($28)"};
        String[] miscellaneousOptions = {"Grip tape ($10)", "Bearings ($30)", "Riser pads ($2)", "Nuts & bolts kit ($3)"};

        deckComboBox = new JComboBox<>(deckOptions);
        truckComboBox = new JComboBox<>(truckOptions);
        wheelComboBox = new JComboBox<>(wheelOptions);
        miscellaneousList = new JList<>(miscellaneousOptions);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
    }

    private void addComponents() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Select Deck:"));
        add(deckComboBox);
        add(new JLabel("Select Truck Assembly:"));
        add(truckComboBox);
        add(new JLabel("Select Wheel Set:"));
        add(wheelComboBox);
        add(new JLabel("Select Miscellaneous Products:"));
        add(new JScrollPane(miscellaneousList));
        add(new JLabel(" "));
        add(calculateButton);
    }

    private void calculateTotal() {
        double subtotal = getSelectedDeckPrice() + getSelectedTruckPrice() + getSelectedWheelPrice()
                + getMiscellaneousTotal();
        double salesTax = subtotal * 0.06;
        double total = subtotal + salesTax;

        JOptionPane.showMessageDialog(this, "Subtotal: $" + subtotal + "\nSales Tax: $" + salesTax + "\nTotal: $" + total);
    }

    private double getSelectedDeckPrice() {
        return getPriceFromComboBox(deckComboBox);
    }

    private double getSelectedTruckPrice() {
        return getPriceFromComboBox(truckComboBox);
    }

    private double getSelectedWheelPrice() {
        return getPriceFromComboBox(wheelComboBox);
    }

    private double getMiscellaneousTotal() {
        String[] selectedMiscellaneous = miscellaneousList.getSelectedValuesList().toArray(new String[0]);
        double total = 0;

        for (String item : selectedMiscellaneous) {
            total += getPriceFromComboBox(new JComboBox<>(item.split(",")));
        }

        return total;
    }

    private double getPriceFromComboBox(JComboBox<String> comboBox) {
        String selectedOption = (String) comboBox.getSelectedItem();
        System.out.println(selectedOption);
        String priceString = selectedOption.substring(selectedOption.indexOf("$") + 1, selectedOption.indexOf(")"));
        return Double.parseDouble(priceString);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SkateboardDesigner();
            }
        });
    }
}
