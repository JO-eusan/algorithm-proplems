def solution(numbers:list):
    sum = 0;
    for n in range(0, 10):
        if not n in numbers:
            sum += n
    return sum