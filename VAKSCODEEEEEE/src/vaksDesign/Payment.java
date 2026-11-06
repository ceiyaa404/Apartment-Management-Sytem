package vaksDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Payment extends VaksJFrame {

    private RentAndPayment rentAndpayment;
    private PaymentConfirmation paymentConfirmation;
    private JTextField t1;

    public double getPaymentAmount() {
        return Double.parseDouble(t1.getText().trim());
    }

    Payment() {

        setTitle("Payment");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#7492BC"));
        mainPanel.setBounds(0, 0, 1542, 850);
        mainPanel.setLayout(null);

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

        //BACKGROUND TO AH
        ImageIcon bg = new ImageIcon("picture/collage.jpg");
        int newW1 = 1700;
        int newH1 = 800;
        Image scaled1 = bg.getImage().getScaledInstance(newW1, newH1, Image.SCALE_SMOOTH);
        JLabel bg1 = new JLabel(new ImageIcon(scaled1));
        bg1.setBounds(0, 65, newW1, newH1);
        bg1.setLayout(null);
        mainPanel.add(bg1);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.decode("#C8D8EF"));
        bluePanel.setBounds(30, 10, 1495, 740);
        bluePanel.setLayout(null);

        JPanel topWPanel = new JPanel();
        topWPanel.setBackground(Color.decode("#ffffff"));
        topWPanel.setBounds(30, 30, 1435, 680);
        topWPanel.setLayout(null);

        JPanel topBPanel = new JPanel();
        topBPanel.setBackground(Color.decode("#7492BC"));
        topBPanel.setBounds(0, 90, 1435, 590);
        topBPanel.setLayout(null);

        JPanel whitePanel2 = new JPanel();
        whitePanel2.setBackground(Color.decode("#F4F6F9"));
        whitePanel2.setBounds(60, 40, 1315, 480);
        whitePanel2.setLayout(null);

        JLabel l1 = new JLabel("Make payment");
        l1.setBounds(90, 0, 400, 60);
        l1.setFont(new Font("Dialog", Font.BOLD, 50));
        l1.setForeground(Color.decode("#000000"));

        JLabel l2 = new JLabel("Enter the payment details");
        l2.setBounds(90, 40, 400, 60);
        l2.setFont(new Font("Dialog", Font.PLAIN, 25));
        l2.setForeground(Color.decode("#000000"));

        JLabel l3 = new JLabel("📱");
        l3.setBounds(5, 5, 400, 80);
        l3.setFont(new Font("Dialog", Font.BOLD, 80));
        l3.setForeground(Color.decode("#000000"));

        JLabel l4 = new JLabel("Payment Details");
        l4.setBounds(557, 0, 400, 80);
        l4.setFont(new Font("Dialog", Font.BOLD, 30));
        l4.setForeground(Color.decode("#000000"));

        JLabel l5 = new JLabel("Due Date");
        l5.setBounds(70, 40, 400, 80);
        l5.setFont(new Font("Dialog", Font.PLAIN, 25));
        l5.setForeground(Color.decode("#000000"));

        //Gamitin ang helper method para makuha ang tamang active due date (hindi lang basta move-in date)
        LocalDate dueDate = getNextDueDate();

        JLabel R5 = new JLabel(dueDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
        R5.setBounds(1000, 40, 600, 80);
        R5.setFont(new Font("Dialog", Font.PLAIN, 25));
        R5.setForeground(Color.decode("#000000"));

        JLabel l6 = new JLabel("Unit Number");
        l6.setBounds(70, 90, 400, 80);
        l6.setFont(new Font("Dialog", Font.PLAIN, 25));
        l6.setForeground(Color.decode("#000000"));

        // Kunin yung unit number ng current user
        String unitId = MainExtended.currentUser.getApartmentUnit();

        JLabel R6 = new JLabel(unitId);
        R6.setBounds(1000, 90, 600, 80);
        R6.setFont(new Font("Dialog", Font.PLAIN, 25));
        R6.setForeground(Color.decode("#000000"));

        JLabel l7 = new JLabel("Current Balance");
        l7.setBounds(70, 140, 400, 80);
        l7.setFont(new Font("Dialog", Font.PLAIN, 25));
        l7.setForeground(Color.decode("#000000"));

        double balance = MainExtended.currentUser.getCurrentBalance(); //current balance
        JLabel R7 = new JLabel("P " + String.format("%.2f", balance));
        R7.setBounds(1000, 140, 600, 80);
        R7.setFont(new Font("Dialog", Font.PLAIN, 25));
        R7.setForeground(Color.decode("#000000"));

        JLabel l8 = new JLabel("Late Penalty Fee");
        l8.setBounds(70, 190, 400, 80);
        l8.setFont(new Font("Dialog", Font.PLAIN, 25));
        l8.setForeground(Color.decode("#000000"));

        double baseRent = MainExtended.currentUser.getMonthRate();
        double calculatedPenalty = 0.00;
        if (balance > baseRent) {
            calculatedPenalty = balance - baseRent; // Kung may patong na 7%, ito ang magiging penalty value
        }

        JLabel R8 = new JLabel("P " + String.format("%.2f", calculatedPenalty));
        R8.setBounds(1000, 190, 400, 80);
        R8.setFont(new Font("Dialog", Font.PLAIN, 25));
        R8.setForeground(Color.decode("#000000"));

        JLabel l9 = new JLabel("Payment amount");
        l9.setBounds(70, 260, 400, 80);
        l9.setFont(new Font("Dialog", Font.PLAIN, 25));
        l9.setForeground(Color.decode("#000000"));

        t1 = new JTextField();
        t1.setBounds(800, 270, 400, 70);
        t1.setFont(new Font("Dialog", Font.PLAIN, 25));
        t1.setForeground(Color.decode("#000000"));

// PAYMENT AMOUNT (dapat tumugma sa kasalukuyang total balance kasama ang penalty)
        t1.getDocument().addDocumentListener(new DocumentListener() {
            private void validatePayment() {
                String input = t1.getText().trim();

                if (input.isEmpty()) {
                    t1.setBorder(new LineBorder(Color.GRAY, 2));
                    return;
                }
                String numberRegex = "^[0-9]+(\\.[0-9]{1,2})?|^[0-9]+$"; // Tumatanggap ng whole numbers o may decimal

                double targetBalance = MainExtended.currentUser.getCurrentBalance(); // Kunin ang buong balanse (may penalty man o wala)

                // 🔹 Check kung valid numbers ang input
                if (!input.matches(numberRegex)) {
                    t1.setBorder(new LineBorder(Color.RED, 2));
                    return;
                }

                try {
                    double payment = Double.parseDouble(input);
                    if (payment == targetBalance) {
                        t1.setBorder(new LineBorder(Color.GREEN, 2)); // ✅ Eksaktong tumugma sa babayaran
                    } else {
                        t1.setBorder(new LineBorder(Color.RED, 2));   // ❌ Sobra o kulang
                    }
                } catch (NumberFormatException ex) {
                    t1.setBorder(new LineBorder(Color.RED, 2));        // ❌ Invalid parse
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validatePayment();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validatePayment();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validatePayment();
            }
        });

        JLabel l10 = new JLabel("Payment Method");
        l10.setBounds(70, 360, 500, 80);
        l10.setFont(new Font("Dialog", Font.PLAIN, 25));
        l10.setForeground(Color.decode("#000000"));

        JButton B1 = new JButton("✖ Cancel");
        B1.setBounds(800, 530, 240, 40);
        B1.setFont(new Font("Dialog", Font.PLAIN, 25));
        B1.setForeground(Color.decode("#DC143C"));
        B1.setBackground(Color.decode("#C8D8EF"));

        B1.addActionListener(e -> {
            if (rentAndpayment == null) {
                rentAndpayment = new RentAndPayment();
            }
            rentAndpayment.setVisible(true);

            this.dispose();

        });

        JButton B2 = new JButton("➡ Proceed to Pay");
        B2.setBounds(1090, 530, 240, 40);
        B2.setFont(new Font("Dialog", Font.PLAIN, 25));
        B2.setForeground(Color.decode("#3CB371"));
        B2.setBackground(Color.decode("#C8D8EF"));

        B2.addActionListener(e -> {

            String input = t1.getText().trim();

            // Empty field
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a payment amount.",
                        "Payment Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Check if number
            try {
                double paymentAmount = Double.parseDouble(input);

                double targetBalance = MainExtended.currentUser.getCurrentBalance();

                // Negative or zero payment
                if (paymentAmount <= 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Payment amount must be greater than zero.",
                            "Payment Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                // Must exactly match balance
                if (paymentAmount != targetBalance) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Payment amount must exactly match your balance of ₱"
                            + String.format("%.2f", targetBalance),
                            "Invalid Amount",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                paymentConfirmation = new PaymentConfirmation(paymentAmount);
                paymentConfirmation.setVisible(true);
                this.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter numbers only.",
                        "Payment Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        JComboBox<String> paymentOptions = new JComboBox<>(DataStore.paymentComboModel);
        paymentOptions.setFont(new Font("Dialog", Font.PLAIN, 23));
        paymentOptions.setBounds(800, 370, 400, 70);  // adjust position

        mainPanel.add(button1);
        mainPanel.add(button2);

        mainPanel.add(button5);
        mainPanel.add(bg1);
        bg1.add(bluePanel);
        bluePanel.add(topWPanel);
        topWPanel.add(topBPanel);
        topBPanel.add(whitePanel2);
        topWPanel.add(l1);
        topWPanel.add(l2);
        topWPanel.add(l3);
        whitePanel2.add(l4);
        whitePanel2.add(l5);
        whitePanel2.add(l6);
        whitePanel2.add(l7);
        whitePanel2.add(l8);
        whitePanel2.add(l9);
        whitePanel2.add(l10);
        whitePanel2.add(t1);
        whitePanel2.add(R5);
        whitePanel2.add(R6);
        whitePanel2.add(R7);
        whitePanel2.add(R8);
        topBPanel.add(B1);
        topBPanel.add(B2);

        whitePanel2.add(paymentOptions);

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

class PaymentConfirmation extends VaksJFrame {

    private Payment payment;

    PaymentConfirmation(double paymentAmount) {

        setTitle("Payment Confirmation");
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#7492BC"));
        mainPanel.setBounds(0, 0, 1542, 850);
        mainPanel.setLayout(null);

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

        //BACKGROUND TO AH
        ImageIcon bg = new ImageIcon("picture/collage.jpg");
        int newW1 = 1700;
        int newH1 = 800;
        Image scaled1 = bg.getImage().getScaledInstance(newW1, newH1, Image.SCALE_SMOOTH);
        JLabel bg1 = new JLabel(new ImageIcon(scaled1));
        bg1.setBounds(0, 65, newW1, newH1);
        bg1.setLayout(null);
        mainPanel.add(bg1);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.decode("#C8D8EF"));
        bluePanel.setBounds(30, 10, 1495, 740);
        bluePanel.setLayout(null);

        JPanel topWPanel = new JPanel();
        topWPanel.setBackground(Color.decode("#ffffff"));
        topWPanel.setBounds(30, 30, 1435, 680);
        topWPanel.setLayout(null);

        JPanel topBPanel = new JPanel();
        topBPanel.setBackground(Color.decode("#7492BC"));
        topBPanel.setBounds(0, 90, 1435, 590);
        topBPanel.setLayout(null);

        JPanel whitePanel2 = new JPanel();
        whitePanel2.setBackground(Color.decode("#F4F6F9"));
        whitePanel2.setBounds(60, 20, 1315, 510);
        whitePanel2.setLayout(null);
        //===================stuff i add  
        JLabel titleP = new JLabel("Payment Confirmation");
        titleP.setFont(new Font("Dialog", Font.BOLD, 30));
        titleP.setBounds(130, 15, 500, 30);
        topWPanel.add(titleP);

        JLabel titleP2 = new JLabel("Please review your details before proceeding!");
        titleP2.setFont(new Font("Dialog", Font.PLAIN, 24));
        titleP2.setBounds(130, 55, 500, 30);
        topWPanel.add(titleP2);

        JLabel ICon = new JLabel("📄");
        ICon.setFont(new Font("Dialog", Font.PLAIN, 80));
        ICon.setBounds(20, 6, 500, 80);
        topWPanel.add(ICon);

        JLabel samari = new JLabel("Payment Summary");
        samari.setFont(new Font("Dialog", Font.BOLD, 30));
        samari.setBounds(490, 5, 500, 40);
        whitePanel2.add(samari);

        JPanel line0 = new JPanel();
        line0.setBackground(Color.decode("#7492BC"));
        line0.setBounds(10, 50, 1285, 2);
        whitePanel2.add(line0);

        JLabel dueD = new JLabel("Due Date");
        dueD.setFont(new Font("Dialog", Font.PLAIN, 26));
        dueD.setBounds(50, 70, 500, 30);
        whitePanel2.add(dueD);

        JPanel line1 = new JPanel();
        line1.setBackground(Color.decode("#7492BC"));
        line1.setBounds(10, 130, 1285, 2);
        whitePanel2.add(line1);

        LocalDate dueDate = getNextDueDate();

        JLabel dueD1 = new JLabel(dueDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
        dueD1.setFont(new Font("Dialog", Font.PLAIN, 26));
        dueD1.setBounds(1010, 70, 500, 30);
        whitePanel2.add(dueD1);

        ///////////////////////////////////////////////////////////////
        
        
        JLabel UN = new JLabel("Unit Number");
        UN.setFont(new Font("Dialog", Font.PLAIN, 26));
        UN.setBounds(50, 160, 500, 30);
        whitePanel2.add(UN);

        JPanel line2 = new JPanel();
        line2.setBackground(Color.decode("#7492BC"));
        line2.setBounds(10, 220, 1285, 2);
        whitePanel2.add(line2);

        // Kunin yung unit number ng current user
        String unitId = MainExtended.currentUser.getApartmentUnit();

        JLabel UN1 = new JLabel(unitId);
        UN1.setFont(new Font("Dialog", Font.PLAIN, 26));
        UN1.setBounds(1010, 160, 500, 30);
        whitePanel2.add(UN1);
        /////////////////////////////////////////////////////////
        
        JLabel TB = new JLabel("Total Balance");
        TB.setFont(new Font("Dialog", Font.PLAIN, 26));
        TB.setBounds(50, 250, 500, 30);
        whitePanel2.add(TB);

        JPanel line3 = new JPanel();
        line3.setBackground(Color.decode("#7492BC"));
        line3.setBounds(10, 310, 1285, 2);
        whitePanel2.add(line3);

        double balance = MainExtended.currentUser.getCurrentBalance();
        JLabel UN2 = new JLabel("₱ " + String.format("%.2f", balance));
        UN2.setFont(new Font("Dialog", Font.PLAIN, 26));
        UN2.setBounds(1010, 250, 500, 30);
        whitePanel2.add(UN2);
        ////////////////////////////////////////
        
       
        JLabel PayA = new JLabel("Payment Amount");
        PayA.setFont(new Font("Dialog", Font.PLAIN, 26));
        PayA.setBounds(50, 340, 500, 30);
        whitePanel2.add(PayA);

        JPanel line4 = new JPanel();
        line4.setBackground(Color.decode("#7492BC"));
        line4.setBounds(10, 400, 1285, 2);
        whitePanel2.add(line4);

        String paymentText = "₱" + String.format("%.2f", paymentAmount);
        JLabel UN3 = new JLabel(paymentText);
        UN3.setFont(new Font("Dialog", Font.PLAIN, 26));
        UN3.setBounds(1010, 340, 500, 30);
        whitePanel2.add(UN3);
        ////////////////////////////////////////////
       
        JLabel PayM = new JLabel("Payment Method");
        PayM.setFont(new Font("Dialog", Font.PLAIN, 26));
        PayM.setBounds(50, 430, 500, 30);
        whitePanel2.add(PayM);

        JPanel line5 = new JPanel();
        line5.setBackground(Color.decode("#7492BC"));
        line5.setBounds(10, 490, 1285, 2);
        whitePanel2.add(line5);

        JComboBox<String> paymentBox = new JComboBox<>(DataStore.paymentComboModel);
        paymentBox.setFont(new Font("Dialog", Font.PLAIN, 23));
        paymentBox.setBounds(1010, 430, 200, 30);  // adjust position
        paymentBox.setEnabled(false);
        whitePanel2.add(paymentBox);

        JButton COFNIRM = new JButton("Confirm ✔️");
        COFNIRM.setFont(new Font("Dialog", Font.BOLD, 15));
        COFNIRM.setForeground(Color.decode("#3CB371"));
        COFNIRM.setBounds(1177, 535, 200, 50);
        topBPanel.add(COFNIRM);

        COFNIRM.addActionListener(e -> {

            String selectedMethod = (String) paymentBox.getSelectedItem();

            // Kunin ang calculated due date gamit ang helper method sa PaymentConfirmation
            LocalDate confirmedDueDate = getNextDueDate();
            String dueDateStrForReceipt = confirmedDueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-d"));

            // Ipasa pareho ang paymentAmount at ang dueDateStr papuntang PaymentSummary
            new PaymentSummary(paymentAmount, dueDateStrForReceipt).setVisible(true);

            this.dispose();
        });

        JButton CACNEL = new JButton("Cancel ❌");
        CACNEL.setFont(new Font("Dialog", Font.BOLD, 15));
        CACNEL.setForeground(Color.decode("#DC143C"));
        CACNEL.setBounds(940, 535, 200, 50);
        topBPanel.add(CACNEL);

        CACNEL.addActionListener(e -> {
            if (payment == null) {
                payment = new Payment();
            }
            //payment.setCustomerName(MainExtended.currentUser.getEmail());
            payment.setVisible(true);

            this.dispose();

        });

//==================where it end=============  
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button5);
        mainPanel.add(bg1);
        bg1.add(bluePanel);
        bluePanel.add(topWPanel);
        topWPanel.add(topBPanel);
        topBPanel.add(whitePanel2);

        this.add(mainPanel);

        setVisible(true);

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

class PaymentSummary extends VaksJFrame {

    PaymentSummary(double paymentAmount, String dueDateStr) {
        setTitle("Payment Summary");
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#7492BC"));
        mainPanel.setBounds(0, 0, 1542, 850);
        mainPanel.setLayout(null);

        ImageIcon icon = new ImageIcon("picture/LEGENDARY.png");
        Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel iconLabel = new JLabel(scaledIcon);
        iconLabel.setBounds(40, 10, 50, 50);
        mainPanel.add(iconLabel);
        mainPanel.repaint();

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

        // BACKGROUND
        ImageIcon bg = new ImageIcon("picture/collage.jpg");
        int newW1 = 1700;
        int newH1 = 800;
        Image scaled1 = bg.getImage().getScaledInstance(newW1, newH1, Image.SCALE_SMOOTH);
        JLabel bg1 = new JLabel(new ImageIcon(scaled1));
        bg1.setBounds(0, 65, newW1, newH1);
        bg1.setLayout(null);
        mainPanel.add(bg1);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.decode("#C8D8EF"));
        bluePanel.setBounds(30, 10, 1495, 740);
        bluePanel.setLayout(null);

        JPanel topWPanel = new JPanel();
        topWPanel.setBackground(Color.decode("#ffffff"));
        topWPanel.setBounds(30, 30, 1435, 680);
        topWPanel.setLayout(null);

        JPanel topBPanel = new JPanel();
        topBPanel.setBackground(Color.decode("#7492BC"));
        topBPanel.setBounds(0, 90, 1435, 590);
        topBPanel.setLayout(null);

        JPanel whitePanel2 = new JPanel();
        whitePanel2.setBackground(Color.decode("#F4F6F9"));
        whitePanel2.setBounds(60, 10, 1315, 520);
        whitePanel2.setLayout(null);

        // Header Stuff
        JLabel titleP = new JLabel("Receipt");
        titleP.setFont(new Font("Dialog", Font.BOLD, 30));
        titleP.setBounds(130, 15, 500, 30);
        topWPanel.add(titleP);

        JLabel titleP2 = new JLabel("Processed!");
        titleP2.setFont(new Font("Dialog", Font.PLAIN, 24));
        titleP2.setBounds(130, 55, 500, 30);
        topWPanel.add(titleP2);

        JLabel ICon = new JLabel("✅");
        ICon.setForeground(Color.green);
        ICon.setFont(new Font("Dialog", Font.PLAIN, 80));
        ICon.setBounds(20, 6, 500, 80);
        topWPanel.add(ICon);

        JLabel samari = new JLabel("Receipt Information");
        samari.setFont(new Font("Dialog", Font.BOLD, 30));
        samari.setBounds(490, 5, 500, 40);
        whitePanel2.add(samari);

        JPanel line0 = new JPanel();
        line0.setBackground(Color.decode("#7492BC"));
        line0.setBounds(10, 50, 1285, 2);
        whitePanel2.add(line0);

        JLabel receiptsLabel = new JLabel("Receipt No.");
        receiptsLabel.setFont(new Font("Dialog", Font.PLAIN, 26));
        receiptsLabel.setBounds(50, 70, 500, 30);
        whitePanel2.add(receiptsLabel);

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String unitId = MainExtended.currentUser.getApartmentUnit();
        String receiptCode = "RCP-" + today + "-" + unitId;

        JLabel receiptsVal = new JLabel(receiptCode);
        receiptsVal.setFont(new Font("Dialog", Font.PLAIN, 26));
        receiptsVal.setBounds(1010, 70, 500, 30);
        whitePanel2.add(receiptsVal);

        JPanel line6 = new JPanel();
        line6.setBackground(Color.decode("#7492BC"));
        line6.setBounds(10, 120, 1285, 2);
        whitePanel2.add(line6);

        JLabel dueD = new JLabel("Due Date");
        dueD.setFont(new Font("Dialog", Font.PLAIN, 26));
        dueD.setBounds(50, 140, 500, 30);
        whitePanel2.add(dueD);

        LocalDate targetDueDate = LocalDate.now();
        // String currentTenantEmailCheck = MainExtended.currentUser.getEmail();
        //  DateTimeFormatter flexibleFormatter = DateTimeFormatter.ofPattern("yyyy-M-d");

        try {
            targetDueDate = LocalDate.parse(dueDateStr, DateTimeFormatter.ofPattern("yyyy-M-d"));
        } catch (Exception e) {
            targetDueDate = LocalDate.now();
        }

        String displayDueDateFormatted = targetDueDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));

        JLabel dueD1 = new JLabel(displayDueDateFormatted);
        dueD1.setFont(new Font("Dialog", Font.PLAIN, 26));
        dueD1.setBounds(1010, 140, 500, 30);
        whitePanel2.add(dueD1);

        JPanel line1 = new JPanel();
        line1.setBackground(Color.decode("#7492BC"));
        line1.setBounds(10, 190, 1285, 2);
        whitePanel2.add(line1);

        JLabel UN = new JLabel("Unit Number");
        UN.setFont(new Font("Dialog", Font.PLAIN, 26));
        UN.setBounds(50, 210, 500, 30);
        whitePanel2.add(UN);

        JLabel UN1 = new JLabel(unitId);
        UN1.setFont(new Font("Dialog", Font.PLAIN, 26));
        UN1.setBounds(1010, 210, 500, 30);
        whitePanel2.add(UN1);

        JPanel line2 = new JPanel();
        line2.setBackground(Color.decode("#7492BC"));
        line2.setBounds(10, 260, 1285, 2);
        whitePanel2.add(line2);

        JLabel TB = new JLabel("Total Balance");
        TB.setFont(new Font("Dialog", Font.PLAIN, 26));
        TB.setBounds(50, 280, 500, 30);
        whitePanel2.add(TB);

        double balance = MainExtended.currentUser.getCurrentBalance();
        JLabel UN2 = new JLabel("₱ " + String.format("%.2f", balance));
        UN2.setFont(new Font("Dialog", Font.PLAIN, 26));
        UN2.setBounds(1010, 280, 500, 30);
        whitePanel2.add(UN2);

        JPanel line3 = new JPanel();
        line3.setBackground(Color.decode("#7492BC"));
        line3.setBounds(10, 330, 1285, 2);
        whitePanel2.add(line3);

        JLabel PayA = new JLabel("Payment Amount");
        PayA.setFont(new Font("Dialog", Font.PLAIN, 26));
        PayA.setBounds(50, 350, 500, 30);
        whitePanel2.add(PayA);

        String paymentText = "₱" + String.format("%.2f", paymentAmount);
        JLabel UN3 = new JLabel(paymentText);
        UN3.setFont(new Font("Dialog", Font.PLAIN, 26));
        UN3.setBounds(1010, 350, 500, 30);
        whitePanel2.add(UN3);

        JPanel line4 = new JPanel();
        line4.setBackground(Color.decode("#7492BC"));
        line4.setBounds(10, 400, 1285, 2);
        whitePanel2.add(line4);

        JLabel PayM = new JLabel("Payment Method");
        PayM.setFont(new Font("Dialog", Font.PLAIN, 26));
        PayM.setBounds(50, 420, 500, 30);
        whitePanel2.add(PayM);

        String selectedMethod = (String) DataStore.paymentComboModel.getSelectedItem();
        JLabel UN4 = new JLabel(selectedMethod != null ? selectedMethod : "GCash");
        UN4.setFont(new Font("Dialog", Font.PLAIN, 26));
        UN4.setBounds(1010, 420, 500, 30);
        whitePanel2.add(UN4);

        JPanel line5 = new JPanel();
        line5.setBackground(Color.decode("#7492BC"));
        line5.setBounds(10, 470, 1285, 2);

        whitePanel2.add(line5);

        // para Hanapin muna kung ano ang binayaran (Overdue ba o Pending)
        String currentTenantEmail = MainExtended.currentUser.getEmail();
        String paidAmount = "₱" + String.format("%.2f", paymentAmount);
        int targetRow = -1;
        boolean isPayingOverdue = false;

        // Suriin kung may Overdue row pa
        for (int i = 0; i < DataStore.tenantPaymentHistoryModel.getRowCount(); i++) {
            String rowEmail = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 4);
            String rowStatus = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 3);

            if (currentTenantEmail.equalsIgnoreCase(rowEmail) && "Overdue".equalsIgnoreCase(rowStatus)) {
                targetRow = i;
                isPayingOverdue = true;
                break;
            }
        }

        // Kung walang Overdue, ibig sabihin Pending na ang binayaran
        if (targetRow == -1) {
            for (int i = 0; i < DataStore.tenantPaymentHistoryModel.getRowCount(); i++) {
                String rowEmail = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 4);
                String rowStatus = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 3);

                if (currentTenantEmail.equalsIgnoreCase(rowEmail) && "Pending".equalsIgnoreCase(rowStatus)) {
                    targetRow = i;
                    isPayingOverdue = false;
                    break;
                }
            }
        }

        // I-update ang nahanap na row patungong "Paid"
        if (targetRow >= 0) {
            DataStore.updatePaymentMethod(targetRow, selectedMethod);
            DataStore.updatePaymentAmount(targetRow, paidAmount);
            DataStore.updatePaymentStatus(targetRow, "Paid");
        }

        double baseRent = MainExtended.currentUser.getMonthRate();

        if (isPayingOverdue) {
            MainExtended.currentUser.setCurrentBalance(baseRent);

            boolean hasPending = false;
            for (int i = 0; i < DataStore.tenantPaymentHistoryModel.getRowCount(); i++) {
                String rowEmail = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 4);
                String rowStatus = (String) DataStore.tenantPaymentHistoryModel.getValueAt(i, 3);
                if (currentTenantEmail.equalsIgnoreCase(rowEmail) && "Pending".equalsIgnoreCase(rowStatus)) {
                    hasPending = true;
                    break;
                }
            }

            if (!hasPending) {

                LocalDate nextDueDate = getNextDueDate();

                String rentAmountStr
                        = "₱" + String.format("%.2f", baseRent);

                DataStore.addPayment(
                        nextDueDate.format(
                                DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        unitId,
                        currentTenantEmail,
                        "—",
                        rentAmountStr,
                        "Pending");
            }

        } else {
            LocalDate nextDueDate;
            if (targetRow >= 0 && targetRow < DataStore.tenantPaymentHistoryModel.getRowCount()) {
                String lastPaidDateStr = (String) DataStore.tenantPaymentHistoryModel.getValueAt(targetRow, 0);
                try {
                    LocalDate lastPaidDate = LocalDate.parse(lastPaidDateStr, DateTimeFormatter.ofPattern("yyyy-M-d"));
                    nextDueDate = lastPaidDate.plusMonths(1);
                } catch (Exception ex) {
                    nextDueDate = LocalDate.now().plusMonths(1);
                }
            } else {
                nextDueDate = LocalDate.now().plusMonths(1);
            }

            String nextDate = nextDueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String nextAmount = "₱" + String.format("%.2f", baseRent);

            DataStore.addPayment(nextDate, unitId, currentTenantEmail, "—", nextAmount, "Pending");

            MainExtended.currentUser.setCurrentBalance(0);
        }

        RentAndPayment.rentAndpayment = null;

        JButton backD = new JButton("<- Back to dashboard");
        backD.setFont(new Font("Dialog", Font.BOLD, 15));
        backD.setForeground(Color.decode("#7492BC"));
        backD.setBounds(1177, 535, 200, 45);
        topBPanel.add(backD);

        backD.addActionListener(e -> {
            new TenantHomeDashboard().setVisible(true);
            this.dispose();
        });

        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button5);
        mainPanel.add(bg1);
        bg1.add(bluePanel);
        bluePanel.add(topWPanel);
        topWPanel.add(topBPanel);
        topBPanel.add(whitePanel2);

        this.add(mainPanel);
        setVisible(true);
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
