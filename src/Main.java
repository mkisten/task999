import java.util.Arrays;
import java.util.stream.IntStream;

import static java.util.Arrays.*;

public class Main {
    public static void main(String[] args) {
        int [] array1 = {2, 5, 8, 10};
        int [] array2 = {1, 3, 6, 12};
        int [] arraySorted =sortedArray(array1, array2);
        System.out.println(Arrays.toString(arraySorted));;
    }
    public static int[] sortedArray(int[] array1, int[] array2){
        int [] mergedArray = IntStream.concat(stream(array1), stream(array2)).toArray();
        Arrays.sort(mergedArray);
        return mergedArray;
    }


}


import java.util.Arrays;
import java.util.List;

@Data
class Room {
    private List<Person> persons;
    private int roomNumber;
}

@Data
class Person {
    private String name;
    private int age;
}

public class Main {
    public static void main(String[] args) {
        List<Room> rooms = Arrays.asList(
                new Room(Arrays.asList(new Person("Alice", 25), new Person("Bob", 30)), 101),
                new Room(Arrays.asList(new Person("Charlie", 20), new Person("David", 35)), 102),
                new Room(Arrays.asList(new Person("Eve", 22), new Person("Frank", 28)), 103)
        );

        int minAge = 25;

        int result = rooms.stream()
                .flatMap(room -> room.getPersons().stream())
                .filter(person -> person.getAge() < minAge)
                .map(Person::getRoomNumber)
                .findFirst()
                .orElse(-1);

        System.out.println("Номер комнаты с человеком младше " + minAge + ": " + result);
    }
}
