class Solution(object):
    def minimumAbsDifference(self, arr):
        """
        :type arr: List[int]
        :rtype: List[List[int]]
        """
        arr.sort()
        m = float('inf')
        for i in range(len(arr) - 1):
            if arr[i+1] - arr[i] < m:
                m = arr[i+1] - arr[i]
        
        res = []
        for i in range(len(arr) - 1):
            if arr[i+1] - arr[i] == m:
                res.append((arr[i], arr[i+1]))
        return res
    
