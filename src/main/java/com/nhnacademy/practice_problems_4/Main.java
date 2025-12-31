package com.nhnacademy.practice_problems_4;

import com.nhnacademy.Summary.Category;

public class Main {
    public static void main(String[] args) {
        /*
        ###연습: enum에 필드와 메서드 추가
        ####문제 4: 다음 실행 결과가 나오도록 코드를 작성하세요.

        요구사항:

        Category enum을 정의합니다
        상수: WORK, STUDY, PERSONAL
        각 상수에 한글 표시명(displayName)을 저장합니다
        WORK="업무", STUDY="학습", PERSONAL="개인"
        getDisplayName() 메서드로 한글명을 반환합니다
        실행 결과:

        업무
        학습
        // 여기에 Category enum을 정의하세요

        public class Main {
            public static void main(String[] args) {
                Category c1 = Category.WORK;
                Category c2 = Category.STUDY;
                System.out.println(c1.getDisplayName());
                System.out.println(c2.getDisplayName());
    }
}
         */

        Category c1 = Category.WORK;
        Category c2 = Category.STUDY;
        System.out.println(c1.getDisplayName());
        System.out.println(c2.getDisplayName());
        
    }
}
