package com.enmivida.eazybank.repository;

import com.enmivida.eazybank.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Integer> {
    List<Cards> findByCustomerId(int customerId);
}
