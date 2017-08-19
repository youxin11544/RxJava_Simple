package haibao.com.api.data.response.basic;

public class GetBasicRateLimitResponse {
    public ResourcesBean resources;

    public static class ResourcesBean {
        public CoreBean core;

        public static class CoreBean {
            public Integer limit;

            public Integer remaining;

            public Integer reset;
        }
    }
}
