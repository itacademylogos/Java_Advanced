package ua.lviv.lgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.FileMultipart;

@Repository
public interface FileMultipartRepository extends JpaRepository<FileMultipart, String> {}
