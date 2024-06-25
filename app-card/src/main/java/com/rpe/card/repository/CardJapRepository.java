package com.rpe.card.repository;

import com.rpe.card.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardJapRepository extends JpaRepository<Card, Long> {
    List<Card> findByCustomerIdEquals(long customerId);
}
