import math


def convert(n, k):
    s = ""
    while n != 0:
        s += str(n % k)
        n = n // k
    return s[::-1]




def is_prime(t):
    t = int(t)
    if t <= 1:
        return False
    for i in range(2, int(math.sqrt(t)) + 1):
        if t % i == 0:
            return False
    return True



def solution(n, k):
    s = convert(n, k)
    candidates = s.split("0")
    cnt = 0
    for candidate in candidates:
        if candidate != '' and is_prime(candidate):
            cnt += 1
    return cnt

print(solution(437674, 3))
print(solution(110011, 10))
