package com.example.stratyp.repository;

import com.example.stratyp.Entity.ServiceRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRoleRepository extends JpaRepository<ServiceRole,Long> {
}
