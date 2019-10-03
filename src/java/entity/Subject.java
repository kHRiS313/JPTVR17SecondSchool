package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Subject implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private int Id;
private String name;
private int hours;

    public Subject() {
    }

    public Subject(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.Id;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.hours;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Subject other = (Subject) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (this.hours != other.hours) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + Id + ", name=" + name + ", hours=" + hours + '}';
    }


}