package com.mvc.restaurant.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mvc.restaurant.model.util.DBUtil;

public final class LoginHelper {

	private LoginHelper() {
	}

	public static Integer checkLogin(String username, String password) {
		int userRole = 0;
		try (Connection connection = DBUtil.openDBConnection()) {
			String query = "SELECT USER_ROLE FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						userRole = resultSet.getInt("USER_ROLE");
					}
				}
			}
		} catch (Exception e) {
		}
		return userRole;
	}
}
