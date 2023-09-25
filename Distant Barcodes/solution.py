class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        cnt = collections.Counter(barcodes)
        # print(type(cnt))
        # print(cnt)
        #print(cnt.most_common())
        index, n = 0, len(barcodes)
        ans = [0] * n
        for code, freq in cnt.most_common():
            for i in range(freq):
                if index >= n:
                    index = 1
                ans[index] = code
                index += 2
        return ans