package task3;

import java.util.Stack;

public class StringBuilderWithUndo {
    private interface Action{
        void undo();
    }
    private class DeleteAction implements Action{
        private int size;

        DeleteAction(int size) {
            this.size = size;
        }

        public void undo(){
            stringBuilder.delete(
                    stringBuilder.length() - size, stringBuilder.length());
        }
    }

    private StringBuilder stringBuilder;
    private Stack <Action> actions = new Stack<>();

    private StringBuilderWithUndo() {
        stringBuilder = new StringBuilder();
    }
    private StringBuilderWithUndo(CharSequence seq) {
        stringBuilder = new StringBuilder(seq);
    }
    private StringBuilderWithUndo(int capacity) {
        stringBuilder = new StringBuilder(capacity);
    }
    StringBuilderWithUndo(String str) {
        stringBuilder = new StringBuilder(str);
    }
    public StringBuilderWithUndo append(String str) {
        stringBuilder.append(str);

        Action action = () -> stringBuilder.delete(
                stringBuilder.length() - str.length() -1,
                stringBuilder.length());

        actions.add(action);
        return this;
    }
    public StringBuilderWithUndo append(boolean b)
    {
        String appended = String.valueOf(b);
        Action action = () -> stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
        actions.push(action);
        stringBuilder.append(b);
        return this;
    }
    public StringBuilderWithUndo append(char c)
    {
        Action action = () -> stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        actions.push(action);
        stringBuilder.append(c);
        return this;
    }
    public StringBuilderWithUndo append(char[] str)
    {
        String appended = String.valueOf(str);
        Action action = () -> stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
        actions.push(action);
        stringBuilder.append(str);
        return this;
    }
    public StringBuilderWithUndo append(char[] str, int offset, int len)
    {
        String appended = String.valueOf(str).substring(offset,offset + len);

        Action action = () -> stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
        actions.push(action);
        stringBuilder.append(str, offset, len);
        return this;
    }
    public StringBuilderWithUndo append(CharSequence s)
    {
        Action action = () -> stringBuilder.delete(stringBuilder.length() - s.length(), stringBuilder.length());
        actions.push(action);
        stringBuilder.append(s);
        return this;
    }
    public StringBuilderWithUndo append(CharSequence s, int start, int end)
    {
        String appended = String.valueOf(s).substring(start, end);
        Action action = () -> stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
        actions.push(action);
        stringBuilder.append(s, start, end);
        return this;
    }
    public StringBuilderWithUndo append(double d)
    {
        String appended = String.valueOf(d);
        Action action = () -> stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
        actions.push(action);
        stringBuilder.append(d);
        return this;
    }
    public StringBuilderWithUndo append(int i)
    {
        String appended = String.valueOf(i);
        Action action = () -> stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
        actions.push(action);
        stringBuilder.append(i);
        return this;
    }
    public StringBuilderWithUndo append(long lng)
    {
        String appended = String.valueOf(lng);
        Action action = () -> stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
        actions.push(action);
        stringBuilder.append(lng);
        return this;
    }
    public StringBuilderWithUndo append(Object o)
    {
        String appended = String.valueOf(o);
        Action action = () -> stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
        actions.push(action);
        stringBuilder.append(o);
        return this;
    }
    public StringBuilderWithUndo append(StringBuffer sb)
    {
        String appended = String.valueOf(sb);
        Action action = () -> stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
        actions.push(action);
        stringBuilder.append(sb);
        return this;
    }
    public StringBuilderWithUndo appendCodePoint(int codePoint) {
        int lenghtBefore = stringBuilder.length();
        stringBuilder.appendCodePoint(codePoint);
        actions.add(new DeleteAction(stringBuilder.length() - lenghtBefore));
        return this;
    }


    public StringBuilderWithUndo delete(int start, int end) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        actions.add(() -> stringBuilder.insert(start, deleted));
        return this;
    }

    public StringBuilderWithUndo deleteCharAt(int index) {
        char deleted = stringBuilder.charAt(index);
        stringBuilder.deleteCharAt(index);
        actions.add(() -> stringBuilder.insert(index, deleted));
        return this;
    }

    public StringBuilderWithUndo replace(int start, int end, String str) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.replace(start, end, str);
        actions.add(() -> stringBuilder.replace(start, end, deleted));
        return this;
    }

    public StringBuilderWithUndo insert(int index, char[] str, int offset, int len) {
        String inserted = String.valueOf(str).substring(offset, offset + len);
        Action action = () -> stringBuilder.delete(offset, offset + inserted.length());
        actions.push(action);
        stringBuilder.insert(index, str, offset, len);
        return this;
    }

    public StringBuilderWithUndo insert(int offset, String str) {
        Action action = () -> stringBuilder.delete(offset, offset + str.length());
        actions.push(action);
        stringBuilder.insert(offset, str);
        return this;
    }
    public StringBuilderWithUndo insert(int offset, boolean b)
    {
        String inserted = String.valueOf(b);
        Action action = () -> stringBuilder.delete(offset, offset + inserted.length());
        actions.push(action);
        stringBuilder.insert(offset, b);
        return this;
    }
    public StringBuilderWithUndo insert(int offset, char c)
    {
        Action action = () -> stringBuilder.deleteCharAt(offset);
        actions.push(action);
        stringBuilder.insert(offset, c);
        return this;
    }

    public StringBuilderWithUndo insert(int dstOffset, CharSequence s)
    {
        Action action = () -> stringBuilder.delete(dstOffset, dstOffset + s.length());
        actions.push(action);
        stringBuilder.insert(dstOffset, s);
        return this;
    }
    public StringBuilderWithUndo insert(int dstOffset, CharSequence s, int start, int end)
    {
        String inserted = String.valueOf(s).substring(start, end);
        Action action = () -> stringBuilder.delete(dstOffset, dstOffset + inserted.length());
        actions.push(action);
        stringBuilder.insert(dstOffset, s, start, end);
        return this;
    }
    public StringBuilderWithUndo insert(int offset, double d)
    {
        String inserted = String.valueOf(d);
        Action action = () -> stringBuilder.delete(offset, offset + inserted.length());
        actions.push(action);
        stringBuilder.insert(offset, d);
        return this;
    }
    public StringBuilderWithUndo insert(int offset, float f)
    {
        String inserted = String.valueOf(f);
        Action action = () -> stringBuilder.delete(offset, offset + inserted.length());
        actions.push(action);
        stringBuilder.insert(offset, f);
        return this;
    }
    public StringBuilderWithUndo insert(int offset, int i)
    {
        String inserted = String.valueOf(i);
        Action action = () -> stringBuilder.delete(offset, offset + inserted.length());
        actions.push(action);
        stringBuilder.insert(offset, i);
        return this;
    }
    public StringBuilderWithUndo insert(int offset, long l)
    {
        String inserted = String.valueOf(l);
        Action action = () -> stringBuilder.delete(offset, offset + inserted.length());
        actions.push(action);
        stringBuilder.insert(offset, l);
        return this;
    }
    public StringBuilderWithUndo insert(int offset, Object obj)
    {
        String inserted = String.valueOf(obj);
        Action action = () -> stringBuilder.delete(offset, offset + inserted.length());
        actions.push(action);
        stringBuilder.insert(offset, obj);
        return this;
    }
    public StringBuilderWithUndo insert(int offset, char[] str)
    {
        String inserted = String.valueOf(str);
        Action action = () -> stringBuilder.delete(offset, offset + inserted.length());
        actions.push(action);
        stringBuilder.insert(offset, str);
        return this;
    }

    public StringBuilderWithUndo reverse() {
        stringBuilder.reverse();

        Action action = () -> stringBuilder.reverse();

        actions.add(action);

        return this;
    }
    public void undo(){
        if (!actions.isEmpty()) {
            actions.pop().undo();
        }
    }
        public String toString() {
            return stringBuilder.toString();
        }
    public int lastIndexOf(String str)
    {
        return stringBuilder.lastIndexOf(str);
    }
    public int lastIndexOf(String str, int fromIndex)
    {
        return stringBuilder.lastIndexOf(str, fromIndex);
    }
    public int length()
    {
        return stringBuilder.length();
    }
    public int offsetByCodePoints(int index, int codePointOffset)
    {
        return stringBuilder.offsetByCodePoints(index, codePointOffset);
    }
    public void setCharAt(int index, char ch)
    {
        char symbol = stringBuilder.charAt(index);
        Action action = () -> stringBuilder.setCharAt(index, symbol);
        actions.push(action);
        stringBuilder.setCharAt(index, ch);
    }
    public void setLength(int newLength)
    {
        int oldLength = stringBuilder.length();
        Action action = () -> stringBuilder.setLength(oldLength);
        actions.push(action);
        stringBuilder.setLength(newLength);
    }
    public CharSequence subSequence(int start, int end)
    {
        return stringBuilder.subSequence(start, end);
    }
    public String substring(int start)
    {
        return stringBuilder.substring(start);
    }
    public String substring(int start, int end)
    {
        return stringBuilder.substring(start, end);
    }
    public void trimToSize()
    {
        stringBuilder.trimToSize();
    }

    public void ensureCapacity(int minimumCapacity)
    {
        stringBuilder.ensureCapacity(minimumCapacity);
    }
    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
    {
        stringBuilder.getChars(srcBegin, srcEnd, dst, dstBegin);
    }
    public int indexOf(String str)
    {
        return stringBuilder.indexOf(str);
    }
    public int indexOf(String str, int fromIndex)
    {
        return stringBuilder.indexOf(str, fromIndex);
    }
    public int capacity()
    {
        return stringBuilder.capacity();
    }
    public char charAt(int index)
    {
        return stringBuilder.charAt(index);
    }
    public int codePointAt(int index)
    {
        return stringBuilder.codePointAt(index);
    }
    public int codePointBefore(int index)
    {
        return stringBuilder.codePointBefore(index);
    }
    public int codePointCount(int beginIndex, int endIndex)
    {
        return stringBuilder.codePointCount(beginIndex, endIndex);
    }
}
