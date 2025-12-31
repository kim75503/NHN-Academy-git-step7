package com.nhnacademy.practice_problems_3;

import com.nhnacademy.Summary.Category;

public class Main {
    public static void main(String[] args) {
        /*
        ####문제 3: 다음 실행 결과가 나오도록 코드를 작성하세요.

        배경 설명: 문자열로 카테고리를 관리하면 오타가 있어도 컴파일 시 오류가 발생하지 않습니다:

        String category = "WORKK";  // 오타지만 컴파일 됨
        enum을 사용하면 존재하지 않는 값을 사용할 때 컴파일 에러가 발생합니다.

        요구사항:

        Category enum (WORK, STUDY, PERSONAL)을 정의합니다
        WORK 카테고리를 변수에 저장하고 출력합니다
        enum을 사용하여 타입 안전성을 확보합니다
         */

        Category cat = Category.WORK;
        System.out.println("카테고리: " + cat);
    }
}   
