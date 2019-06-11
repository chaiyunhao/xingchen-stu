package cn.xingchen.model;

import java.util.Date;

public class OrderNodeInstances {
    private Long id;

    private Long fid;

    private String names;

    private String desc;

    private Date created_at;

    private Date updated_at;

    private Byte first_node;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names == null ? null : names.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Byte getFirst_node() {
        return first_node;
    }

    public void setFirst_node(Byte first_node) {
        this.first_node = first_node;
    }
}