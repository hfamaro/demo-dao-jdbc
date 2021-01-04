package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department department = new Department(1,"Setec");
		Seller seller = new Seller(1,"Heliel","hfamaro@hotmailcom", new Date(),5000.00,department);
		
		System.out.println(department);
		System.out.println(seller);

	}

}
