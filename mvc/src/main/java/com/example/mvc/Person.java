package com.example.mvc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author qiuchangdong
 * @Type Person
 * @Desc 。
 * @date 2021-03-10 14:44:28
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
}
