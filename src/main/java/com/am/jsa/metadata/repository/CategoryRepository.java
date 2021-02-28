package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("FROM Category WHERE id = ?1")
    Category read(long id);
}
