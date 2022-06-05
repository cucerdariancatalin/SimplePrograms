package com.SimplePrograms;

import java.util.Arrays;

/**
 * A program for finding the time to cover the distance
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class TortoiseRacing {

    /**
     * Method that launches the program
     */
    public static void main(String[] args) {
        int speedOfTheFirstTortoise = 15, speedOfTheSecondTortoise = 300, distanceBetweenTortoises = 1000;

        System.out.println(Arrays.toString(new TortoiseRacing().calculateTimeBeforeMeeting(speedOfTheFirstTortoise, speedOfTheSecondTortoise, distanceBetweenTortoises)));
    }

    /**
     * Method for calculating the time before the meeting.
     * First the time is found in seconds, then it is converted by the
     * {@link TortoiseRacing#convertTimeBeforeMeeting(int timeBeforeMeetingInSeconds)} to an array
     */
    public int[] calculateTimeBeforeMeeting(int speedOfFirstTortoise,
                                            int speedOfSecondTortoise,
                                            int distanceBetweenTortoises) {

        int timeBeforeMeetingInSeconds = (3600 * distanceBetweenTortoises) / (speedOfSecondTortoise - speedOfFirstTortoise);

        return convertTimeBeforeMeeting(timeBeforeMeetingInSeconds);
    }

    /**
     * Method for converting to an array of the form [hours, minutes, seconds]
     */
    private int[] convertTimeBeforeMeeting(int timeBeforeMeetingInSeconds) {
        int[] convertedTime = new int[3];
        convertedTime[0] = timeBeforeMeetingInSeconds / 3600;
        convertedTime[1] = (timeBeforeMeetingInSeconds % 3600) / 60;
        convertedTime[2] = timeBeforeMeetingInSeconds % 60;

        return convertedTime;
    }
}