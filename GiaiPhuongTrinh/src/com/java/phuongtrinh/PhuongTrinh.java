package com.java.phuongtrinh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhuongTrinh extends JFrame implements ActionListener {
	private JButton buttonSlove;
	private JButton buttonClear;
	private JButton buttonExit;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtKQ;
	
	public PhuongTrinh() {
		setTitle("Phuong trinh");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		createGUI();
	}
	
	public void createGUI() {
		JPanel panelNorth, panelCenter, panelSouth;
		add(panelNorth = new JPanel(), BorderLayout.NORTH);
		add(panelCenter = new JPanel(), BorderLayout.CENTER);
		add(panelSouth = new JPanel(), BorderLayout.SOUTH);
		
		panelNorth.setBackground(Color.CYAN);
		JLabel labelTitle = new JLabel("Giai phuong trinh bac hai");
		labelTitle.setFont(new Font("Arial", Font.BOLD, 20));
		panelNorth.add(labelTitle);
		
		panelCenter.setLayout(null);
		JLabel labelA, labelB, labelC, labelResult;
		panelCenter.add(labelA = new JLabel("Nhap A"));
		panelCenter.add(labelB = new JLabel("Nhap B"));
		panelCenter.add(labelC = new JLabel("Nhap C"));
		panelCenter.add(labelResult = new JLabel("Ket qua"));
		
		panelCenter.add(txtA = new JTextField());
		panelCenter.add(txtB = new JTextField());
		panelCenter.add(txtC = new JTextField());
		panelCenter.add(txtKQ = new JTextField());
		txtKQ.setEditable(false);
		
		int x=20, y=40, width=100, height=30;
		labelA.setBounds(x, y, width, height);
		y += 50;
		labelB.setBounds(x, y, width, height);
		y += 50;
		labelC.setBounds(x, y, width, height);
		y += 50;
		labelResult.setBounds(x, y, width, height);
		x += 100; y=40; width=300;
		txtA.setBounds(x, y, width, height);
		y += 50;
		txtB.setBounds(x, y, width, height);
		y += 50;
		txtC.setBounds(x, y, width, height);
		y += 50;
		txtKQ.setBounds(x, y, width, height);
		y += 50;
		
		panelSouth.setBorder(BorderFactory.createTitledBorder("Chon tac vu"));
		panelSouth.add(buttonSlove = new JButton("Giai"));
		panelSouth.add(buttonClear = new JButton("Don du lieu"));
		panelSouth.add(buttonExit = new JButton("Thoat"));
		
		buttonSlove.addActionListener(this);
		buttonClear.addActionListener(this);
		buttonExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new PhuongTrinh().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(buttonExit)) {
			System.exit(0);
		} else if(o.equals(buttonClear)) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtKQ.setText("");
			txtA.requestFocus();
		} else if(o.equals(buttonSlove)) {
			int a = Integer.parseInt(txtA.getText());
			int b = Integer.parseInt(txtB.getText());
			int c = Integer.parseInt(txtC.getText());
			if(a==0) giaiPhuongTrinhBacNhat(b, c);
			else giaiPhuongTrinhBacHai(a, b, c);
		}
		
	}
	
	public boolean isInt(JTextField text) {
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		} catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}
	
	public void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "Loi nhap lieu");
		text.selectAll();
		text.requestFocus();
	}
	
	public void giaiPhuongTrinhBacNhat(int a, int b) {
		if(a!=0) {
			txtKQ.setText("Nghiem x = " + (-b/(float)a));
		} else if(b==0) {
			txtKQ.setText("Vo so nghiem");
		} else txtKQ.setText("Vo nghiem");
	}
	
	public void giaiPhuongTrinhBacHai(int a, int b, int c) {
		float denta = b*b - 4*a*c;
		if(denta < 0) {
			txtKQ.setText("Vo nghiem");
		}
		else if(denta == 0) {
			txtKQ.setText("x1 = x2 = " + (-b/2*(float)a));
		} else {
			txtKQ.setText("x1 = " + ((-b+Math.sqrt(denta))/(2*(float)a)) 
						+ "; x2 = " + ((-b-Math.sqrt(denta))/(2*(float)a)));
		}
	}
}
