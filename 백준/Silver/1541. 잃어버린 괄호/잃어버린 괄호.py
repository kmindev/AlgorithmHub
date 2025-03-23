def find_temp_sum(num_list: list):
  temp_sum = 0
  for num in num_list:
    temp_sum += num
  return temp_sum


minus_split = input().split('-')

result = 0

for i in range(len(minus_split)):
  plus_split = list(map(int, minus_split[i].split('+')))
  if i == 0:
    result = find_temp_sum(plus_split)
  else:
    result -= find_temp_sum(plus_split)

print(result)
