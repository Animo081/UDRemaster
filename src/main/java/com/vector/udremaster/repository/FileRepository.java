package com.vector.udremaster.repository;

import com.vector.udremaster.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FileRepository extends JpaRepository<File, Long> {

    File[] getFilesByOwnerId(@Param("owner_id") long ownerId);
}
