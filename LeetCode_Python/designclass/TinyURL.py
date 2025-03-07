import random
import string


class TinyURL:
    def __init__(self):
        self.url_to_code = {}
        self.code_to_url = {}
        self.base_url = "http://tinyurl.com/"

    def encode(self, longUrl: str) -> str:
        if longUrl in self.url_to_code:
            return self.base_url + self.url_to_code[longUrl]

        while True:
            code = "".join(random.choices(string.ascii_letters + string.digits, k=6))
            if code not in self.code_to_url:
                break
        self.url_to_code[longUrl] = code
        self.code_to_url[code] = longUrl
        return self.base_url + code

    def decode(self, shortUrl: str) -> str:
        code = shortUrl.split("/")[-1]
        return self.code_to_url[code]


if __name__ == "__main__":
    solution = TinyURL()

    longUrl1 = "https://leetcode.com/problems/design-tinyurl"
    encoded1 = solution.encode(longUrl1)
    decoded1 = solution.decode(encoded1)
    expected1 = longUrl1
    print("Expected Output:", expected1)
    print("Actual Output:", decoded1)

    longUrl2 = "https://example.com/very/long/url/for/testing"
    encoded2 = solution.encode(longUrl2)
    decoded2 = solution.decode(encoded2)
    expected2 = longUrl2
    print("Expected Output:", expected2)
    print("Actual Output:", decoded2)
