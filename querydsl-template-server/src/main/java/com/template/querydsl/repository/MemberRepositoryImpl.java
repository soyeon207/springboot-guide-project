package com.template.querydsl.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.template.querydsl.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.template.querydsl.entity.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    final JPAQueryFactory jpaQueryFactory;

    @Override
    public Member findByName(String name) {
        return jpaQueryFactory
                .selectFrom(member)
                .fetchFirst();
    }

}