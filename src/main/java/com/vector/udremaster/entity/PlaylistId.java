package com.vector.udremaster.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PlaylistId implements Serializable {

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "audio_id", nullable = false)
    private long audioId;

    protected PlaylistId() {}

    public PlaylistId(long userId, long audioId){
        this.userId = userId;
        this.audioId = audioId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAudioId() {
        return audioId;
    }

    public void setAudioId(long audioId) {
        this.audioId = audioId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
