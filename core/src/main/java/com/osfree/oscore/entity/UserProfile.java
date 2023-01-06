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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * @author OlieSantos
 *
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserProfile extends BaseEntity {

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @Column(name = "first_name", nullable = false, length = 55)
    private String firstName;

    @Column(name = "middle_name", length = 55)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 55)
    private String lastName;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "birth_date")
    private String birthDate;
    
}
