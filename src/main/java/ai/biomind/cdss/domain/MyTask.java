package ai.biomind.cdss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class MyTask {
    @Id
    @GeneratedValue
    private Long id;
    private Long jobId;
    private Long dbId;
    private Long tbId;
    private String operation;
    private String trigger;
}
