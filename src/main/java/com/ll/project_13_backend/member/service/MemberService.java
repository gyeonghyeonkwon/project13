package com.ll.project_13_backend.member.service;

import com.ll.project_13_backend.global.BaseEntity;
import com.ll.project_13_backend.global.Rsdata.RsData;
import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.member.repository.MemberRepository;
import com.ll.project_13_backend.payment.entity.CashLog;
import com.ll.project_13_backend.payment.service.CashService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final CashService cashService;

    @Transactional
    public RsData<Member> join(String username, String password) {

        Member member = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();

        memberRepository.save(member);

        return RsData.of("200", "회원가입 성공", member);

    }
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public void addCash(Member member, BigDecimal price, CashLog.EvenType evenType , BaseEntity relEntity) {
        CashLog cashLog = cashService.addCash(member, price, evenType, relEntity);

    }
}
