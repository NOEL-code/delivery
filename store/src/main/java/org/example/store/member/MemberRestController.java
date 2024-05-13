package org.example.store.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberRestController {

    private final MemberService memberService;

    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public ResponseEntity<Member> join(@RequestBody Member member) {
        if (member == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(memberService.join(member));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Member member) {
        if (member == null) {
            return ResponseEntity.badRequest().body("Invalid member data");
        } else {
            if (checkDuplicate(member.getUserId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Member with the same ID already exists");
            } else {
                return ResponseEntity.ok("Login successful");
            }
        }
    }

    public boolean checkDuplicate(String id) {
        return memberService.findById(id) != null;
    }
}
