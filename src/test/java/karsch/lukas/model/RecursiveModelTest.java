package karsch.lukas.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static karsch.lukas.asserts.RecursiveModelAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RecursiveModelTest {
    @Test
    void test() {
        Container entryContainer = new Container("1", "Content");
        Container parentContainer = new Container("2", "Content");
        var entry = new RecursiveModel(entryContainer);
        var parent = new RecursiveModel(parentContainer);

        entry.addParent(parent);
        parent.addChild(entry);

        assertThat(entry).hasContainer(entryContainer);
        assertThat(entry).hasParent(parent).withContainer(parentContainer);
    }
}
