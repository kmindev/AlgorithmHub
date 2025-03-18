n = int(input())
p_list = list(map(int, input().split()))
p_list.sort()

sum = 0
result = 0

for s in p_list:
  sum += s
  result += sum
  
print(result)