class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        mp1 = {}
        mp2 = {}
        words = str.split(' ')
        if len(words)!=len(pattern):
            return False
        for word, ch in zip(words, pattern):
            if word not in mp1 and ch not in mp2:
                mp1[word] = ch
                mp2[ch] = word
            elif mp1.get(word) == ch and mp2.get(ch) == word:
                pass
            else:
                return False
        
        return True
