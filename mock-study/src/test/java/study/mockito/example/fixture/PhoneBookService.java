package study.mockito.example.fixture;


public class PhoneBookService {

    private final PhoneBookRepository phoneBookRepository;

    public PhoneBookService(PhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    public void register(String name, String phone) {
        if(!name.isEmpty() && !phone.isEmpty()
                && !phoneBookRepository.contains(name)) {
            phoneBookRepository.insert(name, phone);
        }
    }

    public String search(String name) {
        if(!name.isEmpty() && phoneBookRepository.contains(name)) {
            return phoneBookRepository.getPhoneNumberByContactName(name);
        }
        return null;
    }

    public String search(String name, String name2, String name3) {
        return "";
    }
}