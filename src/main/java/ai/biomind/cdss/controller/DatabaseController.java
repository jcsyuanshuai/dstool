package ai.biomind.cdss.controller;

import ai.biomind.cdss.domain.MyDatabase;
import ai.biomind.cdss.repo.DatabaseRepository;
import ai.biomind.cdss.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DatabaseController {

    @Autowired
    DatabaseRepository databaseRepository;

    @RequestMapping("/db/find")
    public List<MyDatabase> find() {
        return databaseRepository.findAll();
    }

    @RequestMapping("/db/save")
    public MyDatabase save(
            @RequestParam("url") String url,
            @RequestParam("un") String username,
            @RequestParam("pas") String password,
            @RequestParam("dcn") String driverClassName) {
        MyDatabase myDatabase = new MyDatabase(
                null, null, null,
                url, username, password, driverClassName);
        System.out.println(myDatabase);
        return databaseRepository.save(myDatabase);
    }

    @RequestMapping("/db/test/{id}")
    public Boolean test(@PathVariable("id") Long id) {
        MyDatabase mds = databaseRepository.getOne(id);
        return DBUtil.test(mds);
    }

    @RequestMapping("/db/tables/{id}")
    public List<String> showTables(@PathVariable("id") Long id) {
        MyDatabase mds = databaseRepository.getOne(id);
        return DBUtil.showTables(mds);
    }

}
