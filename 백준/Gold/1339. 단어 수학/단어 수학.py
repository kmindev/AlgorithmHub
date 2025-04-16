n = int(input())

alphabet_dict = {}

for _ in range(n):
  alphabets= list(input())
  for seq in range(0, len(alphabets)):
    alphabet = alphabets[seq]
    if alphabet in alphabet_dict: # 있으면 들어 있는 수랑 더해준다.
      alphabet_dict[alphabet] += 10 ** (len(alphabets) - 1 - seq) 
    else: # 없으면 새로 넣어준다
      alphabet_dict[alphabet] = 10 ** (len(alphabets) - 1 - seq) 
      
# 내림차순 정렬
alphbat_dict = dict(sorted(alphabet_dict.items(), key = lambda x: x[1], reverse = True))

result = 0
max_num = 9
for alphabet in(alphbat_dict):
  result += alphbat_dict[alphabet] * max_num
  max_num -= 1

print(result)