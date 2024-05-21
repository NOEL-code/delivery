package org.example.store.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    Map<String, Member> members = new HashMap<>();

    @PersistenceContext
    private final EntityManager em;

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public Member findById(String id) {
        return members.get(id);
    }
}
