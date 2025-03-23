n = int(input())
meeting_list = []
for _ in range(n):
  start, end = map(int, input().split())
  meeting_list.append([start, end])

meeting_list.sort(key=lambda meeting: (meeting[1], meeting[0]))

current_meet_end_time = 0
result = 0

for meeting in meeting_list:
  if current_meet_end_time <= meeting[0]:
    result += 1
    current_meet_end_time = meeting[1]

print(result)