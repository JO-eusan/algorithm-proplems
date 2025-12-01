def solution(absolutes: list, signs: list):
    numbers_sum = 0;
    index = 0
    for s in signs:
        if s:
            numbers_sum += absolutes[index]
        else:
            numbers_sum -= absolutes[index]
        index += 1
    return numbers_sum