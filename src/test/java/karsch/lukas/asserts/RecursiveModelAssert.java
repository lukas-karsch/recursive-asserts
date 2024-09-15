package karsch.lukas.asserts;

import karsch.lukas.model.Container;
import karsch.lukas.model.RecursiveModel;
import org.assertj.core.api.AbstractAssert;

public class RecursiveModelAssert extends AbstractAssert<RecursiveModelAssert, RecursiveModel> {
    protected RecursiveModelAssert(RecursiveModel actual) {
        super(actual, RecursiveModelAssert.class);
    }

    public static RecursiveModelAssert assertThat(RecursiveModel actual) {
        return new RecursiveModelAssert(actual);
    }

    public RecursiveModelAssert hasContainer(Container expectedContainer) {
        isNotNull();
        if(actual.getContainer() != expectedContainer) {
            failWithMessage("Expected model to contain <%s>, but was <%s>", expectedContainer, actual.getContainer());
        }
        return this;
    }

    public RecursiveModelParentAssert hasParent(RecursiveModel expectedParent) {
        isNotNull();
        int index = actual.getParents().indexOf(expectedParent);
        if(index == -1) {
            failWithMessage("Expected model to have <%s> as parent, but it did not", expectedParent);
        }
        return new RecursiveModelParentAssert(this, actual.getParents().get(index));
    }

    public RecursiveModelParentAssert hasChild(RecursiveModel expectedChild) {
        isNotNull();
        int index = actual.getChildren().indexOf(expectedChild);
        if(index == -1) {
            failWithMessage("Expected model to have <%s> as child, but it did not", expectedChild);
        }
        return new RecursiveModelParentAssert(this, actual.getChildren().get(index));
    }

     public static class RecursiveModelParentAssert extends AbstractAssert<RecursiveModelParentAssert, RecursiveModel> {
        private final RecursiveModelAssert origin;

        private RecursiveModelParentAssert(RecursiveModelAssert origin, RecursiveModel current) {
            super(current, RecursiveModelParentAssert.class);
            this.origin = origin;
        }

        public RecursiveModelParentAssert withContainer(Container expectedContainer) {
            isNotNull();
            if(actual.getContainer() != expectedContainer) {
                failWithMessage("Expected parent model <%s> to contain <%s>, but contained <%s>", actual, expectedContainer, actual.getContainer());
            }
            return this;
        }

        public RecursiveModelParentAssert withParent(RecursiveModel expectedParent) {
            isNotNull();
            int index = actual.getParents().indexOf(expectedParent);
            if(index == -1) {
                failWithMessage("Expected model to have <%s> as parent, but it did not", expectedParent);
            }
            return new RecursiveModelParentAssert(origin, actual.getParents().get(index));
        }

        public RecursiveModelAssert and() {
            return origin;
        }
    }
}
