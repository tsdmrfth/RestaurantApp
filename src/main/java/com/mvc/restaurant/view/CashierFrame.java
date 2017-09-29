package com.mvc.restaurant.view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class CashierFrame {

	private JFrame frame;
	private JComboBox<String> chooseTableComboBox;
	private JList<String> ordersList;
	private JTextField totalCostField;
	private JButton paymentButton;
	private JButton cancelButton;
	private JTextField descriptionField;
	private JDatePickerImpl datePicker;
	private JTextField spendingAmountField;
	private JButton addExpenseButton;

	public CashierFrame() {
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel paymentTabbedPanel = new JPanel();
		tabbedPane.addTab("PAYMENTS", null, paymentTabbedPanel, null);
		paymentTabbedPanel.setLayout(null);

		JLabel chooseTableLabel = new JLabel("Choose Table");
		chooseTableLabel.setBounds(12, 12, 106, 15);
		paymentTabbedPanel.add(chooseTableLabel);

		chooseTableComboBox = new JComboBox<String>();
		chooseTableComboBox.setBounds(122, 7, 145, 24);
		paymentTabbedPanel.add(chooseTableComboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 39, 276, 358);
		paymentTabbedPanel.add(scrollPane);

		ordersList = new JList<String>();
		scrollPane.setViewportView(ordersList);

		JLabel totalCostLabel = new JLabel("Total Cost");
		totalCostLabel.setBounds(306, 41, 88, 15);
		paymentTabbedPanel.add(totalCostLabel);

		totalCostField = new JTextField();
		totalCostField.setEditable(false);
		totalCostField.setBounds(386, 37, 72, 24);
		paymentTabbedPanel.add(totalCostField);

		paymentButton = new JButton("PAYMENT OK");
		paymentButton.setBackground(Color.LIGHT_GRAY);
		paymentButton.setBounds(429, 359, 132, 61);
		paymentTabbedPanel.add(paymentButton);

		cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(323, 359, 99, 61);
		paymentTabbedPanel.add(cancelButton);

		JPanel expensesTabbedPanel = new JPanel();
		tabbedPane.addTab("EXPENSES", null, expensesTabbedPanel, null);
		expensesTabbedPanel.setLayout(null);

		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(12, 31, 81, 15);
		expensesTabbedPanel.add(descriptionLabel);

		descriptionField = new JTextField();
		descriptionField.setBounds(154, 27, 148, 24);
		expensesTabbedPanel.add(descriptionField);

		JLabel spendingDateLabel = new JLabel("Spending Date");
		spendingDateLabel.setBounds(12, 89, 115, 15);
		expensesTabbedPanel.add(spendingDateLabel);

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(154, 80, 148, 24);
		expensesTabbedPanel.add(datePicker);

		JLabel spendingAmountLabel = new JLabel("Spending Amount");
		spendingAmountLabel.setBounds(12, 136, 148, 15);
		expensesTabbedPanel.add(spendingAmountLabel);

		spendingAmountField = new JTextField();
		spendingAmountField.setBounds(154, 132, 148, 24);
		expensesTabbedPanel.add(spendingAmountField);

		addExpenseButton = new JButton("ADD");
		addExpenseButton.setBackground(Color.LIGHT_GRAY);
		addExpenseButton.setBounds(216, 183, 81, 25);
		expensesTabbedPanel.add(addExpenseButton);
		frame.setVisible(true);
	}

	public void chooseTableNameItems(String item) {
		chooseTableComboBox.addItem(item);
	}

	public void chooseTableComboBoxListener(ItemListener itemListener) {
		chooseTableComboBox.addItemListener(itemListener);
	}

	public String getTableName() {
		return (String) chooseTableComboBox.getSelectedItem();
	}

	public void setOrdersListModel(DefaultListModel<String> tableOrdersListModel) {
		ordersList.setModel(tableOrdersListModel);
	}

	public void setTotalCost(String cost) {
		totalCostField.setText(cost);
	}

	public void cancelButtonListener(ActionListener actionListener) {
		cancelButton.addActionListener(actionListener);
	}

	public void dispose() {
		frame.dispose();
	}

	public void paymentButtonListener(ActionListener actionListener) {
		paymentButton.addActionListener(actionListener);
	}

	public void addExpenseButtonListener(ActionListener actionListener) {
		addExpenseButton.addActionListener(actionListener);
	}

	public String getExpenseDescription() {
		return descriptionField.getText();
	}

	public Double getSpendingAmount() {
		return Double.parseDouble(spendingAmountField.getText());
	}
}
