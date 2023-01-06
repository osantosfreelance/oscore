package com.osfree.oscore.dto;

import com.osfree.oscore.entity.SystemCode;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author osantos
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SystemCodeDTO extends BaseEntityDTO {

    private String key;
    private String value;
    private SystemCodeDTO category;

    public static SystemCodeDTO from(final SystemCode systemCode) {
        return SystemCodeDTO.builder()
                .id(systemCode.getId())
                .createDate(systemCode.getCreateDate())
                .updateDate(systemCode.getUpdateDate())
                .key(systemCode.getKey())
                .value(systemCode.getValue())
                .build();
    }
    
}
