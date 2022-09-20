import sys

input = sys.stdin.readline

brackets = input().strip()
ans = 0
stack = 0
is_razer = True
for b in brackets:
    print(b, ans, stack)
    if b == "(":
        stack += 1
        is_razer = True
    else:
        stack -= 1
        if is_razer:
            ans += stack
        else:
            ans += 1
        is_razer = False
print(ans)

'''
()(((()())(())()))(())
(((()(()()))(())()))(()())
'''
