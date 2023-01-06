package com.osfree.oscore.dto;

import com.osfree.oscore.entity.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author osantos
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDTO extends BaseEntityDTO {

    private String externalId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNo;
    private String birthDate;

    public static UserDTO from(final UserProfile userProfile) {
        return UserDTO.builder()
                .id(userProfile.getId())
                .externalId(userProfile.getExternalId())
                .firstName(userProfile.getFirstName())
                .middleName(userProfile.getMiddleName())
                .lastName(userProfile.getLastName())
                .mobileNo(userProfile.getMobileNo())
                .birthDate(userProfile.getBirthDate())
                .build();
    }
    
}
