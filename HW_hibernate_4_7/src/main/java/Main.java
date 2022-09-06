import models.Animal;
import repos.AnimalHelper;

import java.util.List;

/**
 * Домашнее задание 4
 * Задание 7
 * Создать новую базу данных с помощью MySQLWorkbench.
 * Создать обычный java-проект и подключить к нему библиотеки JPA и Hibernate.
 * Создать файл с настройками persistence.xml в папке META-INF.
 * И создать класс Animal(int age, String name, boolean tail) с методами get и set, как сущность к нашей таблице.
 * И с помощью jpa сделать crud в классе AnimalHelper.
 */

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal(10, "Cat", true);
        Animal animal2 = new Animal(5, "Dog", false);
        Animal animal3 = new Animal(17, "Horse", true);

        AnimalHelper animalHelper = new AnimalHelper();

        //1.добавление Animal в базу
        animalHelper.add(animal1);
        animalHelper.add(animal2);
        animalHelper.add(animal3);

        //2.получение всех Animal из базы
        List<Animal> animalList = animalHelper.getAll();
        for (Animal animal : animalList) {
            System.out.println(animal);
        }

        //3.обновление имени на "NEW Dog" Animal с Id 2L
        animalHelper.updateNameById(2L, "NEW Dog");

        //4.получение Animal из базы с Id 2L это обновленный с именем "NEW Dog"
        Animal animal = animalHelper.getById(2L);
        System.out.println(animal);

        //5.удаление Animal из базы с Id 2L
        animalHelper.removeById(2L);

    }
}
