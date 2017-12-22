package JQYGGkdRRlQ;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//public class Solution {
//
//}



public class Metals {
	
	public void testing() {
		int cost_per_cut = 1;
    	int metal_price = 10;
    	int[] lengths = {26, 103, 59};
    	
    	
    	int cost_per_cut3 = 25;
    	int metal_price3 = 10;
    	int[] lengths3 = {31,73,127,179,181,191,283,353,359,1019}; 
    	
    	int cost_per_cut10 = 498;
    	int metal_price10 = 297;
    	int[] lengths10 = {149,3983,902,1953,7292,6404,5028,9786,7240,9071,6485,9912,1834,2206,5446,5825,5560,8766,8938,7762,7381,9206,8868,5467,179,7250,2899,2000,3637,1939,3237,846,6793,9621,9445,5387,1158,1617,4407,848,8771,7828,423,1611,9032,9424,6876,2304,6985,7937};
    	
        System.out.println(calculateMaximumProfit(cost_per_cut, metal_price, lengths) == 1770);
        System.out.println(calculateMaximumProfit2(cost_per_cut, metal_price, lengths) == 1770);
        System.out.println(calculateMaximumProfit(cost_per_cut3, metal_price3, lengths3) == 25145);
        System.out.println(calculateMaximumProfit2(cost_per_cut3, metal_price3, lengths3) == 25145);
        System.out.println(calculateMaximumProfit(cost_per_cut10, metal_price10, lengths10) ==  77792388);
        System.out.println(calculateMaximumProfit2(cost_per_cut10, metal_price10, lengths10) == 77792388);
	}


// Calculate maximum profit
    public static long calculateMaximumProfit(int cost_per_cut, int metal_price, int[] lengths) {

        long maxProfit = 0;
        long curProfit = 0;
        int maxLength = 0;
        int totalRods = 0;
        int totalCuts = 0;

    // Find out maximum length
        for (int curLength : lengths) {
            maxLength = Math.max(maxLength, curLength);
        }

    // For each of the possible rod lengths, calculate possible profit
        for (int curLength = 1; curLength < maxLength; curLength++) {

            totalRods = 0;
            totalCuts = 0;

        // Cut each of the rods into smaller rods of size curLength
        // Count total rods and total cuts
            for (int length : lengths) {

                totalRods += (length / curLength);
                totalCuts += ((length - 1) / curLength);

            }

        // Calculate current profit
            curProfit = totalRods * curLength * metal_price - totalCuts * cost_per_cut;

        // Calculate maximum profit
            maxProfit = Math.max(maxProfit, curProfit);
        }

        return maxProfit;
    }


    public static long calculateMaximumProfit2(int costpercut, int price, int[] arr) {
    	long maxProfit = 0;
    	int max = arr[0];
    	for(int i = 0 ; i < arr.length; i++)
            if(max < arr[i])
                max = arr[i];
            for(int size = 1 ; size <= max; size++) {
                int profit = 0;
                for(int i = 0 ; i < arr.length; i++) {
                    if(size > arr[i])
                        continue;
                    int currPrice = (arr[i] / size) * price * size; // current Rod price after cutting it.
                    int cuts = arr[i] % size == 0 ? (arr[i] / size) - 1 : (arr[i] / size); // Number of cuts depend on the length of rod.
                    int currProfit = currPrice - costpercut * cuts;
                    if(currProfit > 0)
                        profit += currProfit;
                }
                if(profit > maxProfit)
                    maxProfit = profit;
            }

//            System.out.println(maxProfit);
            return maxProfit;
        }

    }