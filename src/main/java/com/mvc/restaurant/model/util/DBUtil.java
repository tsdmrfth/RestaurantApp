package com.mvc.restaurant.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/RestaurantAppSchema";
	private static final String USER = "root";
	private static final String PASSWORD = "Line.939017.java";

	private DBUtil() {
	}

	public static Connection openDBConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
