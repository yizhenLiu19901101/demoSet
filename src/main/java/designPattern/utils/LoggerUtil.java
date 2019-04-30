package designPattern.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志组件
 */
public class LoggerUtil {

    /**
     * 私有静态常量
     */
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    /**
     * info级别的日志
     * @param message
     */
    public static void info(String message){
        logger.info(message);
    }
}
