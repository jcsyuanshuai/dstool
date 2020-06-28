package ai.biomind.cdss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class MyJob {
    @Id
    @GeneratedValue
    private Long id;
    private String jobName;
    private String description;
    private Boolean isActive;
    private Long lastExecuteTimeMills;
    private Integer cycle;
}
