# UndoableStringBuilder

StringBuilder с поддержкой отмены операций (undo).

## Возможности
- Отмена последнего изменения (`undo()`)
- Все методы стандартного `StringBuilder`
- Цепочки вызовов

## Пример

```java
UndoableStringBuilder sb = new UndoableStringBuilder("Hello");
sb.append(" World");
System.out.println(sb);   // Hello World

sb.undo();
System.out.println(sb);   // Hello
