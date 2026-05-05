import java.util.Stack;

public class UndoableStringBuilder {

    private final StringBuilder stringBuilder;
    private final Stack<Snapshot> history;

    private record Snapshot(String state) {
    }

    public UndoableStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.history = new Stack<>();
        saveSnapshot();
    }

    public UndoableStringBuilder(String str) {
        this.stringBuilder = new StringBuilder(str);
        this.history = new Stack<>();
        saveSnapshot();
    }

    private void saveSnapshot() {
        history.push(new Snapshot(stringBuilder.toString()));
    }

    public void undo() {
        if (history.size() <= 1) {
            throw new IllegalStateException("Невозможно выполнить undo: достигнуто начальное состояние");
        }

        history.pop();
        Snapshot previousState = history.peek();
        stringBuilder.replace(0, stringBuilder.length(), previousState.state());
    }

    public UndoableStringBuilder append(String str) {
        stringBuilder.append(str);
        saveSnapshot();
        return this;
    }

    public UndoableStringBuilder append(char c) {
        stringBuilder.append(c);
        saveSnapshot();
        return this;
    }

    public UndoableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        saveSnapshot();
        return this;
    }

    public UndoableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        saveSnapshot();
        return this;
    }

    public UndoableStringBuilder deleteCharAt(int index) {
        stringBuilder.deleteCharAt(index);
        saveSnapshot();
        return this;
    }

    public UndoableStringBuilder replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        saveSnapshot();
        return this;
    }

    public UndoableStringBuilder reverse() {
        stringBuilder.reverse();
        saveSnapshot();
        return this;
    }


    public String toString() {
        return stringBuilder.toString();
    }

    public int length() {
        return stringBuilder.length();
    }

    public char charAt(int index) {
        return stringBuilder.charAt(index);
    }

    public String substring(int start) {
        return stringBuilder.substring(start);
    }

    public String substring(int start, int end) {
        return stringBuilder.substring(start, end);
    }
}
