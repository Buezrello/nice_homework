package com.example.nice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Height {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`value`")
    private Integer value;

    public Height(Long id, int value) {
        this.id = id;
        this.value = value;
    }

}
