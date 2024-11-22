package com.example.stratyp.user;

import com.example.stratyp.user.ServiceRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRoleRepository extends JpaRepository<ServiceRole,Long> {
}
