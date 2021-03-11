package com.example.webflux

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("person")
data class Person(@Id var id: Int?, var name: String)
