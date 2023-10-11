package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table(name = "tools")
@NoArgsConstructor
@AllArgsConstructor
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tool_id")
    private Long id;


    @ManyToMany(mappedBy = "tools")
    private Set<PersonalData> personalData;

    @Column(name = "name")
    private String name;

    @Column(name = "icon_url")
    private String iconUrl;

}
