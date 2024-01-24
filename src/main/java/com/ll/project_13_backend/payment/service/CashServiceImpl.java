package com.ll.project_13_backend.payment.service;

import com.ll.project_13_backend.global.BaseEntity;
import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.payment.entity.CashLog;
import com.ll.project_13_backend.payment.repository.CashLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CashServiceImpl implements CashService{

    private final CashLogRepository cashLogRepository;

    @Transactional
    public CashLog addCash(Member member, BigDecimal price, CashLog.EvenType eventType, BaseEntity relEntity) {
        CashLog cashLog = CashLog.builder()
                .member(member)
                .price(price)
                .relTypeCode("Post")
                .relId(relEntity.getId())
                .eventType(eventType)
                .build();

        cashLogRepository.save(cashLog);

        return cashLog;
    }
}


