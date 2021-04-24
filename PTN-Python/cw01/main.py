class Stack():
    def __init__(self, n):
        self.data = []

    def push(self, n):
        self.data.append(n)

    def pop(self):
        self.data.pop()

    def peak(self):
        peak = 0
        for i in self.data:
            if self.data[i] > peak:
                peak = self.data[i]
        return peak;

    def size(self):
        return self.data.__sizeof__()

if __name__ == "__main__":
    try:
        stack = Stack(5)
        print(stack.push(5))
        print(stack.push(2))
        print(stack.pop())
        print(stack.peak())
        print(stack.peak())
        print(len(stack))
        print(stack.size())
        print(stack.push(1))
        print(stack.push(1))
        print(stack.push(1))
        print(stack.push(1))
        print(stack.push(2))
    except MemoryError as e:
        print(e)
        exit(1)