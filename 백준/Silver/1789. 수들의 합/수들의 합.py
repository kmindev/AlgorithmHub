s = int(input())

result = 0
sum = 0
i = 1

while True:
  sum += i
  if sum > s:
    break
  result += 1
  i += 1

print(result)