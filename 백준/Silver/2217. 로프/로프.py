n = int(input())
ropes = []

for _ in range(n):
  ropes.append(int(input()))

ropes.sort(reverse=True)

result = ropes[0]
for i in range(1, len(ropes)):
    current = ropes[i] * (i + 1)
    if result < current:
      result = current

print(result)
    