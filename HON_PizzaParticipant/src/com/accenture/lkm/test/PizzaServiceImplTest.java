package com.accenture.lkm.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.bean.PizzaBean;
import com.accenture.lkm.bean.PizzaOrderBean;
import com.accenture.lkm.dao.PizzaDAOWrapper;
import com.accenture.lkm.exception.NoRecordFoundException;
import com.accenture.lkm.service.PizzaServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/root-config.xml"})
@Transactional
public class PizzaServiceImplTest {
	
  @Autowired
  private PizzaServiceImpl pizzaServiceImpl;
  
  /**
   * 	
   * To-Do Item 1.25: This method tests the getOrderDetailsWithRecordsFound functionality in PizzaServiceImpl
     by retrieving pizza orders within a specified bill range from the database.
     TODO: Implement the testGetOrderDetailsWithRecordsFound method:
        --Prepare test data by setting valid fromBill and toBill values that exists in database.
        --Invoke the getOrderDetails method of pizzaServiceImpl, passing the fromBill and toBill..
        --Verify that PizzaOrder exists within the bill range.
        
   */
  @Test
  public void testGetOrderDetailsWithRecordsFound() throws Exception {
	  List<PizzaOrderBean> pizzaOrderBeans=pizzaServiceImpl.getOrderDetails(100.0, 1000.0);
	  assertFalse(pizzaOrderBeans.size()==0);
	  
     
  }
  
  /**
   * 	
   * To-Do Item 1.26: This method tests the getOrderDetailsWithNoRecordsFound functionality in PizzaServiceImpl
     by retrieving pizza orders within a specified bill range from the database when no records are found.
     TODO: Implement the testGetOrderDetailsWithNoRecordsFound method:
        --Set invalid fromBill and toBill values that do not correspond to any records in the database.
        --Verify that the NoRecordFoundException is thrown when invoking the getOrderDetails method of pizzaServiceImpl.
        --Verify that the message of the thrown exception matches the expected message: "No records were found for the entered Bill Range".
        
   */

  @Test
  public void testGetOrderDetailsWithNoRecordsFound() throws Exception {
	  
	  
	  NoRecordFoundException exception= assertThrows(NoRecordFoundException.class,()->pizzaServiceImpl.getOrderDetails(14000.0, 20000.0));
	  
	  
	  assertEquals("No records were found for the entered Bill Range", exception.getMessage());
     
  }
  /**
   * 	
   * To-Do Item 1.27: This method tests the transactional behavior of adding a pizza order
     in PizzaServiceImpl by verifying that no changes are made to the database when adding a pizza order.
     TODO: Implement the testTransactionalBehavior method:
        --Prepare test data by setting valid fromBill and toBill values that exist in the database.
        --Retrieve the initial list of pizza orders using getOrderDetails method of pizzaServiceImpl.
        --Record the initial number of orders
        --Add a new pizza order using addPizzaOrderDetails method of pizzaServiceImpl.
        --Retrieve the final list of pizza orders using getOrderDetails method of pizzaServiceImpl.
        --Record the final number of orders.
        --Verify that the initial and final number of orders are equal, indicating that no changes were made to the database.
   */
  @Test
  public void testTransactionalBehavior() throws Exception {
	  List<PizzaOrderBean> pizzaOrderBeansInitial=pizzaServiceImpl.getOrderDetails(100.0, 1000.0);
	  int initial=pizzaOrderBeansInitial.size();
	  
	  PizzaOrderBean pizzaOrderBean=new PizzaOrderBean();
		pizzaOrderBean.setContactNumber("8929330397");
		pizzaOrderBean.setBill(600.0);
		pizzaOrderBean.setCustomerName("Raju");
		pizzaOrderBean.setNumberOfPiecesOrdered(3);
		pizzaOrderBean.setOrderId(54);
		pizzaOrderBean.setPizzaId(1001);
		
		PizzaOrderBean pizzaOrderBean2=pizzaServiceImpl.addPizzaOrderDetails(pizzaOrderBean);
		
		List<PizzaOrderBean> pizzaOrderBeansFinal=pizzaServiceImpl.getOrderDetails(100.0, 1000.0);
		int fin=pizzaOrderBeansFinal.size();
		
		assertNotEquals(initial, fin);
			  
	 
	 	}
  }






	


