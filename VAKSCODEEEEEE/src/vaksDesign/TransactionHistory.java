package vaksDesign;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class TransactionHistory extends VaksJFrame {

    JTable table;
    static ApartmentManagement apartmentPage;
    static AdminHome adminHome;
    static TenantManagement tenantManagement;
    static TransactionHistory transactionHistory;
    static PaymentHistory paymentHistory;

    JDateChooser fromDate, toDate;

    TransactionHistory() {

        setTitle("Transaction History");
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

         button5.addActionListener(e -> { // if user click view details, it go to unit v2

        new MainExtended().setVisible(true);
            this.dispose();     
        });
        

        JLabel l1 = new JLabel("Transaction History");
        l1.setBounds(20, 25, 600, 60);
        l1.setFont(new Font("Dialog", Font.BOLD, 40));
        l1.setForeground(Color.decode("#000000"));

        JLabel l2 = new JLabel("View all system transactions");
        l2.setBounds(20, 65, 600, 60);
        l2.setFont(new Font("Dialog", Font.PLAIN, 25));
        l2.setForeground(Color.decode("#000000"));

        JTextField t1 = new JTextField(""); // search button
        t1.setBounds(770, 65, 350, 60);
        t1.setFont(new Font("Dialog", Font.PLAIN, 25));
        t1.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));

        JLabel search = new JLabel("Search...");
        search.setBounds(15, 20, 300, 20);
        search.setFont(new Font("Dialog", Font.BOLD, 20));
        search.setForeground(Color.decode("#003366"));

        JButton paymentManagement = new JButton("Billing Status");
        paymentManagement.setBounds(1170, 65, 300, 60);
        paymentManagement.setBackground(Color.decode("#7492BC"));
        paymentManagement.setForeground(Color.WHITE);
        paymentManagement.setFont(new Font("Dialog", Font.BOLD, 18));

        paymentManagement.addActionListener(e -> {
            if (paymentHistory == null) {
                paymentHistory = new PaymentHistory();
            }
            paymentHistory.setVisible(true);
            this.dispose();
        });
        
        // Gamit na natin ang paymentHistoryModel na may 6 columns
      //  table = new JTable(DataStore.paymentHistoryModel);
      
      DefaultTableModel paidModel = new DefaultTableModel(
    new String[]{"Date", "Unit No.", "Tenant Name", "Method", "Amount", "Status"},
    0
);

for (int i = 0; i < DataStore.paymentHistoryModel.getRowCount(); i++) {

    String status = DataStore.paymentHistoryModel.getValueAt(i, 5).toString();

    if (status.equalsIgnoreCase("Paid")) {

        paidModel.addRow(new Object[]{
            DataStore.paymentHistoryModel.getValueAt(i, 0),
            DataStore.paymentHistoryModel.getValueAt(i, 1),
            DataStore.paymentHistoryModel.getValueAt(i, 2),
            DataStore.paymentHistoryModel.getValueAt(i, 3),
            DataStore.paymentHistoryModel.getValueAt(i, 4),
            DataStore.paymentHistoryModel.getValueAt(i, 5)
        });
    }
}

        table = new JTable(paidModel);
      
      
   
        
        table.setRowHeight(70);
        table.setFont(new Font("Dialog", Font.PLAIN, 20));
         // I-disable ang default cell editor para sa lahat ng uri ng data
        table.setDefaultEditor(Object.class, null);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 30));
        header.setBackground(Color.decode("#4682b4"));
        header.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(390, 220, 1120, 600);

        // Search filter logic para sa paymentHistoryModel
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(paidModel);
        table.setRowSorter(sorter);

        t1.getDocument().addDocumentListener(new DocumentListener() {
            private void filter() {
                String text = t1.getText().trim();
                if (text.isEmpty()) {
                    search.setVisible(true);
                    sorter.setRowFilter(null);
                } else {
                    search.setVisible(false);
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0, 1, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) { filter(); }
            @Override
            public void removeUpdate(DocumentEvent e) { filter(); }
            @Override
            public void changedUpdate(DocumentEvent e) { filter(); }
        });

        JPanel whitePanel3 = new JPanel();
        whitePanel3.setBackground(Color.decode("#F4F6F9"));
        whitePanel3.setBounds(20, 220, 350, 600);
        whitePanel3.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        whitePanel3.setLayout(null);

        JPanel bluePanel1 = new JPanel();
        bluePanel1.setBackground(Color.decode("#C8D8EF"));
        bluePanel1.setBounds(15, 15, 320, 565);
        bluePanel1.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        bluePanel1.setLayout(null);

        JLabel l3 = new JLabel("Filters: ");
        l3.setBounds(10, 20, 200, 30);
        l3.setFont(new Font("Dialog", Font.BOLD, 25));
        l3.setForeground(Color.decode("#000000"));

        JLabel l4 = new JLabel("Payment Method ");
        l4.setBounds(10, 40, 200, 90);
        l4.setFont(new Font("Dialog", Font.BOLD, 20));
        l4.setForeground(Color.decode("#000000"));

        JLabel l6 = new JLabel("Sort");
        l6.setBounds(10, 220, 200, 90);
        l6.setFont(new Font("Dialog", Font.BOLD, 20));
        l6.setForeground(Color.decode("#000000"));

        JButton Filter = new JButton("Apply Filter");
        Filter.setBounds(30, 490, 260, 50);
        Filter.setBackground(Color.decode("#7492BC"));
        Filter.setForeground(Color.WHITE);
        Filter.setFont(new Font("Dialog", Font.BOLD, 18));

        JRadioButton bank = new JRadioButton("Bank Transfer");
        JRadioButton Cc = new JRadioButton("Credit Card");
        JRadioButton Dc = new JRadioButton("Debit Card");
        JRadioButton gCash = new JRadioButton("Gcash");
        JRadioButton maya = new JRadioButton("Maya");

        bank.setBounds(10, 100, 200, 30);
        Cc.setBounds(10, 130, 200, 30);
        Dc.setBounds(10, 160, 200, 30);
        gCash.setBounds(10, 190, 200, 30);
        maya.setBounds(10, 220, 200, 30);

        bank.setFont(new Font("Dialog", Font.PLAIN, 20));
        Cc.setFont(new Font("Dialog", Font.PLAIN, 20));
        Dc.setFont(new Font("Dialog", Font.PLAIN, 20));
        gCash.setFont(new Font("Dialog", Font.PLAIN, 20));
        maya.setFont(new Font("Dialog", Font.PLAIN, 20));

        bank.setBackground(Color.decode("#C8D8EF"));
        Cc.setBackground(Color.decode("#C8D8EF"));
        Dc.setBackground(Color.decode("#C8D8EF"));
        gCash.setBackground(Color.decode("#C8D8EF"));
        maya.setBackground(Color.decode("#C8D8EF"));

        ButtonGroup group = new ButtonGroup();
        group.add(bank);
        group.add(Cc);
        group.add(Dc);
        group.add(gCash);
        group.add(maya);

        String[] sortOptions = {
    "Amount: Lowest to Highest",
    "Amount: Highest to Lowest",
    "Date: Oldest to Newest",
    "Date: Newest to Oldest"
};

JComboBox<String> sortBox = new JComboBox<>(sortOptions);
sortBox.setBounds(10, 280, 300, 40);
bluePanel1.add(sortBox);

sortBox.addActionListener(e -> {

    String choice = (String) sortBox.getSelectedItem();
    int rowCount = paidModel.getRowCount();

    if (rowCount <= 1) return;

    switch (choice) {

        case "Amount: Lowest to Highest":
            dsaMergeSort(paidModel, 4, true, true);
            break;

        case "Amount: Highest to Lowest":
            dsaMergeSort(paidModel, 4, false, true);
            break;

        case "Date: Oldest to Newest":
            dsaMergeSort(paidModel, 0, true, false);
            break;

        case "Date: Newest to Oldest":
            dsaMergeSort(paidModel, 0, false, false);
            break;
    }

    paidModel.fireTableDataChanged();
});


         
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(10, 338, 100, 20);
        fromLabel.setForeground(Color.decode("#000000"));
        fromLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        bluePanel1.add(fromLabel);

        fromDate = new JDateChooser();
        fromDate.setBounds(10, 360, 300, 40);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(10, 410, 100, 20);
        toLabel.setForeground(Color.decode("#000000"));
        bluePanel1.add(toLabel);

        toDate = new JDateChooser();
        toDate.setBounds(10, 430, 300, 40);
        bluePanel1.add(toDate);
        bluePanel1.add(fromDate);

        Filter.addActionListener(e -> {
            java.util.List<RowFilter<Object, Object>> filters = new java.util.ArrayList<>();
            
            if (bank.isSelected()) {
                filters.add(RowFilter.regexFilter("(?i)Bank Transfer", 3));
            } else if (Cc.isSelected()) {
                filters.add(RowFilter.regexFilter("(?i)Credit Card", 3));
            } else if (Dc.isSelected()) {
                filters.add(RowFilter.regexFilter("(?i)Debit Card", 3));
            } else if (gCash.isSelected()) {
                filters.add(RowFilter.regexFilter("(?i)Gcash", 3));
            } else if (maya.isSelected()) {
                filters.add(RowFilter.regexFilter("(?i)Maya", 3));
            }

            if (fromDate.getDate() != null && toDate.getDate() != null) {
                java.util.Date from = fromDate.getDate();
                java.util.Date to = toDate.getDate();

                filters.add(new RowFilter<Object, Object>() {
                    public boolean include(Entry<?, ?> entry) {
                        try {
                            String dateStr = (String) entry.getValue(0);
                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                            java.util.Date rowDate = sdf.parse(dateStr);
                            return !rowDate.before(from) && !rowDate.after(to);
                        } catch (Exception ex) {
                            return true;
                        }
                    }
                });
            }

            if (filters.isEmpty()) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.andFilter(filters));
            }
        });

        bluePanel1.add(l3);
        bluePanel1.add(l4);
        bluePanel1.add(l6);
        bluePanel1.add(Filter);
        bluePanel1.add(bank);
        bluePanel1.add(Cc);
        bluePanel1.add(Dc);
        bluePanel1.add(gCash);
        bluePanel1.add(maya);
        whitePanel3.add(bluePanel1);
        mainPanel.add(scrollPane);

        mainPanel.add(whitePanel3);
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(button4);
        mainPanel.add(button5);

        t1.add(search);

        whitePanel.add(l1);
        whitePanel.add(l2);
        whitePanel.add(t1);
        whitePanel.add(paymentManagement);

        mainPanel.add(whitePanel);

        this.add(mainPanel);

        setVisible(true);
    }

    // ==========================================
    // DSA SORTING IMPLEMENTATION (Merge Sort)
    // ==========================================
    
    private void dsaMergeSort(DefaultTableModel model, int columnIndex, boolean ascending, boolean isNumeric) {
        int rowCount = model.getRowCount();
        if (rowCount <= 1) return;

        Object[][] data = new Object[rowCount][model.getColumnCount()];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                data[i][j] = model.getValueAt(i, j);
            }
        }

        mergeSortHelper(data, 0, rowCount - 1, columnIndex, ascending, isNumeric);

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                model.setValueAt(data[i][j], i, j);
            }
        }
    }

    private void mergeSortHelper(Object[][] data, int left, int right, int columnIndex, boolean ascending, boolean isNumeric) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSortHelper(data, left, mid, columnIndex, ascending, isNumeric);
            mergeSortHelper(data, mid + 1, right, columnIndex, ascending, isNumeric);

            merge(data, left, mid, right, columnIndex, ascending, isNumeric);
        }
    }

    private void merge(Object[][] data, int left, int mid, int right, int columnIndex, boolean ascending, boolean isNumeric) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Object[][] leftArray = new Object[n1][data[0].length];
        Object[][] rightArray = new Object[n2][data[0].length];

        for (int i = 0; i < n1; i++)
            System.arraycopy(data[left + i], 0, leftArray[i], 0, data[0].length);
        for (int j = 0; j < n2; j++)
            System.arraycopy(data[mid + 1 + j], 0, rightArray[j], 0, data[0].length);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            boolean condition = shouldSwapDSA(leftArray[i][columnIndex], rightArray[j][columnIndex], ascending, isNumeric);
            if (!condition) {
                System.arraycopy(leftArray[i], 0, data[k], 0, data[0].length);
                i++;
            } else {
                System.arraycopy(rightArray[j], 0, data[k], 0, data[0].length);
                j++;
            }
            k++;
        }

        while (i < n1) {
            System.arraycopy(leftArray[i], 0, data[k], 0, data[0].length);
            i++;
            k++;
        }

        while (j < n2) {
            System.arraycopy(rightArray[j], 0, data[k], 0, data[0].length);
            j++;
            k++;
        }
    }

    private boolean shouldSwapDSA(Object o1, Object o2, boolean ascending, boolean isNumeric) {
        if (o1 == null) return true;
        if (o2 == null) return false;

        int comparison = 0;
        if (isNumeric) {
            try {
                double v1 = Double.parseDouble(o1.toString().replaceAll("[^0-9.]", ""));
                double v2 = Double.parseDouble(o2.toString().replaceAll("[^0-9.]", ""));
                comparison = Double.compare(v1, v2);
            } catch (Exception e) {
                comparison = o1.toString().compareTo(o2.toString());
            }
        } else {
            comparison = o1.toString().compareTo(o2.toString());
        }

        return ascending ? (comparison > 0) : (comparison < 0);
    }
}


class PaymentHistory extends VaksJFrame {

    JTable table = new JTable(DataStore.paymentHistoryModel);
    static ApartmentManagement apartmentPage;
    static AdminHome adminHome;
    static TenantManagement tenantManagement;
    static TransactionHistory transactionHistory;

   // JDateChooser fromDate, toDate;

    PaymentHistory() {

        setTitle("Payment History");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

        JLabel l1 = new JLabel("Billing Status");
        l1.setBounds(20, 25, 600, 60);
        l1.setFont(new Font("Dialog", Font.BOLD, 40));
        l1.setForeground(Color.decode("#000000"));

        JLabel l2 = new JLabel("View all billing transactions");
        l2.setBounds(20, 65, 600, 60);
        l2.setFont(new Font("Dialog", Font.PLAIN, 25));
        l2.setForeground(Color.decode("#000000"));

        JTextField t1 = new JTextField(""); // search input field
        t1.setBounds(770, 65, 350, 60);
        t1.setFont(new Font("Dialog", Font.PLAIN, 25));
        t1.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));

        JLabel search = new JLabel("Search...");
        search.setBounds(15, 20, 300, 20);
        search.setFont(new Font("Dialog", Font.BOLD, 20));
        search.setForeground(Color.decode("#003366"));

        JButton paymentManagement = new JButton("Transaction History");
        paymentManagement.setBounds(1170, 65, 300, 60);
        paymentManagement.setBackground(Color.decode("#7492BC"));
        paymentManagement.setForeground(Color.WHITE);
        paymentManagement.setFont(new Font("Dialog", Font.BOLD, 18));

        paymentManagement.addActionListener(e -> { // if user click view details, it go to unit v2

            if (transactionHistory == null) {
                transactionHistory = new TransactionHistory();
            }
            transactionHistory.setVisible(true);
            this.dispose();

        });

        table = new JTable(DataStore.paymentHistoryModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //Locks the table cells so they can't be edited!
            }
        };

        table.setRowHeight(70);
        table.setFont(new Font("Dialog", Font.PLAIN, 20));

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 30));
        header.setBackground(Color.decode("#4682b4"));
        header.setForeground(Color.WHITE);

        // Auto-refresh listener for table model changes
        DataStore.paymentHistoryModel.addTableModelListener(e -> {
            table.revalidate();
            table.repaint();
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(390, 220, 1120, 600);

        // 🔹 Search filter logic
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(DataStore.paymentHistoryModel);
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

        JPanel whitePanel3 = new JPanel();
        whitePanel3.setBackground(Color.decode("#F4F6F9"));
        whitePanel3.setBounds(20, 220, 350, 600);
        whitePanel3.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        whitePanel3.setLayout(null);

        JPanel bluePanel1 = new JPanel();
        bluePanel1.setBackground(Color.decode("#C8D8EF"));
        bluePanel1.setBounds(15, 15, 320, 565);
        bluePanel1.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        bluePanel1.setLayout(null);

        // Filter Headers & Labels
        JLabel l3 = new JLabel("Filters: ");
        l3.setBounds(10, 20, 200, 30);
        l3.setFont(new Font("Dialog", Font.BOLD, 25));
        l3.setForeground(Color.decode("#000000"));

        JLabel l4 = new JLabel("Payment Method ");
        l4.setBounds(10, 40, 200, 90);
        l4.setFont(new Font("Dialog", Font.BOLD, 20));
        l4.setForeground(Color.decode("#000000"));

        JLabel l6 = new JLabel("Amount");
        l6.setBounds(10, 240, 200, 90);
        l6.setFont(new Font("Dialog", Font.BOLD, 20));
        l6.setForeground(Color.decode("#000000"));

        JRadioButton bank = new JRadioButton("Bank Transfer");
        JRadioButton Cc = new JRadioButton("Credit Card");
        JRadioButton Dc = new JRadioButton("Debit Card");
        JRadioButton gCash = new JRadioButton("Gcash");
        JRadioButton maya = new JRadioButton("Maya");

        bank.setBounds(10, 100, 200, 30);
        Cc.setBounds(10, 130, 200, 30);
        Dc.setBounds(10, 160, 200, 30);
        gCash.setBounds(10, 190, 200, 30);
        maya.setBounds(10, 220, 200, 30);

        bank.setFont(new Font("Dialog", Font.PLAIN, 20));
        Cc.setFont(new Font("Dialog", Font.PLAIN, 20));
        Dc.setFont(new Font("Dialog", Font.PLAIN, 20));
        gCash.setFont(new Font("Dialog", Font.PLAIN, 20));
        maya.setFont(new Font("Dialog", Font.PLAIN, 20));

        bank.setBackground(Color.decode("#C8D8EF"));
        Cc.setBackground(Color.decode("#C8D8EF"));
        Dc.setBackground(Color.decode("#C8D8EF"));
        gCash.setBackground(Color.decode("#C8D8EF"));
        maya.setBackground(Color.decode("#C8D8EF"));

        ButtonGroup group = new ButtonGroup();
        group.add(bank);
        group.add(Cc);
        group.add(Dc);
        group.add(gCash);
        group.add(maya);

        JPanel line9 = new JPanel();
        line9.setBounds(17, 278, 317, 2);
        line9.setBackground(Color.decode("#7492BC"));
        whitePanel3.add(line9);

        String[] floors = {"Any", "Low", "Medium", "High"};
        JComboBox<String> floorBox = new JComboBox<>(floors);
        floorBox.setBounds(10, 300, 280, 60);
        floorBox.setFont(new Font("Dialog", Font.PLAIN, 20));
        bluePanel1.add(floorBox);

        JLabel statusLabel = new JLabel("Status");
        statusLabel.setBounds(10, 380, 100, 20);
        statusLabel.setForeground(Color.decode("#000000"));
        statusLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        bluePanel1.add(statusLabel);

        String[] stats = {"All", "Pending", "Paid", "OverDue"};
        JComboBox<String> statsBox = new JComboBox<>(stats);

        statsBox.setBounds(10, 405, 280, 60);
        statsBox.setFont(new Font("Dialog", Font.PLAIN, 20));
        bluePanel1.add(statsBox);

        JButton Filter = new JButton("Apply Filter");
        Filter.setBounds(30, 490, 260, 50);
        Filter.setBackground(Color.decode("#7492BC"));
        Filter.setForeground(Color.WHITE);
        Filter.setFont(new Font("Dialog", Font.BOLD, 18));

    Filter.addActionListener(e -> {
    java.util.List<RowFilter<Object,Object>> filters = new java.util.ArrayList<>();

    // 🔹 Payment Method filter (col 3)
    if (bank.isSelected()) {
        filters.add(RowFilter.regexFilter("(?i)Bank Transfer", 3));
    } else if (Cc.isSelected()) {
        filters.add(RowFilter.regexFilter("(?i)Credit Card", 3));
    } else if (Dc.isSelected()) {
        filters.add(RowFilter.regexFilter("(?i)Debit Card", 3));
    } else if (gCash.isSelected()) {
        filters.add(RowFilter.regexFilter("(?i)Gcash", 3));
    } else if (maya.isSelected()) {
        filters.add(RowFilter.regexFilter("(?i)Maya", 3));
    }

    // 🔹 Amount filter (col 4) → gamit yung floorBox
    String selectedRange = (String) floorBox.getSelectedItem();
    if (!selectedRange.equals("Any")) {
        filters.add(new RowFilter<Object,Object>() {
            public boolean include(Entry<?,?> entry) {
                try {
                    String amountStr = ((String) entry.getValue(4))
                        .replace("₱", "")
                        .replace(",", "")
                        .trim();
                    int amount = Integer.parseInt(amountStr);

                    switch (selectedRange) {
                        case "Low":    return amount <= 7500;
                        case "Medium": return amount > 7500 && amount <= 8500;
                        case "High":   return amount > 8500;
                        default:       return true;
                    }
                } catch (Exception ex) {
                    return true;
                }
            }
        });
    }

    // 🔹 Status filter (col 5)
    String status = (String) statsBox.getSelectedItem();
    if (!status.equals("All")) {
        filters.add(RowFilter.regexFilter("(?i)" + status, 5));
    }

    // ✅ Combine all filters safely
    if (filters.isEmpty()) {
        sorter.setRowFilter(null); // show all if no filter
    } else {
        sorter.setRowFilter(RowFilter.andFilter(filters));
    }
});

        bluePanel1.add(l3);
        bluePanel1.add(l4);
        bluePanel1.add(l6);
        bluePanel1.add(Filter);
        bluePanel1.add(bank);
        bluePanel1.add(Cc);
        bluePanel1.add(Dc);
        bluePanel1.add(gCash);
        bluePanel1.add(maya);
        whitePanel3.add(bluePanel1);

        mainPanel.add(scrollPane);
        mainPanel.add(whitePanel3);
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(button4);
        mainPanel.add(button5);

        t1.add(search);
        whitePanel.add(l1);
        whitePanel.add(l2);
        whitePanel.add(t1);
        whitePanel.add(paymentManagement);

        mainPanel.add(whitePanel);
        this.add(mainPanel);

        setVisible(true);
    }

}
