package com.cts.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.product.config.DBConfig;
import com.cts.product.entity.Product;

public class Test {

	public static void main(String[] args) {

		// get session Factory -> for database connectivity

		SessionFactory sf = DBConfig.getSessionbFactory();

		// get Session -> for db operation

		Session ses1 = sf.openSession();
		
		// Transaction management in session

		// 1-> openSession -> new / blank session 
		// 2-> getSession -> open session which is already started by some one/operation
		
		// get transaction object -> for pointing to session objects
		
		Transaction tx=ses1.beginTransaction(); 

		// get Entity class info -> for DB operations

		Product prod = new Product();

		prod.setId(23);
		prod.setName("Watch");
		prod.setDescription("Apple Watch");
		prod.setPrice(65000);

		
		Product prod1 = new Product();

		prod1.setId(24);
		prod1.setName("Watch");
		prod1.setDescription("Samsung Watch");
		prod1.setPrice(55000);

		// CRUD operations

		// save / create object of a product

		ses1.save(prod);
		ses1.save(prod1);
		
		// save
		// update
		// saveOrUpdate
		// delete
		// evict
		// close
		
		

		// what ever objects available in ses1, commit them  to  database using tx object

		//ses1.beginTransaction().commit();
		
		tx.commit();

		System.out.println(">>>>> Done <<<<");

	}

}
