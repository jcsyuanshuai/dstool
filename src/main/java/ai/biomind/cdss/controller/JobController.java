package ai.biomind.cdss.controller;

import ai.biomind.cdss.domain.MyJob;
import ai.biomind.cdss.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @RequestMapping("/job")
    public List<MyJob> find() {
        return jobRepository.findAll();
    }
}
