/*

Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.

Answers within 10-5 of the actual value will be accepted as correct.


Initialize the constants: one_min_angle = 6, one_hour_angle = 30.

The angle between minute hand and 0-minutes vertical line is minutes_angle = one_min_angle * minutes.

The angle between hour hand and 12-hour vertical line is hour_angle = (hour % 12 + minutes / 60) * one_hour_angle.

Find the difference: diff = abs(hour_angle - minutes_angle).

Return the smallest angle: min(diff, 360 - diff)

*/


class Solution {
    public double angleClock(int hour, int minutes) {
        
        int min_degree = 6;
        
        int hour_degree = 30;
        
        int minute_ang = min_degree * minutes;
        
        double hour_ang = (hour % 12 + minutes /60.0) * 30;
        
        double diff = Math.abs(minute_ang- hour_ang);
        
        
        return Math.min(diff, 360- diff);
    }
}
