/*
 * Copyright 2004-2011 H2 Group. Multiple-Licensed under the H2 License,
 * Version 1.0, and under the Eclipse Public License, Version 1.0
 * (http://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.java.lang;

/**
 * A java.lang.Integer implementation.
 */
public class Integer {

    public static final int MIN_VALUE = 1 << 31;

    public static final int MAX_VALUE = (int) ((1L << 31) - 1);

    /**
     * Convert a value to a String.
     *
     * @param x the value
     * @return the String
     */
    public static String toString(int x) {
        // c: char ch[20];
        // c: snprintf(ch, 20, "%d", x);
        // c: return string(ch);
        // c: return;
        if (x == MIN_VALUE) {
            return String.wrap("-2147483648");
        }
        char[] ch = new char[20];
        int i = 20 - 1, count = 0;
        boolean negative;
        if (x < 0) {
            negative = true;
            x = -x;
        } else {
            negative = false;
        }
        for (; i >= 0; i--) {
            ch[i] = (char) ('0' + (x % 10));
            x /= 10;
            count++;
            if (x == 0) {
                break;
            }
        }
        if (negative) {
            ch[--i] = '-';
            count++;
        }
        return new String(ch, i, count);
    }

}