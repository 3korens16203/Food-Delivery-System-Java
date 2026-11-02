package hw;

import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;


public class MainFX extends Application {
	private DeliveryDataBase db =
	        new DeliveryDataBase();
	// Displays error popup
	private void showError(String message) {

	    Alert alert =
	            new Alert(Alert.AlertType.ERROR);

	    alert.setTitle("Error");

	    alert.setHeaderText(null);

	    alert.setContentText(message);

	    alert.showAndWait();
	}
	private void showSuccess(String message) {

	    Alert alert =
	            new Alert(Alert.AlertType.INFORMATION);

	    alert.setTitle("Success");

	    alert.setHeaderText(null);

	    alert.setContentText(message);

	    alert.showAndWait();
	}
	//  Validation Methods

	// Letters only
	private boolean isLetters(String text) {
	    return text.matches("[A-Za-z ]+");
	}

	// Zip code (5-7 digits)
	private boolean isZip(String zip) {
	    return zip.matches("\\d{5,7}");
	}

	// Phone (10 digits or more)
	private boolean isPhone(String phone) {
	    return phone.matches("\\d{10,}");
	}

	// Email
	private boolean isEmail(String email) {
	    return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	}

	// Israeli ID (9 digits)
	private boolean isID(String id) {
	    return id.matches("\\d{9}");
	}

	// Rating between 0-5
	private boolean isRating(double rating) {
	    return rating >= 0 && rating <= 5;
	}

    @Override
    public void start(Stage stage) {
    	

        Button adminBtn =
                new Button("Admin Login");

        Button userBtn =
                new Button("User Login");
        Button managerBtn =
                new Button("Restaurant Manager Login");

        Button riderBtn =
                new Button("Rider Login");

        Button exitBtn =
                new Button("Exit");

        exitBtn.setOnAction(e ->
                stage.close());
        adminBtn.setOnAction(e -> {
        	

            Stage adminStage = new Stage();
            TextField adminUsernameField = new TextField();
            adminUsernameField.setPromptText("Username");

            TextField adminPasswordField = new TextField();
            adminPasswordField.setPromptText("Password");

            Button loginBtn = new Button("Login");
            VBox loginRoot = new VBox(10);

            loginRoot.getChildren().addAll(
                    adminUsernameField,
                    adminPasswordField,
                    loginBtn);

            Scene loginScene =
                    new Scene(
                            loginRoot,
                            300,
                            200);

            adminStage.setTitle("Admin Login");
            adminStage.setScene(loginScene);
            adminStage.show();
            loginBtn.setOnAction(x -> {
            	String username =
            	        adminUsernameField.getText();

            	String password =
            	        adminPasswordField.getText();

            	if(username.equals("admin")
            	        && password.equals("1234")) {
            
            
        

            VBox adminRoot = new VBox(15);

            Button addCustomerBtn =
                    new Button("Customer Management");
       

            Button addRiderBtn =
                    new Button("Rider Management");
            Button restaurantBtn =
                    new Button("Restaurant Management");

            Button orderBtn =
                    new Button("Order Management");

            Button managerBtn2 =
                    new Button("Restaurant Managers");

            Button reportsBtn =
                    new Button("Reports And Sorts");

            Button saveBtn =
                    new Button("Save Data");

            Button loadBtn =
                    new Button("Load Data");

            Button backBtn =
                    new Button("Exit");

            adminRoot.getChildren().addAll(
                    addCustomerBtn,
                    addRiderBtn,
                    restaurantBtn,
                    orderBtn,
                    managerBtn2,
                    reportsBtn,
                    saveBtn,
                    loadBtn,
                    backBtn);
         // Open add customer window
            addCustomerBtn.setOnAction(event -> {

                Stage customerStage =
                        new Stage();
             

                VBox customerRoot =
                        new VBox(10);
             // Customer input fields

                TextField codeField =
                        new TextField();

                codeField.setPromptText(
                        "Customer Code");

                TextField firstNameField =
                        new TextField();

                firstNameField.setPromptText(
                        "First Name");

                TextField lastNameField =
                        new TextField();

                lastNameField.setPromptText(
                        "Last Name");
                TextField addressField =
                        new TextField();

                addressField.setPromptText(
                        "Address");

                TextField cityField =
                        new TextField();

                cityField.setPromptText(
                        "City");

                TextField zipField =
                        new TextField();

                zipField.setPromptText(
                        "Zip Code");

                TextField phoneField =
                        new TextField();

                phoneField.setPromptText(
                        "Phone");

                TextField emailField =
                        new TextField();

                emailField.setPromptText(
                        "Email");

                TextField idField =
                        new TextField();

                idField.setPromptText(
                        "ID Number");

                Button saveCustomerBtn =
                        new Button("Save Customer");

                Button showCustomersBtn =
                        new Button("Show All Customers");

                TextField searchCodeField =
                        new TextField();

                searchCodeField.setPromptText(
                        "Customer Code");

                Button searchCustomerBtn =
                        new Button("Search Customer");
                Button updateCustomerBtn =
                        new Button("Update Customer");
               

               
             // Show customer orders button
                Button showOrdersBtn =
                        new Button("Show Customer Orders");
             // Show customer restaurants button
                Button showRestaurantsBtn =
                        new Button("Show Customer Restaurants");
             // Show premium restaurants button
                Button showPremiumBtn =
                        new Button("Show Premium Restaurants");
                

                saveCustomerBtn.setOnAction(i -> {

                    String code = codeField.getText().trim();
                    String firstName = firstNameField.getText().trim();
                    String lastName = lastNameField.getText().trim();
                    String address = addressField.getText().trim();
                    String city = cityField.getText().trim();
                    String zip = zipField.getText().trim();
                    String phone = phoneField.getText().trim();
                    String email = emailField.getText().trim();
                    String id = idField.getText().trim();

                    // Empty fields
                    if(code.isEmpty() || firstName.isEmpty() || lastName.isEmpty()
                            || address.isEmpty() || city.isEmpty()
                            || zip.isEmpty() || phone.isEmpty()
                            || email.isEmpty() || id.isEmpty()) {

                        showError("All fields are required.");
                        return;
                    }

                    // First name
                    if(!isLetters(firstName)) {
                        showError("Invalid first name.");
                        return;
                    }

                    // Last name
                    if(!isLetters(lastName)) {
                        showError("Invalid last name.");
                        return;
                    }

                    // City
                    if(!isLetters(city)) {
                        showError("Invalid city.");
                        return;
                    }

                    // Zip
                    if(!isZip(zip)) {
                        showError("Invalid zip code.");
                        return;
                    }

                    // Phone
                    if(!isPhone(phone)) {
                        showError("Invalid phone number.");
                        return;
                    }

                    // Email
                    if(!isEmail(email)) {
                        showError("Invalid email.");
                        return;
                    }

                    // ID
                    if(!isID(id)) {
                        showError("Invalid ID.");
                        return;
                    }

                    Customer customer =
                            new Customer(
                                    code,
                                    firstName,
                                    lastName,
                                    address,
                                    phone,
                                    email,
                                    0);

                    db.addCustomer(customer);

                    showSuccess("Customer Saved");
                });
                showCustomersBtn.setOnAction(d -> {

                    for(Customer c : db.getCustomers()) {

                        System.out.println(c);
                    }
                });

                searchCustomerBtn.setOnAction(d -> {

                    Customer customer =
                            db.findCustomer(
                                    searchCodeField.getText());

                    if(customer != null) {

                        System.out.println(customer);

                    }else {

                            showError(
                                    "Customer Not Found");
                        }
                });
                updateCustomerBtn.setOnAction(d -> {

                    Customer customer =
                            db.findCustomer(
                                    searchCodeField.getText());

                    if(customer != null) {

                        customer.setFirstName(
                                firstNameField.getText());

                        customer.setLastName(
                                lastNameField.getText());

                        showSuccess("Customer Updated");
                    }
                    else {

                    	showError("Customer Not Found");
                    }
                });
            
             // Show all orders of a customer
                showOrdersBtn.setOnAction(d -> {

                    db.printCustomerOrders(
                            searchCodeField.getText());
                });
             // Show all restaurants ordered by customer
                showRestaurantsBtn.setOnAction(d -> {

                    db.printCustomerRestaurants(
                            searchCodeField.getText());
                });
             // Show premium restaurants ordered by customer
                showPremiumBtn.setOnAction(d -> {

                    Customer customer =
                            db.findCustomer(
                                    searchCodeField.getText());

                    if(customer != null) {

                        db.printPremiumRestaurants(
                                customer);
                    }
                    else {

                    	showError("Customer Not Found");
                    }
                });

                customerRoot.getChildren().addAll(
                        codeField,
                        firstNameField,
                        lastNameField,
                        addressField,
                        cityField,
                        zipField,
                        phoneField,
                        emailField,
                        idField,
                        saveCustomerBtn,
                        showCustomersBtn,
                        searchCodeField,
                        searchCustomerBtn,
                        updateCustomerBtn,
                        
                        showOrdersBtn,
                        showRestaurantsBtn,
                        showPremiumBtn);
                Scene customerScene =
                        new Scene(
                                customerRoot,
                                400,
                                300);

                customerStage.setTitle(
                        "Add Customer");

                customerStage.setScene(
                        customerScene);

                customerStage.show();
            });

         // Open add rider window
            addRiderBtn.setOnAction(event -> {

                Stage riderStage =
                        new Stage();

                VBox riderRoot =
                        new VBox(10);

                // Rider ID field
                TextField riderIdField =
                        new TextField();

                riderIdField.setPromptText(
                        "Rider ID");

                // First name field
                TextField firstNameField =
                        new TextField();

                firstNameField.setPromptText(
                        "First Name");

                // Last name field
                TextField lastNameField =
                        new TextField();

                lastNameField.setPromptText(
                        "Last Name");

                // Phone field
                TextField phoneField =
                        new TextField();

                phoneField.setPromptText(
                        "Phone");

                // Save rider button
                Button saveRiderBtn =
                        new Button(
                                "Save Rider");
             // Show all riders button
                Button showRidersBtn =
                        new Button(
                                "Show All Riders");

                // Search rider field
                TextField searchRiderField =
                        new TextField();

                searchRiderField.setPromptText(
                        "Rider ID");

                // Search rider button
                Button searchRiderBtn =
                        new Button(
                                "Search Rider");

                // Rider orders field
                TextField riderOrdersField =
                        new TextField();

                riderOrdersField.setPromptText(
                        "Rider ID");

                // Rider orders button
                Button riderOrdersBtn =
                        new Button(
                                "Rider Orders");

                // Top rider button
                Button topRiderBtn =
                        new Button(
                                "Top Rider");
             // Order code field
                TextField updateOrderField =
                        new TextField();

                updateOrderField.setPromptText(
                        "Order Code");

                // Status field
                ComboBox<OrderStatus> statusBox =
                        new ComboBox<>();

                statusBox.getItems().addAll(
                        OrderStatus.values());

                // Update status button
                Button updateStatusBtn =
                        new Button(
                                "Update Status");

                // Save rider action
                saveRiderBtn.setOnAction(v -> {

                    String riderId = riderIdField.getText().trim();
                    String firstName = firstNameField.getText().trim();
                    String lastName = lastNameField.getText().trim();
                    String phone = phoneField.getText().trim();

                    // Empty fields
                    if(riderId.isEmpty() || firstName.isEmpty()
                            || lastName.isEmpty() || phone.isEmpty()) {

                        showError("All fields are required.");
                        return;
                    }

                    // First name
                    if(!isLetters(firstName)) {
                        showError("Invalid first name.");
                        return;
                    }

                    // Last name
                    if(!isLetters(lastName)) {
                        showError("Invalid last name.");
                        return;
                    }

                    // Phone
                    if(!isPhone(phone)) {
                        showError("Invalid phone number.");
                        return;
                    }

                    Rider rider =
                            new Rider(
                                    riderId,
                                    firstName + " " + lastName,
                                    phone,
                                    "Bike",
                                    true);

                    db.addRider(rider);

                    showSuccess("Rider Saved");
                });
             // Show all riders action
                showRidersBtn.setOnAction(d -> {

                    for(Rider rider :
                            db.getRiders()) {

                        System.out.println(rider);
                    }
                });

                // Search rider action
                searchRiderBtn.setOnAction(d -> {

                    Rider rider =
                            db.findRider(
                                    searchRiderField.getText());

                    if(rider != null) {

                        System.out.println(rider);

                    } else {

                    	showError("Rider Not Found");
                    }
                });

                // Show rider orders action
                riderOrdersBtn.setOnAction(d -> {

                    for(Order order :
                            db.getActiveOrdersByRider(
                                    riderOrdersField.getText())) {

                        System.out.println(order);
                    }
                });

                // Top rider action
                topRiderBtn.setOnAction(d -> {

                    Rider rider =
                            db.getTopRider();

                    if(rider != null) {

                        System.out.println(rider);
                    }
                });
             // Update order status action
                updateStatusBtn.setOnAction(d -> {

                    Order order =
                            db.findOrder(updateOrderField.getText().trim());

                    if(order == null) {
                        showError("Order Not Found");
                        return;
                    }

                    try {

                    	order.setStatus(
                    	        statusBox.getValue());
                    	
                        showSuccess("Status Updated");

                    } catch(IllegalArgumentException ex) {

                        showError("Invalid status.");
                    }
                });

                riderRoot.getChildren().addAll(
                        riderIdField,
                        firstNameField,
                        lastNameField,
                        phoneField,
                        saveRiderBtn,
                        showRidersBtn,
                        searchRiderField,
                        searchRiderBtn,
                        riderOrdersField,
                        riderOrdersBtn,
                        topRiderBtn,
                        updateOrderField,
                        statusBox,
                        updateStatusBtn);
                
                Scene riderScene =
                        new Scene(
                                riderRoot,
                                400,
                                300);

                riderStage.setTitle(
                        "Add Rider");

                riderStage.setScene(
                        riderScene);

                riderStage.show();
            });

         // Open restaurant window
            restaurantBtn.setOnAction(event -> {

                Stage restaurantStage =
                        new Stage();

                VBox restaurantRoot =
                        new VBox(10);

                // Restaurant code field
                TextField restaurantCodeField =
                        new TextField();

                restaurantCodeField.setPromptText(
                        "Restaurant Code");

                // Restaurant name field
                TextField restaurantNameField =
                        new TextField();

                restaurantNameField.setPromptText(
                        "Restaurant Name");

                // Cuisine type field
                TextField cuisineField =
                        new TextField();

                cuisineField.setPromptText(
                        "Cuisine Type");

                // Save restaurant button
                Button saveRestaurantBtn =
                        new Button(
                                "Save Restaurant");

                // Save restaurant action
             // Save restaurant
                saveRestaurantBtn.setOnAction(o -> {

                    String code = restaurantCodeField.getText().trim();
                    String name = restaurantNameField.getText().trim();
                    String cuisine = cuisineField.getText().trim();

                    // Empty fields
                    if(code.isEmpty() || name.isEmpty() || cuisine.isEmpty()) {
                        showError("All fields are required.");
                        return;
                    }

                    // Restaurant name
                    if(!isLetters(name)) {
                        showError("Invalid restaurant name.");
                        return;
                    }

                    // Cuisine
                    if(!isLetters(cuisine)) {
                        showError("Invalid cuisine type.");
                        return;
                    }

                    Restaurant restaurant =
                            new Restaurant(
                                    code,
                                    name,
                                    cuisine,
                                    5.0,
                                    true,
                                    10.0);

                    db.addRestaurant(restaurant);

                    showSuccess("Restaurant Saved");
                });
             // Show all restaurants button
                Button showRestaurantsBtn =
                        new Button(
                                "Show All Restaurants");

                // Search restaurant field
                TextField searchRestaurantField =
                        new TextField();

                searchRestaurantField.setPromptText(
                        "Restaurant Code");

                // Search restaurant button
                Button searchRestaurantBtn =
                        new Button(
                                "Search Restaurant");
             // Rating field
                TextField ratingField =
                        new TextField();

                ratingField.setPromptText(
                        "New Rating");

                // Update rating button
                Button updateRatingBtn =
                        new Button(
                                "Update Rating");

                // Open restaurant button
                Button openRestaurantBtn =
                        new Button(
                                "Open Restaurant");

                // Close restaurant button
                Button closeRestaurantBtn =
                        new Button(
                                "Close Restaurant");
             // Show restaurants by cuisine button
                Button cuisineBtn =
                        new Button(
                                "Show By Cuisine");
             // Show open restaurants button
                Button openOnlyBtn =
                        new Button(
                                "Show Open Restaurants");

                // Show all restaurants action
                showRestaurantsBtn.setOnAction(d -> {

                    for(Restaurant r :
                            db.getRestaurants()) {

                        System.out.println(r);
                    }
                });

                // Search restaurant action
                searchRestaurantBtn.setOnAction(d -> {

                    Restaurant restaurant =
                            db.findRestaurant(
                                    searchRestaurantField.getText());

                    if(restaurant != null) {

                        System.out.println(
                                restaurant);

                    } else {

                    	showError("Restaurant Not Found");
                    }
                });
             // Update restaurant rating
                updateRatingBtn.setOnAction(u -> {

                    Restaurant restaurant =
                            db.findRestaurant(searchRestaurantField.getText());

                    if(restaurant == null) {
                        showError("Restaurant Not Found");
                        return;
                    }

                    try {

                        double rating =
                                Double.parseDouble(ratingField.getText());

                        if(!isRating(rating)) {
                            showError("Rating must be between 0 and 5.");
                            return;
                        }

                        restaurant.setRating(rating);

                        showSuccess("Rating Updated");

                    } catch(NumberFormatException ex) {

                        showError("Invalid rating.");
                    }
                });
                // Open restaurant
                openRestaurantBtn.setOnAction(d -> {

                    Restaurant restaurant =
                            db.findRestaurant(
                                    searchRestaurantField.getText());

                    if(restaurant != null) {

                        restaurant.setOpen(true);

                        showSuccess("Restaurant Opened");
                    }
                    else {

                        showError("Restaurant Not Found");
                    }
                });

                // Close restaurant
                closeRestaurantBtn.setOnAction(d -> {

                    Restaurant restaurant =
                            db.findRestaurant(
                                    searchRestaurantField.getText());

                    if(restaurant != null) {

                        restaurant.setOpen(false);

                        showSuccess("Restaurant Closed");
                    }
                    else {

                        showError("Restaurant Not Found");
                    }
                });
             // Show restaurants by cuisine
                cuisineBtn.setOnAction(d -> {

                    for(Restaurant restaurant :
                            db.getOpenRestaurantsByCuisine(
                                    cuisineField.getText())) {

                        System.out.println(
                                restaurant);
                    }
                });
             // Show open restaurants only
                openOnlyBtn.setOnAction(d -> {

                    for(Restaurant restaurant :
                            db.getRestaurants()) {

                        if(restaurant.isOpen()) {

                            System.out.println(
                                    restaurant);
                        }
                    }
                });
                
                restaurantRoot.getChildren().addAll(
                        restaurantCodeField,
                        restaurantNameField,
                        cuisineField,
                        saveRestaurantBtn,
                        showRestaurantsBtn,
                        searchRestaurantField,
                        searchRestaurantBtn,
                        ratingField,
                        updateRatingBtn,
                        openRestaurantBtn,
                        closeRestaurantBtn,
                        cuisineBtn,
                        openOnlyBtn);
                Scene restaurantScene =
                        new Scene(
                                restaurantRoot,
                                400,
                                300);

                restaurantStage.setTitle(
                        "Restaurant Management");

                restaurantStage.setScene(
                        restaurantScene);

                restaurantStage.show();
            });
          
         // Open order window
            orderBtn.setOnAction(event -> {

                Stage orderStage =
                        new Stage();

                VBox orderRoot =
                        new VBox(10);

                // Order code field
                TextField orderCodeField =
                        new TextField();

                orderCodeField.setPromptText(
                        "Order Code");

                // Customer code field
                TextField customerCodeField =
                        new TextField();

                customerCodeField.setPromptText(
                        "Customer Code");

                // Restaurant code field
                TextField restaurantCodeField =
                        new TextField();

                restaurantCodeField.setPromptText(
                        "Restaurant Code");

                // Save order button
                Button saveOrderBtn =
                        new Button(
                                "Save Order");
             // Show all orders button
                Button showOrdersBtn =
                        new Button(
                                "Show All Orders");

                // Search order field
                TextField searchOrderField =
                        new TextField();

                searchOrderField.setPromptText(
                        "Order Code");

                // Search order button
                Button searchOrderBtn =
                        new Button(
                                "Search Order");
             // Customer orders field
                TextField customerOrdersField =
                        new TextField();

                customerOrdersField.setPromptText(
                        "Customer Code");

                // Show customer orders button
                Button showCustomerOrdersBtn =
                        new Button(
                                "Customer Orders");
             // Restaurant orders field
                TextField restaurantOrdersField =
                        new TextField();

                restaurantOrdersField.setPromptText(
                        "Restaurant Code");

                // Show restaurant orders button
                Button showRestaurantOrdersBtn =
                        new Button(
                                "Restaurant Orders");
             // Most expensive order button
                Button maxOrderBtn =
                        new Button(
                                "Most Expensive Order");

             // Save order
                saveOrderBtn.setOnAction(d -> {

                    String orderCode =
                            orderCodeField.getText().trim();

                    String customerCode =
                            customerCodeField.getText().trim();

                    String restaurantCode =
                            restaurantCodeField.getText().trim();

                    // Check empty fields
                    if(orderCode.isEmpty()
                            || customerCode.isEmpty()
                            || restaurantCode.isEmpty()) {

                        showError("All fields are required.");
                        return;
                    }

                    Restaurant restaurant =
                            db.findRestaurant(restaurantCode);

                    if(restaurant == null) {

                        showError("Restaurant Not Found.");
                        return;
                    }

                    Order order =
                            new Order(
                                    orderCode,
                                    customerCode,
                                    restaurant,
                                    50.0,
                                    "01/01/2026");

                    db.addOrder(order);

                    showSuccess("Order Saved");
                });
             // Show all orders action
                showOrdersBtn.setOnAction(d -> {

                    for(Order order :
                            db.getOrders()) {

                        System.out.println(order);
                    }
                });

                // Search order action
             // Search order
                searchOrderBtn.setOnAction(d -> {

                    Order order =
                            db.findOrder(
                                    searchOrderField.getText().trim());

                    if(order == null) {

                        showError("Order Not Found");
                        return;
                    }

                    System.out.println(order);
                });
             // Show orders by customer
                showCustomerOrdersBtn.setOnAction(d -> {

                    db.printCustomerOrders(
                            customerOrdersField.getText());
                });
             // Show orders by restaurant
                showRestaurantOrdersBtn.setOnAction(d -> {

                    for(Order order :
                            db.getOrders()) {

                        if(order.getRestaurant()
                                .getRestaurantCode()
                                .equalsIgnoreCase(
                                        restaurantOrdersField.getText())) {

                            System.out.println(
                                    order);
                        }
                    }
                });
             // Show most expensive order
                maxOrderBtn.setOnAction(d -> {

                    Order maxOrder = null;

                    for(Order order :
                            db.getOrders()) {

                        if(maxOrder == null
                                || order.getFinalPrice()
                                > maxOrder.getFinalPrice()) {

                            maxOrder = order;
                        }
                    }

                    if(maxOrder != null) {

                        System.out.println(
                                maxOrder);
                    }
                });

                orderRoot.getChildren().addAll(
                        orderCodeField,
                        customerCodeField,
                        restaurantCodeField,
                        saveOrderBtn,
                        showOrdersBtn,
                        searchOrderField,
                        searchOrderBtn,
                        customerOrdersField,
                        showCustomerOrdersBtn,
                        restaurantOrdersField,
                        showRestaurantOrdersBtn,
                        maxOrderBtn);

                Scene orderScene =
                        new Scene(
                                orderRoot,
                                400,
                                300);

                orderStage.setTitle(
                        "Order Management");

                orderStage.setScene(
                        orderScene);

                orderStage.show();
            });

         // Open restaurant managers window
            managerBtn2.setOnAction(event -> {

                Stage managerStage =
                        new Stage();

                VBox managerRoot =
                        new VBox(10);

                // Username field
                TextField usernameField =
                        new TextField();

                usernameField.setPromptText(
                        "Username");

                // Password field
                TextField passwordField =
                        new TextField();

                passwordField.setPromptText(
                        "Password");
                TextField restaurantCodeField = new TextField();
                restaurantCodeField.setPromptText("Restaurant Code");

                // Save manager button
                Button saveManagerBtn =
                        new Button(
                                "Save Manager");
             // Show managers
                Button showManagersBtn =
                        new Button("Show Managers");

                // Search manager
                TextField searchManagerField =
                        new TextField();
                searchManagerField.setPromptText("Manager Username");

                Button searchManagerBtn =
                        new Button("Search Manager");

                // Update manager status
                Button updateStatusBtn =
                        new Button("Update Status");

                saveManagerBtn.setOnAction(b -> {
                	

                	String managerUsername =
                	        usernameField.getText();

                	String managerPassword =
                	        passwordField.getText();
                	String restaurantCode = restaurantCodeField.getText();

                	Restaurant restaurant = db.findRestaurant(restaurantCode);

                	if (restaurant == null) {
                	    showError("Restaurant Not Found");
                	    return;
                	}

                	RestAdmin manager =
                	        new RestAdmin(
                	                "Manager",
                	                managerUsername,
                	                managerPassword);
                	manager.addRestaurant(restaurant);

                	db.addRestAdmin(manager);
                	showSuccess("Manager Saved");
                });
             // Show all managers
                showManagersBtn.setOnAction(b -> {

                    Alert alert =
                            new Alert(Alert.AlertType.INFORMATION);

                    alert.setTitle("Restaurant Managers");
                    alert.setHeaderText(null);

                    StringBuilder text =
                            new StringBuilder();

                    for (RestAdmin m : db.getRestAdmins()) {

                        text.append(m)
                            .append("\n\n");
                    }

                    if (text.length() == 0) {

                        text.append("No Managers");
                    }

                    alert.setContentText(
                            text.toString());

                    alert.showAndWait();
                });

                // Search manager
                searchManagerBtn.setOnAction(b -> {

                    RestAdmin manager =
                            db.findRestAdmin(searchManagerField.getText());

                    if (manager != null) {
                        showSuccess(manager.toString());
                    } else {
                        showError("Manager Not Found");
                    }
                });

                // Update manager status
                updateStatusBtn.setOnAction(b -> {

                    RestAdmin manager =
                            db.findRestAdmin(searchManagerField.getText());

                    if (manager != null) {

                        manager.setActive(!manager.isActive());

                        showSuccess("Manager status updated");

                    } else {

                        showError("Manager Not Found");
                    }
                });

                managerRoot.getChildren().addAll(
                	    usernameField,
                	    passwordField,
                	    restaurantCodeField,
                	    saveManagerBtn,
                	    showManagersBtn,
                	    searchManagerField,
                	    searchManagerBtn,
                	    updateStatusBtn);

                Scene managerScene =
                        new Scene(
                                managerRoot,
                                400,
                                300);

                managerStage.setTitle(
                        "Restaurant Managers");

                managerStage.setScene(
                        managerScene);

                managerStage.show();
            });

         // Open reports window
            reportsBtn.setOnAction(event -> {

                Stage reportsStage =
                        new Stage();

                VBox reportsRoot =
                        new VBox(10);

                // Reports buttons
                Button topCustomerBtn =
                        new Button(
                                "Top Customer");

                Button topRiderBtn =
                        new Button(
                                "Top Rider");

                Button allOrdersBtn =
                        new Button(
                                "All Orders");

                Button sortReportsBtn =
                        new Button(
                                "Sort Reports");
             // Sort customers by balance
                Button sortCustomersBalanceBtn =
                        new Button(
                                "Customers By Balance");

                // Sort restaurants by rating
                Button sortRestaurantsRatingBtn =
                        new Button(
                                "Restaurants By Rating");

                // Sort riders by deliveries
                Button sortRidersBtn =
                        new Button(
                                "Riders By Deliveries");

                // Sort orders by final price
                Button sortOrdersBtn =
                        new Button(
                                "Orders By Final Price");

                // Total payments button
                Button totalPaymentsBtn =
                        new Button(
                                "Total Payments");
                Button customersTableBtn =
                        new Button("Customers Table");

                Button restaurantsTableBtn =
                        new Button("Restaurants Table");

                Button ordersTableBtn =
                        new Button("Orders Table");

                reportsRoot.getChildren().addAll(
                        topCustomerBtn,
                        topRiderBtn,
                        allOrdersBtn,
                        sortReportsBtn,
                        sortCustomersBalanceBtn,
                        sortRestaurantsRatingBtn,
                        sortRidersBtn,
                        sortOrdersBtn,
                        totalPaymentsBtn,
                        customersTableBtn,
                        restaurantsTableBtn,
                        ordersTableBtn);
             // Show top customer
                topCustomerBtn.setOnAction(d -> {

                    System.out.println(
                            db.getTopCustomer());
                });

                // Show top rider
                topRiderBtn.setOnAction(d -> {

                    System.out.println(
                            db.getTopRider());
                });

                // Show all orders
                allOrdersBtn.setOnAction(d -> {

                    db.printAllOrders();
                });

                // Sort customers by balance
                sortCustomersBalanceBtn.setOnAction(d -> {

                    java.util.Collections.sort(
                            db.getCustomers());

                    for(Customer c :
                            db.getCustomers()) {

                        System.out.println(c);
                    }
                });

                // Sort restaurants by rating
                sortRestaurantsRatingBtn.setOnAction(d -> {

                    db.getRestaurants().sort(
                            (r1, r2) ->
                                    Double.compare(
                                            r2.getRating(),
                                            r1.getRating()));

                    for(Restaurant r :
                            db.getRestaurants()) {

                        System.out.println(r);
                    }
                });

                // Sort riders by deliveries
                sortRidersBtn.setOnAction(d -> {

                    db.getRiders().sort(
                            (r1, r2) ->
                                    Integer.compare(
                                            r2.getOrderCount(),
                                            r1.getOrderCount()));

                    for(Rider r :
                            db.getRiders()) {

                        System.out.println(r);
                    }
                });

                // Sort orders by final price
                sortOrdersBtn.setOnAction(d -> {

                    db.getOrders().sort(
                            (o1, o2) ->
                                    Double.compare(
                                            o2.getFinalPrice(),
                                            o1.getFinalPrice()));

                    for(Order o :
                            db.getOrders()) {

                        System.out.println(o);
                    }
                });

                // Total payments report
                totalPaymentsBtn.setOnAction(d -> {

                    double total = 0;

                    for(Order o :
                            db.getOrders()) {

                        total += o.getFinalPrice();
                    }

                    System.out.println(
                            "Total Payments = "
                                    + total);
                });
             // Customers Table
                customersTableBtn.setOnAction(d -> {

                    Stage tableStage = new Stage();

                    TableView<Customer> table =
                            new TableView<>();

                    TableColumn<Customer, String> codeCol =
                            new TableColumn<>("Code");
                    codeCol.setCellValueFactory(
                            new PropertyValueFactory<>("customerCode"));

                    TableColumn<Customer, String> firstNameCol =
                            new TableColumn<>("First Name");
                    firstNameCol.setCellValueFactory(
                            new PropertyValueFactory<>("firstName"));

                    TableColumn<Customer, String> lastNameCol =
                            new TableColumn<>("Last Name");
                    lastNameCol.setCellValueFactory(
                            new PropertyValueFactory<>("lastName"));

                    TableColumn<Customer, Double> balanceCol =
                            new TableColumn<>("Balance");
                    balanceCol.setCellValueFactory(
                            new PropertyValueFactory<>("balance"));

                    table.getColumns().add(codeCol);
                    table.getColumns().add(firstNameCol);
                    table.getColumns().add(lastNameCol);
                    table.getColumns().add(balanceCol);

                    table.setItems(
                            FXCollections.observableArrayList(
                                    db.getCustomers()));
                    VBox root = new VBox(table);

                    Scene scene =
                            new Scene(root,600,400);

                    tableStage.setTitle(
                            "Customers Table");

                    tableStage.setScene(scene);

                    tableStage.show();
                });
             // Open restaurants table
                restaurantsTableBtn.setOnAction(z -> {

                    // Create new window
                    Stage tableStage =
                            new Stage();

                    // Create table
                    TableView<Restaurant> table =
                            new TableView<>();

                    // Restaurant code column
                    TableColumn<Restaurant, String> codeCol =
                            new TableColumn<>("Code");
                    codeCol.setCellValueFactory(
                            new PropertyValueFactory<>("restaurantCode"));

                    // Restaurant name column
                    TableColumn<Restaurant, String> nameCol =
                            new TableColumn<>("Name");
                    nameCol.setCellValueFactory(
                            new PropertyValueFactory<>("restaurantName"));

                    // Cuisine column
                    TableColumn<Restaurant, String> cuisineCol =
                            new TableColumn<>("Cuisine");
                    cuisineCol.setCellValueFactory(
                            new PropertyValueFactory<>("cuisineType"));

                    // Rating column
                    TableColumn<Restaurant, Double> ratingCol =
                            new TableColumn<>("Rating");
                    ratingCol.setCellValueFactory(
                            new PropertyValueFactory<>("rating"));

                    // Add columns to table
                    table.getColumns().add(codeCol);
                    table.getColumns().add(nameCol);
                    table.getColumns().add(cuisineCol);
                    table.getColumns().add(ratingCol);

                    // Load restaurants into table
                    table.setItems(
                            FXCollections.observableArrayList(
                                    db.getRestaurants()));

                    VBox root =
                            new VBox(table);

                    Scene scene =
                            new Scene(root, 600, 400);

                    tableStage.setTitle(
                            "Restaurants Table");

                    tableStage.setScene(scene);

                    tableStage.show();
                });
             // Open orders table
                ordersTableBtn.setOnAction(s -> {

                    // Create new window
                    Stage tableStage =
                            new Stage();

                    // Create table
                    TableView<Order> table =
                            new TableView<>();

                    // Order code column
                    TableColumn<Order, String> codeCol =
                            new TableColumn<>("Order Code");
                    codeCol.setCellValueFactory(
                            new PropertyValueFactory<>("orderCode"));

                    // Customer code column
                    TableColumn<Order, String> customerCol =
                            new TableColumn<>("Customer");
                    customerCol.setCellValueFactory(
                            new PropertyValueFactory<>("customerCode"));

                    // Final price column
                    TableColumn<Order, Double> priceCol =
                            new TableColumn<>("Final Price");
                    priceCol.setCellValueFactory(
                            new PropertyValueFactory<>("finalPrice"));

                    // Order date column
                    TableColumn<Order, String> dateCol =
                            new TableColumn<>("Order Date");
                    dateCol.setCellValueFactory(
                            new PropertyValueFactory<>("orderDate"));

                    // Add columns to table
                    table.getColumns().add(codeCol);
                    table.getColumns().add(customerCol);
                    table.getColumns().add(priceCol);
                    table.getColumns().add(dateCol);
                    // Load orders into table
                    table.setItems(
                            FXCollections.observableArrayList(
                                    db.getOrders()));

                    VBox root =
                            new VBox(table);

                    Scene scene =
                            new Scene(root, 600, 400);

                    tableStage.setTitle(
                            "Orders Table");

                    tableStage.setScene(scene);

                    tableStage.show();
                });

                Scene reportsScene =
                        new Scene(
                                reportsRoot,
                                400,
                                300);

                reportsStage.setTitle(
                        "Reports And Sorts");

                reportsStage.setScene(
                        reportsScene);

                reportsStage.show();
            });

         // Save data window
            saveBtn.setOnAction(event -> {

                Stage saveStage =
                        new Stage();

                VBox saveRoot =
                        new VBox(10);

                Button saveFileBtn =
                        new Button(
                                "Save To File");
                saveFileBtn.setOnAction(k -> {

                    db.saveCustomersToFile();
                    db.saveRestaurantsToFile();
                    db.saveRidersToFile();
                    db.saveRestAdminsToFile();
                    db.saveOrdersToFile();
                    showSuccess("Data Saved");
                });

                saveRoot.getChildren().add(
                        saveFileBtn);

                Scene saveScene =
                        new Scene(
                                saveRoot,
                                300,
                                200);

                saveStage.setTitle(
                        "Save Data");

                saveStage.setScene(
                        saveScene);

                saveStage.show();
            });

         // Load data window
            loadBtn.setOnAction(event -> {

                Stage loadStage =
                        new Stage();

                VBox loadRoot =
                        new VBox(10);

                Button loadFileBtn =
                        new Button(
                                "Load From File");
                loadFileBtn.setOnAction(m -> {

                	db.loadCustomersFromFile();
                	db.loadRestaurantsFromFile();
                	db.loadRidersFromFile();
                	db.loadRestAdminsFromFile();
                	db.loadOrdersFromFile();
                	showSuccess("Data Loaded");
                    
                });

                loadRoot.getChildren().add(
                        loadFileBtn);

                Scene loadScene =
                        new Scene(
                                loadRoot,
                                300,
                                200);

                loadStage.setTitle(
                        "Load Data");

                loadStage.setScene(
                        loadScene);

                loadStage.show();
            });

            // Back button action
            backBtn.setOnAction(event -> {
                adminStage.close();
            });
         
           

            Scene adminScene =
                    new Scene(
                            adminRoot,
                            400,
                            300);

            adminStage.setTitle(
                    "Admin Menu");

            adminStage.setScene(
                    adminScene);

            adminStage.show();
            	}
        });
        });
        
        // Open customer menu window
        userBtn.setOnAction(event -> {

            Stage loginStage = new Stage();

            VBox root = new VBox(10);

            TextField customerCodeField = new TextField();
            customerCodeField.setPromptText("Customer Code");

            Button loginBtn = new Button("Login");

            root.getChildren().addAll(customerCodeField, loginBtn);

            loginBtn.setOnAction(e -> {

                Customer customer =
                        db.findCustomer(customerCodeField.getText().trim());

                if(customer == null){

                    showError("Customer Not Found");

                }else{

                    CustomerScreen screen =
                            new CustomerScreen(db, customer);

                    screen.show();

                    loginStage.close();
                }
            });

            Scene scene =
                    new Scene(root,300,150);

            loginStage.setTitle("Customer Login");

            loginStage.setScene(scene);

            loginStage.show();
        });
        
     // Restaurant Manager Login window
        managerBtn.setOnAction(event -> {

            Stage managerLoginStage =
                    new Stage();

            VBox managerLoginRoot =
                    new VBox(10);

            TextField usernameField =
                    new TextField();

            usernameField.setPromptText(
                    "Username");

            Button loginBtn =
                    new Button("Login");
            
            managerLoginRoot.getChildren().addAll(
                    usernameField,
                    loginBtn);
            loginBtn.setOnAction(e -> {

                RestAdmin manager =
                        db.findRestAdmin(
                                usernameField.getText().trim());

                if (manager == null) {

                    showError("Manager Not Found");

                    return;
                }

                Stage managerStage =
                        new Stage();

                VBox managerRoot =
                        new VBox(10);

                Button myRestaurantsBtn =
                        new Button("My Restaurants");

                Button addCustomerBtn =
                        new Button("Add Customer");

                Button addOrderBtn =
                        new Button("Add Order");

                Button assignRiderBtn =
                        new Button("Assign Rider");

                Button restaurantOrdersBtn =
                        new Button("Restaurant Orders");

                Button cuisineBtn =
                        new Button("Open Restaurants By Cuisine");

                Button ratingBtn =
                        new Button("Update Rating");

                Button openCloseBtn =
                        new Button("Open / Close Restaurant");

                Button reportsBtn =
                        new Button("Reports");

                managerRoot.getChildren().addAll(
                        myRestaurantsBtn,
                        addCustomerBtn,
                        addOrderBtn,
                        assignRiderBtn,
                        restaurantOrdersBtn,
                        cuisineBtn,
                        ratingBtn,
                        openCloseBtn,
                        reportsBtn);
             // Show managed restaurants
                myRestaurantsBtn.setOnAction(x -> {

                    Alert alert =
                            new Alert(Alert.AlertType.INFORMATION);

                    alert.setTitle("My Restaurants");
                    alert.setHeaderText(null);

                    StringBuilder text =
                            new StringBuilder();

                    for (Restaurant restaurant :
                            manager.getManagedRestaurants()) {

                        text.append(restaurant)
                            .append("\n\n");
                    }

                    if (text.length() == 0) {

                        text.append("No Restaurants");
                    }

                    alert.setContentText(
                            text.toString());

                    alert.showAndWait();
                });
                
             // Add new customer
                addCustomerBtn.setOnAction(x -> {

                    Stage customerStage =
                            new Stage();

                    VBox root =
                            new VBox(10);

                    TextField codeField =
                            new TextField();
                    codeField.setPromptText("Customer Code");

                    TextField firstNameField =
                            new TextField();
                    firstNameField.setPromptText("First Name");

                    TextField lastNameField =
                            new TextField();
                    lastNameField.setPromptText("Last Name");

                    TextField addressField =
                            new TextField();
                    addressField.setPromptText("Address");

                    TextField phoneField =
                            new TextField();
                    phoneField.setPromptText("Phone");

                    TextField emailField =
                            new TextField();
                    emailField.setPromptText("Email");

                    Button saveBtn =
                            new Button("Save");

                    saveBtn.setOnAction(y -> {

                        Customer customer =
                                new Customer(
                                        codeField.getText(),
                                        firstNameField.getText(),
                                        lastNameField.getText(),
                                        addressField.getText(),
                                        phoneField.getText(),
                                        emailField.getText(),
                                        0);

                        db.addCustomer(customer);

                        showSuccess("Customer Saved");

                        customerStage.close();
                    });

                    root.getChildren().addAll(
                            codeField,
                            firstNameField,
                            lastNameField,
                            addressField,
                            phoneField,
                            emailField,
                            saveBtn);

                    customerStage.setScene(
                            new Scene(root,300,300));

                    customerStage.setTitle(
                            "Add Customer");

                    customerStage.show();
                });
                
             // Add new order
                addOrderBtn.setOnAction(x -> {

                    Stage orderStage =
                            new Stage();

                    VBox root =
                            new VBox(10);

                    TextField orderCodeField =
                            new TextField();
                    orderCodeField.setPromptText("Order Code");

                    TextField customerCodeField =
                            new TextField();
                    customerCodeField.setPromptText("Customer Code");

                    TextField restaurantCodeField =
                            new TextField();
                    restaurantCodeField.setPromptText("Restaurant Code");

                    Button saveBtn =
                            new Button("Save Order");

                    saveBtn.setOnAction(y -> {

                        Restaurant restaurant =
                                db.findRestaurant(
                                        restaurantCodeField.getText().trim());

                        if (restaurant == null) {

                            showError("Restaurant Not Found");
                            return;
                        }

                        if (!manager.isManaging(
                                restaurant.getRestaurantCode())) {

                            showError("Restaurant Not Under Your Management");
                            return;
                        }

                        Order order =
                                new Order(
                                        orderCodeField.getText(),
                                        customerCodeField.getText(),
                                        restaurant,
                                        50,
                                        "Today");

                        db.addOrder(order);

                        showSuccess("Order Saved");

                        orderStage.close();
                    });

                    root.getChildren().addAll(
                            orderCodeField,
                            customerCodeField,
                            restaurantCodeField,
                            saveBtn);

                    orderStage.setScene(
                            new Scene(root,300,200));

                    orderStage.setTitle("Add Order");

                    orderStage.show();
                });
             // Assign rider to order
                assignRiderBtn.setOnAction(x -> {

                    Stage assignStage =
                            new Stage();

                    VBox root =
                            new VBox(10);

                    TextField orderCodeField =
                            new TextField();
                    orderCodeField.setPromptText("Order Code");

                    TextField riderIdField =
                            new TextField();
                    riderIdField.setPromptText("Rider ID");

                    Button saveBtn =
                            new Button("Assign");

                    saveBtn.setOnAction(y -> {

                        Order order =
                                db.findOrder(orderCodeField.getText().trim());

                        if (order == null) {

                            showError("Order Not Found");
                            return;
                        }

                        Rider rider =
                                db.findRider(riderIdField.getText().trim());

                        if (rider == null) {

                            showError("Rider Not Found");
                            return;
                        }

                        order.setRiderCode(
                                rider.getRiderId());

                        showSuccess("Rider Assigned");

                        assignStage.close();
                    });

                    root.getChildren().addAll(
                            orderCodeField,
                            riderIdField,
                            saveBtn);

                    assignStage.setScene(
                            new Scene(root,300,180));

                    assignStage.setTitle(
                            "Assign Rider");

                    assignStage.show();
                });
             // Show restaurant orders
                restaurantOrdersBtn.setOnAction(x -> {

                    Stage ordersStage =
                            new Stage();

                    VBox root =
                            new VBox(10);

                    TextField restaurantCodeField =
                            new TextField();

                    restaurantCodeField.setPromptText(
                            "Restaurant Code");

                    Button showBtn =
                            new Button("Show Orders");

                    showBtn.setOnAction(y -> {

                        Alert alert =
                                new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Restaurant Orders");
                        alert.setHeaderText(null);

                        StringBuilder text =
                                new StringBuilder();

                        for (Order order : db.getOrders()) {

                            if (order.getRestaurant()
                                    .getRestaurantCode()
                                    .equalsIgnoreCase(
                                            restaurantCodeField.getText().trim())) {

                                text.append(order)
                                        .append("\n\n");
                            }
                        }

                        if (text.length() == 0) {

                            text.append("No Orders");
                        }

                        alert.setContentText(
                                text.toString());

                        alert.showAndWait();
                    });

                    root.getChildren().addAll(
                            restaurantCodeField,
                            showBtn);

                    ordersStage.setScene(
                            new Scene(root,300,150));

                    ordersStage.setTitle(
                            "Restaurant Orders");

                    ordersStage.show();
                });
             // Show open restaurants by cuisine
                cuisineBtn.setOnAction(x -> {

                    Stage cuisineStage =
                            new Stage();

                    VBox root =
                            new VBox(10);

                    TextField cuisineField =
                            new TextField();

                    cuisineField.setPromptText(
                            "Cuisine");

                    Button showBtn =
                            new Button("Show");

                    showBtn.setOnAction(y -> {

                        Alert alert =
                                new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Open Restaurants");
                        alert.setHeaderText(null);

                        StringBuilder text =
                                new StringBuilder();

                        for (Restaurant restaurant :
                                db.getOpenRestaurantsByCuisine(
                                        cuisineField.getText().trim())) {

                            text.append(restaurant)
                                    .append("\n\n");
                        }

                        if (text.length() == 0) {

                            text.append("No Restaurants");
                        }

                        alert.setContentText(text.toString());

                        alert.showAndWait();
                    });
                    

                    root.getChildren().addAll(
                            cuisineField,
                            showBtn);

                    cuisineStage.setScene(
                            new Scene(root,300,150));

                    cuisineStage.setTitle(
                            "Open Restaurants");

                    cuisineStage.show();
                });
                
             // Update restaurant rating
                ratingBtn.setOnAction(x -> {

                    Stage ratingStage =
                            new Stage();

                    VBox root =
                            new VBox(10);

                    TextField restaurantCodeField =
                            new TextField();

                    restaurantCodeField.setPromptText(
                            "Restaurant Code");

                    TextField ratingField =
                            new TextField();

                    ratingField.setPromptText(
                            "New Rating");

                    Button saveBtn =
                            new Button("Update");

                    saveBtn.setOnAction(y -> {

                        Restaurant restaurant =
                                db.findRestaurant(
                                        restaurantCodeField.getText().trim());

                        if (restaurant == null) {

                            showError("Restaurant Not Found");
                            return;
                        }

                        if (!manager.isManaging(
                                restaurant.getRestaurantCode())) {

                            showError("Restaurant Not Under Your Management");
                            return;
                        }

                        restaurant.setRating(
                                Double.parseDouble(
                                        ratingField.getText()));

                        showSuccess("Rating Updated");

                        ratingStage.close();
                    });

                    root.getChildren().addAll(
                            restaurantCodeField,
                            ratingField,
                            saveBtn);

                    ratingStage.setScene(
                            new Scene(root,300,180));

                    ratingStage.show();
                });
             // Update restaurant rating
                ratingBtn.setOnAction(x -> {

                    Stage ratingStage =
                            new Stage();

                    VBox root =
                            new VBox(10);

                    TextField restaurantCodeField =
                            new TextField();

                    restaurantCodeField.setPromptText(
                            "Restaurant Code");

                    TextField ratingField =
                            new TextField();

                    ratingField.setPromptText(
                            "New Rating");

                    Button saveBtn =
                            new Button("Update");

                    saveBtn.setOnAction(y -> {

                        Restaurant restaurant =
                                db.findRestaurant(
                                        restaurantCodeField.getText().trim());

                        if (restaurant == null) {

                            showError("Restaurant Not Found");
                            return;
                        }

                        if (!manager.isManaging(
                                restaurant.getRestaurantCode())) {

                            showError("Restaurant Not Under Your Management");
                            return;
                        }

                        restaurant.setRating(
                                Double.parseDouble(
                                        ratingField.getText()));

                        showSuccess("Rating Updated");

                        ratingStage.close();
                    });

                    root.getChildren().addAll(
                            restaurantCodeField,
                            ratingField,
                            saveBtn);

                    ratingStage.setScene(
                            new Scene(root,300,180));

                    ratingStage.show();
                });
             // Open or close restaurant
                openCloseBtn.setOnAction(x -> {

                    Stage openStage =
                            new Stage();

                    VBox root =
                            new VBox(10);

                    TextField restaurantCodeField =
                            new TextField();

                    restaurantCodeField.setPromptText(
                            "Restaurant Code");

                    Button toggleBtn =
                            new Button("Open / Close");

                    toggleBtn.setOnAction(y -> {

                        Restaurant restaurant =
                                db.findRestaurant(
                                        restaurantCodeField.getText().trim());

                        if (restaurant == null) {

                            showError("Restaurant Not Found");
                            return;
                        }

                        if (!manager.isManaging(
                                restaurant.getRestaurantCode())) {

                            showError("Restaurant Not Under Your Management");
                            return;
                        }

                        restaurant.setOpen(
                                !restaurant.isOpen());

                        showSuccess("Restaurant Status Updated");

                        openStage.close();
                    });

                    root.getChildren().addAll(
                            restaurantCodeField,
                            toggleBtn);

                    openStage.setScene(
                            new Scene(root,300,150));

                    openStage.show();
                });
             // Show manager reports
                reportsBtn.setOnAction(x -> {

                    Alert alert =
                            new Alert(Alert.AlertType.INFORMATION);

                    alert.setTitle("Restaurant Reports");
                    alert.setHeaderText(null);

                    StringBuilder text =
                            new StringBuilder();

                    text.append("Managed Restaurants: ")
                        .append(manager.getManagedRestaurants().size())
                        .append("\n");

                    int totalOrders = 0;

                    for (Restaurant restaurant :
                            manager.getManagedRestaurants()) {

                        for (Order order : db.getOrders()) {

                            if (order.getRestaurant()
                                    .getRestaurantCode()
                                    .equalsIgnoreCase(
                                            restaurant.getRestaurantCode())) {

                                totalOrders++;
                            }
                        }
                    }

                    text.append("Total Orders: ")
                        .append(totalOrders);

                    alert.setContentText(text.toString());

                    alert.showAndWait();
                });
                
                managerStage.setScene(
                        new Scene(managerRoot, 350, 400));

                managerStage.setTitle(
                        "Restaurant Manager");

                managerStage.show();

                managerLoginStage.close();
            });

            Scene managerLoginScene =
                    new Scene(
                            managerLoginRoot,
                            400,
                            300);

            managerLoginStage.setTitle(
                    "Restaurant Manager Menu");

            managerLoginStage.setScene(
                    managerLoginScene);

            managerLoginStage.show();
        });
     // Rider Login window
        riderBtn.setOnAction(event -> {

            Stage riderLoginStage =
                    new Stage();

            VBox riderLoginRoot =
                    new VBox(10);

            TextField riderIdField =
                    new TextField();

            riderIdField.setPromptText(
                    "Rider ID");

            Button loginBtn =
                    new Button("Login");

            riderLoginRoot.getChildren().addAll(
                    riderIdField,
                    loginBtn);

            loginBtn.setOnAction(e -> {

                Rider rider =
                        db.findRider(
                                riderIdField.getText().trim());

                if (rider == null) {

                    showError("Rider Not Found");

                } else {

                    Stage riderStage =
                            new Stage();

                    VBox riderRoot =
                            new VBox(10);

                    Button myOrdersBtn =
                            new Button("My Orders");

                    Button activeOrderBtn =
                            new Button("Active Order");

                    Button onTheWayBtn =
                            new Button("Set ON_THE_WAY");

                    Button deliveredBtn =
                            new Button("Set DELIVERED");

                    Button historyBtn =
                            new Button("Delivery History");

                    Button countBtn =
                            new Button("Delivery Count");

                    riderRoot.getChildren().addAll(
                            myOrdersBtn,
                            activeOrderBtn,
                            onTheWayBtn,
                            deliveredBtn,
                            historyBtn,
                            countBtn);
                 // Show all rider orders
                    myOrdersBtn.setOnAction(x -> {

                        Alert alert =
                                new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("My Orders");
                        alert.setHeaderText(null);

                        StringBuilder text =
                                new StringBuilder();

                        for (Order order :
                                db.getActiveOrdersByRider(
                                        rider.getRiderId())) {

                            text.append(order)
                                .append("\n\n");
                        }

                        if(text.length() == 0){

                            text.append("No Orders");
                        }

                        alert.setContentText(
                                text.toString());

                        alert.showAndWait();
                    });
                    
                 // Show current active order
                    activeOrderBtn.setOnAction(x -> {

                        Alert alert =
                                new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Active Order");
                        alert.setHeaderText(null);

                        ArrayList<Order> orders =
                                db.getActiveOrdersByRider(
                                        rider.getRiderId());

                        if (orders.isEmpty()) {

                            alert.setContentText(
                                    "No Active Order");

                        } else {

                            alert.setContentText(
                                    orders.get(0).toString());
                        }

                        alert.showAndWait();
                    });
                    
                 // Update order status to ON_THE_WAY
                    onTheWayBtn.setOnAction(x -> {

                        ArrayList<Order> orders =
                                db.getActiveOrdersByRider(
                                        rider.getRiderId());

                        if (orders.isEmpty()) {

                            showError("No Active Order");

                            return;
                        }

                        Order order =
                                orders.get(0);

                        order.setStatus(
                                OrderStatus.ON_THE_WAY);

                        showSuccess(
                                "Order Status Updated");
                    });
                    
                 // Update order status to DELIVERED
                    deliveredBtn.setOnAction(x -> {

                        ArrayList<Order> orders =
                                db.getActiveOrdersByRider(
                                        rider.getRiderId());

                        if (orders.isEmpty()) {

                            showError("No Active Order");

                            return;
                        }

                        Order order =
                                orders.get(0);

                        order.setStatus(
                                OrderStatus.DELIVERED);

                        order.setDeliveryDate(
                                "Today");

                        rider.addOrder(order);

                        showSuccess(
                                "Order Delivered");
                    });
                    
                 // Show completed deliveries
                    historyBtn.setOnAction(x -> {

                        Alert alert =
                                new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Delivery History");
                        alert.setHeaderText(null);

                        StringBuilder text =
                                new StringBuilder();

                        for (Order order :
                                rider.getCompletedOrders()) {

                            text.append(order)
                                .append("\n\n");
                        }

                        if (text.length() == 0) {

                            text.append("No Completed Deliveries");
                        }

                        alert.setContentText(
                                text.toString());

                        alert.showAndWait();
                    });
                    
                 // Show completed deliveries count
                    countBtn.setOnAction(x -> {

                        Alert alert =
                                new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Delivery Count");
                        alert.setHeaderText(null);

                        alert.setContentText(
                                "Completed Deliveries: "
                                + rider.getOrderCount());

                        alert.showAndWait();
                    });

                    riderStage.setScene(
                            new Scene(riderRoot,300,300));

                    riderStage.setTitle("Rider Screen");

                    riderStage.show();

                    riderLoginStage.close();
                }
            });

            Scene riderLoginScene =
                    new Scene(
                            riderLoginRoot,
                            400,
                            300);

            riderLoginStage.setTitle(
                    "Rider Menu");

            riderLoginStage.setScene(
                    riderLoginScene);

            riderLoginStage.show();
        });
     
        

        VBox root =
                new VBox(15);

        root.getChildren().addAll(
                adminBtn,
                managerBtn,
                userBtn,
                riderBtn,
                exitBtn);

        Scene scene =
                new Scene(
                        root,
                        400,
                        300);

        stage.setTitle(
                "Food Delivery System");

        stage.setScene(scene);

        stage.show();
        
    }

    public static void main(String[] args) {

        launch(args);
    }
}
