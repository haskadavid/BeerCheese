package edu.vse.daos;

import edu.vse.models.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageDao extends JpaRepository<PackageEntity, Integer> {

    List<PackageEntity> findByOrder_Id(int id);
}
