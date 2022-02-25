package com.qa;

import java.sql.SQLException;

import com.qa.dao.DatabaseDAO;
import com.qa.models.Student;

public class Runner {

	public static void main(String[] args) {
		
		
		try {
			DatabaseDAO db = new DatabaseDAO();
			db.readAllFromDatabase();
//			db.createStudent("David", "15 Road Street", 100, 784321972);
			db.updateStudent(8, "Richard", "123 street", 25, 777777777);
//			db.deleteStudent(3);
			db.readAllFromDatabase();
			db.readByIdNoReturn(4);
			db.findById(2);
//			Student richard = db.findById(2);
//			System.out.println(richard.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
        
	}

}
