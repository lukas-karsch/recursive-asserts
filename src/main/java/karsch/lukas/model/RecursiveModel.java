package karsch.lukas.model;

import java.util.List;

public class RecursiveModel {
    private String name;
    private List<RecursiveModel> parents;
    private List<RecursiveModel> children;

    public RecursiveModel(String name, List<RecursiveModel> parents, List<RecursiveModel> children) {
        this.name = name;
        this.parents = parents;
        this.children = children;
    }

    public RecursiveModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecursiveModel> getParents() {
        return parents;
    }

    public void setParents(List<RecursiveModel> parents) {
        this.parents = parents;
    }

    public List<RecursiveModel> getChildren() {
        return children;
    }

    public void setChildren(List<RecursiveModel> children) {
        this.children = children;
    }

    public boolean hasChildren() {
        return children != null && !children.isEmpty();
    }
}
