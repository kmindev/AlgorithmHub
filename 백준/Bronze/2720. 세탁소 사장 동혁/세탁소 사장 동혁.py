t = int(input())
coins = [25, 10, 5, 1]
m_list = []  # 거스름 돈

for _ in range(t):
  m_list.append(int(input()))

for m in (m_list):
  result = []
  for coin in (coins):
    result.append(m // coin)
    m %= coin

  print(f'{result[0]} {result[1]} {result[2]} {result[3]}')