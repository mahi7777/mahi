package fi.spring.data.bootjpa.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fi.spring.data.bootjpa.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
@Query(name="byName", nativeQuery=true,value="select * from users where name=:var1")
public Optional<User> findByName(@Param("var1")String name);
@Query(name="byEmail", nativeQuery=false,value="select * from users where email=:pemail")
public Optional<User> findByEmail(@Param("pemail")String name);
@Modifying
@Query(name="changePassword",nativeQuery=true,value="update user set password=:pwd where username=:uname")
@Transactional
public void changePassword(@Param("uname")String userName,@Param("pwd")String password);
}