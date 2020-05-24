package test1;

import com.complexible.pinto.Identifiable;
import com.complexible.pinto.annotations.RdfsClass;
import common.DataProperty;
import common.ObjectProperty;
import org.openrdf.model.Resource;
import org.openrdf.model.impl.SimpleValueFactory;

import java.util.List;

@RdfsClass("http://www.w3.org/2002/07/owl#Ontology")
public class Ontology implements Identifiable {
    List<NamedIndividual> namedIndividuals;
    List<DataProperty> dataProperties;
    List<ObjectProperty> objectProperties;

    public Ontology() {
    }

    public Ontology(List<NamedIndividual> namedIndividuals, List<DataProperty> dataProperties, List<ObjectProperty> objectProperties) {
        this.namedIndividuals = namedIndividuals;
        this.dataProperties = dataProperties;
        this.objectProperties = objectProperties;
    }

    public List<NamedIndividual> getNamedIndividuals() {
        return namedIndividuals;
    }

    public void setNamedIndividuals(List<NamedIndividual> namedIndividuals) {
        this.namedIndividuals = namedIndividuals;
    }

    public List<DataProperty> getDataProperties() {
        return dataProperties;
    }

    public void setDataProperties(List<DataProperty> dataProperties) {
        this.dataProperties = dataProperties;
    }

    public List<ObjectProperty> getObjectProperties() {
        return objectProperties;
    }

    public void setObjectProperties(List<ObjectProperty> objectProperties) {
        this.objectProperties = objectProperties;
    }

    @Override
    public Resource id() {
        return SimpleValueFactory.getInstance().createIRI("http://www.semanticweb.org/cloud/ontologies/2020/4/untitled-ontology-20");
    }

    @Override
    public void id(Resource resource) {
        /* no operation
        // This method is overwritten with an empty body on purpose
         */
    }
}
