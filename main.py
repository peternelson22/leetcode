from typing import List
# 1. Contains duplicate - Given an array of numbers, return true if any value appears at least twice in the array and otherwise eg nums = [1,2,3,1] - true

# class ContainsDuplicate:
#     def isDuplicate(self, nums: list[int]) -> bool:
#         return len(set(nums)) != len(nums)

# ans = ContainsDuplicate()
# print(ans.isDuplicate([1,2,3,4]))

# 2. Given two strings s and t, return true if t is an anagram of s and otherwise. An Anagram is a word or phrase formed by rearranging the letters of a dfferent word or phrase eg: s = "anagram", t = "nagaram" -> true
# 1st silution
# class Anagram:
#     def isAnagram(self, s: str, t: str) -> bool:
#         if len(s) != len(t):
#             return False
#         for i in s:
#             if i in t:
#                 return True
#         return False

# ans = Anagram()
# print(ans.isAnagram('anagram', 'nagara'))

# second solution

# def isAnagram(s:str, t:str)->bool:
#     return sorted(s) == sorted(t) 

# print(isAnagram('anagram', 'nagaram'))

# 3. Two sum problem - Given an arr of integers nums and an integer target, return indices of the two numbers such that they add up to target eg: nums = [2,7,11,15], target = 9 -> output = [0,1]

# def two_sum(nums: list[int], t: int) -> list[int]:
#     for i in range(len(nums)):
#         for v in range(i+1, len(nums)):
#             if nums[i] + nums[v] == t:
#                 return [i, v] 

# ans = two_sum([3,2,4,8], 12)
# print(ans)

# 4. Given an array of strings, group the anagrams together. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase. eg:["eat", "tan", "ate", "nat", "bat", "tea"] -> [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

# def groupAnagram(strs: list[str]) -> list[list[str]]:
#     obj = {}
#     for i in strs:
#         temp = sorted(list(i))
#         if tuple(temp) not in obj:
#             obj[tuple(temp)] = [i]
#         else:
#             obj[tuple(temp)].append(i)

#     result = []
#     for i in obj.values():
#         result.append(i)
#     return result

# ans = groupAnagram(["eat", "tan", "ate", "nat", "bat", "tea"])   
# print(ans) 

# 5. Given an integer arr of nums and an int k, return the k most frequent elements. eg: nums = [1,1,1,2,2,3], k = 2 -> [1,2]

# def topFrequent(nums:list[int], k: int) -> list[int]:
#     obj = {}
#     for i in nums:
#         if i in obj:
#             obj[i] += 1
#         else:
#             obj[i] = 1
#     result = []
#     for i in range(k):
#         max_val = max(obj.values())
#         for v in obj:
#             if obj[v] == max_val:
#                 result.append(v)
#                 obj[v] = -1
#                 break
#     return result


# ans = topFrequent([1,1,1,2,2,3], 2)
# print(ans)

# 6. Given an int of nums, return an array ans such that ans[i] is equal to the product of all the elements of nums execpt nums[i] 
# class ProductArrExceptSelf:
#     def productArr(self, nums:list[int]) -> list[int]:
#         result = [1] * len(nums)
#         for i in range(1, len(nums)):
#             result[i] *= nums[i-1] * result[i-1]
#         right_product = 1
#         for i in range(len(nums) - 2, -1, -1):
#             right_product *= nums[i+1]
#             result[i] *= right_product
#         return result


# ans = ProductArrExceptSelf()
# print(ans.productArr([1,2,3,4]))

# def product_except_self(nums):
#     length = len(nums)

#     # Initialize arrays to store left and right products
#     left_products = [1] * length
#     right_products = [1] * length

#     # Calculate left products
#     for i in range(1, length):
#         left_products[i] = left_products[i - 1] * nums[i - 1]

#     # Calculate right products
#     for i in range(length - 2, -1, -1):
#         right_products[i] = right_products[i + 1] * nums[i + 1]

#     # Calculate the final result array
#     ans = [left_products[i] * right_products[i] for i in range(length)]

#     return ans

# # Example usage
# nums = [1, 2, 3, 4]
# result = product_except_self(nums)

# # Print the result array
# print(result)


# 7: Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules: 1. Each row must contain the digits 1-9 without repetition. 2: Each column must contain the digits 1-9 without repetition. 3: Each of the nine 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition

# def valid_sudoku(board: List[List[str]]) -> bool:
#     # check rows
#     for row in board:
#         if not is_valid(row):
#             return False

#     # check column
#     for r in range(9):
#         column = []
#         for c in range(9):
#             column = board[r][c]
#         if not is_valid(column):
#             return False

#     for i in range(0, 9, 3):
#         for j in range(0, 9, 3):
#             subbox = []
#             index = 0
#             for x in range(i, i+3):
#                 for y in range(j, j+3):
#                     subbox = board[x][y]
#                 if not is_valid(subbox):
#                     return False

#     return True


# def is_valid(group: List[str]) -> bool:
#     seen = set()
#     for c in group:
#         if c != '.':
#             if c in seen:
#                 return False
#             seen.add(c)
    
#     return True

# sudoku_board = [
#     ["5","3",".",".","7",".",".",".","."],
#     ["6",".",".","1","9","5",".",".","."],
#     [".","9","8",".",".",".",".","6","."],
#     ["8",".",".",".","6",".",".",".","3"],
#     ["4",".",".","8",".","3",".",".","1"],
#     ["7",".",".",".","2",".",".",".","6"],
#     [".","6",".",".",".",".","2","8","."],
#     [".",".",".","4","1","9",".",".","5"],
#     [".",".",".",".","8",".",".","7","9"]
# ]

# result = valid_sudoku(sudoku_board)
# print(result)


# 8. Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence eg: nums = [100,4,200,1,3,2] -> 4

# def longest_consecutive_element(nums: List[int]) -> int:
#     if not nums:
#         return 0

#     nums_set = set(nums)

#     max_length = 0
#     for num in range(len(nums)):
#         if num-1 not in nums_set:
#             current_num = num
#             current_streak = 1
#             while(current_num+1 in nums_set):
#                 current_num += 1
#                 current_streak += 1

#             max_length = max(current_num, current_streak) 
#     return max_length

# ans = longest_consecutive_element([100,4,200,1,3,2])
# print(ans)

# 9: Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings

# def encode(strs: List[str]) -> str:
#     DELIMITER = "%"
#     outputStr = ""
#     for s in strs:
#         ecodedStr = s.replace(DELIMITER, "\\" + DELIMITER)
#         outputStr += ecodedStr + DELIMITER

#     return outputStr

# def decode(string: str) -> List[str]:
#     DELIMITER = "%"
#     decodedStrs = []
#     ecodedStr = string.split(DELIMITER)

#     for s in ecodedStr:
#         decodedStr = s.replace("\\" + DELIMITER, DELIMITER)
#         decodedStrs.append(decodedStr)

#     return decodedStrs

# x = ["Hello","Hipp"]
# ecoded = encode(x)

# print(decode(ecoded))

# 10: Given a string s, return true if is a palindrome, or false otherwise eg: "A man, a plan, a canal:panama"

def palindrome(s: str) -> bool:
    cleanedStr = "".join(char.lower() for char in s if char.isalnum())
    start = 0
    end = len(cleanedStr) - 1

    while(start < end):
        if cleanedStr[start] != cleanedStr[end]:
            return False
        start += 1
        end -= 1

    return True

ans = "A man, a plan, a canal:panama"
print(palindrome(ans))
































