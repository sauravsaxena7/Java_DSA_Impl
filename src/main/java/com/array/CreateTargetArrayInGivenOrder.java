package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 *
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 *
 * It is guaranteed that the insertion operations will be valid.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 * Example 2:
 *
 * Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * Output: [0,1,2,3,4]
 * Explanation:
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 * Example 3:
 *
 * Input: nums = [1], index = [0]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length, index.length <= 100
 * nums.length == index.length
 * 0 <= nums[i] <= 100
 * 0 <= index[i] <= i
 *
 */



class Vehicle{
    public Integer getNumberOfWheels(){
        return 2;
    }


}

class EngineVehicle extends Vehicle{
    public Boolean hasEngine(){
        return true;
    }

}

class MotorCycle extends EngineVehicle{

    @Override
    public Boolean hasEngine() {
        return super.hasEngine();
    }
}

class Car extends EngineVehicle{

    @Override
    public Integer getNumberOfWheels() {
        return 4;
    }

}

class BiCycle extends Vehicle{
}



public class CreateTargetArrayInGivenOrder {

    public int[] createTargetArray(int[] nums, int[] index) {

        int[] target = new int[index.length];
        for(int i=0;i<index.length;i++){
            target[i]=-1;
        }

        for(int i=0;i<index.length;i++){

            if(target[index[i]]==-1){
                target[index[i]]=nums[i];
            }else{
                int value = nums[i];
                int j=index[i];
                while(j<index.length){
                    int temp = target[j];
                    target[j]=value;
                    value=temp;
                    j++;
                }
            }
        }


        return target;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read input line
        String line = br.readLine();  // e.g., "10 20 30 40"

        // Split and parse into int array
        int[] nums = Arrays.stream(line.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        line = br.readLine();
        int[] index = Arrays.stream(line.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        //System.out.println(Arrays.toString(new CreateTargetArrayInGivenOrder().createTargetArray(nums, index)));

        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new MotorCycle());
        vehicleList.add(new Car());

        for(Vehicle vehicle: vehicleList){
            System.out.println(vehicle.getNumberOfWheels());
        }
    }
}
