// Source code is decompiled from a .class file using FernFlower decompiler.
class ContactManager$Contact {
   private String name;
   private String phoneNumber;
   private String email;

   public ContactManager$Contact(String var1, String var2, String var3) {
      this.name = var1;
      this.phoneNumber = var2;
      this.email = var3;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public String getPhoneNumber() {
      return this.phoneNumber;
   }

   public void setPhoneNumber(String var1) {
      this.phoneNumber = var1;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String var1) {
      this.email = var1;
   }

   public String toString() {
      return "Name: " + this.name + ", Phone: " + this.phoneNumber + ", Email: " + this.email;
   }
}
