package top.hyzhu.utils;

/**
 * @Description StringUtil
 * @Author zhy
 * @Date 2023/9/26 20:43
 */
public class StringUtil {
    public static String subUri(String uri) {
        int position = uri.lastIndexOf("/");
        return uri.substring(position + 1);
    }
}
