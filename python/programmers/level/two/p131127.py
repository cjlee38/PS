from collections import Counter


def check(want, discount):
    for k, v in want.items():
        if not discount.get(k):
            return False
        if discount.get(k) < v:
            return False
    return True


def solution(want, number, discount):
    dct = {w: n for w, n in zip(want, number)}
    cur = dict(Counter(discount[:10]))
    ans = 1 if check(dct, cur) else 0
    for i in range(10, len(discount)):  # 둘째날부터
        before = discount[i - 10]
        cur[before] -= 1
        next = discount[i]
        if not cur.get(next):
            cur[next] = 0
        cur[next] += 1
        if check(dct, cur):
            ans += 1
    return ans


want = ["banana", "apple", "rice", "pork", "pot"]
number = [3, 2, 2, 2, 1]
discount = ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana",
            "apple", "banana"]

print(solution(want, number, discount))
