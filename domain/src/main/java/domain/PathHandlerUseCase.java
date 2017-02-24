package domain;

import java.util.ArrayList;
import java.util.List;

public class PathHandlerUseCase {

    private SomePort port;
    private List<SomeData> list;

    public PathHandlerUseCase(SomePort port) {
        this.port = port;
        this.list = new ArrayList<>();
    }

    public void execute(PathHandlerUseCaseObserver observer, String path) {
        PathHandler pathHandler = new PathHandler(path, observer, port, list);
        list.add(new SomeData("hmm"));
        pathHandler.handle();
    }

    static class PathHandler {
        private final List<SomeData> list;
        private String path;
        private PathHandlerUseCaseObserver observer;
        private SomePort port;

        public PathHandler(String path, PathHandlerUseCaseObserver observer, SomePort port, List<SomeData> list) {
            this.path = path;
            this.observer = observer;
            this.port = port;
            this.list = list;
        }

        public void handle() {
            if (success()) observer.success(responseData());
            if (failure()) observer.failed();
            if (found()) {
                new Thread(() -> {
                    observer.found();
                }).start();
            }

            if (error())
                observer.error();
        }

        private boolean error() {
            return path.equals("error");
        }

        private boolean found() {
            return path.equals("found");
        }

        private boolean failure() {
            return path.equals("failed");
        }

        private boolean success() {
            return path.equals("success");
        }

        private List<SomeData> responseData() {
            return list;
        }

    }
}

