package vaksDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MainExtended extends VaksJFrame {

    public static UserData userData = new UserData(); 
    public static UserDataBP currentUser;             
   

//ADMIN ACCOUNT
    private static UserDataBP adminAccount = new UserDataBP(
            "Admin User",
            "Vaks@gmail.com",
            "123456",
            "09123456789",
            "Admin"
    );
    public static UserDataBP getAdminAccount() {
    return adminAccount;
}

    MainExtended() {
        this.setTitle("MainDashBoard");
        this.setLayout(null); // manual positioning
      


        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#7492BC"));
        panel.setBounds(0, 0, 660, 850);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.decode("#f0f8ff"));
        panel2.setBounds(10, 12, 630, 810);
        panel2.setLayout(null);

        JPanel border = new JPanel();
        border.setBounds(22, 14, 585, 785);
        border.setBackground(Color.decode("#f0f8ff"));
        border.setBorder(new LineBorder(Color.decode("#7492BC"), 7, true));

        JPanel rpanel = new JPanel();
        rpanel.setBackground(Color.decode("#000080"));
        rpanel.setBounds(660, 0, 880, 850);
        rpanel.setLayout(null);

        JButton button1 = new JButton("Login");
        button1.setBounds(162, 600, 320, 57);
        button1.setBackground(Color.decode("#7492BC"));
        button1.setForeground(Color.decode("#f0f8ff"));
        button1.setFont(new Font("Dialog", Font.BOLD, 17));

        JLabel l1 = new JLabel("Email/Contact Number: ");
        l1.setBounds(90, 280, 200, 60);
        l1.setFont(new Font("Dialog", Font.BOLD, 15));

        JTextField t1 = new JTextField();
        t1.setBounds(90, 330, 450, 40);
        t1.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));

        JLabel l2 = new JLabel("Password: ");
        l2.setBounds(90, 380, 100, 60);
        l2.setFont(new Font("Dialog", Font.BOLD, 15));

        JPasswordField t2 = new JPasswordField();
        t2.setBounds(90, 430, 450, 40);
        t2.setBorder(new LineBorder(Color.decode("#7492BC"), 2, true));

        JLabel l5 = new JLabel("User Role: ");
        l5.setBounds(90, 480, 100, 60);
        l5.setFont(new Font("Dialog", Font.BOLD, 15));

        String[] Role = {"Tenant", "Admin"};

        JComboBox<String> combo = new JComboBox<>(Role);
        combo.setFont(new Font("Dialog", Font.CENTER_BASELINE, 13));
        combo.setBounds(90, 540, 450, 40);

        JLabel l4 = new JLabel("Find your next place to call home");
        l4.setBounds(120, 150, 400, 50);
        l4.setFont(new Font("Dialog", Font.BOLD, 25));
        l4.setForeground(Color.decode("#000000"));

        JLabel l3 = new JLabel("Vaks Apartment");
        l3.setBounds(240, 60, 300, 50);
        l3.setFont(new Font("Dialog", Font.BOLD, 30));
        l3.setForeground(Color.decode("#191970"));

        JTextArea descArea = new JTextArea(
                "A secure system that streamlines apartment rentals by managing"
                + " room availability, tenant records, and payment tracking in one place."
        );

        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setEditable(false);
        descArea.setOpaque(false);
        descArea.setBorder(null);
        descArea.setFont(new Font("Dialog", Font.BOLD, 17));
        descArea.setBounds(86, 210, 500, 100);
        descArea.setForeground(Color.decode("#002147"));

        JTextArea descArea2 = new JTextArea(
                " You might find your dream place here! join now."
                
        );
        descArea2.setLineWrap(true);
        descArea2.setWrapStyleWord(true);
        descArea2.setEditable(false);
        descArea2.setOpaque(false);
        descArea2.setBorder(null);
        descArea2.setFont(new Font("Serif", Font.PLAIN, 18));
        descArea2.setBounds(140, 690, 400, 100);
        descArea2.setForeground(Color.decode("#002147"));

        ImageIcon icon9 = new ImageIcon("5.png");
        int newW9 = 250;
        int newH9 = 140;
        Image scaled9 = icon9.getImage().getScaledInstance(newW9, newH9, Image.SCALE_SMOOTH);
        JLabel imageLabel9 = new JLabel(new ImageIcon(scaled9));

        JPanel rightPanel9 = new JPanel();
        rightPanel9.setBounds(80, 18, newW9, newH9);
        rightPanel9.setOpaque(false);
        rightPanel9.add(imageLabel9);

        ImageIcon rIcon = new ImageIcon("picture/collage.jpg");
        int newW1 = 882;
        int newH1 = 840;
        Image scaled1 = rIcon.getImage().getScaledInstance(newW1, newH1, Image.SCALE_SMOOTH);
        JLabel imageLabel1 = new JLabel(new ImageIcon(scaled1));
        
       


        JPanel rightPanel1 = new JPanel();
        rightPanel1.setBounds(0, 0, newW1, newH1);
        rightPanel1.add(imageLabel1);

        panel2.add(button1);
        panel2.add(rightPanel9);
        panel2.add(t1);
        panel2.add(t2);
        panel2.add(combo);
        panel2.add(l1);
        panel2.add(l2);
        panel2.add(l5);
        panel2.add(l3);
        panel2.add(descArea);
        panel2.add(l4);
        panel2.add(descArea2);
        panel2.add(border);
        rpanel.add(rightPanel1);

        this.add(panel2);
        this.add(rpanel);
        this.add(panel);

        button1.addActionListener(e -> {
            String username = t1.getText().trim();
            String password = new String(t2.getPassword()).trim();
            String selectedRole = (String) combo.getSelectedItem();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check admin login
            if (selectedRole.equals("Admin")
                    && username.equals(MainExtended.getAdminAccount().getEmail())
                    && password.equals(MainExtended.getAdminAccount().getPassword())) {

                MainExtended.currentUser = MainExtended.getAdminAccount();
                JOptionPane.showMessageDialog(this, "Login Successful as Admin!");
                this.dispose();
                new AdminHome().setVisible(true); // open admin UI

            } else if (selectedRole.equals("Tenant")) {
                boolean found = false;

                for (UserDataBP u : MainExtended.userData.getUsers()) {

                    if (u.getEmail().equals(username)
                            || u.getPhoneNumber().equals(username)) {

                        // CHECK KUNG BLOCKED
                        if (u.isBlocked()) {

                            JOptionPane.showMessageDialog(
                                    this,
                                    "Account is blocked. Contact the Administrator."
                            );

                            found = true;
                            break;
                        }

                        // TAMA PASSWORD
                        if (u.getPassword().equals(password)) {

                            u.setLoginAttempts(0); // reset attempts

                            MainExtended.currentUser = u;

                            JOptionPane.showMessageDialog(
                                    this,
                                    "Login Successful as Tenant!"
                            );

                            this.dispose();

                            TenantHomeDashboard THD
                                    = new TenantHomeDashboard();

                            THD.setVisible(true);

                            found = true;
                            break;
                        }

                        // MALI PASSWORD
                        u.setLoginAttempts(
                                u.getLoginAttempts() + 1
                        );

                        int remaining
                                = 3 - u.getLoginAttempts();

                        if (u.getLoginAttempts() >= 3) {

                            u.setBlocked(true);

                            JOptionPane.showMessageDialog(
                                    this,
                                    "Account has been blocked after 3 failed attempts."
                            );

                        } else {

                            JOptionPane.showMessageDialog(
                                    this,
                                    "Wrong Password! Remaining Attempts: "
                                    + remaining
                            );
                        }

                        found = true;
                        break;
                    }

                }
                if (!found) {
                    JOptionPane.showMessageDialog(this, "Invalid tenant credentials.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid role selection.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    

        setVisible(true);
    }
}




class Main {

    public static void main(String[] args) {

        new MainExtended();
    }
}
