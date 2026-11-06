package vaksDesign;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class RentAndPayment extends VaksJFrame {
    
    static RentAndPayment rentAndpayment;
    private Payment payment;

    // static TenantHomeDashboard tenantHomeDashboard;
    // private static boolean hasPending = false;
    JTable tabs;

    RentAndPayment() {
        setTitle("Payment");
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#7492BC"));
        mainPanel.setBounds(0, 0, 1542, 850);
        mainPanel.setLayout(null);

        ImageIcon backg = new ImageIcon("picture/collage.jpg");
        int neW1 = 1700;
        int neH1 = 800;
        Image scaled1 = backg.getImage().getScaledInstance(neW1, neH1, Image.SCALE_SMOOTH);
        JLabel backg1 = new JLabel(new ImageIcon(scaled1));
        backg1.setBounds(0, 65, neW1, neH1);
        backg1.setLayout(null);
        mainPanel.add(backg1);

        //////////////////////////////////Navigation Stuff///////////////////////////////////////////////////

        JButton button1 = new JButton("Home");
        button1.setBounds(380, 10, 160, 40);
        button1.setBackground(Color.decode("#7492BC"));
        button1.setBorder(new LineBorder(Color.white, 3));
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Dialog", Font.BOLD, 18));

        button1.addActionListener(e -> {
            new TenantHomeDashboard().setVisible(true);
            this.dispose();
        });

        JButton button2 = new JButton("Payments");
        button2.setBounds(820, 10, 160, 40);
        button2.setBorder(new LineBorder(Color.white, 3));
        button2.setBackground(Color.decode("#7492BC"));
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Dialog", Font.BOLD, 18));

        button2.addActionListener(e -> {
            new RentAndPayment().setVisible(true);
            this.dispose();
        });

        JButton button5 = new JButton("Account");
        button5.setBounds(1300, 10, 160, 40);
        button5.setBorder(new LineBorder(Color.white));
        button5.setBackground(Color.decode("#7492BC"));
        button5.setForeground(Color.WHITE);
        button5.setFont(new Font("Dialog", Font.BOLD, 18));

        button5.addActionListener(e -> {
            new Account().setVisible(true);
            this.dispose();
        });

        ImageIcon icon = new ImageIcon("picture/LEGENDARY.png");
        Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel iconLabel = new JLabel(scaledIcon);
        iconLabel.setBounds(40, 10, 50, 50);
        mainPanel.add(iconLabel);
        mainPanel.repaint();

        JPanel LightB = new JPanel();
        LightB.setBounds(15, 10, 1510, 760);
        LightB.setBackground(Color.decode("#E0EEFF"));
        LightB.setLayout(null);

        JPanel LightB2 = new JPanel();
        LightB2.setBounds(20, 20, 1470, 720);
        LightB2.setBackground(Color.decode("#F0F7FF"));
        LightB2.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        LightB2.setLayout(null);

        // Header Panel
        JPanel white1 = new JPanel();
        white1.setBounds(0, 0, 1470, 100);
        white1.setBackground(Color.white);
        white1.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        white1.setLayout(null);

        JLabel imoji = new JLabel("📄");
        imoji.setFont(new Font("Dialog", Font.BOLD, 100));
        imoji.setBounds(20, 10, 200, 80);

        JLabel title1 = new JLabel("Rent And Payment");
        title1.setFont(new Font("Dialog", Font.BOLD, 40));
        title1.setBounds(120, 5, 1000, 50);

        JLabel title2 = new JLabel("Check your balance and payment history ");
        title2.setFont(new Font("Dialog", Font.PLAIN, 30));
        title2.setBounds(120, 48, 1000, 50);

        white1.add(imoji);
        white1.add(title1);
        white1.add(title2);

        // Current Balance Panel
        JPanel white2 = new JPanel();
        white2.setBounds(43, 120, 1380, 150);
        white2.setBackground(Color.white);
        white2.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        white2.setLayout(null);

        JLabel imoji2 = new JLabel("💵");
        imoji2.setFont(new Font("Dialog", Font.BOLD, 100));
        imoji2.setBounds(40, 30, 200, 80);

        JLabel t3 = new JLabel("Current Balance");
        t3.setFont(new Font("Dialog", Font.PLAIN, 25));
        t3.setBounds(170, 5, 1000, 50);

        double balance = MainExtended.currentUser.getCurrentBalance();
        JLabel t4 = new JLabel("₱ " + String.format("%.2f", balance));
        t4.setFont(new Font("Dialog", Font.BOLD, 50));
        t4.setBounds(170, 50, 1000, 50);

        LocalDate dueDate = getNextDueDate();

        // Reset balance kung lumipas na ang due date at zero pa ang balance
        if (LocalDate.now().isAfter(dueDate) && balance == 0) {
            MainExtended.currentUser.setCurrentBalance(MainExtended.currentUser.getMonthRate());
            balance = MainExtended.currentUser.getMonthRate();
        }

        JLabel t5 = new JLabel("Due on " + dueDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
        t5.setFont(new Font("Dialog", Font.PLAIN, 25));
        t5.setBounds(170, 90, 1000, 50);

        boolean hasAnyRecord = false;

        for (int i = 0; i < DataStore.tenantPaymentHistoryModel.getRowCount(); i++) {

            String rowEmail
                    = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 4);

            if (MainExtended.currentUser.getEmail().equalsIgnoreCase(rowEmail)) {
                hasAnyRecord = true;
                break;
            }
        }

        String date;

        if (!hasAnyRecord) {

            date = getNextDueDate().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
            );

        } else {

            date = getNextDueDate().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
            );
        }

        String unitId = MainExtended.currentUser.getApartmentUnit();
        String currentTenantEmail = MainExtended.currentUser.getEmail();
        double rentAmount = MainExtended.currentUser.getMonthRate();
        String amount = "₱" + String.format("%.2f", rentAmount);

        boolean hasActiveRow = false;

        // 1. Suriin kung may umiiral nang Pending o Overdue row para sa tenant na ito
        for (int i = 0; i < DataStore.tenantPaymentHistoryModel.getRowCount(); i++) {
            String rowEmail = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 4);
            String rowStatus = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 3);

            if (currentTenantEmail.equalsIgnoreCase(rowEmail)
                    && ("Pending".equalsIgnoreCase(rowStatus) || "Overdue".equalsIgnoreCase(rowStatus))) {
                hasActiveRow = true;
                break;
            }
        }

        // 2. Kung WALA pang active row, igawa ng Pending
        if (!hasActiveRow) {
            DataStore.addPayment(date, unitId, currentTenantEmail, "—", amount, "Pending");
        }

        // 3. Check kung Overdue na ang Pending row
        for (int i = 0; i < DataStore.tenantPaymentHistoryModel.getRowCount(); i++) {
            String rowEmail = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 4);
            String rowStatus = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 3);

            if (currentTenantEmail.equalsIgnoreCase(rowEmail) && "Pending".equalsIgnoreCase(rowStatus)) {
                if (LocalDate.now().isAfter(dueDate)) {
                    DataStore.updatePaymentStatus(i, "Overdue");
                }
            }
        }

        JButton goPay = new JButton("Pay Now");
        goPay.setBackground(Color.decode("#7492BC"));
        goPay.setFont(new Font("Dialog", Font.BOLD, 30));
        goPay.setForeground(Color.white);
        goPay.setBounds(1100, 35, 220, 80);

        goPay.addActionListener(ev -> {

            double currentBalance = MainExtended.currentUser.getCurrentBalance();

            boolean isOverdue = false;

            for (int i = 0; i < DataStore.tenantPaymentHistoryModel.getRowCount(); i++) { // main to kapag di gumana isa ito gagamtin

                String rowEmail
                        = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 4);

                String rowStatus
                        = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 3);

                if (MainExtended.currentUser.getEmail().equalsIgnoreCase(rowEmail)
                        && "Overdue".equalsIgnoreCase(rowStatus)) {

                    isOverdue = true;
                    break;
                }
            }

            if (isOverdue) {

                JOptionPane.showMessageDialog(this,
                        "<html><b>⚠️ Your account is currently Overdue.</b><br>"
                        + "Please use the <b>'Pay Overdue'</b> button to settle your balance<br>"
                        + "along with the applicable late penalty.</html>",
                        "Action Restricted",
                        JOptionPane.WARNING_MESSAGE);

            } else if (currentBalance <= 0) {

                DateTimeFormatter formatter
                        = DateTimeFormatter.ofPattern("yyyy-M-d");

                LocalDate latestPaidDate = null;

                for (int i = 0; i < DataStore.tenantPaymentHistoryModel.getRowCount(); i++) {

                    String rowEmail
                            = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 4);

                    String rowStatus
                            = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 3);

                    if (MainExtended.currentUser.getEmail().equalsIgnoreCase(rowEmail)
                            && "Paid".equalsIgnoreCase(rowStatus)) {

                        String paidDate
                                = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 0);

                        LocalDate paidLocalDate
                                = LocalDate.parse(paidDate, formatter);

                        if (latestPaidDate == null
                                || paidLocalDate.isAfter(latestPaidDate)) {

                            latestPaidDate = paidLocalDate;
                        }
                    }
                }
                if (latestPaidDate != null) {

                    String moveInDateStr
                            = MainExtended.currentUser.getMoveInDate();

                    LocalDate moveInDate
                            = LocalDate.parse(
                                    moveInDateStr,
                                    DateTimeFormatter.ofPattern("yyyy-M-d"));

                    int paidCount = 0;

                    for (int i = 0; i < DataStore.tenantPaymentHistoryModel.getRowCount(); i++) {

                        String rowEmail
                                = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 4);

                        String rowStatus
                                = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 3);

                        if (MainExtended.currentUser.getEmail().equalsIgnoreCase(rowEmail)
                                && "Paid".equalsIgnoreCase(rowStatus)) {

                            paidCount++;
                        }
                    }

                    LocalDate coverageStart
                            = moveInDate.plusMonths(paidCount - 1);

                    LocalDate coverageEnd
                            = moveInDate.plusMonths(paidCount);

                    LocalDate nextDueDate
                            = moveInDate.plusMonths(paidCount + 1);

                    String coverageStartStr
                            = coverageStart.format(
                                    DateTimeFormatter.ofPattern("MMMM dd, yyyy"));

                    String coverageEndStr
                            = coverageEnd.format(
                                    DateTimeFormatter.ofPattern("MMMM dd, yyyy"));

                    String nextDueStr
                            = nextDueDate.format(
                                    DateTimeFormatter.ofPattern("MMMM dd, yyyy"));

                    JOptionPane.showMessageDialog(this,
                            "<html><b>✅ You have already paid your rent.</b><br><br>"
                            + "Current Rental Coverage:<br>"
                            + "<b>" + coverageStartStr + " to "
                            + coverageEndStr + "</b><br><br>"
                            + "Next Payment Due Date:<br>"
                            + "<b>" + nextDueStr + "</b><br><br>"
                            + "Please wait until <b>"
                            + coverageEndStr
                            + "</b><br>"
                            + "to pay your next due date."
                            + "</html>",
                            "Payment Info",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            } else {

                if (payment == null) {
                    payment = new Payment();
                }

                payment.setVisible(true);
                this.dispose();
            }
        });

        JPanel lline = new JPanel();
        lline.setBackground(Color.decode("#7492BC"));
        lline.setBounds(1040, 0, 10, 160);

        white2.add(imoji2);
        white2.add(t3);
        white2.add(t4);
        white2.add(t5);
        white2.add(lline);
        white2.add(goPay);

        // Payment History Panel
        JPanel white3 = new JPanel();
        white3.setBounds(43, 290, 1380, 405);
        white3.setBackground(Color.white);
        white3.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        white3.setLayout(null);

        JLabel t6 = new JLabel("Payment History");
        t6.setFont(new Font("Dialog", Font.BOLD, 40));
        t6.setBounds(30, 10, 1000, 50);

        tabs = new JTable(DataStore.tenantPaymentHistoryModel);
        tabs.setFont(new Font("Dialog", Font.PLAIN, 16));
        tabs.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
        tabs.setRowHeight(60);

        // I-disable ang default cell editor para sa lahat ng uri ng data
        tabs.setDefaultEditor(Object.class, null);

        javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> tenantSorter
                = new javax.swing.table.TableRowSorter<>(DataStore.tenantPaymentHistoryModel);
        tabs.setRowSorter(tenantSorter);

        String loggedInEmail = MainExtended.currentUser.getEmail();
        tenantSorter.setRowFilter(javax.swing.RowFilter.regexFilter("^" + loggedInEmail + "$", 4));

        javax.swing.table.JTableHeader header = tabs.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 18));
        header.setBackground(Color.decode("#E0EEFF"));
        header.setPreferredSize(new java.awt.Dimension(header.getWidth(), 60));

        tabs.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabs.getColumnModel().getColumn(1).setPreferredWidth(270);
        tabs.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabs.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabs.getColumnModel().getColumn(4).setPreferredWidth(250);

        JScrollPane scrollPane = new JScrollPane(tabs);
        scrollPane.setBounds(30, 75, 960, 300);

        JButton view1 = new JButton("View Receipt");
        view1.setBackground(Color.decode("#7492BC"));
        view1.setFont(new Font("Dialog", Font.BOLD, 25));
        view1.setForeground(Color.white);
        view1.setBounds(1100, 140, 220, 60);

        view1.addActionListener(ev -> {

            int selectedRow = tabs.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please select a payment record from the table first!",
                        "No Selection",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int modelRow = tabs.convertRowIndexToModel(selectedRow);

            String dueDateString
                    = (String) DataStore.tenantPaymentHistoryModel.getValueAt(modelRow, 0);

            String method
                    = (String) DataStore.tenantPaymentHistoryModel.getValueAt(modelRow, 1);

            String amountStr
                    = (String) DataStore.tenantPaymentHistoryModel.getValueAt(modelRow, 2);

            String status
                    = (String) DataStore.tenantPaymentHistoryModel.getValueAt(modelRow, 3);

            if (!"Paid".equalsIgnoreCase(status)) {

                JOptionPane.showMessageDialog(
                        this,
                        "You can only view receipts for PAID transactions!",
                        "Invalid Status",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            double amountPaid = 0.0;

            try {

                String cleanAmount
                        = amountStr.replace("₱", "")
                                .replace(",", "")
                                .trim();

                amountPaid = Double.parseDouble(cleanAmount);

            } catch (Exception ex) {

                amountPaid
                        = MainExtended.currentUser.getMonthRate();
            }

            String tenantName
                    = MainExtended.currentUser.getFullName();

            if (tenantName == null || tenantName.isEmpty()) {

                tenantName
                        = MainExtended.currentUser.getEmail();
            }

            String tenantId
                    = MainExtended.currentUser.getTenantId();

            String unitNo
                    = MainExtended.currentUser.getApartmentUnit();

            // ✅ Total Balance = binayaran ng tenant
            double totalBalance = amountPaid;

            String rawDate
                    = dueDateString.replace("-", "");

            String receiptNo
                    = "RCP-" + rawDate + "-" + unitNo;

            String transId
                    = "TXN-" + rawDate + "-" + unitNo;

            String actualDueDate = dueDateString;

            try {

                String moveInDateStr
                        = MainExtended.currentUser.getMoveInDate();

                if (moveInDateStr != null
                        && !moveInDateStr.isEmpty()) {

                    DateTimeFormatter formatter
                            = DateTimeFormatter.ofPattern("yyyy-M-d");

                    LocalDate moveInDate
                            = LocalDate.parse(
                                    moveInDateStr.trim(),
                                    formatter);

                    int paymentIndex = 0;

                    LocalDate currentPaymentDate
                            = LocalDate.parse(
                                    dueDateString.trim(),
                                    formatter);

                    for (int i = 0;
                            i < DataStore.tenantPaymentHistoryModel.getRowCount();
                            i++) {

                        String rowEmail
                                = (String) DataStore.tenantPaymentHistoryModel
                                        .getValueAt(i, 4);

                        String rowStatus
                                = (String) DataStore.tenantPaymentHistoryModel
                                        .getValueAt(i, 3);

                        if (loggedInEmail.equalsIgnoreCase(rowEmail)
                                && "Paid".equalsIgnoreCase(rowStatus)) {

                            String rowDateStr
                                    = (String) DataStore.tenantPaymentHistoryModel
                                            .getValueAt(i, 0);

                            LocalDate rowDate
                                    = LocalDate.parse(
                                            rowDateStr.trim(),
                                            formatter);

                            if (rowDate.isBefore(currentPaymentDate)
                                    || (rowDate.isEqual(currentPaymentDate)
                                    && i <= modelRow)) {

                                paymentIndex++;
                            }
                        }
                    }

                    LocalDate calculatedDueDate
                            = moveInDate.plusMonths(paymentIndex);

                    actualDueDate
                            = calculatedDueDate.format(
                                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }

            } catch (Exception ex) {

                actualDueDate = dueDateString;
            }

            // ✅ Actual payment date
            String actualPaymentDate
                    = LocalDate.now().format(
                            DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            ReceiptDialog receipt
                    = new ReceiptDialog(
                            this,
                            receiptNo,
                            transId,
                            tenantName,
                            tenantId,
                            unitNo,
                            "Monthly Rent",
                            totalBalance,
                            method,
                            amountPaid,
                            actualDueDate,
                            actualPaymentDate,
                            status.toUpperCase());

            receipt.setVisible(true);
        });

        JButton view2 = new JButton("Pay Overdue");
        view2.setBackground(Color.decode("#7492BC"));
        view2.setFont(new Font("Dialog", Font.BOLD, 25));
        view2.setForeground(Color.white);
        view2.setBounds(1100, 240, 220, 60);

        view2.addActionListener(e -> {
            double currentBalance = MainExtended.currentUser.getCurrentBalance();

            boolean isOverdue = false;
            for (int i = 0; i < DataStore.tenantPaymentHistoryModel.getRowCount(); i++) {
                String rowEmail = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 4);
                String rowStatus = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 3);

                if (MainExtended.currentUser.getEmail().equalsIgnoreCase(rowEmail) && "Overdue".equalsIgnoreCase(rowStatus)) {
                    isOverdue = true;
                    break;
                }
            }

            if (!isOverdue || currentBalance <= 0) {
                JOptionPane.showMessageDialog(this,
                        "✨ Good job! You have no overdue accounts or penalties to pay. Keep up the good standing!",
                        "Account Status: Clear",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                double penaltyRate = 0.07;
                double penaltyAmount = currentBalance * penaltyRate;
                double totalWithPenalty = currentBalance + penaltyAmount;

                int choice = JOptionPane.showConfirmDialog(this,
                        "⚠️ OVERDUE SETTLEMENT NOTICE:\n\n"
                        + "Base Balance      : ₱" + String.format("%.2f", currentBalance) + "\n"
                        + "Late Penalty (7%) : ₱" + String.format("%.2f", penaltyAmount) + "\n"
                        + "----------------------------------------\n"
                        + "Total Amount Due  : ₱" + String.format("%.2f", totalWithPenalty) + "\n\n"
                        + "Would you like to proceed to payment?",
                        "Overdue Notice",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (choice == JOptionPane.YES_OPTION) {
                    MainExtended.currentUser.setCurrentBalance(totalWithPenalty);

                    if (payment == null) {
                        payment = new Payment();
                    }
                    payment.setVisible(true);
                    this.dispose();
                }
            }
        });

        JPanel line = new JPanel();
        line.setBackground(Color.decode("#7492BC"));
        line.setBounds(1040, 0, 10, 480);

        JPanel line2 = new JPanel();
        line2.setBackground(Color.decode("#7492BC"));
        line2.setBounds(350, 30, 1000, 10);

        white3.add(scrollPane);
        white3.add(t6);
        white3.add(view1);
        white3.add(view2);
        white3.add(line);
        white3.add(line2);

        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button5);

        backg1.add(LightB);
        LightB.add(LightB2);
        LightB2.add(white1);
        LightB2.add(white2);
        LightB2.add(white3);
        this.add(mainPanel);

    }

    
    private LocalDate getNextDueDate() {

        String moveInDateStr = MainExtended.currentUser.getMoveInDate();

        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("yyyy-M-d");

        LocalDate moveInDate
                = LocalDate.parse(moveInDateStr, formatter);

        int paidCount = 0;

        for (int i = 0; i < DataStore.tenantPaymentHistoryModel.getRowCount(); i++) {

            String rowEmail
                    = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 4);

            String rowStatus
                    = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 3);

            if (MainExtended.currentUser.getEmail().equalsIgnoreCase(rowEmail)
                    && "Paid".equalsIgnoreCase(rowStatus)) {

                paidCount++;
            }
        }

        return moveInDate.plusMonths(paidCount + 1);
    }
}

class ReceiptDialog extends JDialog implements Printable {

    public ReceiptDialog(JFrame parent,
            String receiptNo,
            String transId,
            String tenantName,
            String tenantId,
            String unitNo,
            String category,
            double totalBalance,
            String method,
            double amountPaid,
            String dueDate,
            String paymentDate,
            String status) {

        super(parent, "Payment Receipt", true);

        setSize(650, 720);
        setLocationRelativeTo(parent);
        setResizable(false);

        JPanel mainContent = new JPanel(new BorderLayout(15, 15));
        mainContent.setBackground(Color.decode("#C8D8EF"));
        mainContent.setBorder(new EmptyBorder(20, 20, 15, 20));

        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(Color.WHITE);

        cardPanel.setBorder(new CompoundBorder(
                new LineBorder(Color.decode("#7492BC"), 2, true),
                new EmptyBorder(10, 10, 10, 10)
        ));

        double change = amountPaid > totalBalance ? amountPaid - totalBalance : 0.00;

        // Eksaktong text format
        StringBuilder sb = new StringBuilder();
        sb.append("==============================================================\n");
        sb.append("               APARTMENT MANAGEMENT SYSTEM\n");
        sb.append("                   PAYMENT RECEIPT\n");
        sb.append("==============================================================\n\n");

        sb.append(String.format("Receipt No.     : %s\n", receiptNo));
        sb.append(String.format("Transaction ID  : %s\n\n", transId));

        sb.append(String.format("Tenant Name     : %s\n", tenantName));
        sb.append(String.format("Tenant ID       : %s\n", tenantId));
        sb.append(String.format("Unit Number     : %s\n\n", unitNo));

        sb.append("--------------------------------------------------------------\n");
        sb.append("Payment Details\n");
        sb.append("--------------------------------------------------------------\n\n");

        sb.append(String.format("Expense Category: %s\n", category));
        sb.append(String.format("Total Balance   : PHP %,.2f\n", totalBalance));
        sb.append(String.format("Payment Method  : %s\n", method));
        sb.append(String.format("Amount Paid     : PHP %,.2f\n", amountPaid));
        sb.append(String.format("Change          : PHP %,.2f\n", change));
        sb.append(String.format("Due Date        : %s\n", dueDate));
        sb.append(String.format("Payment Date    : %s\n", paymentDate));
        sb.append(String.format("Payment Status  : %s\n\n", status));

        sb.append("--------------------------------------------------------------\n\n");

        sb.append("                Thank you for your payment!\n\n");

        sb.append("==============================================================\n");
        sb.append("               APARTMENT MANAGEMENT SYSTEM\n");
        sb.append("==============================================================\n");

        // JTextArea na may Consolas font
        JTextArea txtReceipt = new JTextArea(sb.toString());
        txtReceipt.setFont(new Font("Consolas", Font.BOLD, 13));
        txtReceipt.setEditable(false);
        txtReceipt.setBackground(Color.WHITE);
        txtReceipt.setForeground(Color.decode("#1E293B"));
        txtReceipt.setCaretPosition(0);

        // Paglagay sa gitna gamit ang GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        cardPanel.add(txtReceipt, gbc);

        mainContent.add(cardPanel, BorderLayout.CENTER);

        // Bottom Action Panel para sa Close Button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        bottomPanel.setOpaque(false);

        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnClose.setPreferredSize(new Dimension(110, 38));
        btnClose.setBackground(Color.decode("#7492BC"));
        btnClose.setForeground(Color.WHITE);
        btnClose.setFocusPainted(false);
        btnClose.setBorderPainted(false);
        btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnClose.setBackground(Color.decode("#5B7A9E"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnClose.setBackground(Color.decode("#7492BC"));
            }
        });

        btnClose.addActionListener(e -> dispose());
        bottomPanel.add(btnClose);

        mainContent.add(bottomPanel, BorderLayout.SOUTH);

        setContentPane(mainContent);
    }
    @Override
    public void printReceiptDetails() {
        System.out.println("Receipt successfully printed.");
    }
}




interface Printable {
    
    void printReceiptDetails();
}
