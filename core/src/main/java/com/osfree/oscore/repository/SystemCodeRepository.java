package com.osfree.oscore.repository;

import com.osfree.oscore.entity.SystemCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SystemCodeRepository extends JpaRepository<SystemCode, Long> {

    Optional<SystemCode> findByKey(final String key);
    List<SystemCode> findByCategoryKey(final String category);


}