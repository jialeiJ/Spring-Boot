package spring.boot.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class TableUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String bh;

    private String xm;

    private String sfz;

    private String nl;

    private String mm;

    private String sjh;

    private String jtzz;

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh == null ? null : bh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz == null ? null : sfz.trim();
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl == null ? null : nl.trim();
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm == null ? null : mm.trim();
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh == null ? null : sjh.trim();
    }

    public String getJtzz() {
        return jtzz;
    }

    public void setJtzz(String jtzz) {
        this.jtzz = jtzz == null ? null : jtzz.trim();
    }
}