package com.argo.user_commons.User.domain.repositroy;



import com.commons.user.models.entity.User;
import com.commons.user.models.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDetails  extends JpaRepository<UserDetails, User> {
}
