package vn.nsi.iphoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.nsi.iphoneshop.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
