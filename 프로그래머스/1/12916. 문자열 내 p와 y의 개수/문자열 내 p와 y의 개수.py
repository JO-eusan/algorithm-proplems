def solution(s: str):
    counter_p = s.count('p') + s.count('P')
    counter_y = s.count('y') + s.count('Y')
    
    if counter_p == 0 and counter_y == 0:
        return True
    elif counter_p == counter_y:
        return True
    else:
        return False