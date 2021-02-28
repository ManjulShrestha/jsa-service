package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.MerchantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantTypeRepository extends JpaRepository<MerchantType, Long> {

    @Query("FROM MerchantType WHERE id = ?1")
    MerchantType read(long id);
}
