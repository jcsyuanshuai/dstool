package ai.biomind.cdss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class MyTable {
    @Id
    @GeneratedValue
    private Long id;
    private Long dbId;
    private String tableName;
    private String description;
}
