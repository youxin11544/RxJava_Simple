package haibao.com.api.helper;

import com.socks.library.KLog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import haibao.com.api.listener.MyUploadListener;
import haibao.com.api.listener.ProgressRequestBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @author: yaoyongchao
 * @date: 2016/9/8 16:08
 * @description:
 */
public class MultipartBuilder {

    private static MultipartBuilder multipartBuilder = new MultipartBuilder();

    public static MultipartBuilder getInstance() {
        return multipartBuilder;
    }

    public static List<MultipartBody.Part> filesToMultipartBodyParts(List<File> files) {
        List<MultipartBody.Part> parts = new ArrayList<>(files.size());
        for (File file : files) {
            // TODO: 16-4-2  这里为了简单起见，没有判断file的类型
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("aFile", file.getName(), requestBody);
            parts.add(part);
        }
        return parts;
    }

    public static MultipartBody filesToMultipartBody(String avatar, List<File> files) {
        MultipartBody.Builder builder = new MultipartBody.Builder();

        for (int i = 0; i < files.size(); i++) {
            // TODO: 16-4-2  这里为了简单起见，没有判断file的类型
            File file = files.get(i);
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
            builder.addFormDataPart(avatar, file.getName(), requestBody);
        }
        builder.setType(MultipartBody.FORM);
        MultipartBody multipartBody = builder.build();
        return multipartBody;
    }

    public MultipartBody filesToMultipartBody(List<File> files) {
        MultipartBody.Builder builder = new MultipartBody.Builder();

//        CrashHandler.create(HaiBaoApplication.getInstance()).saveLogToSDCard("filesToMultipartBody() ------ " +
//                "use_id--"+HaiBaoApplication.getUserId()+"文件个数："+files.size()
//        );


        for (int i = 0; i < files.size(); i++) {
            // TODO: 16-4-2  这里为了简单起见，没有判断file的类型
            File file = files.get(i);
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
            builder.addFormDataPart("contentImage_" + i, file.getName(), requestBody);
        }

        builder.setType(MultipartBody.FORM);
        MultipartBody multipartBody = builder.build();
        return multipartBody;
    }


//
//    public static MultipartBody filesToMultipartBody(List<File> files) {
//        MultipartBody.Builder builder = new MultipartBody.Builder();
//
//        for(int i=0;i<files.size();i++) {
//            // TODO: 16-4-2  这里为了简单起见，没有判断file的类型
//            //加上了类型判断
//            File file = files.get(i);
//            String fileAbsolutePath = file.getAbsolutePath();
//            int i1 = fileAbsolutePath.lastIndexOf(".");
//            String imageType = fileAbsolutePath.substring(i1+1);
//            switch (imageType){
//                case "jpeg":
//                case "jpg":
//                case "png":
//                case "bmp":
//                case "gif":
//                    break;
//            }
//            RequestBody requestBody = RequestBody.create(MediaType.parse("image/"+imageType), file);
////            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
//            builder.addFormDataPart("contentImage_" + i, file.getName(), requestBody);
//        }
//        builder.setType(MultipartBody.FORM);
//        MultipartBody multipartBody = builder.build();
//        return multipartBody;
//    }

    public MultipartBody fileToMultipartBody(File file) {
        MultipartBody.Builder builder = new MultipartBody.Builder();

        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        builder.addFormDataPart("contentImage_", file.getName(), requestBody);

        builder.setType(MultipartBody.FORM);
        MultipartBody multipartBody = builder.build();
        return multipartBody;
    }

    //新增加方法，添加了一个接口fu
    public MultipartBody filesToMultipartBody(List<File> files, final MyUploadListener listener) {
        MultipartBody.Builder builder = new MultipartBody.Builder();

        for (int i = 0; i < files.size(); i++) {
            // TODO: 16-4-2  这里为了简单起见，没有判断file的类型
            File file = files.get(i);
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(requestBody, new ProgressRequestBody.Listener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, long networkSpeed) {
                    KLog.e("contentLength:" + contentLength);
                    KLog.e("networkSpeed:" + networkSpeed);

                    listener.onProgress(bytesWritten, contentLength, true);

                }
            });

            builder.addFormDataPart("contentImage_" + i, file.getName(), progressRequestBody);//this是在当前类实现了ProgressRequestListener接口
        }

        builder.setType(MultipartBody.FORM);
        MultipartBody multipartBody = builder.build();
        return multipartBody;
    }


}
