package com.vector.udremaster.repository;

import com.vector.udremaster.entity.Playlist;
import com.vector.udremaster.entity.PlaylistId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, PlaylistId> {
}
