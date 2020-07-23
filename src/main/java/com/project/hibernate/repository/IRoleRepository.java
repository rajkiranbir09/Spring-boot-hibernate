package com.project.hibernate.repository;


import com.project.hibernate.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface IRoleRepository extends JpaRepository<Role, Long> {


//    // find role
//    @Query(" SELECT r FROM Role r WHERE r.roleName = :roleName")
//    public Role findRole(@Param("roleName") String role);
}