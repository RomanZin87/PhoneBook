import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Contact implements Serializable {

    private String name;
    private String surname;
    private String nickname;
    private String phoneNumber;
    private String email;
    private String birthday;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        List<String> propList = Stream.of(name, surname, nickname, phoneNumber, email, birthday).
                filter(Objects::nonNull).
                collect(Collectors.toList());
        return propList.toString().replaceAll("\\s*,", "");
    }
}
