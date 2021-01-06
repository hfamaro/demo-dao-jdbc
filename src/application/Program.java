package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
					
		SellerDao  sd = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1 Seller.FindById ===");
		System.out.println();
		Seller seller2 = sd.findById(3);		
		System.out.println(seller2);
		System.out.println();
		System.out.println("=== TEST 2 Seller.findByDepartment ===");
		System.out.println();
		Department dep = new Department(2, null);
		List<Seller> list = sd.findByDepartment(dep);
		
		for (Seller seller : list) {
			System.out.println(seller);
		}
		
		System.out.println();
		System.out.println("=== TEST 3 Seller.FindAll ===");
		System.out.println();
		
		list = sd.findAll();
		
		for (Seller seller : list) {
			System.out.println(seller);
		}

	}

}
