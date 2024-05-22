package org.example.store.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;
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

    public Optional<Member> findByUserId(String userId) {

        return Optional.ofNullable(
            em.createQuery("SELECT m FROM Member m WHERE m.userId = :userId", Member.class)
                .setParameter("userId", userId)
                .getSingleResult());
    }

    public Member findById(Long id) {
        return em.find(Member.class, id);
    }
}
