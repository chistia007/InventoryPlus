package chistia007.github.io.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Make sure to add this annotation to enable JPA entity mapping
@Getter
@Setter
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @JsonCreator
    public User(@JsonProperty("name") String name, @JsonProperty("email") String email) {
        this.name = name != null ? name : "";
        this.email = email != null ? email : "";
    }

    public User() {
    }

    // Getter and Setter methods for the 'name' field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Other getter and setter methods for the 'id' and 'email' fields as needed
}