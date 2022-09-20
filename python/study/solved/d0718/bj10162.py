import sys

input = sys.stdin.readline

T = int(input())

buttons = {
    360: 0,
    60: 0,
    10: 0
}

if T % 10 != 0:
    print(-1)
else:
    for time in buttons.keys():
        if time <= T:
            count = T // time
            buttons[time] = count
            T -= count * time
    l = list(map(str, buttons.values()))
    print(" ".join(l))

