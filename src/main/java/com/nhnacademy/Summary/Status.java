package com.nhnacademy.Summary;

public enum  Status {
    TODO("할 일"),
    IN_PROGRESS("진행 중"),
    DONE("완료");

    private final String displayName;

    Status(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return this.displayName;
    }
}

