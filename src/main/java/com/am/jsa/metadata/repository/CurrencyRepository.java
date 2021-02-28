package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    @Query("FROM Currency WHERE id = ?1")
    Currency read(long id);
}
