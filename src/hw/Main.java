package hw;

import java.util.Scanner;

import java.util.ArrayList;

/**
 * Main system class.
 * Handles menus, validations, and system operations.
 */
public class Main {
    // Main database object
    private static DeliveryDataBase system =
            new DeliveryDataBase();
    // Scanner object
    private static Scanner scanner =
            new Scanner(System.in);
    public static void main(String[] args) {
        // Load initial data
        initStaticData();
        try {

            ExceptionDemo.checkCustomer("");

            ExceptionDemo.checkRestaurant("");

            ExceptionDemo.checkBalance(
                    50,
                    100);

            ExceptionDemo.checkRider(
                    false);

        } catch (Exception e) {

            System.out.println(
                    e.getMessage());

        } finally {

            System.out.println(
                    "Exception demo completed.");
        }
        
        int choice = -1;
        // Main menu loop
        while (choice != 0) {
            System.out.println(
                    "\n========== FOOD DELIVERY SYSTEM ==========");
            System.out.println("1. Admin Login");
            System.out.println("2. Restaurant Manager Login");
            System.out.println("3. Customer Login");
            System.out.println("4. Rider Login");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            choice = readSafeInt();
            // Input validation
            if (choice < 0 || choice > 4) {
                System.out.println(
                        "Error: Invalid menu option.");
                continue;
            }
            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    restAdminMenu();
                    break;
                case 3:
                    customerMenu();
                    break;
                case 4:
                    riderMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println(
                            "Invalid option.");
            }
        }
    }
    /**
     * Inserts static initial data.
     */
    private static void initStaticData() {
       
        // REST ADMINS
        
        RestAdmin m1 =
                new RestAdmin(
                        "Yossi Cohen",
                        "yossi",
                        "111");
        RestAdmin m2 =
                new RestAdmin(
                        "Dani Levi",
                        "dani",
                        "222");
        RestAdmin m3 =
                new RestAdmin(
                        "Shira Shaked",
                        "shira",
                        "333");
        system.addRestAdmin(m1);
        system.addRestAdmin(m2);
        system.addRestAdmin(m3);
        
        // RESTAURANTS
       
        Restaurant r1 =
                new FastFoodRestaurant(
                        "R1",
                        "Burger Star",
                        "Burgers",
                        4.5,
                        true,
                        15.0,
                        15,
                        5.0);
        Restaurant r2 =
                new PremiumRestaurant(
                        "R2",
                        "Sushi Room",
                        "Asian",
                        4.8,
                        true,
                        20.0,
                        100.0,
                        10.0);
        Restaurant r3 =
                new Restaurant(
                        "R3",
                        "Pizza Corner",
                        "Italian",
                        4.2,
                        true,
                        12.0);
        Restaurant r4 =
                new FastFoodRestaurant(
                        "R4",
                        "Falafel Gold",
                        "Mediterranean",
                        4.0,
                        true,
                        10.0,
                        5,
                        2.0);
        Restaurant r5 =
                new PremiumRestaurant(
                        "R5",
                        "La Kitchen",
                        "French",
                        4.9,
                        true,
                        25.0,
                        150.0,
                        12.0);
        Restaurant r6 =
                new Restaurant(
                        "R6",
                        "Hummus Eli",
                        "Israeli",
                        4.3,
                        true,
                        10.0);
        Restaurant r7 =
                new FastFoodRestaurant(
                        "R7",
                        "Schnitzel Express",
                        "Fast Food",
                        4.1,
                        true,
                        12.0,
                        10,
                        3.0);
        Restaurant r8 =
                new PremiumRestaurant(
                        "R8",
                        "Chef Table",
                        "Gourmet",
                        4.7,
                        true,
                        30.0,
                        200.0,
                        15.0);
        Restaurant r9 =
                new Restaurant(
                        "R9",
                        "Greg Cafe",
                        "Dairy",
                        3.9,
                        true,
                        15.0);
        Restaurant r10 =
                new FastFoodRestaurant(
                        "R10",
                        "Wok Noodles",
                        "Asian",
                        4.4,
                        true,
                        14.0,
                        12,
                        4.0);
        system.addRestaurant(r1);
        system.addRestaurant(r2);
        system.addRestaurant(r3);
        system.addRestaurant(r4);
        system.addRestaurant(r5);
        system.addRestaurant(r6);
        system.addRestaurant(r7);
        system.addRestaurant(r8);
        system.addRestaurant(r9);
        system.addRestaurant(r10);
        
        // MANAGER ASSIGNMENTS
        
        m1.addRestaurant(r1);
        m1.addRestaurant(r2);
        m1.addRestaurant(r3);
        m2.addRestaurant(r4);
        m2.addRestaurant(r5);
        m2.addRestaurant(r6);
        m3.addRestaurant(r7);
        m3.addRestaurant(r8);
        m3.addRestaurant(r9);
        m3.addRestaurant(r10);
        
        // CUSTOMERS
        
        for (int i = 1; i <= 10; i++) {
            Customer customer =
                    new Customer(
                            "C" + i,
                            "User",
                            "Client",
                            "Street " + i,
                            "05012345" + String.format("%02d", i),
                            "user" + i + "@mail.com",
                            500.0);
            system.addCustomer(customer);
        }
        
        // RIDERS
        
        for (int i = 1; i <= 5; i++) {
            Rider rider =
                    new Rider(
                            "RIDER" + i,
                            "Rider Name " + i,
                            "05411122" + String.format("%02d", i),
                            "Scooter",
                            true);
            system.addRider(rider);
        }
            Order o1 = new Order(
                    "O1",
                    "C1",
                    r1,
                    50,
                    "01/01/2025");

            Order o2 = new Order(
                    "O2",
                    "C2",
                    r2,
                    120,
                    "02/01/2025");

            Order o3 = new Order(
                    "O3",
                    "C3",
                    r3,
                    70,
                    "03/01/2025");

            Order o4 = new Order(
                    "O4",
                    "C4",
                    r4,
                    40,
                    "04/01/2025");

            Order o5 = new Order(
                    "O5",
                    "C5",
                    r5,
                    200,
                    "05/01/2025");

            Order o6 = new Order(
                    "O6",
                    "C6",
                    r6,
                    55,
                    "06/01/2025");

            Order o7 = new Order(
                    "O7",
                    "C7",
                    r7,
                    35,
                    "07/01/2025");

            Order o8 = new Order(
                    "O8",
                    "C8",
                    r8,
                    250,
                    "08/01/2025");

            Order o9 = new Order(
                    "O9",
                    "C9",
                    r9,
                    65,
                    "09/01/2025");

            Order o10 = new Order(
                    "O10",
                    "C10",
                    r10,
                    80,
                    "10/01/2025");

            system.addOrder(o1);
            system.addOrder(o2);
            system.addOrder(o3);
            system.addOrder(o4);
            system.addOrder(o5);
            system.addOrder(o6);
            system.addOrder(o7);
            system.addOrder(o8);
            system.addOrder(o9);
            system.addOrder(o10);
        
    }
    
    // VALIDATIONS
    
    /**
     * Validates string input.
     */
    private static String validateString(
            String label,
            boolean alphabeticOnly) {
        while (true) {
            System.out.print(label);
            String input =
                    scanner.nextLine().trim();
            // Empty validation
            if (input.trim().isEmpty()) {
                System.out.println(
                        "Error: Empty input.");
                continue;
            }
            // Alphabet validation
            if (alphabeticOnly
                    &&
                    !input.matches(
                            "^[a-zA-Z\\s\u0590-\u05fe]+$")) {
                System.out.println(
                        "Error: Letters only.");
                continue;
            }
            return input;
        }
    }
    /**
     * Validates integer input.
     */
    private static int readSafeInt() {
        while (!scanner.hasNextInt()) {
            System.out.println(
                    "Error: Invalid integer.");
            scanner.next();
        }
        int value =
                scanner.nextInt();
        scanner.nextLine();
        return value;
    }
    /**
     * Validates double input.
     */
    private static double readSafeDouble() {

        while (true) {

            while (!scanner.hasNextDouble()) {

                System.out.println(
                        "Error: Invalid double.");

                scanner.next();
            }

            double value =
                    scanner.nextDouble();

            scanner.nextLine();

            if (value < 0) {

                System.out.println(
                        "Error: Negative number not allowed.");

                continue;
            }

            return value;
        }
    }
    /**
     * Validates email format.
     */
    private static String validateEmail() {
        while (true) {
            System.out.print(
                    "Enter email: ");
            String email =
                    scanner.nextLine().trim();
            if (email.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                return email;
            }
            System.out.println(
                    "Error: Invalid email.");
        }
    }
    /**
     * Validates ID number.
     */
    private static String validateId() {

        while (true) {

            System.out.print(
                    "Enter ID number: ");

            String id =
                    scanner.nextLine().trim();

            if (!id.matches("\\d{9}")) {

                System.out.println(
                        "Error: ID must contain exactly 9 digits.");

                continue;
            }

            return id;
        }
    }

    /**
     * Validates zip code.
     */
    private static String validateZipCode() {

        while (true) {

            System.out.print(
                    "Enter zip code: ");

            String zip =
                    scanner.nextLine().trim();

            if (!zip.matches("\\d{5,7}")) {

                System.out.println(
                        "Error: Zip code must contain 5-7 digits.");

                continue;
            }

            return zip;
        }
    }

    /**
     * Validates address.
     */
    private static String validateAddress() {

        while (true) {

            System.out.print(
                    "Enter address: ");

            String address =
                    scanner.nextLine().trim();

            if (!address.matches(
                    "^[a-zA-Z0-9\\s\\-/\u0590-\u05FF]+$")) {

                System.out.println(
                        "Error: Invalid address.");

                continue;
            }

            return address;
        }
    }

    /**
     * Validates customer code.
     */
    private static String validateCustomerCode() {

        while (true) {

            System.out.print(
                    "Enter customer code: ");

            String code =
                    scanner.nextLine().trim();

            if (!code.matches("C\\d+")) {

                System.out.println(
                        "Error: Customer code must start with C.");

                continue;
            }

            return code;
        }
    }

    /**
     * Validates restaurant code.
     */
    private static String validateRestaurantCode() {

        while (true) {

            System.out.print(
                    "Enter restaurant code: ");

            String code =
                    scanner.nextLine().trim();

            if (!code.matches("R\\d+")) {

                System.out.println(
                        "Error: Restaurant code must start with R.");

                continue;
            }

            return code;
        }
    }

    /**
     * Validates rider code.
     */
    private static String validateRiderCode() {

        while (true) {

            System.out.print(
                    "Enter rider ID: ");

            String code =
                    scanner.nextLine().trim();

            if (!code.matches("RIDER\\d+")) {

                System.out.println(
                        "Error: Rider ID format invalid.");

                continue;
            }

            return code;
        }
    }
    /**
     * Validates phone number.
     */
    private static String validatePhone() {

        while (true) {

            System.out.print(
                    "Enter phone number: ");

            String phone =
                    scanner.nextLine().trim();

            if (!phone.matches("05\\d-?\\d{7}")) {

                System.out.println(
                        "Error: Phone must contain exactly 10 digits.");

                continue;
            }

            return phone;
        }
    }
    /**
     * Validates date format.
     */
    private static String validateDate() {

        while (true) {

            System.out.print(
                    "Enter Date (DD/MM/YYYY): ");

            String date =
                    scanner.nextLine().trim();

            try {

                java.time.format.DateTimeFormatter formatter =
                        java.time.format.DateTimeFormatter.ofPattern(
                                "dd/MM/yyyy");

                java.time.LocalDate parsedDate =
                        java.time.LocalDate.parse(
                                date,
                                formatter);

                int year =
                        parsedDate.getYear();

                if (year < 2000 || year > 2026) {

                    System.out.println(
                            "Error: Year must be between 2000-2026.");

                    continue;
                }

                return date;

            }

            catch (Exception e) {

                System.out.println(
                        "Error: Invalid date.");
            }
        }
    }
    
 
 // ADMIN MENU


 private static void adminMenu() {

     String username =
             validateString(
                     "Admin username: ",
                     false);

     String password =
             validateString(
                     "Admin password: ",
                     false);

     if (!system.loginAdmin(
             username,
             password)) {

         System.out.println(
                 "Invalid login.");

         return;
     }

     int choice = -1;

     while (choice != 0) {

         System.out.println(
                 "\n--- ADMIN MENU ---");

         System.out.println(
                 "1. Add Customer");

         System.out.println(
                 "2. Add Rider");

         System.out.println(
                 "3. Add Restaurant Manager");

         System.out.println(
                 "4. Add Restaurant");

         System.out.println(
                 "5. Assign Restaurant To Manager");

         System.out.println(
                 "6. Assign Rider To Order");

         System.out.println(
                 "7. Show All Orders");

         System.out.println(
                 "8. Show Top Customer");

         System.out.println(
                 "9. Show Top Rider");

         System.out.println(
        	        "10. Open/Close Restaurant");

        	System.out.println(
        	        "11. Sort Reports");
        	System.out.println(
        	        "12. Predicate Report");

        	System.out.println(
        	        "0. Back");

         choice = readSafeInt();
         if (choice < 0 || choice > 12) {

        	    System.out.println(
        	            "Invalid option.");

        	    continue;
        	}

         switch (choice) {

             
             // ADD CUSTOMER
            

         case 1:

             String customerCode =
                     validateCustomerCode();

             if (system.findCustomer(
                     customerCode) != null) {

                 System.out.println(
                         "Customer already exists.");

                 break;
             }

             String firstName =
            	        validateString(
            	                "First name: ",
            	                true);

            	String lastName =
            	        validateString(
            	                "Last name: ",
            	                true);

            	String idNumber =
            	        validateId();

            	validateZipCode();

            	String address =
            	        validateAddress();

            	String phone =
            	        validatePhone();

            	String email =
            	        validateEmail();

            	Customer customer =
            	        new Customer(
            	                customerCode,
            	                firstName,
            	                lastName,
            	                address,
            	                phone,
            	                email,
            	                500.0,
            	                idNumber);

            	system.addCustomer(customer);

            	System.out.println(
            	        "Customer added.");

             break;
             // ADD RIDER
             

             case 2:

                 String riderId =
                         validateRiderCode();

                 if (system.findRider(
                         riderId) != null) {

                     System.out.println(
                             "Rider already exists.");

                     break;
                 }

                 String riderName =
                         validateString(
                                 "Rider Name: ",
                                 true);

                 String riderPhone =
                         validatePhone();

                 Rider rider =
                         new Rider(
                                 riderId,
                                 riderName,
                                 riderPhone,
                                 "Scooter",
                                 true);

                 system.addRider(rider);

                 System.out.println(
                         "Rider added.");

                 break;

         
             // ADD REST ADMIN
             

             case 3:

                 String managerName =
                         validateString(
                                 "Manager name: ",
                                 true);

                 String managerUser =
                         validateString(
                                 "Username: ",
                                 false);

                 String managerPass =
                         validateString(
                                 "Password: ",
                                 false);

                 RestAdmin newAdmin =
                         new RestAdmin(
                                 managerName,
                                 managerUser,
                                 managerPass);

                 system.addRestAdmin(newAdmin);

                 System.out.println(
                         "Restaurant manager added.");

                 break;

          
             // ADD RESTAURANT
             

             case 4:

                 System.out.println(
                         "1. Regular Restaurant");

                 System.out.println(
                         "2. Fast Food Restaurant");

                 System.out.println(
                         "3. Premium Restaurant");

                 int type;

                 do {

                     System.out.print("Choose type (1-3): ");

                     type = readSafeInt();

                     if (type < 1 || type > 3) {

                         System.out.println("Invalid option.");
                     }

                 } while (type < 1 || type > 3);

                 String restaurantCode =
                         validateRestaurantCode();

                 if (system.findRestaurant(
                         restaurantCode) != null) {

                     System.out.println(
                             "Restaurant already exists.");

                     break;
                 }

                 String restaurantName =
                         validateString(
                                 "Restaurant name: ",
                                 false);

                 String cuisine =
                         validateString(
                                 "Cuisine type: ",
                                 true);

                 double rating;

                 while (true) {

                     System.out.print(
                             "Rating (0-5): ");

                     rating =
                             readSafeDouble();

                     if (rating >= 0
                             && rating <= 5) {

                         break;
                     }

                     System.out.println(
                             "Error: Rating must be between 0 and 5.");
                 }

                 System.out.print(
                         "Delivery price: ");

                 double deliveryPrice =
                         readSafeDouble();

                 Restaurant restaurant = null;

                 if (type == 1) {

                     restaurant =
                             new Restaurant(
                                     restaurantCode,
                                     restaurantName,
                                     cuisine,
                                     rating,
                                     true,
                                     deliveryPrice);
                 }

                 else if (type == 2) {

                     System.out.print(
                             "Fast delivery minutes: ");

                     int minutes =
                             readSafeInt();

                     System.out.print(
                             "Extra fast fee: ");

                     double extraFee =
                             readSafeDouble();

                     restaurant =
                             new FastFoodRestaurant(
                                     restaurantCode,
                                     restaurantName,
                                     cuisine,
                                     rating,
                                     true,
                                     deliveryPrice,
                                     minutes,
                                     extraFee);
                 }

                 else if (type == 3) {

                     System.out.print(
                             "Minimum order value: ");

                     double minimum =
                             readSafeDouble();

                     System.out.print(
                             "Luxury fee: ");

                     double luxuryFee =
                             readSafeDouble();

                     restaurant =
                             new PremiumRestaurant(
                                     restaurantCode,
                                     restaurantName,
                                     cuisine,
                                     rating,
                                     true,
                                     deliveryPrice,
                                     minimum,
                                     luxuryFee);
                 }

                 if (restaurant != null) {

                     system.addRestaurant(
                             restaurant);

                     System.out.println(
                             "Restaurant added.");
                 }

                 break;

             
             // ASSIGN RESTAURANT TO MANAGER
            

             case 5:

                 String managerUsername =
                         validateString(
                                 "Manager username: ",
                                 false);

                 String managerPassword =
                         validateString(
                                 "Manager password: ",
                                 false);

                 RestAdmin foundAdmin =
                         system.loginRestAdmin(
                                 managerUsername,
                                 managerPassword);

                 if (foundAdmin == null) {

                     System.out.println(
                             "Manager not found.");

                     break;
                 }

                 String restCode =
                         validateRestaurantCode();

                 Restaurant rest =
                         system.findRestaurant(
                                 restCode);

                 if (rest == null) {

                     System.out.println(
                             "Restaurant not found.");

                     break;
                 }

                 foundAdmin.addRestaurant(
                         rest);

                 System.out.println(
                         "Restaurant assigned.");

                 break;

            
             // ASSIGN RIDER TO ORDER
            
             case 6:

                 String orderCodeAssign =
                         validateString(
                                 "Order code: ",
                                 false);

                 Order orderToAssign =
                         system.findOrder(
                                 orderCodeAssign);

                 if (orderToAssign == null) {

                     System.out.println(
                             "Order not found.");

                     break;
                 }

                 if (orderToAssign.getRiderCode()
                         != null) {

                     System.out.println(
                             "Order already assigned.");

                     break;
                 }

                 String riderCode =
                         validateRiderCode();

                 Rider assignRider =
                         system.findRider(
                                 riderCode);

                 if (assignRider == null) {

                     System.out.println(
                             "Rider not found.");

                     break;
                 }

                 if (!assignRider.isAvailable()) {

                     System.out.println(
                             "Rider unavailable.");

                     break;
                 }

                 orderToAssign.setRiderCode(
                         riderCode);

                 orderToAssign.setStatus(
                	        OrderStatus.SENT);

                 assignRider.setAvailable(
                         false);
                 assignRider.addOrder(orderToAssign);

                 System.out.println(
                         "Rider assigned successfully.");

                 break;

             
             // SHOW ALL ORDERS
             

             case 7:

                 system.printAllOrders();

                 break;

             
             // SHOW TOP CUSTOMER
             

             case 8:

                 Customer topCustomer =
                         system.getTopCustomer();

                 if (topCustomer != null) {

                     System.out.println(
                             topCustomer);

                 } else {

                     System.out.println(
                             "No customer data.");
                 }

                 break;

             
             // SHOW TOP RIDER
             

             case 9:

                 Rider topRider =
                         system.getTopRider();

                 if (topRider != null) {

                     System.out.println(
                             topRider);

                 } else {

                     System.out.println(
                             "No rider data.");
                 }

                 break;

             
             // OPEN / CLOSE RESTAURANT
             

             case 10:

                 String codeToUpdate =
                         validateRestaurantCode();

                 Restaurant updateRestaurant =
                         system.findRestaurant(
                                 codeToUpdate);

                 if (updateRestaurant == null) {

                     System.out.println(
                             "Restaurant not found.");

                     break;
                 }

                 System.out.println(
                         "1. Open Restaurant");

                 System.out.println(
                         "2. Close Restaurant");

                 int statusChoice =
                         readSafeInt();

                 if (statusChoice == 1) {

                     updateRestaurant.setOpen(
                             true);

                     System.out.println(
                             "Restaurant opened.");
                 }

                 else if (statusChoice == 2) {

                     updateRestaurant.setOpen(
                             false);

                     System.out.println(
                             "Restaurant closed.");
                 }

                 else {

                     System.out.println(
                             "Invalid option.");
                 }

                 break;
             case 11:

            	    sortReports();

            	    break;
             case 12:

         	    PredicateDemo.runPredicateDemo();

         	    break;

             case 0:
                 break;

             default:

                 System.out.println(
                         "Invalid option.");
         }
     }
 }
    
    
    
    // REST ADMIN MENU
    
    private static void restAdminMenu() {
        String username =
                validateString(
                        "Manager username: ",
                        false);
        String password =
                validateString(
                        "Manager password: ",
                        false);
        RestAdmin admin =
                system.loginRestAdmin(
                        username,
                        password);
        if (admin == null) {
            System.out.println(
                    "Invalid login.");
            return;
        }
        int choice = -1;
        while (choice != 0) {
        	System.out.println(
        	        "\n--- REST ADMIN MENU ---");

        	System.out.println(
        	        "1. Add Order");

        	System.out.println(
        	        "2. Add Customer");

        	System.out.println(
        	        "3. Add Rider");

        	System.out.println(
        	        "4. Assign Rider To Order");

        	System.out.println(
        	        "5. Show Restaurant Orders");

        	System.out.println(
        	        "6. Show Open Restaurants By Cuisine");

        	System.out.println(
        	        "0. Back");
            choice = readSafeInt();
            if (choice < 0 || choice > 6) {

                System.out.println(
                        "Invalid option.");

                continue;
            }
            switch (choice) {
                case 1:
                    String restaurantCode =
                            validateString(
                                    "Restaurant code: ",
                                    false);
                    if (!admin.isManaging(
                            restaurantCode)) {
                        System.out.println(
                                "You do not manage this restaurant.");
                        break;
                    }
                    Restaurant restaurant =
                            system.findRestaurant(
                                    restaurantCode);
                    if (restaurant == null) {
                        System.out.println(
                                "Restaurant not found.");
                        break;
                    }
                    String customerCode =
                            validateString(
                                    "Customer code: ",
                                    false);
                    Customer customer =
                            system.findCustomer(
                                    customerCode);
                    if (customer == null) {
                        System.out.println(
                                "Customer not found.");
                        break;
                    }
                    String orderCode =
                            validateString(
                                    "Order code: ",
                                    false);
                    if (system.findOrder(orderCode)
                            != null) {
                        System.out.println(
                                "Order already exists.");
                        break;
                    }
                    System.out.print(
                            "Base amount: ");
                    double amount =
                            readSafeDouble();
                 // Balance validation
                    double finalPrice=
                            restaurant.calculateFinalPrice(amount);

                    if(customer.getBalance()<finalPrice){
                        System.out.println("Insufficient balance.");
                        break;
                    }
                    String date =
                            validateDate();
                    Order order =
                            new Order(
                                    orderCode,
                                    customerCode,
                                    restaurant,
                                    amount,
                                    date);
                    system.addOrder(order);
                    // Update maps
                    system.addOrderToCustomerMap(
                            customerCode,
                            order);
                    system.addRestaurantToCustomerTable(
                            customerCode,
                            restaurant);
                    system.updateCustomerPayment(
                            customerCode,
                            order.getFinalPrice());
                    customer.setBalance(customer.getBalance()-order.getFinalPrice());
                    System.out.println(
                            "Order created successfully.");
                    break;
                case 2:

                    String customerCodeNew =
                            validateCustomerCode();

                    if (system.findCustomer(
                            customerCodeNew) != null) {

                        System.out.println(
                                "Customer already exists.");

                        break;
                    }

                    String firstNameNew =
                            validateString(
                                    "First name: ",
                                    true);

                    String lastNameNew =
                            validateString(
                                    "Last name: ",
                                    true);

                    String addressNew =
                            validateAddress();

                    String phoneNew =
                            validatePhone();

                    String emailNew =
                            validateEmail();

                    Customer newCustomer =
                            new Customer(
                                    customerCodeNew,
                                    firstNameNew,
                                    lastNameNew,
                                    addressNew,
                                    phoneNew,
                                    emailNew,
                                    500.0);

                    system.addCustomer(
                            newCustomer);

                    System.out.println(
                            "Customer added successfully.");

                    break;
                case 3:

                    String riderIdNew =
                            validateRiderCode();

                    if (system.findRider(
                            riderIdNew) != null) {

                        System.out.println(
                                "Rider already exists.");

                        break;
                    }

                    String riderNameNew =
                            validateString(
                                    "Rider name: ",
                                    true);

                    String riderPhoneNew =
                            validatePhone();

                    Rider newRider =
                            new Rider(
                                    riderIdNew,
                                    riderNameNew,
                                    riderPhoneNew,
                                    "Scooter",
                                    true);

                    system.addRider(
                            newRider);

                    System.out.println(
                            "Rider added successfully.");

                    break;
                case 4:

                    String assignOrderCode =
                            validateString(
                                    "Order code: ",
                                    false);

                    Order assignOrder =
                            system.findOrder(
                                    assignOrderCode);

                    if (assignOrder == null) {

                        System.out.println(
                                "Order not found.");

                        break;
                    }

                    if (assignOrder.getRiderCode()
                            != null) {

                        System.out.println(
                                "Order already assigned.");

                        break;
                    }

                    String assignRiderCode =
                            validateRiderCode();

                    Rider foundRider =
                            system.findRider(
                                    assignRiderCode);

                    if (foundRider == null) {

                        System.out.println(
                                "Rider not found.");

                        break;
                    }

                    if (!foundRider.isAvailable()) {

                        System.out.println(
                                "Rider unavailable.");

                        break;
                    }

                    assignOrder.setRiderCode(
                            assignRiderCode);

                    assignOrder.setStatus(
                            OrderStatus.SENT);

                    foundRider.setAvailable(
                            false);
                    foundRider.addOrder(assignOrder);

                    System.out.println(
                            "Rider assigned successfully.");

                    break;
                case 5:

                    String restCodeShow =
                            validateRestaurantCode();

                    boolean foundOrders =
                            false;

                    for (Order restaurantOrder
                            : system.getOrders()) {

                        if (restaurantOrder
                                .getRestaurant()
                                .getRestaurantCode()
                                .equalsIgnoreCase(
                                        restCodeShow)) {

                            System.out.println(
                                    restaurantOrder);

                            foundOrders = true;
                        }
                    }

                    if (!foundOrders) {

                        System.out.println(
                                "No orders found.");
                    }

                    break;
                case 6:

                    String cuisineType =
                            validateString(
                                    "Cuisine type: ",
                                    true);

                    boolean foundRestaurant =
                            false;

                    for (Restaurant openRestaurant
                            : system.getRestaurants()) {

                        if (openRestaurant.isOpen()

                                &&

                                openRestaurant.getCuisineType()
                                        .equalsIgnoreCase(
                                                cuisineType)) {

                            System.out.println(
                                    openRestaurant);

                            foundRestaurant = true;
                        }
                    }

                    if (!foundRestaurant) {

                        System.out.println(
                                "No open restaurants found.");
                    }

                    break;
                case 0:
                    break;
                default:
                    System.out.println(
                            "Invalid option.");
            }
        }
    }
    
    // CUSTOMER MENU
    
    private static void customerMenu() {
        String customerCode =
                validateString(
                        "Customer code: ",
                        false);
        Customer customer =
                system.findCustomer(
                        customerCode);
        if (customer == null) {
            System.out.println(
                    "Customer not found.");
            return;
        }
        int choice = -1;
        while (choice != 0) {
            System.out.println(
                    "\n--- CUSTOMER MENU ---");
            System.out.println(
                    "1. Create Order");

            System.out.println(
                    "2. Update Address");

            System.out.println(
                    "3. Update Phone");

            System.out.println(
                    "4. Update Email");

            System.out.println(
                    "5. Show My Orders");

            System.out.println(
                    "6. Show My Restaurants");

            System.out.println(
                    "7. Show Premium Restaurants");

            System.out.println(
                    "8. Show Balance");

            System.out.println(
                    "9. Deposit Money");

            System.out.println(
                    "10. Withdraw Money");

            System.out.println(
                    "0. Back");
            choice = readSafeInt();
            if (choice < 0 || choice > 10) {

                System.out.println(
                        "Invalid option.");

                continue;
            }
            switch (choice) {
                case 1:
                    String restaurantCode =
                            validateString(
                                    "Restaurant code: ",
                                    false);
                    Restaurant restaurant =
                            system.findRestaurant(
                                    restaurantCode);
                    if (restaurant == null
                            || !restaurant.isOpen()) {
                        System.out.println(
                                "Restaurant unavailable.");
                        break;
                    }
                    String orderCode =
                            validateString(
                                    "Order code: ",
                                    false);
                    if (system.findOrder(orderCode)
                            != null) {
                        System.out.println(
                                "Order already exists.");
                        break;
                    }
                    System.out.print(
                            "Base amount: ");
                    double amount =
                            readSafeDouble();
                    // Premium validation
                    if (restaurant
                            instanceof PremiumRestaurant) {
                        PremiumRestaurant premium =
                                (PremiumRestaurant)
                                        restaurant;
                        if (amount
                                < premium.getMinimumOrderValue()) {
                            System.out.println(
                                    "Order below minimum.");
                            break;
                        }
                    }
                 // Balance validation
                    double finalPrice=
                            restaurant.calculateFinalPrice(amount);

                    if(customer.getBalance()<finalPrice){
                        System.out.println("Insufficient balance.");
                        break;
                    }
                    String date =
                            validateDate();
                    Order order =
                            new Order(
                                    orderCode,
                                    customerCode,
                                    restaurant,
                                    amount,
                                    date);
                    system.addOrder(order);
                    // Update maps
                    system.addOrderToCustomerMap(
                            customerCode,
                            order);
                    system.addRestaurantToCustomerTable(
                            customerCode,
                            restaurant);
                    system.updateCustomerPayment(
                            customerCode,
                            order.getFinalPrice());
                    customer.setBalance(customer.getBalance()-order.getFinalPrice());
                    System.out.println(
                            "Order created.");
                    break;
                case 2:

                    String newAddress =
                            validateAddress();

                    customer.setFullAddress(
                            newAddress);

                    System.out.println(
                            "Address updated.");

                    break;
                case 3:

                    String phone =
                            validatePhone();

                    customer.setPhoneNumber(
                            phone);

                    System.out.println(
                            "Phone updated.");

                    break;
                case 4:

                    String newEmail =
                            validateEmail();

                    customer.setEmail(
                            newEmail);

                    System.out.println(
                            "Email updated.");

                    break;

                case 5:

                    system.printCustomerOrders(
                            customer.getCustomerCode());

                    break;

                case 6:

                    system.printCustomerRestaurants(
                            customer.getCustomerCode());

                    break;

                case 7:

                    system.printPremiumRestaurants(
                            customer);

                    break;

                case 8:

                    System.out.println(
                            "Current balance: "
                                    + customer.getBalance());

                    break;

                case 9:

                    System.out.print(
                            "Amount to deposit: ");

                    double deposit =
                            readSafeDouble();

                    customer.setBalance(
                            customer.getBalance()
                                    + deposit);

                    System.out.println(
                            "Money deposited.");

                    break;

                case 10:

                    System.out.print(
                            "Amount to withdraw: ");

                    double withdraw =
                            readSafeDouble();

                    if (withdraw >
                            customer.getBalance()) {

                        System.out.println(
                                "Insufficient balance.");

                        break;
                    }

                    customer.setBalance(
                            customer.getBalance()
                                    - withdraw);

                    System.out.println(
                            "Money withdrawn.");

                    break;
                case 0:
                    break;
                default:
                    System.out.println(
                            "Invalid option.");
            }
        }
    }
    
    // RIDER MENU
    
    private static void riderMenu() {
        String riderId =
                validateString(
                        "Rider ID: ",
                        false);
        Rider rider =
                system.findRider(riderId);
        if (rider == null) {
            System.out.println(
                    "Rider not found.");
            return;
        }
        int choice = -1;
        while (choice != 0) {
            System.out.println(
                    "\n--- RIDER MENU ---");
            System.out.println(
                    "1. Update Order Status");

            System.out.println(
                    "2. Show Active Orders");

            System.out.println(
                    "3. Show Order History");

            System.out.println(
                    "0. Back");
            
            choice = readSafeInt();
            if (choice < 0 || choice > 3) {

                System.out.println(
                        "Invalid option.");

                continue;
            }
            switch (choice) {
            case 1:

                String orderCode =
                        validateString(
                                "Order code: ",
                                false);

                Order order =
                        system.findOrder(
                                orderCode);

                if (order == null) {

                    System.out.println(
                            "Order not found.");

                    break;
                }

                if (order.getRiderCode() == null
                        ||
                        !order.getRiderCode()
                                .equalsIgnoreCase(
                                        rider.getRiderId())) {

                    System.out.println(
                            "Order not assigned to this rider.");

                    break;
                }

                System.out.println(
                        "1. On The Way");

                System.out.println(
                        "2. Delivered");

                int statusChoice =
                        readSafeInt();

                if (statusChoice == 1) {

                	order.setStatus(
                	        OrderStatus.ON_THE_WAY);

                    System.out.println(
                            "Order updated to On The Way.");
                }

                else if (statusChoice == 2) {

                	order.setStatus(
                	        OrderStatus.DELIVERED);
                    order.setDeliveryDate(
                            validateDate());

                    rider.setAvailable(
                            true);

                    rider.addOrder(
                            order);

                    System.out.println(
                            "Order delivered.");
                }

                else {

                    System.out.println(
                            "Invalid option.");
                }

                break;
            case 2:

                boolean found = false;

                for (Order activeOrder
                        : system.getOrders()) {

                    if (activeOrder.getRiderCode() != null

                            &&

                            activeOrder.getRiderCode()
                                    .equalsIgnoreCase(
                                            rider.getRiderId())

                            &&

                            activeOrder.getStatus()
                            != OrderStatus.DELIVERED){
                        System.out.println(
                                activeOrder);

                        found = true;
                    }
                }

                if (!found) {

                    System.out.println(
                            "No active orders.");
                }

                break;
            case 3:

                if (rider.getCompletedOrders()
                        .isEmpty()) {

                    System.out.println(
                            "No order history.");

                    break;
                }

                for (Order historyOrder
                        : rider.getCompletedOrders()) {

                    System.out.println(
                            historyOrder);
                }

                break;
                case 0:
                    break;
                default:
                    System.out.println(
                            "Invalid option.");
            }
        }
    }
    /**
     * Displays all Comparable and Comparator sorts.
     */
    private static void sortReports() {

        System.out.println("\n--- CUSTOMERS BY BALANCE ---");

        ArrayList<Customer> customers =
                new ArrayList<>(
                        system.getCustomers());

        java.util.Collections.sort(customers);
   

        customers.forEach(System.out::println);

        System.out.println("\n--- RESTAURANTS BY RATING ---");

        ArrayList<Restaurant> restaurants =
                new ArrayList<>(
                        system.getRestaurants());

        java.util.Collections.sort(
                restaurants,
                new RestaurantRatingComparator());

        restaurants.forEach(System.out::println);

        System.out.println("\n--- ORDERS BY FINAL PRICE ---");

        ArrayList<Order> orders =
                new ArrayList<>(
                        system.getOrders());

        java.util.Collections.sort(
                orders,
                new OrderPriceComparator());

        orders.forEach(System.out::println);
        
     // Lambda sort riders by delivery count

        System.out.println(
                "\n--- RIDERS BY DELIVERY COUNT ---");

        ArrayList<Rider> riders =
                new ArrayList<>(
                        system.getRiders());

        riders.sort(
                (r1, r2) ->
                        Integer.compare(
                                r2.getOrderCount(),
                                r1.getOrderCount()));

        for (Rider rider : riders) {

            System.out.println(rider);
        }
     // Lambda sort customers by first name

        System.out.println(
                "\n--- CUSTOMERS BY FIRST NAME ---");

        ArrayList<Customer> customersByName =
                new ArrayList<>(
                        system.getCustomers());

        customersByName.sort(
                (c1, c2) ->
                        c1.getFirstName()
                          .compareToIgnoreCase(
                                  c2.getFirstName()));

        for (Customer customer : customersByName) {

            System.out.println(customer);
        }
     // Lambda sort orders by order date

        System.out.println(
                "\n--- ORDERS BY ORDER DATE ---");

        ArrayList<Order> ordersByDate =
                new ArrayList<>(
                        system.getOrders());

        ordersByDate.sort(
                (o1, o2) ->
                        o1.getOrderDate()
                          .compareTo(
                                  o2.getOrderDate()));

        for (Order order : ordersByDate) {

            System.out.println(order);
        }
        System.out.println("\n--- OPEN RESTAURANTS ---");

        StreamReports.printOpenRestaurants(system);

        System.out.println("\n--- AVAILABLE RIDERS ---");

        StreamReports.printAvailableRiders(system);

        System.out.println("\n--- DELIVERED ORDERS ---");

        StreamReports.printDeliveredOrders(system);

        System.out.println("\n--- TOTAL PAYMENTS ---");

        System.out.println(
                StreamReports.getTotalPayments(system));
        System.out.println("\n--- WILDCARD REPORTS ---");

        SystemReports.printRestaurants(
                system.getRestaurants());

        System.out.println(
                "\nTotal Orders Price: "
                        + SystemReports.getTotalOrdersPrice(
                                system.getOrders()));
        System.out.println(
                "\nLargest Customer By Balance:");

        System.out.println(
                SystemReports.getLargest(
                        new ArrayList<>(
                                system.getCustomers())));

        ArrayList<Restaurant> tempRestaurants =
                new ArrayList<>();

        SystemReports.addFastFoodRestaurant(
                tempRestaurants,
                new FastFoodRestaurant(
                        "RX",
                        "Demo Restaurant",
                        "Fast Food",
                        5.0,
                        true,
                        10.0,
                        10,
                        2.0));

        System.out.println(
                "\nWildcard addFastFoodRestaurant executed.");
    }
}