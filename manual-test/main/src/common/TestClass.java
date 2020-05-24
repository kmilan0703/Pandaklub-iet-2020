package common;

import com.complexible.pinto.annotations.RdfId;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    private List<TestClass> neighbors = new ArrayList<>();
    private int id;

    public TestClass() {
    }

    public TestClass(int id) {
        this.id = id;
    }

    public TestClass(List<TestClass> neighbors) {
        this.neighbors = neighbors;
    }

    public List<TestClass> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<TestClass> neighbors) {
        this.neighbors = neighbors;
    }

    @RdfId
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
