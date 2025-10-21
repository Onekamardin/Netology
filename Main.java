public class Main {
    public static void main(String[] args) {
        Book book = new Book("Война и мир", 2020, "Лев Толстой", 1225);

        System.out.println("Название: " + book.getTitle());
        System.out.println("Автор: " + book.getAuthor());
        System.out.println("Страниц: " + book.getPages());
        System.out.println("Большая книга? " + book.isBig());
        System.out.println("Содержит 'Война'? " + book.matches("Война"));
        System.out.println("Цена: " + book.estimatePrice() + " руб.");

    }
}
