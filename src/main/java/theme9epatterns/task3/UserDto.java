package theme9epatterns.task3;

public class UserDto {
    private final String name;
    private final String surname;
    private final String password;

    public UserDto(String name, String password) {
        this.name = name;
        this.surname = null;
        this.password = password;
    }

    public UserDto(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }
}
