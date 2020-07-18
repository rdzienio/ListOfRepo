package pl.postek.my_repo_list.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Branch {

    @JsonProperty("name")
    private String branchName;
    @JsonProperty("protected")
    private boolean isProtected;

    private CommitInfo commit;

}
