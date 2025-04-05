a, b = map(int, input().split())

result = 1
while b > a:
  if b % 2 == 0:
    b //= 2
  else:
    b = b // 10 if b % 10 == 1 else -1
  result += 1

if a == b:
  print(result)
else:
 print(-1)