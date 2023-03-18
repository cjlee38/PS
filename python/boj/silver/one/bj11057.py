n = int(input())

nums = [1] * 10
for i in range(n - 1):
    for j in range(1, 10):
        nums[j] += nums[j-1]

print(sum(nums) % 10007)