package com.nhnacademy.practice_problems_6;

import com.nhnacademy.Summary.Category;

public class Main {
    public static void main(String[] args) {
        /*
        ###연습: enum 메서드 (values, valueOf, ordinal)
        ####문제 6: 다음 실행 결과가 나오도록 코드를 작성하세요.

        요구사항:

        Category enum (WORK, STUDY, PERSONAL, HEALTH, OTHER)을 정의합니다
        values() 메서드로 모든 상수를 배열로 가져옵니다
        반복문으로 각 상수의 순서번호(ordinal())와 이름(name())을 출력합니다
        실행 결과:

        0: WORK
        1: STUDY
        2: PERSONAL
        3: HEALTH
        4: OTHER
        // 여기에 코드를 작성하세요
         */

        Category[] cat = Category.values();

        for(Category c : cat){
            System.out.println(c.ordinal()+": " + c.name());
        }
    }
}
