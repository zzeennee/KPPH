package com.kpph.api.entity;

import lombok.*;

import javax.persistence.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="test2")
@Entity
public class Test2 {

    @Id
    private Integer id;
    @Column(length=300)
    private String test2;
}
