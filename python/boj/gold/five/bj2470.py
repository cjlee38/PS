import sys

input = sys.stdin.readline

N = int(input())
liquids = list(map(int, input().strip().split(" ")))

liquids.sort()

if liquids[0] >= 0:
    print(liquids[0], liquids[1])
elif liquids[N - 1] <= 0:
    print(liquids[N - 2], liquids[N - 1])
else:
    left_idx = 0
    right_idx = N - 1
    min_val = 9876543210
    left_val = right_val = 0
    while left_idx < right_idx:
        cur_val = liquids[left_idx] + liquids[right_idx]
        if abs(cur_val) < min_val:
            min_val = abs(cur_val)
            left_val = liquids[left_idx]
            right_val = liquids[right_idx]
        if cur_val < 0:
            left_idx += 1
        elif cur_val > 0:
            right_idx -= 1
        else: # zero
            break
    print(left_val, right_val)


'''
4
-5 -3 -1 1000000

5
-99 -2 -1 4 98


'''