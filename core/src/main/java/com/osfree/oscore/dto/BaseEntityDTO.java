package com.osfree.oscore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class BaseEntityDTO {

    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    
}
