class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        Rows = len(grid)
        Cols = len(grid[0])
        dx = [-1,0,1]
 
        @lru_cache(None)
        def go(row, a, b):
            if row == Rows:
                return 0
 
            best = 0
            if a == b:
                cost = grid[row][a]
            else:
                cost = grid[row][a] + grid[row][b]
 
            for da in dx:
                for db in dx:
                    na = a + da
                    nb = b + db
 
                    na,nb = min(na,nb),max(na,nb)
                    if 0 <= na < Cols and 0 <= nb < Cols:
                        best = max(go(row + 1, na, nb) + cost, best)
 
            return best
 
        return go(0, 0, Cols - 1)
