import collections
if __name__ == '__main__':
    N, M = map(int, input().split())
    miro = [list(map(int, ' '.join(input().split()))) for _ in range(N)]

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    que = collections.deque([(0, 0)])
    while que :
        x, y = que.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if miro[nx][ny] == 1:
                    miro[nx][ny] = miro[x][y] + 1
                    que.append((nx, ny))

    print(miro[N-1][M-1])