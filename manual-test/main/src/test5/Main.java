package test5;

import com.complexible.pinto.RDFMapper;
import common.TestClass;
import org.openrdf.model.Model;
import org.openrdf.model.impl.SimpleValueFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    private static void createGraph(TestClass root, int width, int complexity) throws Exception {
        if(complexity > width) {
            throw new Exception("Complexity can't be greater then width");
        }
        List<TestClass> layer1 = new ArrayList<>(width);
        List<TestClass> layer2 = new ArrayList<>(width);
        for(int i = 0; i < width; i++) {
            layer1.add(new TestClass(random.nextInt()));
            layer2.add(new TestClass(random.nextInt()));
        }
        root.getNeighbors().addAll(layer1);
        for(int i = 0; i < width; i++) {
            TestClass t = layer1.get(i);
            int from = Math.min(i, width - complexity);
            for(int j = from; j < from + complexity; j++) {
                t.getNeighbors().add(layer2.get(j));
            }
        }
    }

    public static void main(String[] args) throws Exception {

        // Create mapper
        RDFMapper mapper = RDFMapper.create();

        // Create graph
        TestClass root = new TestClass();
        createGraph(root, 150, 150);

        // Measure time
        long start = System.currentTimeMillis();

        // Map Java Bean to model
        Model model = mapper.writeValue(root);

        // Measure time
        long end = System.currentTimeMillis();

        System.out.println("To model: " + (end - start));

        // Measure time
        start = System.currentTimeMillis();

        // Map Java Bean to model
        TestClass newRoot = mapper.readValue(model, TestClass.class, SimpleValueFactory.getInstance().createIRI("tag:complexible:pinto:cfcd208495d565ef66e7dff9f98764da"));

        // Measure time
        end = System.currentTimeMillis();

        System.out.println("From model: " + (end - start));
    }
}
