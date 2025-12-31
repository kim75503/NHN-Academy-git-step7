package com.nhnacademy.practice_problems_13;

import com.nhnacademy.Summary.Status;

public class Main {
    public static void main(String[] args) {
        /*
        ###종합 연습
        ####문제 13: 다음 요구사항을 만족하는 Status enum을 작성하세요.

        요구사항:

        상수: TODO, IN_PROGRESS, DONE
        필드: displayName (한글명)
        TODO="할 일", IN_PROGRESS="진행 중", DONE="완료"
        getter 메서드 포함

         */
        Status[] status = Status.values();
        for(Status s : status)
            System.out.println(s.getDisplayName());
    }
}
