package additional.persistence.dao.repositories;

import additional.persistence.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findCustomerByFirstName(String firstName);
    @Modifying
    @Query(value = "delete from Customer c where c.firstName = ?1", nativeQuery = true)
    void deleteCustomerByFirstName(String firstName);

    @Modifying
    @Query(value = "update Customer c set c.firstName = ?2, c.lastName = ?3, c.age = ?4  where c.id = ?1",
            nativeQuery = true)
    void updateCustomer(long id, String firstName, String lastName, int age);
}
