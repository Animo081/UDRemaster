package com.vector.udremaster.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "playlist")
public class Playlist {

    @EmbeddedId
    private PlaylistId playlistId;

    protected Playlist() {
    }

    public Playlist(PlaylistId playlistId) {
        this.playlistId = playlistId;
    }

    public PlaylistId getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(PlaylistId playlistId) {
        this.playlistId = playlistId;
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


