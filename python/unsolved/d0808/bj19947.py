import sys

input = sys.stdin.readline

profits = [
    (5, 1.35),
    (3, 1.20),
    (1, 1.05)
]
ANS = -1


def run(money, year):
    global ANS

    if year == 0:
        ANS = max(ANS, money)
        return
    for idx, profit in enumerate(profits):
        if year >= profits[idx][0]:
            run(int(money * profits[idx][1]), year - profits[idx][0])


money, year = map(int, input().split(" "))

run(money, year)
print(ANS)
