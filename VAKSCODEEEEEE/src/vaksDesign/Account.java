package vaksDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Account extends VaksJFrame {

    private UserDataBP current;

    Account() {

        setTitle("Tenant Account");
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

        ImageIcon bg = new ImageIcon("picture/collage.jpg");
        int newW1 = 1700;
        int newH1 = 800;
        Image scaled1 = bg.getImage().getScaledInstance(newW1, newH1, Image.SCALE_SMOOTH);
        JLabel bg1 = new JLabel(new ImageIcon(scaled1));
        bg1.setBounds(0, 65, newW1, newH1);
        bg1.setLayout(null);

        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.decode("#F4F6F9"));
        whitePanel.setBounds(40, 10, 1455, 730);
        whitePanel.setBorder(new LineBorder(Color.decode("#C8D8EF"), 7, true));
        whitePanel.setLayout(null);

        JPanel mainPanel2 = new JPanel();
        mainPanel2.setBackground(Color.decode("#C8D8EF"));
        mainPanel2.setBounds(0, 0, 1510, 100);
        mainPanel2.setLayout(null);

        JLabel l1 = new JLabel("👤 User Profile: ");
        l1.setBounds(20, 20, 400, 60);
        l1.setFont(new Font("Dialog", Font.BOLD, 50));
        l1.setForeground(Color.decode("#7492BC"));

        JPanel Fbox = new JPanel();
        Fbox.setBackground(Color.decode("#F4F6F9"));
        Fbox.setBounds(30, 130, 670, 450);
        Fbox.setBorder(new LineBorder(Color.decode("#7492BC"), 5, true));
        Fbox.setLayout(null);

        JPanel FboxD = new JPanel();
        FboxD.setBackground(Color.decode("#C8D8EF"));
        FboxD.setBounds(0, 0, 670, 50);
        FboxD.setBorder(new LineBorder(Color.decode("#7492BC"), 5, true));
        FboxD.setLayout(null);

        JPanel Sbox = new JPanel();
        Sbox.setBackground(Color.decode("#F4F6F9"));
        Sbox.setBounds(760, 130, 670, 450);
        Sbox.setBorder(new LineBorder(Color.decode("#7492BC"), 5, true));
        Sbox.setLayout(null);

        JPanel SboxD = new JPanel();
        SboxD.setBackground(Color.decode("#C8D8EF"));
        SboxD.setBounds(0, 0, 670, 50);
        SboxD.setBorder(new LineBorder(Color.decode("#7492BC"), 5, true));
        SboxD.setLayout(null);

        JPanel Dbox = new JPanel();
        Dbox.setBackground(Color.decode("#F4F6F9"));
        Dbox.setBounds(30, 600, 1400, 100);
        Dbox.setBorder(new LineBorder(Color.decode("#7492BC"), 5, true));
        Dbox.setLayout(null);

        JLabel l2 = new JLabel("Personal Information: ");
        l2.setBounds(20, 0, 300, 50);
        l2.setFont(new Font("Dialog", Font.BOLD, 25));
        l2.setForeground(Color.decode("#7492BC"));

        JLabel l3 = new JLabel("Occupancy Details: ");
        l3.setBounds(20, 0, 300, 50);
        l3.setFont(new Font("Dialog", Font.BOLD, 25));
        l3.setForeground(Color.decode("#7492BC"));

        // Labels inside Fbox (Personal Information)
        JLabel l4 = new JLabel("Full Name:");
        l4.setBounds(40, 75, 200, 40);
        l4.setFont(new Font("Dialog", Font.BOLD, 25));
        l4.setForeground(Color.decode("#7492BC"));

        JLabel l5 = new JLabel("Sex:");
        l5.setBounds(40, 150, 200, 40);
        l5.setFont(new Font("Dialog", Font.BOLD, 25));
        l5.setForeground(Color.decode("#7492BC"));

        JLabel l6 = new JLabel("Tenant ID:");
        l6.setBounds(40, 225, 200, 40);
        l6.setFont(new Font("Dialog", Font.BOLD, 25));
        l6.setForeground(Color.decode("#7492BC"));

        JLabel l7 = new JLabel("Email:");
        l7.setBounds(40, 300, 300, 40);
        l7.setFont(new Font("Dialog", Font.BOLD, 25));
        l7.setForeground(Color.decode("#7492BC"));

        JLabel l8 = new JLabel("Contact Number:");
        l8.setBounds(40, 375, 300, 40);
        l8.setFont(new Font("Dialog", Font.BOLD, 25));
        l8.setForeground(Color.decode("#7492BC"));

        JLabel r1 = new JLabel("Apartment Unit:");
        r1.setBounds(50, 65, 500, 40);
        r1.setFont(new Font("Dialog", Font.BOLD, 25));
        r1.setForeground(Color.decode("#7492BC"));

        JLabel r2 = new JLabel("Unit Type:");
        r2.setBounds(50, 130, 500, 40);
        r2.setFont(new Font("Dialog", Font.BOLD, 25));
        r2.setForeground(Color.decode("#7492BC"));

        JLabel r3 = new JLabel("Monthly Rent:");
        r3.setBounds(50, 195, 500, 40);
        r3.setFont(new Font("Dialog", Font.BOLD, 25));
        r3.setForeground(Color.decode("#7492BC"));

        JLabel r4 = new JLabel("Address:");
        r4.setBounds(50, 260, 500, 40);
        r4.setFont(new Font("Dialog", Font.BOLD, 25));
        r4.setForeground(Color.decode("#7492BC"));

        JLabel r5 = new JLabel("Move-in date:");
        r5.setBounds(50, 325, 500, 40);
        r5.setFont(new Font("Dialog", Font.BOLD, 25));
        r5.setForeground(Color.decode("#7492BC"));

        JLabel r6 = new JLabel("Lease end date:");
        r6.setBounds(50, 385, 500, 40);
        r6.setFont(new Font("Dialog", Font.BOLD, 25));
        r6.setForeground(Color.decode("#7492BC"));

        JTextField t1 = new JTextField();
        t1.setBounds(270, 75, 325, 40);
        t1.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        t1.setEditable(false);

        JTextField t2 = new JTextField();
        t2.setBounds(270, 150, 325, 40);
        t2.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        t2.setEditable(false);

        JTextField t3 = new JTextField();
        t3.setBounds(270, 225, 325, 40);
        t3.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        t3.setEditable(false);

        JTextField t4 = new JTextField();
        t4.setBounds(270, 300, 325, 40);
        t4.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        t4.setEditable(false);

        JTextField t5 = new JTextField();
        t5.setBounds(270, 375, 325, 40);
        t5.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
        t5.setEditable(false);

        JButton b1 = new JButton(" 👤 Edit Profile");
        b1.setBounds(200, 23, 200, 50);
        b1.setFont(new Font("Dialog", Font.BOLD, 20));
        b1.setBackground(Color.decode("#C8D8EF"));
        b1.setForeground(Color.decode("#2A3C52"));
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        // b1.setVisible(false);

        b1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b1.setBorderPainted(true);
                b1.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
            }

            public void mouseExited(MouseEvent e) {
                b1.setBorderPainted(false);
            }
        });

        JButton b2 = new JButton(" ✎ Change Password");
        b2.setBounds(550, 23, 300, 50);
        b2.setFont(new Font("Dialog", Font.BOLD, 20));
        b2.setBackground(Color.decode("#C8D8EF"));
        b2.setForeground(Color.decode("#2A3C52"));
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        //  b2.setVisible(false);

        b2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b2.setBorderPainted(true);
                b2.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
            }

            public void mouseExited(MouseEvent e) {
                b2.setBorderPainted(false);
            }
        });
        //dito na yung action listener para mag-open ng ChangePassUI
        b2.addActionListener(e -> {
            ChangePassUI changePass = new ChangePassUI();
            changePass.setVisible(true);

        });

        JButton b3 = new JButton(" ↪️ Log out");
        b3.setBounds(1000, 23, 200, 50);

        b3.setFont(new Font("Dialog", Font.BOLD, 20));
        b3.setBackground(Color.decode("#C8D8EF"));
        b3.setForeground(Color.decode("#8F1313"));
        b3.setBorderPainted(false);
        b3.setFocusPainted(false);

        b3.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b3.setBorderPainted(true);
                b3.setBorder(BorderFactory.createLineBorder(Color.decode("#8F1313"), 2));
            }

            public void mouseExited(MouseEvent e) {
                b3.setBorderPainted(false);
            }
        });

        JButton b4 = new JButton("Save ✅");
        b4.setBounds(200, 23, 400, 50);
        b4.setFont(new Font("Dialog", Font.BOLD, 20));
        b4.setBackground(Color.decode("#C8D8EF"));
        b4.setForeground(Color.decode("#32cd32"));
        b4.setBorderPainted(false);
        b4.setFocusPainted(false);
        b4.setVisible(false); // Save

        JButton b5 = new JButton("Discard ❌");
        b5.setBounds(800, 23, 400, 50);
        b5.setFont(new Font("Dialog", Font.BOLD, 20));
        b5.setBackground(Color.decode("#C8D8EF"));
        b5.setForeground(Color.decode("#8F1313"));
        b5.setBorderPainted(false);
        b5.setFocusPainted(false);
        b5.setVisible(false);
        JLabel bl1 = new JLabel("Building - 104");
        bl1.setBounds(250, 25, 200, 100);
        bl1.setFont(new Font("Dialog", Font.BOLD, 20));

        current = MainExtended.currentUser;

        t1.setText(current.getFullName());      // Full Name
        t2.setText(current.getGender());        // Gender ✅ dito lalabas
        t3.setText(current.getTenantId());    // Tenant ID
        t4.setText(current.getEmail());         // Email
        t5.setText(current.getPhoneNumber());   // Contact Number

        r1.setText("Apartment Unit: " + current.getApartmentUnit());
        r2.setText("Unit Type: " + current.getUnitType());
        //  r3.setText("Monthly Rent: ₱"
        //          + String.format("%,.0f", current.getMonthRate()));
        r3.setText("Monthly Rent: ₱"
                + String.format("%,.2f", current.getMonthRate()));
        r4.setText("Stay duration: " + current.getLeaseOfStay());
        r5.setText("Move-in date: " + current.getMoveInDate());
        r6.setText("Lease end date: " + current.getEndDate());

        Sbox.add(r1);
        Sbox.add(r2);
        Sbox.add(r3);
        Sbox.add(r4);
        Sbox.add(r5);
        Sbox.add(r6);

        Dbox.add(b1);
        Dbox.add(b2);
        Dbox.add(b3);
        Dbox.add(b4);
        Dbox.add(b5);

        mainPanel.add(bg1);
        bg1.add(whitePanel);
        whitePanel.add(mainPanel2);
        Fbox.add(FboxD);
        FboxD.add(l2);
        Fbox.add(l3);
        Fbox.add(l4);
        Fbox.add(l5);
        Fbox.add(l6);
        Fbox.add(l7);
        Fbox.add(l8);
        Fbox.add(t1);
        Fbox.add(t2);
        Fbox.add(t3);
        Fbox.add(t4);
        Fbox.add(t5);

        whitePanel.add(Fbox);
        Sbox.add(l3);
        Sbox.add(r1);
        Sbox.add(r2);
        Sbox.add(r3);
        Sbox.add(r4);
        Sbox.add(r5);
        Sbox.add(r6);

        Sbox.add(SboxD);
        whitePanel.add(Sbox);

        whitePanel.add(Dbox);

        mainPanel2.add(l1);
        mainPanel.add(button1);
        mainPanel.add(button2);

        mainPanel.add(button5);

        this.add(mainPanel);

// FULL NAME (must have space, letters only)
        t1.getDocument().addDocumentListener(new DocumentListener() {
            private void validateFullName() {
                String fullname = t1.getText().trim();
                String nameRegex = "^[A-Za-z]+([ '-][A-Za-z]+)+$";
                if (fullname.isEmpty() || !fullname.matches(nameRegex)) {
                    t1.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    t1.setBorder(new LineBorder(Color.GREEN, 2));
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

        t2.getDocument().addDocumentListener(new DocumentListener() {
            private void validateGender() {
                String gender = t2.getText().trim().toLowerCase();
                // Regex: letters only, tapos check kung male/female lang
                String genderRegex = "^[A-Za-z]+$";
                if (!gender.matches(genderRegex)
                        || !(gender.equals("male") || gender.equals("female"))) {
                    t2.setBorder(new LineBorder(Color.RED, 2));   // ❌ invalid
                } else {
                    t2.setBorder(new LineBorder(Color.GREEN, 2)); // ✅ valid
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateGender();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateGender();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateGender();
            }
        });

        t5.getDocument().addDocumentListener(new DocumentListener() {
            private void validatePhone() {
                String phone = t5.getText().trim();
                String phoneRegex = "^09\\d{9}$"; // PH format: 09 + 9 digits = 11 total
                if (phone.isEmpty()) {
                    t5.setBorder(new LineBorder(Color.GRAY, 2));   // neutral kapag empty
                } else if (!phone.matches(phoneRegex)) {
                    t5.setBorder(new LineBorder(Color.RED, 2));    // ❌ invalid
                } else {
                    t5.setBorder(new LineBorder(Color.GREEN, 2));  // ✅ valid
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

//EMAIL (valid format)
        t4.getDocument().addDocumentListener(new DocumentListener() {
            private void validateEmail() {
                String email = t4.getText().trim();
                String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$";

                if (email.isEmpty() || !email.matches(emailRegex)) {
                    t4.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    t4.setBorder(new LineBorder(Color.GREEN, 2));
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

        b4.addActionListener(e -> {

            String nameRegex = "^[A-Za-z]+([ '-][A-Za-z]+)+$";
            String genderRegex = "^(?i)(male|female)$"; // ✅ case-insensitive check
            String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$";
            String phoneRegex = "^09\\d{9}$";

            if (!t1.getText().trim().matches(nameRegex)
                    || !t2.getText().trim().matches(genderRegex)
                    || !t4.getText().trim().matches(emailRegex)
                    || !t5.getText().trim().matches(phoneRegex)) {

                JOptionPane.showMessageDialog(this, "Please correct invalid fields ❌");
                return;
            }

            // Prompt for old Gmail
            String inputEmail = JOptionPane.showInputDialog("Enter your old Gmail to confirm:");

            if (inputEmail != null && !inputEmail.trim().isEmpty()) {
                boolean found = false;

                for (UserDataBP u : MainExtended.userData.getUsers()) {
                    if (u.getEmail().equalsIgnoreCase(inputEmail.trim())) {
                        u.setFullName(t1.getText());
                        u.setGender(t2.getText());   // ✅ Gender na
                        u.setEmail(t4.getText());
                        u.setPhoneNumber(t5.getText());

                        MainExtended.currentUser = u; // update global reference

                        new TenantHomeDashboard().setVisible(true);
                        dispose();

                        b1.setVisible(true);  // show Edit Profile
                        b2.setVisible(true);  // show Change Password
                        b3.setVisible(true);  // show Logout
                        b4.setVisible(false); // hide Save
                        b5.setVisible(false); // hide Discard

                        t1.setEditable(false);
                        t2.setEditable(false);
                        t3.setEditable(false);
                        t4.setEditable(false);
                        t5.setEditable(false);

                        t1.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
                        t2.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
                        t3.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
                        t4.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
                        t5.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));

                        found = true;
                        break; // ← importante para tumigil sa loop kapag nahanap na

                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(this, "Email not found in records ❌");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter your Gmail ❌");
            }
        });

        b1.addActionListener(e -> {

            t1.setEditable(true);
            t2.setEditable(true);
            // t3.setEditable(true);
            //t4.setEditable(true);
            t5.setEditable(true);

            b1.setVisible(false); // hide Edit Profile
            b2.setVisible(false); // hide Change Password
            b3.setVisible(false); // hide Logout
            b4.setVisible(true);  // show Save
            b5.setVisible(true);  // show Discard
        });
        b5.addActionListener(e -> {
            // Disable editing again
            t1.setEditable(false);
            t2.setEditable(false);
            t3.setEditable(false);
            t4.setEditable(false);
            t5.setEditable(false);

            // Reset values to currentUser data
            t1.setText(current.getFullName());
            t2.setText(current.getGender());
            t3.setText(current.getTenantId());      // Tenant ID (read-only)
            t4.setText(current.getEmail());
            t5.setText(current.getPhoneNumber());

            t1.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
            t2.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
            t3.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
            t4.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));
            t5.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));

            // Toggle buttons back
            b1.setVisible(true);  // show Edit Profile
            b2.setVisible(true);  // show Change Password
            b3.setVisible(true);  // show Logout
            b4.setVisible(false); // hide Save
            b5.setVisible(false); // hide Discard

        });
        b3.addActionListener(e -> {
            this.dispose();
            new MainExtended().setVisible(true);

        });

        setVisible(true);
    }

}

class ChangePassUI extends VaksJFrame {

    ChangePassUI() {
        super(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Password");
        setLayout(null);
        setSize(400, 410);

        JPanel base = new JPanel();
        base.setSize(400, 450);
        base.setLayout(null);

        JPanel iB = new JPanel();
        iB.setBounds(15, 30, 350, 330);
        iB.setBorder(new LineBorder(Color.decode("#abbfd5"), 2, false));
        iB.setLayout(null);
        base.add(iB);

        JLabel lab1 = new JLabel("                            Change Password  🔐 ");
        lab1.setFont(new Font("Dialog", Font.BOLD, 15));
        lab1.setBounds(10, 8, 300, 20);
        base.add(lab1);

        JLabel Email = new JLabel("Email:");
        Email.setFont(new Font("Dialog", Font.PLAIN, 15));
        Email.setBounds(15, 15, 200, 20);

        JTextField txt1 = new JTextField("");
        txt1.setForeground(Color.decode("#7A8691"));
        txt1.setBounds(15, 40, 320, 30);

        JLabel eFormat = new JLabel("Enter your email adress");//hint
        eFormat.setBounds(5, 5, 500, 20);
        eFormat.setFont(new Font("Dialog", Font.PLAIN, 14));
        txt1.add(eFormat);

        // --- Toggle visibility of format hint ---
        txt1.getDocument().addDocumentListener(new DocumentListener() {
            private void toggleHint() {
                if (txt1.getText().trim().isEmpty()) {
                    eFormat.setVisible(true);   // show hint kapag walang laman
                } else {
                    eFormat.setVisible(false);  // hide hint kapag may tinype
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

        JLabel paas = new JLabel("Current Password:");
        paas.setFont(new Font("Dialog", Font.PLAIN, 15));
        paas.setBounds(15, 85, 200, 20);

      JPasswordField  psp1 = new JPasswordField();
        psp1.setForeground(Color.decode("#7A8691"));
        psp1.setBounds(15, 110, 270, 30);

        JLabel paas2 = new JLabel("New Password:");
        paas2.setFont(new Font("Dialog", Font.PLAIN, 15));
        paas2.setBounds(15, 155, 200, 20);

        JPasswordField psp2 = new JPasswordField();
        psp2.setForeground(Color.decode("#7A8691"));
        psp2.setBounds(15, 180, 270, 30);

        // 👁 toggle buttons
        JToggleButton btnTogglePass1 = new JToggleButton("👁");
        btnTogglePass1.setFont(new Font("Dialog", Font.BOLD, 13));
        btnTogglePass1.setBackground(Color.decode("#7492BC"));
        btnTogglePass1.setForeground(Color.white);
        btnTogglePass1.setBounds(285, 110, 47, 30);
        btnTogglePass1.setFocusPainted(false);

        JToggleButton  btnTogglePass2 = new JToggleButton("👁");
        btnTogglePass2.setFont(new Font("Dialog", Font.BOLD, 13));
        btnTogglePass2.setBackground(Color.decode("#7492BC"));
        btnTogglePass2.setForeground(Color.white);
        btnTogglePass2.setBounds(285, 180, 47, 30);
        btnTogglePass2.setFocusPainted(false);

        btnTogglePass1.addActionListener(e -> {
            psp1.setEchoChar(btnTogglePass1.isSelected() ? (char) 0 : '•');
        });

        btnTogglePass2.addActionListener(e -> {
            psp2.setEchoChar(btnTogglePass2.isSelected() ? (char) 0 : '•');
        });

        JLabel check = new JLabel("                 Double check before updating!");
        check.setForeground(Color.decode("#7A8691"));
        check.setBounds(15, 230, 300, 20);
        check.setFont(new Font("Dialog", Font.PLAIN, 13));

       
        JButton updateb = new JButton("Update Password ✔");
        updateb.setBackground(Color.decode("#7492BC"));
        updateb.setForeground(Color.white);
        updateb.setBounds(15, 270, 150, 40);

        updateb.addActionListener(e -> {
            String emailEntered = txt1.getText().trim();
            String currentPassEntered = new String(psp1.getPassword());
            String newPassEntered = new String(psp2.getPassword());

            // Regex: exactly 6 digits
            String passRegex = "^[0-9]{6}$";

            if (emailEntered.isEmpty() || currentPassEntered.isEmpty() || newPassEntered.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!");
                return;
            }

            // Check if new password is 6 digits
            if (!newPassEntered.matches(passRegex)) {
                JOptionPane.showMessageDialog(this, "New password must be exactly 6 digits ❌");
                psp2.setBorder(new LineBorder(Color.RED, 2));
                return;
            }

            // Check only against the currently logged-in user
            UserDataBP loggedIn = MainExtended.currentUser;

            if (loggedIn.getEmail().equalsIgnoreCase(emailEntered)) {

                if (loggedIn.getPassword().equals(currentPassEntered)) {

                    if (currentPassEntered.equals(newPassEntered)) {
                        JOptionPane.showMessageDialog(this,
                                "You entered the same password. Please change it to a new one ❌");
                        psp2.setBorder(new LineBorder(Color.RED, 2));
                        return;
                    }

                    loggedIn.setPassword(newPassEntered); // update password
                    JOptionPane.showMessageDialog(this, "Password changed successfully!");
                    psp1.setBorder(new LineBorder(Color.GREEN, 2));
                    psp2.setBorder(new LineBorder(Color.GREEN, 2));
                    txt1.setBorder(new LineBorder(Color.GREEN, 2));
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect current password ❌");
                    psp1.setBorder(new LineBorder(Color.RED, 2));
                }

            } else {
                JOptionPane.showMessageDialog(this, "You can only change your own account password!");
                txt1.setBorder(new LineBorder(Color.RED, 2));
            }
        });

        // 🔹 Cancel button
        JButton cancelb = new JButton("Cancel ↩");
        cancelb.setForeground(Color.decode("#7492BC"));
        cancelb.setBackground(Color.white);
        cancelb.setBounds(190, 270, 150, 40);
        cancelb.addActionListener(e -> dispose());

        // 🔹 Add components
        iB.add(Email);
        iB.add(txt1);
        iB.add(paas);
        iB.add(psp1);
        iB.add(paas2);
        iB.add(psp2);
        iB.add(check);
        iB.add(updateb);
        iB.add(cancelb);
        iB.add(btnTogglePass1);
        iB.add(btnTogglePass2);
        this.add(base);

// EMAIL (must end with .com and must match current user, case-sensitive)
        txt1.getDocument().addDocumentListener(new DocumentListener() {
            private void validateEmail() {
                String email = txt1.getText().trim();
                String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$";
                UserDataBP loggedIn = MainExtended.currentUser;

                if (email.isEmpty() || !email.matches(emailRegex)) {
                    txt1.setBorder(new LineBorder(Color.RED, 2));
                } else if (!email.equals(loggedIn.getEmail())) {
                    // ❌ valid format pero hindi eksaktong tugma sa current user's email
                    txt1.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    // ✅ valid format at eksaktong tugma (case-sensitive)
                    txt1.setBorder(new LineBorder(Color.GREEN, 2));
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

// CURRENT PASSWORD (must be exactly 6 digits)
        psp1.getDocument().addDocumentListener(new DocumentListener() {
            private void validateCurrentPass() {
                String enteredPass = new String(psp1.getPassword()).trim();
                String passRegex = "^[0-9]{6}$"; // ✅ only 6 digits

                if (enteredPass.isEmpty() || !enteredPass.matches(passRegex)) {
                    psp1.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    psp1.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateCurrentPass();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateCurrentPass();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateCurrentPass();
            }
        });

// NEW PASSWORD (must be exactly 6 digits and not same as current)
        psp2.getDocument().addDocumentListener(new DocumentListener() {
            private void validateNewPass() {
                String newPass = new String(psp2.getPassword()).trim();
                String currentPass = new String(psp1.getPassword()).trim();
                String passRegex = "^[0-9]{6}$"; // ✅ only 6 digits

                if (newPass.isEmpty() || !newPass.matches(passRegex) || newPass.equals(currentPass)) {
                    psp2.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    psp2.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateNewPass();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateNewPass();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateNewPass();
            }
        });

    }
}
