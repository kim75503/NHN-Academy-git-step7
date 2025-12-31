package com.nhnacademy.practice_problems_1;

import com.nhnacademy.Summary.Category;

public class Main {
    public static void main(String[] args) {
        /*
        ###연습: enum 기본 개념
        ####문제 1: 다음 요구사항을 만족하는 코드를 작성하세요.

        요구사항:

        Category라는 이름의 열거형(enum)을 정의합니다
        상수: WORK, STUDY, PERSONAL, HEALTH, OTHER
        실행 결과:

        WORK
        STUDY
        // 여기에 Category enum을 정의하세요

        public class Main {
            public static void main(String[] args) {
                Category c1 = Category.WORK;
                Category c2 = Category.STUDY;
                System.out.println(c1);
                System.out.println(c2);
             }
        }
         */

        Category c1 = Category.WORK;
        Category c2 = Category.STUDY;
        System.out.println(c1);
        System.out.println(c2);
       
    }
}
