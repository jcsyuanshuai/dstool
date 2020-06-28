package ai.biomind.cdss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class MyDatabase {
    @Id
    @GeneratedValue
    private Long id;
    private Long jobId;
    private String databaseName;
    private String description;
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    public MyDatabase(Long id, String databaseName, String description, String url, String username, String password, String driverClassName) {
        this.id = id;
        this.url = url;
        this.databaseName = databaseName;
        this.description = description;
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
    }

    public MyDatabase() {
    }
}
