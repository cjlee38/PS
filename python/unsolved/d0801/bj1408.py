import sys
input = sys.stdin.readline

start = input().strip()
end = input().strip()

from datetime import datetime, timedelta

start_time = datetime.strptime(start, "%H:%M:%S")
end_time = datetime.strptime(end, "%H:%M:%S")


if (end_time - start_time).days < 0:
    delta = str((end_time - start_time) + timedelta(days = 1))
else:
    delta = str(end_time - start_time)
if len(str(delta)) == 7:
    delta = "0" + delta
print(delta)