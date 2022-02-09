package additional.persistence.dao.services.implementations;

import additional.persistence.dao.repositories.CustomerRepository;
import additional.persistence.dao.services.interfaces.CustomerSimpleService;
import additional.persistence.model.Customer;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerSimpleServiceImpl implements CustomerSimpleService {
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() throws InterruptedException {
        return Lists.newArrayList(customerRepository.findAll());
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    @Override
    public void removeById(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findCustomerByFirstName(String firstName) {
        return customerRepository.findCustomerByFirstName(firstName);
    }

    @Override
    public void deleteCustomerByFirstName(String firstName) {
        customerRepository.deleteCustomerByFirstName(firstName);
    }

    @Override
    public void updateCustomer(long id, String firstName, String lastName, int age) {
        customerRepository.updateCustomer(id, firstName, lastName, age);
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
