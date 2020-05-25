package com.auto.entities

enum IconEnum {
    BUG(5),
    BALL(4),
    MAIL(9)

    int val

    public IconEnum(int val) {
        this.val = val
    }

    public static String getNameById(int id) {
        for (IconEnum anEnum: values()) {
            if (anEnum.val == id) {
                return anEnum.name()
            }
        }

        return ""
    }
}