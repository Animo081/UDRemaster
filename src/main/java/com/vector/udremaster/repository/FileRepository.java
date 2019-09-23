package com.vector.udremaster.repository;

import com.vector.udremaster.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {

    Optional<List<File>> findAllByOwnerId(@Param("owner_id") long ownerId);
}
