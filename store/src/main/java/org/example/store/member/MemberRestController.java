package org.example.store.member;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.store.utils.ApiUtils;
import org.example.store.utils.ApiUtils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/members")
public class MemberRestController {

    private final MemberService memberService;

    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    @Transactional
    public ResponseEntity<ApiResult<Object>> join(@RequestBody Member member) {
        if (member == null) {
            return ResponseEntity.badRequest().body(ApiUtils.error("Invalid member data", HttpStatus.BAD_REQUEST));
        }
//        if (checkDuplicate(member.getUserId())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiUtils.error("Member with the same ID already exists", HttpStatus.CONFLICT));
//        }
        try {

            String userId = memberService.join(member).getUserId();
            return ResponseEntity.status(HttpStatus.CREATED).body(ApiUtils.success(userId));
        } catch (Exception e) {
            log.error("Error during member join", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiUtils.error("Join failed", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResult<Object>> login(@RequestBody Member member) {
        if (member == null) {
            return ResponseEntity.badRequest().body(ApiUtils.error("Invalid member data", HttpStatus.BAD_REQUEST));
        }

        return ResponseEntity.ok(ApiUtils.success("Login successful"));
    }

    @PostMapping("/join/api/result")
    public ResponseEntity<ApiResult<Object>> joinByApiResult(@RequestBody Member member) {
        if (member == null) {
            return ResponseEntity.badRequest().body(ApiUtils.error("Invalid member data", HttpStatus.BAD_REQUEST));
        }
        log.info(member.toString());

        if (checkDuplicate(member.getUserId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiUtils.error("Duplicate user ID", HttpStatus.CONFLICT));
        }

        try {
            String userId = memberService.join(member).getUserId();
            return ResponseEntity.status(HttpStatus.CREATED).body(ApiUtils.success(userId));
        } catch (Exception e) {
            log.error("Error during member join", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiUtils.error("Join failed", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    public boolean checkDuplicate(String id) {
        return memberService.findById(id).isPresent();
    }
}