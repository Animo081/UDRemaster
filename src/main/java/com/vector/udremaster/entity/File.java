package com.vector.udremaster.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "files")
public class File {

    @Id
    @Column(name = "file_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fileId;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "size", nullable = false)
    private long size;

    @CreationTimestamp
    @Column(name = "inserted_on", nullable = false)
    private Timestamp insertedOn;

    @Column(name = "owner_id", nullable = false)
    private long ownerId;

    @Column(name = "real_name", nullable = false)
    private String realName;

    protected File() {}

    public File(String url, String realName, String name, String type, long size){
        this.url = url;
        this.realName = realName;
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Timestamp getInsertedOn() {
        return insertedOn;
    }

    public void setInsertedOn(Timestamp insertedOn) {
        this.insertedOn = insertedOn;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
