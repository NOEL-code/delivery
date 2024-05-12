package org.example.store.member;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    Map<String, Member> members = new HashMap<>();


    public void save(Member member) {
        members.put(member.getUserId(), member);
    }

    public Member findById(Long id) {
        return members.get(id);
    }


}
