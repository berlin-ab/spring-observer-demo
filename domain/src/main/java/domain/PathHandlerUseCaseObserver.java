package domain;

import java.util.List;

public interface PathHandlerUseCaseObserver {
    void success(List<SomeData> data);
    void failed();
    void found();
    void error();
}
