def solution(nums):
    answer = 0
    choose_max = len(nums)/2
    no_dup = set(nums)
    if len(no_dup) > choose_max:
        answer = choose_max
    else:
        answer = len(no_dup)

    return int(answer)