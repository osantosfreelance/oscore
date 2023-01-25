package com.osfree.oscore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public abstract class SearchRequest {

    private String searchString;
    private Integer generation;

}
