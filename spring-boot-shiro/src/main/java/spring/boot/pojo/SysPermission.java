package spring.boot.pojo;

public class SysPermission {
    private String id;

    private String kyd;

    private String xm;

    private String fid;

    private String qx;

    private String zylx;

    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getKyd() {
        return kyd;
    }

    public void setKyd(String kyd) {
        this.kyd = kyd == null ? null : kyd.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public String getQx() {
        return qx;
    }

    public void setQx(String qx) {
        this.qx = qx == null ? null : qx.trim();
    }

    public String getZylx() {
        return zylx;
    }

    public void setZylx(String zylx) {
        this.zylx = zylx == null ? null : zylx.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}