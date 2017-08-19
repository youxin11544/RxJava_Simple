package haibao.com.api.common;

/**
 * 常量类
 */
public class HttpCommon {


    //公共参数
    public static final int DEFAULT_VERSION = 0;
    public static final int INVALID_INT_VALUE = -100;

    public static final int MAX_RECORD_AUDIO_DURATION = 15 * 60 * 1000;
    public static final int MAX_RECORD_VIDEO_DURATION = 5 * 60 * 1000;// 后面要加 1秒  以后 在 WXLikeVideoRecorder 里面改时间

    public static final long MAX_AUDIO_SIZE = 100 * 1024 * 1024L;
    public static final long MAX_VIDEO_SIZE = 500 * 1024 * 1024L;

    public static final String NAME_DB = "haibao";
    public static final String NAME_SP = "haibao";

    public static final String OSS_UPLOAD_PREFIX = "audio/diary/";
    public static final String OSS_UPLOAD_VIDEO_PREFIX = "video/diary/";
    public static final String Q_CLOUD_VIDEO_PERSISTENCE_ID = "qcloud_video";
    public static final String REAL_PACKAGE_NAME = "com.haibao";

    public static final String DIR_CACHE_IMAGE = "/ayb/image";
    public static final String DIR_CACHE_LYRIC = "/ayb/lyric";
    public static final String DIR_DOWNLOAD_AUDIO = "/ayb/audio";
    public static final String DIR_DOWNLOAD_VIDEO = "/ayb/video";
    public static final String DIR_DOWNLOAD_TEMP = "/ayb/temp";
    public static final String DIR_MSC = "/ayb/msc";
    public static final String DIR_RECORD_AUDIO = "/ayb/record/audio";
    public static final String DIR_RECORD_VIDEO = "/ayb/record/video";
    public static final String DIR_ERROR_LOG = "/ayb/errorlog";


    public static final String SIGN_SECRET_CODE = "4lmJLSZ5x63XYhb87IisuajoCfwTHVQn";

    public static final String ACTION_MEDIA_SERVICE = "com.haibao.media.service";
    public static final String USERINFO = "user";


    // 请求参数key
    public static final String KEY_ACCOUNT = "account";
    public static final String KEY_AVATAR = "avatar";
    public static final String KEY_BABY_ID = "baby_id";
    public static final String KEY_CHANNEL_ID = "channel_id";
    public static final String KEY_CONTENT_ID = "content_id";
    public static final String KEY_CONTENT_IMAGE = "contentImage_";
    public static final String KEY_COUNTRY_CODE = "country_code";
    public static final String KEY_COURSE_ID = "course_id";
    public static final String KEY_FILE_ID = "fileId";
    public static final String KEY_FOLLOWING = "following";
    public static final String KEY_HBSID = "HBSID";
    public static final String KEY_HBUID = "HBUID";
    public static final String KEY_SUPPORT_WEBP = "supportWebp";

    public static final String KEY_ID = "id";
    public static final String KEY_ISBN = "isbn";
    public static final String KEY_ISBN_ID = "isbn_id";
    public static final String KEY_LAST_TIMESTAMP = "last_timestamp";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_MOBILE_COUNTRY_CODE = "mobile_country_code";
    public static final String KEY_OFFSET = "offset";
    public static final String KEY_PAGE = "page";
    public static final String KEY_Q = "q";
    public static final String KEY_SHARED_PLATFORM = "shared_platform";
    public static final String KEY_SHARED_USER_ID = "shared_user_id";
    public static final String KEY_SNS_USER_ID = "sns_user_id";
    public static final String KEY_SOURCE_PLATFORM = "source_platform";
    public static final String KEY_TYPE = "type";
    public static final String KEY_USER_ID = "user_id";


}
