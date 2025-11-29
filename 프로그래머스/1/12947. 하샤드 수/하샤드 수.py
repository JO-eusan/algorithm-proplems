def solution(x:int):
    # 자릿수 합 구하기
    sum_number = 0
    for n in str(x):
        sum_number += int(n)

    if x % sum_number == 0:
        return True
    else:
        return False