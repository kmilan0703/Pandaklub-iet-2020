package common;

import com.complexible.pinto.Identifiable;
import com.complexible.pinto.annotations.RdfsClass;
import org.openrdf.model.Resource;
import org.openrdf.model.impl.SimpleValueFactory;

@RdfsClass("http://www.w3.org/2002/07/owl#ObjectProperty")
public class ObjectProperty implements Identifiable {
    private String name;

    public ObjectProperty() {
    }

    public ObjectProperty(String name) {
        this.name = name;
    }

    @Override
    public Resource id() {
        return SimpleValueFactory.getInstance().createIRI("http://www.semanticweb.org/cloud/ontologies/2020/4/untitled-ontology-20#" + name);
    }

    @Override
    public void id(Resource resource) {
        name = resource.stringValue().split("#")[1];
    }
}
