package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * 日志问候类
 */
public class HelloLog {

    private static Logger logger = LoggerFactory.getLogger(HelloLog.class); /**
     * 主程序
     * @param args
     */
    public static void main(String[] args){
        //映射诊断环境
        MDC.put("location","001");
        //打印不同级别的日志
        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");
        logger.trace("trace");
    }
}
