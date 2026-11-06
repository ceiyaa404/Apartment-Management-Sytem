package vaksDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class TenantHomeDashboard extends VaksJFrame {

    static RentAndPayment rentAndpayment;

    TenantHomeDashboard() {
        setTitle("Tenant Dashboard");
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

        JButton button1 = new JButton("Home");
        button1.setBounds(380, 10, 160, 40);
        button1.setBackground(Color.decode("#7492BC"));
        button1.setBorder(new LineBorder(Color.white, 3));
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Dialog", Font.BOLD, 18));

        button1.addActionListener(e -> {
            JButton btn = (JButton) e.getSource();
            btn.setEnabled(false);

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

        JLabel l1 = new JLabel(" 👤 Dashboard");
        l1.setBounds(20, 20, 600, 45);
        l1.setFont(new Font("Dialog", Font.BOLD, 40));

        JPanel rang = new JPanel();
        rang.setBounds(0, 75, 2000, 3);
        rang.setBackground(Color.decode("#7492BC"));
        LightB2.add(rang);

        String Tname = MainExtended.currentUser.getFullName();

        JLabel l2 = new JLabel("Welcome " + Tname);
        l2.setBounds(20, 80, 600, 40);
        l2.setFont(new Font("Dialog", Font.BOLD, 35));

        JLabel l3 = new JLabel("Here is your apartment overview");
        l3.setBounds(20, 120, 600, 40);
        l3.setFont(new Font("Dialog", Font.PLAIN, 30));

        int newW1 = 100;
        int newH1 = 100;

        JPanel p1 = new JPanel();
        p1.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        p1.setBackground(Color.decode("#D7E6F5"));
        p1.setBounds(30, 180, 450, 280);
        p1.setLayout(null);

        JPanel p_1 = new JPanel();
        p_1.setBounds(11, 60, 425, 210);
        p_1.setBackground(Color.white);
        p_1.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        p_1.setLayout(null);
        p1.add(p_1);

        JLabel unitnum = new JLabel("Unit number 🔑");
        unitnum.setBounds(20, 10, 300, 40);
        unitnum.setFont(new Font("Dialog", Font.BOLD, 26));
        p1.add(unitnum);

        // Kunin yung unit number ng current user
        String unitId = MainExtended.currentUser.getApartmentUnit();

        JLabel unitnum1 = new JLabel(unitId);
        unitnum1.setBounds(30, 30, 300, 40);
        unitnum1.setFont(new Font("Dialog", Font.BOLD, 40));
        p_1.add(unitnum1);

        ImageIcon aIc1 = new ImageIcon("picture/l.png");
        Image acal11 = aIc1.getImage().getScaledInstance(newW1, newH1, Image.SCALE_SMOOTH);
        JLabel aim1 = new JLabel(new ImageIcon(acal11));
        aim1.setBounds(300, 95, newW1, newH1);
        p_1.add(aim1);

        JPanel p2 = new JPanel();
        p2.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        p2.setBackground(Color.decode("#D7E6F5"));
        p2.setBounds(505, 180, 450, 280);
        p2.setLayout(null);

        JPanel p_2 = new JPanel();
        p_2.setBounds(11, 60, 425, 210);
        p_2.setBackground(Color.white);
        p_2.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        p_2.setLayout(null);
        p2.add(p_2);

        JLabel mb = new JLabel("Monthly Balance 💰");
        mb.setBounds(20, 10, 300, 40);
        mb.setFont(new Font("Dialog", Font.BOLD, 26));
        p2.add(mb);

        // Kunin yung unit number ng current user
        double balance = MainExtended.currentUser.getMonthRate();

        JLabel mb1 = new JLabel("₱ " + String.format("%.2f", balance));
        mb1.setBounds(30, 30, 300, 40);
        mb1.setFont(new Font("Dialog", Font.BOLD, 40));
        p_2.add(mb1);

        ImageIcon Ic1 = new ImageIcon("picture/k.png");
        Image cal11 = Ic1.getImage().getScaledInstance(newW1, newH1, Image.SCALE_SMOOTH);
        JLabel im1 = new JLabel(new ImageIcon(cal11));
        im1.setBounds(300, 95, newW1, newH1);
        p_2.add(im1);

        JPanel p3 = new JPanel();
        p3.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        p3.setBackground(Color.decode("#D7E6F5"));
        p3.setBounds(980, 180, 450, 280);
        p3.setLayout(null);

        JPanel p_3 = new JPanel();
        p_3.setBounds(11, 60, 425, 210);
        p_3.setBackground(Color.white);
        p_3.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        p_3.setLayout(null);
        p3.add(p_3);

        JLabel mb3 = new JLabel("Lease end Date 🔚 ");
        mb3.setBounds(20, 10, 300, 40);
        mb3.setFont(new Font("Dialog", Font.BOLD, 26));
        p3.add(mb3);

        String endDate = MainExtended.currentUser.getEndDate();

        JLabel mb13 = new JLabel(endDate);
        mb13.setBounds(30, 30, 300, 40);
        mb13.setFont(new Font("Dialog", Font.BOLD, 40));
        p_3.add(mb13);

        LocalDate leaseEnd = LocalDate.parse(MainExtended.currentUser.getEndDate());
        String formattedEndDate = leaseEnd.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));

        JLabel mb14 = new JLabel(formattedEndDate);
        mb14.setBounds(30, 60, 300, 40);
        mb14.setForeground(Color.gray);
        mb14.setFont(new Font("Dialog", Font.PLAIN, 20));
        p_3.add(mb14);

        ImageIcon Ic = new ImageIcon("picture/m.png");
        Image cal1 = Ic.getImage().getScaledInstance(newW1, newH1, Image.SCALE_SMOOTH);
        JLabel im = new JLabel(new ImageIcon(cal1));
        im.setBounds(300, 90, newW1, newH1);
        p_3.add(im);

        JPanel p4 = new JPanel();
        p4.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        p4.setBackground(Color.decode("#D7E6F5"));
        p4.setBounds(330, 470, 750, 240);
        p4.setLayout(null);

        JPanel p_4 = new JPanel();
        p_4.setBounds(40, 60, 665, 168);
        p_4.setBackground(Color.white);
        p_4.setBorder(new LineBorder(Color.decode("#7492BC"), 3, true));
        p_4.setLayout(null);
        p4.add(p_4);

        JButton b1b = new JButton("👤");
        b1b.setFont(new Font("Dialog", Font.PLAIN, 70));
        b1b.setBackground(Color.decode("#7492BC"));
        b1b.setForeground(Color.white);
        b1b.setBounds(50, 10, 250, 100);
        p_4.add(b1b);

        b1b.addActionListener(e -> {

            new Account().setVisible(true);
            this.dispose();

        });

        JButton b2b = new JButton("📄");
        b2b.setFont(new Font("Dialog", Font.PLAIN, 70));
        b2b.setBackground(Color.decode("#7492BC"));
        b2b.setForeground(Color.white);
        b2b.setBounds(360, 10, 250, 100);
        p_4.add(b2b);

        b2b.addActionListener(e -> {
            if (rentAndpayment == null) {
                rentAndpayment = new RentAndPayment();
            }

            rentAndpayment.setVisible(true);
            this.dispose();

        });

        JLabel lal1 = new JLabel("Rent and Payment");
        lal1.setBounds(410, 120, 250, 30); // just below the button
        lal1.setFont(new Font("Dialog", Font.BOLD, 20)); // optional styling
        lal1.setForeground(Color.decode("#7492BC"));     // optional color
        p_4.add(lal1);

        JLabel lal = new JLabel("View Account");
        lal.setBounds(115, 120, 250, 30); // just below the button
        lal.setFont(new Font("Dialog", Font.BOLD, 20)); // optional styling
        lal.setForeground(Color.decode("#7492BC"));     // optional color
        p_4.add(lal);

        JLabel mb4 = new JLabel("Quick Action ⏰");
        mb4.setBounds(20, 10, 300, 40);
        mb4.setFont(new Font("Dialog", Font.BOLD, 26));
        p4.add(mb4);

        LightB2.add(l1);
        LightB2.add(l2);
        LightB2.add(l3);
        LightB2.add(p1);
        LightB2.add(p2);
        LightB2.add(p3);
        LightB2.add(p4);

        backg1.add(LightB);
        LightB.add(LightB2);

        mainPanel.add(button1);
        mainPanel.add(button2);

        mainPanel.add(button5);

        this.add(mainPanel);

        setVisible(true);
    }

}
