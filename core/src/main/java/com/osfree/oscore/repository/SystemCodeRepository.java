package com.osfree.oscore.repository;

import com.osfree.oscore.entity.SystemCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemCodeRepository extends JpaRepository<SystemCode, Long> {

}