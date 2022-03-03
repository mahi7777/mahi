package fi.spring.data.bootjpa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fi.spring.data.bootjpa1.entity.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
	
@Query(name="byName",nativeQuery=true,value="select * from users where name=:var1")	
public Users findbyName(@Param("var1")String name);

}
