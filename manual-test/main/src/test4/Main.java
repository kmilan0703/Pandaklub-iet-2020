package test4;

import com.complexible.pinto.RDFMapper;
import common.TestClass;
import org.openrdf.model.Model;
import org.openrdf.model.impl.SimpleValueFactory;

import java.util.Random;

public class Main {

    private static Random random = new Random();

    private static void createTree(TestClass root, int branching, int depth) {
        if(depth == 0) {
            return;
        }
        for(int i = 0; i < branching; i++) {
            TestClass t = new TestClass(random.nextInt());
            root.getNeighbors().add(t);
            createTree(t, branching, depth - 1);
        }
    }

    public static void main(String[] args) {

        // Create mapper
        RDFMapper mapper = RDFMapper.create();

        // Create tree
        TestClass root = new TestClass();
        createTree(root, 2, 14);

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
