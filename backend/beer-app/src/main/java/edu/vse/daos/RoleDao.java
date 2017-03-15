package edu.vse.daos;

import edu.vse.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleDao extends JpaRepository<RoleEntity, Integer> {

    RoleEntity getOne(Integer id);

    RoleEntity findByName(String name);

    List<RoleEntity> findAll();

    @Query(value = "SELECT r.id, r.name " +
            "FROM role r JOIN user_role ur ON r.id=ur.role " +
            "WHERE ur.user=?1",
            nativeQuery = true
    )
    List<RoleEntity> findUsersRoles(int id);
}
