package com.nhnacademy.Summary;

import java.io.BufferedReader;
import java.io.IOException;

public enum Category {
    WORK("업무"),
    STUDY("학습"),
    PERSONAL("개인"),
    HEALTH("건강"),
    OTHER("기타");

    private final String displayName;  // 한글 표시명

    // 생성자 (private만 가능)
    Category(String displayName) {
        this.displayName = displayName;
    }

    // Getter
    public String getDisplayName() {
        return displayName;
    }

    // 숫자로 enum 찾기 (1부터 시작)
    public static Category fromNumber(int number) {
        if (number < 1 || number > values().length) {
            throw new IllegalArgumentException("잘못된 구분 번호: " + number);
        }
        return values()[number - 1];
    }

    private Category readCategory(BufferedReader reader) throws IOException {
    while (true) {
        System.out.println("구분 선택:");
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.printf("%d: %s%n", i + 1, categories[i].getDisplayName());
        }
        System.out.print("선택 > ");

        try {
            int num = Integer.parseInt(reader.readLine());
            return Category.fromNumber(num);
        } catch (NumberFormatException e) {
            System.out.println("[오류] 숫자를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println("[오류] " + e.getMessage());
        }
    }
}

}
