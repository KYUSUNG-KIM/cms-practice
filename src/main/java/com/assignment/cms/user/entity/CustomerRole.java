package com.assignment.cms.user.entity;

import com.assignment.cms.user.constants.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@IdClass(value = CustomerRoleId.class)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRole {

    @Id
    private long customerId;

    @Id
    private String role;

}
