package ua.lviv.lgs.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.CustomerRepository;
import ua.lviv.lgs.domain.Customer;
import ua.lviv.lgs.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}

	@Override
	public Customer findById(Long id) {
		return customerRepository.getOne(id);
	}

	@Override
	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteById(Long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	public List<Customer> findByDate(Date date) {
		return customerRepository.findByDate(date);
	}
}
