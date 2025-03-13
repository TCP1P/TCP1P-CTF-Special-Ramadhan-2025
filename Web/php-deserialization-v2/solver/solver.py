import httpx
import asyncio
import os, base64

URL = "http://localhost:9432"

class BaseAPI:
    def __init__(self, url=URL) -> None:
        self.c = httpx.AsyncClient(base_url=url)

class API(BaseAPI):
    def solve(self, ops: str):
        return self.c.post("/", data={"ops": ops}, params={"ops": "foobar"})
    def payload(self):
        res = os.popen("php solver.php").read()
        return base64.b64decode(res).decode()

async def main():
    api = API()
    payload = api.payload()
    res = await api.solve(payload)
    print(res.text)

if __name__ == "__main__":
    asyncio.run(main())
