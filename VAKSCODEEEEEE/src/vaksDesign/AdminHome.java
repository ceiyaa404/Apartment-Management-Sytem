package vaksDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class AdminHome extends VaksJFrame {

    static ApartmentManagement apartmentPage;
    static AdminHome adminHome;
    static TenantManagement tenantManagement;
    static TransactionHistory transactionHistory;
    JLabel fValue, sValue, tValue; 

    AdminHome() {

        setTitle("Admind Dashboard");
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#7492BC"));
        mainPanel.setBounds(0, 0, 1542, 850);
        mainPanel.setLayout(null);

        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.decode("#C8D8EF"));
        whitePanel.setBounds(0, 65, 1542, 850);
        whitePanel.setLayout(null);

        ImageIcon icon = new ImageIcon("picture/LEGENDARY.png");
        Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel iconLabel = new JLabel(scaledIcon);
        iconLabel.setBounds(40, 10, 50, 50);
        mainPanel.add(iconLabel);
        mainPanel.repaint();

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

        // ================= DASHBOARD HEADER LABELS =================
        JLabel l1 = new JLabel("Dashboard ");
        l1.setBounds(20, 75, 400, 60);
        l1.setFont(new Font("Dialog", Font.BOLD, 40));
        l1.setForeground(Color.decode("#000000"));

        JLabel l2 = new JLabel("Welcome back, admin! ");
        l2.setBounds(20, 115, 400, 60);
        l2.setFont(new Font("Dialog", Font.PLAIN, 30));
        l2.setForeground(Color.decode("#000000"));

        JLabel l3 = new JLabel("Here's an overview of your apartment system. ");
        l3.setBounds(20, 150, 700, 60);
        l3.setFont(new Font("Dialog", Font.PLAIN, 25));
        l3.setForeground(Color.decode("#000000"));

        // ================= TOP STATS BOX 1: TOTAL TENANTS (Fbox) =================
        JPanel Fbox = new JPanel();
        Fbox.setBackground(Color.decode("#F4F6F9"));
        Fbox.setBounds(90, 220, 400, 210);
        Fbox.setBorder(new LineBorder(Color.decode("#7492BC"), 5, true));
        Fbox.setLayout(null);

        JLabel fTitle = new JLabel("Total Tenants");
        fTitle.setBounds(20, 15, 200, 25);
        fTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        fTitle.setForeground(Color.decode("#64748B"));

        fValue = new JLabel("0");
        fValue.setBounds(20, 45, 200, 50);
        fValue.setFont(new Font("Dialog", Font.BOLD, 35));
        fValue.setForeground(Color.decode("#1E293B"));
        Fbox.add(fTitle);
        Fbox.add(fValue);

        ImageIcon Icons = new ImageIcon("picture/human.png");
        int newW1 = 80;
        int newH1 = 80;
        Image caled1 = Icons.getImage().getScaledInstance(newW1, newH1, Image.SCALE_SMOOTH);
        JLabel imag1 = new JLabel(new ImageIcon(caled1));
        imag1.setBounds(300, 110, newW1, newH1);
        Fbox.add(imag1);

        //  Total Tenants
        fValue.setText(String.valueOf(DataStore.tenantModel.getRowCount()));
        DataStore.tenantModel.addTableModelListener(e -> {
            fValue.setText(String.valueOf(DataStore.tenantModel.getRowCount()));
        });

        // ================= TOP STATS BOX 2: OCCUPIED UNITS (Sbox) =================
        JPanel Sbox = new JPanel();
        Sbox.setBackground(Color.decode("#F4F6F9"));
        Sbox.setBounds(570, 220, 400, 210);
        Sbox.setBorder(new LineBorder(Color.decode("#7492BC"), 5, true));
        Sbox.setLayout(null);

        JLabel sTitle = new JLabel("Occupied Units");
        sTitle.setBounds(20, 15, 200, 25);
        sTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        sTitle.setForeground(Color.decode("#64748B"));

        sValue = new JLabel("0");
        sValue.setBounds(20, 45, 200, 50);
        sValue.setFont(new Font("Dialog", Font.BOLD, 35));
        sValue.setForeground(Color.decode("#1E293B"));
        Sbox.add(sTitle);
        Sbox.add(sValue);

        ImageIcon iconS = new ImageIcon("picture/hulock.png");
        int wS = 80;
        int hS = 80;
        Image scaledS = iconS.getImage().getScaledInstance(wS, hS, Image.SCALE_SMOOTH);
        JLabel imagS = new JLabel(new ImageIcon(scaledS));
        imagS.setBounds(300, 110, wS, hS);
        Sbox.add(imagS);

        // ================= TOP STATS BOX 3: AVAILABLE UNITS (Tbox) =================
        JPanel Tbox = new JPanel();
        Tbox.setBackground(Color.decode("#F4F6F9"));
        Tbox.setBounds(1050, 220, 400, 210);
        Tbox.setBorder(new LineBorder(Color.decode("#7492BC"), 5, true));
        Tbox.setLayout(null);

        JLabel tTitle = new JLabel("Available Units");
        tTitle.setBounds(20, 15, 200, 25);
        tTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        tTitle.setForeground(Color.decode("#64748B"));

        tValue = new JLabel("0");
        tValue.setBounds(20, 45, 200, 50);
        tValue.setFont(new Font("Dialog", Font.BOLD, 35));
        tValue.setForeground(Color.decode("#1E293B"));
        Tbox.add(tTitle);
        Tbox.add(tValue);

        ImageIcon iconT = new ImageIcon("picture/hudoor.png");
        int wT = 80;
        int hT = 80;
        Image scaledT = iconT.getImage().getScaledInstance(wT, hT, Image.SCALE_SMOOTH);
        JLabel imagT = new JLabel(new ImageIcon(scaledT));
        imagT.setBounds(300, 110, wT, hT);
        Tbox.add(imagT);

        // 🔹 Isang malinis at pinag-isang TableModelListener para sa Units
        DataStore.unitModel.addTableModelListener(e -> {
            int occupiedCount = 0;
            int availableCount = 0;

            for (int i = 0; i < DataStore.unitModel.getRowCount(); i++) {
                Object val = DataStore.unitModel.getValueAt(i, 4); // Column 4 = Status
                if (val != null) {
                    String status = val.toString().trim();

                    if ("Occupied".equalsIgnoreCase(status)) {
                        occupiedCount++;
                    } else if ("Available".equalsIgnoreCase(status)) {
                        availableCount++;
                    }
                }
            }

            // I-update ang mga counters sa Dashboard nang sabay
            sValue.setText(String.valueOf(occupiedCount));
            tValue.setText(String.valueOf(availableCount));
        });

// Huwag kalimutan ding tawagin ito minsan sa simula (constructor) para sa paunang bilang pagbukas ng app:
        int initialOccupied = 0;
        int initialAvailable = 0;
        for (int i = 0; i < DataStore.unitModel.getRowCount(); i++) {
            Object val = DataStore.unitModel.getValueAt(i, 4);
            if (val != null) {
                String status = val.toString().trim();
                if ("Occupied".equalsIgnoreCase(status)) {
                    initialOccupied++;
                } else if ("Available".equalsIgnoreCase(status)) {
                    initialAvailable++;
                }
            }
        }
        sValue.setText(String.valueOf(initialOccupied));
        tValue.setText(String.valueOf(initialAvailable));

        // ================= RIGHT PANEL: QUICK ACTIONS (Dbox) =================
        JPanel Dbox = new JPanel();
        Dbox.setBackground(Color.decode("#F4F6F9"));
        Dbox.setBounds(1030, 455, 430, 365);
        Dbox.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        Dbox.setLayout(null);

        JLabel quickActionTitle = new JLabel("Quick Action");
        quickActionTitle.setBounds(20, 15, 300, 25);
        quickActionTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        quickActionTitle.setForeground(Color.decode("#1E293B"));
        Dbox.add(quickActionTitle);

        JButton addTenantBtn = new JButton("👤 Add Tenant");
        addTenantBtn.setBounds(20, 52, 390, 62);
        addTenantBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        addTenantBtn.setBackground(Color.WHITE);
        addTenantBtn.setForeground(Color.decode("#1E293B"));
        addTenantBtn.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        addTenantBtn.setFocusPainted(false);

        addTenantBtn.addActionListener(e -> { // if user click view details, it go to unit v2 
            // Check kung may available unit
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
                TenantManagement.openAddTenantPopup();
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

        JButton addUnitBtn = new JButton("🚪 Add Apartment Unit");
        addUnitBtn.setBounds(20, 126, 390, 62);
        addUnitBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        addUnitBtn.setBackground(Color.WHITE);
        addUnitBtn.setForeground(Color.decode("#1E293B"));
        addUnitBtn.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        addUnitBtn.setFocusPainted(false);

        addUnitBtn.addActionListener(e -> { // if user click view details, it go to unit v2 

            DataStore.unitModel.addRow(new Object[]{
                "U00" + (DataStore.unitModel.getRowCount() + 1), // auto Unit No.
                "Studio",
                "35",
                "₱8000",
                "Available",
                "Edit | Delete"
            });
        });

        JButton viewTenantsBtn = new JButton("👥 View All Tenants");
        viewTenantsBtn.setBounds(20, 200, 390, 62);
        viewTenantsBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        viewTenantsBtn.setBackground(Color.WHITE);
        viewTenantsBtn.setForeground(Color.decode("#1E293B"));
        viewTenantsBtn.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        viewTenantsBtn.setFocusPainted(false);

        viewTenantsBtn.addActionListener(e -> { // if user click view details, it go to unit v2 

            if (tenantManagement == null) {
                tenantManagement = new TenantManagement();
            }
            tenantManagement.setVisible(true);
            this.dispose();

        });

        JButton viewUnitsBtn = new JButton("🏢 View All Unit");
        viewUnitsBtn.setBounds(20, 274, 390, 62);
        viewUnitsBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        viewUnitsBtn.setBackground(Color.WHITE);
        viewUnitsBtn.setForeground(Color.decode("#1E293B"));
        viewUnitsBtn.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        viewUnitsBtn.setFocusPainted(false);

        viewUnitsBtn.addActionListener(e -> {
            if (apartmentPage == null) {
                apartmentPage = new ApartmentManagement();
            }
            apartmentPage.setVisible(true);
            this.dispose();

        });

        Dbox.add(addTenantBtn);
        Dbox.add(addUnitBtn);
        Dbox.add(viewTenantsBtn);
        Dbox.add(viewUnitsBtn);

        // ================= LEFT PANEL: RECENT TRANSACTIONS TABLE (Bbox) =================
        JPanel Bbox = new JPanel();
        Bbox.setBackground(Color.decode("#F4F6F9"));
        Bbox.setBounds(90, 390, 915, 365);
        Bbox.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        Bbox.setLayout(null);

        JLabel recentLabel = new JLabel("Recent Transaction");
        recentLabel.setBackground(Color.decode("#F4F6F9"));
        recentLabel.setFont(new Font("Dialog", Font.BOLD, 22));
        recentLabel.setBounds(20, 15, 300, 30);

        //String[] columns = {"Date", "Tenant", "Method", "Amount"};
        //  String[][] data = {
        //   {"2026-10-12", "Juan Dela Cruz", "Cash", "₱3,000"},
        //   {"2026-10-11", "Maria Santos", "GCash", "₱2,500"}
        //  };
        // Gamitin ang transactionModel o paymentHistoryModel mula sa DataStore para real-time makita ng admin
        JTable table = new JTable(DataStore.adminRecentTransactionModel);
        table.setRowHeight(50);
        table.setFont(new Font("Dialog", Font.PLAIN, 18));
        table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 20));

        // I-disable ang default cell editor para sa lahat ng uri ng data
        table.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 55, 875, 285);

        // ================= ADDING COMPONENTS TO PANELS =================
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(button4);
        mainPanel.add(button5);
        mainPanel.add(l1);
        mainPanel.add(l2);
        mainPanel.add(l3);
        mainPanel.add(Fbox);
        mainPanel.add(Sbox);
        mainPanel.add(Tbox);
        mainPanel.add(Dbox);

        whitePanel.add(Bbox);

        Bbox.add(scrollPane);
        Bbox.add(recentLabel);

        mainPanel.add(whitePanel);
        this.add(mainPanel);

        setVisible(true);
    }
}

