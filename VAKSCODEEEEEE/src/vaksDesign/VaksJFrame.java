package vaksDesign;

import javax.swing.JFrame;

public abstract class VaksJFrame extends JFrame {
    
   //para sa mga full frame
    public VaksJFrame() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //para sa pop up
    public VaksJFrame(int closeOperation) {
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(closeOperation); 
    }
} 
