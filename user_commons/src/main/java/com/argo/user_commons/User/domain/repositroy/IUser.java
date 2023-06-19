package com.argo.user_commons.User.domain.repositroy;




import com.commons.user.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUser  extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);
}
