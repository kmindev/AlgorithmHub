import heapq

n = int(input())
cards = []
for _ in range(n):
  heapq.heappush(cards, int(input()))

result = 0

while len(cards) > 1:
  a = heapq.heappop(cards)
  b = heapq.heappop(cards)
  sum = a + b
  result += sum
  heapq.heappush(cards, sum)

print(result)