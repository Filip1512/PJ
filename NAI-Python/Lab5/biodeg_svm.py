"""
 Autorzy
-Sebastian Browarczyk s17818
-Filip Krzysztofik s16664

"""
import numpy as np
from sklearn import svm
from sklearn.model_selection import train_test_split

"""
Ładowanie danych z pliku tekstowego 
"""


def converters(s):
    if s == b'RB':
        return 0
    if s == b'NRB':
        return 1


input_file = 'biodeg .csv'
data = np.loadtxt(input_file, delimiter=';', converters={-1: converters}, )
"""
Przypisanie kolumn do zmiennych
"""

X, y = data[:, :-1], data[:, -1]

"""
Podział danych na dane testowe oraz treningowe
"""

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.50)

"""
'Nakarmnienie' danamy treningowymi SVM
"""
svc = svm.SVC(kernel='linear', C=1, gamma=1)

svc.fit(X_train, y_train)

"""
Predykcja klasy na podstawie danych testowych
"""
Z = svc.predict(X_test)
"""
Porównanie predykcji z oczekiwanymwynikiem
"""
print(Z == y_test)
