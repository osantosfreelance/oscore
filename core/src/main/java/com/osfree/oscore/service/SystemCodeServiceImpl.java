package com.osfree.oscore.service;

import com.osfree.oscore.dto.SystemCodeDTO;
import com.osfree.oscore.repository.SystemCodeRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SystemCodeServiceImpl implements SystemCodeService {

    private final SystemCodeRepository repository;

    @Override
    public SystemCodeDTO findDtoById(final Long id) {
        val systemCode = repository.findById(id);
        return systemCode.isPresent() ? SystemCodeDTO.from(systemCode.get()) : null;
    }
}
