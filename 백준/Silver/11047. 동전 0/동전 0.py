if __name__ == '__main__':
    count = 0
    N, K = map(int, input().split())
    coin_list = []
    for _ in range(N):
        coin_list.append(int(input()))
    coin_list = [x for x in coin_list if x <= K]
    coin_list.sort(reverse=True)
    for coin in coin_list:
        count += K // coin
        K = K % coin
    print(count)