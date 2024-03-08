package iut.montreuil.authent;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class TestJavaVersion {

    public static void main(String[] args) {
        System.out.print("Duration of switchJava -> ");
        System.out.println(switchJava("A").toNanos());

        System.out.print("Duration of switchJava17 -> ");
        System.out.println(switchJava17("A").toNanos());
    }

    private static LocalTime printDate() {
        LocalTime localTime = LocalTime.now();
        return localTime;
    }

    private static Duration switchJava(String value) {
        LocalTime localTimeDebut = printDate();
        switch (value) {
            case "A":
                System.out.print(" callMethod1() ");
                break;
            case "B":
                System.out.print(" callMethod2() ");
                break;
            default:
                System.out.print(" callDefaultMethod() ");
        };
        return Duration.between(localTimeDebut, printDate());
    }

    private static Duration switchJava17(String value) {
        LocalTime localTimeDebut = printDate();
        switch (value) {
            case "A" -> System.out.print(" callMethod1() ");
            case "B" -> System.out.print(" callMethod2() ");
            default -> System.out.print(" callDefaultMethod() ");
        }
        return Duration.between(localTimeDebut, printDate());
    }
}
