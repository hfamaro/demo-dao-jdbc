package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
					
		SellerDao  sd = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1 Seller.FindById ===");
		System.out.println();
		Seller seller2 = sd.findById(3);		
		System.out.println(seller2);

	}

}
