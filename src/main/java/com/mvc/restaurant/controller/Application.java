package com.mvc.restaurant.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mvc.restaurant.model.domain.impl.Employee;
import com.mvc.restaurant.model.domain.impl.Expense;
import com.mvc.restaurant.model.domain.impl.Order;
import com.mvc.restaurant.model.domain.impl.Product;
import com.mvc.restaurant.model.domain.impl.ProductCategory;
import com.mvc.restaurant.model.domain.impl.RestaurantTable;
import com.mvc.restaurant.model.domain.impl.User;
import com.mvc.restaurant.model.repo.impl.EmployeeRepo;
import com.mvc.restaurant.model.repo.impl.ExpenseRepo;
import com.mvc.restaurant.model.repo.impl.OrderRepo;
import com.mvc.restaurant.model.repo.impl.ProductCategoryRepo;
import com.mvc.restaurant.model.repo.impl.ProductRepo;
import com.mvc.restaurant.model.repo.impl.TableRepo;
import com.mvc.restaurant.model.repo.impl.UserRepo;
import com.mvc.restaurant.view.TableDataMaker;
import com.mvc.restaurant.view.WaiterFrame;
import com.mvc.restaurant.view.CashierFrame;
import com.mvc.restaurant.view.LoginScreenFrame;
import com.mvc.restaurant.view.ManagerFrame;

public class Application {

	private final LoginScreenFrame loginScreenFrame = new LoginScreenFrame();
	private final ManagerFrame managerFrame = new ManagerFrame();
	private final WaiterFrame waiterFrame = new WaiterFrame();
	private final CashierFrame cashierFrame = new CashierFrame();
	private final EmployeeRepo employeeRepo = new EmployeeRepo();
	private final ProductCategoryRepo productCategoryRepo = new ProductCategoryRepo();
	private final ProductRepo productRepo = new ProductRepo();
	private final TableRepo tableRepo = new TableRepo();
	private final UserRepo userRepo = new UserRepo();
	private final OrderRepo orderRepo = new OrderRepo();
	private final ExpenseRepo expenseRepo = new ExpenseRepo();
	private boolean result;

	public Application() {
	}

	public void start() {
		loginScreenFrame.initialize();
		loginScreenFrame.loginButtonAction(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int userRole = LoginHelper.checkLogin(loginScreenFrame.getUserName(), loginScreenFrame.getPassword());
				if (loginScreenFrame.getUserName().equals("aa") && loginScreenFrame.getPassword().equals("aa")) {
					managerFrame.initialize();
					getManagerFrameMethods();
				} else if (userRole == 1) {
					waiterFrame.initialize();
					getWaiterFrameMethods();
				} else if (userRole == 2) {
					cashierFrame.initialize();
					getCashierFrameMethods();
				}
			}
		});

	}

	private void getManagerFrameMethods() {
		// Add employees.
		managerFrame.addEmployeeButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Employee employee = new Employee();
				employee.setFirstName(managerFrame.getFirstName());
				employee.setLastName(managerFrame.getLastName());
				employee.setPhoneNumber(managerFrame.getPhoneNumber());
				employee.setSalary(managerFrame.getSalary());
				employee.setHireDate(new Date());
				result = employeeRepo.save(employee);
				ManagerFrame.setInformation(result ? "Succesfully saved" : "Error!");
			}
		});
		// Update employees.
		managerFrame.updateEmployeeButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Employee employee = employeeRepo.findById(managerFrame.getEmployeeId());
				employee.setFirstName(managerFrame.getFirstName());
				employee.setLastName(managerFrame.getLastName());
				employee.setPhoneNumber(managerFrame.getPhoneNumber());
				employee.setSalary(managerFrame.getSalary());
				employee.setHireDate(new Date());
				result = employeeRepo.update(employee);
				ManagerFrame.setInformation(result ? "Succesfully updated" : "Error!");
			}
		});
		// Delete employees.
		managerFrame.deleteEmployeeButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Employee employee = employeeRepo.findById(managerFrame.getEmployeeId());
				result = employeeRepo.delete(employee);
				ManagerFrame.setInformation(result ? "Succesfully deleted" : "Error!");
			}
		});
		// Show employees.
		managerFrame.showEmployeesButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				TableDataMaker tableDataMaker = new TableDataMaker("EMPLOYEES");
				try {
					managerFrame.setShowEmployeTableModel(tableDataMaker.getTableDataModel());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		// Add product categories.
		managerFrame.addProductCategoryListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProductCategory productCategory = new ProductCategory();
				productCategory.setCategoryName(managerFrame.getProductCategoryName());
				productCategoryRepo.save(productCategory);
			}
		});
		// Show products categories
		managerFrame.showProductCategoryButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				TableDataMaker tableDataMaker = new TableDataMaker("PRODUCT_CATEGORY");
				try {
					managerFrame.setShowProductCategoryTableModel(tableDataMaker.getTableDataModel());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		// Add products.
		managerFrame.addProductButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Product product = new Product();
				product.setProductName(managerFrame.getProductName());
				product.setPrice(managerFrame.getProductPrice());
				product.setCategory(productCategoryRepo.findById(managerFrame.getProductCategoryID()));
				productRepo.save(product);
			}
		});
		// Update products.
		managerFrame.updateProductButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Product product = productRepo.findById(managerFrame.getProductID());
				product.setPrice(managerFrame.getProductPrice());
				product.setProductName(managerFrame.getProductName());
				product.setCategory(productCategoryRepo.findById(managerFrame.getProductCategoryID()));
				productRepo.update(product);
			}
		});
		// Delete products.
		managerFrame.deleteProductButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Product product = productRepo.findById(managerFrame.getProductID());
				productRepo.delete(product);
			}
		});
		// Show products.
		managerFrame.showProductsButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TableDataMaker tableDataMaker = new TableDataMaker("PRODUCTS");
				try {
					managerFrame.setShowProductsTableModel(tableDataMaker.getTableDataModel());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		// Add tables.
		managerFrame.addTableButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				RestaurantTable restaurantTable = new RestaurantTable();
				restaurantTable.setTableName(managerFrame.getTableName());
				tableRepo.save(restaurantTable);
			}
		});
		// Update tables.
		managerFrame.updateTableButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				RestaurantTable restaurantTable = tableRepo.findById(managerFrame.getTableID());
				restaurantTable.setTableName(managerFrame.getTableName());
				tableRepo.update(restaurantTable);
			}
		});
		// Delete tables.
		managerFrame.deleteTableButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				RestaurantTable restaurantTable = tableRepo.findById(managerFrame.getTableID());
				tableRepo.delete(restaurantTable);
			}
		});
		// Show tables.
		managerFrame.showTablesButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				TableDataMaker tableDataMaker = new TableDataMaker("TABLES");
				try {
					managerFrame.setShowTablesTableModel(tableDataMaker.getTableDataModel());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		// Add users.
		managerFrame.addUserButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setUserName(managerFrame.getUsername());
				user.setPassword(managerFrame.getUserPassword());
				user.setUserRole(managerFrame.getUserRole());
				userRepo.save(user);
			}
		});
		// Update users.
		managerFrame.updateUserButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				User user = userRepo.findById(managerFrame.getUserID());
				user.setUserName(managerFrame.getUsername());
				user.setPassword(managerFrame.getUserPassword());
				user.setUserRole(managerFrame.getUserRole());
				userRepo.update(user);
			}
		});
		// Delete users.
		managerFrame.deleteUserButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				User user = userRepo.findById(managerFrame.getUserID());
				userRepo.delete(user);
			}
		});
		// Show users.
		managerFrame.showUsersButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TableDataMaker tableDataMaker = new TableDataMaker("USERS");
				try {
					managerFrame.setShowUsersTableModel(tableDataMaker.getTableDataModel());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void getWaiterFrameMethods() {
		DefaultListModel<String> orderListModel = new DefaultListModel<>();
		waiterFrame.setOrderListModel(orderListModel);
		// Get table names.
		{
			TableDataMaker tableDataMaker = new TableDataMaker("TABLES");
			List<String> tableNameList = tableDataMaker.getTableName();
			for (int i = 0; i < tableNameList.size(); i++) {
				waiterFrame.tableNameComboBoxItems(tableNameList.get(i));
			}
		}
		// Get category names.
		{
			TableDataMaker tableDataMaker = new TableDataMaker("PRODUCT_CATEGORY");
			List<String> categoryNameList = tableDataMaker.getCategoryName();
			for (int i = 0; i < categoryNameList.size(); i++) {
				waiterFrame.categoryComboBoxItems(categoryNameList.get(i));
			}
		}
		// Get product list.
		{
			waiterFrame.categoryComboBoxItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						waiterFrame
								.setProductsListModel(TableDataMaker.getListDataModel(waiterFrame.getCategoryName()));
					}
				}
			});
		}
		// Set products to order list.
		{
			waiterFrame.productsListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					if (!waiterFrame.productsList.getValueIsAdjusting()) {
						if (!waiterFrame.productsList.isSelectionEmpty()) {
							orderListModel.addElement(waiterFrame.getProductsFromList());
							// Set orders total cost.
							{
								int cost = TableDataMaker.getProductPrice(waiterFrame.productsList.getSelectedValue());
								cost += Integer.parseInt(waiterFrame.getCost());
								waiterFrame.setCost(String.valueOf(cost));
							}
						}
					}
				}
			});
		}
		// Dispose the frame.
		{
			waiterFrame.cancelButtonListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					waiterFrame.dispose();
				}
			});
		}
		// Send orders.
		{
			waiterFrame.sendOrderButtonListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					List<String> orderList = new ArrayList<>();
					for (int i = 0; i < waiterFrame.sendOrdersList.getModel().getSize(); i++)
						orderList.add(waiterFrame.sendOrdersList.getModel().getElementAt(i));
					Order order = new Order();
					order.setCost(Integer.parseInt(waiterFrame.getCost()));
					order.setOrderList(orderList);
					order.setTableID(TableDataMaker.getTableID(waiterFrame.getTableName()));
					order.setOrderDate(new Date());
					orderRepo.save(order);
				}
			});
		}
		// Get table orders.
		{
			waiterFrame.tableNameComboBoxListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					orderListModel.removeAllElements();
					for (int i = 0; i < TableDataMaker.getTableOrders(waiterFrame.getTableName()).size(); i++)
						orderListModel.addElement(TableDataMaker.getTableOrders(waiterFrame.getTableName()).get(i));
					waiterFrame.setCost(String.valueOf(TableDataMaker.getTableTotalCost(waiterFrame.getTableName())));
				}
			});
		}
		// Update orders.
		{
			waiterFrame.updateOrderButtonListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Order order = orderRepo.findById(TableDataMaker.getOrderID(waiterFrame.getTableName()));
					List<String> orderList = new ArrayList<>();
					for (int i = 0; i < waiterFrame.sendOrdersList.getModel().getSize(); i++)
						orderList.add(waiterFrame.sendOrdersList.getModel().getElementAt(i));
					order.setCost(Integer.parseInt(waiterFrame.getCost()));
					order.setOrderList(orderList);
					orderRepo.update(order);
				}
			});
		}
		// Add more selected items to the order list.
		{
			waiterFrame.plusButtonListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					orderListModel.addElement(waiterFrame.sendOrdersList.getSelectedValue());
					// Set orders total cost.
					{
						int cost = TableDataMaker.getProductPrice(orderListModel.lastElement());
						cost += Integer.parseInt(waiterFrame.getCost());
						waiterFrame.setCost(String.valueOf(cost));
					}
				}
			});
		}
		// Remove items from the order list.
		{
			waiterFrame.minusButtonListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int elementIndex = waiterFrame.sendOrdersList.getSelectedIndex();
					// Set orders total cost.
					{
						int cost = TableDataMaker.getProductPrice(orderListModel.getElementAt(elementIndex));
						int lastCost = Integer.parseInt(waiterFrame.getCost()) - cost;
						waiterFrame.setCost(String.valueOf(lastCost));
					}
					orderListModel.removeElementAt(elementIndex);
				}
			});
		}
	}

	private void getCashierFrameMethods() {
		// Get table names.
		{
			TableDataMaker tableDataMaker = new TableDataMaker("TABLES");
			List<String> tableNames = tableDataMaker.getTableName();
			for (int i = 0; i < tableNames.size(); i++)
				cashierFrame.chooseTableNameItems(tableNames.get(i));
		}
		// Get table orders.
		{
			DefaultListModel<String> tableOrdersListModel = new DefaultListModel<>();
			cashierFrame.chooseTableComboBoxListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					tableOrdersListModel.removeAllElements();
					for (int i = 0; i < TableDataMaker.getTableOrders(cashierFrame.getTableName()).size(); i++)
						tableOrdersListModel
								.addElement(TableDataMaker.getTableOrders(cashierFrame.getTableName()).get(i));
					cashierFrame.setOrdersListModel(tableOrdersListModel);
					cashierFrame.setTotalCost(
							String.valueOf(TableDataMaker.getTableTotalCost(cashierFrame.getTableName())));
				}
			});
		}
		// Dispose the frame.
		{
			cashierFrame.cancelButtonListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					cashierFrame.dispose();
				}
			});
		}
		// Set table's payment.
		{
			cashierFrame.paymentButtonListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Order order = orderRepo.findById(TableDataMaker.getOrderID(cashierFrame.getTableName()));
					order.setPaid(true);
					orderRepo.update(order);
				}
			});
		}
		// Add expenses.
		{
			cashierFrame.addExpenseButtonListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Expense expense = new Expense();
					expense.setDesctription(cashierFrame.getExpenseDescription());
					expense.setExpenditureDate(new Date());
					expense.setSpendingAmount(cashierFrame.getSpendingAmount());
					expenseRepo.save(expense);
				}
			});
		}
	}
}