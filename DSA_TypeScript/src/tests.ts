import { strict as assert } from 'assert';
import { twoSum } from './TwoSum';
// 1. Two Sum Problem
testTwoSum();
function testTwoSum() {
    assert.deepEqual(twoSum([2, 7, 11, 15], 9), [0, 1]);
    assert.deepEqual(twoSum([3, 2, 4], 6), [1, 2]);
    assert.deepEqual(twoSum([3, 3], 6), [0, 1]);
    console.log("Two Sum tests passed!");
}

// 2. Valid Parentheses
testIsValidParentheses();
function testIsValidParentheses() {
    assert.equal(isValidParentheses("()"), true);
    assert.equal(isValidParentheses("()[]{}"), true);
    assert.equal(isValidParentheses("(]"), false);
    console.log("Valid Parentheses tests passed!");
}

// 3. Merge Intervals
testMergeIntervals();
function testMergeIntervals() {
    assert.deepEqual(mergeIntervals([[1,3],[2,6],[8,10],[15,18]]), [[1,6],[8,10],[15,18]]);
    assert.deepEqual(mergeIntervals([[1,4],[4,5]]), [[1,5]]);
    console.log("Merge Intervals tests passed!");
}

// 4. Group Anagrams
testGroupAnagrams();
function testGroupAnagrams() {
    assert.deepEqual(groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]), [["eat","tea","ate"],["tan","nat"],["bat"]]);
    console.log("Group Anagrams tests passed!");
}

// 5. Longest Substring Without Repeating Characters
testLengthOfLongestSubstring();
function testLengthOfLongestSubstring() {
    assert.equal(lengthOfLongestSubstring("abcabcbb"), 3);
    assert.equal(lengthOfLongestSubstring("bbbbb"), 1);
    console.log("Longest Substring Without Repeating Characters tests passed!");
}

// 6. Rotate Image
testRotateImage();
function testRotateImage() {
    let matrix = [[1,2,3],[4,5,6],[7,8,9]];
    rotateImage(matrix);
    assert.deepEqual(matrix, [[7,4,1],[8,5,2],[9,6,3]]);
    console.log("Rotate Image tests passed!");
}

// More test cases for remaining problems...

console.log("All test cases passed successfully!");
```
