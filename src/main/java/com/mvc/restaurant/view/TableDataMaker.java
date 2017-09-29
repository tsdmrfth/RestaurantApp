package com.mvc.restaurant.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import com.mvc.restaurant.model.util.DBUtil;

public class TableDataMaker {

	// This field is for getting entity data by database table name.
	private final String DBTableName;

	public TableDataMaker(String DBTableName) {
		this.DBTableName = DBTableName;
	}

	// Get entity data from database to set table.
	public DefaultTableModel getTableDataModel() throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		try (Connection connection = DBUtil.openDBConnection()) {
			String query = "SELECT * FROM " + DBTableName;
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					int columns = resultSet.getMetaData().getColumnCount();
					for (int i = 1; i <= columns; i++)
						tableModel.addColumn(resultSet.getMetaData().getColumnName(i));
					while (resultSet.next()) {
						Object[] tableRows = new Object[columns];
						for (int i = 1; i <= columns; i++)
							tableRows[i - 1] = resultSet.getObject(i);
						tableModel.addRow(tableRows);
					}
					resultSet.close();
				}
				preparedStatement.close();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}

	// Get table names from database.
	public List<String> getTableName() {
		List<String> tableNames = new ArrayList<>();
		try (Connection connection = DBUtil.openDBConnection()) {
			String query = "SELECT TABLE_NAME FROM " + DBTableName;
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					int columns = resultSet.getMetaData().getColumnCount();
					while (resultSet.next()) {
						for (int i = 1; i <= columns; i++)
							tableNames.add((String) resultSet.getObject(i));
					}
					resultSet.close();
				}
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
		}
		return tableNames;
	}

	// Get category names to set products.
	public List<String> getCategoryName() {
		List<String> categoryNames = new ArrayList<>();
		try (Connection connection = DBUtil.openDBConnection()) {
			String query = "SELECT NAME FROM " + DBTableName;
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					int columns = resultSet.getMetaData().getColumnCount();
					while (resultSet.next()) {
						for (int i = 1; i <= columns; i++)
							categoryNames.add((String) resultSet.getObject(i));
					}
					resultSet.close();
				}
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
		}
		return categoryNames;
	}

	// Get product names.
	public static DefaultListModel<String> getListDataModel(String categoryName) {
		DefaultListModel<String> listModel = new DefaultListModel<>();
		try (Connection connection = DBUtil.openDBConnection()) {
			String query = "SELECT * FROM PRODUCTS INNER JOIN PRODUCT_CATEGORY ON PRODUCT_CATEGORY.ID = PRODUCTS.PRODUCT_CATEGORY AND PRODUCT_CATEGORY.NAME = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, categoryName);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						listModel.addElement(resultSet.getString("NAME"));
					}
					resultSet.close();
				}
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
		}
		return listModel;
	}

	// Get product prices to set order costs.
	public static Integer getProductPrice(String productName) {
		int price = 0;
		try (Connection connection = DBUtil.openDBConnection()) {
			String query = "SELECT PRICE FROM PRODUCTS WHERE NAME = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, productName);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						price = resultSet.getInt("PRICE");
					}
					resultSet.close();
				}
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
		}
		return price;
	}

	// Get table id for useful methods.
	public static Integer getTableID(String tableName) {
		int id = 0;
		try (Connection connection = DBUtil.openDBConnection()) {
			String query = "SELECT ID FROM TABLES WHERE TABLE_NAME = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, tableName);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						id = resultSet.getInt("ID");
					}
					resultSet.close();
				}
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
		}
		return id;
	}

	// Get unpaid order for adding or removing new orders.
	public static List<String> getTableOrders(String tableName) {
		List<String> orderList = new ArrayList<>();
		try (Connection connection = DBUtil.openDBConnection()) {
			String query = "SELECT orderList FROM ORDERS INNER JOIN Order_orderList ON ORDERS.ID = Order_orderList.Order_ID AND TABLE_ID = ? AND IS_PAID = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setInt(1, getTableID(tableName));
				preparedStatement.setBoolean(2, false);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					int columns = resultSet.getMetaData().getColumnCount();
					while (resultSet.next()) {
						for (int i = 1; i <= columns; i++)
							orderList.add(resultSet.getString(i));
					}
					resultSet.close();
				}
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
		}
		return orderList;
	}

	// Get unpaid costs.
	public static Integer getTableTotalCost(String tableName) {
		int totalCost = 0;
		try (Connection connection = DBUtil.openDBConnection()) {
			String query = "SELECT SUM(COST) FROM ORDERS WHERE TABLE_ID = ? AND IS_PAID = 0";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setInt(1, getTableID(tableName));
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						totalCost = resultSet.getInt(1);
					}
					resultSet.close();
				}
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
		}
		return totalCost;
	}

	// Get order id for useful methods.
	public static Integer getOrderID(String tableName) {
		int id = 0;
		try (Connection connection = DBUtil.openDBConnection()) {
			String query = "SELECT ID FROM ORDERS WHERE TABLE_ID = ? AND IS_PAID = 0";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setInt(1, getTableID(tableName));
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						id = resultSet.getInt(1);
					}
					resultSet.close();
				}
				preparedStatement.close();
			}
			connection.close();
		} catch (Exception e) {
		}
		return id;
	}
}
