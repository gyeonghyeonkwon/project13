package com.ll.project_13_backend.global;

public class Ut {

    public static class str {

        public static String lcfirst(String str) {
            if (str == null || str.isEmpty()) {
                return str;
            }
            return str.substring(0, 1).toLowerCase() + str.substring(1);
        }
    }
}

