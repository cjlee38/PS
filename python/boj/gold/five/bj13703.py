import sys
input = sys.stdin.readline

k, n = map(int, input().strip().split(" "))

'''
3cm에서, 10초 동안

1초일때 -> 0
2초일때 -> 0
3초일때 -> 1 = 1
4초일때 -> 1 + 4 = 5
5초일때 -> 1 + 5 + 10 = 16
6초일때 -> 1 + 6 + 15 + 20 = 42
 
'''