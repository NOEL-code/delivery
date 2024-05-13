package org.example.store.member;

public class MemberDuplicatedException extends RuntimeException {
    public MemberDuplicatedException(String message) {
        super(message);
        System.out.println("MemberDuplicatedException");
    }
}
