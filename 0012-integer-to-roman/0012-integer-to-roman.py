class Solution:
    def intToRoman(self, num: int) -> str:
        romans = ['I','V','X','L','C','D','M']
        str = ''
        rest = 0
        index = 0
        while num != 0:
            rest = int(num % 10)
            if rest < 5:
                if rest == 4:
                    str = romans[index] + romans[index +1] + str
                else:
                    str = (rest * romans[index]) + str
            else:
                if rest == 9:
                    str = romans[index] + romans[index +2] + str
                else:
                    str = romans[index+1] + ((rest - 5) * romans[index]) + str
            index = index + 2
            num = int(num / 10)
        return str
            
            
                    