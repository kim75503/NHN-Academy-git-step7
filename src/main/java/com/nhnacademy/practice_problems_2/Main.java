package com.nhnacademy.practice_problems_2;

import com.nhnacademy.Summary.Category;
public class Main {
    public static void main(String[] args) {
        /*
        ####문제 2: 다음 실행 결과가 나오도록 코드를 작성하세요.

        요구사항:

        Category enum과 switch문을 사용합니다
        Category.STUDY를 변수에 저장합니다
        switch문으로 카테고리에 따라 한글 이름을 출력합니다
        WORK → "업무", STUDY → "학습", 그 외 → "기타"
        실행 결과:

        학습
        // Category enum 정의 (WORK, STUDY, PERSONAL, HEALTH, OTHER)

        public class Main {
            public static void main(String[] args) {
                // 여기에 코드를 작성하세요
            }
        }
        */

        Category cat = Category.STUDY;

        switch(cat){
            case WORK:
                System.out.println("업무");
                break;
            case STUDY:
                System.out.println("학습");
                break;
            default:
                System.out.println("기타");
        }

    }
}
