import re

def solution(id_list, report, k):
    # id_list가 key인 딕셔너리 초기화
    result_dic = dict.fromkeys(id_list, 0)
    
    # 중복 제거
    report = list(dict.fromkeys(report))
    
    report_dic = {}
    num = 0
    
    for rep in report:
        x,y = rep.split()
        report_dic[x + str(num)] = y
        num += 1
    
    for i in result_dic:
        count = 0
        report_list = []
        for key,value in report_dic.items():
            if value == i:
                count += 1
                report_list.append(re.sub(r'[0-9]+','',key))
        
        if count >= k:
            for person in report_list:
                result_dic[person] += 1
                
    return list(result_dic.values())
