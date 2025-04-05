import sys

n = int(input())
distances = list(map(int, input().split()))
prices = list(map(int, input().split()))

result = 0
min_value = sys.maxsize

for i in range(len(distances)):
  min_value = min(min_value, prices[i])
  result += (min_value * distances[i])

print(result)