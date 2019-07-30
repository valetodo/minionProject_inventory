package com.inventory;

public class Mark {
    private String nameMark;
    private String originMark;

    public String getNameMark() {
        return nameMark;
    }

    public void setNameMark(String nameMark) {
        this.nameMark = nameMark;
    }

    public String getOriginMark() {
        return originMark;
    }

    public void setOriginMark(String originMark) {
        this.originMark = originMark;
    }

    @Override
    public String toString() {
        return "{" + "nameMark=" + nameMark + ", originMark=" + originMark + '}';
    }
}
