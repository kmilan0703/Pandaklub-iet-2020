package test2;

import com.complexible.pinto.Identifiable;
import com.complexible.pinto.annotations.RdfProperty;
import com.complexible.pinto.annotations.RdfsClass;
import org.openrdf.model.Resource;
import org.openrdf.model.impl.SimpleValueFactory;

import java.util.List;
import java.util.Objects;

@RdfsClass("http://www.w3.org/2002/07/owl#NamedIndividual")
public class NamedIndividual implements Identifiable {
    private Integer age;
    private String name;
    private List<NamedIndividual> friends;

    public NamedIndividual() {
    }

    public NamedIndividual(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @RdfProperty("http://www.semanticweb.org/cloud/ontologies/2020/4/untitled-ontology-20#age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @RdfProperty("http://www.semanticweb.org/cloud/ontologies/2020/4/untitled-ontology-20#friend")
    public List<NamedIndividual> getFriends() {
        return friends;
    }

    public void setFriends(List<NamedIndividual> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamedIndividual that = (NamedIndividual) o;
        return Objects.equals(age, that.age) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
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