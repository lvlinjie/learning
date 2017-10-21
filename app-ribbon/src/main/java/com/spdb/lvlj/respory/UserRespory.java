package com.spdb.lvlj.respory;

import com.spdb.lvlj.entity.CloudUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespory extends JpaRepository<CloudUser, Integer> {
}
