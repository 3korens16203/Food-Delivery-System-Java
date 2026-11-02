package hw;
import java.util.Objects;

/**
* High-level system-wide administrative account entity.
*/
public class Admin {
   private String managerName;
   private String username;
   private String password;

   // Generate Constructor using fields
   public Admin(String managerName, String username, String password) {
       this.managerName = managerName;
       this.username = username;
       this.password = password;
   }

   // Generate Getters & Setters
   public String getManagerName() { return managerName; }
   public void setManagerName(String managerName) { this.managerName = managerName; }

   public String getUsername() { return username; }
   public void setUsername(String username) { this.username = username; }

   public String getPassword() { return password; }
   public void setPassword(String password) { this.password = password; }

   // Generate equals & hashCode
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Admin admin = (Admin) o;
       return Objects.equals(username, admin.username);
   }

   @Override
   public int hashCode() {
       return Objects.hash(username);
   }

   // Generate toString
   @Override
   public String toString() {
       return "Admin{" + "managerName='" + managerName + '\'' + ", username='" + username + '\'' + '}';
   }
}