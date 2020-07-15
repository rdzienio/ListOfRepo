package pl.postek.my_repo_list.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.postek.my_repo_list.domain.ListOfRepo;
import pl.postek.my_repo_list.repository.MyRepoListRepository;

import java.io.Serializable;

@Service
@Slf4j
public class MyRepoListService {

    private MyRepoListRepository repository;

    public MyRepoListService(MyRepoListRepository repository) {
        this.repository = repository;
    }

    public String getList() {
       return repository.readRawJson();
    }

    public ListOfRepo[] getRepository(String[] repositories) {
        ListOfRepo[] serializable = repository.readRepository(repositories);
        log.info("repositories: [{}]", serializable);
        return serializable;
    }
}
