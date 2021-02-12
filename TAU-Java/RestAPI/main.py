import requests
import json

locale_cases = "Europe"
apiKey = "RGAPI-f2659fcf-4c21-4c72-880a-73a6079c0250"
url = "https://europe.api.riotgames.com/lor/status/v1/platform-data?api_key=" + apiKey
head = {'content-type': 'application/json'}
response = requests.request("GET", url)
a = json.loads(response.text)

# -----------------------------------
# sprawdzanie kluczy
expected = ['id', 'name', 'locales', 'maintenances', 'incidents']
current = []

for key, value in a.items():
    for k, v in value.items():
        if k in expected:
            current.append(k)
assert expected == current

# -----------------------------------
# sprawdzanie wartosci
for key, value in a.items():
    for k in value.items():
        if k == 'name':
            name = v

assert locale_cases == v
assert locale_cases == "Europe"

# -----------------------------------
# sprawdzanie odpowiedzi
assert response.status_code == 200

# -----------------------------------
# sprawdzanie niepoprawnego zapytania
url = "https://europe.api.riotgames.com/lor/status/v1/platform?api_key=" + apiKey
response = requests.request("GET", url)
assert response.status_code == 403