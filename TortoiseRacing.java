import java.util.Arrays;

public class TortoiseRacing { // TODO: Add description

    public static void main(String[] args) {
        int speedOfTheFirstTortoise = 10;
        int speedOfTheSecondTortoise = 20;
        int distanceBetweenTortoises = 7;

        TortoiseRacing tr = new TortoiseRacing();
        int timeBeforeMeeting = tr.calculateTimeBeforeMeeting(speedOfTheFirstTortoise, speedOfTheSecondTortoise, distanceBetweenTortoises);

        System.out.println(Arrays.toString(tr.convertTimeBeforeMeeting(timeBeforeMeeting)));

    }

    public int calculateTimeBeforeMeeting(int speedOfFirstTortoise,
                                          int speedOfSecondTortoise,
                                          int distanceBetweenTortoises) {

        return (3600 * distanceBetweenTortoises) / (speedOfSecondTortoise - speedOfFirstTortoise);
    }

    public int[] convertTimeBeforeMeeting(int timeBeforeMeetingInSeconds) {
        int[] convertedTime = new int[3];
        convertedTime[0] = timeBeforeMeetingInSeconds / 3600;
        convertedTime[1] = (timeBeforeMeetingInSeconds % 3600) / 60;
        convertedTime[2] = timeBeforeMeetingInSeconds % 60;

        return convertedTime;
    }
}