import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    earnings += getAmount(scanner, "Введите сумму дохода: ");
                    break;
                case "2":
                    spendings += getAmount(scanner, "Введите сумму расхода: ");
                    break;
                case "3":
                    calculateTaxes(earnings, spendings);
                    break;
                case "end":
                    break;
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
            }
            System.out.println("Программа завершена!");
        }
    }


    private static int getAmount(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void calculateTaxes(int earn, int spend) {
        int usnIncomeTax = taxEarnings(earn);
        int usnIncomeExpenseTax = taxEarningsMinusSpendings(earn, spend);

        if (usnIncomeTax < usnIncomeExpenseTax) {
            System.out.println("Мы советуем вам УСН доходы");
            System.out.println("Ваш налог составит: " + usnIncomeTax + " рублей");
            System.out.println("Налог на другой системе: " + usnIncomeExpenseTax + " рублей");
            System.out.println("Экономия: " + (usnIncomeExpenseTax - usnIncomeTax) + " рублей");
        } else {
            System.out.println("Мы советуем вам УСН доходы минус расходы");
            System.out.println("Ваш налог составит: " + usnIncomeExpenseTax + " рублей");
            System.out.println("Налог на другой системе: " + usnIncomeTax + " рублей");
            System.out.println("Экономия: " + (usnIncomeTax - usnIncomeExpenseTax) + " рублей");
        }
    }

    public static int taxEarnings(int spendings) {
        int tax = spendings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
}
