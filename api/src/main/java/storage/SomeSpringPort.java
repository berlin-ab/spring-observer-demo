package storage;

import domain.SomeData;
import domain.SomePort;

import java.util.ArrayList;
import java.util.List;

public class SomeSpringPort implements SomePort {
    List<SomeData> list = new ArrayList<>();

    @Override
    public void save(SomeData data) {
        list.add(data);
    }

    @Override
    public List<SomeData> find() {
        return list;
    }
}
