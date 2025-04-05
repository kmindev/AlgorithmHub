times = [300, 60, 10]

t = int(input())

results = []

if t % 10 != 0:
  print(-1)
else:
  for time in (times):
    results.append(t // time)
    t %= time
  print(f'{results[0]} {results[1]} {results[2]}')