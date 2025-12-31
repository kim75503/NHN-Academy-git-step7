package com.nhnacademy.practice_problems_8;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nhnacademy.Summary.Category;


public class Main {
    public static void main(String[] args)throws IOException {
        /*
        ####문제 8: 숫자(1~5)를 입력받아 Category로 변환하는 fromNumber(int number) 메서드를 완성하세요.

        public enum Category {
            WORK("업무"),
            STUDY("학습"),
            PERSONAL("개인"),
            HEALTH("건강"),
            OTHER("기타");

            // ... 기존 코드 생략

            public static Category fromNumber(int number) {
                // 여기에 코드 작성
                // 1 → WORK, 2 → STUDY, ... 5 → OTHER
            }
        }
         */
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        System.out.println(Category.fromNumber(num));

    }
}
