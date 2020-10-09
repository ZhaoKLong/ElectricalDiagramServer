package com.electricaldiagram.common;

import org.apache.commons.lang3.StringUtils;

/**
 * 错误码定义规范
 * 定义错误提示级别，
 * 0 表示没有错误
 * 1 为服务端返回提示   客户端直接显示服务器返回的错误
 * 2 为不提示          客户端做相应的操作、
 * 3 隐藏性卖萌提示     客户端需要将转换成用户友好的提示
 * 定义具体的错误模块，登录相关/订单相关/产品相关
 * 具体错误编号，自增即可，一个项目9999种错误应该够用；
 *
 * @author: Zkl
 * @create: 2010-10-09
 * @params 静态常量
 */
public class ErrorCode implements java.io.Serializable {

    public static final ErrorCode SUCCESS = new ErrorCode(HintLevel.SUCCESS, (short) 0, (short) 0);
    public static final ErrorCode PASSWORD_ERROR = new ErrorCode(HintLevel.PROCESS, 1, 3, "密码错误!");
    public static final ErrorCode DEFAULT_ERROR = new ErrorCode(HintLevel.HIDDEN, (short) 1, (short) 1);
    public static final ErrorCode INVALID_PARAMETER = new ErrorCode(HintLevel.PROCESS, (short) 1, (short) 2);
    public static final ErrorCode RESOURCE_NOT_FOUNT = new ErrorCode(HintLevel.SHOW, 1, 3, "请求的资源不存在或已删除");
    public static final ErrorCode MISS_PARAMETER = new ErrorCode(HintLevel.PROCESS, 1, 4, "缺少参数");
    public static final ErrorCode PERSISTENT_DATA_ERROR = new ErrorCode(HintLevel.SHOW, 1, 5, "数据有误");
    public static final ErrorCode UNKNOWN_ERROR = new ErrorCode(HintLevel.PROCESS, 1, 6, "");
    public static final ErrorCode UN_AUTHORIZATION = new ErrorCode(HintLevel.PROCESS, 1, 7, "没有权限访问该url");
    public static final ErrorCode FUNCTION_NOT_SUPPORT = new ErrorCode(HintLevel.PROCESS, 1, 8, "此功能暂不支持");
    public static final ErrorCode TASK_PUBLISH_FAIL = new ErrorCode(HintLevel.PROCESS, 1, 8, "发送失败");

    public static final Integer SQL_EXCEPTION = 1001;
    public static final Integer CLASSCAST_EXPECTION = 1002;
    public static final Integer ARRAYINDEXOUTOF_EXCEPTION = 1003;
    public static final Integer FILENOTFOUND_EXCEPTION = 1005;
    public static final Integer IO_EXCEPTION = 1005;

    public static final Integer DEFAULT_CODE = 2000;

    private final int code;
    private final String message;

    public ErrorCode(HintLevel level, int module, int trail) {
        message = null;
        this.code = initCode(level, module, trail);
    }

    public ErrorCode(HintLevel level, int module, int identity, String message) {
        this.code = initCode(level, module, identity);
        this.message = message;
    }

    /**
     * 在解析接口返回的json数据时， 如果返回错误码， 需要用到， 其余情况下不要使用
     *
     * @param code
     * @param message
     */
    public ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 错误码提示级别占一位,
     * 模块占两位，
     * 表示自身的码占三位，
     * 重写该方法可以自定义位数
     *
     * @return
     */
    protected int initCode(HintLevel level, int module, int identity) {
        if (level == HintLevel.SUCCESS) {
            return level.getLevel();
        }
        return Integer.valueOf(level.getLevel() + "" + StringUtils.leftPad(module + "", 2, "0") + StringUtils.leftPad(identity + "", 3, "0"));
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static enum HintLevel {

        SUCCESS(0),
        SHOW(1),
        PROCESS(2),
        HIDDEN(3);

        private final int level;

        HintLevel(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }
}
