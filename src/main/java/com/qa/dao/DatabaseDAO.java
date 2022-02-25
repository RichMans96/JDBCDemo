package com.qa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.config.DatabaseConfig;
import com.qa.models.Student;

public class DatabaseDAO {

	private Statement statement;
	private Connection connect;

	public DatabaseDAO() throws SQLException {
		this.connect = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USERNAME,
				DatabaseConfig.PASSWORD);
		this.statement = connect.createStatement();
	}

	// CREATE
	public void createStudent(String sname, String address, int age, int phoneNum) {
		String sql = String.format("INSERT INTO students(`student_name`, `address`, `age`, `phone_number`)"
				+ " VALUES ('%s', '%s', '%d', '%d')", sname, address, age, phoneNum);
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// READ
	public void readAllFromDatabase() {
		String sql = "SELECT * FROM students";
		try {
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				System.out
						.println("ID: " + res.getInt("st_id") + " " + "Student Name: " + res.getString("student_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readByIdNoReturn(int id) {
		String sql = "SELECT * FROM students WHERE st_id=" + id;

		try {
			ResultSet res = statement.executeQuery(sql);
			res.next();
			System.out.println("ID: " + res.getInt("st_id") + " " + "Student Name: " + res.getString("student_name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Student findById(int id) {
		String sql = "SELECT * FROM students WHERE st_id=" + id;
		Student foundStudent = new Student();
		try {
			ResultSet res = statement.executeQuery(sql);
			res.next();
			foundStudent.setName(res.getString("student_name"));
			foundStudent.setAddress(res.getString("address"));
			foundStudent.setAge(res.getInt("age"));
			foundStudent.setPhoneNo(res.getInt("phone_number"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return foundStudent;
	}

	// Update
	public void updateStudent(int id, String name, String address, int age, int phoneNo) {

		// search for the student using the id -> findById(int id)
		Student found = findById(id);

		if (found.getName() == null) {
			System.out.println("Doesn't exist");
		} else {
			String sql = String.format(
					"UPDATE students SET student_name='%s', address='%s', age='%d', phone_number='%d' WHERE st_id='%d'",
					name, address, age, phoneNo, id);
			try {
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	}

	// Delete
	public void deleteStudent(int id) {
		String sql = "DELETE FROM students WHERE st_id = " + id;

		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
