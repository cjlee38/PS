import sys

input = sys.stdin.readline


gears = [list(map(int, list(input().strip()))) for i in range(4)]

right = 2 ## 오른쪽을 가리키는 톱니바퀴 인덱스
left = 6

K = int(input())


def rotate(gears, index, wise, visited):
    if not 0 <= index < 4:
        return

    current = gears[index]
    is_left_rotate, is_right_rotate = False, False

    if index >= 1 and not visited[index-1]: # 왼쪽에 뭔가 있다면
        my_left = gears[index-1]
        if  my_left[right] != current[left]: # 만난 지점이 다르면
            is_left_rotate = True
    if index < 3 and not visited[index+1]: # 오른쪽에 뭔가 있다면
        my_right = gears[index+1]
        if my_right[left] != current[right]:
            is_right_rotate = True

    visited[index] = True
    # 1이면 시계방향, -1 이면 반시계방향
    if wise == 1:
        current.insert(0, current.pop(len(current) - 1)) # 오른쪽껄 빼서 왼쪽으로
    else:
        current.append(current.pop(0)) # 왼쪽걸 뺴서 오른쪽으로


    if is_left_rotate:
        rotate(gears, index - 1, wise * -1, visited)  # 반대방향으로 회전
    if is_right_rotate:
        rotate(gears, index + 1, wise * -1, visited)





for i in range(K):
    index, wise = map(int, input().strip().split(" "))
    visited = [False] * 4
    rotate(gears, index - 1, wise, visited)

ans = 0
ans += 1 if gears[0][0] == 1 else 0
ans += 2 if gears[1][0] == 1 else 0
ans += 4 if gears[2][0] == 1 else 0
ans += 8 if gears[3][0] == 1 else 0
print(ans)