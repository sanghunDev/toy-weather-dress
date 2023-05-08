package com.app.global.jwt.constant;

public enum ToKenType {

    ACCESS, REFRESH;

    public static boolean isAccessToken(String tokenType) {
        return ToKenType.ACCESS.name().equals(tokenType);
    }
}
