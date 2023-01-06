package com.osfree.oscore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author JunMinon
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @CreationTimestamp
	@Column(name = "create_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime createDate;

    @UpdateTimestamp
	@Column(name = "update_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime updateDate;
    
}
