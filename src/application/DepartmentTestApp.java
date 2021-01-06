package application;

import java.util.List;
import java.util.Scanner;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentTestApp {

	public static void main(String[] args) {
		
		DepartmentDao  dd = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1 Department.FindById ===");
		System.out.println();
		Department dep = dd.findById(1);		
		System.out.println(dep);
		System.out.println();
						
		System.out.println();
		System.out.println("=== TEST 2 Department.FindAll ===");
		System.out.println();
		
		List<Department> list = dd.findAll();
		
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println();
		System.out.println("=== TEST 3 Department.Insert ===");
		System.out.println();
		
		Department newDep = new Department(null, "Mechanic");
		
		dd.insert(newDep);
		
		System.out.println("New department inserted with key: " +  newDep.getId());
		System.out.println("New department data: " +  newDep);
		
		System.out.println();
		System.out.println("=== TEST 4 Department.Update ===");
		System.out.println();
		
		int updateId = 4;
		
		Department updateDep = dd.findById(updateId);
		
		if (updateDep != null) {
			updateDep.setName("Fiction Books");			
			
			dd.update(updateDep);
			
			System.out.println("Department "+updateId+" is updated. ");
			System.out.println("New data: "+ updateDep);
		}
		else {
			throw new DbException("Department not found!");
		}
		
		System.out.println();
		System.out.println("=== TEST 5 Department.Delete ===");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the department id: ");
		
		int id = sc.nextInt();
		
		dd.deleteById(id);
		
		System.out.println("Department deleted successfull!");
		
		sc.close();

	}

}
