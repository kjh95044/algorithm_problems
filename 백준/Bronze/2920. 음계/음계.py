sound_list = list(map(int, input().split()))
ascending = [i+1 for i in range(8)]
descending = sorted(ascending, reverse=True)

if sound_list == ascending:
  print("ascending")
elif sound_list == descending:
  print("descending")
else:
  print("mixed")