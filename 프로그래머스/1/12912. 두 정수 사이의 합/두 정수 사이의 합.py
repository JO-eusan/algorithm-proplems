def solution(a: int, b: int):
    numbers = [x for x in range(min(a, b), max(a, b) + 1)]
    return sum(numbers)