import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей
        //к большей).
        System.out.println("Задание 1.");
        transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparingInt(x -> x.getValue()))
                .forEach(x-> System.out.println(x));

        //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        System.out.println("Задание 2.");
        transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .forEach(x -> System.out.println(x));

        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        System.out.println("Задание 3.");
        transactions.stream()
                .map(x -> x.getTrader())
                .filter(x -> x.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(x -> x.getName()))
                .distinct()
                .forEach(x -> System.out.println(x));

        //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
        //порядке.
        System.out.println("Задание 4.");
        transactions.stream()
                .map(x -> x.getTrader().getName())
                .sorted()
                .distinct()
                .forEach(x -> System.out.println(x));

        //5. Выяснить, существует ли хоть один трейдер из Милана.
        System.out.println("Задание 5.");
        var milan = transactions.stream()
                .map(x -> x.getTrader())
                .filter(x -> x.getCity().equals("Milan"))
                .findFirst()
                .isEmpty();
        System.out.println(milan);

        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        System.out.println("Задание 6.");
        transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .map(x -> x.getValue())
                .forEach(x -> System.out.println(x));

        //7. Какова максимальная сумма среди всех транзакций?
        System.out.println("Задание 7.");
        var max = transactions.stream()
                .max(Comparator.comparing(x -> x.getValue()))
                .get()
                .getValue();
        System.out.println(max);

        //8. Найти транзакцию с минимальной суммой.
        System.out.println("Задание 8.");
        var min = transactions.stream()
                .min(Comparator.comparing(x -> x.getValue()))
                .get()
                .getValue();
        System.out.println(min);
    }
}