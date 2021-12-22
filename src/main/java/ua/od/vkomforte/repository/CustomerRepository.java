package ua.od.vkomforte.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.od.vkomforte.domain.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Pageable pageableAndSortAscByFirstName = PageRequest.of(0, 10, Sort.by("firstName").ascending());
    Pageable pageableAndSortAscByLastName = PageRequest.of(0, 10, Sort.by("lastName").ascending());
    Pageable pageableAndSortAscByPhone = PageRequest.of(0, 10, Sort.by("phone").ascending());

    List<Customer> findByFirstName(String getFirstName, Pageable pageable);

    List<Customer> findByLastName(String lastName, Pageable pageable);

    List<Customer> findByPhone(String phone, Pageable pageable);

    @Modifying
    @Query("update Customer c set c.phone = ?1 where c.id = ?2")
    @Transactional
    void changeCustomerPhone(String phone, Long id);


}
