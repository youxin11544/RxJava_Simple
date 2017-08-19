package haibao.com.utilscollection.io;

import com.google.gson.Gson;

import java.io.InputStream;
import java.lang.reflect.Type;

import haibao.com.utilscollection.UtilsCollection;

/**
 *
 * Created by Administrator on 2017/2/22 0022.
 */
public class AssetsUtils {
    public static String get(String fileName) {
        InputStream is = null;
        try {
            is = UtilsCollection.core.getAssets().open(fileName);
            int lenght = is.available();
            byte[] buffer = new byte[lenght];
            is.read(buffer);
            String result = new String(buffer, "utf8");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T getBean(String fileName, Type typeOfT) {
        return new Gson().fromJson(AssetsUtils.get(fileName), typeOfT);
    }

}
