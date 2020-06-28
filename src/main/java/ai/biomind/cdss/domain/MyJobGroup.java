package ai.biomind.cdss.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class MyJobGroup {
    @Id
    @GeneratedValue
    private Long id;

//    private List<MyJob> jobs;


}
