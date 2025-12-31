package com.nhnacademy.practice_problems_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nhnacademy.Summary.Priority;

public class Main {
    public static void main(String[] args)throws IOException {
        /*
        ####문제 14: Priority enum에 숫자로 Priority를 찾는 fromLevel(int level) 메서드를 구현하세요.

        public enum Priority {
            LOW(1, "낮음"),
            MEDIUM(2, "보통"),
            HIGH(3, "높음");

            private final int level;
            private final String displayName;

            // 생성자, getter 생략

            public static Priority fromLevel(int level) {
                // 여기에 코드 작성
                // level이 1이면 LOW, 2이면 MEDIUM, 3이면 HIGH 반환
                // 그 외의 값이면 IllegalArgumentException 발생
            }
        }
        */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int level = Integer.parseInt(reader.readLine());
        System.out.println(Priority.fromLevel(level));

    }
}
