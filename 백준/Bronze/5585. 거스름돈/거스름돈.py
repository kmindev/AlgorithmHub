coins = [500, 100, 50, 10, 5, 1]

money = 1000 - int(input()) # 돌려받을 돈

result = 0

for coin in coins:
  result += (money // coin)
  money %= coin

print(result)
