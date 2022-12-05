package com.yakushkin.portal.util;

import com.github.javafaker.Faker;
import com.yakushkin.portal.entity.enumiration.AccommodationType;
import com.yakushkin.portal.entity.enumiration.PetType;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@UtilityClass
public class TestDataGeneratorPet {
    private final static Faker FAKER = Faker.instance();

    public static void main(String[] args) {
        printInsertSql(10);
    }

    public void printInsertSql(Integer countEntity) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO pet (name, birthday, pet_type, chipped, type_of_accommodation) VALUES ");

        for (int i = 0; i < countEntity; i++) {
            String animalName = FAKER.funnyName().name();
            LocalDate birthday = convertDateToLocalDate(FAKER.date().birthday(1, 20));
            PetType petType = getRandomPetType();
            boolean chipped = isChipped();
            AccommodationType accommodationType = getRandomAccommodationType();

            stringBuilder.append(String.format("\n('%s','%s','%s','%s','%s'),", animalName, birthday, petType, chipped, accommodationType));
        }

        stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), ";");

        System.out.println(stringBuilder);
    }

    private static PetType getRandomPetType() {
        int countOfType = PetType.values().length;
        int randomTypeIndex = FAKER.number().numberBetween(0, countOfType);

        return PetType.values()[randomTypeIndex];
    }

    private static Boolean isChipped() {

        return FAKER.bool().bool();
    }

    private static AccommodationType getRandomAccommodationType() {
        int countOfAccommodationType = AccommodationType.values().length;
        int randomTypeIndex = FAKER.number().numberBetween(0, countOfAccommodationType);

        return AccommodationType.values()[randomTypeIndex];
    }

    private static LocalDate convertDateToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
