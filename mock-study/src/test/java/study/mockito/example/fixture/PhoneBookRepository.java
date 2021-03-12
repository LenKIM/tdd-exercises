package study.mockito.example.fixture;

public class PhoneBookRepository {

    public boolean contains(String name) {
        return true;
    }

    public void insert(String name, String phone) {
    }

    public String getPhoneNumberByContactName(String name) {
        return "";
    }
}
