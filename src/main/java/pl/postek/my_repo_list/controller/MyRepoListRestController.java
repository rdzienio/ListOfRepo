package pl.postek.my_repo_list.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.postek.my_repo_list.service.MyRepoListService;

import java.io.Serializable;

@RestController
@Slf4j
public class MyRepoListRestController {
    private MyRepoListService service;

    public MyRepoListRestController(MyRepoListService service) {
        this.service = service;
    }

    @GetMapping("/postek")
    public String repo(){
        log.info("my repo [{}]");
        return service.getList();
    }

    @GetMapping("/users/AnnaPostek/repos")
    public Serializable getRepoList(String[] repo) {
        Serializable repository = service.getRepository(repo);
        log.info("repository:  [{}]", repository);
        return service.getRepository(repo);
    }
}
