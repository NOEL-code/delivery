package org.example.store.member;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    Map<String, Member> members = new HashMap<>();


    public Member save(Member member) {
        members.put(member.getUserId(), member);
        return members.get(member.getUserId());
    }

    public Member findById(String id) {
        return members.get(id);
    }
}
