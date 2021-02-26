package com.am.jsa.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Wrapper for log4j2. Wrapper wraps the call to all the logging methods of
 * log4j so that any changes in log can be localized to this and only this
 * class.
 * 
 * 
 */
public class AmLogger {
	static final Logger logger = LogManager.getLogger(AmLogger.class.getName());

	/**
	 * Error logger
	 * 
	 * @param source
	 *            where is the log invoked from
	 * @param log
	 *            content of the log
	 */
	public static void error(Class source, String log) {
		logger.error(formatter(source, "ERROR", log));
	}

	/**
	 * Fatal logger
	 * 
	 * @param source
	 *            where is the log invoked from
	 * @param log
	 *            content of the log
	 */
	public static void fatal(Class source, String log) {
		logger.fatal(formatter(source, "FATAL", log));
	}

	/**
	 * Info logger
	 * 
	 * @param source
	 *            where is the log invoked from
	 * @param log
	 *            content of the log
	 */
	public static void info(Class source, String log) {
		logger.info(formatter(source, "INFO", log));
	}

	/**
	 * debug logger
	 * 
	 * @param source
	 *            where is the log invoked from
	 * @param log
	 *            content of the log
	 */
	public static void debug(Class source, String log) {
		logger.debug(formatter(source, "DEBUG", log));
	}

	/**
	 * Warn logger
	 * 
	 * @param source
	 *            where is the log invoked from
	 * @param log
	 *            content of the log
	 */
	public static void warn(Class source, String log) {
		logger.warn(formatter(source, "WARN", log));
	}

	/**
	 * Log formatter
	 * 
	 * @param src
	 *            source of logging event
	 * @param level
	 *            log level
	 * @param log
	 *            log message
	 * @return formatted log message string
	 */
	private static String formatter(Class src, String level, String log) {
		return level + " " + src.toString().split(" ")[1] + ":" + log;
	}

	public static void printData(String str) {
		System.out.println("*******:: " + str);
	}
}
