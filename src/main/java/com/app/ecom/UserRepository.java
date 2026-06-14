package com.app.ecom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //we just need to declare this interface and specify the entity type and primarykey.
    // we will get ready made actions which allow us to deal with database
}
