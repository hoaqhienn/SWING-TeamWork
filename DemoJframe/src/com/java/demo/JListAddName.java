package com.java.demo;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class JListAddName extends JFrame implements ActionListener {
	private JButton btnAdd, btnRemove;
	private JTextField txtFirstName, txtLastName;
	private DefaultTableModel tableModel;
	private JTable table;
	
	public JListAddName() throws HeadlessException {
		super("Add name");
		setSize(500, 300);
		
		//list
		String []header = {"Ho va dem",  "Ten"};
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel pNorth, pTop, pBottom, pSouth;
		
		pTop = new JPanel();
		pBottom = new JPanel();
		
		pTop.add(new JLabel("Ho"));
		pTop.add(txtLastName = new JTextField(15));
		
		pBottom.add(new JLabel("Ten"));
		pBottom.add(txtFirstName = new JTextField(15));
		
		pNorth = new JPanel(new BorderLayout());
		pNorth.add(pTop, BorderLayout.NORTH);
		pNorth.add(pBottom, BorderLayout.CENTER);
		add(pNorth, BorderLayout.NORTH);
		
		pSouth = new JPanel();
		pSouth.add(btnAdd = new JButton("Add item"));
		pSouth.add(btnRemove = new JButton("Remove item"));
		add(pSouth, BorderLayout.SOUTH);
		
		txtLastName.addActionListener(this);
		txtFirstName.addActionListener(this);
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnAdd)) {
			if(txtLastName.getText().equals("")||txtFirstName.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui long nhap");
			} else {
				Object []obj = new Object[2];
				obj[0] = txtLastName.getText();
				obj[1] = txtFirstName.getText();
				tableModel.addRow(obj);
			}
		} else if(o.equals(btnRemove)) {
			if(table.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(this, "Phai chon dong can xoa");
			} else {
				if(JOptionPane.showConfirmDialog(this, "Ban co chac chan muon xoa?", "Canh bao", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					tableModel.removeRow(table.getSelectedRow());
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new JListAddName().setVisible(true);
	}
	
	
}
