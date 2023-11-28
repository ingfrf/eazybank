package com.enmivida.eazybank.repository;

import com.enmivida.eazybank.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Integer> {
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
