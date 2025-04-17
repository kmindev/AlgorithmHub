# 1보다 큰 양수의 경우 가장 큰 수를 기준으로 곱했을 때 커진다.
# 음수의 경우 가장 작은 수를 기준으로 정렬하여 곱했을 때 커진다.
# 1은 무조건 더해줘야 커진다.
# 0의 경우는 하나의 음수만 남았을 때 곱해줘야 커진다.

# 1. N 입력을 받는다
n = int(input())

# 2. N 만큼 입력을 받아서 양수 음수 나누어서 리스트에 넣는다. 1은 그냥 더한다.
plus_list = []
minus_list = []
result = 0
for _ in range(n):
  num = int(input())
  if num == 1:
    result += num
  elif num > 1:
    plus_list.append(num)
  else:
    minus_list.append(num)

# 3. 양수 리스트는 내림차순 정렬, 음수 리스트는 오름차순 정렬
plus_list.sort(reverse=True)
minus_list.sort()

# 4. 양수 리스트를 처리하여 result에 저장
for i in range(0, len(plus_list), 2):
  if i + 1 >= len(plus_list): # 숫자가 하나 남았을 때
    result += plus_list[i]
  else: # 숫자가 두 개일 때
    result += (plus_list[i] * plus_list[i+1])

# 5. 음수 리스트를 처리하여 result에 저장
for i in range(0, len(minus_list), 2):
  if i + 1 >= len(minus_list): # 숫자가 하나 남았을 때
    result += minus_list[i]
  else: # 숫자가 두 개일 때
    result += (minus_list[i] * minus_list[i+1])

print(result)