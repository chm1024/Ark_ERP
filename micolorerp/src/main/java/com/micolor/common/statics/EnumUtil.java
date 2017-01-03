/*
 * Copyright (c) 2015. MiColor
 */

/**
 * @Title: MESSAGE.java
 * @Package ierp.common
 * @Description: 用于各个方法返回的参数或者一些静态常量。
 * @author 钰鹏
 * @date 2013年10月9日 下午1:43:00
 * @version V1.0
 */
package com.micolor.common.statics;

/**
 * @author 钰鹏
 * @ClassName: MESSAGE
 * @Description: 用于各个方法返回的参数或者一些静态常量。
 * @date 2013年10月9日 下午1:43:00
 */

public class EnumUtil {

    /**
     * 消息状态
     */
    public enum MessageStatus {
        OK {
            public int getName() {
                return 1;
            }
        },
        ERROR {
            public int getName() {
                return 0;
            }
        },
        WARN{
            public int getName() {
                return 2;
            }
        },
        NOFOUND{
            public int getName() {
                return 3;
            }
        },
        ERRORSTATION{
            public int getName() {
                return 4;
            }
        };

        public abstract int getName();
    }

    public enum UserTypes {
        Admins {
            @Override
            public String toString() {
                return "a";
            }
        },
        Partners {
            @Override
            public String toString() {
                return "g";
            }
        },
        Enterprise {
            @Override
            public String toString() {
                return "e";
            }
        };


    }
}
