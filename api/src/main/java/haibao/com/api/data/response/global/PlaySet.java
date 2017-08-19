package haibao.com.api.data.response.global;

import java.io.Serializable;

public class PlaySet implements Serializable {

    private int definition;
    private int vbitrate;
    private int vheight;
    private int vwidth;
    private String url;

    public int getDefinition() {
        return definition;
    }

    public void setDefinition(int definition) {
        this.definition = definition;
    }

    public int getVbitrate() {
        return vbitrate;
    }

    public void setVbitrate(int vbitrate) {
        this.vbitrate = vbitrate;
    }

    public int getVheight() {
        return vheight;
    }

    public void setVheight(int vheight) {
        this.vheight = vheight;
    }

    public int getVwidth() {
        return vwidth;
    }

    public void setVwidth(int vwidth) {
        this.vwidth = vwidth;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
