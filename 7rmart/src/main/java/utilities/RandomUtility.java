package utilities;

import com.github.javafaker.Faker;

public class RandomUtility {

	Faker faker;
	
	public String generateFirstName() {
		faker = new Faker();
		return faker.name().firstName();
	}
	
	public String generateCode() {
		faker = new Faker();
		return faker.currency().code();
	}
	
	public String generateLastName() {
		faker = new Faker();
		return faker.name().lastName();
	}
	
	public String generateFullName() {
		faker = new Faker();
		return faker.name().fullName();
	}
	
	public String generatePhoneNumber() {
		faker = new Faker();
		return faker.phoneNumber().phoneNumber();
	}
	
	public String generateEmail() {
		faker = new Faker();
		return faker.internet().emailAddress();
	}
	
	public String generatePassword(int minLength, int maxLength) {
		faker = new Faker();
		return faker.internet().password(minLength, maxLength, true, true, true);
	}
}