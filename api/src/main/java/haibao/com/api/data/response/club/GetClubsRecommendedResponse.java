package haibao.com.api.data.response.club;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.global.LocationBean;
import haibao.com.api.data.response.global.MembersBean;
import haibao.com.api.data.response.global.ShareBean;

public class GetClubsRecommendedResponse implements Serializable {
    /**
     * club_id : 37
     * user_id : 36845
     * club_name : 孩宝阅读也破vghs嘻x进那些那打开你
     * club_avatar : https://osstest.baobaobooks.net/readerclub/activities/cover/201705/149438893745506.jpg
     * club_cover : https://oss.baobaobooks.net/background/club_bg.png
     * club_desc : 旅行的主题，一直都是妈和暖暖的心头最爱。一收到这套《Hello World》旅行绘本，我就和暖暖一起迫不及待地打开了。刚翻开《London: A Book
     * members_count : 40
     * created_at : 1489139244
     * user_name : fxm5547
     * user_avatar : https://osstest.baobaobooks.net/images/avatar/201705/149576902932580.jpg@1e_1c_180w_180h_95q
     * signature : Ghghhgfffffgghhhhhhgddftrrrfghjjjbfddfhh
     * is_joined : 0
     * share : {"title":"孩宝阅读也破vghs嘻x进那些那打开你","content":"旅行的主题，一直都是妈和暖暖的心头最爱。一收到这套《Hello World》旅行绘本，我就和暖暖一起迫不及待地打开了。刚翻开《London: A Book","url":"","image":"https://osstest.baobaobooks.net/readerclub/activities/cover/201705/149438893745506.jpg"}
     * members : [{"user_id":"36845","user_name":"fxm5547","avatar":"https://osstest.baobaobooks.net/images/avatar/201705/149576902932580.jpg@1e_1c_180w_180h_95q","signature":"Ghghhgfffffgghhhhhhgddftrrrfghjjjbfddfhh","is_lecturer":"1","is_promoter":"1","friend_status":0},{"user_id":"77777887","user_name":"weid3","avatar":"","signature":"","is_lecturer":"0","is_promoter":"0","friend_status":0},{"user_id":"614808","user_name":"shopdev","avatar":"https://osstest.baobaobooks.net/images/avatar/201612/148178243135689.JPG@1e_1c_180w_180h_95q","signature":"","is_lecturer":"0","is_promoter":"1","friend_status":0},{"user_id":"77777877","user_name":"haibaodaixiao_002","avatar":"https://osstest.baobaobooks.net/images/avatar/201705/149553730196797.cn/mmopen/OhtYDiamhZUnWPwOicicSEQoUjSDhLtFaDA5vvRibV6T6eic8Rubcjsn9PHWuAwu6kY9soqttfRMcNAhFAz8OSHhLNKspajmlTRFe/0","signature":"","is_lecturer":"0","is_promoter":"0","friend_status":0},{"user_id":"77777888","user_name":"yz53","avatar":"","signature":"","is_lecturer":"0","is_promoter":"0","friend_status":0},{"user_id":"77777889","user_name":"15965759072","avatar":"https://osstest.baobaobooks.net/images/avatar/201705/149464204697911.jpg","signature":"谷歌哈哈哈hi哩哩啦啦公积金叽里呱啦hi推推会吐呼呼呼考虑考虑哈哈😄急功近利吉里吉里吉里吉里吉里吉里咖喱鸡块来了吉里吉里来例假了4级来例假了4级哩哩啦啦高科技刘涛健健康康健健康康了解了解理解可口可乐","is_lecturer":"1","is_promoter":"1","friend_status":2},{"user_id":"77777922","user_name":"雅竹1","avatar":"","signature":"","is_lecturer":"0","is_promoter":"0","friend_status":0},{"user_id":"638053","user_name":"1212test","avatar":"","signature":"","is_lecturer":"0","is_promoter":"0","friend_status":0},{"user_id":"54881","user_name":"cchocolatec","avatar":"https://oss.baobaobooks.net/images/avatar/201511/54881.jpg","signature":"","is_lecturer":"0","is_promoter":"0","friend_status":0},{"user_id":"77777890","user_name":"15965759073","avatar":"https://osstest.baobaobooks.net/images/avatar/201705/149397194773585.png","signature":"阅读，让世界更美好@～/：；（\u201c\u201d）哈哈😓","is_lecturer":"0","is_promoter":"0","friend_status":0},{"user_id":"488867","user_name":"Nobody","avatar":"https://oss.baobaobooks.net/images/avatar/201608/147194010596411.jpg","signature":"Qq","is_lecturer":"0","is_promoter":"1","friend_status":0},{"user_id":"77777926","user_name":"hb5916a619c489c","avatar":"http://wx.qlogo.cn/mmopen/Wkn9MzXXE2YmPUzjv6uUB23MBvqnrfFrDlKGDBASQePpLAicOR6lghz2THvatRT8TjLco75jE4Cbgrv87XyR0Hv8EfpLoLcEz/0","signature":"","is_lecturer":"0","is_promoter":"0","friend_status":0},{"user_id":"77777928","user_name":"hb5916be7cd919b","avatar":"http://wx.qlogo.cn/mmopen/Wkn9MzXXE2YmPUzjv6uUB23MBvqnrfFrDlKGDBASQePpLAicOR6lghz2THvatRT8TjLco75jE4Cbgrv87XyR0Hv8EfpLoLcEz/0","signature":"","is_lecturer":"0","is_promoter":"0","friend_status":0},{"user_id":"77777931","user_name":"雅竹651","avatar":"http://wx.qlogo.cn/mmopen/Wkn9MzXXE2YmPUzjv6uUB23MBvqnrfFrDlKGDBASQePpLAicOR6lghz2THvatRT8TjLco75jE4Cbgrv87XyR0Hv8EfpLoLcEz/0","signature":"","is_lecturer":"0","is_promoter":"0","friend_status":0},{"user_id":"77778034","user_name":"hb59282695e3c5d","avatar":"","signature":"","is_lecturer":"0","is_promoter":"0","friend_status":0}]
     * location : {"province":"广东","city":"深圳","district":"龙岗区","address":"南湾街道求水山公园","address_detail":"宝源华丰经济大厦C座51911","longitude":114.02887,"latitude":22.61674017}
     */


    public String club_avatar;

    public String club_cover;

    public String club_desc;

    public Integer club_id;

    public String club_name;

    //  public Integer create_at;
    public Integer created_at;

    public Integer is_joined;

    public List<MembersBean> members;

    public Integer members_count;

    public ShareBean share;

    public String signature;

    public String user_avatar;

    public String user_id;

    public String user_name;

    public LocationBean location;




}
