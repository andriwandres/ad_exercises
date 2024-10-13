package ch.hslu.ad.sw04;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class NodeTest {
    @Test()
    public void value_shouldReturnInitialValue() {
        var node = new Node<>(123);

        assertEquals(123, node.value());
    }

    @Test
    public void setLeftNode_shouldAssignNodeOnTheLeft() {
        var node = new Node<>(3);
        var newNode = new Node<>(2);

        node.setLeft(newNode);

        assertEquals(newNode, node.getLeft());
    }

    @Test
    public void setRightNode_shouldAssignNodeOnTheRight() {
        var node = new Node<>(3);
        var newNode = new Node<>(2);

        node.setRight(newNode);

        assertEquals(newNode, node.getRight());
    }

    @Test
    public void node_shouldBeEqualBasedOnTheirValue() {
        EqualsVerifier
                .forClass(Node.class)
                .withOnlyTheseFields("value")
                .withGenericPrefabValues(Node.class, (x) -> null)
                .verify();
    }
}
