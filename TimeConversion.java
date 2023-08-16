import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time in 12-hour format (hh:mm:ss AM/PM): ");
        String time12Hour = scanner.nextLine();

        String militaryTime = convertToMilitaryTime(time12Hour);
        System.out.println("Military (24-hour) time: " + militaryTime);

        scanner.close();
    }

    public static String convertToMilitaryTime(String time12Hour) {
        int hours = Integer.parseInt(time12Hour.substring(0, 2));
        int minutes = Integer.parseInt(time12Hour.substring(3, 5));
        int seconds = Integer.parseInt(time12Hour.substring(6, 8));
        String period = time12Hour.substring(9);

        if (period.equals("PM") && hours != 12) {
            hours += 12;
        } else if (period.equals("AM") && hours == 12) {
            hours = 0;
        }

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
