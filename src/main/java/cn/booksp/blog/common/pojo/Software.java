package cn.booksp.blog.common.pojo;

import java.util.Date;

public class Software {
    private Integer id;

    private String name;

    private String version;

    private String url;

    private String baiduyun;

    private String csdn;

    private Date releaseTime;

    private Date uploadTime;

    private String intro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getBaiduyun() {
        return baiduyun;
    }

    public void setBaiduyun(String baiduyun) {
        this.baiduyun = baiduyun == null ? null : baiduyun.trim();
    }

    public String getCsdn() {
        return csdn;
    }

    public void setCsdn(String csdn) {
        this.csdn = csdn == null ? null : csdn.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}