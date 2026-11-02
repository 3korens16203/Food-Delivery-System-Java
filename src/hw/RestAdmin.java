package hw;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Restaurant manager account capable of supervising
 * assigned restaurants in the system.
 */
public class RestAdmin {
    // Manager full name
    private String managerName;
    // Login username
    private String username;
    // Login password
    private String password;
    // Collection of restaurants managed by this admin
    private ArrayList<Restaurant> managedRestaurants;
    private boolean active;
    /**
     * Full constructor.
     *
     * @param managerName Manager full name
     * @param username Login username
     * @param password Login password
     */
    public RestAdmin(String managerName,
                     String username,
                     String password) {
    	setManagerName(managerName);
    	setUsername(username);
    	setPassword(password);
        // Initialize restaurants collection
        this.managedRestaurants =
                new ArrayList<>();
        this.active= true;
    }
    
    // GETTERS & SETTERS
    
    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {

        if (managerName != null
                && managerName.matches(
                "^[a-zA-Z\\s\u0590-\u05FF]+$")) {

            this.managerName = managerName;

        } else {

            this.managerName = "Unknown";
        }
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {

        if (username != null
                && !username.trim().isEmpty()) {

            this.username = username;

        } else {

            this.username = "user";
        }
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {

        if (password != null
                && password.length() >= 3) {

            this.password = password;

        } else {

            this.password = "123";
        }
    }
    public ArrayList<Restaurant>
    getManagedRestaurants() {
        return managedRestaurants;
    }
    public void setManagedRestaurants(
            ArrayList<Restaurant> managedRestaurants) {
        this.managedRestaurants =
                managedRestaurants;
    }
    
    // CUSTOM METHODS
    
    /**
     * Adds restaurant to manager collection.
     * Prevents duplicate restaurants.
     *
     * @param restaurant Restaurant object
     */
    public void addRestaurant(
            Restaurant restaurant) {
        // Prevent duplicates
        if (!managedRestaurants
                .contains(restaurant)) {
            managedRestaurants
                    .add(restaurant);
        }
    }
    /**
     * Checks if manager controls
     * a specific restaurant.
     *
     * @param restaurantCode Restaurant code
     * @return true if manager controls restaurant
     */
    public boolean isManaging(
            String restaurantCode) {
        for (Restaurant restaurant
                : managedRestaurants) {
            if (restaurant.getRestaurantCode()
                    .equalsIgnoreCase(
                            restaurantCode)) {
                return true;
            }
        }
        return false;
    }
    
    // EQUALS & HASHCODE
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null
                || getClass() != o.getClass())
            return false;
        RestAdmin restAdmin =
                (RestAdmin) o;
        return Objects.equals(
                username,
                restAdmin.username);
    }
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
    
    // TOSTRING
    
    @Override
    public String toString() {
        return "RestAdmin{" +
                "managerName='" +
                managerName + '\'' +
                ", username='" +
                username + '\'' +
                ", managedRestaurants=" +
                managedRestaurants.size() +
                '}';
    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}