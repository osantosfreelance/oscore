/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.osfree.oscore.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author OlieSantos
 *
 */
@Entity
@Table(name = "system_code")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SystemCode extends BaseEntity {

    @Column(name = "key_", nullable = false)
    private String key;

    @Column(name = "value_", nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name="parent_id")
    private SystemCode category;
    
}
