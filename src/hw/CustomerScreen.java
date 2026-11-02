package hw;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class CustomerScreen {
	// Database reference
	private DeliveryDataBase db;
	private Customer customer;
	
	// Constructor
	public CustomerScreen(DeliveryDataBase db,
	                      Customer customer) {

	    this.db = db;
	    this.customer = customer;
	}
	

	// Open customer menu
    public void show() {

        Stage stage =
                new Stage();

        VBox root =
                new VBox(10);

        Button myDetailsBtn =
                new Button("My Details");

        Button updateCustomerBtn =
                new Button("Update Customer");

        Button depositBtn =
                new Button("Deposit Money");

        Button withdrawBtn =
                new Button("Withdraw Money");
        
        Button newOrderBtn =
                new Button("New Order");
        
        Button balanceBtn =
                new Button("Show Balance");

        Button showOrdersBtn =
                new Button("Show Customer Orders");

        Button showRestaurantsBtn =
                new Button("Show Customer Restaurants");

        Button showPremiumBtn =
                new Button("Show Premium Restaurants");
        
        Button searchRestaurantBtn =
                new Button("Search Restaurant");

        Button backBtn =
                new Button("Back");

        root.getChildren().addAll(
                myDetailsBtn,
                updateCustomerBtn,
                depositBtn,
                withdrawBtn,
                newOrderBtn,
                balanceBtn,
                searchRestaurantBtn,
                showOrdersBtn,
                showRestaurantsBtn,
                showPremiumBtn,
                backBtn);
        
     
     // Update customer details
        updateCustomerBtn.setOnAction(e -> {

            Stage updateStage =
                    new Stage();

            VBox updateRoot =
                    new VBox(10);

            TextField phoneField =
                    new TextField(customer.getPhoneNumber());

            TextField emailField =
                    new TextField(customer.getEmail());

            TextField addressField =
                    new TextField(customer.getFullAddress());

            Button saveBtn =
                    new Button("Save");

            saveBtn.setOnAction(x -> {

                customer.setPhoneNumber(
                        phoneField.getText());

                customer.setEmail(
                        emailField.getText());

                customer.setFullAddress(
                        addressField.getText());

                Alert alert =
                        new Alert(Alert.AlertType.INFORMATION);

                alert.setContentText(
                        "Customer Updated");

                alert.showAndWait();

                updateStage.close();
            });

            updateRoot.getChildren().addAll(
                    addressField,
                    phoneField,
                    emailField,
                    saveBtn);

            Scene scene =
                    new Scene(updateRoot,300,200);

            updateStage.setTitle(
                    "Update Customer");

            updateStage.setScene(scene);

            updateStage.show();
        });

        // Deposit money to customer account
        depositBtn.setOnAction(e -> {

            Stage depositStage = new Stage();

            VBox depositRoot = new VBox(10);

            TextField amountField = new TextField();
            amountField.setPromptText("Amount");

            Button saveBtn = new Button("Deposit");

            saveBtn.setOnAction(x -> {

                try {

                    double amount =
                            Double.parseDouble(amountField.getText());

                    if(amount <= 0){

                        Alert alert =
                                new Alert(Alert.AlertType.ERROR);

                        alert.setContentText("Invalid Amount");

                        alert.showAndWait();

                        return;
                    }

                    customer.setBalance(
                            customer.getBalance() + amount);

                    Alert alert =
                            new Alert(Alert.AlertType.INFORMATION);

                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "New Balance: " + customer.getBalance());

                    alert.showAndWait();

                    depositStage.close();

                } catch (NumberFormatException ex) {

                    Alert alert =
                            new Alert(Alert.AlertType.ERROR);

                    alert.setContentText("Enter Numbers Only");

                    alert.showAndWait();
                }

            });

            depositRoot.getChildren().addAll(
                    amountField,
                    saveBtn);

            Scene scene = new Scene(depositRoot,250,120);

            depositStage.setTitle("Deposit Money");

            depositStage.setScene(scene);

            depositStage.show();
        });

     // Withdraw money from customer account
        withdrawBtn.setOnAction(e -> {

            Stage withdrawStage = new Stage();

            VBox withdrawRoot = new VBox(10);

            TextField amountField = new TextField();
            amountField.setPromptText("Amount");

            Button saveBtn = new Button("Withdraw");

            saveBtn.setOnAction(x -> {

                try {

                    double amount =
                            Double.parseDouble(amountField.getText());

                    if (amount <= 0) {

                        Alert alert =
                                new Alert(Alert.AlertType.ERROR);

                        alert.setContentText("Invalid Amount");

                        alert.showAndWait();

                        return;
                    }

                    if (amount > customer.getBalance()) {

                        Alert alert =
                                new Alert(Alert.AlertType.ERROR);

                        alert.setContentText("Insufficient Balance");

                        alert.showAndWait();

                        return;
                    }

                    customer.setBalance(
                            customer.getBalance() - amount);

                    Alert alert =
                            new Alert(Alert.AlertType.INFORMATION);

                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "New Balance: " + customer.getBalance());

                    alert.showAndWait();

                    withdrawStage.close();

                } catch (NumberFormatException ex) {

                    Alert alert =
                            new Alert(Alert.AlertType.ERROR);

                    alert.setContentText("Enter Numbers Only");

                    alert.showAndWait();
                }

            });
            

            withdrawRoot.getChildren().addAll(
                    amountField,
                    saveBtn);

            Scene scene =
                    new Scene(withdrawRoot, 250, 120);

            withdrawStage.setTitle("Withdraw Money");

            withdrawStage.setScene(scene);

            withdrawStage.show();
        });
     // Create new order
        newOrderBtn.setOnAction(e -> {

            Stage orderStage =
                    new Stage();

            VBox orderRoot =
                    new VBox(10);

            TextField orderCodeField =
                    new TextField();
            orderCodeField.setPromptText("Order Code");

            TextField restaurantCodeField =
                    new TextField();
            restaurantCodeField.setPromptText("Restaurant Code");

            Button saveBtn =
                    new Button("Save Order");

            saveBtn.setOnAction(x -> {

                Restaurant restaurant =
                        db.findRestaurant(
                                restaurantCodeField.getText().trim());

                if (restaurant == null) {

                    Alert alert =
                            new Alert(Alert.AlertType.ERROR);

                    alert.setContentText("Restaurant Not Found");

                    alert.showAndWait();

                    return;
                }

                Order order =
                        new Order(
                                orderCodeField.getText().trim(),
                                customer.getCustomerCode(),
                                restaurant,
                                50,
                                "Today");

                db.addOrder(order);

                Alert alert =
                        new Alert(Alert.AlertType.INFORMATION);

                alert.setContentText("Order Created");

                alert.showAndWait();

                orderStage.close();
            });

            orderRoot.getChildren().addAll(
                    orderCodeField,
                    restaurantCodeField,
                    saveBtn);

            orderStage.setScene(
                    new Scene(orderRoot,300,180));

            orderStage.setTitle("New Order");

            orderStage.show();
        });
        

        // Show customer orders
        showOrdersBtn.setOnAction(e -> {

            db.printCustomerOrders(
                    customer.getCustomerCode());
        });

        // Show restaurants visited by customer
        showRestaurantsBtn.setOnAction(e -> {

            db.printCustomerRestaurants(
                    customer.getCustomerCode());
        });


        // Show premium restaurants
        showPremiumBtn.setOnAction(e -> {

            db.printPremiumRestaurants(
                    customer);
        });
        // Show current balance
        balanceBtn.setOnAction(e -> {

            Alert alert =
                    new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle(
                    "Current Balance");

            alert.setHeaderText(
                    null);

            alert.setContentText(
                    "Current Balance: " +
                    customer.getBalance());

            alert.showAndWait();
        });
        
     // Search restaurant by code
        searchRestaurantBtn.setOnAction(e -> {

            Stage searchStage =
                    new Stage();

            VBox searchRoot =
                    new VBox(10);

            TextField codeField =
                    new TextField();

            codeField.setPromptText(
                    "Restaurant Code");

            Button searchBtn =
                    new Button("Search");

            searchBtn.setOnAction(x -> {

                Restaurant restaurant =
                        db.findRestaurant(
                                codeField.getText().trim());

                if (restaurant == null) {

                    Alert alert =
                            new Alert(Alert.AlertType.ERROR);

                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "Restaurant Not Found");

                    alert.showAndWait();

                } else {

                    Alert alert =
                            new Alert(Alert.AlertType.INFORMATION);

                    alert.setTitle("Restaurant");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            restaurant.toString());

                    alert.showAndWait();
                }
            });

            searchRoot.getChildren().addAll(
                    codeField,
                    searchBtn);

            Scene scene =
                    new Scene(searchRoot,
                            300,
                            120);

            searchStage.setTitle(
                    "Search Restaurant");

            searchStage.setScene(scene);

            searchStage.show();
        });

        myDetailsBtn.setOnAction(e -> {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("My Details");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Code: " + customer.getCustomerCode() +
                    "\nName: " + customer.getFirstName() + " " + customer.getLastName() +
                    "\nAddress: " + customer.getFullAddress() +
                    "\nPhone: " + customer.getPhoneNumber() +
                    "\nEmail: " + customer.getEmail() +
                    "\nBalance: " + customer.getBalance());

            alert.showAndWait();
        });
        // Close screen
        backBtn.setOnAction(e ->
                stage.close());

        Scene scene =
                new Scene(
                        root,
                        400,
                        400);

        stage.setTitle("Customer Menu");

        stage.setScene(
                scene);

        stage.show();
    }
}
