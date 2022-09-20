
import sys
input = sys.stdin.readline

N = int(input().strip())
numbers = sorted(list(map(int, input().strip().split(" "))), reverse=True)

def check(index, number):
    left = 0
    right = len(numbers) - 1
    while left <= right:
        if left == index:
            left += 1
            continue
        if right == index:
            right -= 1
            continue

        if number < numbers[left] + numbers[right]:
            left += 1
        elif number > numbers[left] + numbers[right]:
            right -= 1
        elif number == numbers[left] + numbers[right]:
            if left != right:
                return True
            return False
    return False


ans = 0
for idx, number in enumerate(numbers):
    if check(idx, number):
        ans += 1
print(ans)
