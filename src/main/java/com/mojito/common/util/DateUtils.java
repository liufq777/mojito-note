package com.mojito.common.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期工具
 *
 * @author liufengqiang
 * @date 2020-10-26 09:47:09
 */
public class DateUtils {

    public static final String FORMAT_DATE_DATETIME = "yyyy-MM-dd";
    public static final String FORMAT_DATE_SECOND = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_DATE_CHINA = "MM月dd日 HH:mm";

    /**
     * 格式化指定时间（默认格式）
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, FORMAT_DATE_DATETIME);
    }

    /**
     * 格式化指定时间
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        if ((date == null) || StringUtils.isEmpty(format)) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 获取当前时间（默认格式）
     *
     * @return
     */
    public static String getCurrentTime() {
        return format(new Date());
    }

    public static String getCurrentTime(String format) {
        return format(new Date(), format);
    }

    /**
     * 生成ISO-8601 规范的时间格式
     *
     * @param date
     * @return
     */
    public static String formatISO8601DateString(Date date) {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        return DateFormatUtils.format(date, pattern);
    }

    private static String formatDateByPattern(String date, String pattern) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(df.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatPretty(Date date) {
        try {
            String format = DateUtils.format(date, DateUtils.FORMAT_DATE_MINUTE);
            if (format.substring(0, 4).equals(DateUtils.getCurrentTime().substring(0, 4))) {
                return DateUtils.format(date, DateUtils.FORMAT_DATE_CHINA);
            } else {
                return format;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static String formatPretty(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern(LocalDateTime.now().getYear() == date.getYear() ? FORMAT_DATE_CHINA : FORMAT_DATE_MINUTE));
    }
}
