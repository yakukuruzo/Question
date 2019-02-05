package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by levin on 3/17/17.
 */

public class YelpCodingChallenge {


    public static String getMostDesiredRestaurant(List<String> restList1, List<String> restList2) {
        if (restList1 == null || restList1.isEmpty() ||
                restList2 == null || restList2.isEmpty()) {
            return "Yelpwich";
        }

        int minRank = Integer.MAX_VALUE;
        int restIndex = -1;

        for (int i = 0; i < restList1.size(); i++) {
            for (int j = 0; j < restList2.size(); j++) {

                if (restList1.get(i).equals(restList2.get(j))) {
                    int currentRate = (i + 1) + (j + 1);
                    if (currentRate < minRank) {
                        minRank = currentRate;
                        restIndex = i;
                    }
                }
            }
        }

        return restIndex != -1 ? restList1.get(restIndex) : "Yelpwich";

    }

    public static String getMostDesiredRestaurantHashMap(List<String> restList1, List<String> restList2) {
        if (restList1 == null || restList1.isEmpty() ||
                restList2 == null || restList2.isEmpty()) {
            return "Yelpwich";
        }

        HashMap<String, Integer> rest2Map = new HashMap<>();
        for (int i = 0; i < restList2.size(); i++) {
            rest2Map.put(restList2.get(i), i);
        }

        int minRank = Integer.MAX_VALUE;
        int restIndex = -1;

        for (int i = 0; i < restList1.size(); i++) {
            String currRest = restList1.get(i);
            if (rest2Map.containsKey(currRest)) {
                int currentRate = (i + 1) + (rest2Map.get(currRest) + 1);
                if (currentRate < minRank) {
                    minRank = currentRate;
                    restIndex = i;
                }
            }
        }

        return restIndex != -1 ? restList1.get(restIndex) : "Yelpwich";

    }

    public static void sortedRatedRestaurantsTop(List<String> rests, List<Integer> ratings) {
        TreeMap<Integer, String> restMap = new TreeMap<>();

        for (int i = 0; i < rests.size(); i++) {
            restMap.put(ratings.get(i), rests.get(i));
        }

        Set<Map.Entry<Integer, String>> entrySet=  restMap.descendingMap().entrySet();

        Iterator iter = entrySet.iterator();

        while(iter.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iter.next();

            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }

    public static void mostFrequentColor(List<List<String>> listOfColorList) {
        ArrayList<String> colorList = new ArrayList<>();
        if (listOfColorList == null || listOfColorList.size() == 0) {
            System.out.println("No entries");
        }

        TreeMap<String, Integer> colorMap = new TreeMap<>();

        int maxNumber = -1;

        for (List<String> colors : listOfColorList) {
            if (colors == null || colors.size() == 0) {
                continue;
            }

            for (String color : colors) {
                if (!colorMap.containsKey(color)) {
                    colorMap.put(color, 1);
                } else {
                    int currentMax = colorMap.get(color) + 1;
                    colorMap.put(color, currentMax);
                    if (currentMax > maxNumber) {
                        maxNumber = currentMax;
                    }
                }
            }
        }

        for (String color : colorMap.keySet()) {
            if (colorMap.get(color) == maxNumber) {
                colorList.add(color);
                System.out.print(color + " ");
            }
        }
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if (intervals == null || intervals.isEmpty()) {
            return result;
        }

        Collections.sort(intervals, (interval1, interval2) -> {
            if (interval1.start != interval2.start) {
                return interval1.start - interval2.start;
            } else {
                return interval1.end - interval2.end;
            }
        });

        Interval prev = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);

            if(curr.start > prev.end) {
                result.add(prev);
                prev = curr;
            } else {
                Interval merged = new Interval(prev.start, curr.end);
                prev = merged;
            }
        }

        result.add(prev);
        return result;
    }

    public static int mergeIntervalsConstantMemory(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if (intervals == null || intervals.isEmpty()) {
            return -1;
        }

        Collections.sort(intervals, (interval1, interval2) -> interval2.start - interval1.start);

        int index = 0;
        for (int i = 0; i < intervals.size(); i++) {

            if (index != 0) {
                Interval prev = intervals.get(index - 1);
                Interval curr = intervals.get(i);
                if (prev.start <= curr.end) {
                    while (index != 0 && prev.start <= curr.end) {

                        prev = intervals.get(index - 1);
                        prev.end = Math.max(prev.end, curr.end);
                        prev.start = Math.min(prev.start, curr.start);
                        index--;
                    }
                } else {
                    intervals.set(index, intervals.get(i));
                }
            } else {
                intervals.set(index, intervals.get(i));
            }

            index++;
        }

        return index;
    }

     public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

}
