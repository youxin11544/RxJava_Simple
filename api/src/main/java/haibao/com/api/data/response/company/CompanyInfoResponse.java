package haibao.com.api.data.response.company;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.activity.ActivitiesActivityResponse;
import haibao.com.api.data.response.course.LiveCourse;
import haibao.com.api.data.response.global.Content;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

public class CompanyInfoResponse implements Serializable {
    public List<BannersBean> banners;
    public List<String> orders;
    public CommomBean qatalk;
    public LecturesBean lectures;
    public ActivitiesBean activities;
    public CommomBean articles;
    public CommomBean news;
    public CommomBean book_story;
    public CommomBean abroad;


    public static class CommomBean implements Serializable {
        public String title;
        public List<Content> items;
    }

    public static class LecturesBean implements Serializable {
        public String title;
        public List<LiveCourse> items;
    }

    public static class ActivitiesBean implements Serializable {
        public String title;
        public List<ActivitiesActivityResponse> items;
    }

    public static class BannersBean implements Serializable {
        public Integer type;
        public String type_id;
        public String title;
        public String image;
        public String link;
        public LiveCourse course;
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BannersBean that = (BannersBean) o;
            if (type != null ? !type.equals(that.type) : that.type != null) return false;
            if (type_id != null ? !type_id.equals(that.type_id) : that.type_id != null)
                return false;
            if (title != null ? !title.equals(that.title) : that.title != null) return false;
            if (image != null ? !image.equals(that.image) : that.image != null) return false;
            return link != null ? link.equals(that.link) : that.link == null;

        }

    }
}
