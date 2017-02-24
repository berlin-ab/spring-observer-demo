package api;

import domain.SomeData;
import domain.PathHandlerUseCaseObserver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

class SpringPathHandlerUseCaseObserver implements PathHandlerUseCaseObserver {
    private Response result;

    SpringPathHandlerUseCaseObserver(Response result) {
        this.result = result;
    }

    @Override
    public void success(List<SomeData> data) {
        complete(ResponseEntity.ok(data));
    }

    @Override
    public void failed() {
        complete(ResponseEntity.badRequest().body("Some failure"));
    }

    @Override
    public void found() {
        complete(
            ResponseEntity
                    .status(HttpStatus.TEMPORARY_REDIRECT)
                    .location(URI.create("/test?path=success"))
                    .build()
        );
    }

    @Override
    public void error() {
        complete(ResponseEntity.badRequest().body("Failed with error"));
    }

    private void complete(ResponseEntity responseEntity) {
        result.setResult(responseEntity);
    }

}