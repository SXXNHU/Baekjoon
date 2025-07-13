import sys

def min_subarray_length(N, S, nums):
    start, end = 0, 0
    total = 0
    min_len = float('inf')

    while True:
        if total >= S:
            min_len = min(min_len, end - start)
            total -= nums[start]
            start += 1
        elif end == N:
            break
        else:
            total += nums[end]
            end += 1

    return 0 if min_len == float('inf') else min_len


N, S = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))

print(min_subarray_length(N, S, nums))
