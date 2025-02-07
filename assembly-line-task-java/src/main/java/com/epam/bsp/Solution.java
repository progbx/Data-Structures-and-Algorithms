package com.epam.bsp;

import org.javatuples.Pair;

public class Solution {
    public static Pair<Integer, Integer[]> solveAlsProblem(
            Pair<Integer, Integer> startCosts,
            Pair<Integer[], Integer[]> stationCosts,
            Pair<Integer[], Integer[]> transferCosts,
            Pair<Integer, Integer> finishCosts
    ) {
        Integer[] firstLineStations = stationCosts.getValue0();
        Integer[] secondLineStations = stationCosts.getValue1();
        int k = firstLineStations.length;
        Integer[] firstLineTransfers = transferCosts.getValue0();
        Integer[] secondLineTransfers = transferCosts.getValue1();
        int[] firstLineTime = new int[k];
        int[] secondLineTime = new int[k];
        firstLineTime[0] = startCosts.getValue0() + firstLineStations[0];
        secondLineTime[0] = startCosts.getValue1() + secondLineStations[0];
        for (int i = 1; i < k; i++) {
            firstLineTime[i] = Math.min(
                    firstLineTime[i - 1] + firstLineStations[i],
                    secondLineTime[i - 1] + secondLineTransfers[i - 1] + firstLineStations[i]);
            secondLineTime[i] = Math.min(
                    secondLineTime[i - 1] + secondLineStations[i],
                    firstLineTime[i - 1] + firstLineTransfers[i - 1] + secondLineStations[i]);
        }
        int totalTime = Math.min(
                firstLineTime[k - 1] + finishCosts.getValue0(),
                secondLineTime[k - 1] + finishCosts.getValue1());

        Integer[] optimalLineIndices = new Integer[k];
        int lineIndex = (firstLineTime[k - 1] + finishCosts.getValue0()) < (secondLineTime[k - 1]
                + finishCosts.getValue1()) ? 1 : 2;
        for (int i = k - 1; i >= 1; i--) {
            optimalLineIndices[i] = lineIndex;
            if (lineIndex == 1) {
                lineIndex = (firstLineTime[i - 1] + firstLineStations[i]) < (secondLineTime[i - 1]
                        + secondLineTransfers[i - 1] + firstLineStations[i]) ? 1 : 2;
            } else {
                lineIndex = (secondLineTime[i - 1] + secondLineStations[i]) < (firstLineTime[i - 1]
                        + firstLineTransfers[i - 1] + secondLineStations[i]) ? 2 : 1;
            }
        }
        optimalLineIndices[0] = lineIndex;
        return new Pair<>(totalTime, optimalLineIndices);
    }
}