if __name__ == '__main__':
    result = 0
    N = int(input())
    P = list(map(int, input().split()))
    P.sort()
    for i in range(N):
        for j in range(i+1):
            result += P[j]
    print(result)