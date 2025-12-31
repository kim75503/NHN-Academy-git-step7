package com.nhnacademy.practice_problems_10;

import com.nhnacademy.Summary.Todo;

public class Main {
    public static void main(String[] args) {
        /*
        ####문제 10: 다음 실행 결과가 나오도록 코드를 작성하세요.

        요구사항:

        Todo 클래스 (문제 9 참고)를 사용합니다
        3개의 Todo 오브젝트를 생성합니다 (공부, 운동, 독서)
        각 오브젝트의 ID를 출력합니다
        실행 결과:

        1
        2   
        3
        // 여기에 코드를 작성하세요
         */

        Todo todo1 = new Todo("공부",3, false);
        Todo todo2 = new Todo("운동",1, false);
        Todo todo3 = new Todo("독서",2, false);
        System.out.println(todo1.getId());
        System.out.println(todo2.getId());
        System.out.println(todo3.getId());



        
    }
}
