MOD = 1000000
code = input()
if int(code[0]) == 0:
    print(0)
    exit()

code = '0' + code
dp = [0] * (len(code))
dp[0] = 1
dp[1] = 1
for i in range(2, len(code)):
    x = int(code[i])
    if x != 0:
        dp[i] = (dp[i] + dp[i - 1]) % MOD
    x = int(code[i-1:i+1])
    if 10 <= x <= 26:
        dp[i] = (dp[i] + dp[i - 2]) % MOD
print(dp[-1])