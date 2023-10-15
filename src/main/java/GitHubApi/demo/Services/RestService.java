package GitHubApi.demo.Services;

import GitHubApi.demo.Dtos.GitHubRepositoryDTO;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class RestService {

    private final RestClient restClient;

    public RestService(RestClient restClient) {
        this.restClient = restClient;
    }

    public GitHubRepositoryDTO findall(String q, String sort, String order, Integer page, Integer perPage) {
        var uri = new StringBuilder("https://api.github.com/search/repositories");

        Map<String, Object> queryParams = new HashMap<>();
        if (q != null) {
            queryParams.put("q=", q);
        }
        if (sort != null) {
            queryParams.put("sort=", sort);
        }
        if (order != null) {
            queryParams.put("order=", order);
        }
        if (page != null) {
            queryParams.put("page=", page);
        }
        if (perPage != null) {
            queryParams.put("per_page=", perPage);
        }

        if (!queryParams.isEmpty()){
            uri.append("?");

            queryParams.forEach((k, v) ->{
                uri.append(k).append(v).append("&");
            });
        }

        return restClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
