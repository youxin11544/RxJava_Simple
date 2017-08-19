package haibao.com.api.data.response.club;

import java.util.List;

import haibao.com.api.data.response.global.ShareBean;

public class GetClubsClubIdResponse {
    public String club_avatar;

    public String club_cover;

    public String club_desc;

    public Integer club_id;

    public String club_name;

    public Integer create_at;

    public Integer is_joined;

    public LocationBean location;

    public List<MembersBean> members;

    public Integer members_count;

    public ShareBean share;

    public String signature;

    public String user_avatar;

    public String user_id;

    public String user_name;

    public static class LocationBean {
        public String address;

        public String address_detail;

        public String city;

        public String district;

        public String latitude;

        public String longitude;

        public String province;
    }

    public static class MembersBean {
        public String avatar;

        public Integer friend_status;

        public Integer is_lecturer;

        public Integer is_promoter;

        public String signature;

        public Integer user_id;

        public String user_name;
    }
}
