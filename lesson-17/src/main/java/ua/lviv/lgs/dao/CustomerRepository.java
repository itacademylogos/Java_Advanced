package ua.lviv.lgs.dao;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.lviv.lgs.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long>{

	List<Customer> findByEmail(String email);
	
	List<Customer> findByDate(Date date);
		
}
