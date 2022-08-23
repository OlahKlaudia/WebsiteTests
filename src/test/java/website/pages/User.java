package website.pages;

public class User {
    private final String firstName; // required
    private final String lastName; // required
    private final String zip; // optional
    private final String phone; // optional
    private final String password; // optional
    private final String email;
    private final String state;
    private final String alias_address;
    private final String address; // optional

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.zip = builder.zip;
        this.phone = builder.phone;
        this.address = builder.address;
        this.password = builder.password;
        this.email = builder.email;
        this.state = builder.state;
        this.alias_address = builder.alias_address;
    }

    //All getter, and NO setter to provde immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getZip() {
        return zip;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getState() {
        return state;
    }
    public String getAlias_address() {
        return alias_address;
    }

    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.zip+", "+this.phone+", "+this.address+", "+this.password+", "+this.email+", "+this.state+", "+this.alias_address;
    }

    public static class UserBuilder
    {
        private  String firstName;
        private final String lastName;
        private String zip;
        private String phone;
        private String address;
        private String password;
        private String email;
        private String state;
        private String alias_address;
        public UserBuilder( String lastName) {
            this.lastName = lastName;
        }
        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public UserBuilder zip(String zip) {
            this.zip = zip;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public UserBuilder state(String state) {
            this.state = state;
            return this;
        }
        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }
        public UserBuilder alias_address(String alias_address) {
            this.alias_address = alias_address;
            return this;
        }
        //Return the finally consrcuted User object
        public User build() {
            User user =  new User(this);
            return user;
        }
    }
}

