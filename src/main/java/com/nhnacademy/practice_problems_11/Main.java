package com.nhnacademy.practice_problems_11;


import com.nhnacademy.Summary.Todo;
import com.nhnacademy.Summary.Category;
import com.nhnacademy.Summary.Priority;

public class Main {
    public static void main(String[] args) {
     /*
     ###연습: enum과 Todo 통합
    ####문제 11: 다음 실행 결과가 나오도록 코드를 작성하세요.

        요구사항:

        Category enum (WORK="업무", STUDY="학습", PERSONAL="개인")을 정의합니다
        Priority enum (LOW=1, MEDIUM=2, HIGH=3)을 정의합니다
        Todo 클래스에 category와 priority 필드를 추가합니다
        Category는 getDisplayName(), Priority는 getLevel() 메서드를 가집니다
        실행 결과:

        학습
        3
        // 여기에 코드를 작성하세요
        // Category enum, Priority enum, Todo 클래스 정의

        public class Main {
            public static void main(String[] args) {
                Todo todo = new Todo("Java 공부", Category.STUDY, Priority.HIGH);
                System.out.println(todo.getCategory().getDisplayName());
                System.out.println(todo.getPriority().getLevel());
            }
        }
      */
        Todo todo = new Todo("Java 공부", Category.STUDY, Priority.HIGH);
        System.out.println(todo.getCategory().getDisplayName());
        System.out.println(todo.getPriority().getLevel());
    }
}
