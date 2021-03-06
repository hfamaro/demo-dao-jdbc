package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DbException;
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
		
		System.out.println();
		System.out.println("=== TEST 4 Seller.Insert ===");
		System.out.println();
		
		Seller newSeller = new Seller(null, "Lucas Gabriel", "lucas.amaro@gmail.com", new Date(), 15000.00, new Department(3,null));
		
		sd.insert(newSeller);
		
		System.out.println("New seller inserted with key: " +  newSeller.getId());
		System.out.println("New seller data: " +  newSeller);
		
		System.out.println();
		System.out.println("=== TEST 5 Seller.Insert ===");
		System.out.println();
		
		int updateId = 19;
		
		Seller updateSeller = sd.findById(updateId);
		
		if (updateSeller != null) {
			updateSeller.setName("Arthur Felipe");
			updateSeller.setEmail("arthur.felipe@gmail.com");
			
			sd.update(updateSeller);
			
			System.out.println("Seller "+updateId+" is updated. ");
			System.out.println("New data: "+ updateSeller);
		}
		else {
			throw new DbException("Seller not found!");
		}
		
		System.out.println();
		System.out.println("=== TEST 6 Seller.Delete ===");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the seller id: ");
		
		int id = sc.nextInt();
		
		sd.deleteById(id);
		
		System.out.println("Seller deleted successfull!");
		
		sc.close();
	}

}
