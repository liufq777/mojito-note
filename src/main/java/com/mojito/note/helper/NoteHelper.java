package com.mojito.note.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-08-07 08:41
 */
@Slf4j
public class NoteHelper {

    /**
     * 获取文章简介
     * @param content
     */
    public static String getDesc(String content) {
        if (StringUtils.isNotBlank(content)) {
            try {
                String result = content.substring(0, content.indexOf("\n"));
                result = result.replace("> ", "");
                result = result.replace("#### ", "");
                result = result.replace("### ", "");
                result = result.replace("## ", "");
                result = result.replace("# ", "");
                result = result.replace("**", "");
                return result;
            } catch (Exception ignored) {
            }
        }
        return null;
    }
}
