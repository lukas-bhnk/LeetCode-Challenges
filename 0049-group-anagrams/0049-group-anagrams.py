class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        arr = []
        res = []
        for s in strs:
            inserted = False
            a = list(s)
            a.sort()
            for i in range(len(arr)):
                if a == arr[i]:
                    res[i].append(s)
                    inserted = True

            if inserted != True:
                arr.append(a)
                res.append([s])

        return res
                
                