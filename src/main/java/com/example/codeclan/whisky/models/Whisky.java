package com.example.codeclan.whisky.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="whiskies")
public class Whisky {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "distillery_id")
    @JsonIgnoreProperties({"whiskies"})
    private Distillery distillery;

    @Column
    private int year;

    @Column
    private int age;

    public Whisky(String name, int year, int age, Distillery distillery) {
        this.name = name;
        this.year = year;
        this.age = age;
        this.distillery = distillery;
    }

    public Whisky() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Distillery getDistillery() {
        return distillery;
    }

    public void setDistillery(Distillery distillery) {
        this.distillery = distillery;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
