package pl.postek.my_repo_list.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.postek.my_repo_list.domain.ListOfRepo;

import java.util.Map;

@Repository
@Slf4j
public class MyRepoListRepository {

    private static final String URL = "https://api.github.com/users/annapostek/repos";

    private final RestTemplate restTemplate;
    private final String repositories;

    public MyRepoListRepository(final RestTemplate restTemplate,
                                @Value("${user.repo.name}") final String repositories) {
        this.restTemplate = restTemplate;
        this.repositories = repositories;
        log.info("user.name [{}]", repositories);
    }

    public String readRawJson() {
        return restTemplate.getForObject(URL, String.class);
    }

    public ListOfRepo[] readRepository (String[] repositories) {
        Map<String, String> param = Map.of(
                "user", "AnnaPostek"
        );
        ResponseEntity<ListOfRepo[]> response = restTemplate.getForEntity(URL, ListOfRepo[].class, param);
        log.info("response:[{}]",response);
        log.info("response status :[{}]",response.getStatusCode());
        response.getHeaders()
                .forEach((key, value) -> log.info("header key: [{}] - value [{}]", key, value));
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return null;
    }

}
