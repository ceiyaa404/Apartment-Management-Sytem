package vaksDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class ApartmentManagement extends VaksJFrame {

    static ApartmentManagement apartmentPage;
    static AdminHome adminHome;
    static TenantManagement tenantManagement;
    static TransactionHistory transactionHistory;

    ApartmentManagement() {

        setTitle("Apartment Management");
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#7492BC"));
        mainPanel.setBounds(0, 0, 1542, 850);
        mainPanel.setLayout(null);

        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.decode("#C8D8EF"));
        whitePanel.setBounds(0, 65, 1542, 850);
        whitePanel.setLayout(null);

        JButton button1 = new JButton("Home");
        button1.setBounds(100, 10, 200, 40);
        button1.setBackground(Color.decode("#7492BC"));
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Dialog", Font.BOLD, 18));

        button1.addActionListener(e -> {

            if (adminHome == null) {
                adminHome = new AdminHome();
            }
            adminHome.setVisible(true);
            this.dispose();

        });

        JButton button2 = new JButton("Tenant Management");
        button2.setBounds(350, 10, 250, 40);
        button2.setBackground(Color.decode("#7492BC"));
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Dialog", Font.BOLD, 18));

        button2.addActionListener(e -> {
            if (tenantManagement == null) {
                tenantManagement = new TenantManagement();
            }
            tenantManagement.setVisible(true);
            this.dispose();

        });

        JButton button3 = new JButton("Unit Management");
        button3.setBounds(650, 10, 250, 40);
        button3.setBackground(Color.decode("#7492BC"));
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("Dialog", Font.BOLD, 18));

        button3.addActionListener(e -> {
            if (apartmentPage == null) {
                apartmentPage = new ApartmentManagement();
            }
            apartmentPage.setVisible(true);
            this.dispose();

        });

        JButton button4 = new JButton("Transaction History");
        button4.setBounds(950, 10, 250, 40);
        button4.setBackground(Color.decode("#7492BC"));
        button4.setForeground(Color.WHITE);
        button4.setFont(new Font("Dialog", Font.BOLD, 18));

        button4.addActionListener(e -> {
            if (transactionHistory == null) {
                transactionHistory = new TransactionHistory();
            }
            transactionHistory.setVisible(true);
            this.dispose();

        });

        JButton button5 = new JButton("Logout");
        button5.setBounds(1250, 10, 200, 40);
        button5.setBackground(Color.decode("#7492BC"));
        button5.setForeground(Color.WHITE);
        button5.setFont(new Font("Dialog", Font.BOLD, 18));

        button5.addActionListener(e -> {

            new MainExtended().setVisible(true);
            this.dispose();
        });

        JTable table = new JTable(DataStore.unitModel);
        table.setRowHeight(70);
        table.setFont(new Font("Dialog", Font.PLAIN, 20));

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 30));
        header.setBackground(Color.decode("#4682b4"));
        header.setForeground(Color.WHITE);

        DataStore.unitModel.addTableModelListener(e -> {
            table.revalidate();
            table.repaint();
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 155, 1502, 580);

        JButton button6 = new JButton("+ Add Unit");
        button6.setBounds(1000, 65, 300, 60);
        button6.setBackground(Color.decode("#7492BC"));
        button6.setForeground(Color.WHITE);
        button6.setFont(new Font("Dialog", Font.BOLD, 18));

        button6.addActionListener(e -> {
            if (DataStore.unitModel.getRowCount() >= 50) {
                JOptionPane.showMessageDialog(
                        null,
                        "Maximum of 50 units only!",
                        "Limit Reached",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int unitNumber = DataStore.unitModel.getRowCount() + 1;

            DataStore.unitModel.addRow(new Object[]{
                String.format("U%03d", unitNumber),
                "35",
                "₱3000",
                "Available"
            });
        });

        JLabel l1 = new JLabel("Apartment Management");
        l1.setBounds(20, 25, 600, 60);
        l1.setFont(new Font("Dialog", Font.BOLD, 40));
        l1.setForeground(Color.decode("#000000"));

        JLabel l2 = new JLabel("Manage apartment units and availability");
        l2.setBounds(20, 65, 600, 60);
        l2.setFont(new Font("Dialog", Font.PLAIN, 25));
        l2.setForeground(Color.decode("#000000"));

        JTextField t1 = new JTextField("");
        t1.setBounds(600, 65, 350, 60);
        t1.setFont(new Font("Dialog", Font.PLAIN, 25));
        t1.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));

        JLabel search = new JLabel("Search 🔎");
        search.setBounds(15, 20, 300, 20);
        search.setFont(new Font("Dialog", Font.BOLD, 20));
        search.setForeground(Color.decode("#003366"));

        JButton edit = new JButton("Edit");
        edit.setBounds(1350, 55, 100, 30);
        edit.setBackground(Color.decode("#7492BC"));
        edit.setForeground(Color.decode("#FFD700"));
        edit.setFont(new Font("Dialog", Font.BOLD, 18));

        ImageIcon icon = new ImageIcon("picture/LEGENDARY.png");
        Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel iconLabel = new JLabel(scaledIcon);
        iconLabel.setBounds(40, 10, 50, 50);
        mainPanel.add(iconLabel);
        mainPanel.repaint();

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(DataStore.unitModel);
        table.setRowSorter(sorter);

        t1.getDocument().addDocumentListener(new DocumentListener() {
            private void filter() {
                String text = t1.getText().trim();

                if (text.isEmpty()) {
                    search.setVisible(true);
                    sorter.setRowFilter(null);
                } else {
                    search.setVisible(false);
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0, 1));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filter();
            }
        });
        edit.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int modelRow = table.convertRowIndexToModel(selectedRow);
                new JTFF(modelRow).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row first!");
            }
        });

        JButton del = new JButton("Del");
        del.setBounds(1350, 105, 100, 30);
        del.setBackground(Color.decode("#7492BC"));
        del.setForeground(Color.decode("#dc143c"));
        del.setFont(new Font("Dialog", Font.BOLD, 18));

        del.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int row = table.convertRowIndexToModel(selectedRow); // I-convert dito

                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this row?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    DataStore.unitModel.removeRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row first!");
            }
        });

        mainPanel.add(button1);

        mainPanel.add(button2);
        mainPanel.add(button3);

        mainPanel.add(button4);

        mainPanel.add(button5);
        whitePanel.add(l1);
        whitePanel.add(l2);
        whitePanel.add(t1);
        whitePanel.add(button6);
        whitePanel.add(scrollPane);
        t1.add(search);
        whitePanel.add(edit);
        whitePanel.add(del);
        mainPanel.add(whitePanel);

        this.add(mainPanel);

        setVisible(true);
    }

}

class JTFF extends VaksJFrame {
    JTextField fie1;
    JTextField fie2;
    JTextField fie3;
    JComboBox<String> typeDropdown;
    JComboBox<String> statusDropdown;
    
private boolean isFieldValid(JTextField field) {
    if (field.getBorder() instanceof LineBorder) {
        LineBorder border = (LineBorder) field.getBorder();
        
        return border.getLineColor().getRGB() == Color.GREEN.getRGB();
    }
    return false;
}

    public JTFF(int rowIndex) {
        super(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Edit");
        setLayout(null);
        setSize(400, 440);
       

        JPanel editBase = new JPanel();
        editBase.setSize(400, 440);
        editBase.setBackground(Color.white);
        editBase.setLayout(null);

        JLabel EditUnit = new JLabel("Edit Unit ✎");
        EditUnit.setFont(new Font("Dialog", Font.BOLD, 20));
        EditUnit.setBounds(145, 10, 200, 20);

        JPanel pann2 = new JPanel();
        pann2.setBounds(7, 40, 370, 295);
        pann2.setBackground(Color.white);
        pann2.setBorder(new LineBorder(Color.decode("#abbfd5"), 4, true));
        pann2.setLayout(null);

        // Pre-fill values from DataStore
        String unitNo = (String) DataStore.unitModel.getValueAt(rowIndex, 0);
        String type   = (String) DataStore.unitModel.getValueAt(rowIndex, 1);
        String area   = (String) DataStore.unitModel.getValueAt(rowIndex, 2);
        String rent   = (String) DataStore.unitModel.getValueAt(rowIndex, 3);
        String status = (String) DataStore.unitModel.getValueAt(rowIndex, 4);

        JLabel furst = new JLabel("Unit No.:");
        furst.setBounds(20, 35, 200, 20);
        furst.setFont(new Font("Dialog", Font.PLAIN, 18));

        fie1 = new JTextField(unitNo);
        fie1.setBounds(140, 30, 210, 35);
        
        // Initial validation para sa pre-filled Unit ID
String idRegex = "^U(00[1-9]|0[1-9][0-9]|[1-9][0-9]{2})$";
if (unitNo != null && unitNo.trim().matches(idRegex)) {
    fie1.setBorder(new LineBorder(Color.GREEN, 2)); // ✅ valid agad
} else {
    fie1.setBorder(new LineBorder(Color.RED, 2));   // ❌ invalid agad
}

// Defensive validation: Unit ID must be U01–U99
fie1.getDocument().addDocumentListener(new DocumentListener() {
    private void validateUnitId() {
        String id = fie1.getText().trim();
        String idRegex = "^U(00[1-9]|0[1-9][0-9]|[1-9][0-9]{2})$";

        if (id.isEmpty() || !id.matches(idRegex)) {
            fie1.setBorder(new LineBorder(Color.RED, 2));   // ❌ invalid
        } else {
            fie1.setBorder(new LineBorder(Color.GREEN, 2)); // ✅ valid
        }
    }

    @Override public void insertUpdate(DocumentEvent e) { validateUnitId(); }
    @Override public void removeUpdate(DocumentEvent e) { validateUnitId(); }
    @Override public void changedUpdate(DocumentEvent e) { validateUnitId(); }
});


        JLabel TYPE = new JLabel("Type:");
        TYPE.setBounds(20, 85, 200, 20);
        TYPE.setFont(new Font("Dialog", Font.PLAIN, 18));

        String[] unitTypes = {"Standard 1 Bed","Standard 2 Bed", "Studio"};
        typeDropdown = new JComboBox<>(unitTypes);
        typeDropdown.setSelectedItem(type);
        typeDropdown.setBounds(140, 80, 210, 35);

        JLabel AREA = new JLabel("Area(sqm):");
        AREA.setBounds(20, 135, 200, 20);
        AREA.setFont(new Font("Dialog", Font.PLAIN, 18));

        fie2 = new JTextField(area);
        fie2.setBounds(140, 130, 210, 35);
        
        fie2 = new JTextField(area);
fie2.setBounds(140, 130, 210, 35);
fie2.setEditable(false);

// Auto-fill
typeDropdown.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedType = (String) typeDropdown.getSelectedItem();

        if (selectedType.equals("Standard 1 Bed")) {
            fie2.setText("40");
        } else if (selectedType.equals("Standard 2 Bed")) {
            fie2.setText("60");
        } else if (selectedType.equals("Studio")) {
            fie2.setText("25");
        }
    }
});
    


        JLabel RENT = new JLabel("Rent(₱):");
        RENT.setBounds(20, 185, 200, 20);
        RENT.setFont(new Font("Dialog", Font.PLAIN, 18));

        fie3 = new JTextField();
        fie3.setBounds(140, 180, 210, 35);
 
fie3.getDocument().addDocumentListener(new DocumentListener() {
    private void validateRent() {
        String text = fie3.getText().trim();

        // Regex: digits only
        String rentRegex = "^[0-9]+$";

        if (text.isEmpty() || !text.matches(rentRegex)) {
            fie3.setBorder(new LineBorder(Color.RED, 2));   // ❌ invalid
        } else {
            fie3.setBorder(new LineBorder(Color.GREEN, 2)); // ✅ valid

            // Only check mismatch kapag may 4 digits or more
            if (text.length() >= 4) {
                String selectedType = (String) typeDropdown.getSelectedItem();
                String defaultRent = "";

                if (selectedType.equals("Studio")) {
                    defaultRent = "3000";
                } else if (selectedType.equals("Standard 1 Bed")) {
                    defaultRent = "4500";
                } else if (selectedType.equals("Standard 2 Bed")) {
                    defaultRent = "7000";
                }

                if (!text.equals(defaultRent)) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Default rent for " + selectedType + " is ₱" + defaultRent +
                        ". Are you sure you want to change it to ₱" + text + "?",
                        "Rent Mismatch",
                        JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        }
    }

    @Override public void insertUpdate(DocumentEvent e) { validateRent(); }
    @Override public void removeUpdate(DocumentEvent e) { validateRent(); }
    @Override public void changedUpdate(DocumentEvent e) { validateRent(); }
});

//Defensive check when type changes (no popup, just border)
typeDropdown.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedType = (String) typeDropdown.getSelectedItem();
        String defaultRent = "";

        if (selectedType.equals("Studio")) {
            defaultRent = "3000";
        } else if (selectedType.equals("Standard 1 Bed")) {
            defaultRent = "4500";
        } else if (selectedType.equals("Standard 2 Bed")) {
            defaultRent = "7000";
        }

        String text = fie3.getText().trim();

        if (!text.equals(defaultRent)) {
            fie3.setBorder(new LineBorder(Color.RED, 2));   // ❌ mismatch
        } else {
            fie3.setBorder(new LineBorder(Color.GREEN, 2)); // ✅ match
        }
    }
});




        JLabel STATUS = new JLabel("Status:");
        STATUS.setBounds(20, 235, 200, 20);
        STATUS.setFont(new Font("Dialog", Font.PLAIN, 18));

        String[] statusType = {"Available", "Occupied"};
        statusDropdown = new JComboBox<>(statusType);
        statusDropdown.setSelectedItem(status);
        statusDropdown.setBounds(140, 230, 210, 35);

        JButton UPDATE = new JButton("Update✎");
        UPDATE.setFont(new Font("Dialog", Font.BOLD, 17));
        UPDATE.setBounds(20, 347, 150, 40);
        UPDATE.setBackground(Color.decode("#7492BC"));
        UPDATE.setForeground(Color.white);
        
        
        // Pre-fill values from DataStore
final String originalUnitNo = unitNo; // 🔒 lock original value

        UPDATE.addActionListener(ev -> {
    String newUnitId = fie1.getText().trim();
    String rentValue = fie3.getText().trim();

    // 🔹 Check kung may laman lahat ng fields
    if (newUnitId.isEmpty() || rentValue.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Please fill in all required fields before updating!",
            "Missing Fields",
            JOptionPane.ERROR_MESSAGE
        );
        return;
    }

    // 🔹 Check kung valid lahat ng fields (green border)
    if (!isFieldValid(fie1) || !isFieldValid(fie3)) {
        JOptionPane.showMessageDialog(
            this,
            "Some fields are invalid. Please correct them before saving!",
            "Invalid Input",
            JOptionPane.ERROR_MESSAGE
        );
        return;
    }
// 🔹 Check duplicate Unit ID
boolean duplicateFound = false;
for (int i = 0; i < DataStore.unitModel.getRowCount(); i++) {
    if (i == rowIndex) continue; // skip current row
    String existingId = (String) DataStore.unitModel.getValueAt(i, 0);

    // ✅ Only flag duplicate if it's not the original value
    if (existingId.equalsIgnoreCase(newUnitId) 
        && !newUnitId.equalsIgnoreCase(originalUnitNo)) {
        duplicateFound = true;
        break;
    }
}

if (duplicateFound) {
    fie1.setBorder(new LineBorder(Color.RED, 2));
    JOptionPane.showMessageDialog(
        this,
        "Unit ID " + newUnitId + " already exists in the table!",
        "Duplicate Unit ID",
        JOptionPane.ERROR_MESSAGE
    );
    return;
}
  
    // ✅ If all checks pass → save
    String rentWithPeso = "₱" + rentValue;

    DataStore.unitModel.setValueAt(newUnitId, rowIndex, 0);
    DataStore.unitModel.setValueAt(typeDropdown.getSelectedItem(), rowIndex, 1);
    DataStore.unitModel.setValueAt(fie2.getText(), rowIndex, 2);
    DataStore.unitModel.setValueAt(rentWithPeso, rowIndex, 3);
    DataStore.unitModel.setValueAt(statusDropdown.getSelectedItem(), rowIndex, 4);

    JOptionPane.showMessageDialog(this, "Unit updated successfully!");
    dispose();
});


        JButton CANCEL = new JButton("Cancel❌");
        CANCEL.setFont(new Font("Dialog", Font.BOLD, 17));
        CANCEL.setBounds(215, 347, 150, 40);
        CANCEL.setForeground(Color.decode("#7492BC"));
        CANCEL.setBackground(Color.white);
        CANCEL.addActionListener(e -> dispose());
          
        

        pann2.add(furst);
        pann2.add(fie1);
        pann2.add(TYPE);
        pann2.add(typeDropdown);
        pann2.add(AREA);
        pann2.add(fie2);
        pann2.add(RENT);
        pann2.add(fie3);
        pann2.add(STATUS);
        pann2.add(statusDropdown);

        editBase.add(UPDATE);
        editBase.add(CANCEL);
        editBase.add(pann2);
        editBase.add(EditUnit);
        this.add(editBase);
    }
}
