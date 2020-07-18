package pl.postek.my_repo_list.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommitInfo {
    private String sha;
    private String url;
}
