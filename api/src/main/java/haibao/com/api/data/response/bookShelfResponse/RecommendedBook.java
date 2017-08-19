package haibao.com.api.data.response.bookShelfResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/11 0011.
 */

public class RecommendedBook implements Serializable, Parcelable {
    /**
     * isbn_id : 4567
     * book_name : My Very First Mother Goose
     * book_img_thumb : https://oss.baobaobooks.net/images/goods/covers/1452310705264582960.jpg?w=320&h=355
     * author_name :
     * drawer_name :
     */

    public Integer isbn_id = -1;
    public String book_name;
    public String book_img_thumb;
    public String author_name;
    public String drawer_name;
    public int is_audio;
    //是否是更多的数据
    public boolean isMoreData = false;


    public RecommendedBook() {

    }
    public static final Creator<RecommendedBook> CREATOR = new Creator<RecommendedBook>() {
        @Override
        public RecommendedBook createFromParcel(Parcel in) {
            return new RecommendedBook(in);
        }

        @Override
        public RecommendedBook[] newArray(int size) {
            return new RecommendedBook[size];
        }
    };
    protected RecommendedBook(Parcel in) {
        book_name = in.readString();
        book_img_thumb = in.readString();
        author_name = in.readString();
        drawer_name = in.readString();
        isbn_id = in.readInt();
        isMoreData = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(book_name);
        dest.writeString(book_img_thumb);
        dest.writeString(author_name);
        dest.writeString(drawer_name);
        dest.writeInt(isbn_id);
        dest.writeByte((byte) (isMoreData ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
