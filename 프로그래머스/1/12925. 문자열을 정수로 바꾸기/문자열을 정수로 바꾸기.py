def solution(s):
    if s.startswith('+'):
        return int(s[1:])
    elif s.startswith('-'):
        return -int(s[1:])
    else:
        return int(s)