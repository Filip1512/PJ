# Filip Krzysztofik
# s16664
# https://www.codingame.com/multiplayer/codegolf/temperature-code-golf

import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

n = int(input())  # the number of temperatures to analyse
temps = input() # t: a temperature expressed as an integer ranging from -273 to 5526
result = ''

if len(temps) == 0:
    print("0")
else:
    temps_s = temps.split()
    result = temps_s[0]

    for temp in temps_s:
        if abs(int(temp)) < abs(int(result)):
            result = temp
        elif abs(int(temp)) == abs(int(result)):
            result = max(int(temp),int(result))

# Write an answer using print
# To debug: print("Debug messages...", file=sys.stderr, flush=True)

print(result)
