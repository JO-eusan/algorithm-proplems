def solution(n:int):
    numbers = sorted(str(n), reverse = True)
    new_number = ""
    for i in numbers:
        new_number += i
    return int(new_number)
    