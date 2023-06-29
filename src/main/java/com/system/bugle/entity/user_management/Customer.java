package com.system.bugle.entity.user_management;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_id_seq_gen", sequenceName = "customer_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "customer_id_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="customer_name",length = 50,nullable = false)
    private String customerName;

    @Column(name="customer_email",length = 50,nullable = false)
    private String customerEmail;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_department_id"))
    private Department department;

}
