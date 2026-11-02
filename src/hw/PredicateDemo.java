package hw;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void runPredicateDemo() {

        Customer customer1 =
                new Customer(
                        "C1",
                        "Shira",
                        "Amar",
                        "Haifa",
                        "0501234567",
                        "shira@gmail.com",
                        150,
                        "123456789");

        Customer customer2 =
                new Customer(
                        "C2",
                        "Dana",
                        "Levi",
                        "Tel Aviv",
                        "0507654321",
                        "dana@gmail.com",
                        50,
                        "987654321");

        Predicate<Customer> balanceAbove100 =
                customer ->
                        customer.getBalance() > 100;

        System.out.println(
                customer1.getFirstName()
                        + " balance above 100: "
                        + balanceAbove100.test(customer1));

        System.out.println(
                customer2.getFirstName()
                        + " balance above 100: "
                        + balanceAbove100.test(customer2));
    }
}
