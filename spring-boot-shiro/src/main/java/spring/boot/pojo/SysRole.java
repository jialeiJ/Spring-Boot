package spring.boot.pojo;

public class SysRole {
    private String id;

    private String kyd;

    private String ms;

    private String js;

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

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms == null ? null : ms.trim();
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js == null ? null : js.trim();
    }
}