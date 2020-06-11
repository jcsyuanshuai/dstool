package ai.biomind.cdss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;

    public User() {

    }

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
