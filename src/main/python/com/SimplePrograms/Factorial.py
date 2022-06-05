print("- Number?")
number = int(input())
print("- " + str(number))
print(str(number) + "! = ", end="")

result = 1

while number > 0:
    result *= number
    number -= 1

print(str(result))