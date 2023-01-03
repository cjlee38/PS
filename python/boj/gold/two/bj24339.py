'''
root가 없는 경우가 있거나, 자신이 자신을 가리키는 self-loop가 있는 경우도 있음을 조심하세요.
'''

import sys
input = sys.stdin.readline


class Obj:

    def __init__(self, id, root_str):
        self.id = id
        self.is_root = root_str == 'ROOT'
        self.strong_refs = dict()
        self.weak_refs = dict()

    def connect(self, ref, ref_id, ref_type):
        is_weak = ref_type == '->'
        if is_weak:
            self.weak_refs[ref_id] = ref
        else:
            self.strong_refs[ref_id] = ref
    def remove(self, ref_id):
        if self.weak_refs.get(ref_id):
            self.weak_refs.pop(ref_id)
        if self.strong_refs.get(ref_id):
            self.strong_refs.pop(ref_id)

    def get_nexts(self, is_all):
        if is_all:
            return {**self.strong_refs, **self.weak_refs}
        return self.strong_refs

    def finalize(self, visited, is_all):
        if is_all == False: # delete weak
            self.weak_refs = {k: v for k, v in self.weak_refs.items() if v.id in visited}


objs = dict()
refs = dict()

o, e = map(int, input().strip().split())
for _ in range(o):
    o_id, is_root = input().strip().split()
    objs[o_id] = Obj(o_id, is_root)


def connect(src, dest, ref_id, ref_type):
    src_obj = objs[src]
    dest_obj = objs[dest]
    src_obj.connect(dest_obj, ref_id, ref_type)
    refs[ref_id] = src_obj # ??


def remove(ref_id):
    src_obj = refs.pop(ref_id)
    src_obj.remove(ref_id)


def mark(obj: Obj, is_all, visited):
    for ref_id, obj in obj.get_nexts(is_all).items():
        if obj.id in visited:
            continue
        visited.add(obj.id)
        mark(obj, is_all, visited)


def sweep(obj_id, is_all, visited):
    if not objs.get(obj_id): # already removed
        return
    if obj_id in visited: # referenced > 1
        objs[obj_id].finalize(visited, is_all)
        return
    obj = objs.pop(obj_id)
    nexts = dict(obj.get_nexts(is_all))
    del obj
    for ref_id, next_obj in nexts.items():
        del refs[ref_id]
        sweep(next_obj.id, is_all, visited)


def collect_garbage(g_type):
    is_all = g_type == 'm' # else only remain strong
    roots = [obj for obj in objs.values() if obj.is_root]
    visited = set([root.id for root in roots])
    for root in roots:
        mark(root, is_all, visited)
    all_ids = list(objs.keys())
    for id in all_ids:
        sweep(id, is_all, visited)

for _ in range(e):
    op = input().strip().split()
    if op[0] == 'M' or op[0] == 'm':
        collect_garbage(op[0])
        print(len(objs))
    elif op[0] == 'MADE':
        objs[op[1]] = Obj(op[1], op[2])
    elif op[0] == 'ADD':
        connect(op[2], op[4], op[1], op[3])
    elif op[0] == 'REMOVE':
        remove(op[1])

