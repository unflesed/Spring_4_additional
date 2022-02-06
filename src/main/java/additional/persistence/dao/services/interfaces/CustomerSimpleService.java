package additional.persistence.dao.services.interfaces;

import additional.persistence.model.Customer;

import java.util.List;

public interface CustomerSimpleService {
    List<Customer> findAll() throws InterruptedException;

    Customer addCustomer(Customer customer);

    void removeById(long id);

    List<Customer> findCustomerByFirstName(String firstName);

    void deleteCustomerByFirstName(String firstName);

    void updateCustomer(long id, String firstName, String lastName, int age);
}
