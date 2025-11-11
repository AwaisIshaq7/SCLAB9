class Name {
    String name;

    public String getName(String name) {
        this.name = name;
        return name;
    }

    public String formatName() {
        return name.toUpperCase();
    }

    public boolean isValidName() {
        return name != null && !name.trim().isEmpty();
    }
}

class Age {
    int age;

    public int getAge(int age) {
        this.age = age;
        return age;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public String getAgeCategory() {
        if (age < 12) return "Child";
        if (age < 20) return "Teenager";
        if (age < 45) return "Adult";
        return "Senior";
    }
}

class PhoneNumber {
    String phoneNumber;

    public String getNumber(String number) {
        this.phoneNumber = number;
        return number;
    }

    public String formatNumber() {
        return "+1-" + phoneNumber;
    }

    public boolean isValidNumber() {
        return phoneNumber != null && phoneNumber.length() == 10;
    }
}

class PersonDisplay {
    public static void main(String[] args) {
        Name personName = new Name();
        System.out.println("Your Name: " + personName.getName("Awais Ishaq"));
        System.out.println("Formatted: " + personName.formatName());
        System.out.println("Valid: " + personName.isValidName());

        Age personAge = new Age();
        System.out.println("Age: " + personAge.getAge(50));
        System.out.println("Adult: " + personAge.isAdult());
        System.out.println("Category: " + personAge.getAgeCategory());

        PhoneNumber personNumber = new PhoneNumber();
        System.out.println("Phone: " + personNumber.getNumber("099492018"));
        System.out.println("Formatted: " + personNumber.formatNumber());
        System.out.println("Valid: " + personNumber.isValidNumber());
    }
}