import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.List;

import com.complexible.common.openrdf.model.ModelIO;
import com.complexible.pinto.RDFMapper;

import org.openrdf.model.Model;
import org.openrdf.model.impl.SimpleValueFactory;
import org.openrdf.rio.RDFFormat;

public class Main {

    public static void main(String[] args) throws java.io.IOException {
        // Create mapper
        RDFMapper mapper = RDFMapper.create();

        // Load model
        Model original = ModelIO.read(new FileInputStream("original.xml"), RDFFormat.RDFXML);

        // Map model to Java Bean
        Ontology o = mapper.readValue(original, Ontology.class, SimpleValueFactory.getInstance().createIRI("http://www.semanticweb.org/cloud/ontologies/2020/4/untitled-ontology-20"));

        // Create a new person
        NamedIndividual newPerson = new NamedIndividual("Dan", 1);

        List<NamedIndividual> people = o.getNamedIndividuals();
        NamedIndividual mother =  people.get(people.indexOf(new NamedIndividual("Alice", 42)));
        NamedIndividual father =  people.get(people.indexOf(new NamedIndividual("Charlie", 36)));

        newPerson.setFather(father);
        newPerson.setMother(mother);

        // Add new person to model
        people.add(newPerson);

        // Map Java Bean to model
        Model modified = mapper.writeValue(o);

        // Write model
        ModelIO.write(modified, new FileWriter("modified.xml"), RDFFormat.RDFXML);
    }
}