package be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Admin {
   
   private SimpleStringProperty username = new SimpleStringProperty();
   private SimpleStringProperty password = new SimpleStringProperty();

   public Admin( String username, String password){

      setUsername(username);
      setPassword(password);
   }

   public String getUsername() {
      return username.get();
   }

   public final void setUsername(String username){
      this.username.set(username);
   }

   public String getPassword() {
      return password.get();
   }

   public final void setPassword(String password){
      this.password.set(password);
   }

   public SimpleStringProperty usernameProperty() {
      return username;
   }

   public SimpleStringProperty passwordProperty() {
      return password;
   }
}

