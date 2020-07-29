package vn.nsi.iphoneshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.nsi.iphoneshop.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select  u from User u where u.username = :username")
    User findByUserName(String username);

    @Query("select  u from User u where u.username = :username or u.phone = :phone or u.email= :email")
    User findByUserNameOrPhoneOrEmail(String username, String phone, String email);

    @Query("select u from User u where u.id = :id")
    User findByID(Long id);



}
