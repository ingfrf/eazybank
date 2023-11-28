package com.enmivida.eazybank.repository;

import com.enmivida.eazybank.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Integer> {
    Accounts findByCustomerId(int customerId);
}
