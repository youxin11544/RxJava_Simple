package haibao.com.api.data.response.club;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.global.LocationBean;
import haibao.com.api.data.response.global.ShareBean;

public class GetClubsClubIdProfileResponse implements Serializable {
    /**
     * club_avatar : https://oss.baobaobooks.net/images/avatar/201608/147194010596411.jpg
     * club_cover : https://osstest.baobaobooks.net/readerclub/activities/cover/201704/149147281580475.jpg
     * club_desc : 这是圈子简介
     * club_id : 81
     * club_name : 这是圈子名称A111A111111A
     * created_at : 2017-03-28 15:24:55
     * is_joined : 1
     * location : {"address":"江苏常州郊区","address_detail":"广东省 东莞市 沙田镇大泥村临海北路5号中通快递B栋三楼中通秀驿香港转运仓@BJGYQH，51810133","city":"","district":"","latitude":"","longitude":"","province":""}
     * members : [{"avatar":"https://osstest.baobaobooks.net/images/avatar/201612/148102801511422.jpg","friend_status":0,"is_lecturer":"1","is_promoter":"1","signature":"","user_id":"638033","user_name":"18977777"},{"avatar":"","friend_status":0,"is_lecturer":"1","is_promoter":"1","signature":"","user_id":"657400","user_name":"zzx"}]
     * members_count : 1
     * share : {"content":"这是圈子简介","image":"https://oss.baobaobooks.net/images/avatar/201608/147194010596411.jpg","title":"这是圈子名称A111A111111A","url":"https://eeshop.baobaobooks.net"}
     * signature :
     * user_avatar : https://osstest.baobaobooks.net/images/avatar/201612/148102801511422.jpg
     * user_id : 638033
     * user_name : 18977777
     */

    public String club_avatar;
    public String club_cover;
    public String club_desc;
    public String club_id;
    public String club_name;
    public String created_at;
    public Integer is_joined;
    public LocationBean location;
    public String members_count;
    public ShareBean share;
    public String signature;
    public String user_avatar;
    public String user_id;
    public String user_name;
    public List<MembersBean> members;


    public static class MembersBean {
        /**
         * avatar : https://osstest.baobaobooks.net/images/avatar/201612/148102801511422.jpg
         * friend_status : 0
         * is_lecturer : 1
         * is_promoter : 1
         * signature :
         * user_id : 638033
         * user_name : 18977777
         */

        public String avatar;
        public Integer friend_status;
        public String is_lecturer;
        public String is_promoter;
        public String signature;
        public String user_id;
        public String user_name;

    }


}
