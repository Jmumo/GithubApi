package GitHubApi.demo.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class GitHubRepositoryDTO {
    @JsonProperty("total_count")
    private int total_count;
    @JsonProperty("incomplete_results")
    private boolean incomplete_results;
    @JsonProperty("items")
    private List<Item> items;

}
