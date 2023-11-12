// 1. Contains duplicate - Given an array of numbers, return true if any value appears at least twice in the array and otherwise eg nums = [1,2,3,1] - true

// const containsDuplicate = (arr) => {
//   const nums = new Set([...arr]);
//   return nums.size !== arr.length;
// };

// console.log(containsDuplicate([1, 2, 3, 4]));

// const containsDuplicate = (arr) => {
//   if (arr.length <= 1) {
//     return false;
//   }
//   const obj = {};
//   for (let num of arr) {
//     if (obj[num]) return true;
//     obj[num] = true;
//   }
//   return false;
// };

// console.log(containsDuplicate([1, 2, 3, 4]));

// 2. Given two strings s and t, return true if t is an anagram of s and otherwise. An Anagram is a word or phrase formed by rearranging the letters of a dfferent word or phrase eg: s = "anagram", t = "nagaram" -> true

// const validAnagram = (s, t) => {
//   if (s.length !== t.length) return false;
//   return s.split('').sort().join('') === t.split('').sort().join('');
// };

// console.log(validAnagram('anagram', 'nagaram'));

// 3. Two sum problem - Given an arr of integers nums and an integer target, return indices of the two numbers such that they add up to target eg: nums = [2,7,11,15], target = 9 -> output = [0,1]

// const twoSum = (nums, t) => {
//   for (let i = 0; i < nums.length; i++) {
//     for (let j = i + 1; j < nums.length; j++) {
//       if (nums[i] + nums[j] === t) {
//         return [i, j];
//       }
//     }
//   }
// };

// console.log(twoSum([3, 3, 8, 2], 10));

// 4. Given an array of strings, group the anagrams together. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase. eg:["eat", "tan", "ate", "nat", "bat"] -> [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

// const groupAnagram = (strs) => {
//   if (strs.length === 1) return [strs];
//   let obj = {};
//   for (let s = 0; s < strs.length; s++) {
//     let sorted = strs[s].split('').sort().join('');

//     if (!obj[sorted]) {
//       obj[sorted] = [strs[s]];
//     } else {
//       obj[sorted].push(strs[s]);
//     }
//   }
//   return Object.values(obj);
// };

// console.log(groupAnagram(['eat', 'tan', 'ate', 'nat', 'bat', 'tea']));

// 5. Given an integer arr of nums and an int k, return the k most frequent elements. eg: nums = [1,1,1,2,2,3], k = 2 -> [1,2]

// const topFrequent = (nums, k) => {
//   let answer = nums.reduce((acc, curr) => {
//     if (acc[curr]) {
//       acc[curr]++;
//     } else {
//       acc[curr] = 1;
//     }
//     return acc;
//   }, {});

//   const arr = Object.entries(answer);
//   arr.sort((a, b) => b[1] - a[1]);
//   let ans = [];
//   for (let i = 0; i < k; i++) {
//     ans.push(Number(arr[i][0]));
//   }
//   return ans;
// };

// console.log(topFrequent([1, 1, 1, 2, 2, 2, 3, 4, 4], 3));

//6: Given an int of nums, return an array ans such that ans[i] is equal to the product of all the elements of nums execpt nums[i]
// function productExceptSelf(nums) {
//   const length = nums.length;

//   // Initialize arrays to store left and right products
//   const leftProducts = Array(length).fill(1);
//   const rightProducts = Array(length).fill(1);

//   // Calculate left products
//   for (let i = 1; i < length; i++) {
//     leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
//   }

//   // Calculate right products
//   for (let i = length - 2; i >= 0; i--) {
//     rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
//   }

//   // Calculate the final result array
//   const ans = Array(length)
//     .fill(0)
//     .map((_, i) => leftProducts[i] * rightProducts[i]);

//   return ans;
// }

// // Example usage
// const nums = [1, 2, 3, 4];
// const result = productExceptSelf(nums);

// // Print the result array
// console.log(result);

// 7: Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules: 1. Each row must contain the digits 1-9 without repetition. 2: Each column must contain the digits 1-9 without repetition. 3: Each of the nine 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition

// const isValidSudoku = (board) => {
//   const isValidGroup = (group) => {
//     let seen = new Set();
//     for (let c of group) {
//       if (c !== '.') {
//         if (seen.has(c)) {
//           return false;
//         }
//         seen.add(c);
//       }
//     }
//     return true;
//   };

//   //check rows
//   for (let i = 0; i < 9; i++) {
//     if (!isValidGroup(board[i])) {
//       return false;
//     }
//   }

//   //check column
//   for (let i = 0; i < 9; i++) {
//     let column = [];
//     for (let j = 0; j < 9; j++) {
//       column.push(board[i][j]);
//     }
//     if (!isValidGroup(column)) {
//       return false;
//     }
//   }

//   for (let i = 0; i < 9; i += 3) {
//     for (let j = 0; j < 9; j += 3) {
//       let subbox = [];
//       for (let x = i; x < i + 3; x++) {
//         for (let y = j; y < j + 3; y++) {
//           subbox.push(board[x][y]);
//         }
//       }
//       if (!isValidGroup(subbox)) {
//         return false;
//       }
//     }
//   }
//   return true;
// };
// let arr = [
//   ['5', '3', '.', '.', '7', '.', '.', '.', '.'],
//   ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
//   ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
//   ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
//   ['4', '.', '.', '8', '.', '3', '.', '.', '1'],
//   ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
//   ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
//   ['.', '.', '.', '4', '1', '9', '.', '.', '5'],
//   ['.', '.', '.', '.', '8', '.', '.', '7', '9'],
// ];

// console.log(isValidSudoku(arr));

// 8. Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence eg: nums = [100,4,200,1,3,2] -> 4

// const longestConsecutiveElement = (nums) => {
//   if (nums.length === 0 || !nums) return 0;

//   const numSet = new Set(nums);

//   let maxLength = 0;
//   for (let num of nums) {
//     if (!numSet.has(num - 1)) {
//       let currentNum = num;
//       let currentStreak = 1;

//       while (numSet.has(currentNum + 1)) {
//         currentNum++;
//         currentStreak++;
//       }
//       maxLength = Math.max(currentNum, currentStreak);
//     }
//   }
//   return maxLength;
// };

// const arr = [100, 4, 200, 1, 3, 2];
// console.log(longestConsecutiveElement(arr));
// 9: Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings

// const encode = (strs) => {
//   const DELIMITER = '%';
//   let strings = '';

//   for (let s of strs) {
//     let encoderStr = s.replace(DELIMITER, '\\' + DELIMITER);
//     strings += encoderStr + DELIMITER;
//   }
//   return strings;
// };

// const decode = (str) => {
//   const DELIMITER = '%';

//   let decodedStr = [];
//   let econdedArr = str.split(DELIMITER);
//   for (let s of econdedArr) {
//     let encodeStr = s.replace('\\' + DELIMITER, DELIMITER);
//     decodedStr.push(encodeStr);
//   }
//   return decodedStr;
// };

// const arr = ['Hello', 'World'];
// let ans = encode(arr);
// console.log(decode(ans));

// 10: Given a string s, return true if is a palindrome, or false otherwise eg: "A man, a plan, a canal:panama"

const palindrome = (str) => {
  let cleanedStr = str.replaceAll('[^A-Za-z0-9]', '').toLowerCase();

  let start = 0;
  let end = cleanedStr.length - 1;

  while (start < end) {
    if (cleanedStr.charAt(start) !== cleanedStr.charAt(end)) {
      return false;
    }
    start++;
    end--;
  }
  return true;
};

const inputStr = 'A man, a plan, a canal: Panama';
const result = palindrome(inputStr);
console.log(result);
