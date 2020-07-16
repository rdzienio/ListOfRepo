package pl.postek.my_repo_list.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.postek.my_repo_list.domain.ListOfRepo;
import pl.postek.my_repo_list.repository.MyRepoListRepository;

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

    public ListOfRepo[] getRepository() {
        ListOfRepo[] repos = repository.readRepository();
        log.info("repositories: [{}]", repos);
        return repos;
    }
}
