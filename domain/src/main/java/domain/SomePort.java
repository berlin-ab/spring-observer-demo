package domain;

import java.util.List;

public interface SomePort {
    void save(SomeData data);
    List<SomeData> find();
}
