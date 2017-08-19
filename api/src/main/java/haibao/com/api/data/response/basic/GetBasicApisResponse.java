package haibao.com.api.data.response.basic;

public class GetBasicApisResponse {
    public AccountBean account;

    public static class AccountBean {
        public String endpoint;

        public String version;
    }
}
