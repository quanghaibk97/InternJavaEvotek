package evotek.edu.model;

import evotek.edu.Constants;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@NamedQueries({@NamedQuery(name = Constants.GROUP_BY_NAME, query = "from Group where name =:name")})
@Entity
@Table(name = "Groups")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Group {
  @Id
  @GeneratedValue
  private int id;
  private String name;

  @ManyToMany
  private Set<Fresher> freshers = new HashSet<>();



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

  public Set<Fresher> getFreshers() {
    return freshers;
  }

  public void setFreshers(Set<Fresher> freshers) {
    this.freshers = freshers;
  }

  public Group(String name, Set<Fresher> freshers) {
    this.name = name;
    this.freshers = freshers;
  }

  public Group(String name) {
    this.name = name;
  }

  public Group() {
    System.out.println("Created a group");
  }

  @Override
  public String toString() {
    return "Group{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
