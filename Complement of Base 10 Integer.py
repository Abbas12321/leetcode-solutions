class Solution:
    def bitwiseComplement(self, N: int) -> int:
        
        binary_n = bin(N)

        result = ""
        for c in binary_n[2:]:
            if c == '0':
                result += '1'
            else:
                result += '0'
                
        
        return int(result, 2)
