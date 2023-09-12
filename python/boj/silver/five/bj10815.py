import sys
input = sys.stdin.readline

n = int(input())
cards = list(map(int, input().strip().split()))
m = int(input())
numbers = list(map(int, input().strip().split()))

cards = set(cards)
print(" ".join(map(str, [1 if number in cards else 0 for number in numbers])))