package com.huawei.l00379880.common.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO相关工具类
 *
 * @author Louis
 * @date Oct 29, 2018
 */
public class IOUtils {

    /**
     * 关闭对象，连接
     *
     * @param closeable 可关闭的流对象
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
