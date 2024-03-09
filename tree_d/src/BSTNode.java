public class BSTNode<T extends Comparable<T>> {
    T data;
    BSTNode<T> left;
    BSTNode<T> right;

    public BSTNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(data);
        buffer.append('\n');

        if (right != null) right.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
        if (left != null) left.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
    }
}