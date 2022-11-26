from collections import defaultdict

def divisor_map(n):
    div_map = defaultdict(int)
    div_map[1] = 1

    for i in range(2, n + 1):
        div_map[i] += 2
        for j in range(2, int(i ** 0.5) + 1):
            if i % j == 0:
                if i / j == j:
                    div_map[i] += 1
                else:
                    div_map[i] += 2
    return div_map


def solution(number, limit, power):
    answer = 0
    div_map = divisor_map(number)

    for i in range(1, number + 1):
        if div_map[i] > limit:
            answer += power
        else:
            answer += div_map[i]

    return answer
