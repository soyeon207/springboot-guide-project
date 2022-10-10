package com.template.querydsl.repository;

import com.template.querydsl.entity.Member;

public interface MemberRepositoryCustom {

    Member findByName(String name);
}