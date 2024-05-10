package evotek.edu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String street;
  private String district;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public Address() {
  }

  public Address(String street, String district) {
    this.street = street;
    this.district = district;
  }

}
