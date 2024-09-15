package karsch.lukas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecursiveModel {
    private Container container;
    private List<RecursiveModel> parents;
    private List<RecursiveModel> children;

    public RecursiveModel(Container container, List<RecursiveModel> parents, List<RecursiveModel> children) {
        this.container = container;
        this.parents = parents;
        this.children = children;
    }

    public RecursiveModel(Container container) {
        this.container = container;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public List<RecursiveModel> getParents() {
        return parents;
    }

    public void setParents(List<RecursiveModel> parents) {
        if(parents == null) {
            this.parents = new ArrayList<>();
        }
        this.parents = parents;
    }

    public List<RecursiveModel> getChildren() {
        return children;
    }

    public void setChildren(List<RecursiveModel> children) {
        if(children == null) {
            this.children = new ArrayList<>();
        }
        this.children = children;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public boolean hasChildren() {
        return children != null && !children.isEmpty();
    }

    public void addParent(RecursiveModel parent) {
        Objects.requireNonNull(parent);
        parents.add(parent);
    }

    public void addChild(RecursiveModel child) {
        Objects.requireNonNull(child);
        children.add(child);
    }
}
