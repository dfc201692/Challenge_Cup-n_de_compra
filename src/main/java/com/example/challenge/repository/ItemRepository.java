package com.example.challenge.repository;

import com.example.challenge.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM item ORDER BY favorite_count DESC LIMIT ?1", nativeQuery = true)
    List<Item> findTopFavoriteItems(int limit);
}
