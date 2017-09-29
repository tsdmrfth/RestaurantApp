package com.mvc.restaurant.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class ManagerFrame {

	private JFrame managerFrame;
	private JDatePickerImpl datePicker;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField salaryField;
	private JTextField phoneNumberField;
	private JTextField idField;
	private JButton addEmployeeButton;
	private JButton updateEmployeeButton;
	private JButton deleteEmployeeButton;
	private JButton showEmployeesButton;
	private JButton showReportsButton;
	private JButton addCategoryButton;
	private JButton addProductButton;
	private JButton updateProductButton;
	private JButton deleteProductButton;
	private JPanel showEmployeesPanel;
	private JTextField categoryNameField;
	private JTextField productNameField;
	private JTextField productPriceField;
	private JTextField productCategoryField;
	private JTextField productIDField;
	private JTable showEntityTable;
	private JTable showProductsTable;
	private JButton showProductsCategoryButton;
	private JButton showProductsButton;
	private JButton addTableButton;
	private JButton updateTableButton;
	private JButton deleteTableButton;
	private JButton showTablesButton;
	private JButton addUserButton;
	private JButton updateUserButton;
	private JButton deleteUserButton;
	private JButton showUsersButton;
	private JTextField tableIDField;
	private JTextField tabelNameField;
	private JPanel addUserPanel;
	private JTextField usernameField;
	private JPasswordField userPasswordField;
	private JTable showUsersTable;
	private JLabel userRoleLabel;
	private JLabel userIDLabel;
	private JTextField userIDField;
	private JRadioButton waiterRadioButton;
	private JRadioButton kitchenStaffRadioButton;
	private JRadioButton cashierRadioButton;

	public ManagerFrame() {

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		managerFrame = new JFrame();
		managerFrame.setBounds(100, 100, 1300, 800);
		managerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		managerFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		{
			JPanel employeeTabbedPanel = new JPanel();
			tabbedPane.addTab("EMPLOYEES", null, employeeTabbedPanel, null);
			employeeTabbedPanel.setLayout(null);

			JPanel employeesPanel = new JPanel();
			employeesPanel.setBounds(22, 15, 405, 494);
			employeesPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "ADD EMPLOYEE",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
			employeeTabbedPanel.add(employeesPanel);
			employeesPanel.setLayout(null);

			JPanel addEmployeePanel = new JPanel();
			addEmployeePanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			addEmployeePanel.setBounds(26, 56, 335, 395);
			employeesPanel.add(addEmployeePanel);
			addEmployeePanel.setLayout(null);

			JLabel firstNameLabel = new JLabel("First Name");
			firstNameLabel.setBounds(12, 63, 90, 24);
			addEmployeePanel.add(firstNameLabel);
			firstNameLabel.setFont(new Font("Dialog", Font.BOLD, 14));

			JLabel lastNameLabel = new JLabel("Last Name");
			lastNameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			lastNameLabel.setBounds(12, 103, 90, 24);
			addEmployeePanel.add(lastNameLabel);

			JLabel salaryLabel = new JLabel("Salary");
			salaryLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			salaryLabel.setBounds(12, 143, 90, 24);
			addEmployeePanel.add(salaryLabel);

			JLabel hireDateLabel = new JLabel("Hire Date");
			hireDateLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			hireDateLabel.setBounds(12, 183, 90, 24);
			addEmployeePanel.add(hireDateLabel);

			JLabel phoneNumberLabel = new JLabel("Phone Number");
			phoneNumberLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			phoneNumberLabel.setBounds(12, 223, 127, 15);
			addEmployeePanel.add(phoneNumberLabel);

			firstNameField = new JTextField();
			firstNameField.setBounds(153, 65, 157, 22);
			addEmployeePanel.add(firstNameField);
			firstNameField.setColumns(10);

			lastNameField = new JTextField();
			lastNameField.setColumns(10);
			lastNameField.setBounds(153, 105, 157, 22);
			addEmployeePanel.add(lastNameField);

			salaryField = new JTextField();
			salaryField.setColumns(10);
			salaryField.setBounds(153, 145, 157, 22);
			addEmployeePanel.add(salaryField);

			{
				UtilDateModel model = new UtilDateModel();
				JDatePanelImpl datePanel = new JDatePanelImpl(model);
				datePicker = new JDatePickerImpl(datePanel);
				datePicker.setBounds(153, 185, 157, 22);
				addEmployeePanel.add(datePicker);
			}

			phoneNumberField = new JTextField();
			phoneNumberField.setColumns(10);
			phoneNumberField.setBounds(153, 220, 157, 22);
			addEmployeePanel.add(phoneNumberField);

			addEmployeeButton = new JButton("ADD");
			addEmployeeButton.setBackground(Color.LIGHT_GRAY);
			addEmployeeButton.setBounds(44, 305, 78, 25);
			addEmployeePanel.add(addEmployeeButton);

			updateEmployeeButton = new JButton("UPDATE");
			updateEmployeeButton.setBackground(Color.LIGHT_GRAY);
			updateEmployeeButton.setBounds(126, 305, 89, 25);
			addEmployeePanel.add(updateEmployeeButton);

			JLabel idLabel = new JLabel("ID");
			idLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			idLabel.setBounds(12, 24, 127, 24);
			addEmployeePanel.add(idLabel);

			idField = new JTextField();
			idField.setText("For Update or Delete");
			idField.setColumns(10);
			idField.setBounds(153, 27, 157, 22);
			addEmployeePanel.add(idField);

			deleteEmployeeButton = new JButton("DELETE");
			deleteEmployeeButton.setBackground(Color.LIGHT_GRAY);
			deleteEmployeeButton.setBounds(221, 305, 89, 25);
			addEmployeePanel.add(deleteEmployeeButton);

			showEmployeesButton = new JButton("LIST EMPLOYEES");
			showEmployeesButton.setBounds(162, 342, 148, 25);
			addEmployeePanel.add(showEmployeesButton);
			showEmployeesButton.setBackground(Color.LIGHT_GRAY);

			showEmployeesPanel = new JPanel();
			showEmployeesPanel
					.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			showEmployeesPanel.setBounds(439, 19, 815, 617);
			employeeTabbedPanel.add(showEmployeesPanel);
			showEmployeesPanel.setLayout(null);

			showEntityTable = new JTable();
			showEntityTable.setCellSelectionEnabled(true);
			showEntityTable.setFillsViewportHeight(true);
			showEntityTable.setColumnSelectionAllowed(true);
			showEntityTable.setFont(new Font("Dialog", Font.BOLD, 12));
			showEntityTable.setBackground(UIManager.getColor("Button.background"));
			{
				JScrollPane jScrollPane = new JScrollPane();
				jScrollPane.setBounds(12, 60, 724, 525);
				showEmployeesPanel.add(jScrollPane);
				jScrollPane.setViewportView(showEntityTable);
			}
		}

		{
			JPanel reportTabbedPanel = new JPanel();
			tabbedPane.addTab("REPORTS", null, reportTabbedPanel, null);
			reportTabbedPanel.setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(25, 121, 531, 553);
			reportTabbedPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));

			JComboBox<Object> reportsComboBox = new JComboBox<Object>();
			reportsComboBox.addItem("DAILY REPORTS");
			reportsComboBox.addItem("WEEKLY REPORTS");
			reportsComboBox.addItem("MONTHLY REPORTS");
			reportsComboBox.setBounds(25, 33, 202, 31);
			reportTabbedPanel.add(reportsComboBox);

			showReportsButton = new JButton("SHOW REPORTS");
			showReportsButton.setBackground(Color.LIGHT_GRAY);
			showReportsButton.setBounds(259, 34, 145, 28);
			reportTabbedPanel.add(showReportsButton);
		}

		JPanel usersTabbedPanel = new JPanel();
		tabbedPane.addTab("USERS", null, usersTabbedPanel, null);
		usersTabbedPanel.setLayout(null);

		addUserPanel = new JPanel();
		addUserPanel.setBorder(new TitledBorder(null, "ADD USER", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addUserPanel.setBounds(25, 28, 497, 373);
		usersTabbedPanel.add(addUserPanel);
		addUserPanel.setLayout(null);

		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		usernameLabel.setBounds(12, 97, 95, 15);
		addUserPanel.add(usernameLabel);

		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(200, 93, 224, 26);
		addUserPanel.add(usernameField);

		JLabel userPasswordLabel = new JLabel("Password");
		userPasswordLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		userPasswordLabel.setBounds(12, 152, 95, 15);
		addUserPanel.add(userPasswordLabel);

		userPasswordField = new JPasswordField();
		userPasswordField.setColumns(10);
		userPasswordField.setBounds(200, 148, 224, 26);
		addUserPanel.add(userPasswordField);

		addUserButton = new JButton("ADD");
		addUserButton.setBackground(Color.LIGHT_GRAY);
		addUserButton.setBounds(75, 261, 87, 25);
		addUserPanel.add(addUserButton);

		updateUserButton = new JButton("UPDATE");
		updateUserButton.setToolTipText("Update user with username");
		updateUserButton.setBackground(Color.LIGHT_GRAY);
		updateUserButton.setBounds(175, 261, 119, 25);
		addUserPanel.add(updateUserButton);

		deleteUserButton = new JButton("DELETE");
		deleteUserButton.setToolTipText("Delete user with username");
		deleteUserButton.setBackground(Color.LIGHT_GRAY);
		deleteUserButton.setBounds(306, 261, 119, 25);
		addUserPanel.add(deleteUserButton);

		showUsersButton = new JButton("LIST USERS");
		showUsersButton.setToolTipText("Delete user with username");
		showUsersButton.setBackground(Color.LIGHT_GRAY);
		showUsersButton.setBounds(306, 298, 119, 25);
		addUserPanel.add(showUsersButton);

		userRoleLabel = new JLabel("User Role");
		userRoleLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		userRoleLabel.setBounds(12, 207, 119, 15);
		addUserPanel.add(userRoleLabel);

		userIDLabel = new JLabel("ID");
		userIDLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		userIDLabel.setBounds(12, 46, 95, 15);
		addUserPanel.add(userIDLabel);

		userIDField = new JTextField();
		userIDField.setText("For Update or Delete");
		userIDField.setColumns(10);
		userIDField.setBounds(200, 35, 224, 26);
		addUserPanel.add(userIDField);

		waiterRadioButton = new JRadioButton("Waiter");
		waiterRadioButton.setBounds(184, 203, 87, 23);
		addUserPanel.add(waiterRadioButton);

		cashierRadioButton = new JRadioButton("Cashier");
		cashierRadioButton.setBounds(275, 203, 87, 23);
		addUserPanel.add(cashierRadioButton);

		kitchenStaffRadioButton = new JRadioButton("Kitchen Staff");
		kitchenStaffRadioButton.setBounds(366, 203, 123, 23);
		addUserPanel.add(kitchenStaffRadioButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(534, 29, 497, 373);
		usersTabbedPanel.add(scrollPane);

		showUsersTable = new JTable();
		showUsersTable.setEnabled(false);
		scrollPane.setViewportView(showUsersTable);
		{
			JPanel productsTabbedPanel = new JPanel();
			tabbedPane.addTab("PRODUCTS  & TABLES", null, productsTabbedPanel, null);
			productsTabbedPanel.setLayout(null);

			JPanel productCategoryPanel = new JPanel();
			productCategoryPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "ADD CATEGORY",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
			productCategoryPanel.setBounds(0, 12, 447, 185);
			productsTabbedPanel.add(productCategoryPanel);
			productCategoryPanel.setLayout(null);

			JLabel categoryNameLabel = new JLabel("CATEGORY NAME");
			categoryNameLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			categoryNameLabel.setBounds(24, 48, 151, 15);
			productCategoryPanel.add(categoryNameLabel);

			categoryNameField = new JTextField();
			categoryNameField.setBounds(179, 42, 242, 28);
			productCategoryPanel.add(categoryNameField);

			addCategoryButton = new JButton("ADD");
			addCategoryButton.setBackground(Color.LIGHT_GRAY);
			addCategoryButton.setBounds(179, 116, 78, 25);
			productCategoryPanel.add(addCategoryButton);

			showProductsCategoryButton = new JButton("LIST PRODUCTS");
			showProductsCategoryButton.setBackground(Color.LIGHT_GRAY);
			showProductsCategoryButton.setBounds(269, 116, 142, 25);
			productCategoryPanel.add(showProductsCategoryButton);

			JPanel addProductPanel = new JPanel();
			addProductPanel.setBorder(
					new TitledBorder(null, "ADD PRODUCT", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			addProductPanel.setBounds(0, 229, 447, 393);
			productsTabbedPanel.add(addProductPanel);
			addProductPanel.setLayout(null);

			JLabel productNameLabel = new JLabel("Product Name");
			productNameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			productNameLabel.setBounds(12, 94, 132, 15);
			addProductPanel.add(productNameLabel);

			productNameField = new JTextField();
			productNameField.setBounds(162, 88, 242, 28);
			addProductPanel.add(productNameField);

			JLabel productPriceLabel = new JLabel("Price");
			productPriceLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			productPriceLabel.setBounds(12, 143, 132, 15);
			addProductPanel.add(productPriceLabel);

			productPriceField = new JTextField();
			productPriceField.setBounds(162, 137, 242, 28);
			addProductPanel.add(productPriceField);

			JLabel productCategoryIdDLabel = new JLabel("Category ID");
			productCategoryIdDLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			productCategoryIdDLabel.setBounds(12, 184, 132, 15);
			addProductPanel.add(productCategoryIdDLabel);

			productCategoryField = new JTextField();
			productCategoryField.setBounds(162, 177, 242, 28);
			addProductPanel.add(productCategoryField);

			addProductButton = new JButton("ADD");
			addProductButton.setBackground(Color.LIGHT_GRAY);
			addProductButton.setBounds(127, 247, 69, 25);
			addProductPanel.add(addProductButton);

			updateProductButton = new JButton("UPDATE");
			updateProductButton.setBackground(Color.LIGHT_GRAY);
			updateProductButton.setBounds(208, 247, 95, 25);
			addProductPanel.add(updateProductButton);

			deleteProductButton = new JButton("DELETE");
			deleteProductButton.setBackground(Color.LIGHT_GRAY);
			deleteProductButton.setBounds(315, 247, 95, 25);
			addProductPanel.add(deleteProductButton);

			JLabel productIDLabel = new JLabel("ID");
			productIDLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			productIDLabel.setBounds(12, 49, 132, 15);
			addProductPanel.add(productIDLabel);

			productIDField = new JTextField();
			productIDField.setText("For Update or Delete");
			productIDField.setBounds(162, 43, 242, 28);
			addProductPanel.add(productIDField);

			showProductsButton = new JButton("LIST PRODUCTS");
			showProductsButton.setBackground(Color.LIGHT_GRAY);
			showProductsButton.setBounds(268, 284, 142, 25);
			addProductPanel.add(showProductsButton);

			JPanel showProductsPanel = new JPanel();
			showProductsPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			showProductsPanel.setBounds(462, 23, 447, 594);
			productsTabbedPanel.add(showProductsPanel);
			showProductsPanel.setLayout(null);

			JScrollPane showProductEntityTable = new JScrollPane();
			showProductEntityTable.setBounds(12, 12, 423, 570);
			showProductsPanel.add(showProductEntityTable);

			showProductsTable = new JTable();
			showProductsTable.setBackground(UIManager.getColor("Button.background"));
			showProductsTable.setFont(new Font("Dialog", Font.BOLD, 14));
			showProductsTable.setEnabled(false);
			showProductEntityTable.setViewportView(showProductsTable);

			JPanel tablesPanel = new JPanel();
			tablesPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "ADD TABLE",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
			tablesPanel.setBounds(921, 23, 358, 302);
			productsTabbedPanel.add(tablesPanel);
			tablesPanel.setLayout(null);

			JLabel tableNameLabel = new JLabel("Name");
			tableNameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			tableNameLabel.setBounds(12, 94, 65, 15);
			tablesPanel.add(tableNameLabel);

			JLabel tableIDLabel = new JLabel("ID");
			tableIDLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			tableIDLabel.setBounds(12, 42, 47, 15);
			tablesPanel.add(tableIDLabel);

			tableIDField = new JTextField();
			tableIDField.setText("For Update or Delete");
			tableIDField.setBounds(84, 36, 242, 28);
			tablesPanel.add(tableIDField);

			tabelNameField = new JTextField();
			tabelNameField.setBounds(84, 88, 242, 28);
			tablesPanel.add(tabelNameField);

			addTableButton = new JButton("ADD");
			addTableButton.setBackground(Color.LIGHT_GRAY);
			addTableButton.setBounds(43, 163, 69, 25);
			tablesPanel.add(addTableButton);

			updateTableButton = new JButton("UPDATE");
			updateTableButton.setBackground(Color.LIGHT_GRAY);
			updateTableButton.setBounds(124, 163, 95, 25);
			tablesPanel.add(updateTableButton);

			deleteTableButton = new JButton("DELETE");
			deleteTableButton.setBackground(Color.LIGHT_GRAY);
			deleteTableButton.setBounds(231, 163, 95, 25);
			tablesPanel.add(deleteTableButton);

			showTablesButton = new JButton("LIST TABLES");
			showTablesButton.setBackground(Color.LIGHT_GRAY);
			showTablesButton.setBounds(197, 200, 129, 25);
			tablesPanel.add(showTablesButton);
			managerFrame.setVisible(true);
		}
	}

	public JDatePickerImpl getDatePickerClass() {
		return datePicker;
	}

	// Send useful methods for adding updating, deleting and listing employees.
	public String getFirstName() {
		return firstNameField.getText();
	}

	public String getLastName() {
		return lastNameField.getText();
	}

	public double getSalary() {
		return Double.parseDouble(salaryField.getText());
	}

	public Date getHireDate() {
		return (Date) datePicker.getJFormattedTextField().getValue();
	}

	public String getPhoneNumber() {
		return phoneNumberField.getText();
	}

	public Integer getEmployeeId() {
		return Integer.parseInt(idField.getText());
	}

	public void addEmployeeButtonListener(ActionListener actionListener) {
		addEmployeeButton.addActionListener(actionListener);
	}

	public void updateEmployeeButtonListener(ActionListener actionListener) {
		updateEmployeeButton.addActionListener(actionListener);
	}

	public void deleteEmployeeButtonListener(ActionListener actionListener) {
		deleteEmployeeButton.addActionListener(actionListener);
	}

	public void showEmployeesButtonListener(ActionListener actionListener) {
		showEmployeesButton.addActionListener(actionListener);
	}

	public void setShowEmployeTableModel(DefaultTableModel tableModel) {
		showEntityTable.setModel(tableModel);
	}

	// Send useful methods for adding and listing product categories.
	public String getProductCategoryName() {
		return categoryNameField.getText();
	}

	public void addProductCategoryListener(ActionListener actionListener) {
		addCategoryButton.addActionListener(actionListener);
	}

	public void showProductCategoryButtonListener(ActionListener actionListener) {
		showProductsCategoryButton.addActionListener(actionListener);
	}

	public void setShowProductCategoryTableModel(DefaultTableModel defaultTableModel) {
		showProductsTable.setModel(defaultTableModel);
	}

	// Send useful methods for adding updating, deleting and listing products.
	public Integer getProductID() {
		return Integer.parseInt(productIDField.getText());
	}

	public String getProductName() {
		return productNameField.getText();
	}

	public double getProductPrice() {
		return Double.parseDouble(productPriceField.getText());
	}

	public Integer getProductCategoryID() {
		return Integer.parseInt(productCategoryField.getText());
	}

	public void addProductButtonListener(ActionListener actionListener) {
		addProductButton.addActionListener(actionListener);
	}

	public void updateProductButtonListener(ActionListener actionListener) {
		updateProductButton.addActionListener(actionListener);
	}

	public void deleteProductButtonListener(ActionListener actionListener) {
		deleteProductButton.addActionListener(actionListener);
	}

	public void showProductsButtonListener(ActionListener actionListener) {
		showProductsButton.addActionListener(actionListener);
	}

	public void setShowProductsTableModel(DefaultTableModel defaultTableModel) {
		showProductsTable.setModel(defaultTableModel);
	}

	// Send useful methods for adding, updating, deleting and listing tables.
	public String getTableName() {
		return tabelNameField.getText();
	}

	public Integer getTableID() {
		return Integer.parseInt(tableIDField.getText());
	}

	public void addTableButtonListener(ActionListener actionListener) {
		addTableButton.addActionListener(actionListener);
	}

	public void updateTableButtonListener(ActionListener actionListener) {
		updateTableButton.addActionListener(actionListener);
	}

	public void deleteTableButtonListener(ActionListener actionListener) {
		deleteTableButton.addActionListener(actionListener);
	}

	public void showTablesButtonListener(ActionListener actionListener) {
		showTablesButton.addActionListener(actionListener);
	}

	public void setShowTablesTableModel(DefaultTableModel defaultTableModel) {
		showProductsTable.setModel(defaultTableModel);
	}

	// Send useful methods for adding, updating, deleting and listing users
	public Integer getUserID() {
		return Integer.parseInt(userIDField.getText());
	}

	public String getUsername() {
		return usernameField.getText();
	}

	@SuppressWarnings("deprecation")
	public String getUserPassword() {
		return userPasswordField.getText();
	}

	public Integer getUserRole() {
		int userRole = 0;
		if (waiterRadioButton.isSelected()) {
			userRole = 1;
		}
		if (cashierRadioButton.isSelected()) {
			userRole = 2;
		}
		if (kitchenStaffRadioButton.isSelected()) {
			userRole = 3;
		}
		return userRole;
	}

	public void addUserButtonListener(ActionListener actionListener) {
		addUserButton.addActionListener(actionListener);
	}

	public void updateUserButtonListener(ActionListener actionListener) {
		updateUserButton.addActionListener(actionListener);
	}

	public void deleteUserButtonListener(ActionListener actionListener) {
		deleteUserButton.addActionListener(actionListener);
	}

	public void showUsersButtonListener(ActionListener actionListener) {
		showUsersButton.addActionListener(actionListener);
	}

	public void setShowUsersTableModel(DefaultTableModel defaultTableModel) {
		showUsersTable.setModel(defaultTableModel);
	}

	public static void setInformation(String information) {
		JOptionPane.showMessageDialog(null, information);
	}

	public void setVisible(boolean visible) {
		managerFrame.setVisible(visible);
	}
}
