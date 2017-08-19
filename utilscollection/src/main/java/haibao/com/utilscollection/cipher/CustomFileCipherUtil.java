package haibao.com.utilscollection.cipher;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**自定义实现简单的文件加密解密工具
 * Created by zhangshuo on 2016/6/28.
 */
public class CustomFileCipherUtil {

    /**
     * 加密后的文件的后缀
     */
    public static final String CIPHER_TEXT_SUFFIX = ".cipher";

    /**
     * 加解密时以32K个字节为单位进行加解密计算
     */
    private static final int CIPHER_BUFFER_LENGHT = 32 * 1024;

    /**
     * 加密，这里主要是演示加密的原理，没有用什么实际的加密算法
     *
     * @param filePath 明文文件绝对路径
     * @return
     */
    public static boolean encrypt(String filePath, CipherListener listener) {
        try {
            long startTime = System.currentTimeMillis();
            File f = new File(filePath);
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            long totalLenght = raf.length();
            FileChannel channel = raf.getChannel();

            long multiples = totalLenght / CIPHER_BUFFER_LENGHT;
            long remainder = totalLenght % CIPHER_BUFFER_LENGHT;

            MappedByteBuffer buffer = null;
            byte tmp;
            byte rawByte;

            //先对整除部分加密
            for(int i = 0; i < multiples; i++){
                buffer = channel.map(
                        FileChannel.MapMode.READ_WRITE, i * CIPHER_BUFFER_LENGHT, (i + 1) * CIPHER_BUFFER_LENGHT);

                //此处的加密方法很简单，只是简单的异或计算
                for (int j = 0; j < CIPHER_BUFFER_LENGHT; ++j) {
                    rawByte = buffer.get(j);
                    tmp = (byte) (rawByte ^ j);
                    buffer.put(j, tmp);

                    if(null != listener){
                        listener.onProgress(i * CIPHER_BUFFER_LENGHT + j, totalLenght);
                    }
                }
                buffer.force();
                buffer.clear();
            }

            //对余数部分加密
            buffer = channel.map(
                    FileChannel.MapMode.READ_WRITE, multiples * CIPHER_BUFFER_LENGHT, multiples * CIPHER_BUFFER_LENGHT + remainder);

            for (int j = 0; j < remainder; ++j) {
                rawByte = buffer.get(j);
                tmp = (byte) (rawByte ^ j);
                buffer.put(j, tmp);

                if(null != listener){
                    listener.onProgress(multiples * CIPHER_BUFFER_LENGHT + j, totalLenght);
                }
            }
            buffer.force();
            buffer.clear();

            channel.close();
            raf.close();

            //对加密后的文件重命名，增加.cipher后缀
//      f.renameTo(new File(f.getPath() + CIPHER_TEXT_SUFFIX));
//            KLog.d("加密用时：", (System.currentTimeMillis() - startTime) /1000 + "s");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 解密，这里主要是演示加密的原理，没有用什么实际的加密算法
     *
     * @param filePath 密文文件绝对路径，文件需要以.cipher结尾才会认为其实可解密密文
     * @return
     */
    public static boolean decrypt(String filePath, CipherListener listener) {
        try {
            long startTime = System.currentTimeMillis();
            File f = new File(filePath);
//      if(!f.getPath().toLowerCase().endsWith(CIPHER_TEXT_SUFFIX)){
//        //后缀不同，认为是不可解密的密文
//        return false;
//      }

            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            long totalLenght = raf.length();
            FileChannel channel = raf.getChannel();

            long multiples = totalLenght / CIPHER_BUFFER_LENGHT;
            long remainder = totalLenght % CIPHER_BUFFER_LENGHT;

            MappedByteBuffer buffer = null;
            byte tmp;
            byte rawByte;

            //先对整除部分解密
            for(int i = 0; i < multiples; i++){
                buffer = channel.map(
                        FileChannel.MapMode.READ_WRITE, i * CIPHER_BUFFER_LENGHT, (i + 1) * CIPHER_BUFFER_LENGHT);

                //此处的解密方法很简单，只是简单的异或计算
                for (int j = 0; j < CIPHER_BUFFER_LENGHT; ++j) {
                    rawByte = buffer.get(j);
                    tmp = (byte) (rawByte ^ j);
                    buffer.put(j, tmp);

                    if(null != listener){
                        listener.onProgress(i * CIPHER_BUFFER_LENGHT + j, totalLenght);
                    }
                }
                buffer.force();
                buffer.clear();
            }

            //对余数部分解密
            buffer = channel.map(
                    FileChannel.MapMode.READ_WRITE, multiples * CIPHER_BUFFER_LENGHT, multiples * CIPHER_BUFFER_LENGHT + remainder);

            for (int j = 0; j < remainder; ++j) {
                rawByte = buffer.get(j);
                tmp = (byte) (rawByte ^ j);
                buffer.put(j, tmp);

                if(null != listener){
                    listener.onProgress(multiples * CIPHER_BUFFER_LENGHT + j, totalLenght);
                }
            }
            buffer.force();
            buffer.clear();

            channel.close();
            raf.close();

            //对加密后的文件重命名，增加.cipher后缀
//      f.renameTo(new File(f.getPath().substring(f.getPath().toLowerCase().indexOf(CIPHER_TEXT_SUFFIX))));

//            KLog.d("解密用时：", (System.currentTimeMillis() - startTime) / 1000 + "s");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 用于加解密进度的监听器
     */
    public interface CipherListener{
        void onProgress(long current, long total);
    }
}
