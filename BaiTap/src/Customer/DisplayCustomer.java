package Customer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class DisplayCustomer extends JFrame implements ActionListener, MouseListener {
	
	private JTextField txtCustomerID, txtLastName, txtFirstName, txtAge, txtSalary;
	private JRadioButton rbtMan, rbtWoman;
	private JButton btAdd, btClear, btDelete, btSave, btEdit;
	private DefaultTableModel model;
	private JTable table;
	private FunctionCustomer fcustomer;
	private Customer customer;
	
	public DisplayCustomer() {
		setTitle("Customer")
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createGUI();
		
		if(fcustomer==null)
			fcustomer = new FunctionCustomer();
		
	}
	
	public void createGUI() {
		JPanel pNorth, pCenter, pSouth, pCenterNort, pCenterCenter;
		
		// title
		add(pNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lbTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		lbTitle.setFont(new Font("Arial", Font.BOLD, 25));
		pNorth.add(lbTitle);
		
		// create center
		add(pCenter = new JPanel(), BorderLayout.CENTER);
		pCenterNort = new JPanel();
		pCenterCenter = new JPanel();
		pCenter.add(pCenterNort, BorderLayout.NORTH);
		pCenter.add(pCenterCenter, BorderLayout.CENTER);
		
		// Phan north Center cua nhan vien
		// Khoi tao cac box
		pCenterNort.setLayout(new BoxLayout(pCenterNort, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		pCenterNort.add(b);
		
		// them label va text vao
		
		JLabel lbCustomerID = new JLabel("Mã nhân viên: ");
		txtCustomerID = new JTextField(50);
		b1.add(lbCustomerID); b1.add(txtCustomerID);
		
		JLabel lbLastName = new JLabel("Họ: ");
		JLabel lbFirstName = new JLabel("Tên NV: ");
		txtLastName = new JTextField();
		txtFirstName = new JTextField();
		b2.add(lbLastName); b2.add(txtLastName);
		b2.add(lbFirstName); b2.add(txtFirstName);
		
		JLabel lbAge = new JLabel("Tuổi: ");
		JLabel lbFaction = new JLabel("Phái: ");
		txtAge = new JTextField();
		ButtonGroup grFaction = new ButtonGroup();
		rbtMan = new JRadioButton("Nam");
		rbtWoman = new JRadioButton("Nữ");
		grFaction.add(rbtMan);
		grFaction.add(rbtWoman);
		b3.add(lbAge); b3.add(txtAge);
		b3.add(lbFaction); b3.add(rbtMan); b3.add(rbtWoman);
		
		JLabel lbSalary = new JLabel("Tiền lương");
		txtSalary = new JTextField();
		b4.add(lbSalary); b4.add(txtSalary);
		
		// tao bảng
		createTable();
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(700, 250));
		pCenterCenter.add(sp);
		
		// add các nút
		add(pSouth = new JPanel(), BorderLayout.SOUTH);
		pSouth.add(btAdd = new JButton("Thêm"));
		pSouth.add(btDelete = new JButton("Xoá"));
		pSouth.add(btEdit = new JButton("Sửa"));
		pSouth.add(btClear = new JButton("Xoá trắng"));
		pSouth.add(btSave = new JButton("Lưu"));
		
		txtCustomerID.addActionListener(this);
		txtLastName.addActionListener(this);
		txtFirstName.addActionListener(this);
		txtAge.addActionListener(this);
		txtSalary.addActionListener(this);
		btAdd.addActionListener(this);
		btClear.addActionListener(this);
		btDelete.addActionListener(this);
		btSave.addActionListener(this);
		btEdit.addActionListener(this);
		rbtMan.addActionListener(this); 
		rbtWoman.addActionListener(this);
		table.addMouseListener(this);
		
	}
	
	public void createTable() {
		JPanel pbTable = new JPanel();
		String []header = {"Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương"};
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		
		TableColumn faction = table.getColumnModel().getColumn(3);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		faction.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn column = new TableColumn();
		column.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btAdd){
			if(btAdd.getText().equals("Thêm")) {
				btDelete.setEnabled(false);
				btAdd.setText("Huỷ");
			} else {
				btDelete.setEnabled(true);
				btAdd.setText("Thêm");
			}
		}
		else if(o==btSave) {
			if(btAdd.getText().equals("Huỷ")) {
				if (this.txtCustomerID.getText().equals("") || this.txtFirstName.getText().equals("") || this.txtLastName.getText().equals("") || this.txtAge.getText().equals("")
						|| (this.rbtMan.isSelected() == false && this.rbtWoman.isSelected() == false) || this.txtSalary.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
				} else {
					try {
						save();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					btDelete.setEnabled(true);
					btAdd.setText("Thêm");
					clear();
				}
			} else if(btEdit.getText().equals("Huỷ")) {
				customer = createCustomer();
				if(fcustomer.editCustomer(customer)){
					JOptionPane.showMessageDialog(this, "Sửa thành công");
					int row = table.getSelectedRow();
					model.setValueAt(txtLastName.getText(), row, 1);
					model.setValueAt(txtFirstName.getText(), row, 2);
					if(rbtMan.isSelected()==true)
						model.setValueAt("Nam", row, 3);
					else model.setValueAt("Nữ", row, 3);
					model.setValueAt(txtAge.getText(), row, 4);
					model.setValueAt(txtSalary.getText(), row, 5);
					clear();
				} else {
					JOptionPane.showMessageDialog(this, "Không thể sửa");
					clear();
				}
				txtCustomerID.setEnabled(true);
				btDelete.setEnabled(true);
				btEdit.setText("Sửa");
			}
		} else if(o==btDelete){
			if(txtCustomerID.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xoá");
			} else {
				if(JOptionPane.showConfirmDialog(this, "Ban co chac chan muon xoa?", "Canh bao", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					if(!fcustomer.deleteCustomer(txtCustomerID.getText())){
						JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại");
					} else {
						model.removeRow(table.getSelectedRow());
						clear();
					}
				} else{
					clear();
				}
			}
		} else if(o==btClear) clear();
		else if(o==btEdit){
			if(txtCustomerID.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần sửa");
			} else {
				if (btEdit.getText().equals("Sửa")) {
					btDelete.setEnabled(false);
					btEdit.setText("Huỷ");
					JOptionPane.showMessageDialog(this, "Sửa những phần bạn muốn");
					txtCustomerID.setEnabled(false);
				} else if (btEdit.getText().equals("Huỷ")) {
					btDelete.setEnabled(true);
					btEdit.setText("Sửa");
					clear();
				}
			}
		}
		
	}

	public void save(){
		customer = createCustomer();

		if(this.rbtMan.isSelected()==true) customer.setFaction(this.rbtMan.getText());
		else if(this.rbtWoman.isSelected()==true) customer.setFaction(this.rbtWoman.getText());

		if(this.fcustomer.addCustomer(customer)) {
			Object []obj = new Object[6];
			obj[0] = this.txtCustomerID.getText();
			obj[1] = this.txtLastName.getText();
			obj[2] = this.txtFirstName.getText();
			if(this.rbtMan.isSelected()==true) obj[3] = this.rbtMan.getText();
			else if(this.rbtWoman.isSelected()==true) obj[3] = this.rbtWoman.getText();
			obj[4] = this.txtAge.getText();
			obj[5] = this.txtSalary.getText();

			model.addRow(obj);
			JOptionPane.showMessageDialog(this, "Thêm thành công");
		} else JOptionPane.showMessageDialog(this, "Nhân viên đã tồn tại");
	}

	public void clear(){
		txtCustomerID.setText("");
		txtFirstName.setText("");
		txtLastName.setText("");
		txtAge.setText("");
		txtSalary.setText("");
		rbtMan.setSelected(false);
		rbtWoman.setSelected(false);
		txtCustomerID.requestFocus();
	}

	public Customer createCustomer(){
		Customer c = new Customer();
		if (this.txtCustomerID.getText().equals("") || this.txtFirstName.getText().equals("") || this.txtLastName.getText().equals("") || this.txtAge.getText().equals("")
				|| (this.rbtMan.isSelected() == false && this.rbtWoman.isSelected() == false) || this.txtSalary.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
		} else {

			c.setID(this.txtCustomerID.getText());
			c.setLastName(this.txtLastName.getText());
			c.setFirstName(this.txtFirstName.getText());
			if (rbtMan.isSelected() == true)
				c.setFaction("Nam");
			else c.setFaction("Nữ");
			c.setAge(Integer.parseInt(this.txtAge.getText()));
			c.setSalary(Double.parseDouble(this.txtSalary.getText()));

			return c;
		}

		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtCustomerID.setText(model.getValueAt(row, 0).toString());
		txtLastName.setText(model.getValueAt(row, 1).toString());
		txtFirstName.setText(model.getValueAt(row, 2).toString());
		if(model.getValueAt(row, 3).toString().equalsIgnoreCase("Nam")){
			rbtMan.setSelected(true);
			rbtWoman.setSelected(false);
		} else {
			rbtMan.setSelected(false);
			rbtWoman.setSelected(true);
		}
		txtAge.setText(model.getValueAt(row, 4).toString());
		txtSalary.setText(model.getValueAt(row, 5).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new DisplayCustomer().setVisible(true);
	}

	
}
