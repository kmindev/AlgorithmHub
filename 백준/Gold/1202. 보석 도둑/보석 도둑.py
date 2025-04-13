import sys
import heapq

input = sys.stdin.readline
n, k = map(int, input().split())
jewelries = [[*map(int, input().split())] for _ in range(n)]
bags = [int(input()) for _ in range(k)]
jewelries.sort() # 1. 무게 기준으로 오름차순 2.가격 기준 오름차순 
bags.sort() # 2. 무게 기준 오름차순

result = 0
tmp = []

for bag in bags: # 가방 무게가 낮은 것 부터
  while jewelries and jewelries[0][0] <= bag: # jewelries가 비어있지 않으면서 무게가 초과되지 않을 때
    heapq.heappush(tmp, -jewelries[0][1]) # 가격을 push, 우선순위 큐이므로 비싼 것 pop 하기 위해 음수로 넣어야 함  
    heapq.heappop(jewelries) # 처리한 jewelrie는 pop
  if tmp:
    result -= heapq.heappop(tmp) # 비싼 것을 pop 해서 누적합

print(result)