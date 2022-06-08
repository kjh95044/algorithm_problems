def bfs(graph, start_node):
  visited = []
  need_visit = [start_node]
  for i in graph:
    graph[i].sort()

  while need_visit:
    node = need_visit.pop(0)
    if node not in visited:
      visited.append(node)
      need_visit.extend(graph[node])
  return visited

def dfs(graph, start_node):
  visited = []
  need_visit = [start_node]
  for i in graph:
    graph[i].sort(reverse=True)
  while need_visit:
    node = need_visit.pop()
    if node not in visited:
      visited.append(node)
      need_visit.extend(graph[node])
  return visited

if __name__ == '__main__':
  N,M,V = map(int,input().split())
  graph = dict()
  graph[V] = []
  for i in range(M):
    front_node, back_node = map(int, input().split())
    if front_node not in graph:
      graph[front_node] = [back_node]
    else:
      graph[front_node].append(back_node)
    if back_node not in graph:
      graph[back_node] = [front_node]
    else:
      graph[back_node].append(front_node)
  print(' '.join(map(str,dfs(graph,V))))
  print(' '.join(map(str,bfs(graph,V))))
