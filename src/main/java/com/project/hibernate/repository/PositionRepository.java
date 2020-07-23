package com.project.hibernate.repository;



import com.project.hibernate.entity.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {

    Position findById(int id);

    // find by name enable with full text search
    @Query(value = "SELECT * FROM POSITION WHERE (COALESCE(name,'') LIKE %:name% ", nativeQuery = true)
    List<Position> searchByName(@Param("name")String name);


}