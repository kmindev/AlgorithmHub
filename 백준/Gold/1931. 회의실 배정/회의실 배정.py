class Meeting:

  def __init__(self, start: int, end: int):
    self.start = start
    self.end = end


n = int(input())
meeting_list = []
for _ in range(n):
  start, end = map(int, input().split())
  meeting_list.append(Meeting(start, end))

meeting_list.sort(key=lambda meeting: (meeting.end, meeting.start))

current_meet_end_time = 0
result = 0

for meeting in meeting_list:
  if current_meet_end_time <= meeting.start:
    result += 1
    current_meet_end_time = meeting.end

print(result)
