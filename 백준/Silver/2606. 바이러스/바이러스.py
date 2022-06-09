def dfs(_graph, start_node):
    visited = []
    need_visit = [start_node]
    while need_visit:
        node = need_visit.pop()
        if node not in visited:
            visited.append(node)
            need_visit.extend(_graph[node])

    return visited


if __name__ == '__main__':
    com_num = int(input())
    edge = int(input())
    graph = dict()

    for _ in range(edge):
        a, b = map(int, input().split())
        if a not in graph:
            graph[a] = [b]
        else:
            graph[a].append(b)
        if b not in graph:
            graph[b] = [a]
        else:
            graph[b].append(a)

    print(len(dfs(graph, 1)) -1 )