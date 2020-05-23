package test2;

import com.complexible.common.openrdf.model.ModelIO;
import com.complexible.pinto.RDFMapper;
import org.openrdf.model.Model;
import org.openrdf.model.impl.SimpleValueFactory;
import org.openrdf.rio.RDFFormat;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws java.io.IOException {
        // Create mapper
        RDFMapper mapper = RDFMapper.create();

        // Load model
        Model original = ModelIO.read(new FileInputStream("original2.xml"), RDFFormat.RDFXML);

        // Map model to Java Bean
        Ontology o = mapper.readValue(original, Ontology.class, SimpleValueFactory.getInstance().createIRI("http://www.semanticweb.org/cloud/ontologies/2020/4/untitled-ontology-20"));

        // Map Java Bean to model
        Model modified = mapper.writeValue(o);

        // Write model
        ModelIO.write(modified, new FileWriter("modified2.xml"), RDFFormat.RDFXML);
    }
}