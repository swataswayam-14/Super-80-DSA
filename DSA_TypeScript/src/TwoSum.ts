// 1. Two Sum Problem
// Question:
// Given an array of integers nums and a target integer target, return the indices of the two numbers that add up to the target. Each input has exactly one solution, and you cannot use the same element twice. Implement an efficient solution

export function twoSum (nums: number[], target: number): number[] {
    const numMap = new Map<number, number>();

    for (let i =0; i< nums.length; i++) {
        const complement = target - nums[i];
        if (numMap.has(complement)) { //checking if the completement exists in the numMap (if yes then returning the array of indices of the values that add upto target)
            return [numMap.get(complement)!, i];
        } 
        numMap.set(nums[i], i);//storing the value along with its index
    }
    return [];
}