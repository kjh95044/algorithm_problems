if __name__ == '__main__':
    N = int(input())
    a_list = list(map(int, input().split()))
    b_list = list(map(int, input().split()))
    result = 0

    for _ in range(N):
        a = a_list.pop(a_list.index(min(a_list)))
        b = b_list.pop(b_list.index(max(b_list)))
        result += a * b
    print(result)