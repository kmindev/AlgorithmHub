s = input()

before = s[0:1]
result = 0 
for i in range(len(s) - 1):
  if s[i] != s[i+1]:
    result += 1
print((result + 1) // 2)