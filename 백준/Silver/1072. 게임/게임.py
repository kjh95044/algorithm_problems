if __name__ == '__main__':
    x, y = map(int, input().split())

    start = 1
    end = 1000000000
    result = 1000000000
    z = int((y*100) / x)
    if z >= 99:
        print(-1)
    else:
        while end-start >= 0:
            mid = int((start + end) / 2)
            result_rate = int((y + mid) * 100 / (x + mid))
            if result_rate > z:
                result = min(mid, result)
                end = mid - 1
            else:
                start = mid + 1
        print(result)