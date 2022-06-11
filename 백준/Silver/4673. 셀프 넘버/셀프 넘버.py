numbers = set()
generated_num = set()


for i in range(1,10001):
  numbers.add(i)
  for j in str(i):
    i += int(j)
  generated_num.add(i)

result = sorted(numbers - generated_num)
for k in result:
  print(k)