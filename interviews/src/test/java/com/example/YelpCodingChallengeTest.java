package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.example.YelpCodingChallenge.*;

/**
 * Created by levin on 3/17/17.
 */
public class YelpCodingChallengeTest {
    @Test
    public void testMergeIntervalsConstantMemory() throws Exception {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        int index = mergeIntervalsConstantMemory(intervals);
        for (int i = 0; i < index; i++)  {
            System.out.print( "{" + intervals.get(i).start + ", " +  intervals.get(i).end + "} ");
        }
    }

    @Test
    public void testMergeIntervals() throws Exception {

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        List<Interval> result = mergeIntervals(intervals);
        for (Interval interval : result) {
            System.out.print( "{" + interval.start + ", " + interval.end + "} ");
        }
    }

    @Test
    public void testMostFrequentColor() throws Exception {

        List<List<String>> listOfColorLists = new ArrayList<>();

        List<String> row1 = new ArrayList<>(Arrays.asList("angular", "green", "blue"));
        List<String> row2 = new ArrayList<>(Arrays.asList("angular", "green", "cyan"));
        List<String> row3 = new ArrayList<>(Arrays.asList("blue", "yellow", "angular"));
        List<String> row4 = new ArrayList<>(Arrays.asList("blue", "green", "angular"));

        listOfColorLists.add(row1);
        listOfColorLists.add(row2);
        listOfColorLists.add(row3);
        listOfColorLists.add(row4);

        mostFrequentColor(listOfColorLists);
    }

    @Test
    public void testSortedRatedRestaurantsTop() throws Exception {
        List<String> rests = new ArrayList<>(Arrays.asList("a","b","c", "d"));
        List<Integer> ratings = new ArrayList<>(Arrays.asList(5, 4, 1, 8));

        sortedRatedRestaurantsTop(rests, ratings);
    }

    @Test
    public void testGetMostDesiredRestaurantHashMap() throws Exception {
        List<String> rest1 = new ArrayList<>(Arrays.asList("a","b","c", "d"));
        List<String> rest2 = new ArrayList<>(Arrays.asList("c","b","d", "a"));
        System.out.println(getMostDesiredRestaurantHashMap(rest1, rest2));


        List<String> rest3 = new ArrayList<>(Arrays.asList("a","b","c", "d"));
        List<String> rest4 = new ArrayList<>(Arrays.asList("d","c","b", "a"));
        System.out.println(getMostDesiredRestaurantHashMap(rest3, rest4));
    }

    @Test
    public void testGetMostDesiredRestaurant() throws Exception {

        List<String> rest1 = new ArrayList<>(Arrays.asList("a","b","c", "d"));
        List<String> rest2 = new ArrayList<>(Arrays.asList("c","b","d", "a"));
        System.out.println(getMostDesiredRestaurant(rest1, rest2));


        List<String> rest3 = new ArrayList<>(Arrays.asList("a","b","c", "d"));
        List<String> rest4 = new ArrayList<>(Arrays.asList("d","c","b", "a"));
        System.out.println(getMostDesiredRestaurant(rest3, rest4));
    }

}