package com.mjp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjp.models.Debt;
import com.mjp.models.User;

@Repository
public interface DebtRepository extends JpaRepository<Debt,Long>{
	Optional<Debt> findByCreditorAndDebtor(User creditor, User debtor);

}
