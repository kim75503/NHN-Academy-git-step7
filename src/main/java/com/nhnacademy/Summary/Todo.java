package com.nhnacademy.Summary;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Todo {
    private static int idCounter = 1;  // ID 자동 생성용

    private int id;
    private String title;
    private Category category;
    private Priority priority;
    private LocalDate dueDate;
    private int hours;
    private boolean done;
    private LocalDateTime createdAt;

    // 생성자
    public Todo(String title, Category category, Priority priority,
                LocalDate dueDate, int hours) {
        this.id = idCounter++;
        this.title = title;
        this.category = category;
        this.priority = priority;
        this.dueDate = dueDate;
        this.hours = hours;
        this.done = false;
        this.createdAt = LocalDateTime.now();
    }

    // Getter/Setter 메서드들
    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public int getHours() { return hours; }
    public void setHours(int hours) { this.hours = hours; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // ID 카운터 리셋 (파일 로드 시 사용)
    public static void resetIdCounter(int nextId) {
        idCounter = nextId;
    }
    // 생성자에서 this 사용
    public Todo(String title) {
        this.id = idCounter++;
        this.title = title;  // this.title = 필드, title = 매개변수
    }

    public Todo(String title, int hours) {
        this.id = idCounter++;
        this.title = title;  // this.title = 필드, title = 매개변수
        this.hours = hours;
    }

    public Todo(String title, int hours, boolean done) {
        this.id = idCounter++;
        this.title = title;  // this.title = 필드, title = 매개변수
        this.hours = hours;
        this.done = done;
    }

    public Todo(String title, Category category, Priority priority) {
        this.id = idCounter++;
        this.title = title;  // this.title = 필드, title = 매개변수
        this.category = category;
        this.priority = priority;

    }

    // Setter에서 this 사용

    
}
