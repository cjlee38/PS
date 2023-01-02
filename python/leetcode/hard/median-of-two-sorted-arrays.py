from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        merged = []
        i, j = 0, 0
        m = len(nums1)
        n = len(nums2)
        while i < m and j < n:
            if nums1[i] > nums2[j]:
                merged.append(nums2[j])
                j += 1
            elif nums1[i] < nums2[j]:
                merged.append(nums1[i])
                i += 1
            else:
                merged.append(nums1[i])
                merged.append(nums2[j])
                i += 1
                j += 1
        if i < m:
            merged.extend(nums1[i:])
        else:
            merged.extend(nums2[j:])
        if len(merged) % 2 == 0:
            return (merged[(len(merged)//2) - 1] + merged[len(merged)//2]) / 2
        return merged[(len(merged)//2)]

print(Solution().findMedianSortedArrays([0,0,0,0,0], [-1,0,0,0,0,0,1]))
print(Solution().findMedianSortedArrays([1,3], [2]))
print(Solution().findMedianSortedArrays([1,2], [3,4]))