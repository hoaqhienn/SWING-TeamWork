package Chuong1;

import javax.swing.*;

public class BT1 extends JFrame {
    public BT1() {
        setTitle("Demo JFrame");
        setSize(500, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    public static void main(String[] args) {
        new BT1().setVisible(true);
    }
}
