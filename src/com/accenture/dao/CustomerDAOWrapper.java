package com.accenture.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.bean.Customer;
import com.accenture.entity.CustomerEntityBean;

@Repository
public class CustomerDAOWrapper {
	
	@Autowired
	private CustomerDAO dao;
	
	public List<Customer>findAll(){
		List<Customer> list = new ArrayList<Customer>(); 
		
		Iterable<CustomerEntityBean> listEn= dao.findAll();
		for (CustomerEntityBean x : listEn) {
			Customer customer = new Customer();
			BeanUtils.copyProperties(x, customer);
			list.add(customer);
		}
		/*listEn.forEach(x->{
			Employee employee = new Employee();
			BeanUtils.copyProperties(x, employee);
			list.add(employee);
		});*/
		return list;
	}
	
	public Customer findOne(Integer id){ 
	    CustomerEntityBean x= dao.findOne(id);
	    Customer customer =null;
	    if(x!=null){
	    	customer = new Customer();		
			BeanUtils.copyProperties(x, customer);
	    }
	return customer;
}
	
	public Integer saveCustomer(Customer customer){
		CustomerEntityBean customerEntityBean = new CustomerEntityBean();
		BeanUtils.copyProperties(customer, customerEntityBean);
		CustomerEntityBean cust=  dao.save(customerEntityBean);
		return cust.getCustomer_id();	
	}
	
	public Customer updateCustomer(Customer customer){
		CustomerEntityBean customerEntityBean = new CustomerEntityBean();
		BeanUtils.copyProperties(customer, customerEntityBean);
		CustomerEntityBean cust=  dao.save(customerEntityBean);
		
		Customer customer2 = new Customer();
		
		BeanUtils.copyProperties(cust,customer2);
		return customer2;	
	}
	
	public void delete(int id){
		dao.delete(id);
	}
}
