package com.accenture.lkm.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.bean.PizzaBean;
import com.accenture.lkm.bean.PizzaOrderBean;
import com.accenture.lkm.dao.PizzaDAOWrapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/root-config.xml"})
@Transactional
public class PizzaDAOWrapperTest {
	
  @Autowired
  private PizzaDAOWrapper pizzaDAOWrapper;
	/**
	 * 	
	 * To-Do Item 1.21: This method tests the findAllPizzaDetails functionality in PizzaDAOWrapper
       by retrieving a list of pizza details from the database.
       TODO: Implement the testFindAllPizzaDetails method:
            --It should invoke the findAllPizzaDetails method of pizzaDAOWrapper.
            --It should verify that the returned list of PizzaBean objects is not empty
	 */
  @Test
  public void testFindAllPizzaDetails() throws Exception {   
	  
	  List<PizzaBean> pizzaBean=pizzaDAOWrapper.findAllPizzaDetails();
	  assertFalse(pizzaBean.isEmpty());
	  
     
  }
  
  /**
	 * 	
	 * To-Do Item 1.22: This method tests the addPizzaOrderDetails functionality in PizzaDAOWrapper
       by adding a new pizza order to the database.
       TODO: Implement the testAddPizzaOrderDetails method:
          --Create a new instance of PizzaOrderBean and set its properties with dummy data.
          --Invoke the addPizzaOrderDetails method of pizzaDAOWrapper
          --Verify that the pizza order has been successfully added.
          --Verify that the order has been assigned an OrderId.
	 */ 
@Test
public void testAddPizzaOrderDetails() throws Exception {
	
	PizzaOrderBean pizzaOrderBean=new PizzaOrderBean();
	pizzaOrderBean.setContactNumber("8929330397");
	pizzaOrderBean.setBill(600.0);
	pizzaOrderBean.setCustomerName("Raju");
	pizzaOrderBean.setNumberOfPiecesOrdered(3);
	pizzaOrderBean.setOrderId(54);
	pizzaOrderBean.setPizzaId(1001);
	
   PizzaOrderBean pizzaOrderBean2= pizzaDAOWrapper.addPizzaOrderDetails(pizzaOrderBean);
   assertNotNull(pizzaOrderBean2);
}

/**
 	
  To-Do Item 1.23: This method tests the getPizzaPrice functionality in PizzaDAOWrapper
   by retrieving the price of a pizza from the database.
   TODO: Implement the testGetPizzaPrice method:
      --Set a valid pizzaId that exists in the database.
      --Set the expected price of the pizza
      --Invoke the getPizzaPrice method of pizzaDAOWrapper
      --Verify that the actual price returned is non-negative.
      --Verify that the actual price matches the expected price.
 */ 
@Test
public void testGetPizzaPrice() throws Exception {
	
   
 }

/**
 	
  To-Do Item 1.24: This method tests the getOrderDetails functionality in PizzaDAOWrapper
   by retrieving pizza orders within a specified bill range from the database..
   TODO: Implement the testGetOrderDetails method:
      --Prepare test data by setting valid fromBill and toBill values that exists in database.
      --Invoke the getOrderDetails method of pizzaDAOWrapper, passing the fromBill and toBill.
      --Verify that PizzaOrder exists within the bill range.
      --Iterate through each PizzaOrderBean object in the list and verify that.
 */ 
@Test
public void testGetOrderDetails() throws Exception {
	List<PizzaOrderBean>pizzaOrderBeans= pizzaDAOWrapper.getOrderDetails(100.0, 1000.0);
	for(PizzaOrderBean bean: pizzaOrderBeans) {
		assertNotNull(bean);
	}
   
	}
}



	


