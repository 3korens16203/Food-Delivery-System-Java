package hw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DeliveryDataBase {
	private Admin systemAdministrator;

	private ArrayList<RestAdmin> restAdmins;

	private ArrayList<Restaurant> restaurants;

	private ArrayList<Customer> customers;

	private ArrayList<Rider> riders;

	private ArrayList<Order> orders;

	private HashMap<String, ArrayList<Order>> customerOrders;

	private Hashtable<String, ArrayList<Restaurant>> customerRestaurants;

	private HashMap<String, Double> customerPayments;
	
	/**
     * Default constructor.
     * Initializes all collections as empty collections
     * and creates the main system administrator.
     */
    public DeliveryDataBase() {

        // Main administrator account required by assignment
        systemAdministrator =
                new Admin("System Admin", "admin", "12345");

        // Initialize restaurant managers collection
        restAdmins = new ArrayList<>();

        // Initialize restaurants collection
        restaurants = new ArrayList<>();

        // Initialize customers collection
        customers = new ArrayList<>();

        // Initialize riders collection
        riders = new ArrayList<>();

        // Initialize orders collection
        orders = new ArrayList<>();

        // Stores all customer orders by customer code
        customerOrders = new HashMap<>();

        // Stores all restaurants ordered by each customer
        customerRestaurants = new Hashtable<>();

        // Stores total payments made by each customer
        customerPayments = new HashMap<>();
    }
    /**
     * Adds a new customer to the system.
     * Prevents duplicate customer codes.
     *
     * @param customer Customer object to add
     * @return true if added successfully, otherwise false
     */
    public ArrayList<Restaurant> getRestaurants() {

        return restaurants;
    }
    public boolean addCustomer(Customer customer) {

        // Null validation
        if (customer == null) {
            return false;
        }

        // Prevent duplicate customer codes
        for (Customer c : customers) {

            if (c.getCustomerCode()
                    .equalsIgnoreCase(
                            customer.getCustomerCode())) {

                return false;
            }
        }

        // Add customer to ArrayList
        customers.add(customer);

        return true;
    }
    /**
     * Adds a new restaurant manager to the system.
     * Prevents duplicate usernames.
     *
     * @param admin Restaurant manager object
     * @return true if added successfully, otherwise false
     */
    public boolean addRestAdmin(RestAdmin admin) {

        // Null validation
        if (admin == null) {
            return false;
        }

        // Prevent duplicate usernames
        for (RestAdmin r : restAdmins) {

            if (r.getUsername()
                    .equalsIgnoreCase(
                            admin.getUsername())) {

                return false;
            }
        }

        // Add manager to collection
        restAdmins.add(admin);

        return true;
    }
 // Search restaurant manager by username
    public RestAdmin findRestAdmin(String username) {

        if (username == null) {
            return null;
        }

        for (RestAdmin admin : restAdmins) {

            if (admin.getUsername().equalsIgnoreCase(username)) {
                return admin;
            }

        }

        return null;
    }
    /**
     * Adds a restaurant to the system.
     * Prevents duplicate restaurant codes.
     *
     * @param restaurant Restaurant object
     * @return true if added successfully, otherwise false
     */
    public boolean addRestaurant(Restaurant restaurant) {

        // Null validation
        if (restaurant == null) {
            return false;
        }

        // Prevent duplicate restaurant codes
        for (Restaurant r : restaurants) {

            if (r.getRestaurantCode()
                    .equalsIgnoreCase(
                            restaurant.getRestaurantCode())) {

                return false;
            }
        }

        // Add restaurant to collection
        restaurants.add(restaurant);

        return true;
    }
    /**
     * Adds a rider to the system.
     * Prevents duplicate rider IDs.
     *
     * @param rider Rider object
     * @return true if added successfully, otherwise false
     */
    public boolean addRider(Rider rider) {

        // Null validation
        if (rider == null) {
            return false;
        }

        // Prevent duplicate rider IDs
        for (Rider r : riders) {

            if (r.getRiderId()
                    .equalsIgnoreCase(
                            rider.getRiderId())) {

                return false;
            }
        }

        // Add rider to collection
        riders.add(rider);

        return true;
    }
    /**
     * Adds a new order to the system.
     * Prevents duplicate order codes.
     *
     * @param order Order object
     * @return true if added successfully, otherwise false
     */
    public boolean addOrder(Order order) {

        // Null validation
        if (order == null) {
            return false;
        }

        // Prevent duplicate order codes
        for (Order o : orders) {

            if (o.getOrderCode()
                    .equalsIgnoreCase(
                            order.getOrderCode())) {

                return false;
            }
        }

        // Add order to collection
        orders.add(order);

        return true;
    }
    /**
     * Searches for a customer by customer code.
     *
     * @param customerCode Customer code
     * @return Customer object if found, otherwise null
     */
    public Customer findCustomer(String customerCode) {
    	if (customerCode == null
    	        || customerCode.trim().isEmpty()) {

    	    return null;
    	}
            

        // Search customer inside collection
        for (Customer customer : customers) {

            if (customer.getCustomerCode()
                    .equalsIgnoreCase(customerCode)) {

                return customer;
            }
        }

        return null;
    }
    /**
     * Searches for a restaurant by restaurant code.
     *
     * @param restaurantCode Restaurant code
     * @return Restaurant object if found, otherwise null
     */
    public Restaurant findRestaurant(String restaurantCode) {
    	if (restaurantCode == null
    	        || restaurantCode.trim().isEmpty()) {

    	    return null;
    	}
            

        // Search restaurant inside collection
        for (Restaurant restaurant : restaurants) {

            if (restaurant.getRestaurantCode()
                    .equalsIgnoreCase(restaurantCode)) {

                return restaurant;
            }
        }

        return null;
    }
    /**
     * Searches for a rider by rider ID.
     *
     * @param riderId Rider ID
     * @return Rider object if found, otherwise null
     */
    public Rider findRider(String riderId) {
    	if (riderId == null
    	        || riderId.trim().isEmpty()) {

    	    return null;
    	}

        // Search rider inside collection
        for (Rider rider : riders) {

            if (rider.getRiderId()
                    .equalsIgnoreCase(riderId)) {

                return rider;
            }
        }

        // Rider not found
        return null;
    }
    /**
     * Searches for an order by order code.
     *
     * @param orderCode Order code
     * @return Order object if found, otherwise null
     */
    public Order findOrder(String orderCode) {
    	if (orderCode == null
    	        || orderCode.trim().isEmpty()) {

    	    return null;
    	}

        // Search order inside collection
        for (Order order : orders) {

            if (order.getOrderCode()
                    .equalsIgnoreCase(orderCode)) {

                return order;
            }
        }

        // Order not found
        return null;
    }
    /**
     * Validates restaurant manager login credentials.
     *
     * @param username Manager username
     * @param password Manager password
     * @return RestAdmin object if login successful, otherwise null
     */
    public RestAdmin loginRestAdmin(String username,
                                    String password) {
    	if (username == null
    	        || username.trim().isEmpty()
    	        || password == null
    	        || password.trim().isEmpty()) {

    	    return null;
    	}

        // Search matching manager credentials
        for (RestAdmin admin : restAdmins) {

            if (admin.getUsername()
                    .equals(username)

                    &&

                    admin.getPassword()
                            .equals(password)) {

                return admin;
            }
        }

        // Login failed
        return null;
    }
    /**
     * Validates system administrator login.
     *
     * @param username Admin username
     * @param password Admin password
     * @return true if login successful
     */
    public boolean loginAdmin(
            String username,
            String password) {
    	if (username == null
    	        || username.trim().isEmpty()
    	        || password == null
    	        || password.trim().isEmpty()) {

    	    return false;
    	}

        return systemAdministrator
                .getUsername()
                .equals(username)

                &&

                systemAdministrator
                        .getPassword()
                        .equals(password);
    }
    /**
     * Adds an order to the customer orders HashMap.
     * Each customer code stores a list of all customer orders.
     *
     * @param customerCode Customer code
     * @param order Order object
     */
    public void addOrderToCustomerMap(String customerCode,
                                      Order order) {

        // Validation
        if (customerCode == null || order == null) {
            return;
        }

        // If customer does not exist in map yet,
        // create a new empty ArrayList
        if (!customerOrders.containsKey(customerCode)) {

            customerOrders.put(
                    customerCode,
                    new ArrayList<>());
        }

        // Prevent duplicate orders
        if (!customerOrders.get(customerCode)
                .contains(order)) {

            customerOrders.get(customerCode)
                    .add(order);
        }
    }
    /**
     * Adds a restaurant to the customer restaurants Hashtable.
     * Stores all restaurants ordered by each customer.
     *
     * @param customerCode Customer code
     * @param restaurant Restaurant object
     */
    public void addRestaurantToCustomerTable(
            String customerCode,
            Restaurant restaurant) {

        // Validation
        if (customerCode == null || restaurant == null) {
            return;
        }

        // If customer does not exist yet,
        // create empty restaurant list
        if (!customerRestaurants.containsKey(customerCode)) {

            customerRestaurants.put(
                    customerCode,
                    new ArrayList<>());
        }

        // Prevent duplicate restaurants
        if (!customerRestaurants.get(customerCode)
                .contains(restaurant)) {

            customerRestaurants.get(customerCode)
                    .add(restaurant);
        }
    }
    /**
     * Updates total payments made by a customer.
     *
     * @param customerCode Customer code
     * @param amount Payment amount
     */
    public void updateCustomerPayment(
            String customerCode,
            double amount) {

        // Validation
        if (customerCode == null || amount < 0) {
            return;
        }

        // If customer does not exist in map,
        // initialize payment amount with 0
        if (!customerPayments.containsKey(customerCode)) {

            customerPayments.put(customerCode, 0.0);
        }

        // Add new payment to existing amount
        double currentAmount =
                customerPayments.get(customerCode);

        customerPayments.put(
                customerCode,
                currentAmount + amount);
    }
    /**
     * Returns the customer with the highest
     * number of orders in the system.
     *
     * @return Customer with most orders
     */
    public Customer getTopCustomer() {

        Customer topCustomer = null;

        int maxOrders = 0;

        // Loop through all customers
        for (Customer customer : customers) {

            // Check if customer exists in orders map
            if (customerOrders.containsKey(
                    customer.getCustomerCode())) {

                // Get number of customer orders
                int orderCount =
                        customerOrders
                                .get(customer.getCustomerCode())
                                .size();

                // Update maximum
                if (orderCount > maxOrders) {

                    maxOrders = orderCount;

                    topCustomer = customer;
                }
            }
        }

        return topCustomer;
    }
    /**
     * Returns the rider with the highest
     * number of completed deliveries.
     *
     * @return Rider with most deliveries
     */
    public Rider getTopRider() {

        Rider topRider = null;

        int maxDeliveries = 0;

        // Loop through all riders
        for (Rider rider : riders) {

            // Compare delivery count
            if (rider.getOrderCount()
                    > maxDeliveries) {

                maxDeliveries =
                        rider.getOrderCount();

                topRider = rider;
            }
        }

        return topRider;
    }
    /**
     * Returns all open restaurants
     * matching a specific cuisine type.
     *
     * @param cuisineType Cuisine type
     * @return ArrayList of matching restaurants
     */
    public ArrayList<Restaurant>
    getOpenRestaurantsByCuisine(
            String cuisineType) {

        // Result collection
        ArrayList<Restaurant>
                result = new ArrayList<>();

        // Validation
        if (cuisineType == null) {
            return result;
        }

        // Search matching restaurants
        for (Restaurant restaurant : restaurants) {

            // Restaurant must be open
            // and cuisine must match
            if (restaurant.isOpen()

                    &&

                    restaurant.getCuisineType()
                            .equalsIgnoreCase(
                                    cuisineType)) {

                result.add(restaurant);
            }
        }

        return result;
    }
    public void printAllOrders() {

        if (orders.isEmpty()) {

            System.out.println(
                    "No orders found.");

            return;
        }

        for (Order order : orders) {

            System.out.println(order);
        }
    }
    /**
     * Prints all orders of a customer.
     */
    public void printCustomerOrders(
            String customerCode) {

        ArrayList<Order> orders =
                customerOrders.get(
                        customerCode);

        if (orders == null
                || orders.isEmpty()) {

            System.out.println(
                    "No orders found.");

            return;
        }

        for (Order order : orders) {

            System.out.println(order);
        }
    }

    /**
     * Prints all restaurants of a customer.
     */
    public void printCustomerRestaurants(
            String customerCode) {

        ArrayList<Restaurant> restaurants =
                customerRestaurants.get(
                        customerCode);

        if (restaurants == null
                || restaurants.isEmpty()) {

            System.out.println(
                    "No restaurants found.");

            return;
        }

        for (Restaurant restaurant
                : restaurants) {

            System.out.println(
                    restaurant);
        }
    }

    /**
     * Prints premium restaurants only.
     */
    /**
     * Returns premium restaurants ordered by customer.
     */
    public ArrayList<Restaurant>
    getPremiumRestaurants(
            Customer customer) {

        ArrayList<Restaurant> premium =
                new ArrayList<>();

        ArrayList<Restaurant> restaurants =
                customerRestaurants.get(
                        customer.getCustomerCode());

        if (restaurants == null) {

            return premium;
        }

        for (Restaurant restaurant
                : restaurants) {

            if (restaurant
                    instanceof PremiumRestaurant) {

                premium.add(
                        restaurant);
            }
        }

        return premium;
    }
    public void printPremiumRestaurants(
            Customer customer) {

        ArrayList<Restaurant> restaurants =
        		getPremiumRestaurants(
        		        customer);

        if (restaurants == null
                || restaurants.isEmpty()) {

            System.out.println(
                    "No premium restaurants.");

            return;
        }

        for (Restaurant restaurant
                : restaurants) {

            System.out.println(
                    restaurant);
        }
    }
    /**
     * Returns all active orders of a rider.
     *
     * @param riderId Rider ID
     * @return Active orders list
     */

    public ArrayList<Order> getActiveOrdersByRider(
            String riderId) {

        ArrayList<Order> result =
                new ArrayList<>();

        // Validation
        if (riderId == null) {
            return result;
        }

        // Search active orders
        for (Order order : orders) {

        	if (order.getRiderCode() != null
        	        && order.getRiderCode().equalsIgnoreCase(riderId)
        	        && (order.getStatus() == OrderStatus.SENT
        	        || order.getStatus() == OrderStatus.ON_THE_WAY)) {

                result.add(order);
            }
        }

        return result;
    }
    public ArrayList<Order> getOrders() {

        return orders;
    }
    /**
     * Returns all customers in the system.
     */
    public ArrayList<Customer> getCustomers() {

        return customers;
    }

    /**
     * Returns all riders in the system.
     */
    public ArrayList<Rider> getRiders() {

        return riders;
    }
    
    public ArrayList<RestAdmin> getRestAdmins() {

        return restAdmins;
    }
   
    public void saveCustomersToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     "customers.txt"))) {

            for (Customer customer : customers) {

                writer.write(
                        customer.getCustomerCode() + "," +
                        customer.getFirstName() + "," +
                        customer.getLastName() + "," +
                        customer.getFullAddress() + "," +
                        customer.getPhoneNumber() + "," +
                        customer.getEmail() + "," +
                        customer.getBalance() + "," +
                        customer.getIdNumber());

                writer.newLine();
            }

            System.out.println(
                    "Customers saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving customers.");
        }
    }
    public void loadCustomersFromFile() {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     "customers.txt"))) {

            customers.clear();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                Customer customer =
                        new Customer(
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                data[4],
                                data[5],
                                Double.parseDouble(
                                        data[6]),
                                data[7]);

                customers.add(customer);
            }

            System.out.println(
                    "Customers loaded successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error loading customers.");
        }
    }
    public void saveRestaurantsToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     "restaurants.txt"))) {

            for (Restaurant restaurant : restaurants) {

                writer.write(
                        restaurant.getRestaurantCode() + "," +
                        restaurant.getRestaurantName() + "," +
                        restaurant.getCuisineType() + "," +
                        restaurant.getRating() + "," +
                        restaurant.isOpen() + "," +
                        restaurant.getBaseDeliveryFee());

                writer.newLine();
            }

            System.out.println(
                    "Restaurants saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving restaurants.");
        }
    }
    public void loadRestaurantsFromFile() {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     "restaurants.txt"))) {

            restaurants.clear();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                Restaurant restaurant =
                        new Restaurant(
                                data[0],
                                data[1],
                                data[2],
                                Double.parseDouble(data[3]),
                                Boolean.parseBoolean(data[4]),
                                Double.parseDouble(data[5]));
                

                restaurants.add(restaurant);
            }

            System.out.println(
                    "Restaurants loaded successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error loading restaurants.");
        }
    }
    public void saveRidersToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     "riders.txt"))) {

            for (Rider rider : riders) {

                writer.write(
                        rider.getRiderId() + "," +
                        rider.getFullName() + "," +
                        rider.getPhoneNumber() + "," +
                        rider.getVehicle() + "," +
                        rider.isAvailable());

                writer.newLine();
            }

            System.out.println(
                    "Riders saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving riders.");
        }
    }
    public void loadRidersFromFile() {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     "riders.txt"))) {

            riders.clear();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                Rider rider =
                        new Rider(
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                Boolean.parseBoolean(
                                        data[4]));

                riders.add(rider);
            }

            System.out.println(
                    "Riders loaded successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error loading riders.");
        }
    }
    public void saveRestAdminsToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     "restAdmins.txt"))) {

            for (RestAdmin admin : restAdmins) {

                writer.write(
                        admin.getManagerName() + "," +
                        admin.getUsername() + "," +
                        admin.getPassword());

                writer.newLine();
            }

            System.out.println(
                    "RestAdmins saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving RestAdmins.");
        }
    }
    public void loadRestAdminsFromFile() {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     "restAdmins.txt"))) {

            restAdmins.clear();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                RestAdmin admin =
                        new RestAdmin(
                                data[0],
                                data[1],
                                data[2]);

                restAdmins.add(admin);
            }

            System.out.println(
                    "RestAdmins loaded successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error loading RestAdmins.");
        }
    }
    public void saveOrdersToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     "orders.txt"))) {

            for (Order order : orders) {

                writer.write(
                        order.getOrderCode() + "," +
                        order.getCustomerCode() + "," +
                        order.getRestaurant().getRestaurantCode() + "," +
                        order.getBaseAmount() + "," +
                        order.getOrderDate());

                writer.newLine();
            }

            System.out.println(
                    "Orders saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving orders.");
        }
    }
    public void loadOrdersFromFile() {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     "orders.txt"))) {

            orders.clear();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                Restaurant restaurant =
                        findRestaurant(data[2]);

                if (restaurant != null) {

                    Order order =
                            new Order(
                                    data[0],
                                    data[1],
                                    restaurant,
                                    Double.parseDouble(
                                            data[3]),
                                    data[4]);

                    orders.add(order);
                }
            }

            System.out.println(
                    "Orders loaded successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error loading orders.");
        }
    }
    
    /**
     * Returns completed deliveries of a rider.
     */
    public ArrayList<Order> getCompletedOrdersByRider(
            String riderId) {

        ArrayList<Order> result =
                new ArrayList<>();

        if (riderId == null) {

            return result;
        }

        for (Order order : orders) {

            if (order.getRiderCode() != null
                    && order.getRiderCode().equalsIgnoreCase(riderId)
                    && order.getStatus() == OrderStatus.DELIVERED) {

                result.add(order);
            }
        }

        return result;
    }
    
    

}
