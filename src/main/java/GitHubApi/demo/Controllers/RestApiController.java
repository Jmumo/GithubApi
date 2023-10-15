package GitHubApi.demo.Controllers;

import GitHubApi.demo.Dtos.GitHubRepositoryDTO;
import GitHubApi.demo.Services.RestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/getRepos")
public class RestApiController {

    private final RestService postService;

    public RestApiController(RestService postService) {
        this.postService = postService;
    }


    @GetMapping("")
    public GitHubRepositoryDTO findall(
            @RequestParam(name = "q",required = false) String q,
            @RequestParam(name = "sort",required = false) String sort,
            @RequestParam(name = "order",required = false) String order,
            @RequestParam(name = "page",required = false) Integer page,
            @RequestParam(name = "per_page",required = false) Integer per_page

    ){
        return postService.findall(q,sort,order,page,per_page);
    }
}
