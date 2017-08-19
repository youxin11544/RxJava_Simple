package haibao.com.api.data.response.club;

public class GetClubsClubIdStatisticsBriefResponse {
    public ContentsBean contents;

    public UsersBean users;

    public static class ContentsBean {
        public Integer today;

        public Integer total;
    }

    public static class UsersBean {
        public Integer today;

        public Integer total;
    }
}
