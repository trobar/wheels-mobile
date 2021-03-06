package com.doit.wheels.dao.repositories;

import com.doit.wheels.dao.entities.AccessLevel;
import com.doit.wheels.utils.enums.AccessLevelTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessLevelRepository extends JpaRepository<AccessLevel, Long> {

    AccessLevel findAccessLevelByAccessLevel(AccessLevelTypeEnum AccessLevelTypeEnum);
}
