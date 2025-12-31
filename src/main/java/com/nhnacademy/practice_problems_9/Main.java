package com.nhnacademy.practice_problems_9;

import com.nhnacademy.Summary.Todo;

public class Main {
    public static void main(String[] args) {
        /*
        ###연습: 확장된 Todo 클래스
        ####문제 9: 다음 실행 결과가 나오도록 코드를 작성하세요.

        요구사항:

        Todo 클래스를 정의합니다
        static 변수 idCounter를 사용하여 ID를 자동 생성합니다
        첫 번째 Todo는 id=1, 두 번째는 id=2, ...
        getId() 메서드로 ID를 반환합니다
        실행 결과:

        1
        2
        // 여기에 Todo 클래스를 정의하세요

        public class Main {
            public static void main(String[] args) {
                Todo todo1 = new Todo("공부");
                Todo todo2 = new Todo("운동");
                System.out.println(todo1.getId());
                System.out.println(todo2.getId());
            }
        }
        */

        Todo todo1 = new Todo("공부");
        Todo todo2 = new Todo("운동");
        System.out.println(todo1.getId());
        System.out.println(todo2.getId());

    }
}
