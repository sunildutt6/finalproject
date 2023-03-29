package com.sunil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil.entity.Customer;
import com.sunil.entity.Loans;

@Repository
public interface LoanRepository extends JpaRepository<Loans, Long> {

	List<Customer> findByEmail(String email);
}
