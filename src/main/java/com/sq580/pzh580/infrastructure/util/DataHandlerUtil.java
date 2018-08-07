package com.sq580.pzh580.infrastructure.util;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.File;
import java.io.IOException;

/**
 * 生成图片信息
 * @author chensh
 */
public class DataHandlerUtil {

    public static DataHandler getDataHandler() {
        DataHandler dh1 = null;
        try {
            dh1 = new DataHandler(new FileDataSource(
                    new File("/usr/local/580/shishi.jpg")
                            .getAbsoluteFile().getCanonicalPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dh1;
    }
}
