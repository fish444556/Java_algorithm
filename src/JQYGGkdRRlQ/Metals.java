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
    	
    	int cost_per_cut1 = 100;
    	int metal_price1 = 10;
    	int[] lengths1 = {26, 103, 59};
    	
    	int cost_per_cut2 = 200;
    	int metal_price2 = 10;
    	int[] lengths2 = {25,50,75,100,125,150,175,200};    	
    	
    	int cost_per_cut3 = 25;
    	int metal_price3 = 10;
    	int[] lengths3 = {31,73,127,179,181,191,283,353,359,1019};
    	
    	int cost_per_cut4 = 5;
    	int metal_price4 = 10;
    	int[] lengths4 = {25,50,75,100,125,150,175};
    	
    	int cost_per_cut5 = 25;
    	int metal_price5 = 1;
    	int[] lengths5 = {20,40,21,20,20,20,20,20,20};
    	
    	int cost_per_cut6 = 1000;
    	int metal_price6 = 1;
    	int[] lengths6 = {200,200,200,400,200,200,200,200,200,200,200};
    	
    	int cost_per_cut7 = 131;
    	int metal_price7 = 10;
    	int[] lengths7 = {13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,169};
    	
    	int cost_per_cut8 = 120;
    	int metal_price8 = 10;
    	int[] lengths8 = {10,10,10,10,10,10,10,10,100,10,10,10,10,10,10,10,10,10,10,10,10,10};
    	
    	int cost_per_cut9 = 552;
    	int metal_price9 = 581;
    	int[] lengths9 = { 2763,4724,2143,8933,3695,2511,2560,5726,8115,1732,5125,1767,355,7881,233,4654,8991,76,9157,3580,2465,4900,8354,3541,9964,9544,9454,9644,8705,1279,3633,8092,6840,9464,4384,709,7117,2651,9889,2100,4201,7790,2224,9350,5427,541,6737,8606,3414,8132};
    	
    	int cost_per_cut10 = 498;
    	int metal_price10 = 297;
    	int[] lengths10 = {149,3983,902,1953,7292,6404,5028,9786,7240,9071,6485,9912,1834,2206,5446,5825,5560,8766,8938,7762,7381,9206,8868,5467,179,7250,2899,2000,3637,1939,3237,846,6793,9621,9445,5387,1158,1617,4407,848,8771,7828,423,1611,9032,9424,6876,2304,6985,7937};
    	
    	int cost_per_cut11 = 1000;
    	int metal_price11 = 1;
    	int[] lengths11 = {10, 10, 11};
    	
        System.out.println(calculateMaximumProfit(cost_per_cut, metal_price, lengths) == 1770);
//        System.out.println(calculateMaximumProfit2(cost_per_cut, metal_price, lengths) == 1770);
    	System.out.println(calculateMaximumProfit(cost_per_cut1, metal_price1, lengths1) == 1230);
    	System.out.println(calculateMaximumProfit(cost_per_cut2, metal_price2, lengths2) == 5600);
        System.out.println(calculateMaximumProfit(cost_per_cut3, metal_price3, lengths3) == 25145);
        System.out.println(calculateMaximumProfit(cost_per_cut4, metal_price4, lengths4) == 6895);
        System.out.println(calculateMaximumProfit(cost_per_cut5, metal_price5, lengths5) == 155);
        System.out.println(calculateMaximumProfit(cost_per_cut6, metal_price6, lengths6) == 2000);
        System.out.println(calculateMaximumProfit(cost_per_cut7, metal_price7, lengths7) == 5318);
        System.out.println(calculateMaximumProfit(cost_per_cut8, metal_price8, lengths8) == 2100);
        System.out.println(calculateMaximumProfit(cost_per_cut9, metal_price9, lengths9) == 150693498);
//        System.out.println(calculateMaximumProfit2(cost_per_cut3, metal_price3, lengths3) == 25145);
        System.out.println(calculateMaximumProfit(cost_per_cut10, metal_price10, lengths10) ==  77792388);
//        System.out.println(calculateMaximumProfit2(cost_per_cut10, metal_price10, lengths10) == 77792388);
        System.out.println(calculateMaximumProfit(cost_per_cut11, metal_price11, lengths11) == 20);
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
            	if ((length / curLength) * curLength * metal_price - 
            			(length - 1) / curLength * cost_per_cut >= 0) {
            		totalRods += (length / curLength);
                    totalCuts += ((length - 1) / curLength);
            	}
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