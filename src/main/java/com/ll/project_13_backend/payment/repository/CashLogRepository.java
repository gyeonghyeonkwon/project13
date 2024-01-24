package com.ll.project_13_backend.payment.repository;

import com.ll.project_13_backend.payment.entity.CashLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashLogRepository extends JpaRepository<CashLog , Long>  {
}
