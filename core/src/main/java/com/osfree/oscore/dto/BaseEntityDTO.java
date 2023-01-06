package com.osfree.oscore.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author osantos
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class BaseEntityDTO {

    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    
}
