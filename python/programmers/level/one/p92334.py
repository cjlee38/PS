
def solution(id_list, report, k):
    report_to = {id: set() for id in id_list}
    report_by = {id: set() for id in id_list}
    for r in report:
        f, t = r.split(" ")
        report_to[f].add(t)
        report_by[t].add(f)
    halted = {id for id, v in report_by.items() if len(v) >= k}
    return [len(s.intersection(halted)) for s in report_to.values()]

id_list = ["muzi", "frodo", "apeach", "neo"]
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
k = 2
print(solution(id_list, report, k))
