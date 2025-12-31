package com.nhnacademy.practice_problems_7;

import com.nhnacademy.Summary.Category;

public class Main {
    public static void main(String[] args) {
        /*
        #### 문제 7: 다음 실행 결과가 나오도록 코드를 작성하세요.

        배경 설명: valueOf() 메서드는 문자열로 enum 상수를 찾x습니다. 단, 대소문자를 구분합니다:

        Category.valueOf("WORK") → 정상 동작
        Category.valueOf("work") → IllegalArgumentException 발생
        요구사항:

        Category enum (WORK, STUDY, PERSONAL)을 정의합니다
        valueOf() 메서드로 "STUDY" 문자열에서 enum을 찾습니다
        찾은 enum 상수를 출력합니다
        실행 결과:

        STUDY
        // 여기에 코드를 작성하세요
         */

        Category cat = Category.valueOf("STUDY");
        System.out.println(cat);

    }
}
