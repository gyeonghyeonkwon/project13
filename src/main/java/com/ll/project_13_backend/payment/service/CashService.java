package com.ll.project_13_backend.payment.service;

import com.ll.project_13_backend.global.BaseEntity;
import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.payment.entity.CashLog;

import java.math.BigDecimal;

public interface CashService {

    CashLog addCash(Member member, BigDecimal price, CashLog.EvenType eventType, BaseEntity relEntity) ;
}
