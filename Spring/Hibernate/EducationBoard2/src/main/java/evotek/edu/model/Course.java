package evotek.edu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private int id;

  @Column
  private String name;

  @Temporal(TemporalType.DATE)
  private Date createdDate;

  @ElementCollection(fetch = FetchType.EAGER)
  private List<Syllabus> syllabuses = new ArrayList<Syllabus>();

  public Course(String name) {
    this.name = name;
  }

  public List<Syllabus> getSyllabuses() {
    return syllabuses;
  }

  public void setSyllabuses(List<Syllabus> syllabuses) {
    this.syllabuses = syllabuses;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  public Course() {
  }

  public Course(String name, Date createdDate) {
    this.name = name;
    this.createdDate = createdDate;
  }

  public Course(String name, Date createdDate, List<Syllabus> syllabuses) {
    this.name = name;
    this.createdDate = createdDate;
    this.syllabuses = syllabuses;
  }
}

