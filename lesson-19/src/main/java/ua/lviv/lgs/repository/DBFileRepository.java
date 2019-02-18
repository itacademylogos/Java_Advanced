package ua.lviv.lgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}
