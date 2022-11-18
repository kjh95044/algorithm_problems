from typing import List


def max_price(nums: List[int], size: int):
    result = 0
    max_value = nums[-1]

    for i in reversed(range(size)):
        if nums[i] < max_value:
            result += max_value - nums[i]
        elif nums[i] >= max_value:
            max_value = nums[i]

    return result


if __name__ == '__main__':
    T = int(input())
    for test_case in range(1, T + 1):
        num = int(input())
        sale_price = list(map(int, (input().split())))
        print("#" + str(test_case), max_price(sale_price, len(sale_price)))