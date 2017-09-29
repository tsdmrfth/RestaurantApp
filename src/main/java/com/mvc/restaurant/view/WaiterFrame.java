package com.mvc.restaurant.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class WaiterFrame {

	private JFrame waiterFrame;
	private JComboBox<String> tableNameComboBox;
	private JComboBox<String> categoryComboBox;
	public JList<String> sendOrdersList;
	public JList<String> productsList;
	public JButton sendOrderButton;
	private JButton cancelButton;
	private JButton updateOrderButton;
	private JButton minusButton;
	private JButton plusButton;
	private JTextField totalCostField;

	public WaiterFrame() {
	}

	public void initialize() {
		waiterFrame = new JFrame();
		waiterFrame.setBounds(100, 100, 900, 600);
		waiterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		waiterFrame.getContentPane().setLayout(null);

		JPanel informationPanel = new JPanel();
		informationPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		informationPanel.setBounds(12, 12, 865, 34);
		waiterFrame.getContentPane().add(informationPanel);
		informationPanel.setLayout(null);

		JLabel totalCostLabel = new JLabel("Total Cost");
		totalCostLabel.setBounds(625, 10, 115, 15);
		informationPanel.add(totalCostLabel);
		totalCostLabel.setFont(new Font("Dialog", Font.BOLD, 12));

		totalCostField = new JTextField();
		totalCostField.setEditable(false);
		totalCostField.setBounds(717, 6, 116, 22);
		totalCostField.setText(String.valueOf(0));
		informationPanel.add(totalCostField);

		JPanel orderPanel = new JPanel();
		orderPanel.setBounds(12, 58, 865, 528);
		waiterFrame.getContentPane().add(orderPanel);
		orderPanel.setLayout(null);

		JLabel tableLabel = new JLabel("Choose Table");
		tableLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		tableLabel.setBounds(12, 2, 115, 15);
		orderPanel.add(tableLabel);

		tableNameComboBox = new JComboBox<String>();
		tableNameComboBox.setBounds(166, 0, 129, 24);
		tableNameComboBox.setSelectedIndex(-1);
		orderPanel.add(tableNameComboBox);

		JLabel chooseCategoryLabel = new JLabel("Choose Category");
		chooseCategoryLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		chooseCategoryLabel.setBounds(12, 52, 149, 15);
		orderPanel.add(chooseCategoryLabel);

		categoryComboBox = new JComboBox<String>();
		categoryComboBox.setBounds(166, 47, 192, 24);
		categoryComboBox.setSelectedIndex(-1);
		orderPanel.add(categoryComboBox);

		sendOrderButton = new JButton("SEND ORDER");
		sendOrderButton.setFont(new Font("Dialog", Font.BOLD, 11));
		sendOrderButton.setBackground(Color.LIGHT_GRAY);
		sendOrderButton.setBounds(723, 412, 115, 44);
		orderPanel.add(sendOrderButton);

		cancelButton = new JButton("CANCEL");
		cancelButton.setFont(new Font("Dialog", Font.BOLD, 11));
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(497, 412, 90, 44);
		orderPanel.add(cancelButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(497, 12, 341, 388);
		orderPanel.add(scrollPane);

		sendOrdersList = new JList<String>();
		sendOrdersList.setFont(new Font("Dialog", Font.BOLD, 13));
		scrollPane.setViewportView(sendOrdersList);

		updateOrderButton = new JButton("UPDATE ORDER");
		updateOrderButton.setFont(new Font("Dialog", Font.BOLD, 11));
		updateOrderButton.setBackground(Color.LIGHT_GRAY);
		updateOrderButton.setBounds(590, 412, 131, 44);
		orderPanel.add(updateOrderButton);

		JScrollPane productListScrollPane = new JScrollPane();
		productListScrollPane.setBounds(46, 106, 291, 373);
		orderPanel.add(productListScrollPane);

		productsList = new JList<String>();
		productListScrollPane.setViewportView(productsList);

		minusButton = new JButton("-");
		minusButton.setFont(new Font("Dialog", Font.BOLD, 18));
		minusButton.setBackground(Color.LIGHT_GRAY);
		minusButton.setBounds(723, 460, 54, 44);
		orderPanel.add(minusButton);

		plusButton = new JButton("+");
		plusButton.setFont(new Font("Dialog", Font.BOLD, 18));
		plusButton.setBackground(Color.LIGHT_GRAY);
		plusButton.setBounds(784, 460, 54, 44);
		orderPanel.add(plusButton);
		waiterFrame.setVisible(true);
	}

	public void tableNameComboBoxItems(String items) {
		tableNameComboBox.addItem(items);
	}

	public void categoryComboBoxItems(String items) {
		categoryComboBox.addItem(items);
	}

	public void categoryComboBoxItemListener(ItemListener itemListener) {
		categoryComboBox.addItemListener(itemListener);
	}

	public String getCategoryName() {
		return (String) categoryComboBox.getSelectedItem();
	}

	public String getTableName() {
		return (String) tableNameComboBox.getSelectedItem();
	}

	public void setOrderListModel(ListModel<String> defaultListModel) {
		sendOrdersList.setModel(defaultListModel);
	}

	public void setProductsListModel(DefaultListModel<String> defaultListModel) {
		productsList.setModel(defaultListModel);
	}

	public void productsListSelectionListener(ListSelectionListener listener) {
		productsList.addListSelectionListener(listener);
	}

	public String getProductsFromList() {
		return productsList.getSelectedValue();
	}

	public void setCost(String cost) {
		totalCostField.setText(cost);
	}

	public String getCost() {
		return totalCostField.getText();
	}

	public void sendOrderButtonListener(ActionListener actionListener) {
		sendOrderButton.addActionListener(actionListener);
	}

	public void updateOrderButtonListener(ActionListener actionListener) {
		updateOrderButton.addActionListener(actionListener);
	}

	public void cancelButtonListener(ActionListener actionListener) {
		cancelButton.addActionListener(actionListener);
	}

	public void plusButtonListener(ActionListener actionListener) {
		plusButton.addActionListener(actionListener);
	}

	public void minusButtonListener(ActionListener actionListener) {
		minusButton.addActionListener(actionListener);
	}

	public void tableNameComboBoxListener(ItemListener itemListener) {
		tableNameComboBox.addItemListener(itemListener);
	}

	public void dispose() {
		waiterFrame.dispose();
	}
}
