package haibao.com.utilscollection.io;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by tang on 14-3-1.
 */
public class JsonUtils {

  //从给定位置读取Json文件
  public static String readJson(String path){
    //从给定位置获取文件
    File file = new File(path);
    BufferedReader reader = null;
    //返回值,使用StringBuffer
    StringBuffer data = new StringBuffer();
    //
    try {
      reader = new BufferedReader(new FileReader(file));
      //每次读取文件的缓存
      String temp = null;
      while((temp = reader.readLine()) != null){
        data.append(temp);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      //关闭文件流
      if (reader != null){
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return data.toString();
  }

  //给定路径与Json文件，存储到硬盘
  public static void writeJson(String path,Object json,String fileName){
    BufferedWriter writer = null;
    File file = new File(path + fileName + ".json");
    //如果文件不存在，则新建一个
    if(!file.exists()){
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    //写入
    try {
      writer = new BufferedWriter(new FileWriter(file));
      writer.write(json.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      try {
        if(writer != null){
          writer.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
//        System.out.println("文件写入成功！");
  }



  /**
   * 从asset路径下读取对应文件转String输出
   * @param mContext
   * @return
   */
  public static String getJson(Context mContext, String fileName) {
    // TODO Auto-generated method stub
    StringBuilder sb = new StringBuilder();
    AssetManager am = mContext.getAssets();
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(
              am.open(fileName)));
      String next = "";
      while (null != (next = br.readLine())) {
        sb.append(next);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      sb.delete(0, sb.length());
    }
    return sb.toString().trim();
  }



  final static int BUFFER_SIZE = 4096;

  // 将InputStream转换成String
  public static String InputStreamTOString(InputStream in) throws Exception {

    ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    byte[] data = new byte[BUFFER_SIZE];

    int count = -1;

    while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)

      outStream.write(data, 0, count);

    data = null;

    return new String(outStream.toByteArray(), "ISO-8859-1");

  }
}
