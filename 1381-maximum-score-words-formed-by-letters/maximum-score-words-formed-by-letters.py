class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        return self.helper(words, 0, letters, score, alphabet)

    def helper(self, words, indWord, letters, score, alphabet):
        if indWord >= len(words) or len(words[indWord]) > len(letters):
            return 0
        index = 0
        wordScore = 0
        for l in words[indWord]:
            if l in letters:
                index += 1
                wordScore += score[alphabet.index(l)]
                del letters[letters.index(l)]
            else:
                break

        scoreWithWord = 0
        if index == len(words[indWord]):
            scoreWithWord = wordScore
            scoreWithWord += self.helper(words, indWord + 1, letters, score, alphabet)
        for j in range(index):
            letters.append(words[indWord][j])
        scoreWithOutWord = self.helper(words, indWord + 1, letters, score, alphabet)
        return max(scoreWithWord, scoreWithOutWord)
            



    