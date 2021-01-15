# klasyfikacja
# autorzy: Sebastian Browarczyk, Filip Krzysztofik

import numpy as np
import matplotlib.pyplot as plt
from sklearn import svm
from mlxtend.plotting import plot_decision_regions
from sklearn.model_selection import train_test_split

input_file = 'data_banknote_authentication.txt'
data = np.loadtxt(input_file, delimiter=',')
X, y = data[:, :-1], data[:, -1]

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.20)

svc = svm.SVC(kernel='linear', C=1, gamma=1)
svc.fit(X_train, y_train)
svc.predict(X_test)

value = 4
width = 0.75

# Plot Decision Region using mlxtend's awesome plotting function
plot_decision_regions(X=X,
                      y=y.astype(np.int),
                      filler_feature_ranges={2: value, 3: value},
                      filler_feature_values={2: width, 3: value},
                      clf=svc,
                      legend=2)

# Update plot object with X/Y axis labels and Figure Title
# plt.xlabel(X.columns[0], size=14)
# plt.ylabel(X.columns[1], size=14)
plt.title('SVM Decision Region Boundary', size=16)
plt.show()