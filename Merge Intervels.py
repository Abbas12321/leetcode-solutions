class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        '''
        Detailed graphical explanation:
        https://medium.com/@edward.zhou/leet-code-56-merge-intervals-explained-python3-solution-89b3297e81a1
        I can compare each one of intervals against the other, it will be
        a n to n comparison and make the complexity O(n^2).
        
        If intervals are ordered by start times (complexity is O(nlogn)), 
        then I just need to compare the two contious internals which is a
        O(n) work. Total complexity will be O(nlogn + n) = O(nlogn)
        '''
        intervals = sorted(intervals, key=lambda x:x[0])
        ret = []
        for i in intervals:
            newInterval = i
            #compare with the last one in ret
            if ret:
                if ret[-1][1] >= i[0]: 
                    #merge and then replace the last one in ret
                    newInterval = ret.pop()
                    if i[1] > newInterval[1]:
                        newInterval[1] = i[1]      
            ret.append(newInterval)
        return ret
