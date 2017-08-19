package haibao.com.api.data.response.school;

import java.io.Serializable;

public class AudioInfo implements Serializable {

    private Credentials Credentials;
    private int ttl;
    private String bucket;
    private String domain;
    private String endpoint;

    public class Credentials {

        private String AccessKeyId;
        private String AccessKeySecret;
        private String Expiration;
        private String SecurityToken;

        public String getAccessKeyId() {
            return AccessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            AccessKeyId = accessKeyId;
        }

        public String getAccessKeySecret() {
            return AccessKeySecret;
        }

        public void setAccessKeySecret(String accessKeySecret) {
            AccessKeySecret = accessKeySecret;
        }

        public String getExpiration() {
            return Expiration;
        }

        public void setExpiration(String expiration) {
            Expiration = expiration;
        }

        public String getSecurityToken() {
            return SecurityToken;
        }

        public void setSecurityToken(String securityToken) {
            SecurityToken = securityToken;
        }
    }

    public AudioInfo.Credentials getCredentials() {
        return Credentials;
    }

    public void setCredentials(AudioInfo.Credentials credentials) {
        Credentials = credentials;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
