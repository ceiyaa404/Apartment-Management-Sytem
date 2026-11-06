package vaksDesign;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class TenantManagement extends VaksJFrame {

    static ApartmentManagement apartmentPage;
    static AdminHome adminHome;
    static TenantManagement tenantManagement;
    static TransactionHistory transactionHistory;

    static void openAddTenantPopup() {
        new PopUpCode(DataStore.tenantModel).setVisible(true);
    }

    TenantManagement() {

        setTitle("Tenant Management");
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

        ImageIcon icon = new ImageIcon("picture/LEGENDARY.png");
        Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel iconLabel = new JLabel(scaledIcon);
        iconLabel.setBounds(40, 10, 50, 50);
        mainPanel.add(iconLabel);
        mainPanel.repaint();

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

        JButton button6 = new JButton("+ Add Tenant");
        button6.setBounds(1000, 65, 300, 60);

        button6.setBackground(Color.decode("#7492BC"));
        button6.setForeground(Color.WHITE);
        button6.setFont(new Font("Dialog", Font.BOLD, 18));

        button6.addActionListener(e -> {
            boolean hasAvailable = false;
            for (int i = 0; i < DataStore.unitModel.getRowCount(); i++) {
                String status = (String) DataStore.unitModel.getValueAt(i, 4);
                if ("Available".equalsIgnoreCase(status)) {
                    hasAvailable = true;
                    break;
                }
            }

            if (hasAvailable) {
                // May available unit → pwede mag-add tenant
                PopUpCode popup = new PopUpCode(DataStore.tenantModel);
                popup.setVisible(true);
            } else {
                // Walang available unit → show warning
                JOptionPane.showMessageDialog(
                        this,
                        "No available units. Cannot add tenant.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        JLabel l1 = new JLabel("Tenant Management");
        l1.setBounds(20, 25, 600, 60);
        l1.setFont(new Font("Dialog", Font.BOLD, 40));
        l1.setForeground(Color.decode("#000000"));

        JLabel l2 = new JLabel("Manage tenant account and information");
        l2.setBounds(20, 65, 600, 60);
        l2.setFont(new Font("Dialog", Font.PLAIN, 25));
        l2.setForeground(Color.decode("#000000"));

        JTextField t1 = new JTextField("");// search
        // t1.setBounds(700, 65, 350, 60);
        t1.setBounds(600, 65, 350, 60);
        t1.setFont(new Font("Dialog", Font.PLAIN, 25));
        t1.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));

        JLabel search = new JLabel("Search🔎");
        search.setBounds(15, 20, 300, 20);
        search.setFont(new Font("Dialog", Font.BOLD, 20));
        search.setForeground(Color.decode("#003366"));

        JTable table = new JTable(DataStore.tenantModel);
        table.setRowHeight(70); // mas malaki row height para readable
        table.setFont(new Font("Dialog", Font.PLAIN, 20));

        // I-disable ang default cell editor para sa lahat ng uri ng data
        table.setDefaultEditor(Object.class, null);

// Header styling
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 30)); // patabain at palakihin
        header.setBackground(Color.decode("#4682b4"));       // dark bluish background
        header.setForeground(Color.WHITE);                 // puti ang text

        // 🔹 Attach listener para auto-refresh
        DataStore.tenantModel.addTableModelListener(e -> {
            table.revalidate();
            table.repaint();
        });

// Scroll pane para sa table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 155, 1502, 580);
        add(scrollPane);

        /*
         // 🔹 Search filter logic
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(DataStore.tenantModel);
        table.setRowSorter(sorter);

        t1.getDocument().addDocumentListener(new DocumentListener() {
            private void filter() {
                String text = t1.getText().trim();
                if (text.length() == 0) {
                    sorter.setRowFilter(null); // show all rows
                } else {
                    // (?i) = case-insensitive
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0, 1));
                    // columns 0 = ID, 1 = Name
                }
            }

            @Override public void insertUpdate(DocumentEvent e) { filter(); }
            @Override public void removeUpdate(DocumentEvent e) { filter(); }
            @Override public void changedUpdate(DocumentEvent e) { filter(); }
        });
         */
        // 🔹 Search filter logic
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(DataStore.tenantModel);
        table.setRowSorter(sorter);

        t1.getDocument().addDocumentListener(new DocumentListener() {
            private void filter() {
                String text = t1.getText().trim();

                // 🔹 Toggle label visibility
                if (text.isEmpty()) {
                    search.setVisible(true);   // show label kapag walang laman
                    sorter.setRowFilter(null); // show all rows
                } else {
                    search.setVisible(false);  // hide label kapag may tinype
                    // (?i) = case-insensitive
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0, 1));
                    // columns 0 = ID, 1 = Name
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

        JButton edit = new JButton("Edit");
        edit.setBounds(1350, 55, 100, 30);
        edit.setBackground(Color.decode("#7492BC"));
        edit.setForeground(Color.decode("#FFD700"));
        edit.setFont(new Font("Dialog", Font.BOLD, 18));

        edit.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int modelRow = table.convertRowIndexToModel(selectedRow); // ✅ Convert view index to model index
                new EditTenant(modelRow); // Bubukas ang iyong magandang form at ipapasa ang row index
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

                int row = table.convertRowIndexToModel(selectedRow);

                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this row?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {

                    // 🔒 Defensive Check: Hingin muna ang Password ng Admin
                    JPasswordField passwordField = new JPasswordField();
                    Object[] message = {
                        "Enter Admin Password to confirm deletion:", passwordField
                    };

                    int option = JOptionPane.showConfirmDialog(
                            this,
                            message,
                            "Admin Verification",
                            JOptionPane.OK_CANCEL_OPTION
                    );

                    if (option == JOptionPane.OK_OPTION) {
                        String enteredPassword = new String(passwordField.getPassword());

                        // Kuhanin ang password ng admin mula sa MainExtended (o kung saan mo man sine-save)
                        String adminPass = MainExtended.getAdminAccount().getPassword();

                        if (enteredPassword.equals(adminPass)) {
                            // ✅ Tama ang password, ituloy ang pag-delete
                            String tenantId = DataStore.tenantModel.getValueAt(row, 0).toString();
                            String unitNo = DataStore.tenantModel.getValueAt(row, 2).toString();

                            UserData userData = new UserData();
                            userData.removeUser(tenantId);

                            DataStore.tenantModel.removeRow(row);

                            for (int i = 0; i < DataStore.unitModel.getRowCount(); i++) {
                                String currentUnit = DataStore.unitModel.getValueAt(i, 0).toString();
                                if (currentUnit.equals(unitNo)) {
                                    DataStore.unitModel.setValueAt("Available", i, 4);
                                    break;
                                }
                            }

                            JOptionPane.showMessageDialog(this, "Tenant deleted successfully and unit is now available!");
                        } else {
                            // ❌ Mali ang password
                            JOptionPane.showMessageDialog(this, "Incorrect Password! Deletion cancelled.", "Access Denied", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        /*
    String tenantId =
            DataStore.tenantModel.getValueAt(row, 0).toString();

    // ✅ Kunin ang unit ng tenant
    String unitNo =
            DataStore.tenantModel.getValueAt(row, 2).toString();

    UserData userData = new UserData();
    userData.removeUser(tenantId);

    // ✅ Delete tenant sa table
    DataStore.tenantModel.removeRow(row);

    // ✅ Gawing Available ulit ang unit
    for (int i = 0; i < DataStore.unitModel.getRowCount(); i++) {

        String currentUnit =
                DataStore.unitModel.getValueAt(i, 0).toString();

        if (currentUnit.equals(unitNo)) {

            DataStore.unitModel.setValueAt("Available", i, 4);
            break;
        }
    }
}
            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a row first!"
                );
            }
        });
         */
        JButton unlockBtn = new JButton("Unlock");
        unlockBtn.setBounds(1350, 10, 100, 30);
        unlockBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        unlockBtn.setBackground(Color.decode("#0000cd"));
        unlockBtn.setForeground(Color.decode("#ffffff"));
        unlockBtn.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        unlockBtn.setFocusPainted(false);

        unlockBtn.addActionListener(e -> {

            int selectedRow = table.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Select a tenant first!"
                );

                return;
            }

            int row
                    = table.convertRowIndexToModel(selectedRow);

            String tenantId
                    = DataStore.tenantModel.getValueAt(row, 0).toString();

            for (UserDataBP user : MainExtended.userData.getUsers()) {

                if (user.getTenantId().equals(tenantId)) {

                    user.setBlocked(false);
                    user.setLoginAttempts(0);

                    JOptionPane.showMessageDialog(
                            this,
                            "Account unlocked successfully!"
                    );

                    return;
                }
            }

        });
        mainPanel.add(button1);

        mainPanel.add(button2);
        mainPanel.add(button3);

        mainPanel.add(button4);

        mainPanel.add(button5);
        whitePanel.add(l1);
        whitePanel.add(l2);
        t1.add(search);
        whitePanel.add(t1);
        whitePanel.add(button6);
        whitePanel.add(edit);
        whitePanel.add(del);
        whitePanel.add(unlockBtn);
        whitePanel.add(scrollPane);
        mainPanel.add(whitePanel);

        this.add(mainPanel);

        setVisible(true);
    }

}

class EditTenant extends VaksJFrame {

    // Instance fields para ma-access sa buong class
    JTextField txtId, txtName, txtUnit, txtEmail;

    // Helper method para i-check kung green ang border ng field
    private boolean isFieldValid(JTextField field) {
        if (field.getBorder() instanceof LineBorder) {
            LineBorder border = (LineBorder) field.getBorder();
            return border.getLineColor().getRGB() == Color.GREEN.getRGB();
        }
        return false;
    }

    public EditTenant(int rowIndex) {
        setTitle("Edit Tenant");
        setSize(500, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JPanel tenantInfoPanel = new JPanel();
        tenantInfoPanel.setLayout(null);
        tenantInfoPanel.setBorder(new TitledBorder(
                new LineBorder(Color.decode("#7492BC"), 2), "Tenant Information"));
        tenantInfoPanel.setBounds(15, 20, 450, 200);
        add(tenantInfoPanel);

        Font labelFont = new Font("Dialog", Font.BOLD, 14);
        Font fieldFont = new Font("Dialog", Font.PLAIN, 14);

        JLabel lblId = new JLabel("Tenant ID:");
        lblId.setFont(labelFont);
        lblId.setBounds(40, 30, 100, 25);
        tenantInfoPanel.add(lblId);

        txtId = new JTextField();
        txtId.setFont(fieldFont);
        txtId.setBounds(160, 30, 250, 25);
        txtId.setEditable(false); // Bawal i-edit ang Tenant ID
        tenantInfoPanel.add(txtId);

        JLabel lblName = new JLabel("Full Name:");
        lblName.setFont(labelFont);
        lblName.setBounds(40, 70, 100, 25);
        tenantInfoPanel.add(lblName);

        txtName = new JTextField();
        txtName.setFont(fieldFont);
        txtName.setBounds(160, 70, 250, 25);
        tenantInfoPanel.add(txtName);

        JLabel lblUnit = new JLabel("Unit No.:");
        lblUnit.setFont(labelFont);
        lblUnit.setBounds(40, 110, 100, 25);
        tenantInfoPanel.add(lblUnit);

        txtUnit = new JTextField();
        txtUnit.setFont(fieldFont);
        txtUnit.setBounds(160, 110, 250, 25);
        tenantInfoPanel.add(txtUnit);

        JLabel lblEmail = new JLabel("Email Address:");
        lblEmail.setFont(labelFont);
        lblEmail.setBounds(40, 150, 120, 25);
        tenantInfoPanel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setFont(fieldFont);
        txtEmail.setBounds(160, 150, 250, 25);
        tenantInfoPanel.add(txtEmail);

        // ✅ Pre-fill current values mula sa DataStore.tenantModel
        txtId.setText((String) DataStore.tenantModel.getValueAt(rowIndex, 0));
        txtName.setText((String) DataStore.tenantModel.getValueAt(rowIndex, 1));
        txtUnit.setText((String) DataStore.tenantModel.getValueAt(rowIndex, 2));
        txtEmail.setText((String) DataStore.tenantModel.getValueAt(rowIndex, 3));

        // FULL NAME validation
        txtName.getDocument().addDocumentListener(new DocumentListener() {
            private void validateFullName() {
                String fullname = txtName.getText().trim();
                String nameRegex = "^[A-Za-z]{2,}([ '-][A-Za-z]{2,})+$";
                if (fullname.isEmpty() || !fullname.matches(nameRegex)) {
                    txtName.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    txtName.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateFullName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateFullName();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateFullName();
            }
        });

        // EMAIL validation
        txtEmail.getDocument().addDocumentListener(new DocumentListener() {
            private void validateEmail() {
                String email = txtEmail.getText().trim();
                String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$";

                if (email.isEmpty() || !email.matches(emailRegex)) {
                    txtEmail.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    txtEmail.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateEmail();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateEmail();
            }
        });

        // UNIT ID initial validation
        String idRegex = "^U(00[1-9]|0[1-9][0-9]|[1-9][0-9]{2})$";
        String currentUnitText = txtUnit.getText();

        if (currentUnitText != null && currentUnitText.trim().matches(idRegex)) {
            txtUnit.setBorder(new LineBorder(Color.GREEN, 2));
        } else {
            txtUnit.setBorder(new LineBorder(Color.RED, 2));
        }

        // UNIT ID validation habang nagta-type
        txtUnit.getDocument().addDocumentListener(new DocumentListener() {
            private void validateUnitId() {
                String id = txtUnit.getText().trim();
                String idRegex = "^U(00[1-9]|0[1-9][0-9]|[1-9][0-9]{2})$";

                if (id.isEmpty() || !id.matches(idRegex)) {
                    txtUnit.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    txtUnit.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateUnitId();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateUnitId();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateUnitId();
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Dialog", Font.BOLD, 14));
        btnCancel.setBounds(230, 230, 100, 35);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBackground(Color.decode("#7492BC"));
        btnCancel.addActionListener(e -> dispose());
        add(btnCancel);

        JButton btnSave = new JButton("Save");
        btnSave.setFont(new Font("Dialog", Font.BOLD, 14));
        btnSave.setBounds(350, 230, 100, 35);
        btnSave.setForeground(Color.WHITE);
        btnSave.setBackground(Color.decode("#7492BC"));

        // 🔹 UPDATED SAVE BUTTON LISTENER WITH VALIDATIONS & USER SYNC
        btnSave.addActionListener(e -> {
            String newId = txtId.getText().trim();
            String newName = txtName.getText().trim();
            String newUnit = txtUnit.getText().trim();
            String newEmail = txtEmail.getText().trim();

            // 1. Check kung may blank fields
            if (newId.isEmpty() || newName.isEmpty() || newUnit.isEmpty() || newEmail.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please fill in all fields before saving!",
                        "Missing Fields",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // 2. Check kung valid lahat ng fields (dapat nakaka-green border)
            if (!isFieldValid(txtName) || !isFieldValid(txtUnit) || !isFieldValid(txtEmail)) {
                JOptionPane.showMessageDialog(
                        this,
                        "Some fields are invalid (Red borders). Please correct them before saving!",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // 3. Check kung nag-e-exist ba ang Unit sa unitModel
            boolean unitFound = false;
            for (int i = 0; i < DataStore.unitModel.getRowCount(); i++) {
                String unitNoFromStore = (String) DataStore.unitModel.getValueAt(i, 0);
                if (unitNoFromStore.equalsIgnoreCase(newUnit)) {
                    unitFound = true;
                    break;
                }
            }

            if (!unitFound) {
                txtUnit.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(
                        this,
                        "Unit " + newUnit + " does not exist in the apartment records!",
                        "Invalid Unit",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
// Kunin ang lumang pangalan at lumang email bago palitan
            String oldName = (String) DataStore.tenantModel.getValueAt(rowIndex, 1);
            String oldEmail = (String) DataStore.tenantModel.getValueAt(rowIndex, 3);

// ✅ I-update ang Admin Table (tenantModel)
            DataStore.tenantModel.setValueAt(newId, rowIndex, 0);
            DataStore.tenantModel.setValueAt(newName, rowIndex, 1);
            DataStore.tenantModel.setValueAt(newUnit, rowIndex, 2);
            DataStore.tenantModel.setValueAt(newEmail, rowIndex, 3);

// 🔄 Auto-sync sa lahat ng history tables sa DataStore
            DataStore.updateTenantDetails(oldName, oldEmail, newName, newEmail);

// 🔄 Auto-sync sa MainExtended user accounts (para sa login credentials ng tenant)
            for (UserDataBP u : MainExtended.userData.getUsers()) {
                if (u.getEmail().equalsIgnoreCase(oldEmail)) {
                    u.setFullName(newName);
                    u.setEmail(newEmail);
                    break;
                }
            }

            JOptionPane.showMessageDialog(this, "Tenant updated and synced successfully!");
            dispose();
        });
        add(btnSave);

        setVisible(true);
    }
}



class PopUpCode extends VaksJFrame {
    JComboBox<String> f2A;

    JComboBox<String> ps1A;

    JButton btnCancel;
    JButton btnSave;

    PopUpCode(DefaultTableModel model) {
        super(JFrame.DISPOSE_ON_CLOSE);
        setSize(480, 680);
        setLayout(null);

        getContentPane().setBackground(Color.decode("#7492BC"));
        JPanel addnewT = new JPanel();
        addnewT.setLayout(null);
        addnewT.setBounds(0, 0, 500, 750);
        addnewT.setBackground(Color.white);
        add(addnewT);

        JLabel TITLE = new JLabel("                      Add new Tenant 👤");
        TITLE.setBounds(10, 0, 320, 35);
        TITLE.setFont(new Font("Dialog", Font.BOLD, 20));
        TITLE.setForeground(Color.decode("#1C4463"));
        addnewT.add(TITLE);

        JPanel topP = new JPanel();
        topP.setBounds(7, 30, 450, 210);
        topP.setBorder(new LineBorder(Color.decode("#abbfd5"), 2, true));
        topP.setBackground(Color.white);
        topP.setLayout(null);
        addnewT.add(topP);

        JLabel tenant = new JLabel("Tenant Information");
        tenant.setForeground(Color.decode("#31536E"));
        tenant.setBounds(10, 0, 320, 35);
        tenant.setFont(new Font("Dialog", Font.BOLD, 17));
        topP.add(tenant);

        JLabel lbl1 = new JLabel("Full Name*");
        lbl1.setBounds(10, 35, 190, 20);
        lbl1.setFont(new Font("Dialog", Font.PLAIN, 14));
        topP.add(lbl1);

        JTextField f1 = new JTextField();
        f1.setBounds(10, 55, 190, 30);
        topP.add(f1);

        JLabel nFormat = new JLabel("e.g., Juan Dela Cruz");
        nFormat.setBounds(5, 5, 500, 20);
        nFormat.setFont(new Font("Dialog", Font.PLAIN, 14));
        f1.add(nFormat);

        
        f1.getDocument().addDocumentListener(new DocumentListener() {
            private void toggleHint() {
                if (f1.getText().trim().isEmpty()) {
                    nFormat.setVisible(true);   
                } else {
                    nFormat.setVisible(false);  
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                toggleHint();
            }
        });

        JLabel lbl2 = new JLabel("Contact Number*");
        lbl2.setBounds(10, 90, 190, 20);
        lbl2.setFont(new Font("Dialog", Font.PLAIN, 14));
        topP.add(lbl2);

        JTextField f2 = new JTextField();
        f2.setBounds(10, 110, 190, 30);
        topP.add(f2);

        JLabel numFormat = new JLabel("Enter 11-digit mobile number");//hint
        numFormat.setBounds(5, 5, 200, 20);
        numFormat.setFont(new Font("Dialog", Font.PLAIN, 13));
        f2.add(numFormat);

        // --- Toggle visibility of format hint ---
        f2.getDocument().addDocumentListener(new DocumentListener() {
            private void toggleHint() {
                if (f2.getText().trim().isEmpty()) {
                    numFormat.setVisible(true);   // show hint kapag walang laman
                } else {
                    numFormat.setVisible(false);  // hide hint kapag may tinype
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                toggleHint();
            }
        });

        JLabel lbl3 = new JLabel("Email Address*");
        lbl3.setBounds(10, 145, 190, 20);
        lbl3.setFont(new Font("Dialog", Font.PLAIN, 14));
        topP.add(lbl3);

        JTextField f3 = new JTextField();
        f3.setBounds(10, 165, 190, 30);
        //  f3.setEditable(false);
        topP.add(f3);

        JLabel eFormat = new JLabel("Enter email address"); //hint
        eFormat.setBounds(5, 5, 500, 20);
        eFormat.setFont(new Font("Dialog", Font.PLAIN, 14));
        f3.add(eFormat);

        // --- Toggle visibility of format hint ---
        f3.getDocument().addDocumentListener(new DocumentListener() {
            private void toggleHint() {
                if (f3.getText().trim().isEmpty()) {
                    eFormat.setVisible(true);   
                    eFormat.setVisible(false); 
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                toggleHint();
            }
        });

        JLabel passs1 = new JLabel("Password*");
        //passs1.setBounds(230, 35, 190, 20);
        passs1.setBounds(230, 90, 190, 20);
        passs1.setFont(new Font("Dialog", Font.PLAIN, 14));
        topP.add(passs1);

        JPasswordField ps1 = new JPasswordField();
        // ps1.setBounds(230, 55, 190, 30);
        ps1.setBounds(230, 110, 190, 30);
        topP.add(ps1);

        JLabel passFormat = new JLabel("Enter 6-digit password"); //hint
        passFormat.setBounds(5, 5, 500, 20);
        passFormat.setFont(new Font("Dialog", Font.PLAIN, 14));
        ps1.add(passFormat);

        // --- Toggle visibility of format hint ---
        ps1.getDocument().addDocumentListener(new DocumentListener() {
            private void toggleHint() {
                if (ps1.getText().trim().isEmpty()) {
                    passFormat.setVisible(true);   // show hint kapag walang laman
                } else {
                    passFormat.setVisible(false);  // hide hint kapag may tinype
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                toggleHint();
            }
        });

        JLabel passs2 = new JLabel("Confirm Password*");
        // passs2.setBounds(230, 90, 190, 20);
        passs2.setBounds(230, 145, 190, 20);
        passs2.setFont(new Font("Dialog", Font.PLAIN, 14));
        topP.add(passs2);

        JPasswordField ps2 = new JPasswordField();
        //ps2.setBounds(230, 110, 190, 30);
        ps2.setBounds(230, 165, 190, 30);

        topP.add(ps2);

        JLabel conFormat = new JLabel("Re-enter 6-digit password"); //hint
        conFormat.setBounds(5, 5, 500, 20);
        conFormat.setFont(new Font("Dialog", Font.PLAIN, 14));
        ps2.add(conFormat);

        // --- Toggle visibility of format hint ---
        ps2.getDocument().addDocumentListener(new DocumentListener() {
            private void toggleHint() {
                if (ps2.getText().trim().isEmpty()) {
                    conFormat.setVisible(true);  
                } else {
                    conFormat.setVisible(false);  
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                toggleHint();
            }
        });

        JLabel adris = new JLabel("Gender*");
        adris.setBounds(230, 35, 190, 20);
        adris.setFont(new Font("Dialog", Font.PLAIN, 14));
        topP.add(adris);

        String[] genders = {"Male", "Female"};
        JComboBox<String> genderCombo = new JComboBox<>(genders);
        genderCombo.setBounds(230, 55, 190, 30);
        genderCombo.setFont(new Font("Dialog", Font.PLAIN, 14));
        genderCombo.setBackground(Color.WHITE);
        // genderCombo.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        topP.add(genderCombo);

        JPanel topB = new JPanel();
        topB.setBounds(7, 248, 450, 215);
        topB.setBorder(new LineBorder(Color.decode("#abbfd5"), 2, true));
        topB.setBackground(Color.white);
        topB.setLayout(null);
        addnewT.add(topB);

        // +++++++++++++++++++++++++++++++++++++++++++++++++++ NEW
        JPanel BotP = new JPanel();
        BotP.setBounds(7, 471, 450, 100); // Placed below the buttons
        BotP.setBorder(new LineBorder(Color.decode("#abbfd5"), 2, true));
        BotP.setBackground(Color.white);
        BotP.setLayout(null);
        addnewT.add(BotP);

        JLabel uniT = new JLabel("Unit Information");
        uniT.setForeground(Color.decode("#31536E"));
        uniT.setBounds(10, 0, 320, 35);
        uniT.setFont(new Font("Dialog", Font.BOLD, 17));
        BotP.add(uniT);

        JLabel Labl1 = new JLabel("Unit Type*");
        Labl1.setBounds(10, 35, 190, 20);
        Labl1.setFont(new Font("Dialog", Font.PLAIN, 14));
        BotP.add(Labl1);

        JLabel Labl2 = new JLabel("Monthly Rent*");
        Labl2.setBounds(230, 35, 190, 20);
        Labl2.setFont(new Font("Dialog", Font.PLAIN, 14));
        BotP.add(Labl2);

        JTextField f1f = new JTextField();
        f1f.setBounds(230, 60, 190, 30);
        f1f.setEditable(false);
        BotP.add(f1f);

        JTextField unitTypeField = new JTextField();
        unitTypeField.setBounds(10, 60, 190, 30);
        unitTypeField.setEditable(false); 
        BotP.add(unitTypeField);

// Create dropdown model from unitModel
        DefaultComboBoxModel<String> unitOptions = new DefaultComboBoxModel<>();
        unitOptions.addElement("Select Unit...");

        for (int i = 0; i < DataStore.unitModel.getRowCount(); i++) {
            String unitNo = (String) DataStore.unitModel.getValueAt(i, 0);   
            String status = (String) DataStore.unitModel.getValueAt(i, 4);   

            if ("Available".equalsIgnoreCase(status)) {
                unitOptions.addElement(unitNo);
            }
        }

// Dropdown
        f2A = new JComboBox<>(unitOptions);
        f2A.setBounds(10, 110, 190, 30);
        topB.add(f2A);

        f2A.addActionListener(e -> {
            String selectedUnit = (String) f2A.getSelectedItem();

            if (!"Select Unit...".equals(selectedUnit)) {
                for (int i = 0; i < DataStore.unitModel.getRowCount(); i++) {
                    String unitNo = (String) DataStore.unitModel.getValueAt(i, 0);
                    if (unitNo.equals(selectedUnit)) {
                        String type = (String) DataStore.unitModel.getValueAt(i, 1); 
                        String rent = (String) DataStore.unitModel.getValueAt(i, 3); 

                        unitTypeField.setText(type); 
                        f1f.setText(rent);           
                        break;
                    }
                }
            } else {
                unitTypeField.setText("");
                f1f.setText("");
            }
        });

        // +++++++++++++++++++++++++++++++++++++++++++++++++++ END
        JLabel tenantA = new JLabel("Tenant Apartment Unit");
        tenantA.setForeground(Color.decode("#31536E"));
        tenantA.setBounds(10, 0, 320, 35);
        tenantA.setFont(new Font("Dialog", Font.BOLD, 17));
        topB.add(tenantA);

        JLabel lbl1A = new JLabel("Tenant ID");
        lbl1A.setBounds(10, 35, 190, 20);
        lbl1A.setFont(new Font("Dialog", Font.PLAIN, 14));
        topB.add(lbl1A);

        JTextField f1A = new JTextField();
        f1A.setBounds(10, 55, 190, 30);
        f1A.setEditable(false); // read-only

        topB.add(f1A);

        // --- Auto-generate random Tenant ID ---
        Random rand = new Random();
        int randomNum = rand.nextInt(999) + 1; // 1–999
        String generatedId = String.format("T%03d", randomNum); // e.g. T001, T045, T999
        f1A.setText(generatedId);

        JLabel lbl3A = new JLabel("Move-in Date *");
        lbl3A.setBounds(10, 145, 190, 20);
        lbl3A.setFont(new Font("Dialog", Font.PLAIN, 14));
        topB.add(lbl3A);

        JTextField f3A = new JTextField();
        f3A.setBounds(10, 165, 190, 30);
        topB.add(f3A);

        JLabel yrFormat = new JLabel("YYYY-MM-DD"); //hint
        yrFormat.setBounds(5, 5, 200, 20);
        yrFormat.setFont(new Font("Dialog", Font.PLAIN, 14));
        f3A.add(yrFormat);

        // --- Toggle visibility of format hint ---
        f3A.getDocument().addDocumentListener(new DocumentListener() {
            private void toggleHint() {
                if (f3A.getText().trim().isEmpty()) {
                    yrFormat.setVisible(true);   // show hint kapag walang laman
                } else {
                    yrFormat.setVisible(false);  // hide hint kapag may tinype
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                toggleHint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                toggleHint();
            }
        });

        JLabel passs1A = new JLabel("Lease of stay *");
        passs1A.setBounds(230, 35, 190, 20);
        passs1A.setFont(new Font("Dialog", Font.PLAIN, 14));
        topB.add(passs1A);

        String[] leaseOptions = {"Select Duration...", "3 Months", "6 Months", "1 Years"};
        ps1A = new JComboBox<>(leaseOptions);
        ps1A.setBounds(230, 55, 190, 30);
        topB.add(ps1A);

        JLabel passs2A = new JLabel("End Date");
        passs2A.setBounds(230, 90, 190, 20);
        passs2A.setFont(new Font("Dialog", Font.PLAIN, 14));
        topB.add(passs2A);

        JTextField ps2A = new JTextField();
        ps2A.setBounds(230, 110, 190, 30);
        ps2A.setEditable(false);
        topB.add(ps2A);

// --- AUTO-COMPUTE END DATE ---
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Runnable updateEndDate = () -> {
            String moveInText = f3A.getText().trim().replace("/", "-");
            String lease = (String) ps1A.getSelectedItem();

            // ✅ Skip kung empty pa ang Move-in Date o hindi pa pumipili ng lease
            if (moveInText.isEmpty() || lease.equals("Select Duration...")) {
                ps2A.setText(""); // clear end date
                ps2A.setBorder(new LineBorder(Color.GRAY, 1)); // neutral border
                return;
            }

            try {
                LocalDate moveInDate = LocalDate.parse(moveInText, formatter);
                LocalDate endDate = null;

                switch (lease) {
                    case "3 Months":
                        endDate = moveInDate.plusMonths(3).minusDays(1);
                        break;
                    case "6 Months":
                        endDate = moveInDate.plusMonths(6).minusDays(1);
                        break;
                    case "1 Years":
                        endDate = moveInDate.plusYears(1).minusDays(1);
                        break;
                }

                if (endDate != null) {
                    ps2A.setText(endDate.format(formatter));
                    ps2A.setBorder(new LineBorder(Color.GREEN, 2));
                }
            } catch (Exception ex) {
                // Kung may laman pero mali format → error
                ps2A.setText("Invalid date");
                ps2A.setBorder(new LineBorder(Color.RED, 2));
            }
        };

// --- LISTENERS ---
        f3A.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEndDate.run();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEndDate.run();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEndDate.run();
            }
        });

        ps1A.addActionListener(e -> updateEndDate.run());

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(237, 590, 105, 32);
        btnCancel.setBackground(Color.decode("#C6D5E6"));
        btnCancel.setFont(new Font("Dialog", Font.BOLD, 13));
        btnCancel.setFocusPainted(false);
        addnewT.add(btnCancel);

        btnCancel.addActionListener(e -> {
            // isara lang yung popup
            this.dispose();

        });

        btnSave = new JButton("Save");
        btnSave.setBounds(352, 590, 105, 32);
        btnSave.setBackground(Color.decode("#C6D5E6"));
        btnSave.setFont(new Font("Dialog", Font.BOLD, 13));
        btnSave.setFocusPainted(false);
        addnewT.add(btnSave);

        btnSave.addActionListener(e -> {
            String fullName = f1.getText().trim();
            String contact = f2.getText().trim();
            String email = f3.getText().trim();
            String password = new String(ps1.getPassword()).trim();
            String confirmPassword = new String(ps2.getPassword()).trim();
            String moveInDate = f3A.getText().trim();
            String gender = (String) genderCombo.getSelectedItem(); // ✅ Gender
            String leaseDuration = (String) ps1A.getSelectedItem();
            String unit = (String) f2A.getSelectedItem();

            // Regex rules
            String nameRegex = "^[A-Za-z]{2,}([ '-][A-Za-z]{2,})+$";
            String phoneRegex = "^09\\d{9}$";
            String emailRegex = "^(?=.{6,}@gmail\\.com$)[A-Za-z0-9]+(?:\\.[A-Za-z0-9]+)*@gmail\\.com$";
            String passRegex = "^[0-9]{6}$";
            String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$"; // YYYY-MM-DD

            // 🔹 Validation checks
            if (!fullName.matches(nameRegex)) {
                JOptionPane.showMessageDialog(this, "Invalid full name format!");
                return;
            }
            if (!contact.matches(phoneRegex)) {
                JOptionPane.showMessageDialog(this, "Invalid contact number! Must be 11 digits starting with 09.");
                return;
            }
            if (!email.matches(emailRegex)) {
                JOptionPane.showMessageDialog(this, "Invalid email format!");
                return;
            }
            if (!password.matches(passRegex)) {
                JOptionPane.showMessageDialog(this, "Password must be exactly 6 digits!");
                return;
            }
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!");
                return;
            }
            if (!moveInDate.matches(dateRegex)) {
                JOptionPane.showMessageDialog(this, "Invalid move-in date! Format must be YYYY-MM-DD.");
                return;
            }

            if (!moveInDate.matches(dateRegex)) {
                JOptionPane.showMessageDialog(this, "Invalid move-in date! Format must be YYYY-MM-DD.");
                return;
            }

            try {
                LocalDate selectedDate = LocalDate.parse(moveInDate);
                LocalDate today = LocalDate.now();

                if (selectedDate.isBefore(today)) {
                    JOptionPane.showMessageDialog(this,
                            "Move-in date cannot be in the past!");
                    return;
                }

            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this,
                        "Invalid move-in date!");
                return;
            }
            // GAMITIN ANG tamang variable na `leaseDuration` sa validation
            if (leaseDuration == null || leaseDuration.equals("Select Duration...")) {
                JOptionPane.showMessageDialog(this, "Please select a lease of stay!");
                return;

            }
            //Defensive check para sa Unit kung "Select Unit..." pa rin ang nakapili
            if (unit == null || unit.equals("Select Unit...")) {
                JOptionPane.showMessageDialog(this, "Please select an available unit!");
                return;
            }

            if (gender == null || gender.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a gender!");
                return;
            }

            //If all regex checks pass proceed tayo sa save
            String tenantId = f1A.getText();
            unit = (String) f2A.getSelectedItem();
            String lease = (String) ps1A.getSelectedItem();
            String endDate = ps2A.getText();
            int rentValue = Integer.parseInt(f1f.getText().replaceAll("[^0-9]", "").trim());

            UserDataBP newUser = new UserDataBP(
                    fullName, email, password, contact,
                    "Tenant", unitTypeField.getText(), tenantId,
                    lease, unit, moveInDate, endDate,
                    gender, rentValue
            );

            //Set starting balance = monthly rent
            newUser.setCurrentBalance(rentValue);

            UserData userData = new UserData();
            userData.addUser(newUser);

            model.addRow(new Object[]{tenantId, fullName, unit, email});

            for (int i = 0; i < DataStore.unitModel.getRowCount(); i++) {

                String unitNo = DataStore.unitModel.getValueAt(i, 0).toString();
                String status = DataStore.unitModel.getValueAt(i, 4).toString();

                if (unitNo.equals(unit) && status.equalsIgnoreCase("Available")) {

                    DataStore.unitModel.setValueAt("Occupied", i, 4);
                    break;
                }
            }

            JOptionPane.showMessageDialog(this, "Tenant account successfully added!");
            this.dispose();
        });

// FULL NAME (must have space, letters only)
        f1.getDocument().addDocumentListener(new DocumentListener() {
            private void validateFullName() {
                String fullname = f1.getText().trim();
                // String nameRegex = "^[A-Za-z]+([ '-][A-Za-z]+)+$";
                String nameRegex = "^[A-Za-z]{2,}([ '-][A-Za-z]{2,})+$";
                if (fullname.isEmpty() || !fullname.matches(nameRegex)) {
                    f1.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    f1.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateFullName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateFullName();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateFullName();
            }
        });

// CONTACT NUMBER (PH style: must start with 09, 11 digits)
        f2.getDocument().addDocumentListener(new DocumentListener() {
            private void validatePhone() {
                String phone = f2.getText().trim();
                String phoneRegex = "^09\\d{9}$";
                if (phone.isEmpty() || !phone.matches(phoneRegex)) {
                    f2.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    f2.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validatePhone();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validatePhone();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validatePhone();
            }
        });

// EMAIL (valid format)
        f3.getDocument().addDocumentListener(new DocumentListener() {
            private void validateEmail() {
                String email = f3.getText().trim();
                String emailRegex = "^(?=.{6,}@gmail\\.com$)[A-Za-z0-9]+(?:\\.[A-Za-z0-9]+)*@gmail\\.com$";

                if (email.isEmpty() || !email.matches(emailRegex)) {
                    f3.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    f3.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateEmail();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateEmail();
            }
        });

        ps1.getDocument().addDocumentListener(new DocumentListener() {
            private void validatePassword() {
                String pass = new String(ps1.getPassword()).trim();
                // String passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$";
                String passRegex = "^[0-9]{6}$";

                if (pass.isEmpty() || !pass.matches(passRegex)) {
                    ps1.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    ps1.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validatePassword();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validatePassword();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validatePassword();
            }
        });

// CONFIRM PASSWORD (must match ps1)
        ps2.getDocument().addDocumentListener(new DocumentListener() {
            private void validateConfirmPassword() {
                String pass = new String(ps1.getPassword()).trim();
                String confirm = new String(ps2.getPassword()).trim();
                if (confirm.isEmpty() || !confirm.equals(pass)) {
                    ps2.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    ps2.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateConfirmPassword();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateConfirmPassword();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateConfirmPassword();
            }
        });

        // UNIT FORMAT (format U01–U050 only)
        f1A.getDocument().addDocumentListener(new DocumentListener() {
            private void validateTenantId() {
                String id = f1A.getText().trim();
                // Regex: U0 kasunod ang 1 hanggang 50 (hal. U01 hanggang U050)
                String idRegex = "^U0([1-9]|[1-4][0-9]|50)$";

                if (id.isEmpty() || !id.matches(idRegex)) {
                    f1A.setBorder(new LineBorder(Color.RED, 2)); // ❌ invalid
                } else {
                    // Extra check: must be between 1 and 50
                    try {
                        int num = Integer.parseInt(id.substring(2)); // Tanggalin ang 'U0' para makuha ang mismong numero
                        if (num >= 1 && num <= 50) {
                            f1A.setBorder(new LineBorder(Color.GREEN, 2)); // ✅ valid
                        } else {
                            f1A.setBorder(new LineBorder(Color.RED, 2));
                        }
                    } catch (Exception ex) {
                        f1A.setBorder(new LineBorder(Color.RED, 2));
                    }
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateTenantId();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateTenantId();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateTenantId();
            }
        });

// MOVE-IN DATE (must be today or future)
        f3A.getDocument().addDocumentListener(new DocumentListener() {
            private void validateMoveInDate() {
                String moveIn = f3A.getText().trim();
                String dateRegex = "^\\d{4}[-/]\\d{2}[-/]\\d{2}$";

                if (moveIn.isEmpty() || !moveIn.matches(dateRegex)) {
                    f3A.setBorder(new LineBorder(Color.RED, 2));
                    return;
                }

                try {
                    String normalized = moveIn.replace("/", "-");
                    LocalDate moveInDate = LocalDate.parse(normalized, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    LocalDate today = LocalDate.now(); // ✅ system date, works offline

                    if (!moveInDate.isBefore(today)) {
                        f3A.setBorder(new LineBorder(Color.GREEN, 2)); // valid (today or future)
                    } else {
                        f3A.setBorder(new LineBorder(Color.RED, 2));   // invalid (past date)
                    }
                } catch (Exception ex) {
                    f3A.setBorder(new LineBorder(Color.RED, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateMoveInDate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateMoveInDate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateMoveInDate();
            }
        });

// END DATE (same format YYYY-MM-DD or YYYY/MM/DD)
        ps2A.getDocument().addDocumentListener(new DocumentListener() {
            private void validateEndDate() {
                String end = ps2A.getText().trim();
                String dateRegex = "^\\d{4}[-/]\\d{2}[-/]\\d{2}$";
                if (end.isEmpty() || !end.matches(dateRegex)) {
                    ps2A.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    ps2A.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateEndDate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateEndDate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateEndDate();
            }
        });

        setVisible(true);
    }

}
