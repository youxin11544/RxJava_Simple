package haibao.com.api.data.response.myclass;

import java.util.List;

/**
 * Created by Administrator on 2017/2/24 0024.
 */

public class ClassBean {
    public Integer channel_id;

    public String channel_name;

    public Integer chat_group_id;

    public String chat_group_team_id;

    public Integer class_id;

    public Integer club_id;

    public String cover;

    public String create_at;

    public Integer members_count = 0;

    public Integer is_haibao;

    public String master_avatar;

    public Integer master_id;

    public String master_name;

    public Integer is_joined;

    public List<MessagesBean> messages;

    public String name;

    public Integer getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(Integer channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public Integer getChat_group_id() {
        return chat_group_id;
    }

    public void setChat_group_id(Integer chat_group_id) {
        this.chat_group_id = chat_group_id;
    }

    public String getChat_group_team_id() {
        return chat_group_team_id;
    }

    public void setChat_group_team_id(String chat_group_team_id) {
        this.chat_group_team_id = chat_group_team_id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getClub_id() {
        return club_id;
    }

    public void setClub_id(Integer club_id) {
        this.club_id = club_id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public Integer getMembers_count() {
        return members_count;
    }

    public void setMembers_count(Integer members_count) {
        this.members_count = members_count;
    }

    public Integer getIs_haibao() {
        return is_haibao;
    }

    public void setIs_haibao(Integer is_haibao) {
        this.is_haibao = is_haibao;
    }

    public String getMaster_avatar() {
        return master_avatar;
    }

    public void setMaster_avatar(String master_avatar) {
        this.master_avatar = master_avatar;
    }

    public Integer getMaster_id() {
        return master_id;
    }

    public void setMaster_id(Integer master_id) {
        this.master_id = master_id;
    }

    public String getMaster_name() {
        return master_name;
    }

    public void setMaster_name(String master_name) {
        this.master_name = master_name;
    }

    public Integer getIs_joined() {
        return is_joined;
    }

    public void setIs_joined(Integer is_joined) {
        this.is_joined = is_joined;
    }

    public List<MessagesBean> getMessages() {
        return messages;
    }

    public void setMessages(List<MessagesBean> messages) {
        this.messages = messages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
