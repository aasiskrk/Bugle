package com.system.bugle.entity.user_management;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class EmailCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Email_Seq_GEN")
    @SequenceGenerator(name = "Email_Seq_GEN", sequenceName = "Email_Seq", initialValue = 1,
            allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String host;
    private String port;
    private Date date;
    private Boolean active;
    private String protocol;

}
