package com.osfree.oscore.service;

import com.osfree.oscore.dto.SystemCodeDTO;

import java.util.List;

public interface SystemCodeService {

    SystemCodeDTO findDtoById(final Long id);

    SystemCodeDTO findDtoByKey(final String key);

    List<SystemCodeDTO> findDtoByCategory(final String category);

}
