package api;

import domain.PathHandlerUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private PathHandlerUseCase pathHandlerUseCase;

    public ApiController(PathHandlerUseCase pathHandlerUseCase) {
        this.pathHandlerUseCase = pathHandlerUseCase;
    }

    @RequestMapping(value = "/test")
    public Response test(@RequestParam String path) {
        Response result = new Response();
        SpringPathHandlerUseCaseObserver observer = new SpringPathHandlerUseCaseObserver(result);
        pathHandlerUseCase.execute(observer, path);
        return result;
    }
}

