package task3;

public class Main {
    public static void main(String[] args){
        boolean b = false;
        char[] mas = {' ', 'd', 'f', 'd', 'r', 'e', 'r'};
        StringBuilderWithUndo string = new StringBuilderWithUndo("Строка для испытаний.");
        System.out.println(string);
        string.append(" Обновим ее");
        string.append(" Снова", 1, 5);
        string.undo();
        string.append(2);
        string.append(3.56);
        string.append('е');
        string.append(b);
        string.append(mas);
        string.append(mas, 0, 6);
        System.out.println(string.toString());
        string.delete(7, 10);
        System.out.println(string.toString());
        string.undo();
        System.out.println(string.toString());
        for (int i = 29; i < 57; i++) {
            string.deleteCharAt(22);
        }
        System.out.println(string.toString());
        string.replace(22, 28, "замена");
        System.out.println(string.toString());
        string.insert(21, "вставка");
        string.insert(22, "+");
        System.out.println(string.toString());
        string.undo();
        string.insert(28, 0);
        string.insert(29, b);
        string.insert(4, mas, 4, 3);
        System.out.println(string.toString());
        string.undo();
        string.undo();
        string.undo();
        System.out.println(string);
        string.reverse();
        System.out.println(string);
        string.undo();
        System.out.println(string);
        System.out.println(string.length());
        System.out.println(string.subSequence(0, 21));
    }
}
