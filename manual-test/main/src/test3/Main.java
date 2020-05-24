package test3;

import com.complexible.pinto.RDFMapper;
import common.TestClass;
import org.openrdf.model.Model;

public class Main {

    public static void main(String[] args) {

        // Create mapper
        RDFMapper mapper = RDFMapper.create();

        TestClass foo = new TestClass(1);
        TestClass bar = new TestClass(2);

        foo.getNeighbors().add(bar);
        bar.getNeighbors().add(foo);

        // Map Java Bean to model
        Model model = mapper.writeValue(foo);

        System.out.println(model);
    }
}
