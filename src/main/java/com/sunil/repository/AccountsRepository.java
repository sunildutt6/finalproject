package com.sunil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil.entity.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
	Accounts findByCustomerId(int customerId);
}
