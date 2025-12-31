package com.nhnacademy.Summary;

public class Main 
{
    public static void main( String[] args )
    {
        Category cat = Category.WORK;

        // switch와 함께 사용
        switch (cat) {
            case WORK:
                System.out.println("업무");
                break;
            case STUDY:
                System.out.println("학습");
                break;
            // ...

            
}
        
        System.out.println( "Hello World!" );
    }
}
/* 
enum Category {
    WORK,      // 업무
    STUDY,     // 학습
    PERSONAL,  // 개인
    HEALTH,    // 건강
    OTHER      // 기타
}
 */