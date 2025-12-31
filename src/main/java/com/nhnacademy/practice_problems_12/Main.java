package com.nhnacademy.practice_problems_12;

import com.nhnacademy.Summary.Category;

public class Main {
    public static void main(String[] args) {
        /*
        ####문제 12: 다음 실행 결과가 나오도록 코드를 작성하세요.

        요구사항:

        Category enum (WORK="업무", STUDY="학습", PERSONAL="개인", HEALTH="건강", OTHER="기타")을 정의합니다
        fromNumber(int number) 메서드를 추가합니다 (1→WORK, 2→STUDY, ...)
        숫자 2를 입력하면 STUDY를 반환합니다
        실행 결과:

        선택: 학습
        // 여기에 Category enum을 정의하세요 (fromNumber 메서드 포함)

        public class Main {
            public static void main(String[] args) {
                int num = 2;  // 사용자가 2를 입력했다고 가정
                Category category = Category.fromNumber(num);
                System.out.println("선택: " + category.getDisplayName());
            }
        }   
        */

        int num = 2;  // 사용자가 2를 입력했다고 가정
        Category category = Category.fromNumber(num);
        System.out.println("선택: " + category.getDisplayName());
    }
}
