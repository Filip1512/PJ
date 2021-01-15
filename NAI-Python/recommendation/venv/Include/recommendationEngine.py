# Autorzy: Sebastian Browarczyk, Filip Krzysztofik
# Silnik rekomendacji filmow


import json

import numpy as np

def euclidean_score(dataset, first_user, second_user):
    """Metoda służy do wyliczania podbieństwa pomiędzy użytkownikami
    Parametry wejściowe:
        dataset (dict): Zaimportowane dane użytkowników
        user1 (str): Nazwa pierwszego użytkownika
        user2 (str): Nazwa drugiego użytkownika
    Parametry zwracane:
        float: Stopień podobieństwa
    """
    if first_user not in dataset:
        raise TypeError('Nie można znaleść użytkownika :' + first_user)

    if second_user not in dataset:
        raise TypeError('Nie można znaleść użytkownika :' + second_user)

    common_movies = {}

    for item in dataset[first_user]:
        if item in dataset[second_user]:
            common_movies[item] = 1

    if len(common_movies) == 0:
        return 0

    squared_diff = []

    for item in dataset[first_user]:
        if item in dataset[second_user]:
            squared_diff.append(np.square(dataset[first_user][item] - dataset[second_user][item]))

    return 1 / (1 + np.sqrt(np.sum(squared_diff)))


def pearson_score(dataset, first_user, second_user):
    """Metoda służy do wyliczenie podonieństwa między użytkownika
    Parametry wejściowe:
        dataset (dict): zaimportowane dane użytkowników
        first_user (str): Nazwa pierwszego użytkownik
        second_user (str): Nazwa drugiego użytkownik
    Parametry zwracane:
            float: Stopień podobieństwa
    """
    if first_user not in dataset:
        raise TypeError('Nie można znaleść użytkownika :' + first_user)

    if second_user not in dataset:
        raise TypeError('Nie można znaleść użytkownika :' + second_user)

    common_movies = {}

    for item in dataset[first_user]:
        if item in dataset[second_user]:
            common_movies[item] = 1

    num_ratings = len(common_movies)

    if num_ratings == 0:
        return 0

    first_user_sum = np.sum([dataset[first_user][item] for item in common_movies])
    second_user_sum = np.sum([dataset[second_user][item] for item in common_movies])

    first_user_squared_sum = np.sum([np.square(dataset[first_user][item]) for item in common_movies])
    second_user_squared_sum = np.sum([np.square(dataset[second_user][item]) for item in common_movies])

    sum_of_products = np.sum([dataset[first_user][item] * dataset[second_user][item] for item in common_movies])

    Sxy = sum_of_products - (first_user_sum * second_user_sum / num_ratings)
    Sxx = first_user_squared_sum - np.square(first_user_sum) / num_ratings
    Syy = second_user_squared_sum - np.square(second_user_sum) / num_ratings

    if Sxx * Syy == 0:
        return 0

    return Sxy / np.sqrt(Sxx * Syy)


def print_result(user_name, user_dict):
    """Metoda służy do wyświtlania najlepiej i najgorzej ocenionych filmów uzytkownika
    Parametry wejściowe:
        user_name (str): Nazwa użytkownika
    Parametry zwracane:
        array[int]: Lista wyświetlonych filmów
    """
    print('Wybrano ' + user_name)
    movie_without_duplicates = {}
    for key, value in user_dict.items():
        if key not in data[user].keys():
            movie_without_duplicates[key] = value
    sorted_dict = dict(sorted(movie_without_duplicates.items(), key=lambda element: element[1], reverse=True))
    best7 = dict(list(sorted_dict.items())[:7])
    worse7 = dict(list(sorted_dict.items())[-7:])
    counter = 0
    movie_all = []

    print('\nPolecane filmy:')
    for itm in best7:
        print('[' + str(counter) + '] ' + itm + ' ' + str(best7[itm]))
        counter += 1
        movie_all.append(itm)

    print('\nNie polecane filmy:')
    for itm in worse7:
        print('[' + str(counter) + '] ' + itm + ' ' + str(worse7[itm]))
        counter += 1
        movie_all.append(itm)
    return movie_all


def select_user():
    """Metoda służy do wyboru użytkownika z listy
    Parametry zwracany:
        str:  Nazwa wybranego użytkownik
    """
    counter = 0
    user_list = []
    print('\nWybierz osobe:')
    for item in data:
        print('[' + str(counter) + '] ' + item)
        user_list.append(item)
        counter += 1
    return user_list[int(input())]


def select_score_type():
    """Metoda do wyświetlania możliwysz algorytmów i wyboru jednego z nich
    Parametry zwracany:
        str: Nazwa wybranego algorytmu
    """
    counter = 0
    score_type_dict = ['Pearson', 'Euclidean']
    score_type_list = []
    print('Wybierz algorytm')
    for item in score_type_dict:
        print('[' + str(counter) + '] ' + item)
        score_type_list.append(item)
        counter += 1
    return score_type_list[int(input())]


if __name__ == '__main__':
    json_file = 'movies.json'
    with open(json_file, 'r', encoding='utf-8') as file:
        data = json.loads(file.read())

    user = select_user()
    score_type = select_score_type()
    show_description = True
    score_array = []

    for item in data:
        if item != user:
            if score_type == 'Euclidean':
                score_array.append({'score': euclidean_score(data, user, item), 'user': item})
            else:
                score_array.append({'score': pearson_score(data, user, item), 'user': item})

    max_score = max(score_array, key=lambda x: x['score'])

    user_movies = data[max_score['user']]
    movie_all_list = print_result(max_score['user'], user_movies)
