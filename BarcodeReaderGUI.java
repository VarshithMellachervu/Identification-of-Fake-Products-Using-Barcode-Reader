import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
public class BarcodeReaderGUI extends JFrame {
    private static Set<String> barcodeDatabase = new HashSet<>();
    public BarcodeReaderGUI() {
        barcodeDatabase.add("123456789");
        barcodeDatabase.add("987654321");
        barcodeDatabase.add("555555555");
        setTitle("Barcode Reader");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel barcodeLabel = new JLabel("Enter Barcode:");
        JTextField barcodeTextField = new JTextField(15);
        JButton verifyButton = new JButton("Verify");
        setLayout(new GridLayout(3, 1));
        add(barcodeLabel);
        add(barcodeTextField);
        add(verifyButton);
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcodeText = barcodeTextField.getText();
                boolean isBarcodeValid = verifyBarcode(barcodeText);
                if (isBarcodeValid) {
                    JOptionPane.showMessageDialog(null, "Barcode is valid.");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid barcode or not found in the database.");
                }
            }
        });
    }
    private boolean verifyBarcode(String barcode) {
        return barcodeDatabase.contains(barcode);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BarcodeReaderGUI().setVisible(true);
            }
        });
    }
}
