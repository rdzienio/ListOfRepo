package pl.postek.my_repo_list.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.postek.my_repo_list.domain.ListOfRepo;
import pl.postek.my_repo_list.service.MyRepoListService;

import java.io.Serializable;
import java.util.List;

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

    @GetMapping("/users/AnnaPostek")
    public ListOfRepo[] getRepoList(String[] repo) {
        ListOfRepo[] repository = service.getRepository(repo);
        log.info("repository:  [{}]", repository);
        return service.getRepository(repo);
    }

    @GetMapping("/users/AnnaPostek/repos")
    public ResponseEntity<ListOfRepo[]> getRepoList(@RequestBody ListOfRepo[] list) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, "application/json");
        log.info("repository:  [{}]", list);
        ResponseEntity<ListOfRepo[]> listofRepo = new ResponseEntity<>(list,
                headers, HttpStatus.CREATED);
        return listofRepo;
    }
}
