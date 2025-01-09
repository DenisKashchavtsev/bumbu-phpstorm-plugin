package pro.dkart.bumbu.completion.tool;

public class StringTool {
    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Возвращаем как есть, если строка пустая или null
        }
        // Преобразуем первую букву в верхний регистр и добавляем оставшуюся часть строки
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
