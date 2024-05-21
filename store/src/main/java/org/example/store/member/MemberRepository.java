package org.example.store.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Member save(Member member) {
        em.persist(member);
        return findById(member.getId());
    }

    public Member findByUserId(String id) {
        return em.find(Member.class, id);
    }
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }
}
