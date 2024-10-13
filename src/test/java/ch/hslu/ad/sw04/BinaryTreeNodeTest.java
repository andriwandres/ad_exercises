package ch.hslu.ad.sw04;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class BinaryTreeNodeTest {
    @Test()
    public void value_shouldReturnInitialValue() {
        var node = new BinaryTreeNode<>(123);

        assertEquals(123, node.value());
    }

    @Test
    public void setLeftNode_shouldAssignNodeOnTheLeft() {
        var node = new BinaryTreeNode<>(3);
        var newNode = new BinaryTreeNode<>(2);

        node.setLeft(newNode);

        assertEquals(newNode, node.left());
    }

    @Test
    public void setRightNode_shouldAssignNodeOnTheRight() {
        var node = new BinaryTreeNode<>(3);
        var newNode = new BinaryTreeNode<>(2);

        node.setRight(newNode);

        assertEquals(newNode, node.right());
    }

    @Test
    public void node_shouldBeEqualBasedOnTheirValue() {
        EqualsVerifier
                .forClass(BinaryTreeNode.class)
                .withOnlyTheseFields("hashCode")
                .withGenericPrefabValues(BinaryTreeNode.class, (x) -> null)
                .verify();
    }
}
