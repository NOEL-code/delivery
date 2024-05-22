package org.example.store.member;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member join(Member member) {
        return memberRepository.save(member);
    }

    public Optional<Member> findById(String id) {
        return memberRepository.findByUserId(id);
    }

}
