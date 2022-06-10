def solution(n):
    x = n // 5
    for i in range(x, -1, -1):
        y = (N - (5 * i)) // 3 if i != 0 else N//3
        if ((5 * i) + (3 * y)) == N:
            return i + y
    return -1


if __name__ == '__main__':
    N = int(input())
    print(solution(N))