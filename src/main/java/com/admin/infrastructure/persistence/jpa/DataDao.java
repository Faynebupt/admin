package com.admin.infrastructure.persistence.jpa;

import com.admin.domain.modle.Data;
import com.admin.interfaces.facade.commondobject.UserCommond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by NewUser on 2017/11/14.
 */
@Repository
public interface DataDao extends JpaRepository<Data,Long> {

}
